package com.example.flowable;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class BpmnTaskActionsTest {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;

    @Test
    void claimAssignAndCompleteTask() {
        var pi = runtimeService.startProcessInstanceByKey("simpleProcess");
        var task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        assertThat(task).isNotNull();

        taskService.claim(task.getId(), "jdoe");
        Task afterClaim = taskService.createTaskQuery().taskId(task.getId()).singleResult();
        assertThat(afterClaim.getAssignee()).isEqualTo("jdoe");

        taskService.setOwner(task.getId(), "owner1");
        Task afterOwner = taskService.createTaskQuery().taskId(task.getId()).singleResult();
        assertThat(afterOwner.getOwner()).isEqualTo("owner1");

        taskService.complete(task.getId());
        Task finished = taskService.createTaskQuery().taskId(task.getId()).singleResult();
        assertThat(finished).isNull();
    }
}
