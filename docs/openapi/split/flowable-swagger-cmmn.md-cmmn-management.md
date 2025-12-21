# flowable-swagger-cmmn.md — cmmn-management (cmmn-management)

> Generated subset extracted from flowable-swagger-cmmn.md

## GET /cmmn-history/historic-variable-instances/{varInstanceId}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/deadletter-jobs` | List deadletter jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return job with the given id |  |
| caseInstanceId | query |  |  | Only return jobs part of a case with the given id |  |
| withoutScopeId | query |  |  | If true, only returns jobs without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| planItemInstanceId | query |  |  | Only return jobs part of a plan item instance with the given id |  |
| caseDefinitionId | query |  |  | Only return jobs with the given case definition id |  |
| scopeDefinitionId | query |  |  | Only return jobs with the given scope definition id |  |
| scopeType | query |  |  | Only return jobs with the given scope type |  |
| elementId | query |  |  | Only return jobs with the given element id |  |
| elementName | query |  |  | Only return jobs with the given element name |  |
| timersOnly | query |  |  | If true, only return jobs which are timers. If false, this parameter is ignored. Cannot be used together with 'messagesOnly'. |  |
| messagesOnly | query |  |  | If true, only return jobs which are messages. If false, this parameter is ignored. Cannot be used together with 'timersOnly' |  |
| withException | query |  |  | If true, only return jobs for which an exception occurred while executing it. If false, this parameter is ignored. |  |
| dueBefore | query |  |  | Only return jobs which are due to be executed before the given date. Jobs without duedate are never returned using this parameter. |  |
| dueAfter | query |  |  | Only return jobs which are due to be executed after the given date. Jobs without duedate are never returned using this parameter. |  |
| exceptionMessage | query |  |  | Only return jobs with the given exception message |  |
| tenantId | query |  |  | Only return jobs with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return jobs with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns jobs without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| locked | query |  |  | If true, only return jobs which are locked.  If false, this parameter is ignored. |  |
| unlocked | query |  |  | If true, only return jobs which are unlocked. If false, this parameter is ignored. |  |
| withoutProcessInstanceId | query |  |  | If true, only returns jobs without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates the requested jobs were returned.
```json
{
  "data" : [ {
    "id" : "8",
    "url" : "http://localhost:8182/management/jobs/8",
    "caseInstanceId" : "5",
    "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
    "caseDefinitionId" : "timerCase:1:4",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/timerCase%3A1%3A4",
    "planItemInstanceId" : "7",
    "elementId" : "scriptTask1",
    "elementName" : "Script task",
    "handlerType" : "cmmn-trigger-timer",
    "retries" : 3,
    "exceptionMessage" : "null",
    "dueDate" : "2023-06-04T22:05:05.474+0000",
    "createTime" : "2023-06-03T22:05:05.474+0000",
    "lockOwner" : "node1",
    "lockExpirationTime" : "2023-06-03T22:05:05.474+0000",
    "tenantId" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.

## GET /cmmn-management/deadletter-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-management/deadletter-jobs` | Move a bulk of deadletter jobs. Accepts 'move' and 'moveToHistoryJob' as action. | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkMoveDeadLetterActionRequest |  |  |

#### Responses
- **204**: Indicates the dead letter jobs where moved. Response-body is intentionally empty.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /cmmn-management/deadletter-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/deadletter-jobs/{jobId}` | Get a single deadletter job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the suspended job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "caseInstanceId" : "5",
  "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
  "caseDefinitionId" : "timerCase:1:4",
  "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/timerCase%3A1%3A4",
  "planItemInstanceId" : "7",
  "elementId" : "scriptTask1",
  "elementName" : "Script task",
  "handlerType" : "cmmn-trigger-timer",
  "retries" : 3,
  "exceptionMessage" : "null",
  "dueDate" : "2023-06-04T22:05:05.474+0000",
  "createTime" : "2023-06-03T22:05:05.474+0000",
  "lockOwner" : "node1",
  "lockExpirationTime" : "2023-06-03T22:05:05.474+0000",
  "tenantId" : "null"
}
```
- **404**: Indicates the requested job does not exist.

## GET /cmmn-management/deadletter-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-management/deadletter-jobs/{jobId}` | Move a single deadletter job. Accepts 'move' and 'moveToHistoryJob' as action. | jobId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

#### Responses
- **204**: Indicates the dead letter job was moved. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /cmmn-management/deadletter-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-management/deadletter-jobs/{jobId}` | Delete a deadletter job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /cmmn-management/deadletter-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/deadletter-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a deadletter job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.
```json
"string"
```
- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.

## GET /cmmn-management/deadletter-jobs/{jobId}/exception-stacktrace

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/engine` | Get engine info |  |

#### Responses
- **200**: Indicates the engine info is returned.
```json
{
  "name" : "default",
  "resourceUrl" : "file://flowable/flowable.cfg.xml",
  "exception" : "null",
  "version" : "6.3.1"
}
```

## GET /cmmn-management/engine

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/history-jobs` | List history jobs | id (query), withException (query), exceptionMessage (query), scopeType (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), lockOwner (query), locked (query), unlocked (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return the job with the given id |  |
| withException | query |  |  | If true, only return jobs for which an exception occurred while executing it. If false, this parameter is ignored. |  |
| exceptionMessage | query |  |  | Only return jobs with the given exception message |  |
| scopeType | query |  |  | Only return jobs with the given scope type |  |
| tenantId | query |  |  | Only return jobs with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return jobs with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns jobs without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| lockOwner | query |  |  | If true, only return jobs which are owned by the given lockOwner. |  |
| locked | query |  |  | If true, only return jobs which are locked.  If false, this parameter is ignored. |  |
| unlocked | query |  |  | If true, only return jobs which are unlocked. If false, this parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates the requested jobs were returned.
```json
{
  "data" : [ {
    "id" : "8",
    "url" : "http://localhost:8182/management/jobs/8",
    "scopeType" : "cmmn",
    "retries" : 3,
    "exceptionMessage" : "null",
    "jobHandlerType" : "async-history",
    "jobHandlerConfiguration" : "myCfg",
    "advancedJobHandlerConfiguration" : "myAdvancedCfg",
    "tenantId" : "null",
    "customValues" : "custom value",
    "createTime" : "2023-06-03T22:05:05.474+0000",
    "lockOwner" : "node1",
    "lockExpirationTime" : "2023-06-03T22:05:05.474+0000"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.

## GET /cmmn-management/history-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/history-jobs/{jobId}` | Get a single history job job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the history job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "scopeType" : "cmmn",
  "retries" : 3,
  "exceptionMessage" : "null",
  "jobHandlerType" : "async-history",
  "jobHandlerConfiguration" : "myCfg",
  "advancedJobHandlerConfiguration" : "myAdvancedCfg",
  "tenantId" : "null",
  "customValues" : "custom value",
  "createTime" : "2023-06-03T22:05:05.474+0000",
  "lockOwner" : "node1",
  "lockExpirationTime" : "2023-06-03T22:05:05.474+0000"
}
```
- **404**: Indicates the requested job does not exist.

## GET /cmmn-management/history-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-management/history-jobs/{jobId}` | Execute a history job | jobId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

#### Responses
- **204**: Indicates the job was executed. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /cmmn-management/history-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-management/history-jobs/{jobId}` | Delete a history job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the history job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /cmmn-management/history-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/jobs` | List jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return job with the given id |  |
| caseInstanceId | query |  |  | Only return jobs part of a case with the given id |  |
| withoutScopeId | query |  |  | If true, only returns jobs without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| planItemInstanceId | query |  |  | Only return jobs part of a plan item instance with the given id |  |
| caseDefinitionId | query |  |  | Only return jobs with the given case definition id |  |
| scopeDefinitionId | query |  |  | Only return jobs with the given scope definition id |  |
| scopeType | query |  |  | Only return jobs with the given scope type |  |
| elementId | query |  |  | Only return jobs with the given element id |  |
| elementName | query |  |  | Only return jobs with the given element name |  |
| timersOnly | query |  |  | If true, only return jobs which are timers. If false, this parameter is ignored. Cannot be used together with 'messagesOnly'. |  |
| messagesOnly | query |  |  | If true, only return jobs which are messages. If false, this parameter is ignored. Cannot be used together with 'timersOnly' |  |
| withException | query |  |  | If true, only return jobs for which an exception occurred while executing it. If false, this parameter is ignored. |  |
| dueBefore | query |  |  | Only return jobs which are due to be executed before the given date. Jobs without duedate are never returned using this parameter. |  |
| dueAfter | query |  |  | Only return jobs which are due to be executed after the given date. Jobs without duedate are never returned using this parameter. |  |
| exceptionMessage | query |  |  | Only return jobs with the given exception message |  |
| tenantId | query |  |  | Only return jobs with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return jobs with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns jobs without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| locked | query |  |  | If true, only return jobs which are locked.  If false, this parameter is ignored. |  |
| unlocked | query |  |  | If true, only return jobs which are unlocked. If false, this parameter is ignored. |  |
| withoutProcessInstanceId | query |  |  | If true, only returns jobs without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates the requested jobs were returned.
```json
{
  "data" : [ {
    "id" : "8",
    "url" : "http://localhost:8182/management/jobs/8",
    "caseInstanceId" : "5",
    "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
    "caseDefinitionId" : "timerCase:1:4",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/timerCase%3A1%3A4",
    "planItemInstanceId" : "7",
    "elementId" : "scriptTask1",
    "elementName" : "Script task",
    "handlerType" : "cmmn-trigger-timer",
    "retries" : 3,
    "exceptionMessage" : "null",
    "dueDate" : "2023-06-04T22:05:05.474+0000",
    "createTime" : "2023-06-03T22:05:05.474+0000",
    "lockOwner" : "node1",
    "lockExpirationTime" : "2023-06-03T22:05:05.474+0000",
    "tenantId" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.

## GET /cmmn-management/jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/jobs/{jobId}` | Get a single job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "caseInstanceId" : "5",
  "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
  "caseDefinitionId" : "timerCase:1:4",
  "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/timerCase%3A1%3A4",
  "planItemInstanceId" : "7",
  "elementId" : "scriptTask1",
  "elementName" : "Script task",
  "handlerType" : "cmmn-trigger-timer",
  "retries" : 3,
  "exceptionMessage" : "null",
  "dueDate" : "2023-06-04T22:05:05.474+0000",
  "createTime" : "2023-06-03T22:05:05.474+0000",
  "lockOwner" : "node1",
  "lockExpirationTime" : "2023-06-03T22:05:05.474+0000",
  "tenantId" : "null"
}
```
- **404**: Indicates the requested job does not exist.

## GET /cmmn-management/jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-management/jobs/{jobId}` | Execute a single job | jobId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

#### Responses
- **204**: Indicates the job was executed. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /cmmn-management/jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-management/jobs/{jobId}` | Delete a job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found..

## DELETE /cmmn-management/jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.
```json
"string"
```
- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.

## GET /cmmn-management/jobs/{jobId}/exception-stacktrace

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/suspended-jobs` | List suspended jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return job with the given id |  |
| caseInstanceId | query |  |  | Only return jobs part of a case with the given id |  |
| withoutScopeId | query |  |  | If true, only returns jobs without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| planItemInstanceId | query |  |  | Only return jobs part of a plan item instance with the given id |  |
| caseDefinitionId | query |  |  | Only return jobs with the given case definition id |  |
| scopeDefinitionId | query |  |  | Only return jobs with the given scope definition id |  |
| scopeType | query |  |  | Only return jobs with the given scope type |  |
| elementId | query |  |  | Only return jobs with the given element id |  |
| elementName | query |  |  | Only return jobs with the given element name |  |
| timersOnly | query |  |  | If true, only return jobs which are timers. If false, this parameter is ignored. Cannot be used together with 'messagesOnly'. |  |
| messagesOnly | query |  |  | If true, only return jobs which are messages. If false, this parameter is ignored. Cannot be used together with 'timersOnly' |  |
| withException | query |  |  | If true, only return jobs for which an exception occurred while executing it. If false, this parameter is ignored. |  |
| dueBefore | query |  |  | Only return jobs which are due to be executed before the given date. Jobs without duedate are never returned using this parameter. |  |
| dueAfter | query |  |  | Only return jobs which are due to be executed after the given date. Jobs without duedate are never returned using this parameter. |  |
| exceptionMessage | query |  |  | Only return jobs with the given exception message |  |
| tenantId | query |  |  | Only return jobs with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return jobs with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns jobs without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| locked | query |  |  | If true, only return jobs which are locked.  If false, this parameter is ignored. |  |
| unlocked | query |  |  | If true, only return jobs which are unlocked. If false, this parameter is ignored. |  |
| withoutProcessInstanceId | query |  |  | If true, only returns jobs without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates the requested jobs were returned.
```json
{
  "data" : [ {
    "id" : "8",
    "url" : "http://localhost:8182/management/jobs/8",
    "caseInstanceId" : "5",
    "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
    "caseDefinitionId" : "timerCase:1:4",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/timerCase%3A1%3A4",
    "planItemInstanceId" : "7",
    "elementId" : "scriptTask1",
    "elementName" : "Script task",
    "handlerType" : "cmmn-trigger-timer",
    "retries" : 3,
    "exceptionMessage" : "null",
    "dueDate" : "2023-06-04T22:05:05.474+0000",
    "createTime" : "2023-06-03T22:05:05.474+0000",
    "lockOwner" : "node1",
    "lockExpirationTime" : "2023-06-03T22:05:05.474+0000",
    "tenantId" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.

## GET /cmmn-management/suspended-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/suspended-jobs/{jobId}` | Get a single suspended job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the suspended job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "caseInstanceId" : "5",
  "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
  "caseDefinitionId" : "timerCase:1:4",
  "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/timerCase%3A1%3A4",
  "planItemInstanceId" : "7",
  "elementId" : "scriptTask1",
  "elementName" : "Script task",
  "handlerType" : "cmmn-trigger-timer",
  "retries" : 3,
  "exceptionMessage" : "null",
  "dueDate" : "2023-06-04T22:05:05.474+0000",
  "createTime" : "2023-06-03T22:05:05.474+0000",
  "lockOwner" : "node1",
  "lockExpirationTime" : "2023-06-03T22:05:05.474+0000",
  "tenantId" : "null"
}
```
- **404**: Indicates the requested job does not exist.

## GET /cmmn-management/suspended-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-management/suspended-jobs/{jobId}` | Delete a suspended job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /cmmn-management/suspended-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/suspended-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a suspended job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.
```json
"string"
```
- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.

## GET /cmmn-management/suspended-jobs/{jobId}/exception-stacktrace

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/timer-jobs` | List timer jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return job with the given id |  |
| caseInstanceId | query |  |  | Only return jobs part of a case with the given id |  |
| withoutScopeId | query |  |  | If true, only returns jobs without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| planItemInstanceId | query |  |  | Only return jobs part of a plan item instance with the given id |  |
| caseDefinitionId | query |  |  | Only return jobs with the given case definition id |  |
| scopeDefinitionId | query |  |  | (Deprecated; use caseDefinitionId instead) Only return jobs with the given scope definition id |  |
| scopeType | query |  |  | Only return jobs with the given scope type |  |
| elementId | query |  |  | Only return jobs with the given element id |  |
| elementName | query |  |  | Only return jobs with the given element name |  |
| timersOnly | query |  |  | If true, only return jobs which are timers. If false, this parameter is ignored. Cannot be used together with 'messagesOnly'. |  |
| messagesOnly | query |  |  | If true, only return jobs which are messages. If false, this parameter is ignored. Cannot be used together with 'timersOnly' |  |
| withException | query |  |  | If true, only return jobs for which an exception occurred while executing it. If false, this parameter is ignored. |  |
| dueBefore | query |  |  | Only return jobs which are due to be executed before the given date. Jobs without duedate are never returned using this parameter. |  |
| dueAfter | query |  |  | Only return jobs which are due to be executed after the given date. Jobs without duedate are never returned using this parameter. |  |
| exceptionMessage | query |  |  | Only return jobs with the given exception message |  |
| tenantId | query |  |  | Only return jobs with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return jobs with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns jobs without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| locked | query |  |  | If true, only return jobs which are locked.  If false, this parameter is ignored. |  |
| unlocked | query |  |  | If true, only return jobs which are unlocked. If false, this parameter is ignored. |  |
| withoutProcessInstanceId | query |  |  | If true, only returns jobs without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates the requested jobs were returned.
```json
{
  "data" : [ {
    "id" : "8",
    "url" : "http://localhost:8182/management/jobs/8",
    "caseInstanceId" : "5",
    "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
    "caseDefinitionId" : "timerCase:1:4",
    "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/timerCase%3A1%3A4",
    "planItemInstanceId" : "7",
    "elementId" : "scriptTask1",
    "elementName" : "Script task",
    "handlerType" : "cmmn-trigger-timer",
    "retries" : 3,
    "exceptionMessage" : "null",
    "dueDate" : "2023-06-04T22:05:05.474+0000",
    "createTime" : "2023-06-03T22:05:05.474+0000",
    "lockOwner" : "node1",
    "lockExpirationTime" : "2023-06-03T22:05:05.474+0000",
    "tenantId" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.

## GET /cmmn-management/timer-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/timer-jobs/{jobId}` | Get a single timer job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the timer job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "caseInstanceId" : "5",
  "caseInstanceUrl" : "http://localhost:8182/cmmn-runtime/case-instances/5",
  "caseDefinitionId" : "timerCase:1:4",
  "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/timerCase%3A1%3A4",
  "planItemInstanceId" : "7",
  "elementId" : "scriptTask1",
  "elementName" : "Script task",
  "handlerType" : "cmmn-trigger-timer",
  "retries" : 3,
  "exceptionMessage" : "null",
  "dueDate" : "2023-06-04T22:05:05.474+0000",
  "createTime" : "2023-06-03T22:05:05.474+0000",
  "lockOwner" : "node1",
  "lockExpirationTime" : "2023-06-03T22:05:05.474+0000",
  "tenantId" : "null"
}
```
- **404**: Indicates the requested job does not exist.

## GET /cmmn-management/timer-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-management/timer-jobs/{jobId}` | Execute a single job action (move or reschedule) | jobId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/TimerJobActionRequest |  |  |

#### Responses
- **204**: Indicates the timer job action was executed. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /cmmn-management/timer-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-management/timer-jobs/{jobId}` | Delete a timer job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /cmmn-management/timer-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-management/timer-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a timer job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.
```json
"string"
```
- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.
