package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop"
    })
public class RestApiSpecIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void processStartCompleteAndVariables() {
        // start a simple process
        ResponseEntity<Map> start = restTemplate.postForEntity("/process/start", Map.of("key", "simpleProcess"), Map.class);
        assertThat(start.getStatusCode()).isEqualTo(HttpStatus.OK);
        Map body = start.getBody();
        assertThat(body).containsKey("processInstanceId");
        String pi = (String) body.get("processInstanceId");

        // set variables
        ResponseEntity<Void> setVars = restTemplate.postForEntity("/process/instances/" + pi + "/variables", Map.of("approved", true), Void.class);
        assertThat(setVars.getStatusCode()).isEqualTo(HttpStatus.OK);

        // get variables
        ResponseEntity<Map> vars = restTemplate.getForEntity("/process/instances/" + pi + "/variables", Map.class);
        assertThat(vars.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(vars.getBody()).containsEntry("approved", true);

        // get tasks for instance
        ResponseEntity<List> tasks = restTemplate.getForEntity("/process/tasks?processInstanceId=" + pi, List.class);
        assertThat(tasks.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<Map> tlist = tasks.getBody();
        assertThat(tlist).isNotNull();

        if (!tlist.isEmpty()) {
            String taskId = (String) tlist.get(0).get("id");
            // complete task
            ResponseEntity<Void> complete = restTemplate.postForEntity("/process/tasks/" + taskId + "/complete", null, Void.class);
            assertThat(complete.getStatusCode()).isEqualTo(HttpStatus.OK);
            // verify task no longer returned
            ResponseEntity<List> tasks2 = restTemplate.getForEntity("/process/tasks?processInstanceId=" + pi, List.class);
            assertThat(tasks2.getBody()).doesNotContain(tlist.get(0));
        }
    }

    @Test
    void messageCorrelationTriggersProcess() {
        // start message-process (should have message event subscription)
        ResponseEntity<Map> start = restTemplate.postForEntity("/process/start", Map.of("key", "messageProcess"), Map.class);
        assertThat(start.getStatusCode()).isEqualTo(HttpStatus.OK);
        String pi = (String) start.getBody().get("processInstanceId");

        // correlate message
        ResponseEntity<Void> corr = restTemplate.postForEntity("/process/message", Map.of("messageName", "ContinueMessage", "processInstanceId", pi), Void.class);
        assertThat(corr.getStatusCode()).isIn(HttpStatus.OK, HttpStatus.NOT_FOUND);
        // after correlation we expect tasks to reflect the new state (if any)
        ResponseEntity<List> tasks = restTemplate.getForEntity("/process/tasks?processInstanceId=" + pi, List.class);
        assertThat(tasks.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void dmnEvaluationViaRest() {
        Map<String, Object> payload = Map.of("decisionKey", "isAdult", "variables", Map.of("age", 21));
        ResponseEntity<List> eval = restTemplate.postForEntity("/decision/evaluate", payload, List.class);
        assertThat(eval.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<Map<String, Object>> result = eval.getBody();
        assertThat(result).isNotNull();
        // decision returns output 'adult' boolean
        assertThat(result.stream().anyMatch(m -> m.containsKey("adult"))).isTrue();
    }

    @Test
    void cmmnStartCaseViaRest() {
        ResponseEntity<Map> start = restTemplate.postForEntity("/case/start", Map.of("key", "simpleCase"), Map.class);
        assertThat(start.getStatusCode()).isEqualTo(HttpStatus.OK);
        Map body = start.getBody();
        assertThat(body).containsKey("caseInstanceId");
        assertThat(body).containsKey("tasks");
    }
}
