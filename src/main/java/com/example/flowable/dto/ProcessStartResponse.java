package com.example.flowable.dto;

import java.util.List;
import java.util.Map;

public class ProcessStartResponse {
    private String processInstanceId;
    private String processDefinitionKey;
    private List<Map<String,Object>> tasks;

    public String getProcessInstanceId() { return processInstanceId; }
    public void setProcessInstanceId(String processInstanceId) { this.processInstanceId = processInstanceId; }

    public String getProcessDefinitionKey() { return processDefinitionKey; }
    public void setProcessDefinitionKey(String processDefinitionKey) { this.processDefinitionKey = processDefinitionKey; }

    public List<Map<String,Object>> getTasks() { return tasks; }
    public void setTasks(List<Map<String,Object>> tasks) { this.tasks = tasks; }
}
