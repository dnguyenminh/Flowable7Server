package com.example.flowable.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.RepositoryService;

@RestController
public class TestApiController {

    @Autowired
    private com.example.flowable.service.ProcessService processService;

    @Autowired
    private com.example.flowable.service.DecisionService decisionService;

    @Autowired
    private com.example.flowable.service.CaseService caseService;

    @PostMapping("/process/start")
    public ResponseEntity<?> startProcess(@RequestBody(required = false) Map<String,Object> body) {
        com.example.flowable.dto.ProcessStartRequest req = new com.example.flowable.dto.ProcessStartRequest();
        if (body != null && body.get("key") != null) {
            req.setKey(Objects.toString(body.get("key")));
            // pass the whole body as variables for simplicity
            req.setVariables(body);
        }
        if (req.getKey() == null) return ResponseEntity.badRequest().body(Map.of("message","missing key"));
        com.example.flowable.dto.ProcessStartResponse resp = processService.start(req);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/process/tasks")
    public ResponseEntity<?> getTasks(@RequestParam(required = false) String processInstanceId) {
        if (processInstanceId == null) return ResponseEntity.badRequest().body(List.of());
        return ResponseEntity.ok(processService.getTasks(processInstanceId));
    }

    @PostMapping("/process/tasks/{id}/complete")
    public ResponseEntity<?> completeTask(@PathVariable String id) {
        boolean ok = processService.completeTask(id);
        if (ok) return ResponseEntity.ok().build();
        return ResponseEntity.status(404).body(Map.of("message","not found"));
    }

    @PostMapping("/process/instances/{id}/variables")
    public ResponseEntity<?> setVariables(@PathVariable String id, @RequestBody Map<String,Object> vars) {
        boolean ok = processService.setVariables(id, vars == null ? Collections.emptyMap() : vars);
        if (ok) return ResponseEntity.ok().build();
        return ResponseEntity.status(404).body(Map.of("message","not found"));
    }

    @PostMapping("/process/message")
    public ResponseEntity<?> correlateMessage(@RequestBody Map<String,Object> body) {
        if (body == null || body.get("messageName") == null) return ResponseEntity.badRequest().body(Map.of("message","missing messageName"));
        boolean ok = processService.correlateMessage(body);
        if (ok) return ResponseEntity.ok().build();
        return ResponseEntity.status(400).body(Map.of("message","could not correlate"));
    }

    @PostMapping("/decision/evaluate")
    public ResponseEntity<?> evaluateDecision(@RequestBody Map<String,Object> body) {
        com.example.flowable.dto.DecisionEvaluateRequest req = new com.example.flowable.dto.DecisionEvaluateRequest();
        if (body != null && body.get("decisionKey") != null) {
            req.setDecisionKey(Objects.toString(body.get("decisionKey")));
            if (body.get("variables") instanceof Map) req.setVariables((Map<String,Object>) body.get("variables"));
        }
        if (req.getDecisionKey() == null) return ResponseEntity.badRequest().body(List.of());
        return ResponseEntity.ok(decisionService.evaluate(req));
    }

    @PostMapping("/case/start")
    public ResponseEntity<?> startCase(@RequestBody(required = false) Map<String,Object> body) {
        com.example.flowable.dto.CaseStartRequest req = new com.example.flowable.dto.CaseStartRequest();
        if (body != null && body.get("key") != null) req.setKey(Objects.toString(body.get("key")));
        if (req.getKey() == null) return ResponseEntity.badRequest().body(Map.of("message","missing key"));
        com.example.flowable.dto.CaseStartResponse resp = caseService.start(req);
        return ResponseEntity.ok(resp);
    }

}
