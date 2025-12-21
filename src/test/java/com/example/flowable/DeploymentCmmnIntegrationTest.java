package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

import org.flowable.cmmn.api.CmmnRepositoryService;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.flowable.cmmn.api.repository.CaseDefinition;
import org.flowable.cmmn.api.runtime.CaseInstance;
import org.flowable.cmmn.api.runtime.PlanItemInstance;
import org.flowable.cmmn.api.runtime.PlanItemDefinitionType;
import org.flowable.cmmn.api.CmmnTaskService;
import org.flowable.task.api.Task;
import org.flowable.cmmn.api.CmmnHistoryService;
import org.flowable.task.api.history.HistoricTaskInstance;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:flowable",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver",
        // Re-enable CMMN engine to validate the new compliant sample
        "flowable.cmmn.enabled=true"
    }
)
public class DeploymentCmmnIntegrationTest {

    @Autowired(required = false)
    CmmnRepositoryService cmmnRepositoryService;

    @Autowired(required = false)
    CmmnRuntimeService cmmnRuntimeService;

    @Autowired(required = false)
    CmmnTaskService cmmnTaskService;

    @Autowired(required = false)
    CmmnHistoryService cmmnHistoryService;

    

    

    @Test
    public void test_deploy_cmmn_and_verify_case_definition() throws Exception {
        // Use the new minimal, Flowable-compliant sample
        File cmmn = new File("examples/resources/simpleCase-valid.cmmn");
        assertThat(cmmn).exists();

        var deployment = cmmnRepositoryService.createDeployment()
            .name("example-cmmn-deployment")
            .addInputStream("simpleCase.cmmn", new java.io.FileInputStream(cmmn))
            .deploy();

        assertThat(deployment).isNotNull();
        String deployId = deployment.getId();
        assertThat(deployId).isNotBlank();

        java.util.List<CaseDefinition> defs = cmmnRepositoryService.createCaseDefinitionQuery().deploymentId(deployId).list();
        assertThat(defs).isNotEmpty();
        boolean found = defs.stream().anyMatch(d -> "simpleCase".equals(d.getKey()));
        assertThat(found).isTrue();

        // Start a case instance using runtime service
        CaseInstance ci = cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey("simpleCase").start();
        assertThat(ci).isNotNull();
        assertThat(ci.getId()).isNotBlank();

        // Wait for the plan item instance(s) to be created at runtime (small poll loop)
        long planItemCount = 0;
        for (int i = 0; i < 10; i++) {
            planItemCount = cmmnRuntimeService.createPlanItemInstanceQuery().caseInstanceId(ci.getId()).count();
            if (planItemCount > 0) {
                break;
            }
            Thread.sleep(200);
        }
        assertThat(planItemCount).as("Plan item instances should be created after starting the case").isGreaterThan(0);

        // Inspect plan item instances to ensure the human task plan item was instantiated
        java.util.List<PlanItemInstance> planItems = cmmnRuntimeService.createPlanItemInstanceQuery().caseInstanceId(ci.getId()).list();
        assertThat(planItems).isNotEmpty();
        boolean humanTaskTypeFound = planItems.stream().anyMatch(pi ->
            PlanItemDefinitionType.HUMAN_TASK.equals(pi.getPlanItemDefinitionType()) ||
            "humanTaskDef".equals(pi.getElementId())
        );
        assertThat(humanTaskTypeFound).as(() -> "No human task plan item found; plan items: " +
            planItems.stream().map(pi -> String.format("[id=%s,elementId=%s,type=%s,assignee=%s,refId=%s,refType=%s]",
                pi.getId(), pi.getElementId(), pi.getPlanItemDefinitionType(), pi.getAssignee(), pi.getReferenceId(), pi.getReferenceType())).collect(java.util.stream.Collectors.joining(", ")))
            .isTrue();

        // If CMMN task service is available, assert a Task was created for the human task
        if (cmmnTaskService != null) {
            java.util.List<Task> tasks = java.util.Collections.emptyList();
            for (int i = 0; i < 10; i++) {
                tasks = cmmnTaskService.createTaskQuery().taskName("User Task").list();
                if (!tasks.isEmpty()) {
                    break;
                }
                Thread.sleep(200);
            }
            assertThat(tasks).as("A user task should have been created by the case via CMMN task service").isNotEmpty();

            // Pick the first task and verify assignment/claim/complete lifecycle
            Task task = tasks.get(0);
            assertThat(task.getName()).isEqualTo("User Task");
            String taskId = task.getId();

            // Ensure an assignee exists; if not, set it and re-query
            String assignee = task.getAssignee();
            if (assignee == null) {
                cmmnTaskService.setAssignee(taskId, "user");
                // re-fetch task
                Task updated = cmmnTaskService.createTaskQuery().taskId(taskId).singleResult();
                assertThat(updated).isNotNull();
                assertThat(updated.getAssignee()).as("Assignee should be set to 'user'").isEqualTo("user");
            }

            // Claim the task as 'user' and verify
            cmmnTaskService.claim(taskId, "user");
            Task claimed = cmmnTaskService.createTaskQuery().taskId(taskId).singleResult();
            assertThat(claimed).isNotNull();
            assertThat(claimed.getAssignee()).isEqualTo("user");

            // Complete the task and verify it no longer exists (record completedBy)
            cmmnTaskService.complete(taskId, "user");
            // small poll to ensure completion processed
            Task afterComplete = null;
            for (int i = 0; i < 10; i++) {
                afterComplete = cmmnTaskService.createTaskQuery().taskId(taskId).singleResult();
                if (afterComplete == null) {
                    break;
                }
                Thread.sleep(200);
            }
            assertThat(afterComplete).as("Task should be completed and removed").isNull();

            // Verify historic task entry exists and records completion
            if (cmmnHistoryService != null) {
                HistoricTaskInstance hist = null;
                for (int i = 0; i < 10; i++) {
                    hist = cmmnHistoryService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
                    if (hist != null && hist.getEndTime() != null) {
                        break;
                    }
                    Thread.sleep(200);
                }
                assertThat(hist).as("Historic task entry should exist after completion").isNotNull();
                assertThat(hist.getEndTime()).as("Historic task should have an end time after completion").isNotNull();
                // completedBy should be the user who claimed/completed
                assertThat(hist.getCompletedBy()).isEqualTo("user");
            }
        }
    }
}
