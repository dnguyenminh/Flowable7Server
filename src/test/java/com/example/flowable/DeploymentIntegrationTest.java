package com.example.flowable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.io.FileSystemResource;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:flowable",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver",
        // disable CMMN auto-deploy during this test to avoid parsing issues with sample CMMN files
        "flowable.cmmn.enabled=false"
    }
)
public class DeploymentIntegrationTest {

    @Autowired
    TestRestTemplate rest;

    @Autowired
    RepositoryService repositoryService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test_deploy_examples_and_verify_definitions() throws Exception {
        File bpmn = new File("examples/resources/simpleProcess.bpmn");
        assertThat(bpmn).exists();

        // Use engine RepositoryService to deploy BPMN programmatically in the test
        Deployment deployment = repositoryService.createDeployment()
                .name("example-test-deployment")
                .addInputStream("simpleProcess.bpmn", new java.io.FileInputStream(bpmn))
                .deploy();

        assertThat(deployment).isNotNull();
        String deployId = deployment.getId();
        assertThat(deployId).isNotBlank();

        // verify process definitions exist for this deployment via engine API
        java.util.List<ProcessDefinition> defs = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).list();
        assertThat(defs).isNotEmpty();
        boolean found = defs.stream().anyMatch(d -> "simpleProcess".equals(d.getKey()));
        assertThat(found).isTrue();
    }
}
