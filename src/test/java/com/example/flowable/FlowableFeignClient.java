package com.example.flowable;

import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.RequestLine;
import feign.Response;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import feign.FeignException;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Small OpenFeign-based helper used by tests to probe typed Flowable REST endpoints.
 *
 * The nested `FlowableApi` interface describes a small subset of endpoints that the
 * integration tests exercise (CMMN/BPMN runtime, historic queries, repository deployments
 * and task actions). The class also provides helper builders and endpoint discovery
 * helpers used by the test suite.
 */
public class FlowableFeignClient {

    public interface FlowableApi {
        @RequestLine("POST /process/start")
        @Headers("Content-Type: application/json")
        Response startProcessRaw(String body);

        @RequestLine("POST /runtime/process-instances")
        @Headers("Content-Type: application/json")
        Response createProcessInstanceRaw(String body);

        @RequestLine("POST /cmmn-api/case-instances")
        @Headers("Content-Type: application/json")
        Response createCaseRaw(String body);

        @RequestLine("POST /cmmn-api/case-instances/create")
        @Headers("Content-Type: application/json")
        Response createCaseCreateRaw(String body);

        @RequestLine("POST /cmmn-runtime/case-instances")
        @Headers("Content-Type: application/json")
        Response createCaseRuntimeRaw(String body);

        @RequestLine("POST /case-instances")
        @Headers("Content-Type: application/json")
        Response createCaseGenericRaw(String body);

        // Historic CMMN queries
        @RequestLine("GET /cmmn-history/historic-case-instances?caseDefinitionKey={key}")
        Response getHistoricCaseInstancesByKey(@Param("key") String key);

        @RequestLine("GET /cmmn-history/historic-case-instances?caseDefinitionKey={key}&size={size}")
        Response getHistoricCaseInstancesByKeySize(@Param("key") String key, @Param("size") int size);

        @RequestLine("POST /cmmn-api/cmmn-query/historic-case-instances")
        @Headers("Content-Type: application/json")
        Response postCmmnHistoricQuery(String body);

        @RequestLine("GET /repository/process-definitions?key={key}")
        Response getProcessDefinitionsByKey(@Param("key") String key);

        // History endpoints
        @RequestLine("GET /history/historic-process-instances?processDefinitionKey={key}")
        Response getHistoricProcessInstancesByKey(@Param("key") String key);

        @RequestLine("GET /history/historic-variable-instances?variableName={name}")
        Response getHistoricVariableInstancesByName(@Param("name") String name);

        @RequestLine("POST /repository/process-definitions/{id}/start")
        @Headers("Content-Type: application/json")
        Response startByDefinitionId(@Param("id") String id, String body);

        // Task / CMMN actions
        @RequestLine("POST /runtime/tasks/{id}")
        @Headers("Content-Type: application/json")
        Response postRuntimeTask(@Param("id") String id, String body);

        @RequestLine("POST /runtime/tasks/{id}/complete")
        @Headers("Content-Type: application/json")
        Response postRuntimeTaskComplete(@Param("id") String id, String body);

        @RequestLine("POST /runtime/tasks/{id}/action")
        @Headers("Content-Type: application/json")
        Response postRuntimeTaskAction(@Param("id") String id, String body);

        @RequestLine("POST /cmmn-api/runtime/tasks/{id}")
        @Headers("Content-Type: application/json")
        Response postCmmnRuntimeTask(@Param("id") String id, String body);

        @RequestLine("POST /cmmn-api/tasks/{id}/action")
        @Headers("Content-Type: application/json")
        Response postCmmnTasksAction(@Param("id") String id, String body);

        @RequestLine("POST /task/{id}/complete")
        @Headers("Content-Type: application/json")
        Response postTaskCompleteGeneric(@Param("id") String id, String body);

        @RequestLine("POST /cmmn-api/runtime/plan-item-instances/{id}/complete")
        @Headers("Content-Type: application/json")
        Response postPlanItemComplete(@Param("id") String id, String body);

        @RequestLine("PUT /cmmn-runtime/plan-item-instances/{id}")
        @Headers("Content-Type: application/json")
        Response putPlanItem(@Param("id") String id, String body);

        // Deployment probes
        @RequestLine("GET /repository/deployments")
        Response getRepositoryDeployments();

        @RequestLine("GET /cmmn-api/cmmn-repository/deployments")
        Response getCmmnRepositoryDeployments();
    }

    public static Feign.Builder baseBuilder(String user, String pass) {
        RequestInterceptor auth = new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.header("Authorization", "Basic " + java.util.Base64.getEncoder()
                        .encodeToString((user + ":" + pass).getBytes(StandardCharsets.UTF_8)));
            }
        };
        return Feign.builder().options(new feign.Request.Options(1000, 2000)).encoder(new JacksonEncoder()).decoder(new JacksonDecoder()).requestInterceptor(auth)
                .logger(new Slf4jLogger());
    }

    // Probe for deployment endpoints (repository or cmmn-repository). Returns the full
    // URL suitable for multipart upload (including ?deploymentName=...) if found, else null.
    public static String findRepositoryDeploymentEndpoint(String base, String user, String pass, String deploymentName) {
        List<String> bases = new ArrayList<>();
        bases.add(base);
        if (!base.endsWith("/service")) bases.add(base + "/service");
        if (base.contains("/service")) {
            String alt = base.substring(0, base.indexOf("/service"));
            bases.add(alt);
            bases.add(alt + "/service");
        }

        for (String b : bases) {
            try {
                FlowableApi api = baseBuilder(user, pass).target(FlowableApi.class, b);
                try {
                    Response r = api.getRepositoryDeployments();
                    if (r != null && r.status() == 200) {
                        return b + "/repository/deployments?deploymentName=" + java.net.URLEncoder.encode(deploymentName, java.nio.charset.StandardCharsets.UTF_8);
                    }
                } catch (FeignException ignored) {
                }
            } catch (Exception ignored) {
            }
        }
        return null;
    }

    public static String findCmmnDeploymentEndpoint(String base, String user, String pass, String deploymentName) {
        List<String> bases = new ArrayList<>();
        bases.add(base);
        if (!base.endsWith("/service")) bases.add(base + "/service");
        if (base.contains("/service")) {
            String alt = base.substring(0, base.indexOf("/service"));
            bases.add(alt);
            bases.add(alt + "/service");
        }

        for (String b : bases) {
            try {
                FlowableApi api = baseBuilder(user, pass).target(FlowableApi.class, b);
                try {
                    Response r = api.getCmmnRepositoryDeployments();
                    if (r != null && r.status() == 200) {
                        return b + "/cmmn-api/cmmn-repository/deployments?deploymentName=" + java.net.URLEncoder.encode(deploymentName, java.nio.charset.StandardCharsets.UTF_8);
                    }
                } catch (FeignException ignored) {
                }
            } catch (Exception ignored) {
            }
        }
        return null;
    }

    // CMMN / case creation and task completion primitive helpers
    public static boolean tryCreateCase(String base, String user, String pass, String bodyJson) {
        List<String> bases = new ArrayList<>();
        bases.add(base);
        if (!base.endsWith("/service"))
            bases.add(base + "/service");
        if (base.contains("/service")) {
            String alt = base.substring(0, base.indexOf("/service"));
            bases.add(alt);
            bases.add(alt + "/service");
        }

        for (String b : bases) {
            try {
                FlowableApi api = baseBuilder(user, pass).target(FlowableApi.class, b);
                try {
                    Response r = api.createCaseRaw(bodyJson);
                    if (r != null && (r.status() == 200 || r.status() == 201)) {
                        if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign createCase at " + b + " succeeded: " + r.status());
                        return true;
                    }
                } catch (FeignException fe) {
                    if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign createCaseRaw at " + b + " failed: " + fe.getMessage());
                }
                try {
                    Response r2 = api.createCaseCreateRaw(bodyJson);
                    if (r2 != null && (r2.status() == 200 || r2.status() == 201)) {
                        if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign createCaseCreate at " + b + " succeeded: " + r2.status());
                        return true;
                    }
                } catch (FeignException fe) {
                    if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign createCaseCreateRaw at " + b + " failed: " + fe.getMessage());
                }
                try {
                    Response r3 = api.createCaseRuntimeRaw(bodyJson);
                    if (r3 != null && (r3.status() == 200 || r3.status() == 201)) {
                        if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign createCaseRuntime at " + b + " succeeded: " + r3.status());
                        return true;
                    }
                } catch (FeignException fe) {
                    if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign createCaseRuntimeRaw at " + b + " failed: " + fe.getMessage());
                }
                try {
                    Response r4 = api.createCaseGenericRaw(bodyJson);
                    if (r4 != null && (r4.status() == 200 || r4.status() == 201)) {
                        if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign createCaseGeneric at " + b + " succeeded: " + r4.status());
                        return true;
                    }
                } catch (FeignException fe) {
                    if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign createCaseGenericRaw at " + b + " failed: " + fe.getMessage());
                }
            } catch (Exception e) {
                if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign client for base " + b + " failed: " + e.getMessage());
            }
        }
        return false;
    }

    public static boolean tryCompleteTask(String base, String user, String pass, String taskId, String planItemId) {
        String completeBody = "{\"action\":\"complete\"}";
        List<String> bases = new ArrayList<>();
        bases.add(base);
        if (!base.endsWith("/service")) bases.add(base + "/service");
        if (base.contains("/service")) {
            String alt = base.substring(0, base.indexOf("/service"));
            bases.add(alt);
            bases.add(alt + "/service");
        }

        for (String b : bases) {
            try {
                FlowableApi api = baseBuilder(user, pass).target(FlowableApi.class, b);
                try {
                    Response r = api.postRuntimeTaskComplete(taskId, completeBody);
                    if (r != null && (r.status() == 200 || r.status() == 204)) return true;
                } catch (FeignException ignored) {}
                try {
                    Response r2 = api.postRuntimeTaskAction(taskId, completeBody);
                    if (r2 != null && (r2.status() == 200 || r2.status() == 204)) return true;
                } catch (FeignException ignored) {}
                try {
                    Response r3 = api.postRuntimeTask(taskId, completeBody);
                    if (r3 != null && (r3.status() == 200 || r3.status() == 204)) return true;
                } catch (FeignException ignored) {}
                try {
                    Response r4 = api.postCmmnRuntimeTask(taskId, completeBody);
                    if (r4 != null && (r4.status() == 200 || r4.status() == 204)) return true;
                } catch (FeignException ignored) {}
                try {
                    Response r5 = api.postCmmnTasksAction(taskId, completeBody);
                    if (r5 != null && (r5.status() == 200 || r5.status() == 204)) return true;
                } catch (FeignException ignored) {}
                try {
                    Response r6 = api.postTaskCompleteGeneric(taskId, completeBody);
                    if (r6 != null && (r6.status() == 200 || r6.status() == 204)) return true;
                } catch (FeignException ignored) {}

                // Try plan-item based completes/puts
                if (planItemId != null) {
                    try {
                        Response pr = api.postPlanItemComplete(planItemId, completeBody);
                        if (pr != null && (pr.status() == 200 || pr.status() == 204)) return true;
                    } catch (FeignException ignored) {}
                    try {
                        Response put = api.putPlanItem(planItemId, completeBody);
                        if (put != null && (put.status() == 200 || put.status() == 204)) return true;
                    } catch (FeignException ignored) {}
                }
            } catch (Exception e) {
                if (FlowableTestUtils.VERBOSE) System.out.println("DEBUG: Feign client for base " + b + " failed: " + e.getMessage());
            }
        }
        return false;
    }

    public static String readBody(Response r) {
        if (r == null || r.body() == null)
            return null;
        try (InputStream in = r.body().asInputStream()) {
            byte[] b = in.readAllBytes();
            return new String(b, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean tryStartProcess(String base, String user, String pass, String processKey, String businessKey,
            Map<String, Object> variables) {
        List<String> bases = new ArrayList<>();
        bases.add(base);
        if (!base.endsWith("/service"))
            bases.add(base + "/service");
        if (base.contains("/service")) {
            String alt = base.substring(0, base.indexOf("/service"));
            bases.add(alt);
            bases.add(alt + "/service");
        }

        String startBody = String.format("{\"key\":\"%s\",\"businessKey\":\"%s\",\"variables\":[]}", processKey,
                businessKey);
        // simple variables injection when present
        if (variables != null && !variables.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\"key\":\"").append(processKey).append("\",");
            sb.append("\"businessKey\":\"").append(businessKey).append("\",");
            sb.append("\"variables\":[");
            boolean first = true;
            for (Map.Entry<String, Object> e : variables.entrySet()) {
                if (!first)
                    sb.append(',');
                sb.append("{\"name\":\"").append(e.getKey()).append("\",\"value\":\"")
                        .append(String.valueOf(e.getValue()).replace("\"", "\\\"")).append("\"}");
                first = false;
            }
            sb.append("]}");
            startBody = sb.toString();
        }

        String runtimeBody = String.format("{\"processDefinitionKey\":\"%s\",\"businessKey\":\"%s\",\"variables\":[]}",
                processKey, businessKey);
        if (variables != null && !variables.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\"processDefinitionKey\":\"").append(processKey).append("\",");
            sb.append("\"businessKey\":\"").append(businessKey).append("\",");
            sb.append("\"variables\":[");
            boolean first = true;
            for (Map.Entry<String, Object> e : variables.entrySet()) {
                if (!first)
                    sb.append(',');
                sb.append("{\"name\":\"").append(e.getKey()).append("\",\"value\":\"")
                        .append(String.valueOf(e.getValue()).replace("\"", "\\\"")).append("\"}");
                first = false;
            }
            sb.append("]}");
            runtimeBody = sb.toString();
        }

        for (String b : bases) {
            try {
                FlowableApi api = baseBuilder(user, pass).target(FlowableApi.class, b);
                try {
                    Response r = api.startProcessRaw(startBody);
                    if (r != null && (r.status() == 200 || r.status() == 201)) {
                        if (FlowableTestUtils.VERBOSE)
                            System.out.println("DEBUG: Feign POST " + b + "/process/start -> status=" + r.status());
                        return true;
                    }
                } catch (FeignException fe) {
                    if (FlowableTestUtils.VERBOSE)
                        System.out.println("DEBUG: Feign startProcessRaw at " + b + " failed: " + fe.getMessage());
                }

                try {
                    Response r2 = api.createProcessInstanceRaw(runtimeBody);
                    if (r2 != null && (r2.status() == 200 || r2.status() == 201)) {
                        if (FlowableTestUtils.VERBOSE)
                            System.out.println("DEBUG: Feign POST " + b + "/runtime/process-instances -> status=" + r2.status());
                        return true;
                    }
                } catch (FeignException fe) {
                    if (FlowableTestUtils.VERBOSE)
                        System.out.println("DEBUG: Feign createProcessInstanceRaw at " + b + " failed: " + fe.getMessage());
                }
            } catch (Exception e) {
                if (FlowableTestUtils.VERBOSE)
                    System.out.println("DEBUG: Feign client for base " + b + " failed: " + e.getMessage());
            }
        }

        // As last resort use processDefinitionId start
        for (String b : bases) {
            try {
                FlowableApi api = baseBuilder(user, pass).target(FlowableApi.class, b);
                try {
                    Response pd = api.getProcessDefinitionsByKey(processKey);
                    if (pd != null && pd.status() == 200) {
                        String body = readBody(pd);
                        if (body != null) {
                            com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
                            try {
                                com.fasterxml.jackson.databind.JsonNode root = om.readTree(body);
                                com.fasterxml.jackson.databind.JsonNode data = root.path("data");
                                if (data.isArray() && data.size() > 0) {
                                    String id = data.get(0).path("id").asText(null);
                                    if (id != null) {
                                        String idBody = runtimeBody.replace("\"processDefinitionKey\":\"" + processKey + "\"",
                                                "\"processDefinitionId\":\"" + id + "\"");
                                        try {
                                            Response rId = api.startByDefinitionId(id, idBody);
                                            if (rId != null && (rId.status() == 200 || rId.status() == 201)) {
                                                if (FlowableTestUtils.VERBOSE)
                                                    System.out.println("DEBUG: Feign start by id succeeded -> " + id);
                                                return true;
                                            }
                                        } catch (FeignException fe) {
                                            if (FlowableTestUtils.VERBOSE)
                                                System.out.println("DEBUG: Feign startByDefinitionId failed: " + fe.getMessage());
                                        }
                                    }
                                }
                            } catch (Exception ignore) {
                                if (FlowableTestUtils.VERBOSE)
                                    System.out.println("DEBUG: failed parsing process-definitions body");
                            }
                        }
                    }
                } catch (FeignException fe) {
                    if (FlowableTestUtils.VERBOSE)
                        System.out.println("DEBUG: Feign getProcessDefinitionsByKey at " + b + " failed: " + fe.getMessage());
                }
            } catch (Exception e) {
                if (FlowableTestUtils.VERBOSE)
                    System.out.println("DEBUG: Feign client for base " + b + " failed: " + e.getMessage());
            }
        }

        return false;
    }
}
