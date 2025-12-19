package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

import org.flowable.cmmn.api.CmmnRepositoryService;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.flowable.cmmn.api.repository.CaseDefinition;
import org.flowable.cmmn.api.runtime.CaseInstance;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:flowable",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.datasource.driver-class-name=org.h2.Driver",
        // Re-enable CMMN engine to validate the new compliant sample
        "flowable.cmmn.enabled=true"
    }
)
public class DeploymentCmmnIntegrationTest {

    @Autowired(required = false)
    CmmnRepositoryService cmmnRepositoryService;

    @Autowired(required = false)
    CmmnRuntimeService cmmnRuntimeService;

    @Test
    public void test_deploy_cmmn_and_verify_case_definition() throws Exception {
        // Use the new minimal, Flowable-compliant sample
        File cmmn = new File("examples/resources/simpleCase-valid.cmmn");
        assertThat(cmmn).exists();

        var deployment = cmmnRepositoryService.createDeployment()
            .name("example-cmmn-deployment")
            .addInputStream("simpleCase.cmmn", new java.io.FileInputStream(cmmn))
            .deploy();

        assertThat(deployment).isNotNull();
        String deployId = deployment.getId();
        assertThat(deployId).isNotBlank();

        java.util.List<CaseDefinition> defs = cmmnRepositoryService.createCaseDefinitionQuery().deploymentId(deployId).list();
        assertThat(defs).isNotEmpty();
        boolean found = defs.stream().anyMatch(d -> "simpleCase".equals(d.getKey()));
        assertThat(found).isTrue();

        // Start a case instance using runtime service
        CaseInstance ci = cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey("simpleCase").start();
        assertThat(ci).isNotNull();
        assertThat(ci.getId()).isNotBlank();
    }
}
