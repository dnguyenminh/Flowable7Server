# flowable-swagger-cmmn.md — cmmn-query (cmmn-query)

> Generated subset extracted from flowable-swagger-cmmn.md

## GET /cmmn-management/timer-jobs/{jobId}/exception-stacktrace

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/case-instances` | Query case instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/CaseInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/CaseInstanceQueryResource | The field to sort by. Defaults to 'id'. |  |

#### Responses
- **200**: Indicates request was successful and the case instances are returned
```json
{
  "data" : [ {
    "id" : "187",
    "name" : "processName",
    "url" : "http://localhost:8182/cmmn-repository/case-definitions/caseOne%3A1%3A4",
    "businessKey" : "myBusinessKey",
    "businessStatus" : "myBusinessStatus",
    "startTime" : "2019-04-17T10:17:43.902+0000",
    "startUserId" : "aUserId",
    "state" : "active",
    "ended" : false,
    "caseDefinitionId" : "oneTaskCase:1:158",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/caseOne%3A1%3A4",
    "caseDefinitionName" : "aCaseDefinitionName",
    "caseDefinitionDescription" : "A case definition description",
    "parentId" : "123",
    "callbackId" : "123",
    "callbackType" : "cmmn-1.1-to-cmmn-1.1-child-case",
    "referenceId" : "123",
    "referenceType" : "event-to-cmmn-1.1-case",
    "variables" : [ {
      "name" : "myVariable",
      "type" : "string",
      "value" : "test",
      "valueUrl" : "http://....",
      "scope" : "string"
    } ],
    "tenantId" : "null",
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

## POST /cmmn-query/case-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/historic-case-instances` | Query for historic case instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricCaseInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricCaseInstanceQueryResource | The field to sort by. Defaults to 'caseInstanceId'. |  |

#### Responses
- **200**: Indicates request was successful and the case instances are returned
```json
{
  "data" : [ {
    "id" : "5",
    "url" : "http://localhost:8182/cmmn-history/historic-case-instances/5",
    "name" : "myName",
    "businessKey" : "myKey",
    "businessStatus" : "myStatus",
    "caseDefinitionId" : "oneTaskCase%3A1%3A4",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/oneTaskCaseProcess%3A1%3A4",
    "caseDefinitionName" : "aCaseDefinitionName",
    "caseDefinitionDescription" : "A case definition description",
    "startTime" : "2013-04-17T10:17:43.902+0000",
    "endTime" : "2013-04-18T14:06:32.715+0000",
    "startUserId" : "kermit",
    "superProcessInstanceId" : "3",
    "variables" : [ {
      "name" : "myVariable",
      "type" : "string",
      "value" : "test",
      "valueUrl" : "http://....",
      "scope" : "string"
    } ],
    "tenantId" : "null",
    "state" : "active",
    "callbackId" : "123",
    "callbackType" : "cmmn-1.1-to-cmmn-1.1-child-case",
    "referenceId" : "123",
    "referenceType" : "event-to-cmmn-1.1-case"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## POST /cmmn-query/historic-case-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/historic-milestone-instances` | Query for historic milestone instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricMilestoneInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricMilestoneInstanceQueryResource | The field to sort by. Defaults to 'timestamp'. |  |

#### Responses
- **200**: Indicates request was successful and the milestone instances are returned
```json
{
  "data" : [ {
    "id" : "5",
    "name" : "milestoneName",
    "elementId" : "milestonePlanItemId",
    "timestamp" : "2013-04-18T14:06:32.715+0000",
    "caseInstanceId" : "12345",
    "caseDefinitionId" : "oneMilestoneCase%3A1%3A4",
    "url" : "http://localhost:8182/cmmn-history/historic-milestone-instances/5",
    "historicCaseInstanceUrl" : "http://localhost:8182/cmmn-history/historic-case-instances/12345",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/oneMilestoneCase%3A1%3A4"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## POST /cmmn-query/historic-milestone-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/historic-planitem-instances` | Query for historic plan item instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricPlanItemInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricPlanItemInstanceQueryResource | The field to sort by. Defaults to 'createTime'. |  |

#### Responses
- **200**: Indicates request was successful and the plan item instances are returned
```json
{
  "data" : [ {
    "id" : "5",
    "name" : "myPlanItemName",
    "state" : "completed",
    "caseDefinitionId" : "myCaseId%3A1%3A4",
    "derivedCaseDefinitionId" : "string",
    "caseInstanceId" : "12345",
    "stageInstanceId" : "stageId",
    "stage" : true,
    "elementId" : "someElementId",
    "planItemDefinitionId" : "someId",
    "planItemDefinitionType" : "timerEventListener",
    "createTime" : "2013-04-17T10:17:43.902+0000",
    "lastAvailableTime" : "2013-04-17T10:17:43.902+0000",
    "lastEnabledTime" : "2013-04-17T10:17:43.902+0000",
    "lastDisabledTime" : "2013-04-17T10:17:43.902+0000",
    "lastStartedTime" : "2013-04-17T10:17:43.902+0000",
    "lastSuspendedTime" : "2013-04-17T10:17:43.902+0000",
    "completedTime" : "2013-04-17T10:17:43.902+0000",
    "occurredTime" : "2013-04-17T10:17:43.902+0000",
    "terminatedTime" : "2013-04-17T10:17:43.902+0000",
    "exitTime" : "2013-04-17T10:17:43.902+0000",
    "endedTime" : "2013-04-17T10:17:43.902+0000",
    "lastUpdatedTime" : "1970-01-01T00:00:00Z",
    "startUserId" : "kermit",
    "assignee" : "string",
    "completedBy" : "string",
    "referenceId" : "referenceId",
    "referenceType" : "referenceType",
    "entryCriterionId" : "string",
    "exitCriterionId" : "string",
    "formKey" : "string",
    "extraValue" : "string",
    "showInOverview" : false,
    "tenantId" : "null",
    "url" : "http://localhost:8182/cmmn-history/historic-planitem-instances/5",
    "caseInstanceUrl" : "http://localhost:8182/cmmn-history/historic-case-instances/12345",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/myCaseId%3A1%3A4",
    "derivedCaseDefinitionUrl" : "string",
    "stageInstanceUrl" : "string",
    "localVariables" : [ {
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
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## POST /cmmn-query/historic-planitem-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/historic-task-instances` | Query for historic task instances | body (body), sort (body) |

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
    "tenantId" : "string",
    "category" : "string",
    "caseInstanceId" : "string",
    "caseInstanceUrl" : "string",
    "caseDefinitionId" : "string",
    "caseDefinitionUrl" : "string",
    "scopeDefinitionId" : "string",
    "scopeId" : "string",
    "subScopeId" : "string",
    "scopeType" : "string",
    "propagatedStageInstanceId" : "string",
    "executionId" : "string",
    "processInstanceId" : "string",
    "processDefinitionId" : "string"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **404**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## POST /cmmn-query/historic-task-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/historic-variable-instances` | Query for historic variable instances | body (body), sort (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricVariableInstanceQueryRequest |  |  |
| sort | query |  |  | The field to sort by. Defaults to 'variableName'. |  |

#### Responses
- **200**: Indicates request was successful and the tasks are returned
```json
{
  "data" : [ {
    "id" : "14",
    "caseInstanceId" : "5",
    "caseInstanceUrl" : "http://localhost:8182/cmmn-history/historic-case-instances/5",
    "taskId" : "6",
    "planItemInstanceId" : "string",
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

## POST /cmmn-query/historic-variable-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/plan-item-instances` | Query plan item instances | body (body), sort (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/PlanItemInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/PlanItemInstanceQueryResource | The field to sort by. Defaults to 'createTime'. |  |

#### Responses
- **200**: Indicates request was successful and the plan item instances are returned.
```json
{
  "data" : [ {
    "id" : "5",
    "url" : "http://localhost:8182/cmmn-runtime/plan-item-instances/5",
    "name" : "string",
    "caseInstanceId" : "string",
    "caseInstanceUrl" : "string",
    "caseDefinitionId" : "string",
    "caseDefinitionUrl" : "string",
    "derivedCaseDefinitionId" : "string",
    "derivedCaseDefinitionUrl" : "string",
    "stageInstanceId" : "string",
    "stageInstanceUrl" : "string",
    "planItemDefinitionId" : "string",
    "planItemDefinitionType" : "string",
    "state" : "string",
    "stage" : false,
    "elementId" : "string",
    "createTime" : "1970-01-01T00:00:00Z",
    "lastAvailableTime" : "1970-01-01T00:00:00Z",
    "lastEnabledTime" : "1970-01-01T00:00:00Z",
    "lastDisabledTime" : "1970-01-01T00:00:00Z",
    "lastStartedTime" : "1970-01-01T00:00:00Z",
    "lastSuspendedTime" : "1970-01-01T00:00:00Z",
    "completedTime" : "1970-01-01T00:00:00Z",
    "occurredTime" : "1970-01-01T00:00:00Z",
    "terminatedTime" : "1970-01-01T00:00:00Z",
    "exitTime" : "1970-01-01T00:00:00Z",
    "endedTime" : "1970-01-01T00:00:00Z",
    "startUserId" : "string",
    "assignee" : "string",
    "completedBy" : "string",
    "referenceId" : "string",
    "referenceType" : "string",
    "completable" : false,
    "entryCriterionId" : "string",
    "exitCriterionId" : "string",
    "formKey" : "string",
    "extraValue" : "string",
    "tenantId" : "null",
    "localVariables" : [ {
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
- **404**: Indicates a parameter was passed in the wrong format. The status message contains additional information.

## POST /cmmn-query/plan-item-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/tasks` | Query for tasks | body (body), sort (body) |

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
    "url" : "http://localhost:8182/cmmn-runtime/tasks/8",
    "owner" : "owner",
    "assignee" : "kermit",
    "delegationState" : "pending",
    "name" : "My task",
    "description" : "Task description",
    "createTime" : "2013-04-17T10:17:43.902+0000",
    "dueDate" : "2013-04-17T10:17:43.902+0000",
    "priority" : 50,
    "suspended" : false,
    "claimTime" : "2018-04-17T10:17:43.902+0000",
    "taskDefinitionKey" : "theTask",
    "scopeDefinitionId" : "123",
    "scopeId" : "123",
    "subScopeId" : "123",
    "scopeType" : "cmmn",
    "propagatedStageInstanceId" : "123",
    "tenantId" : "null",
    "category" : "ExampleCategory",
    "formKey" : "string",
    "caseInstanceId" : "5",
    "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
    "caseDefinitionId" : "oneTaskCase%3A1%3A4",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-runtime/case-definitions/oneTaskCase%3A1%3A4",
    "parentTaskId" : "null",
    "parentTaskUrl" : "null",
    "executionId" : "123",
    "processInstanceId" : "123",
    "processDefinitionId" : "123",
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

## POST /cmmn-query/tasks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-query/variable-instances` | Query for variable instances | body (body), sort (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/VariableInstanceQueryRequest |  |  |
| sort | query |  |  | The field to sort by. Defaults to 'variableName'. |  |

#### Responses
- **200**: Indicates request was successful and the tasks are returned
```json
{
  "data" : [ {
    "id" : "14",
    "caseInstanceId" : "5",
    "caseInstanceUrl" : "http://localhost:8182/cmmn-history/historic-case-instances/5",
    "taskId" : "6",
    "planItemInstanceId" : "string",
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
