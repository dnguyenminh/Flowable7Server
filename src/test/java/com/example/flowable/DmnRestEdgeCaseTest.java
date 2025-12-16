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
public class DmnRestEdgeCaseTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    void evaluateDecisionWithMissingInputsViaRest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{\"decisionKey\":\"isAdult\", \"variables\": {}}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Object[]> resp = rest.postForEntity("/decision/evaluate", request, Object[].class);
        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();
        Object[] result = resp.getBody();
        // engine may return empty result array or a defined fallback; assert request succeeded and response is present
        assertThat(result).isNotNull();
    }
}
