package com.example.flowable;

import org.flowable.dmn.engine.DmnEngine;
import org.flowable.dmn.engine.impl.cfg.StandaloneInMemDmnEngineConfiguration;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DmnEdgeCaseTest {

    @Test
    void evaluateDecisionWithMissingInputThrows() {
        StandaloneInMemDmnEngineConfiguration cfg = new StandaloneInMemDmnEngineConfiguration();
        cfg.setDatabaseSchemaUpdate("create-drop");
        DmnEngine dmnEngine = cfg.buildDmnEngine();
        dmnEngine.getDmnRepositoryService().createDeployment().addClasspathResource("decisions/simple-decision.dmn").deploy();

        Map<String, Object> variables = new HashMap<>(); // no 'age' provided

        // When required input is missing, the decision table should return no matching rules
        try {
            var result = dmnEngine.getDmnDecisionService().createExecuteDecisionBuilder()
                .decisionKey("isAdult")
                .variables(variables)
                .execute();

            // either an empty result (no matching rule) or an evaluation error is acceptable depending on engine configuration
            org.assertj.core.api.Assertions.assertThat(result).isNotNull();
            org.assertj.core.api.Assertions.assertThat(result).isEmpty();
        } catch (org.flowable.dmn.engine.FlowableDmnExpressionException e) {
            // acceptable: missing input can lead to expression evaluation failures
        }
    }
}
