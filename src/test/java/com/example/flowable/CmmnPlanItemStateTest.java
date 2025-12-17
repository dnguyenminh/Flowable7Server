package com.example.flowable;

import org.flowable.cmmn.engine.CmmnEngine;
import org.flowable.cmmn.engine.CmmnEngineConfiguration;
import org.flowable.cmmn.engine.impl.cfg.StandaloneInMemCmmnEngineConfiguration;
import org.flowable.engine.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class CmmnPlanItemStateTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    TaskService taskService;

    @Test
    void milestoneTriggersAfterTaskCompletion() {
        CmmnEngineConfiguration cfg = CmmnEngineConfiguration.createStandaloneInMemCmmnEngineConfiguration();
        cfg.setDataSource(dataSource);
        cfg.setDisableCmmnXmlValidation(true);
        CmmnEngine engine = cfg.buildCmmnEngine();

        engine.getCmmnRepositoryService().createDeployment().addClasspathResource("cases/milestone-case.cmmn").deploy();
        var ci = engine.getCmmnRuntimeService().createCaseInstanceBuilder().caseDefinitionKey("milestoneCase").start();

        // Find a plan item instance (human task) and trigger it to simulate completion
        var planItems = engine.getCmmnRuntimeService().createPlanItemInstanceQuery().caseInstanceId(ci.getId()).list();
        assertThat(planItems).isNotEmpty();

        var humanPlanItem = planItems.stream().findFirst().orElseThrow();
        // Trigger the plan item instance (this should complete the human task and progress the case)
        engine.getCmmnRuntimeService().triggerPlanItemInstance(humanPlanItem.getId());

        var milestonesList = engine.getCmmnHistoryService().createHistoricMilestoneInstanceQuery().list();
        boolean found = milestonesList.stream().anyMatch(m -> ci.getId().equals(m.getCaseInstanceId()));
        assertThat(found).isTrue();
    }
}
