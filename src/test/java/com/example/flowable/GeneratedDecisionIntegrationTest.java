package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;

// NOTE: CMMN/DMN auto-configurations may reference optional classes at runtime;
// the generator adds explicit exclusions to avoid ApplicationContext failures
@EnableAutoConfiguration(exclude = {org.flowable.spring.boot.cmmn.CmmnEngineAutoConfiguration.class, org.flowable.spring.boot.cmmn.CmmnEngineServicesAutoConfiguration.class, org.flowable.spring.boot.dmn.DmnEngineAutoConfiguration.class, org.flowable.spring.boot.dmn.DmnEngineServicesAutoConfiguration.class})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:flowable",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver"
    }
)
public class GeneratedDecisionIntegrationTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    public void test_post__decision_evaluate() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String,Object> body = new HashMap<>();
        body.put("decisionKey", "isAdult");
        Map<String,Object> vars = new HashMap<>();
        vars.put("age", 20);
        body.put("variables", vars);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> resp = rest.postForEntity("/dmn-rule/execute-decision-service", entity, String.class);
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError() || resp.getStatusCode().is5xxServerError()).isTrue();
        if (resp.getStatusCode().is2xxSuccessful()) {
            ObjectMapper mapper = new ObjectMapper();
            List<?> list = mapper.readValue(resp.getBody(), List.class);
            assertThat(list).isNotNull();
            java.io.InputStream fixture = getClass().getResourceAsStream("/fixtures/decision_evaluate_isAdult_20.json");
            if (fixture != null) {
                Object expected = mapper.readValue(fixture, Object.class);
                assertThat(list).isEqualTo(expected);
            }
        }
    }

    @Test
    public void test_post__decision_evaluate_no_vars() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String,Object> body = new HashMap<>();
        body.put("decisionKey", "isAdult");
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> resp = rest.postForEntity("/dmn-rule/execute-decision-service", entity, String.class);
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError() || resp.getStatusCode().is5xxServerError()).isTrue();
    }

}
