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
public class BpmnVariablesRestTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    void setAndGetProcessVariables() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"key\":\"simpleProcess\"}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> resp = rest.postForEntity("/process/start", request, Map.class);
        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();
        Map<String, Object> result = resp.getBody();
        String processInstanceId = (String) result.get("processInstanceId");

        // set variables
        String vars = "{\"approved\":true, \"score\": 42}";
        HttpEntity<String> setReq = new HttpEntity<>(vars, headers);
        ResponseEntity<Void> setResp = rest.postForEntity("/process/instances/" + processInstanceId + "/variables", setReq, Void.class);
        assertThat(setResp.getStatusCode().is2xxSuccessful()).isTrue();

        // get variables
        ResponseEntity<Map> getResp = rest.getForEntity("/process/instances/" + processInstanceId + "/variables", Map.class);
        Map<String, Object> variables = getResp.getBody();
        assertThat(variables).containsEntry("approved", true);
        assertThat(variables).containsEntry("score", 42);
    }
}
