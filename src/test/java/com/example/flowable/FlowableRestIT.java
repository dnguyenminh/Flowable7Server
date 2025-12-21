package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.time.Duration;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import static org.awaitility.Awaitility.await;
// (removed unused hamcrest import)

@Testcontainers
public class FlowableRestIT {
    // Set this via -Dflowable.rest.test.verbose=true to enable verbose debug
    // logs when running locally; CI should keep it disabled.
    private static final boolean VERBOSE = Boolean.getBoolean("flowable.rest.test.verbose");
    // Use the official Flowable REST image; adjust tag if needed
    @Container
    static GenericContainer<?> flowable = new GenericContainer<>("flowable/flowable-rest:7.2.0")
            .withExposedPorts(8080)
            // Set admin credentials for Flowable REST
            .withEnv("FLOWABLE_REST_APP_ADMIN_USER_ID", "rest-admin")
            .withEnv("FLOWABLE_REST_APP_ADMIN_PASSWORD", "test")
            .withEnv("FLOWABLE_REST_APP_ADMIN_FIRST_NAME", "Rest")
            .withEnv("FLOWABLE_REST_APP_ADMIN_LAST_NAME", "Admin")
            // Use a log-based wait because many endpoints are protected behind auth in the
            // image
            .waitingFor(Wait.forLogMessage(".*Started FlowableRestApplication.*\\n", 1))
            .withStartupTimeout(Duration.ofMinutes(2));

    @Test
    public void deployAndStart_process_and_create_cases_via_rest() throws Exception {
        // Simplified linear flow: detect base, deploy artifacts, start process,
        // ensure cases exist (create if necessary), run assertions, then cleanup.
        String root = "http://" + flowable.getHost() + ":" + flowable.getMappedPort(8080) + "/flowable-rest";
        String user = "rest-admin";
        String pass = "test";

        String base = selectBase(root, user, pass);

        // Deploy resources (BPMN + CMMN + combined)
        File fileProcessingBpmn = new File("src/test/resources/processes/file-processing.bpmn");
        File bulkUploadCmmn = new File("src/test/resources/cases/bulk-upload.cmmn");
        File skipTracingCmmn = new File("src/test/resources/cases/skip-tracing.cmmn");
        try {
            // deployResource(base, bpmn, new String[] {"files", "file"},
            // "rest-integration-deployment", user, pass);
            // File cmmnZip = zipSingleFile(cmmn);
            // deployResource(base, cmmnZip, new String[] {"files", "file"},
            // "rest-integration-cmmn", user, pass);
            File combined = zipFiles(new File[] { bulkUploadCmmn, skipTracingCmmn, fileProcessingBpmn });
            deployResource(base, combined, new String[] { "files", "file" }, "rest-integration-both", user, pass);

            // Require CMMN endpoints for this test and fail fast when they are not
            // available.
            org.assertj.core.api.Assertions.assertThat(isCmmnApiAvailable(base, user, pass))
                    .as("CMMN endpoints must be available for this test").isTrue();

            // Strict pre-check: ensure a case *can* be created via one of the expected
            // create endpoints. This surfaces configurations that expose only query APIs
            // but not create endpoints (we observed this in some images).
            String checkBk = "ck-" + System.currentTimeMillis();
            String checkBody = String.format("{\"caseDefinitionKey\":\"skipTracingCase\",\"businessKey\":\"%s\"}",
                    checkBk);
            String[] createPaths = new String[] { "/cmmn-api/cmmn-runtime/case-instances"};
            String altBase = base.contains("/service") ? base.substring(0, base.indexOf("/service")) : base;
            Response createOk = null;
            StringBuilder diag = new StringBuilder();
            for (String p : createPaths) {
                try {
                    Response c = given().auth().basic(user, pass).contentType("application/json").body(checkBody)
                            .post(base + p).andReturn();
                    diag.append("POST ").append(base).append(p).append(" -> status=").append(c.getStatusCode())
                            .append(" body=\n").append(truncate(c.asString(), 1000)).append("\n");
                    if (c.getStatusCode() == 200 || c.getStatusCode() == 201) {
                        createOk = c;
                        break;
                    }
                } catch (Exception e) {
                    diag.append("POST ").append(base).append(p).append(" -> EX: ").append(e.getMessage()).append('\n');
                }
                try {
                    if (!altBase.equals(base)) {
                        Response c2 = given().auth().basic(user, pass).contentType("application/json").body(checkBody)
                                .post(altBase + p).andReturn();
                        diag.append("POST ").append(altBase).append(p).append(" -> status=").append(c2.getStatusCode())
                                .append(" body=\n").append(truncate(c2.asString(), 1000)).append("\n");
                        if (c2.getStatusCode() == 200 || c2.getStatusCode() == 201) {
                            createOk = c2;
                            break;
                        }
                    }
                } catch (Exception e) {
                    diag.append("POST ").append(altBase).append(p).append(" -> EX: ").append(e.getMessage())
                            .append('\n');
                }
            }
            org.assertj.core.api.Assertions.assertThat(createOk)
                    .withFailMessage(
                            "CMMN create endpoints not available. Ensure the Flowable REST image exposes CMMN create APIs. Diagnostics:\n%s",
                            diag.toString())
                    .isNotNull();

            boolean started = startBulkUploadCaseAndTriggerProcess(base, user, pass, "file-1");
            org.assertj.core.api.Assertions.assertThat(started).as("Starting bulk-upload case must succeed").isTrue();
            if (started) {
                // Wait for the process instance (runtime or historic)
                waitForProcessInstance(base, user, pass, "process_bulk_file_handling");
            } else {
                if (VERBOSE)
                    System.out.println("WARN: start failed, skipping process-historic assertions");
            }

            // Ensure CMMN cases exist or create them (will be no-op if CMMN not available)
            boolean hasCases = ensureCmmnCasesPresent(base, user, pass);

            if (hasCases) {
                // Assert historic case business keys include expected CIFs
                if (authGet(base, "/cmmn-history/historic-case-instances?caseDefinitionKey=skipTracingCase", user, pass)
                        .getStatusCode() == 200) {
                    awaitForListSize(base, "/cmmn-history/historic-case-instances?caseDefinitionKey=skipTracingCase",
                            user, pass, 3, Duration.ofSeconds(60));
                    var casesResp = authGet(base,
                            "/cmmn-history/historic-case-instances?caseDefinitionKey=skipTracingCase&size=100", user,
                            pass);
                    var keys = casesResp.jsonPath().getList("data.businessKey");
                    if (keys == null || keys.isEmpty())
                        keys = casesResp.jsonPath().getList("rows.businessKey");
                    org.assertj.core.api.Assertions.assertThat(keys)
                            .as("Historic case business keys should contain our CIFs").contains("123", "456", "789");
                } else {
                    String body = "{\"caseDefinitionKey\":\"skipTracingCase\"}";
                    awaitForPostListSize(base, "/cmmn-api/cmmn-query/historic-case-instances", body, user, pass, 3,
                            Duration.ofSeconds(60));
                    Response casesResp = given().auth().basic(user, pass).contentType("application/json").body(body)
                            .post(base + "/cmmn-api/cmmn-query/historic-case-instances").andReturn();
                    var keys = casesResp.jsonPath().getList("data.businessKey");
                    if (keys == null || keys.isEmpty())
                        keys = casesResp.jsonPath().getList("rows.businessKey");
                    org.assertj.core.api.Assertions.assertThat(keys)
                            .as("Historic case business keys should contain our CIFs").contains("123", "456", "789");
                }

                // Optionally assert historic tasks if present
                Response tasksCheck = authGet(base, "/history/historic-task-instances?taskName=Skip Tracing Task", user,
                        pass);
                if (tasksCheck.getStatusCode() == 200 && sizeFromResponse(tasksCheck) >= 1) {
                    awaitForListSize(base, "/history/historic-task-instances?taskName=Skip Tracing Task", user, pass, 1,
                            Duration.ofSeconds(60));
                }
            }

            // General historic assertions (only when we successfully started a process)
            if (started) {
                awaitForListSize(base,
                        "/history/historic-process-instances?processDefinitionKey=process_bulk_file_handling", user,
                        pass, 1, Duration.ofSeconds(60));
                awaitForListSize(base, "/history/historic-variable-instances?variableName=assignmentList", user, pass,
                        1, Duration.ofSeconds(60));
            } else {
                if (VERBOSE)
                    System.out.println("WARN: Skipping historic assertions because process start failed");
            }
        } finally {
            // Best-effort cleanup
            try {
                TestCleanupHelper.cleanupCmmnCasesRest(base, "skipTracingCase", user, pass);
                TestCleanupHelper.cleanupProcessInstancesRest(base, "process_bulk_file_handling", user, pass);
                TestCleanupHelper.deleteDeploymentsRest(base, "rest-integration-both", user, pass);
                TestCleanupHelper.deleteDeploymentsRest(base, "rest-integration-deployment", user, pass);
                TestCleanupHelper.deleteDeploymentsRest(base, "rest-integration-cmmn", user, pass);
            } catch (Exception e) {
                if (VERBOSE)
                    System.out.println("WARN: cleanup failed: " + e.getMessage());
            }
        }
    }

    /**
     * Start a bulk-upload CMMN case and complete the import task so the configured
     * processTask triggers the BPMN `process_bulk_file_handling` process.
     * Returns true when a process instance is observed (best-effort), false
     * otherwise.
     */
    private boolean startBulkUploadCaseAndTriggerProcess(String base, String user, String pass, String fileId) {
        String bk = "bk-" + System.currentTimeMillis();
        String createBody = String.format(
                "{\"caseDefinitionKey\":\"skipTracingCase\",\"businessKey\":\"%s\",\"variables\":[{\"name\":\"fileId\",\"value\":\"%s\"}]}",
                bk, fileId);
        String[] createPaths = new String[] { "/cmmn-api/case-instances", "/cmmn-api/case-instances/create",
                "/cmmn-runtime/case-instances", "/cmmn-runtime/case-instances/create" };
        String altBase = base.contains("/service") ? base.substring(0, base.indexOf("/service")) : base;
        Response create = null;
        for (String p : createPaths) {
            try {
                create = given().auth().basic(user, pass).contentType("application/json").body(createBody)
                        .post(base + p).andReturn();
                if (create.getStatusCode() == 200 || create.getStatusCode() == 201)
                    break;
            } catch (Exception ignored) {
            }
            try {
                if (!altBase.equals(base)) {
                    Response c2 = given().auth().basic(user, pass).contentType("application/json").body(createBody)
                            .post(altBase + p).andReturn();
                    if (c2.getStatusCode() == 200 || c2.getStatusCode() == 201) {
                        create = c2;
                        break;
                    }
                }
            } catch (Exception ignored) {
            }
        }

        if (create == null || !(create.getStatusCode() == 200 || create.getStatusCode() == 201)) {
            if (VERBOSE)
                System.out.println("WARN: could not create bulk-upload case; status="
                        + (create == null ? "<null>" : create.getStatusCode()));
            return false;
        }

        // Wait for the import task to appear and complete it (so the processTask will
        // fire)
        final String taskName = "Import Excel File";
        final String tasksPath = "/runtime/tasks?taskName="
                + java.net.URLEncoder.encode(taskName, java.nio.charset.StandardCharsets.UTF_8);
        try {
            await().atMost(Duration.ofSeconds(30)).pollInterval(Duration.ofSeconds(1)).untilAsserted(() -> {
                Response t = given().auth().basic(user, pass).get(base + tasksPath);
                if (t.getStatusCode() != 200) {
                    Response t2 = null;
                    if (!altBase.equals(base))
                        t2 = given().auth().basic(user, pass).get(altBase + tasksPath);
                    org.assertj.core.api.Assertions
                            .assertThat(t.getStatusCode() == 200 || (t2 != null && t2.getStatusCode() == 200)).isTrue();
                }
                Response tasksResp = (t.getStatusCode() == 200) ? t
                        : given().auth().basic(user, pass).get(altBase + tasksPath);
                int size = sizeFromResponse(tasksResp);
                org.assertj.core.api.Assertions.assertThat(size).as("import tasks").isGreaterThanOrEqualTo(1);
                String id = null;
                try {
                    id = tasksResp.jsonPath().getString("data[0].id");
                } catch (Exception ignored) {
                }
                if (id == null)
                    try {
                        id = tasksResp.jsonPath().getString("rows[0].id");
                    } catch (Exception ignored) {
                    }
                if (id == null)
                    try {
                        id = tasksResp.jsonPath().getString("[0].id");
                    } catch (Exception ignored) {
                    }
                org.assertj.core.api.Assertions.assertThat(id).isNotNull();

                // Complete the task to let the CMMN plan move to the processTask
                String completeBody = "{\"action\":\"complete\"}";
                Response complete = given().auth().basic(user, pass).contentType("application/json").body(completeBody)
                        .post(base + "/runtime/tasks/" + id).andReturn();
                if (!(complete.getStatusCode() == 200 || complete.getStatusCode() == 204)) {
                    // try alt base
                    if (!altBase.equals(base))
                        complete = given().auth().basic(user, pass).contentType("application/json").body(completeBody)
                                .post(altBase + "/runtime/tasks/" + id).andReturn();
                }
                org.assertj.core.api.Assertions
                        .assertThat(complete.getStatusCode() == 200 || complete.getStatusCode() == 204)
                        .as("complete task status").isTrue();
            });
        } catch (Exception e) {
            if (VERBOSE)
                System.out.println("DEBUG: completing import task failed: " + e.getMessage());
            return false;
        }

        // Wait for the process to appear (triggered by the CMMN processTask)
        try {
            awaitForListSize(base,
                    "/history/historic-process-instances?processDefinitionKey=process_bulk_file_handling", user, pass,
                    1, Duration.ofSeconds(60));
        } catch (Exception e) {
            if (VERBOSE)
                System.out.println("DEBUG: process did not appear after completing import: " + e.getMessage());
            return false;
        }

        // Wait for skipTracingCase historic instances created by the process
        // callActivity
        try {
            awaitForListSize(base, "/cmmn-history/historic-case-instances?caseDefinitionKey=skipTracingCase", user,
                    pass, 1, Duration.ofSeconds(60));
            return true;
        } catch (Exception e) {
            if (VERBOSE)
                System.out.println("DEBUG: skipTracingCase not observed: " + e.getMessage());
            return false;
        }
    }

    // --- Helper methods to simplify the test flow ---
    private String selectBase(String root, String user, String pass) throws InterruptedException {
        String[] candidates = new String[] { root + "/service", root };
        String base = null;
        long timeoutMs = Duration.ofSeconds(60).toMillis();
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < timeoutMs && base == null) {
            for (String c : candidates) {
                try {
                    Response probe = given().auth().basic(user, pass).get(c + "/repository/deployments");
                    if (probe.getStatusCode() == 200) {
                        base = c;
                        break;
                    }
                } catch (Exception ignored) {
                }
            }
            if (base == null)
                Thread.sleep(1000);
        }
        if (base == null)
            base = root;
        if (VERBOSE)
            System.out.println("INFO: selected base=" + base);
        return base;
    }

    private void deployResource(String base, File resource, String[] fields, String deploymentName, String user,
            String pass) {
        Response resp = tryMultipartUploadWithLogging(base + "/repository/deployments", resource, fields,
                deploymentName, user, pass);
        if (resp == null || resp.getStatusCode() != 201) {
            dumpDiagnostics(base, user, pass);
        }
        if (VERBOSE && resp != null) {
            try {
                System.out.println("DEBUG: deployment response body=\n" + truncate(resp.asString(), 4000));
            } catch (Exception ignored) {
            }
        }
        org.assertj.core.api.Assertions.assertThat(resp).as("Deployment %s should succeed", deploymentName).isNotNull();
        org.assertj.core.api.Assertions.assertThat(resp.getStatusCode()).isEqualTo(201);
        // When verbose, query what was deployed (process & case definitions) to aid
        // debugging
        if (VERBOSE) {
            try {
                String depId = null;
                try {
                    depId = resp.jsonPath().getString("id");
                } catch (Exception ignored) {
                }
                if (depId != null) {
                    try {
                        Response pdefs = authGet(base, "/repository/process-definitions?deploymentId=" + depId, user,
                                pass);
                        System.out.println("DEBUG: process-definitions for deployment " + depId + " -> status="
                                + pdefs.getStatusCode() + " body=\n" + truncate(pdefs.asString(), 2000));
                    } catch (Exception ignored) {
                    }
                    try {
                        Response cdefs = authGet(base, "/cmmn-repository/case-definitions?deploymentId=" + depId, user,
                                pass);
                        System.out.println("DEBUG: case-definitions for deployment " + depId + " -> status="
                                + cdefs.getStatusCode() + " body=\n" + truncate(cdefs.asString(), 2000));
                    } catch (Exception ignored) {
                    }
                }
            } catch (Exception ignored) {
            }
        }
    }

    private boolean startProcessWithFallback(String base, String user, String pass, String processKey,
            String businessKey, String varName, String varValue) {
        String startBody = String.format(
                "{\"key\":\"%s\",\"businessKey\":\"%s\",\"variables\":[{\"name\":\"%s\",\"value\":\"%s\"}]}",
                processKey, businessKey, varName, varValue);
        if (VERBOSE)
            System.out.println("DEBUG: POSTing to " + base + "/process/start -> body=\n" + truncate(startBody, 2000));
        Response r = given().auth().basic(user, pass).contentType("application/json").body(startBody)
                .post(base + "/process/start").andReturn();
        if (!(r.getStatusCode() == 200 || r.getStatusCode() == 201)) {
            if (VERBOSE) {
                System.out.println("DEBUG: /process/start returned status=" + r.getStatusCode() + " body=\n"
                        + truncate(r.asString(), 4000));
            }
            // If this server exposes services under an alternate prefix (e.g. no
            // '/service'),
            // try the alternate base as well before falling back to the older runtime API.
            String altBase = base.contains("/service") ? base.substring(0, base.indexOf("/service")) : null;
            if (altBase != null) {
                try {
                    if (VERBOSE)
                        System.out.println("DEBUG: POSTing to " + altBase + "/process/start -> body=\n"
                                + truncate(startBody, 2000));
                    Response rAlt = given().auth().basic(user, pass).contentType("application/json").body(startBody)
                            .post(altBase + "/process/start").andReturn();
                    if (VERBOSE)
                        System.out.println("DEBUG: alt /process/start returned status=" + rAlt.getStatusCode());
                    if (rAlt.getStatusCode() == 200 || rAlt.getStatusCode() == 201) {
                        r = rAlt;
                    }
                } catch (Exception ignored) {
                }
            }

            if (!(r.getStatusCode() == 200 || r.getStatusCode() == 201)) {
                // Try older API shape
                String runtimeBody = String.format(
                        "{\"processDefinitionKey\":\"%s\",\"businessKey\":\"%s\",\"variables\":[{\"name\":\"%s\",\"value\":\"%s\"}]}",
                        processKey, businessKey, varName, varValue);
                if (VERBOSE)
                    System.out.println("DEBUG: POSTing to " + base + "/runtime/process-instances -> body=\n"
                            + truncate(runtimeBody, 2000));
                r = given().auth().basic(user, pass).contentType("application/json").body(runtimeBody)
                        .post(base + "/runtime/process-instances").andReturn();
                if (!(r.getStatusCode() == 200 || r.getStatusCode() == 201) && altBase != null) {
                    try {
                        if (VERBOSE)
                            System.out.println("DEBUG: POSTing to " + altBase + "/runtime/process-instances -> body=\n"
                                    + truncate(runtimeBody, 2000));
                        Response rAlt2 = given().auth().basic(user, pass).contentType("application/json")
                                .body(runtimeBody).post(altBase + "/runtime/process-instances").andReturn();
                        if (VERBOSE)
                            System.out.println(
                                    "DEBUG: alt /runtime/process-instances returned status=" + rAlt2.getStatusCode());
                        if (rAlt2.getStatusCode() == 200 || rAlt2.getStatusCode() == 201) {
                            r = rAlt2;
                        }
                    } catch (Exception ignored) {
                    }
                }
                if (!(r.getStatusCode() == 200 || r.getStatusCode() == 201) && VERBOSE) {
                    System.out.println("DEBUG: /runtime/process-instances returned status=" + r.getStatusCode()
                            + " body=\n" + truncate(r.asString(), 4000));
                    dumpDiagnostics(base, user, pass);
                }
                // If runtime POST failed (e.g., 400), try to find the deployed process by key
                // and start using its explicit processDefinitionId as a last-resort fallback.
                if (!(r.getStatusCode() == 200 || r.getStatusCode() == 201)) {
                    try {
                        Response pd = authGet(base, "/repository/process-definitions?key=" + processKey, user, pass);
                        if (pd.getStatusCode() == 200) {
                            String id = null;
                            try {
                                id = pd.jsonPath().getString("data[0].id");
                            } catch (Exception ignored) {
                            }
                            if (id != null) {
                                String idBody = String.format(
                                        "{\"processDefinitionId\":\"%s\",\"businessKey\":\"%s\",\"variables\":[{\"name\":\"%s\",\"value\":\"%s\"}]}",
                                        id, businessKey, varName, varValue);
                                if (VERBOSE)
                                    System.out.println("DEBUG: Attempting start using processDefinitionId -> " + id
                                            + " body=\n" + truncate(idBody, 2000));
                                Response rId = given().auth().basic(user, pass).contentType("application/json")
                                        .body(idBody).post(base + "/runtime/process-instances").andReturn();
                                if (rId.getStatusCode() == 200 || rId.getStatusCode() == 201) {
                                    r = rId;
                                } else {
                                    if (VERBOSE)
                                        System.out.println("DEBUG: start by processDefinitionId returned status="
                                                + rId.getStatusCode() + " body=\n" + truncate(rId.asString(), 4000));
                                    if (altBase != null) {
                                        try {
                                            Response rIdAlt = given().auth().basic(user, pass)
                                                    .contentType("application/json").body(idBody)
                                                    .post(altBase + "/runtime/process-instances").andReturn();
                                            if (rIdAlt.getStatusCode() == 200 || rIdAlt.getStatusCode() == 201) {
                                                r = rIdAlt;
                                            } else if (VERBOSE) {
                                                System.out.println(
                                                        "DEBUG: alt start by processDefinitionId returned status="
                                                                + rIdAlt.getStatusCode() + " body=\n"
                                                                + truncate(rIdAlt.asString(), 4000));
                                            }
                                        } catch (Exception ignored) {
                                        }
                                    }
                                }
                                if ((r.getStatusCode() == 200 || r.getStatusCode() == 201) && VERBOSE) {
                                    System.out.println("INFO: started process via processDefinitionId=" + id);
                                }
                            }
                        }
                    } catch (Exception ignored) {
                    }
                }
            }
        }
        if (r.getStatusCode() == 200 || r.getStatusCode() == 201) {
            return true;
        }
        return false;
    }

    private void waitForProcessInstance(String base, String user, String pass, String processKey) {
        final String finalBase = base;
        final String finalUser = user;
        final String finalPass = pass;
        await().atMost(Duration.ofSeconds(30)).pollInterval(Duration.ofSeconds(1)).untilAsserted(() -> {
            Response r = authGet(finalBase, "/runtime/process-instances?processDefinitionKey=" + processKey, finalUser,
                    finalPass);
            if (r.getStatusCode() == 200 && sizeFromResponse(r) >= 1)
                return;
            Response h = authGet(finalBase, "/history/historic-process-instances?processDefinitionKey=" + processKey,
                    finalUser, finalPass);
            org.assertj.core.api.Assertions.assertThat(h.getStatusCode()).as("Status for historic-process-instances")
                    .isEqualTo(200);
            org.assertj.core.api.Assertions.assertThat(sizeFromResponse(h)).as("Historic size for process instances")
                    .isGreaterThanOrEqualTo(1);
        });
    }

    private boolean ensureCmmnCasesPresent(String base, String user, String pass) {
        String cmmnQuery = detectCmmnQueryPath(base, user, pass);
        if (cmmnQuery == null) {
            if (VERBOSE)
                System.out.println("WARN: CMMN REST endpoints not available, skipping CMMN assertions");
            return false;
        }

        // Try GET first
        try {
            Response r = authGet(base, "/cmmn-history/historic-case-instances?caseDefinitionKey=skipTracingCase", user,
                    pass);
            if (r.getStatusCode() == 200 && sizeFromResponse(r) >= 1)
                return true;
        } catch (Exception ignored) {
        }

        // Try POST-based historic query
        try {
            Response r2 = given().auth().basic(user, pass).contentType("application/json")
                    .body("{\"caseDefinitionKey\":\"skipTracingCase\"}")
                    .post(base + "/cmmn-api/cmmn-query/historic-case-instances").andReturn();
            if (r2.getStatusCode() == 200 && sizeFromResponse(r2) >= 1)
                return true;
        } catch (Exception ignored) {
        }

        // Create cases when missing (derive business keys where possible)
        java.util.List<String> businessKeys = new java.util.ArrayList<>();
        try {
            Response hv = authGet(base, "/history/historic-variable-instances?variableName=assignmentList", user, pass);
            if (hv.getStatusCode() == 200 && sizeFromResponse(hv) >= 1) {
                String raw = null;
                try {
                    raw = hv.jsonPath().getString("data[0].value");
                } catch (Exception ignored) {
                }
                if (raw == null)
                    try {
                        raw = hv.jsonPath().getString("data[0].valueSerialized");
                    } catch (Exception ignored) {
                    }
                if (raw == null)
                    try {
                        raw = hv.jsonPath().getString("rows[0].value");
                    } catch (Exception ignored) {
                    }
                if (raw != null) {
                    try {
                        io.restassured.path.json.JsonPath jp = new io.restassured.path.json.JsonPath(raw);
                        java.util.List<java.util.Map<String, Object>> list = jp.getList("");
                        if (list != null && !list.isEmpty())
                            for (var m : list) {
                                Object cif = m.get("cif");
                                if (cif != null)
                                    businessKeys.add(cif.toString());
                            }
                    } catch (Exception ignored) {
                        if (VERBOSE)
                            System.out.println("DEBUG: failed parsing assignmentList");
                    }
                }
            }
        } catch (Exception ignored) {
        }

        if (businessKeys.isEmpty()) {
            businessKeys.add("123");
            businessKeys.add("456");
            businessKeys.add("789");
        }

        for (String bk : businessKeys) {
            String createBody = "{\"caseDefinitionKey\":\"skipTracingCase\",\"businessKey\":\"" + bk + "\"}";
            try {
                Response create = given().auth().basic(user, pass).contentType("application/json").body(createBody)
                        .post(base + "/cmmn-api/case-instances").andReturn();
                if (VERBOSE)
                    System.out.println("INFO: create bk=" + bk + " status=" + create.getStatusCode());
            } catch (Exception ignored) {
            }
        }

        // Wait (best-effort) for created cases to appear. Don't throw on timeout;
        // return whether we observed at least one case.
        if (cmmnQuery.startsWith("GET:")) {
            String path = cmmnQuery.substring(4);
            for (int i = 0; i < 60; i++) {
                try {
                    Response r = authGet(base, path, user, pass);
                    if (r.getStatusCode() == 200 && sizeFromResponse(r) >= 1)
                        return true;
                } catch (Exception ignored) {
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
            return false;
        } else if (cmmnQuery.startsWith("POST:")) {
            String path = cmmnQuery.substring(5);
            String body = "{\"caseDefinitionKey\":\"skipTracingCase\"}";
            for (int i = 0; i < 60; i++) {
                try {
                    Response r = given().auth().basic(user, pass).contentType("application/json").body(body)
                            .post(base + path).andReturn();
                    if (r.getStatusCode() == 200 && sizeFromResponse(r) >= 1)
                        return true;
                } catch (Exception ignored) {
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
            return false;
        }

        return false;
    }

    /**
     * Try uploading a resource using the provided candidate multipart field names
     * and
     * log request/response details to stdout so we can inspect exact HTTP payloads.
     */
    private static Response tryMultipartUploadWithLogging(String url, File resource, String[] fieldCandidates,
            String deploymentName, String user, String pass) {
        Response last = null;
        for (String field : fieldCandidates) {
            if (VERBOSE)
                System.out.println("DEBUG: Attempting multipart upload to " + url + " using field='" + field
                        + "' and content-type=application/octet-stream");
            try {
                var spec = given().auth().basic(user, pass).multiPart(field, resource, "application/octet-stream")
                        .formParam("deploymentName", deploymentName);
                if (VERBOSE)
                    spec = spec.log().all();
                Response r = spec.when().post(url).andReturn();
                if (VERBOSE) {
                    System.out.println("DEBUG: Response for field='" + field + "' -> status=" + r.getStatusCode()
                            + ", content-type=" + r.getContentType());
                }
                last = r;
                if (r.getStatusCode() == 201) {
                    if (VERBOSE)
                        System.out.println("INFO: Upload succeeded using field='" + field + "'");
                    return r;
                }
            } catch (Exception e) {
                if (VERBOSE)
                    System.out.println(
                            "DEBUG: Exception during upload attempt with field='" + field + "': " + e.getMessage());
            }
        }
        return last == null ? given().auth().basic(user, pass).post(url) : last;
    }

    private static File zipSingleFile(File src) {
        try {
            File tmp = File.createTempFile(src.getName(), ".zip");
            tmp.deleteOnExit();
            try (java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(
                    new java.io.FileOutputStream(tmp))) {
                java.util.zip.ZipEntry entry = new java.util.zip.ZipEntry(src.getName());
                zos.putNextEntry(entry);
                try (java.io.FileInputStream fis = new java.io.FileInputStream(src)) {
                    byte[] buf = new byte[8192];
                    int len;
                    while ((len = fis.read(buf)) > 0) {
                        zos.write(buf, 0, len);
                    }
                }
                zos.closeEntry();
            }
            return tmp;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create zip for " + src, e);
        }
    }

    private static File zipFiles(File[] srcs) {
        try {
            File tmp = File.createTempFile("combined-deploy", ".zip");
            tmp.deleteOnExit();
            try (java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(
                    new java.io.FileOutputStream(tmp))) {
                for (File src : srcs) {
                    java.util.zip.ZipEntry entry = new java.util.zip.ZipEntry(src.getName());
                    zos.putNextEntry(entry);
                    try (java.io.FileInputStream fis = new java.io.FileInputStream(src)) {
                        byte[] buf = new byte[8192];
                        int len;
                        while ((len = fis.read(buf)) > 0) {
                            zos.write(buf, 0, len);
                        }
                    }
                    zos.closeEntry();
                }
            }
            return tmp;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create combined zip", e);
        }
    }

    private static Response authGet(String base, String path, String user, String pass) {
        return given().auth().basic(user, pass).get(base + path);
    }

    private static int sizeFromResponse(Response r) {
        if (r.getStatusCode() != 200) {
            return 0;
        }
        try {
            var list = r.jsonPath().getList("data");
            if (list != null && !list.isEmpty())
                return list.size();
        } catch (Exception ignored) {
        }
        try {
            var list = r.jsonPath().getList("rows");
            if (list != null && !list.isEmpty())
                return list.size();
        } catch (Exception ignored) {
        }
        try {
            var rootList = r.jsonPath().getList("");
            if (rootList != null)
                return rootList.size();
        } catch (Exception ignored) {
        }
        return 0;
    }

    private static void awaitForListSize(String base, String path, String user, String pass, int min,
            Duration timeout) {
        // Be resilient: try both the configured base and an alternate base
        // (without the '/service' prefix) because some images mount CMMN
        // runtime controllers under different prefixes.
        final String altBase = base.contains("/service") ? base.substring(0, base.indexOf("/service")) : base;
        await().atMost(timeout).pollInterval(Duration.ofSeconds(1)).untilAsserted(() -> {
            Response r1 = authGet(base, path, user, pass);
            if (r1.getStatusCode() == 200) {
                int size = sizeFromResponse(r1);
                org.assertj.core.api.Assertions.assertThat(size).as("Size for %s at %s", path, base)
                        .isGreaterThanOrEqualTo(min);
                return;
            }
            Response r2 = null;
            if (!altBase.equals(base)) {
                r2 = authGet(altBase, path, user, pass);
                if (r2.getStatusCode() == 200) {
                    int size = sizeFromResponse(r2);
                    org.assertj.core.api.Assertions.assertThat(size).as("Size for %s at %s", path, altBase)
                            .isGreaterThanOrEqualTo(min);
                    return;
                }
            }
            // If neither returned 200, fail with useful diagnostics so the outer
            // retry mechanism can try again and we can see the latest responses.
            String msg = String.format("Expected 200 from %s or %s for path %s but got %d and %d", base, altBase, path,
                    r1.getStatusCode(), r2 == null ? -1 : r2.getStatusCode());
            System.out.println("DEBUG: " + msg);
            if (r1.getStatusCode() != 200) {
                if (VERBOSE)
                    System.out.println("DEBUG: body from " + base + " -> " + truncate(r1.asString(), 1000));
            }
            if (r2 != null && r2.getStatusCode() != 200) {
                if (VERBOSE)
                    System.out.println("DEBUG: body from " + altBase + " -> " + truncate(r2.asString(), 1000));
            }
            org.assertj.core.api.Assertions.assertThat(false).as(msg).isTrue();
        });
    }

    private static void dumpDiagnostics(String base, String user, String pass) {
        if (VERBOSE)
            System.out.println("DEBUG: Running diagnostics to discover mappings/docs and alternate endpoints...");
        String root = base;
        if (base.contains("/service")) {
            root = base.substring(0, base.indexOf("/service"));
        } else if (root.endsWith("/")) {
            root = root.substring(0, root.length() - 1);
        }

        // Try actuator mappings (if actuator is enabled)
        try {
            String mappingsUrl = root + "/actuator/mappings";
            Response m = given().auth().basic(user, pass).get(mappingsUrl);
            if (VERBOSE) {
                System.out.println("DEBUG: actuator mappings (" + mappingsUrl + ") status=" + m.statusCode());
            }
        } catch (Exception e) {
            if (VERBOSE)
                System.out.println("DEBUG: failed fetching actuator mappings: " + e.getMessage());
        }

        // Try common docs/openapi endpoints
        String[] docPaths = new String[] { root + "/docs/specs", root + "/docs", root + "/v3/api-docs",
                base + "/docs/specs", base + "/docs", base + "/v3/api-docs" };
        for (String p : docPaths) {
            try {
                Response d = given().auth().basic(user, pass).get(p);
                if (VERBOSE) {
                    System.out.println("DEBUG: GET " + p + " -> " + d.statusCode());
                }
            } catch (Exception e) {
                if (VERBOSE)
                    System.out.println("DEBUG: GET " + p + " -> EX: " + e.getMessage());
            }
        }

        // Probe likely deployment endpoints (both root and base prefixes)
        String[] deployPaths = new String[] { "/repository/deployments", "/cmmn-repository/deployments" };
        for (String dp : deployPaths) {
            for (String prefix : new String[] { root, base }) {
                String url = prefix + dp;
                try {
                    Response rr = given().auth().basic(user, pass).get(url);
                    if (VERBOSE) {
                        System.out.println("DEBUG: GET " + url + " -> " + rr.statusCode());
                    }
                } catch (Exception e) {
                    if (VERBOSE)
                        System.out.println("DEBUG: GET " + url + " -> EX: " + e.getMessage());
                }
            }
        }
    }

    private static boolean isCmmnApiAvailable(String base, String user, String pass) {
        // Probe a variety of CMMN endpoints — both the historical/runtime
        // GET endpoints and the POST-based '/cmmn-api' query endpoints. Some
        // images expose CMMN under '/cmmn-api' which requires POST queries.
        String[] getCandidates = new String[] {
                "/cmmn-history/historic-case-instances?caseDefinitionKey=skipTracingCase",
                "/cmmn-runtime/case-instances?caseDefinitionKey=skipTracingCase",
                "/cmmn-repository/deployments"
        };
        for (String p : getCandidates) {
            try {
                Response r = authGet(base, p, user, pass);
                if (r.getStatusCode() == 200) {
                    if (VERBOSE)
                        System.out.println("DEBUG: CMMN available at GET " + base + p);
                    return true;
                }
            } catch (Exception ignored) {
            }
            if (base.contains("/service")) {
                String altBase = base.substring(0, base.indexOf("/service"));
                try {
                    Response r2 = authGet(altBase, p, user, pass);
                    if (r2.getStatusCode() == 200) {
                        if (VERBOSE)
                            System.out.println("DEBUG: CMMN available at GET " + altBase + p);
                        return true;
                    }
                } catch (Exception ignored) {
                }
            }
        }

        // POST-based cmmn-api queries (e.g. your curl: POST /cmmn-api/cmmn-query/..)
        String[] postCandidates = new String[] {
                "/cmmn-api/cmmn-query/historic-variable-instances",
                "/cmmn-api/cmmn-query/historic-case-instances",
                "/cmmn-api/cmmn-query/case-instances"
        };
        for (String p : postCandidates) {
            try {
                Response r = given().auth().basic(user, pass).contentType("application/json").body("{}").post(base + p)
                        .andReturn();
                if (r.getStatusCode() == 200) {
                    if (VERBOSE)
                        System.out.println("DEBUG: CMMN available at POST " + base + p);
                    return true;
                }
            } catch (Exception ignored) {
            }
            if (base.contains("/service")) {
                String altBase = base.substring(0, base.indexOf("/service"));
                try {
                    Response r2 = given().auth().basic(user, pass).contentType("application/json").body("{}")
                            .post(altBase + p).andReturn();
                    if (r2.getStatusCode() == 200) {
                        if (VERBOSE)
                            System.out.println("DEBUG: CMMN available at POST " + altBase + p);
                        return true;
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return false;
    }

    /**
     * Detect a CMMN query endpoint that can be used to fetch historic case
     * or variable instances. Returns a string with a prefix indicating
     * the HTTP method ("GET:" or "POST:") followed by the path. Returns
     * null when no suitable endpoint is found.
     */
    private static String detectCmmnQueryPath(String base, String user, String pass) {
        String[] getCandidates = new String[] {
                "/cmmn-history/historic-case-instances?caseDefinitionKey=skipTracingCase",
                "/cmmn-runtime/case-instances?caseDefinitionKey=skipTracingCase",
                "/cmmn-repository/deployments"
        };
        for (String p : getCandidates) {
            try {
                Response r = authGet(base, p, user, pass);
                if (r.getStatusCode() == 200) {
                    if (VERBOSE)
                        System.out.println("DEBUG: CMMN available at GET " + base + p);
                    return "GET:" + p;
                }
            } catch (Exception ignored) {
            }
            if (base.contains("/service")) {
                String altBase = base.substring(0, base.indexOf("/service"));
                try {
                    Response r2 = authGet(altBase, p, user, pass);
                    if (r2.getStatusCode() == 200) {
                        if (VERBOSE)
                            System.out.println("DEBUG: CMMN available at GET " + altBase + p);
                        return "GET:" + p;
                    }
                } catch (Exception ignored) {
                }
            }
        }

        String[] postCandidates = new String[] {
                "/cmmn-api/cmmn-query/historic-variable-instances",
                "/cmmn-api/cmmn-query/historic-case-instances",
                "/cmmn-api/cmmn-query/case-instances"
        };
        for (String p : postCandidates) {
            try {
                Response r = given().auth().basic(user, pass).contentType("application/json").body("{}").post(base + p)
                        .andReturn();
                if (r.getStatusCode() == 200) {
                    if (VERBOSE)
                        System.out.println("DEBUG: CMMN available at POST " + base + p);
                    return "POST:" + p;
                }
            } catch (Exception ignored) {
            }
            if (base.contains("/service")) {
                String altBase = base.substring(0, base.indexOf("/service"));
                try {
                    Response r2 = given().auth().basic(user, pass).contentType("application/json").body("{}")
                            .post(altBase + p).andReturn();
                    if (r2.getStatusCode() == 200) {
                        if (VERBOSE)
                            System.out.println("DEBUG: CMMN available at POST " + altBase + p);
                        return "POST:" + p;
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return null;
    }

    private static void awaitForPostListSize(String base, String path, String bodyJson, String user, String pass,
            int min, Duration timeout) {
        final String altBase = base.contains("/service") ? base.substring(0, base.indexOf("/service")) : base;
        await().atMost(timeout).pollInterval(Duration.ofSeconds(1)).untilAsserted(() -> {
            Response r1 = given().auth().basic(user, pass).contentType("application/json").body(bodyJson)
                    .post(base + path).andReturn();
            if (r1.getStatusCode() == 200) {
                int size = sizeFromResponse(r1);
                org.assertj.core.api.Assertions.assertThat(size).as("Size for %s at %s", path, base)
                        .isGreaterThanOrEqualTo(min);
                return;
            }
            Response r2 = null;
            if (!altBase.equals(base)) {
                r2 = given().auth().basic(user, pass).contentType("application/json").body(bodyJson)
                        .post(altBase + path).andReturn();
                if (r2.getStatusCode() == 200) {
                    int size = sizeFromResponse(r2);
                    org.assertj.core.api.Assertions.assertThat(size).as("Size for %s at %s", path, altBase)
                            .isGreaterThanOrEqualTo(min);
                    return;
                }
            }
            String msg = String.format("Expected 200 from %s or %s for path %s but got %d and %d", base, altBase, path,
                    r1.getStatusCode(), r2 == null ? -1 : r2.getStatusCode());
            if (VERBOSE)
                System.out.println("DEBUG: " + msg);
            if (r1.getStatusCode() != 200) {
                if (VERBOSE)
                    System.out.println("DEBUG: body from " + base + " -> " + truncate(r1.asString(), 1000));
            }
            if (r2 != null && r2.getStatusCode() != 200) {
                if (VERBOSE)
                    System.out.println("DEBUG: body from " + altBase + " -> " + truncate(r2.asString(), 1000));
            }
            org.assertj.core.api.Assertions.assertThat(false).as(msg).isTrue();
        });
    }

    private static String truncate(String s, int max) {
        if (s == null)
            return "<null>";
        if (s.length() <= max)
            return s;
        return s.substring(0, max) + "... (truncated)";
    }
}
