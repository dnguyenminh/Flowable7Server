# flowable-swagger-process.md — form (form)

> Generated subset extracted from flowable-swagger-process.md

## flowable-swagger-process

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/form/form-data` | Get form data | taskId (query), processDefinitionId (query) |

Get form data

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | query |  |  |  |  |
| processDefinitionId | query |  |  |  |  |

**Responses**

- **200**: Indicates that form data could be queried.

```json
{
  "$ref": "#/definitions/FormDataResponse"
}
```

- **404**: Indicates that form data could not be found.
| POST | `/form/form-data` | Submit task form data | body (body) |

## GET /form/form-data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | form |  |  |
| POST | `/form/form-data` | Submit task form data | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/SubmitFormRequest |  |  |

#### Responses
- **200**: Indicates request was successful and the form data was submitted
```json
{
  "id" : "187",
  "url" : "http://localhost:8182/repository/process-definitions/processOne%3A1%3A4",
  "name" : "myProcessInstanceName",
  "businessKey" : "myBusinessKey",
  "businessStatus" : "myBusinessStatus",
  "suspended" : false,
  "ended" : false,
  "processDefinitionId" : "oneTaskProcess:1:158",
  "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/processOne%3A1%3A4",
  "processDefinitionName" : "A process definition name",
  "processDefinitionDescription" : "A process definition description",
  "activityId" : "processTask",
  "startUserId" : "johnDoe",
  "startTime" : "2018-04-17T10:17:43.902+0000",
  "superProcessInstanceId" : "3",
  "variables" : [ {
    "name" : "myVariable",
    "type" : "string",
    "value" : "test",
    "valueUrl" : "http://....",
    "scope" : "string"
  } ],
  "callbackId" : "3",
  "callbackType" : "cmmn",
  "referenceId" : "123",
  "referenceType" : "event-to-bpmn-2.0-process",
  "propagatedStageInstanceId" : "string",
  "tenantId" : "someTenantId",
  "completed" : false
}
```
- **204**: If TaskId has been provided, Indicates request was successful and the form data was submitted. Returns empty
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
