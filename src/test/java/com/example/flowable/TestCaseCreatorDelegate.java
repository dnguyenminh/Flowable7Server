package com.example.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("testCaseCreatorDelegate")
public class TestCaseCreatorDelegate implements JavaDelegate {

    @Autowired(required = false)
    protected CmmnRuntimeService cmmnRuntimeService;

    @Override
    public void execute(DelegateExecution execution) {
        @SuppressWarnings("unchecked")
        Map<String, Object> assignment = (Map<String, Object>) execution.getVariable("assignment");
        if (assignment == null) {
            return;
        }

        String cif = (String) assignment.get("cif");
        String operator = (String) assignment.get("operator");
        String personId = (String) assignment.get("personId");

        if (cmmnRuntimeService == null) {
            // CMMN engine not present in this configuration; skip creating cases
            return;
        }

        cmmnRuntimeService.createCaseInstanceBuilder()
            .caseDefinitionKey("skipTracingCase")
            .businessKey(cif)
            .variable("cif", cif)
            .variable("assignedOperator", operator)
            .variable("personId", personId)
            .start();
    }
}
