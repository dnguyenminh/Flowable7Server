package com.example.flowable;

import org.flowable.dmn.api.DmnDecisionService;
import org.flowable.dmn.engine.DmnEngine;
import org.flowable.dmn.engine.impl.cfg.StandaloneInMemDmnEngineConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class DmnIntegrationTest {

    @Test
    void evaluateDecisionTable() {
        // Build a lightweight in-memory DMN engine for this test
        StandaloneInMemDmnEngineConfiguration cfg = new StandaloneInMemDmnEngineConfiguration();
        // create DB schema automatically for the in-memory DMN engine
        cfg.setDatabaseSchemaUpdate("create-drop");
        DmnEngine dmnEngine = cfg.buildDmnEngine();
        // deploy decision from test resources
        dmnEngine.getDmnRepositoryService().createDeployment().addClasspathResource("decisions/simple-decision.dmn").deploy();
        DmnDecisionService decisionService = dmnEngine.getDmnDecisionService();

        Map<String, Object> variables = new HashMap<>();
        variables.put("age", 20);

        var result = decisionService.createExecuteDecisionBuilder().decisionKey("isAdult").variables(variables).execute();

        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
        assertThat(result.get(0).get("adult")).isEqualTo(true);
    }
}
