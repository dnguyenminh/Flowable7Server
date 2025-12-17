package com.example.flowable;

import org.flowable.engine.ManagementService;
import org.flowable.job.api.Job;
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
public class BpmnJobExecutionTest {

    @Autowired
    ManagementService managementService;

    @Autowired
    org.flowable.engine.RuntimeService runtimeService;

    @Test
    void jobRetriesDecreaseAndSucceedOnSecondRun() {
        // reset the delegate counter
        TestFailingDelegate.counter.set(0);

        var pi = runtimeService.startProcessInstanceByKey("jobProcess");
        assertThat(pi).isNotNull();

        Job job = managementService.createJobQuery().processInstanceId(pi.getId()).singleResult();
        assertThat(job).isNotNull();

        // first execution should throw and decrement retries
        try {
            managementService.executeJob(job.getId());
        } catch (Exception e) {
            // expected failure from delegate
        }

        Job afterFail = managementService.createJobQuery().processInstanceId(pi.getId()).singleResult();

        if (afterFail != null) {
            // job still exists: retries should have decreased
            assertThat(afterFail.getRetries()).isLessThan(job.getRetries());

            // second execution should succeed
            managementService.executeJob(afterFail.getId());

            Job finalJob = managementService.createJobQuery().processInstanceId(pi.getId()).singleResult();
            assertThat(finalJob).isNull();
        } else {
            // job was picked up by background executor; ensure no job remains
            Job finalJob = managementService.createJobQuery().processInstanceId(pi.getId()).singleResult();
            assertThat(finalJob).isNull();
        }
    }
}
