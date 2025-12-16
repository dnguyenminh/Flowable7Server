package com.example.flowable;

import org.flowable.engine.RuntimeService;
import org.flowable.task.api.Task;
import org.flowable.task.service.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/process")
public class ProcessController {

    private final RuntimeService runtimeService;
    private final TaskService taskService;

    public ProcessController(RuntimeService runtimeService, TaskService taskService) {
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

    @GetMapping("/tasks/{processInstanceId}")
    public ResponseEntity<List<Map<String, String>>> tasks(@PathVariable String processInstanceId) {
        List<Map<String, String>> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list()
                .stream().map(t -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("id", t.getId());
                    m.put("name", t.getName());
                    return m;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }
}
