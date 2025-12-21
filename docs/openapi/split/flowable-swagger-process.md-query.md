# flowable-swagger-process.md — query (query)

> Generated subset extracted from flowable-swagger-process.md

## GET /management/timer-jobs/{jobId}/exception-stacktrace

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/activity-instances` | Query for activity instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ActivityInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/ActivityInstanceQueryResource | The field to sort by. Defaults to 'startTime'. |  |

#### Responses
- **200**: Indicates request was successful and the activities are returned
```json
{
  "data" : [ {
    "id" : "5",
    "activityId" : "4",
    "activityName" : "My user task",
    "activityType" : "userTask",
    "processDefinitionId" : "oneTaskProcess%3A1%3A4",
    "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/oneTaskProcess%3A1%3A4",
    "processInstanceId" : "3",
    "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/3",
    "executionId" : "4",
    "taskId" : "4",
    "calledProcessInstanceId" : "null",
    "assignee" : "fozzie",
    "startTime" : "2013-04-17T10:17:43.902+0000",
    "endTime" : "2013-04-18T14:06:32.715+0000",
    "durationInMillis" : 86400056,
    "tenantId" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information

## POST /query/activity-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/executions` | Query executions | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ExecutionQueryRequest |  |  |
| sort | body |  | #/definitions/ExecutionQueryResource | The field to sort by. Defaults to 'processInstanceId'. |  |

#### Responses
- **200**: Indicates request was successful and the executions are returned.
```json
{
  "data" : [ {
    "id" : "5",
    "url" : "http://localhost:8182/runtime/executions/5",
    "parentId" : "null",
    "parentUrl" : "null",
    "superExecutionId" : "null",
    "superExecutionUrl" : "null",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
    "suspended" : false,
    "activityId" : "null",
    "tenantId" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **404**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.

## POST /query/executions

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/historic-activity-instances` | Query for historic activity instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricActivityInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricActivityInstanceQueryResource | The field to sort by. Defaults to 'startTime'. |  |

#### Responses
- **200**: Indicates request was successful and the activities are returned
```json
{
  "data" : [ {
    "id" : "5",
    "activityId" : "4",
    "activityName" : "My user task",
    "activityType" : "userTask",
    "processDefinitionId" : "oneTaskProcess%3A1%3A4",
    "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/oneTaskProcess%3A1%3A4",
    "processInstanceId" : "3",
    "processInstanceUrl" : "http://localhost:8182/history/historic-process-instances/3",
    "executionId" : "4",
    "taskId" : "4",
    "calledProcessInstanceId" : "null",
    "assignee" : "fozzie",
    "startTime" : "2013-04-17T10:17:43.902+0000",
    "endTime" : "2013-04-18T14:06:32.715+0000",
    "durationInMillis" : 86400056,
    "tenantId" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information

## POST /query/historic-activity-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/historic-detail` | Query for historic details | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricDetailQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricDetailQueryResource | The field to sort by. Defaults to 'processInstanceId'. |  |

#### Responses
- **200**: Indicates request was successful and the historic details are returned
```json
{
  "data" : [ {
    "id" : "26",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/history/historic-process-instances/5",
    "executionId" : "6",
    "activityInstanceId" : "10",
    "taskId" : "6",
    "taskUrl" : "http://localhost:8182/history/historic-task-instances/6",
    "time" : "2013-04-17T10:17:43.902+0000",
    "detailType" : "variableUpdate",
    "revision" : 2,
    "variable" : {
      "name" : "myVariable",
      "type" : "string",
      "value" : "test",
      "valueUrl" : "http://....",
      "scope" : "string"
    },
    "propertyId" : "null",
    "propertyValue" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## POST /query/historic-detail

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/historic-process-instances` | Query for historic process instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricProcessInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricProcessInstanceQueryResource | The field to sort by. Defaults to 'processInstanceId'. |  |

#### Responses
- **200**: Indicates request was successful and the process instances are returned
```json
{
  "data" : [ {
    "id" : "5",
    "url" : "http://localhost:8182/history/historic-process-instances/5",
    "name" : "myProcessInstanceName",
    "businessKey" : "myKey",
    "businessStatus" : "myStatus",
    "processDefinitionId" : "oneTaskProcess%3A1%3A4",
    "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/oneTaskProcess%3A1%3A4",
    "processDefinitionName" : "A process definition name",
    "processDefinitionDescription" : "A process definition description",
    "startTime" : "2013-04-17T10:17:43.902+0000",
    "endTime" : "2013-04-18T14:06:32.715+0000",
    "durationInMillis" : 86400056,
    "startUserId" : "kermit",
    "startActivityId" : "startEvent",
    "endActivityId" : "endEvent",
    "deleteReason" : "null",
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
    "tenantId" : "someTenantId"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## POST /query/historic-process-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/historic-task-instances` | Query for historic task instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricTaskInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricTaskInstanceQueryResource | The field to sort by. Defaults to 'taskInstanceId'. |  |

#### Responses
- **200**: Indicates request was successful and the tasks are returned
```json
{
  "data" : [ {
    "id" : "string",
    "processDefinitionId" : "string",
    "processDefinitionUrl" : "string",
    "processInstanceId" : "string",
    "processInstanceUrl" : "string",
    "executionId" : "string",
    "name" : "string",
    "description" : "string",
    "deleteReason" : "string",
    "owner" : "string",
    "assignee" : "string",
    "startTime" : "1970-01-01T00:00:00Z",
    "endTime" : "1970-01-01T00:00:00Z",
    "durationInMillis" : 0,
    "workTimeInMillis" : 0,
    "claimTime" : "1970-01-01T00:00:00Z",
    "taskDefinitionKey" : "string",
    "formKey" : "string",
    "priority" : 0,
    "dueDate" : "1970-01-01T00:00:00Z",
    "parentTaskId" : "string",
    "url" : "string",
    "variables" : [ {
      "name" : "myVariable",
      "type" : "string",
      "value" : "test",
      "valueUrl" : "http://....",
      "scope" : "string"
    } ],
    "scopeDefinitionId" : "string",
    "scopeId" : "string",
    "subScopeId" : "string",
    "scopeType" : "string",
    "propagatedStageInstanceId" : "string",
    "tenantId" : "string",
    "category" : "string"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **404**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## POST /query/historic-task-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/historic-variable-instances` | Query for historic variable instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricVariableInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricVariableInstanceQueryResource | The field to sort by. Defaults to 'variableName'. |  |

#### Responses
- **200**: Indicates request was successful and the tasks are returned
```json
{
  "data" : [ {
    "id" : "14",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/history/historic-process-instances/5",
    "taskId" : "6",
    "executionId" : "string",
    "variable" : {
      "name" : "myVariable",
      "type" : "string",
      "value" : "test",
      "valueUrl" : "http://....",
      "scope" : "string"
    }
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## POST /query/historic-variable-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/process-instances` | Query process instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ProcessInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/ProcessInstanceQueryResource | The field to sort by. Defaults to 'id'. |  |

#### Responses
- **200**: Indicates request was successful and the process-instances are returned
```json
{
  "data" : [ {
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
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.

## POST /query/process-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/tasks` | Query for tasks | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/TaskQueryRequest |  |  |
| sort | body |  | #/definitions/TaskQueryResource | The field to sort by. Defaults to 'id'. |  |

#### Responses
- **200**: Indicates request was successful and the tasks are returned.
```json
{
  "data" : [ {
    "id" : "8",
    "url" : "http://localhost:8182/runtime/tasks/8",
    "owner" : "owner",
    "assignee" : "kermit",
    "delegationState" : "pending",
    "name" : "My task",
    "description" : "Task description",
    "createTime" : "2018-04-17T10:17:43.902+0000",
    "dueDate" : "2018-04-17T10:17:43.902+0000",
    "priority" : 50,
    "suspended" : false,
    "claimTime" : "2018-04-17T10:17:43.902+0000",
    "taskDefinitionKey" : "theTask",
    "scopeDefinitionId" : "12",
    "scopeId" : "14",
    "subScopeId" : "15",
    "scopeType" : "cmmn",
    "propagatedStageInstanceId" : "16",
    "tenantId" : "someTenantId",
    "category" : "ExampleCategory",
    "formKey" : "string",
    "parentTaskId" : "null",
    "parentTaskUrl" : "null",
    "executionId" : "5",
    "executionUrl" : "http://localhost:8182/runtime/executions/5",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
    "processDefinitionId" : "oneTaskProcess%3A1%3A4",
    "processDefinitionUrl" : "http://localhost:8182/runtime/process-definitions/oneTaskProcess%3A1%3A4",
    "variables" : [ {
      "name" : "myVariable",
      "type" : "string",
      "value" : "test",
      "valueUrl" : "http://....",
      "scope" : "string"
    } ]
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.

## POST /query/tasks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/query/variable-instances` | Query for variable instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/VariableInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/VariableInstanceQueryResource | The field to sort by. Defaults to 'variableName'. |  |

#### Responses
- **200**: Indicates request was successful and the tasks are returned
```json
{
  "data" : [ {
    "id" : "14",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/history/historic-process-instances/5",
    "taskId" : "6",
    "executionId" : "string",
    "variable" : {
      "name" : "myVariable",
      "type" : "string",
      "value" : "test",
      "valueUrl" : "http://....",
      "scope" : "string"
    }
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
