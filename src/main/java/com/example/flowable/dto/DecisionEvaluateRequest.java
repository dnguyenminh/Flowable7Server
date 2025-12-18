package com.example.flowable.dto;

import java.util.Map;

public class DecisionEvaluateRequest {
    private String decisionKey;
    private Map<String,Object> variables;

    public String getDecisionKey() { return decisionKey; }
    public void setDecisionKey(String decisionKey) { this.decisionKey = decisionKey; }

    public Map<String,Object> getVariables() { return variables; }
    public void setVariables(Map<String,Object> variables) { this.variables = variables; }
}
