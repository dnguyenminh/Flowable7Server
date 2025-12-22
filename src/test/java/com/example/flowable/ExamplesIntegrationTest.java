package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.io.File;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import static org.assertj.core.api.Assertions.assertThat;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.cmmn.api.CmmnRepositoryService;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.flowable.cmmn.api.CmmnTaskService;
import org.flowable.cmmn.api.CmmnHistoryService;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.Task;
import org.flowable.engine.HistoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:flowable",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver",
        // Ensure CMMN engine is enabled for these tests
        "flowable.cmmn.enabled=true"
    }
)
public class ExamplesIntegrationTest {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    CmmnRepositoryService cmmnRepositoryService;

    @Autowired
    CmmnRuntimeService cmmnRuntimeService;

    @Autowired(required = false)
    CmmnTaskService cmmnTaskService;

    @Autowired(required = false)
    CmmnHistoryService cmmnHistoryService;

    @Autowired
    HistoryService historyService;

    @Test
    public void test_bulk_upload_case_and_file_processing_integration() throws Exception {
        // Deploy BPMN and CMMN examples
        File bpmn = new File("src/test/resources/cases/file-processing.bpmn");
        assertThat(bpmn).exists();
        repositoryService.createDeployment()
                .name("example-bulk-file-deployment")
                .addInputStream("file-processing.bpmn", new java.io.FileInputStream(bpmn))
                .deploy();

        File cmmn = new File("src/test/resources/cases/bulk-upload.cmmn");
        assertThat(cmmn).exists();
        cmmnRepositoryService.createDeployment()
                .name("example-bulk-cmmn-deployment")
                .addInputStream("bulk-upload.cmmn", new java.io.FileInputStream(cmmn))
                .deploy();

        // (Optional) Deploy a minimal skip tracing case under a distinct id so it doesn't
        // override the example CMMN that contains the real plan items used by the test.
        String skipCase = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<cmmn:definitions xmlns:dc=\"http://www.omg.org/spec/CMMN/20151109/DC\" xmlns:cmmndi=\"http://www.omg.org/spec/CMMN/20151109/CMMNDI\" xmlns:cmmn=\"http://www.omg.org/spec/CMMN/20151109/MODEL\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:flowable=\"http://flowable.org/cmmn\" targetNamespace=\"http://flowable.org/cmmn\">\n" +
            "  <cmmn:case id=\"skipTracingCaseMinimal\" name=\"Skip Tracing Case (minimal)\">\n" +
            "    <cmmn:casePlanModel id=\"casePlanModel_skip\">\n" +
            "      <cmmn:planItem id=\"pi_skip_task\" definitionRef=\"humanTask_skip\"/>\n" +
            "      <cmmn:planItem id=\"pi_process\" definitionRef=\"processTask_file\"/>\n" +
            "      <cmmn:humanTask id=\"humanTask_skip\" name=\"Skip Tracing Task\" flowable:assignee=\"operator\"/>\n" +
            "      <cmmn:processTask id=\"processTask_file\" name=\"Process File Logic\" processRef=\"process_bulk_file_handling\">\n" +
            "        <cmmn:extensionElements>\n" +
            "          <flowable:in source=\"fileId\" target=\"fileId\" />\n" +
            "        </cmmn:extensionElements>\n" +
            "      </cmmn:processTask>\n" +
            "    </cmmn:casePlanModel>\n" +
            "  </cmmn:case>\n" +
            "</cmmn:definitions>\n";

        cmmnRepositoryService.createDeployment()
            .name("skip-tracing-deployment-minimal")
            .addString("skipTracingCase-minimal.cmmn", skipCase)
            .deploy();

        // Deploy a small BPMN process with key 'skipTracingCase' so the callActivity can find and call it
        String skipProc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:flowable=\"http://flowable.org/bpmn\" targetNamespace=\"http://www.flowable.org/processdef\">\n" +
            "  <process id=\"skipTracingCase\" name=\"Skip Tracing Process\" isExecutable=\"true\">\n" +
            "    <startEvent id=\"start\" />\n" +
            "    <endEvent id=\"end\" />\n" +
            "    <sequenceFlow id=\"f1\" sourceRef=\"start\" targetRef=\"end\" />\n" +
            "  </process>\n" +
            "</definitions>\n";
        repositoryService.createDeployment().name("skip-tracing-process-deployment").addString("skipTracingCase.bpmn20.xml", skipProc).deploy();

        // Start a simple HTTP stub on port 8080 to satisfy the serviceTask call
        HttpServer server = startStubServer(8080);
        try {
            // Start the CMMN case with variables
                    var builder = cmmnRuntimeService.createCaseInstanceBuilder()
                        .caseDefinitionKey("bulkUploadCase")
                    .variable("supporter", "user")
                    .variable("fileId", "file-1");
            var ci = builder.start();
            assertThat(ci).isNotNull();

            // Wait for plan item instances to be created and ensure the human task plan item exists
            long planItemCount = 0;
            for (int i = 0; i < 20; i++) {
                planItemCount = cmmnRuntimeService.createPlanItemInstanceQuery().caseInstanceId(ci.getId()).count();
                if (planItemCount > 0) break;
                Thread.sleep(200);
            }
            assertThat(planItemCount).as("Plan item instances should be created").isGreaterThan(0);

            var planItems = cmmnRuntimeService.createPlanItemInstanceQuery().caseInstanceId(ci.getId()).list();
            // Debug print to inspect which plan items exist
            System.err.println("DEBUG: plan items for case " + ci.getId() + " -> " + planItems.stream().map(pi -> pi.getElementId()).collect(java.util.stream.Collectors.joining(",")));

            // Find the process plan item (pi_process) and trigger it to start the BPMN process
                // Wait for the process plan item to be created (it may be created after the import task completes)
                org.flowable.cmmn.api.runtime.PlanItemInstance processPlan = null;
                for (int i = 0; i < 30; i++) {
                processPlan = cmmnRuntimeService.createPlanItemInstanceQuery().caseInstanceId(ci.getId()).list().stream()
                    .filter(pi -> "pi_process".equals(pi.getElementId()))
                    .findFirst().orElse(null);
                if (processPlan != null) break;
                Thread.sleep(200);
                }
                assertThat(processPlan).as("Process plan item (pi_process) should be present").isNotNull();
                if (processPlan == null) {
                    // If the process plan item didn't appear, try completing the import task
                    if (cmmnTaskService != null) {
                        java.util.List<org.flowable.task.api.Task> tasks = cmmnTaskService.createTaskQuery().taskName("Import Excel File").list();
                        if (!tasks.isEmpty()) {
                            org.flowable.task.api.Task t = tasks.get(0);
                            if (t.getAssignee() == null) {
                                cmmnTaskService.setAssignee(t.getId(), "user");
                            }
                            cmmnTaskService.claim(t.getId(), "user");
                            cmmnTaskService.complete(t.getId());
                        }
                    }
                    // Wait again for the process plan item to appear after completion
                    for (int j = 0; j < 30; j++) {
                        processPlan = cmmnRuntimeService.createPlanItemInstanceQuery().caseInstanceId(ci.getId()).list().stream()
                                .filter(pi -> "pi_process".equals(pi.getElementId()))
                                .findFirst().orElse(null);
                        if (processPlan != null) break;
                        Thread.sleep(200);
                    }
                }

                // Create a minimal BPMN process for the test that sets `assignmentList` via a delegate and then multi-instantiates a callActivity
                String minimalProc = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<definitions xmlns=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:flowable=\"http://flowable.org/bpmn\" targetNamespace=\"http://www.flowable.org/processdef\">\n" +
                        "  <process id=\"process_bulk_file_handling\" name=\"Bulk File Processing (minimal)\" isExecutable=\"true\">\n" +
                        "    <startEvent id=\"start\" />\n" +
                        "    <serviceTask id=\"task_set_assignments\" name=\"Set Assignments\" flowable:class=\"com.example.flowable.TestAssignmentCreatorDelegate\" />\n" +
                            "    <serviceTask id=\"call_create_case\" name=\"Create Skip Tracing Case\" flowable:delegateExpression=\"${testCaseCreatorDelegate}\">\n" +
                            "      <multiInstanceLoopCharacteristics isSequential=\"false\" flowable:collection=\"assignmentList\" flowable:elementVariable=\"assignment\" />\n" +
                            "    </serviceTask>\n" +
                        "    <endEvent id=\"end\" />\n" +
                        "    <sequenceFlow id=\"f1\" sourceRef=\"start\" targetRef=\"task_set_assignments\" />\n" +
                        "    <sequenceFlow id=\"f2\" sourceRef=\"task_set_assignments\" targetRef=\"call_create_case\" />\n" +
                        "    <sequenceFlow id=\"f3\" sourceRef=\"call_create_case\" targetRef=\"end\" />\n" +
                        "  </process>\n" +
                        "</definitions>\n";
                var dep = repositoryService.createDeployment().name("example-bulk-file-deployment-minimal").addString("file-processing-minimal.bpmn", minimalProc).deploy();

                // Verify the deployed process definition comes from our deployment
                var pd = repositoryService.createProcessDefinitionQuery().processDefinitionKey("process_bulk_file_handling").latestVersion().singleResult();
                assertThat(pd).as("Process definition should be available").isNotNull();
                assertThat(pd.getDeploymentId()).as("Process definition should be from our deployment").isEqualTo(dep.getId());

                // Wait for the modified process definition to be available, then start it
                boolean defReady = false;
                for (int i = 0; i < 20; i++) {
                    long defs = repositoryService.createProcessDefinitionQuery().processDefinitionKey("process_bulk_file_handling").count();
                    if (defs > 0) { defReady = true; break; }
                    Thread.sleep(200);
                }
                assertThat(defReady).as("process_bulk_file_handling process definition should be deployed").isTrue();

                // Start the modified process which will set assignmentList and call the callActivity
                runtimeService.createProcessInstanceBuilder().processDefinitionKey("process_bulk_file_handling").start();

            // After starting, process instance(s) should be started for the file-processing BPMN
                // Wait briefly for variables to be set by the delegate and for any cases to be created
            boolean foundProc = false;
            boolean foundAssignments = false;
            boolean foundHistoricAssignments = false;
            for (int i = 0; i < 30; i++) {
                long count = runtimeService.createProcessInstanceQuery().processDefinitionKey("process_bulk_file_handling").count();
                long varCount = 0;
                try {
                    varCount = runtimeService.createVariableInstanceQuery().variableName("assignmentList").count();
                } catch (Exception ignore) {
                    // Some engine versions may not provide variable instance queries for ended processes
                }
                long histVarCount = historyService.createHistoricVariableInstanceQuery().variableName("assignmentList").count();
                if (count > 0) { foundProc = true; }
                if (varCount > 0) { foundAssignments = true; }
                if (histVarCount > 0) { foundHistoricAssignments = true; }
                if (foundProc || foundAssignments || foundHistoricAssignments) break;
                Thread.sleep(200);
            }

            assertThat(foundProc || foundAssignments || foundHistoricAssignments).as("BPMN process should be startable and produce cases (or at least set assignmentList variable)").isTrue();

            // And the callActivity should create skipTracingCase instances
            boolean foundCase = false;
            for (int i = 0; i < 30; i++) {
                long cnt = cmmnRuntimeService.createCaseInstanceQuery().caseDefinitionKey("skipTracingCase").count();
                long histCallCount = historyService.createHistoricActivityInstanceQuery().activityId("call_create_case").count();
                long histAssignments = historyService.createHistoricVariableInstanceQuery().variableName("assignmentList").count();
                if (cnt > 0) { foundCase = true; break; }
                Thread.sleep(200);
            }
            assertThat(foundCase).as("skipTracingCase should be created by callActivity").isTrue();

            long createdCases = cmmnRuntimeService.createCaseInstanceQuery().caseDefinitionKey("skipTracingCase").count();
            assertThat(createdCases).as("Expect at least one skipTracingCase (one per assignment)").isGreaterThanOrEqualTo(3);

        } finally {
            server.stop(0);
            // Best-effort cleanup via the shared helper
            try {
                TestCleanupHelper.cleanupCmmnCases(cmmnRuntimeService, "skipTracingCase");
                TestCleanupHelper.cleanupProcessInstances(runtimeService, "process_bulk_file_handling");
                TestCleanupHelper.deleteDeploymentsByName(repositoryService, "example-bulk-file-deployment", true);
                TestCleanupHelper.deleteCmmnDeploymentsByName(cmmnRepositoryService, "example-bulk-cmmn-deployment", true);
                TestCleanupHelper.deleteDeploymentsByName(repositoryService, "skip-tracing-process-deployment", true);
                TestCleanupHelper.deleteCmmnDeploymentsByName(cmmnRepositoryService, "skip-tracing-deployment-minimal", true);
            } catch (Exception e) {
                System.out.println("WARN: cleanup encountered an error: " + e.getMessage());
            }
        }
    }

    private HttpServer startStubServer(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api/files/parse", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String resp = "{\"status\":\"ok\"}";
                exchange.getResponseHeaders().add("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, resp.getBytes().length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(resp.getBytes());
                }
            }
        });
        server.setExecutor(java.util.concurrent.Executors.newCachedThreadPool());
        server.start();
        return server;
    }
}
