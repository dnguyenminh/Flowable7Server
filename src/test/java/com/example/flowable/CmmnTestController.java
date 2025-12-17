package com.example.flowable;

import org.flowable.cmmn.engine.CmmnEngine;
import org.flowable.cmmn.engine.CmmnEngineConfiguration;
import org.flowable.cmmn.engine.impl.cfg.StandaloneInMemCmmnEngineConfiguration;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/case")
public class CmmnTestController {

    @Autowired
    DataSource dataSource;

    @Autowired
    TaskService taskService;

    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> start(@RequestBody(required = false) Map<String, String> body) {
        String key = (body != null && body.get("key") != null) ? body.get("key") : "simpleCase";

        CmmnEngineConfiguration cfg = CmmnEngineConfiguration.createStandaloneInMemCmmnEngineConfiguration();
        cfg.setDataSource(dataSource);
        cfg.setDisableCmmnXmlValidation(true);
        CmmnEngine cmmnEngine = cfg.buildCmmnEngine();

        cmmnEngine.getCmmnRepositoryService().createDeployment().addClasspathResource("cases/simple-case.cmmn").deploy();

        var ci = cmmnEngine.getCmmnRuntimeService().createCaseInstanceBuilder().caseDefinitionKey(key).start();

        List<?> tasks = taskService.createTaskQuery().caseInstanceId(ci.getId()).list();

        Map<String, Object> result = new HashMap<>();
        result.put("caseInstanceId", ci.getId());
        result.put("tasks", tasks);

        return ResponseEntity.ok(result);
    }
}
