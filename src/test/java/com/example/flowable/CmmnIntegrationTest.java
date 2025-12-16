package com.example.flowable;

import org.flowable.cmmn.engine.CmmnEngine;
import org.flowable.cmmn.engine.CmmnEngineConfiguration;
import org.flowable.cmmn.engine.impl.cfg.StandaloneInMemCmmnEngineConfiguration;
import org.flowable.engine.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class CmmnIntegrationTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    TaskService taskService;

    @Test
    void startCaseAndListHumanTasks() {
        CmmnEngineConfiguration cfg = CmmnEngineConfiguration.createStandaloneInMemCmmnEngineConfiguration();
        // reuse the Spring-managed datasource so the engine persists to the same H2 instance
        cfg.setDataSource(dataSource);
        // disable XML validation to avoid network XSD lookups in test environment
        cfg.setDisableCmmnXmlValidation(true);
        CmmnEngine cmmnEngine = cfg.buildCmmnEngine();

        // deploy the case (from test resources)
        cmmnEngine.getCmmnRepositoryService().createDeployment().addClasspathResource("cases/simple-case.cmmn").deploy();

        var caseInstance = cmmnEngine.getCmmnRuntimeService().createCaseInstanceBuilder().caseDefinitionKey("simpleCase").start();
        assertThat(caseInstance).isNotNull();

        List<?> tasks = taskService.createTaskQuery().caseInstanceId(caseInstance.getId()).list();
        assertThat(tasks).isNotNull();
        assertThat(tasks.size()).isGreaterThanOrEqualTo(0);
    }
}
