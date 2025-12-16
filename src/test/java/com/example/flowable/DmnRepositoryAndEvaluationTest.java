package com.example.flowable;

import org.flowable.dmn.api.DmnDecisionService;
import org.flowable.dmn.engine.DmnEngine;
import org.flowable.dmn.engine.impl.cfg.StandaloneInMemDmnEngineConfiguration;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DmnRepositoryAndEvaluationTest {

    @Test
    void deployAndEvaluateDecisionVariants() {
        StandaloneInMemDmnEngineConfiguration cfg = new StandaloneInMemDmnEngineConfiguration();
        cfg.setDatabaseSchemaUpdate("create-drop");
        DmnEngine dmnEngine = cfg.buildDmnEngine();

        dmnEngine.getDmnRepositoryService().createDeployment().addClasspathResource("decisions/simple-decision.dmn").deploy();
        DmnDecisionService decisionService = dmnEngine.getDmnDecisionService();

        Map<String,Object> ok = new HashMap<>();
        ok.put("age", 30);
        var res = decisionService.createExecuteDecisionBuilder().decisionKey("isAdult").variables(ok).execute();
        assertThat(res).isNotEmpty();
        assertThat(res.get(0).get("adult")).isEqualTo(true);

        Map<String,Object> missing = new HashMap<>();
        var res2 = decisionService.createExecuteDecisionBuilder().decisionKey("isAdult").variables(missing).execute();
        assertThat(res2).isNotNull();
    }
}
