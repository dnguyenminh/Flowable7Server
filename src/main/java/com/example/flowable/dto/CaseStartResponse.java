package com.example.flowable.dto;

import java.util.List;
import java.util.Map;

public class CaseStartResponse {
    private String caseInstanceId;
    private List<Map<String,Object>> tasks;

    public String getCaseInstanceId() { return caseInstanceId; }
    public void setCaseInstanceId(String caseInstanceId) { this.caseInstanceId = caseInstanceId; }

    public List<Map<String,Object>> getTasks() { return tasks; }
    public void setTasks(List<Map<String,Object>> tasks) { this.tasks = tasks; }
}
