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

++ End File: /home/ducnm/projects/java/Flowable7Server/docs/openapi/flowable-endpoints-inputs.md