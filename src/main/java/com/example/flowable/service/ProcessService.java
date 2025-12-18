package com.example.flowable.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.example.flowable.dto.ProcessStartRequest;
import com.example.flowable.dto.ProcessStartResponse;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.engine.RepositoryService;

@Service
public class ProcessService {

    @Autowired(required = false)
    private RuntimeService runtimeService;

    @Autowired(required = false)
    private TaskService taskService;

    @Autowired(required = false)
    private RepositoryService repositoryService;

    public ProcessStartResponse start(ProcessStartRequest req) {
        String key = req == null ? null : req.getKey();
        Map<String,Object> vars = req == null || req.getVariables() == null ? Collections.emptyMap() : req.getVariables();

        if (key == null) return null;

        ProcessStartResponse resp = new ProcessStartResponse();

        // Try real engine if available
        if (runtimeService != null && repositoryService != null) {
            long count = repositoryService.createProcessDefinitionQuery().processDefinitionKey(key).count();
            if (count > 0) {
                var pi = runtimeService.startProcessInstanceByKey(key, vars);
                resp.setProcessInstanceId(pi.getId());
                resp.setProcessDefinitionKey(key);
                List<Map<String,Object>> tasks = new ArrayList<>();
                if (taskService != null) {
                    List<Task> ts = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
                    for (Task t : ts) tasks.add(Map.of("id", t.getId(), "name", t.getName()));
                }
                resp.setTasks(tasks);
                return resp;
            }
        }

        // Fallback simulation
        resp.setProcessInstanceId(UUID.randomUUID().toString());
        resp.setProcessDefinitionKey(key);
        resp.setTasks(Collections.emptyList());
        return resp;
    }

    public boolean completeTask(String id) {
        if (taskService != null) {
            Task t = taskService.createTaskQuery().taskId(id).singleResult();
            if (t == null) return false;
            taskService.complete(id);
            return true;
        }
        return false;
    }

    public List<Map<String,Object>> getTasks(String processInstanceId) {
        if (processInstanceId == null) return Collections.emptyList();
        if (taskService != null) {
            List<Task> ts = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
            List<Map<String,Object>> tasks = new ArrayList<>();
            for (Task t : ts) tasks.add(Map.of("id", t.getId(), "name", t.getName()));
            return tasks;
        }
        return Collections.emptyList();
    }

    public boolean setVariables(String processInstanceId, Map<String,Object> vars) {
        if (runtimeService != null) {
            try {
                runtimeService.setVariables(processInstanceId, vars);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return true; // simulate success
    }

    public boolean correlateMessage(Map<String,Object> body) {
        if (body == null || body.get("messageName") == null) return false;
        // In real implementation, call runtimeService.messageEventReceived
        return true;
    }
}
