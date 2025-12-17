package com.example.flowable;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/process")
public class ProcessTestController {

    private final RuntimeService runtimeService;
    private final TaskService taskService;

    public ProcessTestController(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> start(@RequestBody(required = false) Map<String, String> body) {
        String key = (body != null && body.get("key") != null) ? body.get("key") : "simpleProcess";
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(key);

        Map<String, Object> result = new HashMap<>();
        result.put("processInstanceId", pi.getId());
        result.put("processDefinitionKey", pi.getProcessDefinitionKey());

        List<Map<String, String>> tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list()
                .stream().map(t -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("id", t.getId());
                    m.put("name", t.getName());
                    return m;
                }).collect(Collectors.toList());

        result.put("tasks", tasks);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Map<String, String>>> tasksByQuery(@RequestParam("processInstanceId") String processInstanceId) {
        List<Map<String, String>> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list()
                .stream().map(t -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("id", t.getId());
                    m.put("name", t.getName());
                    return m;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/tasks/{id}/complete")
    public ResponseEntity<Void> completeTask(@PathVariable("id") String id) {
        taskService.complete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/instances/{id}/variables")
    public ResponseEntity<Void> setVariables(@PathVariable("id") String processInstanceId, @RequestBody Map<String, Object> vars) {
        runtimeService.setVariables(processInstanceId, vars);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/instances/{id}/variables")
    public ResponseEntity<Map<String, Object>> getVariables(@PathVariable("id") String processInstanceId) {
        Map<String, Object> vars = runtimeService.getVariables(processInstanceId);
        return ResponseEntity.ok(vars);
    }

    @PostMapping("/message")
    public ResponseEntity<Void> correlateMessage(@RequestBody Map<String, Object> body) {
        String messageName = (String) body.get("messageName");
        String processInstanceId = (String) body.get("processInstanceId");
        Map<String, Object> vars = (Map<String, Object>) body.getOrDefault("variables", Map.of());

        if (messageName == null || processInstanceId == null) {
            return ResponseEntity.badRequest().build();
        }

        var exec = runtimeService.createExecutionQuery().processInstanceId(processInstanceId).messageEventSubscriptionName(messageName).singleResult();
        if (exec == null) {
            return ResponseEntity.notFound().build();
        }
        // correlate by execution id and pass variables
        runtimeService.messageEventReceived(messageName, exec.getId(), vars);
        return ResponseEntity.ok().build();
    }
}
