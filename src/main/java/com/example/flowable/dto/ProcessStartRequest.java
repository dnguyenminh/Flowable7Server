package com.example.flowable.dto;

import java.util.Map;

public class ProcessStartRequest {
    private String key;
    private Map<String, Object> variables;

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public Map<String, Object> getVariables() { return variables; }
    public void setVariables(Map<String, Object> variables) { this.variables = variables; }
}
