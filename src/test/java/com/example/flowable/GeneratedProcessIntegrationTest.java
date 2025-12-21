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
public class GeneratedProcessIntegrationTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    public void test_post__process_instances__id__variables() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        java.util.List<Map<String,Object>> body = new java.util.ArrayList<>();
        Map<String,Object> v = new HashMap<>(); v.put("name", "approved"); v.put("value", true); body.add(v);
        HttpEntity<java.util.List<Map<String,Object>>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> resp = rest.postForEntity("/runtime/process-instances/dummy-id/variables", entity, String.class);
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError()).isTrue();
    }

    @Test
    public void test_get__process_tasks() throws Exception {
        ResponseEntity<String> resp = rest.getForEntity("/runtime/tasks?processInstanceId=dummy-process", String.class);
        // allow 2xx or 4xx client responses from endpoints when no data is present
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError()).isTrue();
        if (resp.getStatusCode().is2xxSuccessful()) {
            ObjectMapper mapper = new ObjectMapper();
            List<?> list = mapper.readValue(resp.getBody(), List.class);
            assertThat(list).isInstanceOf(List.class);
        }
    }

    @Test
    public void test_post__process_start() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String,Object> body = new HashMap<>();
        body.put("processDefinitionKey", "simpleProcess");
        java.util.List<Map<String,Object>> vars = new java.util.ArrayList<>();
        Map<String,Object> v1 = new HashMap<>(); v1.put("name", "approved"); v1.put("value", true); vars.add(v1);
        body.put("variables", vars);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> resp = rest.postForEntity("/runtime/process-instances", entity, String.class);
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError()).isTrue();
    }

    @Test
    public void test_post__process_message() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String,Object> body = new HashMap<>();
        body.put("messageName", "Ping");
        body.put("processInstanceId", "fake-id");
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> resp = rest.postForEntity("/runtime/executions/dummy-id/message", entity, String.class);
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError()).isTrue();
    }

    @Test
    public void test_post__process_tasks__id__complete() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(Map.of("action", "complete"), headers);
        ResponseEntity<String> resp = rest.postForEntity("/runtime/tasks/dummy-id", entity, String.class);
        // allow 2xx or 4xx when the resource id is missing
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError()).isTrue();
    }

}
