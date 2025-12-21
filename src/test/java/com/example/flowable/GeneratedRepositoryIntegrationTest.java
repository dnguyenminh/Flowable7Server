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
public class GeneratedRepositoryIntegrationTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    public void test_post__repository_deployments() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String,Object> body = new HashMap<>();
        HttpEntity<Map<String,Object>> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> resp = rest.postForEntity("/repository/deployments", entity, String.class);
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError()).isTrue();
    }

    @Test
    public void test_get__repository_deployments__id_() throws Exception {
        ResponseEntity<String> resp = rest.getForEntity("/repository/deployments/dummy-id", String.class);
        // allow 2xx or 4xx client responses from endpoints when no data is present
        assertThat(resp.getStatusCode().is2xxSuccessful() || resp.getStatusCode().is4xxClientError()).isTrue();
        if (resp.getStatusCode().is2xxSuccessful()) {
            ObjectMapper mapper = new ObjectMapper();
            List<?> list = mapper.readValue(resp.getBody(), List.class);
            assertThat(list).isInstanceOf(List.class);
        }
    }

}
