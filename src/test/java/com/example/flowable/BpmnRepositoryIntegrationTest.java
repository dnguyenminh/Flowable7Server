package com.example.flowable;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class BpmnRepositoryIntegrationTest {

    @Autowired
    RepositoryService repositoryService;

    @Test
    void deployListAndDelete() {
        Deployment dep = repositoryService.createDeployment()
                .addClasspathResource("processes/simple-process.bpmn20.xml")
                .name("testDeploy")
                .deploy();

        long defs = repositoryService.createProcessDefinitionQuery().deploymentId(dep.getId()).count();
        assertThat(defs).isGreaterThan(0);

        assertThat(repositoryService.getDeploymentResourceNames(dep.getId()))
                .anyMatch(n -> n.contains("simple-process.bpmn20.xml"));

        repositoryService.deleteDeployment(dep.getId(), true);
        long defsAfter = repositoryService.createProcessDefinitionQuery().deploymentId(dep.getId()).count();
        assertThat(defsAfter).isEqualTo(0);
    }
}
