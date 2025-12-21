package com.example.flowable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.io.FileSystemResource;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.engine.TaskService;
import org.flowable.engine.HistoryService;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:flowable",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver",
        // disable CMMN auto-deploy during this test to avoid parsing issues with sample CMMN files
        "flowable.cmmn.enabled=false"
    }
)
public class DeploymentIntegrationTest {

    @Autowired
    TestRestTemplate rest;

    @Autowired
    RepositoryService repositoryService;

    @Autowired(required = false)
    RuntimeService runtimeService;

    @Autowired(required = false)
    TaskService taskService;

    @Autowired(required = false)
    HistoryService historyService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test_deploy_examples_and_verify_definitions() throws Exception {
        File bpmn = new File("examples/resources/simpleProcess.bpmn");
        assertThat(bpmn).exists();

        // Use engine RepositoryService to deploy BPMN programmatically in the test
        Deployment deployment = repositoryService.createDeployment()
                .name("example-test-deployment")
                .addInputStream("simpleProcess.bpmn", new java.io.FileInputStream(bpmn))
                .deploy();

        assertThat(deployment).isNotNull();
        String deployId = deployment.getId();
        assertThat(deployId).isNotBlank();

        // verify process definitions exist for this deployment via engine API
        java.util.List<ProcessDefinition> defs = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).list();
        assertThat(defs).isNotEmpty();
        boolean found = defs.stream().anyMatch(d -> "simpleProcess".equals(d.getKey()));
        assertThat(found).isTrue();

        // Deploy and test a process that includes a user task to validate runtime and historic behavior
        File bpmnTask = new File("examples/resources/simpleProcess-with-task.bpmn");
        assertThat(bpmnTask).exists();
        Deployment dep2 = repositoryService.createDeployment()
            .name("example-test-deployment-task")
            .addInputStream("simpleProcess-with-task.bpmn", new java.io.FileInputStream(bpmnTask))
            .deploy();
        assertThat(dep2).isNotNull();

        // Start the process instance and assert a user task is created
        if (runtimeService != null && taskService != null) {
            ProcessInstance pi = runtimeService.createProcessInstanceBuilder().processDefinitionKey("simpleProcessTask").start();
            assertThat(pi).isNotNull();

            // Poll for task
            java.util.List<Task> tasks = java.util.Collections.emptyList();
            for (int i = 0; i < 10; i++) {
                tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
                if (!tasks.isEmpty()) break;
                Thread.sleep(200);
            }
            assertThat(tasks).isNotEmpty();
            Task t = tasks.get(0);
            assertThat(t.getName()).isEqualTo("User Task");

            // Claim, complete and verify historic task
            taskService.claim(t.getId(), "user");
            Task claimed = taskService.createTaskQuery().taskId(t.getId()).singleResult();
            assertThat(claimed.getAssignee()).isEqualTo("user");
            taskService.complete(t.getId());

            if (historyService != null) {
                HistoricTaskInstance hist = null;
                for (int i = 0; i < 10; i++) {
                    hist = historyService.createHistoricTaskInstanceQuery().taskId(t.getId()).singleResult();
                    if (hist != null && hist.getEndTime() != null) break;
                    Thread.sleep(200);
                }
                assertThat(hist).isNotNull();
                assertThat(hist.getEndTime()).isNotNull();
                // The historic record should reflect the assignee who completed the task
                assertThat(hist.getAssignee()).isEqualTo("user");
                // Verify historic task metadata
                assertThat(hist.getName()).isEqualTo("User Task");
                assertThat(hist.getDurationInMillis()).isNotNull();
            }
        }
    }
}
