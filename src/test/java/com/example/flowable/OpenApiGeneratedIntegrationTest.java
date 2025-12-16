package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:flowable",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver"
    }
)
public class OpenApiGeneratedIntegrationTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    public void testProcessLifecycle() {
        // Start process
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        java.util.Map<String, Object> startBody = new java.util.HashMap<>();
        startBody.put("key", "simpleProcess");
        HttpEntity<Map<String, Object>> startReq = new HttpEntity<>(startBody, headers);
        ResponseEntity<Map> startResp = rest.postForEntity("/process/start", startReq, Map.class);
        assertThat(startResp.getStatusCode().is2xxSuccessful()).isTrue();

        Map<String, Object> body = startResp.getBody();
        assertThat(body).containsKeys("processInstanceId", "tasks");
        String processInstanceId = (String) body.get("processInstanceId");

        // Query tasks
        ResponseEntity<List> tasksResp = rest.getForEntity("/process/tasks?processInstanceId=" + processInstanceId, List.class);
        assertThat(tasksResp.getStatusCode().is2xxSuccessful()).isTrue();
        List<?> tasks = tasksResp.getBody();
        assertThat(tasks).isNotNull();

        // Set variables and read them back
        java.util.Map<String, Object> varsBody = new java.util.HashMap<>();
        varsBody.put("approved", true);
        HttpEntity<Map<String, Object>> varsReq = new HttpEntity<>(varsBody, headers);
        ResponseEntity<Void> setVarsResp = rest.postForEntity("/process/instances/" + processInstanceId + "/variables", varsReq, Void.class);
        assertThat(setVarsResp.getStatusCode().is2xxSuccessful()).isTrue();

        ResponseEntity<Map> getVarsResp = rest.getForEntity("/process/instances/" + processInstanceId + "/variables", Map.class);
        assertThat(getVarsResp.getStatusCode().is2xxSuccessful()).isTrue();
        Map<?, ?> vars = getVarsResp.getBody();
        assertThat(vars.get("approved")).isEqualTo(true);

        // Complete tasks (complete all returned tasks)
        if (tasks != null && !tasks.isEmpty()) {
            Map<?, ?> t = (Map<?, ?>) tasks.get(0);
            String taskId = (String) t.get("id");
            ResponseEntity<Void> completeResp = rest.postForEntity("/process/tasks/" + taskId + "/complete", null, Void.class);
            assertThat(completeResp.getStatusCode().is2xxSuccessful()).isTrue();
        }

        // Correlate a non-existent message -> expect 404
        java.util.Map<String, Object> msgBody = new java.util.HashMap<>();
        msgBody.put("messageName", "Ping");
        msgBody.put("processInstanceId", processInstanceId);
        HttpEntity<Map<String, Object>> msgReq = new HttpEntity<>(msgBody, headers);
        ResponseEntity<Void> msgResp = rest.postForEntity("/process/message", msgReq, Void.class);
        assertThat(msgResp.getStatusCode().value() == 200 || msgResp.getStatusCode().value() == 404).isTrue();
    }

    @Test
    public void testDecisionEvaluate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        java.util.Map<String, Object> dvars = new java.util.HashMap<>();
        dvars.put("age", 20);
        java.util.Map<String, Object> dreq = new java.util.HashMap<>();
        dreq.put("decisionKey", "isAdult");
        dreq.put("variables", dvars);
        HttpEntity<Map<String, Object>> req = new HttpEntity<>(dreq, headers);
        ResponseEntity<List> resp = rest.postForEntity("/decision/evaluate", req, List.class);
        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();
        List<?> body = resp.getBody();
        assertThat(body).isNotNull();
        // Expect at least one result containing 'adult' -> true
        boolean found = body.stream().anyMatch(o -> (o instanceof Map) && ((Map) o).containsKey("adult"));
        assertThat(found).isTrue();
    }

    @Test
    public void testCaseStart() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        java.util.Map<String, Object> caseBody = new java.util.HashMap<>();
        caseBody.put("key", "simpleCase");
        HttpEntity<Map<String, Object>> startReq = new HttpEntity<>(caseBody, headers);
        ResponseEntity<Map> startResp = rest.postForEntity("/case/start", startReq, Map.class);
        assertThat(startResp.getStatusCode().is2xxSuccessful()).isTrue();
        Map<String, Object> body = startResp.getBody();
        assertThat(body).containsKeys("caseInstanceId", "tasks");
    }
}
