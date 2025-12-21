# flowable-swagger-process.md — management (management)

> Generated subset extracted from flowable-swagger-process.md

## PUT /identity/users/{userId}/picture

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/batch-parts/{batchPartId}` | Get a single batch part | batchPartId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchPartId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the batch part exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/batch-parts/8",
  "batchId" : "4",
  "batchUrl" : "http://localhost:8182/management/batch/4",
  "batchType" : "processMigration",
  "searchKey" : "1:22:MP",
  "searchKey2" : "1:24:MP",
  "scopeId" : "1",
  "subScopeId" : "2",
  "scopeType" : "bpmn",
  "createTime" : "2020-06-03T22:05:05.474+0000",
  "completeTime" : "2020-06-03T22:05:05.474+0000",
  "status" : "completed",
  "tenantId" : "null"
}
```
- **404**: Indicates the requested batch part does not exist.

## GET /management/batch-parts/{batchPartId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/batch-parts/{batchPartId}/batch-part-document` | Get the batch part document | batchPartId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchPartId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested batch part was found and the batch part document has been returned. The response contains the raw batch part document and always has a Content-type of application/json.
```json
"string"
```
- **404**: Indicates the requested batch part was not found or the job does not have a batch part document. Status-description contains additional information about the error.

## GET /management/batch-parts/{batchPartId}/batch-part-document

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/batches` | List batches | id (query), batchType (query), searchKey (query), searchKey2 (query), createTimeBefore (query), createTimeAfter (query), completeTimeBefore (query), completeTimeAfter (query), status (query), tenantId (query), tenantIdLike (query), withoutTenantId (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return batch with the given id |  |
| batchType | query |  |  | Only return batches for the given type |  |
| searchKey | query |  |  | Only return batches for the given search key |  |
| searchKey2 | query |  |  | Only return batches for the given search key2 |  |
| createTimeBefore | query |  |  | Only return batches created before the given date |  |
| createTimeAfter | query |  |  | Only batches batches created after the given date |  |
| completeTimeBefore | query |  |  | Only return batches completed before the given date |  |
| completeTimeAfter | query |  |  | Only batches batches completed after the given date |  |
| status | query |  |  | Only return batches for the given status |  |
| tenantId | query |  |  | Only return batches for the given tenant id |  |
| tenantIdLike | query |  |  | Only return batches like given search key |  |
| withoutTenantId | query |  |  | If true, only returns batches without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |

#### Responses
- **200**: Indicates the requested batches were returned.
```json
{
  "data" : [ {
    "id" : "8",
    "url" : "http://localhost:8182/management/batches/8",
    "batchType" : "processMigration",
    "searchKey" : "1:22:MP",
    "searchKey2" : "1:24:MP",
    "createTime" : "2020-06-03T22:05:05.474+0000",
    "completeTime" : "2020-06-03T22:05:05.474+0000",
    "status" : "completed",
    "tenantId" : "null"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.

## GET /management/batches

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/batches/{batchId}` | Get a single batch | batchId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the batch exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/batches/8",
  "batchType" : "processMigration",
  "searchKey" : "1:22:MP",
  "searchKey2" : "1:24:MP",
  "createTime" : "2020-06-03T22:05:05.474+0000",
  "completeTime" : "2020-06-03T22:05:05.474+0000",
  "status" : "completed",
  "tenantId" : "null"
}
```
- **404**: Indicates the requested batch does not exist.

## GET /management/batches/{batchId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/management/batches/{batchId}` | Delete a batch | batchId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the batch was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested batch was not found.

## DELETE /management/batches/{batchId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/batches/{batchId}/batch-document` | Get the batch document | batchId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested batch was found and the batch document has been returned. The response contains the raw batch document and always has a Content-type of application/json.
```json
"string"
```
- **404**: Indicates the requested batch was not found or the job does not have a batch document. Status-description contains additional information about the error.

## GET /management/batches/{batchId}/batch-document

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/batches/{batchId}/batch-parts` | List batch parts | batchId (path,required), status (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchId | path | yes |  |  |  |
| status | query |  |  | Only return batch parts for the given status |  |

#### Responses
- **200**: Indicates the requested batch parts were returned.
```json
[ {
  "id" : "8",
  "url" : "http://localhost:8182/management/batch-parts/8",
  "batchId" : "4",
  "batchUrl" : "http://localhost:8182/management/batch/4",
  "batchType" : "processMigration",
  "searchKey" : "1:22:MP",
  "searchKey2" : "1:24:MP",
  "scopeId" : "1",
  "subScopeId" : "2",
  "scopeType" : "bpmn",
  "createTime" : "2020-06-03T22:05:05.474+0000",
  "completeTime" : "2020-06-03T22:05:05.474+0000",
  "status" : "completed",
  "tenantId" : "null"
} ]
```
- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.

## GET /management/batches/{batchId}/batch-parts

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/deadletter-jobs` | List deadletter jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return job with the given id |  |
| processInstanceId | query |  |  | Only return jobs part of a process with the given id |  |
| withoutProcessInstanceId | query |  |  | If true, only returns jobs without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| executionId | query |  |  | Only return jobs part of an execution with the given id |  |
| processDefinitionId | query |  |  | Only return jobs with the given process definition id |  |
| elementId | query |  |  | Only return jobs with the given element id |  |
| elementName | query |  |  | Only return jobs with the given element name |  |
| handlerType | query |  |  | Only return jobs with the given handler type |  |
| handlerTypes | query |  |  | Only return jobs which have one of the given job handler type |  |
| executable | query |  |  | If true, only return jobs which are executable. If false, this parameter is ignored. |  |
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
| withoutScopeId | query |  |  | If true, only returns jobs without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| withoutScopeType | query |  |  | If true, only returns jobs without a scope type set. If false, the withoutScopeType parameter is ignored. |  |
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
    "correlationId" : "50",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
    "processDefinitionId" : "timerProcess:1:4",
    "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/timerProcess%3A1%3A4",
    "executionId" : "7",
    "executionUrl" : "http://localhost:8182/runtime/executions/7",
    "elementId" : "timer",
    "elementName" : "Timer task",
    "handlerType" : "trigger-timer",
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

## GET /management/deadletter-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/management/deadletter-jobs` | Move a bulk of deadletter jobs. Accepts 'move' and 'moveToHistoryJob' as action. | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkMoveDeadLetterActionRequest |  |  |

#### Responses
- **204**: Indicates the dead letter jobs where moved. Response-body is intentionally empty.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /management/deadletter-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/deadletter-jobs/{jobId}` | Get a single deadletter job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the suspended job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "correlationId" : "50",
  "processInstanceId" : "5",
  "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
  "processDefinitionId" : "timerProcess:1:4",
  "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/timerProcess%3A1%3A4",
  "executionId" : "7",
  "executionUrl" : "http://localhost:8182/runtime/executions/7",
  "elementId" : "timer",
  "elementName" : "Timer task",
  "handlerType" : "trigger-timer",
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

## GET /management/deadletter-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/management/deadletter-jobs/{jobId}` | Move a single deadletter job. Accepts 'move' and 'moveToHistoryJob' as action. | jobId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

#### Responses
- **204**: Indicates the dead letter job was moved. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /management/deadletter-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/management/deadletter-jobs/{jobId}` | Delete a deadletter job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /management/deadletter-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/deadletter-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a deadletter job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.
```json
"string"
```
- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.

## GET /management/deadletter-jobs/{jobId}/exception-stacktrace

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/engine` | Get engine info |  |

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

## GET /management/engine

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/engine-properties` | Get all engine properties |  |

#### Responses
- **200**: Indicates that engine properties were found and returned.
```json
{ }
```

## GET /management/engine-properties

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/management/engine-properties` | Create a new engine property | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/PropertyRequestBody |  |  |

#### Responses
- **201**: Indicates the property is created
- **409**: Indicates the property already exists

## POST /management/engine-properties

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/management/engine-properties/{engineProperty}` | Update an engine property | engineProperty (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| engineProperty | path | yes |  |  |  |
| body | body |  | #/definitions/PropertyRequestBody |  |  |

#### Responses
- **200**: Indicates the property is updated
- **404**: Indicates the property is not found

## PUT /management/engine-properties/{engineProperty}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/management/engine-properties/{engineProperty}` | Delete an engine property | engineProperty (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| engineProperty | path | yes |  |  |  |

#### Responses
- **204**: Indicates the property was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested property was not found.

## DELETE /management/engine-properties/{engineProperty}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/history-jobs` | List history jobs | id (query), withException (query), exceptionMessage (query), scopeType (query), handlerType (query), handlerTypes (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), lockOwner (query), locked (query), unlocked (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return the job with the given id |  |
| withException | query |  |  | If true, only return jobs for which an exception occurred while executing it. If false, this parameter is ignored. |  |
| exceptionMessage | query |  |  | Only return jobs with the given exception message |  |
| scopeType | query |  |  | Only return jobs with the given scope type |  |
| handlerType | query |  |  | Only return jobs with the given handler type |  |
| handlerTypes | query |  |  | Only return jobs which have one of the given job handler type |  |
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
    "createTime" : "2013-06-03T22:05:05.474+0000",
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

## GET /management/history-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/history-jobs/{jobId}` | Get a single history job job | jobId (path,required) |

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
  "createTime" : "2013-06-03T22:05:05.474+0000",
  "lockOwner" : "node1",
  "lockExpirationTime" : "2023-06-03T22:05:05.474+0000"
}
```
- **404**: Indicates the requested job does not exist.

## GET /management/history-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/management/history-jobs/{jobId}` | Execute a history job | jobId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

#### Responses
- **204**: Indicates the job was executed. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /management/history-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/management/history-jobs/{jobId}` | Delete a history job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the history job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /management/history-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/jobs` | List jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return job with the given id |  |
| processInstanceId | query |  |  | Only return jobs part of a process with the given id |  |
| withoutProcessInstanceId | query |  |  | If true, only returns jobs without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| executionId | query |  |  | Only return jobs part of an execution with the given id |  |
| processDefinitionId | query |  |  | Only return jobs with the given process definition id |  |
| elementId | query |  |  | Only return jobs with the given element id |  |
| elementName | query |  |  | Only return jobs with the given element name |  |
| handlerType | query |  |  | Only return jobs with the given handler type |  |
| handlerTypes | query |  |  | Only return jobs which have one of the given job handler type |  |
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
| withoutScopeId | query |  |  | If true, only returns jobs without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| withoutScopeType | query |  |  | If true, only returns jobs without a scope type set. If false, the withoutScopeType parameter is ignored. |  |
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
    "correlationId" : "50",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
    "processDefinitionId" : "timerProcess:1:4",
    "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/timerProcess%3A1%3A4",
    "executionId" : "7",
    "executionUrl" : "http://localhost:8182/runtime/executions/7",
    "elementId" : "timer",
    "elementName" : "Timer task",
    "handlerType" : "trigger-timer",
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

## GET /management/jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/jobs/{jobId}` | Get a single job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "correlationId" : "50",
  "processInstanceId" : "5",
  "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
  "processDefinitionId" : "timerProcess:1:4",
  "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/timerProcess%3A1%3A4",
  "executionId" : "7",
  "executionUrl" : "http://localhost:8182/runtime/executions/7",
  "elementId" : "timer",
  "elementName" : "Timer task",
  "handlerType" : "trigger-timer",
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

## GET /management/jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/management/jobs/{jobId}` | Execute a single job | jobId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

#### Responses
- **204**: Indicates the job was executed. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /management/jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/management/jobs/{jobId}` | Delete a job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /management/jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.
```json
"string"
```
- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.

## GET /management/jobs/{jobId}/exception-stacktrace

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/properties` | List engine properties |  |

#### Responses
- **200**: Indicates the properties are returned.
```json
{ }
```

## GET /management/properties

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/suspended-jobs` | List suspended jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return job with the given id |  |
| processInstanceId | query |  |  | Only return jobs part of a process with the given id |  |
| withoutProcessInstanceId | query |  |  | If true, only returns jobs without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| executionId | query |  |  | Only return jobs part of an execution with the given id |  |
| processDefinitionId | query |  |  | Only return jobs with the given process definition id |  |
| elementId | query |  |  | Only return jobs with the given element id |  |
| elementName | query |  |  | Only return jobs with the given element name |  |
| handlerType | query |  |  | Only return jobs with the given handler type |  |
| handlerTypes | query |  |  | Only return jobs which have one of the given job handler type |  |
| executable | query |  |  | If true, only return jobs which are executable. If false, this parameter is ignored. |  |
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
| withoutScopeId | query |  |  | If true, only returns jobs without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| withoutScopeType | query |  |  | If true, only returns jobs without a scope type set. If false, the withoutScopeType parameter is ignored. |  |
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
    "correlationId" : "50",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
    "processDefinitionId" : "timerProcess:1:4",
    "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/timerProcess%3A1%3A4",
    "executionId" : "7",
    "executionUrl" : "http://localhost:8182/runtime/executions/7",
    "elementId" : "timer",
    "elementName" : "Timer task",
    "handlerType" : "trigger-timer",
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

## GET /management/suspended-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/suspended-jobs/{jobId}` | Get a single suspended job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the suspended job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "correlationId" : "50",
  "processInstanceId" : "5",
  "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
  "processDefinitionId" : "timerProcess:1:4",
  "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/timerProcess%3A1%3A4",
  "executionId" : "7",
  "executionUrl" : "http://localhost:8182/runtime/executions/7",
  "elementId" : "timer",
  "elementName" : "Timer task",
  "handlerType" : "trigger-timer",
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

## GET /management/suspended-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/management/suspended-jobs/{jobId}` | Delete a suspended job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /management/suspended-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/suspended-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a suspended job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.
```json
"string"
```
- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.

## GET /management/suspended-jobs/{jobId}/exception-stacktrace

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/tables` | List tables |  |

#### Responses
- **200**: Indicates the request was successful.
```json
[ {
  "name" : "ACT_RU_VARIABLE",
  "url" : "http://localhost:8080/flowable-rest/service/management/tables/ACT_RU_VARIABLE",
  "count" : 4528
} ]
```

## GET /management/tables

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/tables/{tableName}` | Get a single table | tableName (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| tableName | path | yes |  |  |  |

#### Responses
- **200**: Indicates the table exists and the table count is returned.
```json
{
  "name" : "ACT_RU_VARIABLE",
  "url" : "http://localhost:8080/flowable-rest/service/management/tables/ACT_RU_VARIABLE",
  "count" : 4528
}
```
- **404**: Indicates the requested table does not exist.

## GET /management/tables/{tableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/tables/{tableName}/columns` | Get column info for a single table | tableName (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| tableName | path | yes |  |  |  |

#### Responses
- **200**: Indicates the table exists and the table column info is returned.
```json
{
  "tableName" : "string",
  "columnNames" : [ "string" ],
  "columnTypes" : [ "string" ]
}
```
- **404**: Indicates the requested table does not exist.

## GET /management/tables/{tableName}/columns

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/tables/{tableName}/data` | Get row data for a single table | tableName (path,required), start (query), size (query), orderAscendingColumn (query), orderDescendingColumn (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| tableName | path | yes |  |  |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |
| orderAscendingColumn | query |  |  | Name of the column to sort the resulting rows on, ascending. |  |
| orderDescendingColumn | query |  |  | Name of the column to sort the resulting rows on, descending. |  |

#### Responses
- **200**: Indicates the table exists and the table row data is returned
```json
{
  "data" : [ [ { } ] ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **404**: Indicates the requested table does not exist.

## GET /management/tables/{tableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/timer-jobs` | List timer jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return job with the given id |  |
| processInstanceId | query |  |  | Only return jobs part of a process with the given id |  |
| withoutProcessInstanceId | query |  |  | If true, only returns jobs without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| executionId | query |  |  | Only return jobs part of an execution with the given id |  |
| processDefinitionId | query |  |  | Only return jobs with the given process definition id |  |
| elementId | query |  |  | Only return jobs with the given element id |  |
| elementName | query |  |  | Only return jobs with the given element name |  |
| handlerType | query |  |  | Only return jobs with the given handler type |  |
| handlerTypes | query |  |  | Only return jobs which have one of the given job handler type |  |
| executable | query |  |  | If true, only return jobs which are executable. If false, this parameter is ignored. |  |
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
| withoutScopeId | query |  |  | If true, only returns jobs without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| withoutScopeType | query |  |  | If true, only returns jobs without a scope type set. If false, the withoutScopeType parameter is ignored. |  |
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
    "correlationId" : "50",
    "processInstanceId" : "5",
    "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
    "processDefinitionId" : "timerProcess:1:4",
    "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/timerProcess%3A1%3A4",
    "executionId" : "7",
    "executionUrl" : "http://localhost:8182/runtime/executions/7",
    "elementId" : "timer",
    "elementName" : "Timer task",
    "handlerType" : "trigger-timer",
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

## GET /management/timer-jobs

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/timer-jobs/{jobId}` | Get a single timer job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the timer job exists and is returned.
```json
{
  "id" : "8",
  "url" : "http://localhost:8182/management/jobs/8",
  "correlationId" : "50",
  "processInstanceId" : "5",
  "processInstanceUrl" : "http://localhost:8182/runtime/process-instances/5",
  "processDefinitionId" : "timerProcess:1:4",
  "processDefinitionUrl" : "http://localhost:8182/repository/process-definitions/timerProcess%3A1%3A4",
  "executionId" : "7",
  "executionUrl" : "http://localhost:8182/runtime/executions/7",
  "elementId" : "timer",
  "elementName" : "Timer task",
  "handlerType" : "trigger-timer",
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

## GET /management/timer-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/management/timer-jobs/{jobId}` | Execute a single job action (move or reschedule) | jobId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/TimerJobActionRequest |  |  |

#### Responses
- **204**: Indicates the timer job action was executed. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.
- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.

## POST /management/timer-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/management/timer-jobs/{jobId}` | Delete a timer job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested job was not found.

## DELETE /management/timer-jobs/{jobId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/management/timer-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a timer job | jobId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.
```json
"string"
```
- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.
