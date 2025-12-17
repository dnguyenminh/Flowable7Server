# API Endpoints (Extracted from OpenAPI)

| Method | Path | Summary | Request Schema | Response Schema | Example curl |
|--------|------|---------|----------------|-----------------|--------------|
| POST | /process/start | Start a process instance (test controller) | `ProcessStartRequest` ({ key }) | `ProcessStartResponse` ({ processInstanceId, processDefinitionKey, tasks }) | `curl -X POST -H "Content-Type: application/json" -d '{"key":"simpleProcess"}' http://localhost:8080/process/start` |
| GET | /process/tasks | Query tasks by processInstanceId | query: `processInstanceId` | array of `Task` | `curl 'http://localhost:8080/process/tasks?processInstanceId=dummy-process'` |
| POST | /process/tasks/{id}/complete | Complete a task | path: `id` | 200 / 404 | `curl -X POST -H "Content-Type: application/json" -d '{}' http://localhost:8080/process/tasks/123/complete` |
| POST | /process/instances/{id}/variables | Set process instance variables | `VariableMap` (obj) | 200 | `curl -X POST -H "Content-Type: application/json" -d '{"approved":true}' http://localhost:8080/process/instances/123/variables` |
| POST | /process/message | Correlate a message to a process execution | `MessageCorrelateRequest` ({ messageName, processInstanceId, variables }) | 200 / 400 / 404 | `curl -X POST -H "Content-Type: application/json" -d '{"messageName":"Ping","processInstanceId":"fake-id"}' http://localhost:8080/process/message` |
| POST | /decision/evaluate | Evaluate a DMN decision (test controller) | `DecisionEvaluateRequest` ({ decisionKey, variables }) | array of `DecisionResult` | `curl -X POST -H "Content-Type: application/json" -d '{"decisionKey":"isAdult","variables":{"age":20}}' http://localhost:8080/decision/evaluate` |
| POST | /case/start | Start a CMMN case instance (test controller) | `CaseStartRequest` ({ key }) | `CaseStartResponse` ({ caseInstanceId, tasks }) | `curl -X POST -H "Content-Type: application/json" -d '{"key":"simpleCase"}' http://localhost:8080/case/start` |

---

> Note: Example curl commands assume the application runs on http://localhost:8080 and that the API uses JSON. For endpoints that may return 4xx when no data/definitions are present, examples are provided for the nominal request payloads.
