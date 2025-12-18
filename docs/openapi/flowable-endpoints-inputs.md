++ Begin File: /home/ducnm/projects/java/Flowable7Server/docs/openapi/flowable-endpoints-inputs.md
# Flowable REST — Required vs Optional Inputs (subset) ✅

This document summarizes **required** vs **optional** inputs for each endpoint in the minimal OpenAPI spec at `docs/openapi/flowable-7.2.0-openapi.yaml` (Flowable 7.2.0 subset used by tests).

---

## Endpoints

| Endpoint | Method | Required inputs | Optional inputs | Notes |
|---|---:|---|---|---|
| `/process/start` | POST | None (request body is **optional**) | Request body (if provided): `key` (string) — schema `ProcessStartRequest` | Spec marks requestBody `required: false`. Tests use Flowable REST `/runtime/process-instances` which expects `processDefinitionKey` + `variables` (mapped in generator). |
| `/process/tasks` | GET | None | Query: `processInstanceId` (string) | Query param is optional per spec. Returns list of `Task` objects. |
| `/process/tasks/{id}/complete` | POST | Path: `id` (required) | None | Path parameter `id` is required. No body defined. |
| `/process/instances/{id}/variables` | POST | Path: `id` (required); Request body (required) — schema `VariableMap` | Variable names/values inside request body are free-form (additionalProperties) | `requestBody.required: true` in spec; body is a map of variables (no per-variable required keys). |
| `/process/message` | POST | Request body (required): `messageName` (required), `processInstanceId` (required) — schema `MessageCorrelateRequest` | `variables` (VariableMap) | Both `messageName` and `processInstanceId` are listed in schema `required: [messageName, processInstanceId]`. |
| `/decision/evaluate` | POST | Request body (required) — schema `DecisionEvaluateRequest` (the schema does not declare required properties) | `decisionKey` (string) and `variables` are accepted in the body per schema | The spec marks the request body required; the schema does not list `decisionKey` as required (but tests expect a `decisionKey`). Generated tests POST to DMN REST execute endpoint. |
| `/case/start` | POST | None (request body **optional**) | Request body (if provided): `key` (string) — schema `CaseStartRequest` | `requestBody.required: false`. Tests call `/cmmn-runtime/case-instances` in Flowable REST. |

---

## Schema notes
- `VariableMap`: object, additional properties allowed — request bodies using this schema are accepted as maps of variables (no per-variable required properties).
- `MessageCorrelateRequest`: *required* properties: `messageName`, `processInstanceId`.
- `DecisionEvaluateRequest`: properties `decisionKey` and `variables` (spec does not mark `decisionKey` as required).

---

If you want, I can also:
- export this table to CSV or add example request bodies for each endpoint ✅
- include the exact Flowable REST endpoint mappings used in tests 🔁

_Generated on: December 18, 2025_

---

## Example request bodies and usage
Below are example request payloads (JSON) and short usage notes for each endpoint. These are aligned with the generator and tests which call Flowable REST endpoints (where applicable).

- /process/start (mapped to Flowable REST `POST /runtime/process-instances`)

```json
{
	"processDefinitionKey": "simpleProcess",
	"variables": [
		{ "name": "approved", "value": true },
		{ "name": "count", "value": 5 }
	]
}
```

Note: the original test-spec used `key` in `ProcessStartRequest`; Flowable REST expects `processDefinitionKey` and an array of variable objects.

- GET /process/tasks example (query)

```
GET /runtime/tasks?processInstanceId=dummy-process
```

- /process/tasks/{id}/complete (mapped to `POST /runtime/tasks/{taskId}` with action complete)

```json
{
	"action": "complete",
	"variables": [ { "name": "approved", "value": true } ]
}
```

- /process/instances/{id}/variables (mapped to `POST /runtime/process-instances/{id}/variables`)

```json
[ { "name": "approved", "value": true }, { "name": "count", "value": 5 } ]
```

- /process/message (mapped to `POST /runtime/executions/{executionId}/message`)

```json
{
	"messageName": "Ping",
	"processInstanceId": "0000-1111-2222",
	"variables": { "approved": true }
}
```

- /decision/evaluate (mapped to `POST /dmn-rule/execute-decision-service`)

```json
{
	"decisionKey": "isAdult",
	"variables": { "age": 20 }
}
```

- /case/start (mapped to `POST /cmmn-runtime/case-instances`)

```json
{
	"caseDefinitionKey": "simpleCase"
}
```

Note: the generator used `key` in the minimal spec's `CaseStartRequest`; Flowable CMMN REST commonly accepts `caseDefinitionKey` / `caseDefinitionId`.

---

## Curl examples
Below are example curl commands for each endpoint. Replace `localhost:8080` or resource ids (`{id}`, `{taskId}`, `{executionId}`) with values appropriate for your environment.

- Start a process instance (Flowable REST: POST /runtime/process-instances)

```bash
curl -s -X POST 'http://localhost:8080/runtime/process-instances' \
	-H 'Content-Type: application/json' \
	-d '{"processDefinitionKey":"simpleProcess","variables":[{"name":"approved","value":true}]}'
```

- Query tasks (Flowable REST: GET /runtime/tasks)

```bash
curl -s "http://localhost:8080/runtime/tasks?processInstanceId=dummy-process"
```

- Complete a task (Flowable REST: POST /runtime/tasks/{taskId})

```bash
curl -s -X POST "http://localhost:8080/runtime/tasks/{taskId}" \
	-H 'Content-Type: application/json' \
	-d '{"action":"complete","variables":[{"name":"approved","value":true}]}'
```

- Set process instance variables (Flowable REST: POST /runtime/process-instances/{id}/variables)

```bash
curl -s -X POST "http://localhost:8080/runtime/process-instances/{id}/variables" \
	-H 'Content-Type: application/json' \
	-d '[{"name":"approved","value":true},{"name":"count","value":5}]'
```

- Correlate a message (Flowable REST: POST /runtime/executions/{executionId}/message)

```bash
curl -s -X POST "http://localhost:8080/runtime/executions/{executionId}/message" \
	-H 'Content-Type: application/json' \
	-d '{"messageName":"Ping","processInstanceId":"0000-1111-2222","variables":{"approved":true}}'
```

- Evaluate a decision (Flowable DMN REST: POST /dmn-rule/execute-decision-service)

```bash
curl -s -X POST 'http://localhost:8080/dmn-rule/execute-decision-service' \
	-H 'Content-Type: application/json' \
	-d '{"decisionKey":"isAdult","variables":{"age":20}}'
```

- Start a case (Flowable CMMN REST: POST /cmmn-runtime/case-instances)

```bash
curl -s -X POST 'http://localhost:8080/cmmn-runtime/case-instances' \
	-H 'Content-Type: application/json' \
	-d '{"caseDefinitionKey":"simpleCase"}'
```

++ End File: /home/ducnm/projects/java/Flowable7Server/docs/openapi/flowable-endpoints-inputs.md