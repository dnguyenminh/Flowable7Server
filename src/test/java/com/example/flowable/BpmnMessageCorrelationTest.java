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
public class BpmnMessageCorrelationTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    void correlateMessageToInstance() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"key\":\"messageProcess\"}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> resp = rest.postForEntity("/process/start", request, Map.class);
        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();
        Map<String, Object> result = resp.getBody();
        String processInstanceId = (String) result.get("processInstanceId");

        // complete the 'Before Message' task so execution reaches the catch event
        var tasks = rest.getForEntity("/process/tasks?processInstanceId=" + processInstanceId, java.util.List.class);
        assertThat(tasks.getBody()).isNotNull();
        if (!tasks.getBody().isEmpty()) {
            Map<?,?> task = (Map<?,?>) tasks.getBody().get(0);
            rest.postForEntity("/process/tasks/" + task.get("id") + "/complete", null, Void.class);
        }

        // correlate the message
        String msgBody = "{\"messageName\":\"ContinueMessage\", \"processInstanceId\": \"" + processInstanceId + "\"}";
        HttpEntity<String> msgReq = new HttpEntity<>(msgBody, headers);
        ResponseEntity<Void> msgResp = rest.postForEntity("/process/message", msgReq, Void.class);
        assertThat(msgResp.getStatusCode().is2xxSuccessful()).isTrue();

        // after correlation, 'After Message' task should be present
        var after = rest.getForEntity("/process/tasks?processInstanceId=" + processInstanceId, java.util.List.class);
        assertThat(after.getBody()).isNotNull();
        assertThat(after.getBody().size()).isGreaterThanOrEqualTo(1);
    }
}
