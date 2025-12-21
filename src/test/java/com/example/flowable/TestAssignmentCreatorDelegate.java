package com.example.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAssignmentCreatorDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        List<Map<String, Object>> assignments = new ArrayList<>();

        Map<String, Object> a1 = new HashMap<>();
        a1.put("cif", "123");
        a1.put("personId", "P1");
        a1.put("operator", "user1");
        assignments.add(a1);

        Map<String, Object> a2 = new HashMap<>();
        a2.put("cif", "456");
        a2.put("personId", "P1");
        a2.put("operator", "user1");
        assignments.add(a2);

        Map<String, Object> a3 = new HashMap<>();
        a3.put("cif", "789");
        a3.put("personId", "P2");
        a3.put("operator", "user2");
        assignments.add(a3);

        execution.setVariable("assignmentList", assignments);
    }
}
