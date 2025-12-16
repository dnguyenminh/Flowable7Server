package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class ProcessMessageCorrelationRestTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    void correlateMessageToWaitingExecution() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"key\":\"messageProcess\"}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> resp = rest.postForEntity("/process/start", request, Map.class);
        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();
        Map<String, Object> result = resp.getBody();
        String processInstanceId = (String) result.get("processInstanceId");

        // complete the first task (Before Message)
        var tasks = (java.util.List<Map<String, String>>) result.get("tasks");
        assertThat(tasks).isNotEmpty();
        String taskId = tasks.get(0).get("id");
        rest.postForEntity("/process/tasks/" + taskId + "/complete", null, Void.class);

        // correlate message by calling REST endpoint
        String msgBody = String.format("{\"messageName\": \"ContinueMessage\", \"processInstanceId\": \"%s\"}", processInstanceId);
        HttpEntity<String> msgReq = new HttpEntity<>(msgBody, headers);
        ResponseEntity<Void> msgResp = rest.postForEntity("/process/message", msgReq, Void.class);
        assertThat(msgResp.getStatusCode().is2xxSuccessful()).isTrue();

        // after correlation, the 'After Message' user task should be present
        ResponseEntity<java.util.List> after = rest.getForEntity("/process/tasks?processInstanceId=" + processInstanceId, java.util.List.class);
        assertThat(after.getBody()).isNotNull();
        // expect at least one task (After Message)
        assertThat(after.getBody().size()).isGreaterThanOrEqualTo(1);
    }
}
