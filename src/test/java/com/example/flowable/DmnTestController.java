package com.example.flowable;

import org.flowable.dmn.engine.DmnEngine;
import org.flowable.dmn.engine.impl.cfg.StandaloneInMemDmnEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/decision")
public class DmnTestController {

    @Autowired
    DataSource dataSource;

    @PostMapping("/evaluate")
    public ResponseEntity<List<Map<String, Object>>> evaluate(@RequestBody Map<String, Object> body) {
        String decisionKey = (String) body.getOrDefault("decisionKey", "isAdult");
        Map<String, Object> variables = (Map<String, Object>) body.getOrDefault("variables", Map.of());

        StandaloneInMemDmnEngineConfiguration cfg = new StandaloneInMemDmnEngineConfiguration();
        cfg.setDataSource(dataSource);
        cfg.setDatabaseSchemaUpdate("create-drop");
        DmnEngine dmnEngine = cfg.buildDmnEngine();

        // simple deploy from test resources (idempotent in tests)
        dmnEngine.getDmnRepositoryService().createDeployment().addClasspathResource("decisions/simple-decision.dmn").deploy();

        var result = dmnEngine.getDmnDecisionService().createExecuteDecisionBuilder().decisionKey(decisionKey).variables(variables).execute();
        return ResponseEntity.ok(result);
    }
}
