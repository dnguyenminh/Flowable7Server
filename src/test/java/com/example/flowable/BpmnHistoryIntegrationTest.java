package com.example.flowable;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
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
public class BpmnHistoryIntegrationTest {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;

    @Test
    void completeTaskAndCheckHistory() {
        var pi = runtimeService.startProcessInstanceByKey("simpleProcess");
        assertThat(pi).isNotNull();

        var task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        assertThat(task).isNotNull();
        taskService.complete(task.getId());

        var histProc = historyService.createHistoricProcessInstanceQuery().processInstanceId(pi.getId()).singleResult();
        assertThat(histProc).isNotNull();
        assertThat(histProc.getEndTime()).isNotNull();

        var histTasks = historyService.createHistoricTaskInstanceQuery().processInstanceId(pi.getId()).finished().list();
        assertThat(histTasks).isNotEmpty();
    }
}
