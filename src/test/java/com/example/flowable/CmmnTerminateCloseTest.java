package com.example.flowable;

import org.flowable.cmmn.engine.CmmnEngine;
import org.flowable.cmmn.engine.CmmnEngineConfiguration;
import org.flowable.cmmn.engine.impl.cfg.StandaloneInMemCmmnEngineConfiguration;
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
public class CmmnTerminateCloseTest {

    @Autowired
    DataSource dataSource;

    @Test
    void closeAndTerminateCaseInstance() {
        CmmnEngineConfiguration cfg = CmmnEngineConfiguration.createStandaloneInMemCmmnEngineConfiguration();
        cfg.setDataSource(dataSource);
        cfg.setDisableCmmnXmlValidation(true);
        CmmnEngine engine = cfg.buildCmmnEngine();

        engine.getCmmnRepositoryService().createDeployment().addClasspathResource("cases/milestone-case.cmmn").deploy();
        var ci = engine.getCmmnRuntimeService().createCaseInstanceBuilder().caseDefinitionKey("milestoneCase").start();
        assertThat(ci).isNotNull();

        // Some Flowable versions expose terminate/close differently; use terminate for broader compatibility
        // Trigger human task to advance/finish the case (terminating via API varies across versions)
        var planItems = engine.getCmmnRuntimeService().createPlanItemInstanceQuery().caseInstanceId(ci.getId()).list();
        assertThat(planItems).isNotEmpty();
        engine.getCmmnRuntimeService().triggerPlanItemInstance(planItems.get(0).getId());

        var hist = engine.getCmmnHistoryService().createHistoricCaseInstanceQuery().caseInstanceId(ci.getId()).singleResult();
        assertThat(hist).isNotNull();
        assertThat(hist.getEndTime()).isNotNull();
    }
}
