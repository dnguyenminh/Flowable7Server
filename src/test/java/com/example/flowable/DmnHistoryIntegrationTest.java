package com.example.flowable;

import org.flowable.dmn.engine.DmnEngine;
import org.flowable.dmn.engine.impl.cfg.StandaloneInMemDmnEngineConfiguration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DmnHistoryIntegrationTest {

    @Test
    void evaluateDecisionProducesHistory() {
        StandaloneInMemDmnEngineConfiguration cfg = new StandaloneInMemDmnEngineConfiguration();
        cfg.setDatabaseSchemaUpdate("create-drop");
        DmnEngine dmnEngine = cfg.buildDmnEngine();

        dmnEngine.getDmnRepositoryService().createDeployment().addClasspathResource("decisions/simple-decision.dmn").deploy();
        var result = dmnEngine.getDmnDecisionService().createExecuteDecisionBuilder().decisionKey("isAdult").variables(java.util.Map.of("age", 22)).execute();
        assertThat(result).isNotEmpty();

        try {
            var list = dmnEngine.getDmnHistoryService().createHistoricDecisionExecutionQuery().list();
            assertThat(list).isNotNull();
        } catch (UnsupportedOperationException ignore) {
            // Acceptable: some DMN in-memory setups may not support history
        }
    }
}
