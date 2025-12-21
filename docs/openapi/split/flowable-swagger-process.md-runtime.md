# flowable-swagger-process.md — runtime (runtime)

> Generated subset extracted from flowable-swagger-process.md

## GET /repository/process-definitions/{processDefinitionId}/start-form

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/activity-instances` | List activity instances | activityId (query), activityInstanceId (query), activityName (query), activityType (query), executionId (query), finished (query), taskAssignee (query), processInstanceId (query), processDefinitionId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| activityId | query |  |  | An id of the activity instance. |  |
| activityInstanceId | query |  |  | An id of the activity instance. |  |
| activityName | query |  |  | The name of the activity instance. |  |
| activityType | query |  |  | The element type of the activity instance. |  |
| executionId | query |  |  | The execution id of the activity instance. |  |
| finished | query |  |  | Indication if the activity instance is finished. |  |
| taskAssignee | query |  |  | The assignee of the activity instance. |  |
| processInstanceId | query |  |  | The process instance id of the activity instance. |  |
| processDefinitionId | query |  |  | The process definition id of the activity instance. |  |
| tenantId | query |  |  | Only return instances with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return instances with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | The field to sort by. Defaults to 'startTime'. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates that activity instances could be queried.
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
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## GET /runtime/activity-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/event-subscriptions` | List of event subscriptions | id (query), eventType (query), eventName (query), activityId (query), executionId (query), processInstanceId (query), withoutProcessInstanceId (query), processDefinitionId (query), withoutProcessDefinitionId (query), scopeId (query), subScopeId (query), withoutScopeId (query), scopeDefinitionId (query), withoutScopeDefinitionId (query), createdBefore (query), createdAfter (query), tenantId (query), withoutTenantId (query), configuration (query), withoutConfiguration (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return event subscriptions with the given id |  |
| eventType | query |  |  | Only return event subscriptions with the given event type |  |
| eventName | query |  |  | Only return event subscriptions with the given event name |  |
| activityId | query |  |  | Only return event subscriptions with the given activity id |  |
| executionId | query |  |  | Only return event subscriptions with the given execution id |  |
| processInstanceId | query |  |  | Only return event subscriptions part of a process with the given id |  |
| withoutProcessInstanceId | query |  |  | Only return event subscriptions that have no process instance id |  |
| processDefinitionId | query |  |  | Only return event subscriptions with the given process definition id |  |
| withoutProcessDefinitionId | query |  |  | Only return event subscriptions that have no process definition id |  |
| scopeId | query |  |  | Only return event subscriptions part of a scope with the given id |  |
| subScopeId | query |  |  | Only return event subscriptions part of a sub scope with the given id |  |
| withoutScopeId | query |  |  | Only return event subscriptions that have no scope id |  |
| scopeDefinitionId | query |  |  | Only return event subscriptions with the given scope definition id |  |
| withoutScopeDefinitionId | query |  |  | Only return event subscriptions that have no scope definition id |  |
| createdBefore | query |  |  | Only return event subscriptions which are created before the given date. |  |
| createdAfter | query |  |  | Only return event subscriptions which are created after the given date. |  |
| tenantId | query |  |  | Only return event subscriptions with the given tenant id. |  |
| withoutTenantId | query |  |  | Only return event subscriptions that have no tenant id |  |
| configuration | query |  |  | Only return event subscriptions with the given configuration value. |  |
| withoutConfiguration | query |  |  | Only return event subscriptions that have no configuration value |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates the requested event subscriptions were returned.
```json
{
  "data" : [ {
    "id" : "string",
    "url" : "string",
    "eventType" : "string",
    "eventName" : "string",
    "activityId" : "string",
    "executionId" : "string",
    "executionUrl" : "string",
    "processInstanceId" : "string",
    "processInstanceUrl" : "string",
    "processDefinitionId" : "string",
    "processDefinitionUrl" : "string",
    "scopeId" : "string",
    "scopeType" : "string",
    "subScopeId" : "string",
    "scopeDefinitionId" : "string",
    "created" : "1970-01-01T00:00:00Z",
    "configuration" : "string",
    "tenantId" : "string"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.

## GET /runtime/event-subscriptions

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/event-subscriptions/{eventSubscriptionId}` | Get a single event subscription | eventSubscriptionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| eventSubscriptionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the event subscription exists and is returned.
```json
{
  "id" : "string",
  "url" : "string",
  "eventType" : "string",
  "eventName" : "string",
  "activityId" : "string",
  "executionId" : "string",
  "executionUrl" : "string",
  "processInstanceId" : "string",
  "processInstanceUrl" : "string",
  "processDefinitionId" : "string",
  "processDefinitionUrl" : "string",
  "scopeId" : "string",
  "scopeType" : "string",
  "subScopeId" : "string",
  "scopeDefinitionId" : "string",
  "created" : "1970-01-01T00:00:00Z",
  "configuration" : "string",
  "tenantId" : "string"
}
```
- **404**: Indicates the requested event subscription does not exist.

## GET /runtime/event-subscriptions/{eventSubscriptionId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/executions` | List of executions | id (query), activityId (query), processDefinitionKey (query), processDefinitionId (query), processInstanceId (query), messageEventSubscriptionName (query), signalEventSubscriptionName (query), parentId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return models with the given version. |  |
| activityId | query |  |  | Only return executions with the given activity id. |  |
| processDefinitionKey | query |  |  | Only return process instances with the given process definition key. |  |
| processDefinitionId | query |  |  | Only return process instances with the given process definition id. |  |
| processInstanceId | query |  |  | Only return executions which are part of the process instance with the given id. |  |
| messageEventSubscriptionName | query |  |  | Only return executions which are subscribed to a message with the given name. |  |
| signalEventSubscriptionName | query |  |  | Only return executions which are subscribed to a signal with the given name. |  |
| parentId | query |  |  | Only return executions which are a direct child of the given execution. |  |
| tenantId | query |  |  | Only return process instances with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return process instances with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns process instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |

#### Responses
- **200**: Indicates request was successful and the executions are returned
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
- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.

## GET /runtime/executions

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/executions` | Signal event received | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ExecutionActionRequest |  |  |

#### Responses
- **204**: Indicates request was successful and the executions are returned
- **404**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.

## PUT /runtime/executions

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/executions/{executionId}` | Get an execution | executionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the execution was found and returned.
```json
{
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
}
```
- **404**: Indicates the execution was not found.

## GET /runtime/executions/{executionId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/executions/{executionId}` | Execute an action on an execution | executionId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionActionRequest |  |  |

#### Responses
- **200**: Indicates the execution was found and the action is performed.
```json
{
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
}
```
- **204**: Indicates the execution was found, the action was performed and the action caused the execution to end.
- **400**: Indicates an illegal action was requested, required parameters are missing in the request body or illegal variables are passed in. Status description contains additional information about the error.
- **404**: Indicates the execution was not found.

## PUT /runtime/executions/{executionId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/executions/{executionId}/activities` | List active activities in an execution | executionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the execution was found and activities are returned.
```json
[ "string" ]
```
- **404**: Indicates the execution was not found.

## GET /runtime/executions/{executionId}/activities

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/executions/{executionId}/change-state` | Change the state of an execution | executionId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionChangeActivityStateRequest |  |  |

#### Responses
- **200**: Indicates the execution was found and the action is performed.
- **404**: Indicates the execution was not found.

## POST /runtime/executions/{executionId}/change-state

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/executions/{executionId}/variables` | List variables for an execution | executionId (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates the execution was found and variables are returned.
```json
[ {
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
} ]
```
- **404**: Indicates the requested execution was not found.

## GET /runtime/executions/{executionId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/executions/{executionId}/variables` | Create variables on an execution | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableCollectionResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

#### Responses
- **200**: successful operation
```json
{ }
```
- **201**: Indicates the execution was found and variable is created/updated.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the requested execution was not found.
- **409**: Indicates the execution was found but already contains a variable with the given name. Use the update-method instead.

## POST /runtime/executions/{executionId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/executions/{executionId}/variables` | Update variables on an execution | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableCollectionResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

#### Responses
- **200**: successful operation
```json
{ }
```
- **201**: Indicates the execution was found and variable is created/updated.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the requested execution was not found.

## PUT /runtime/executions/{executionId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/executions/{executionId}/variables` | Delete all variables for an execution | executionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the execution was found and variables have been deleted.
- **404**: Indicates the requested execution was not found.

## DELETE /runtime/executions/{executionId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/executions/{executionId}/variables-async` | Create variables on an execution asynchronously | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableCollectionResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

#### Responses
- **201**: Indicates the job to create the variables has been created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **409**: Indicates the execution already contains a variable with the given name. Use the update-method instead.

## POST /runtime/executions/{executionId}/variables-async

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/executions/{executionId}/variables-async` | Update variables on an execution asynchronously | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableCollectionResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

#### Responses
- **201**: Indicates the job to update the variables has been created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

## PUT /runtime/executions/{executionId}/variables-async

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/executions/{executionId}/variables-async/{variableName}` | Update a variable on an execution asynchronously | executionId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableResource | Update a variable on an execution |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

#### Responses
- **200**: Indicates both the process instance and variable were found and variable is updated.
- **404**: Indicates the process instance does not have a variable with the given name. Status description contains additional information about the error.

## PUT /runtime/executions/{executionId}/variables-async/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/executions/{executionId}/variables/{variableName}` | Get a variable for an execution | executionId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates both the execution and variable were found and variable is returned.
```json
{
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
}
```
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the requested execution was not found or the execution does not have a variable with the given name in the requested scope (in case scope-query parameter was omitted, variable does not exist in local and global scope). Status description contains additional information about the error.

## GET /runtime/executions/{executionId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/executions/{executionId}/variables/{variableName}` | Update a variable on an execution | executionId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableResource | Update a variable on an execution |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

#### Responses
- **200**: Indicates both the process instance and variable were found and variable is updated.
```json
{
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
}
```
- **404**: Indicates the requested process instance was not found or the process instance does not have a variable with the given name. Status description contains additional information about the error.

## PUT /runtime/executions/{executionId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/executions/{executionId}/variables/{variableName}` | Delete a variable for an execution | executionId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **204**: Indicates both the execution and variable were found and variable has been deleted.
- **404**: Indicates the requested execution was not found or the execution does not have a variable with the given name in the requested scope. Status description contains additional information about the error.

## DELETE /runtime/executions/{executionId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/executions/{executionId}/variables/{variableName}/data` | Get the binary data for an execution | executionId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates the execution was found and the requested variables are returned.
```json
[ "string" ]
```
- **404**: Indicates the requested execution was not found or the task does not have a variable with the given name (in the given scope). Status message provides additional information.

## GET /runtime/executions/{executionId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/process-instances` | List process instances | id (query), name (query), nameLike (query), nameLikeIgnoreCase (query), processDefinitionName (query), processDefinitionNameLike (query), processDefinitionNameLikeIgnoreCase (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionKeyLikeIgnoreCase (query), processDefinitionId (query), processDefinitionCategory (query), processDefinitionCategoryLike (query), processDefinitionCategoryLikeIgnoreCase (query), processDefinitionVersion (query), processDefinitionEngineVersion (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), startedBy (query), startedBefore (query), startedAfter (query), activeActivityId (query), involvedUser (query), suspended (query), superProcessInstanceId (query), rootScopeId (query), parentScopeId (query), subProcessInstanceId (query), excludeSubprocesses (query), includeProcessVariables (query), includeProcessVariablesName (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return process instances with the given version. |  |
| name | query |  |  | Only return process instances with the given name. |  |
| nameLike | query |  |  | Only return process instances like the given name. |  |
| nameLikeIgnoreCase | query |  |  | Only return process instances like the given name ignoring case. |  |
| processDefinitionName | query |  |  | Only return process instances with the given process definition name. |  |
| processDefinitionNameLike | query |  |  | Only return process instances like the given process definition name. |  |
| processDefinitionNameLikeIgnoreCase | query |  |  | Only return process instances like the given process definition name ignoring case. |  |
| processDefinitionKey | query |  |  | Only return process instances with the given process definition key. |  |
| processDefinitionKeyLike | query |  |  | Only return process instances like the given process definition key. |  |
| processDefinitionKeyLikeIgnoreCase | query |  |  | Only return process instances like the given process definition key ignoring case. |  |
| processDefinitionId | query |  |  | Only return process instances with the given process definition id. |  |
| processDefinitionCategory | query |  |  | Only return process instances with the given process definition category. |  |
| processDefinitionCategoryLike | query |  |  | Only return process instances like the given process definition category. |  |
| processDefinitionCategoryLikeIgnoreCase | query |  |  | Only return process instances like the given process definition category ignoring case. |  |
| processDefinitionVersion | query |  |  | Only return process instances with the given process definition version. |  |
| processDefinitionEngineVersion | query |  |  | Only return process instances with the given process definition engine version. |  |
| businessKey | query |  |  | Only return process instances with the given business key. |  |
| businessKeyLike | query |  |  | Only return process instances with the business key like the given key. |  |
| businessKeyLikeIgnoreCase | query |  |  | Only return process instances with the business key like the given key ignoring case. |  |
| businessStatus | query |  |  | Only return process instances with the given business status. |  |
| businessStatusLike | query |  |  | Only return process instances with the business status like the given status. |  |
| businessStatusLikeIgnoreCase | query |  |  | Only return process instances with the business status like the given status ignoring case. |  |
| startedBy | query |  |  | Only return process instances started by the given user. |  |
| startedBefore | query |  |  | Only return process instances started before the given date. |  |
| startedAfter | query |  |  | Only return process instances started after the given date. |  |
| activeActivityId | query |  |  | Only return process instances which have an active activity instance with the provided activity id. |  |
| involvedUser | query |  |  | Only return process instances in which the given user is involved. |  |
| suspended | query |  |  | If true, only return process instance which are suspended. If false, only return process instances which are not suspended (active). |  |
| superProcessInstanceId | query |  |  | Only return process instances which have the given super process-instance id (for processes that have a call-activities). |  |
| rootScopeId | query |  |  | Only return process instances which have the given root scope id (that can be a process or case instance ID). |  |
| parentScopeId | query |  |  | Only return process instances which have the given parent scope id (that can be a process or case instance ID). |  |
| subProcessInstanceId | query |  |  | Only return process instances which have the given sub process-instance id (for processes started as a call-activity). |  |
| excludeSubprocesses | query |  |  | Return only process instances which are not sub processes. |  |
| includeProcessVariables | query |  |  | Indication to include process variables in the result. |  |
| includeProcessVariablesName | query |  |  | Indication to include process variables with the given names in the result. |  |
| callbackId | query |  |  | Only return process instances with the given callbackId. |  |
| callbackType | query |  |  | Only return process instances with the given callbackType. |  |
| parentCaseInstanceId | query |  |  | Only return process instances with the given parent case instance id. |  |
| tenantId | query |  |  | Only return process instances with the given tenant id. |  |
| tenantIdLike | query |  |  | Only return process instances with a tenant id like the given value. |  |
| tenantIdLikeIgnoreCase | query |  |  | Only return process instances with a tenant id like the given value ignoring case. |  |
| withoutTenantId | query |  |  | If true, only returns process instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

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

## GET /runtime/process-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances` | Start a process instance | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ProcessInstanceCreateRequest |  |  |

#### Responses
- **201**: Indicates the process instance was created.
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
- **400**: Indicates either the process-definition was not found (based on id or key), no process is started by sending the given message or an invalid variable has been passed. Status description contains additional information about the error.

## POST /runtime/process-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances/delete` | Bulk delete process instances | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkDeleteInstancesRestActionRequest |  |  |

#### Responses
- **204**: Indicates the bulk of process instances was found and deleted. Response body is left empty intentionally.
- **404**: Indicates at least one requested process instance was not found.

## POST /runtime/process-instances/delete

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/process-instances/{processInstanceId}` | Get a process instance | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and returned.
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
- **404**: Indicates the requested process instance was not found.

## GET /runtime/process-instances/{processInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/process-instances/{processInstanceId}` | Update process instance properties or execute an action on a process instance (body needs to contain an 'action' property for the latter). | processInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceUpdateRequest |  |  |

#### Responses
- **200**: Indicates the process instance was found and the update/action was executed.
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
- **400**: Indicates a invalid parameters are supplied.
- **404**: Indicates the requested process instance was not found.
- **409**: Indicates the requested process instance change cannot be executed since the process-instance is in a wrong status which doesn't accept the change

## PUT /runtime/process-instances/{processInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/process-instances/{processInstanceId}` | Delete a process instance | processInstanceId (path,required), deleteReason (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| deleteReason | query |  |  |  |  |

#### Responses
- **204**: Indicates the process instance was found and deleted. Response body is left empty intentionally.
- **404**: Indicates the requested process instance was not found.

## DELETE /runtime/process-instances/{processInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances/{processInstanceId}/change-state` | Change the state a process instance | processInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionChangeActivityStateRequest |  |  |

#### Responses
- **200**: Indicates the process instance was found and change state activity was executed.
- **404**: Indicates the requested process instance was not found.
- **409**: Indicates the requested process instance action cannot be executed since the process-instance is already activated/suspended.

## POST /runtime/process-instances/{processInstanceId}/change-state

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/process-instances/{processInstanceId}/diagram` | Get diagram for a process instance | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and the diagram was returned.
```json
[ "string" ]
```
- **400**: Indicates the requested process instance was not found but the process does not contain any graphical information (BPMN:DI) and no diagram can be created.
- **404**: Indicates the requested process instance was not found.

## GET /runtime/process-instances/{processInstanceId}/diagram

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances/{processInstanceId}/evaluate-conditions` | Evaluate the conditions of a process instance | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and the evaluation of the conditions was executed.
- **404**: Indicates the requested process instance was not found.
- **409**: Indicates the requested process instance action cannot be executed since the process-instance is already activated/suspended.

## POST /runtime/process-instances/{processInstanceId}/evaluate-conditions

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/process-instances/{processInstanceId}/identitylinks` | Get involved people for process instance | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and links are returned.
```json
[ {
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
} ]
```
- **404**: Indicates the requested process instance was not found.

## GET /runtime/process-instances/{processInstanceId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances/{processInstanceId}/identitylinks` | Add an involved user to a process instance | processInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

#### Responses
- **201**: Indicates the process instance was found and the link is created.
```json
{
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
}
```
- **400**: Indicates the requested body did not contain a userId or a type.
- **404**: Indicates the requested process instance was not found.

## POST /runtime/process-instances/{processInstanceId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}` | Get a specific involved people from process instance | processInstanceId (path,required), identityId (path,required), type (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and the specified link is retrieved.
```json
{
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
}
```
- **404**: Indicates the requested process instance was not found or the link to delete does not exist. The response status contains additional information about the error.

## GET /runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}` | Remove an involved user to from process instance | processInstanceId (path,required), identityId (path,required), type (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

#### Responses
- **204**: Indicates the process instance was found and the link has been deleted. Response body is left empty intentionally.
- **404**: Indicates the requested process instance was not found or the link to delete does not exist. The response status contains additional information about the error.

## DELETE /runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances/{processInstanceId}/inject` | Inject activity in a process instance | processInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/InjectActivityRequest |  |  |

#### Responses
- **200**: Indicates the process instance was updated and the activity injection was executed.
- **404**: Indicates the requested process instance was not found.
- **409**: Indicates the requested process instance action cannot be executed since the process-instance is already activated/suspended.

## POST /runtime/process-instances/{processInstanceId}/inject

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances/{processInstanceId}/migrate` | Migrate process instance | processInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | string |  |  |

#### Responses
- **200**: Indicates the process instance was found and migration was executed.
- **404**: Indicates the requested process instance was not found.
- **409**: Indicates the requested process instance action cannot be executed since the process-instance is already activated/suspended.

## POST /runtime/process-instances/{processInstanceId}/migrate

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/process-instances/{processInstanceId}/variables` | List variables for a process instance | processInstanceId (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and variables are returned.
```json
[ {
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
} ]
```
- **400**: Indicates the requested process instance was not found.

## GET /runtime/process-instances/{processInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances/{processInstanceId}/variables` | Create variables or new binary variable on a process instance | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableCollectionResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **200**: successful operation
```json
{ }
```
- **201**: Indicates the process instance was found and variable is created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the requested process instance was not found.
- **409**: Indicates the process instance was found but already contains a variable with the given name (only thrown when POST method is used). Use the update-method instead.

## POST /runtime/process-instances/{processInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/process-instances/{processInstanceId}/variables` | Update a multiple/single (non)binary variable on a process instance | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableCollectionResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **200**: successful operation
```json
{ }
```
- **201**: Indicates the process instance was found and variable is created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the requested process instance was not found.
- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.

## PUT /runtime/process-instances/{processInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/process-instances/{processInstanceId}/variables` | Delete all variables | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **204**: Indicates variables were found and have been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested process instance was not found.

## DELETE /runtime/process-instances/{processInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/process-instances/{processInstanceId}/variables-async` | Create variables or new binary variable on a process instance asynchronously | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableCollectionResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **201**: Indicates the job to create the variables was created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **409**: Indicates the process instance was found but already contains a variable with the given name (only thrown when POST method is used). Use the update-method instead.

## POST /runtime/process-instances/{processInstanceId}/variables-async

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/process-instances/{processInstanceId}/variables-async` | Update multiple/single (non)binary variables on a process instance asynchronously | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableCollectionResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **201**: Indicates the job to create or update the variables was created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.

## PUT /runtime/process-instances/{processInstanceId}/variables-async

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/process-instances/{processInstanceId}/variables-async/{variableName}` | Update a single variable on a process instance asynchronously | processInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **201**: Indicates the job to update the variable has been created.
- **404**: Indicates the process instance does not have a variable with the given name. Status description contains additional information about the error.

## PUT /runtime/process-instances/{processInstanceId}/variables-async/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Get a variable for a process instance | processInstanceId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates both the process instance and variable were found and variable is returned.
```json
{
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
}
```
- **404**: Indicates the requested process instance was not found or the process instance does not have a variable with the given name. Status description contains additional information about the error.

## GET /runtime/process-instances/{processInstanceId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Update a single variable on a process instance | processInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **200**: successful operation
```json
{
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
}
```
- **201**: Indicates both the process instance and variable were found and variable is updated.
- **404**: Indicates the requested process instance was not found or the process instance does not have a variable with the given name. Status description contains additional information about the error.

## PUT /runtime/process-instances/{processInstanceId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Delete a variable | processInstanceId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **204**: Indicates the variable was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested variable was not found.

## DELETE /runtime/process-instances/{processInstanceId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/process-instances/{processInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | processInstanceId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and the requested variables are returned.
```json
[ "string" ]
```
- **404**: Indicates the requested task was not found or the task does not have a variable with the given name (in the given scope). Status message provides additional information.

## GET /runtime/process-instances/{processInstanceId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/signals` | Signal event received | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/SignalEventReceivedRequest |  |  |

#### Responses
- **202**: Indicated signal processing is queued as a job, ready to be executed.
- **204**: Indicated signal has been processed and no errors occurred.
- **400**: Signal not processed. The signal name is missing or variables are used together with async, which is not allowed. Response body contains additional information about the error.

## POST /runtime/signals

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks` | List of tasks | taskId (query), name (query), nameLike (query), nameLikeIgnoreCase (query), description (query), priority (query), minimumPriority (query), maximumPriority (query), assignee (query), assigneeLike (query), owner (query), ownerLike (query), unassigned (query), delegationState (query), candidateUser (query), candidateGroup (query), candidateGroups (query), involvedUser (query), taskDefinitionKey (query), taskDefinitionKeyLike (query), taskDefinitionKeys (query), processInstanceId (query), processInstanceIdWithChildren (query), withoutProcessInstanceId (query), processInstanceBusinessKey (query), processInstanceBusinessKeyLike (query), processDefinitionId (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionName (query), processDefinitionNameLike (query), executionId (query), createdOn (query), createdBefore (query), createdAfter (query), dueDate (query), dueBefore (query), dueAfter (query), withoutDueDate (query), excludeSubTasks (query), active (query), includeTaskLocalVariables (query), includeProcessVariables (query), scopeDefinitionId (query), scopeId (query), withoutScopeId (query), scopeType (query), propagatedStageInstanceId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), candidateOrAssigned (query), category (query), categoryIn (query), categoryNotIn (query), withoutCategory (query), rootScopeId (query), parentScopeId (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | query |  |  | Only return tasks with the given id. |  |
| name | query |  |  | Only return tasks with the given version. |  |
| nameLike | query |  |  | Only return tasks with a name like the given name. |  |
| nameLikeIgnoreCase | query |  |  | Only return tasks with a name like the given name ignoring case. |  |
| description | query |  |  | Only return tasks with the given description. |  |
| priority | query |  |  | Only return tasks with the given priority. |  |
| minimumPriority | query |  |  | Only return tasks with a priority greater than the given value. |  |
| maximumPriority | query |  |  | Only return tasks with a priority lower than the given value. |  |
| assignee | query |  |  | Only return tasks assigned to the given user. |  |
| assigneeLike | query |  |  | Only return tasks assigned with an assignee like the given value. |  |
| owner | query |  |  | Only return tasks owned by the given user. |  |
| ownerLike | query |  |  | Only return tasks assigned with an owner like the given value. |  |
| unassigned | query |  |  | Only return tasks that are not assigned to anyone. If false is passed, the value is ignored. |  |
| delegationState | query |  |  | Only return tasks that have the given delegation state. Possible values are pending and resolved. |  |
| candidateUser | query |  |  | Only return tasks that can be claimed by the given user. This includes both tasks where the user is an explicit candidate for and task that are claimable by a group that the user is a member of. |  |
| candidateGroup | query |  |  | Only return tasks that can be claimed by a user in the given group. |  |
| candidateGroups | query |  |  | Only return tasks that can be claimed by a user in the given groups. Values split by comma. |  |
| involvedUser | query |  |  | Only return tasks in which the given user is involved. |  |
| taskDefinitionKey | query |  |  | Only return tasks with the given task definition id. |  |
| taskDefinitionKeyLike | query |  |  | Only return tasks with a given task definition id like the given value. |  |
| taskDefinitionKeys | query |  |  | Only return tasks with the given task definition ids. |  |
| processInstanceId | query |  |  | Only return tasks which are part of the process instance with the given id. |  |
| processInstanceIdWithChildren | query |  |  | Only return tasks which are part of the process instance and its children with the given id. |  |
| withoutProcessInstanceId | query |  |  | If true, only returns tasks without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| processInstanceBusinessKey | query |  |  | Only return tasks which are part of the process instance with the given business key. |  |
| processInstanceBusinessKeyLike | query |  |  | Only return tasks which are part of the process instance which has a business key like the given value. |  |
| processDefinitionId | query |  |  | Only return tasks which are part of a process instance which has a process definition with the given id. |  |
| processDefinitionKey | query |  |  | Only return tasks which are part of a process instance which has a process definition with the given key. |  |
| processDefinitionKeyLike | query |  |  | Only return tasks which are part of a process instance which has a process definition with a key like the given value. |  |
| processDefinitionName | query |  |  | Only return tasks which are part of a process instance which has a process definition with the given name. |  |
| processDefinitionNameLike | query |  |  | Only return tasks which are part of a process instance which has a process definition with a name like the given value. |  |
| executionId | query |  |  | Only return tasks which are part of the execution with the given id. |  |
| createdOn | query |  |  | Only return tasks which are created on the given date. |  |
| createdBefore | query |  |  | Only return tasks which are created before the given date. |  |
| createdAfter | query |  |  | Only return tasks which are created after the given date. |  |
| dueDate | query |  |  | Only return tasks which are due on the given date. |  |
| dueBefore | query |  |  | Only return tasks which are due before the given date. |  |
| dueAfter | query |  |  | Only return tasks which are due after the given date. |  |
| withoutDueDate | query |  |  | Only return tasks which do not have a due date. The property is ignored if the value is false. |  |
| excludeSubTasks | query |  |  | Only return tasks that are not a subtask of another task. |  |
| active | query |  |  | If true, only return tasks that are not suspended (either part of a process that is not suspended or not part of a process at all). If false, only tasks that are part of suspended process instances are returned. |  |
| includeTaskLocalVariables | query |  |  | Indication to include task local variables in the result. |  |
| includeProcessVariables | query |  |  | Indication to include process variables in the result. |  |
| scopeDefinitionId | query |  |  | Only return tasks with the given scopeDefinitionId. |  |
| scopeId | query |  |  | Only return tasks with the given scopeId. |  |
| withoutScopeId | query |  |  | If true, only returns tasks without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| scopeType | query |  |  | Only return tasks with the given scopeType. |  |
| propagatedStageInstanceId | query |  |  | Only return tasks which have the given id as propagated stage instance id |  |
| tenantId | query |  |  | Only return tasks with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return tasks with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns tasks without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| candidateOrAssigned | query |  |  | Select tasks that has been claimed or assigned to user or waiting to claim by user (candidate user or groups). |  |
| category | query |  |  | Select tasks with the given category. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| categoryIn | query |  |  | Select tasks for the given categories. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| categoryNotIn | query |  |  | Select tasks which are not assigned to the given categories. Does not return tasks without categories. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| withoutCategory | query |  |  | Select tasks without a category assigned. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| rootScopeId | query |  |  | Only return tasks which have the given root scope id (that can be a process or case instance ID). |  |
| parentScopeId | query |  |  | Only return tasks which have the given parent scope id (that can be a process or case instance ID). |  |
| sort | query |  |  | The field to sort by. Defaults to 'id'. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates request was successful and the tasks are returned
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
- **404**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.

## GET /runtime/tasks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/tasks` | Create Task | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/TaskRequest |  |  |

#### Responses
- **201**: Indicates request was successful and the tasks are returned
```json
{
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
}
```
- **400**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.

## POST /runtime/tasks

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/tasks` | Update Tasks | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkTasksRequest |  |  |

#### Responses
- **200**: successful operation
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
- **201**: Indicates request was successful and the tasks are returned
- **400**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.

## PUT /runtime/tasks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}` | Get a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task was found and returned.
```json
{
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
}
```
- **404**: Indicates the requested task was not found.

## GET /runtime/tasks/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/tasks/{taskId}` | Tasks actions | taskId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskActionRequest |  |  |

#### Responses
- **200**: Indicates the action was executed.
- **400**: When the body contains an invalid value or when the assignee is missing when the action requires it.
- **404**: Indicates the requested task was not found.
- **409**: Indicates the action cannot be performed due to a conflict. Either the task was updates simultaneously or the task was claimed by another user, in case of the claim action.

## POST /runtime/tasks/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/tasks/{taskId}` | Update a task | taskId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskRequest |  |  |

#### Responses
- **200**: Indicates the task was updated.
```json
{
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
}
```
- **404**: Indicates the requested task was not found.
- **409**: Indicates the requested task was updated simultaneously.

## PUT /runtime/tasks/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/tasks/{taskId}` | Delete a task | taskId (path,required), cascadeHistory (query), deleteReason (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| cascadeHistory | query |  |  | Whether or not to delete the HistoricTask instance when deleting the task (if applicable). If not provided, this value defaults to false. |  |
| deleteReason | query |  |  | Reason why the task is deleted. This value is ignored when cascadeHistory is true. |  |

#### Responses
- **204**: Indicates the task was found and has been deleted. Response-body is intentionally empty.
- **403**: Indicates the requested task cannot be deleted because it’s part of a workflow.
- **404**: Indicates the requested task was not found.

## DELETE /runtime/tasks/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/attachments` | List attachments on a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task was found and the attachments are returned.
```json
[ {
  "id" : "string",
  "url" : "string",
  "name" : "string",
  "userId" : "string",
  "description" : "string",
  "type" : "string",
  "taskUrl" : "string",
  "processInstanceUrl" : "string",
  "externalUrl" : "string",
  "contentUrl" : "string",
  "time" : "1970-01-01T00:00:00Z"
} ]
```
- **404**: Indicates the requested task was not found.

## GET /runtime/tasks/{taskId}/attachments

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/tasks/{taskId}/attachments` | Create a new attachment on a task, containing a link to an external resource or an attached file | taskId (path,required), body (body), file (formData), name (formData), description (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskAttachmentCollectionResource | create an attachment containing a link to an external resource |  |
| file | formData |  |  | Attachment file |  |
| name | formData |  |  | Required name of the variable |  |
| description | formData |  |  | Description of the attachment, optional |  |
| type | formData |  |  | Type of attachment, optional. Supports any arbitrary string or a valid HTTP content-type. |  |

#### Responses
- **201**: Indicates the attachment was created and the result is returned.
```json
{
  "id" : "string",
  "url" : "string",
  "name" : "string",
  "userId" : "string",
  "description" : "string",
  "type" : "string",
  "taskUrl" : "string",
  "processInstanceUrl" : "string",
  "externalUrl" : "string",
  "contentUrl" : "string",
  "time" : "1970-01-01T00:00:00Z"
}
```
- **400**: Indicates the attachment name is missing from the request.
- **404**: Indicates the requested task was not found.

## POST /runtime/tasks/{taskId}/attachments

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/attachments/{attachmentId}` | Get an attachment on a task | taskId (path,required), attachmentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| attachmentId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task and attachment were found and the attachment is returned.
```json
{
  "id" : "string",
  "url" : "string",
  "name" : "string",
  "userId" : "string",
  "description" : "string",
  "type" : "string",
  "taskUrl" : "string",
  "processInstanceUrl" : "string",
  "externalUrl" : "string",
  "contentUrl" : "string",
  "time" : "1970-01-01T00:00:00Z"
}
```
- **404**: Indicates the requested task was not found or the tasks does not have a attachment with the given ID.

## GET /runtime/tasks/{taskId}/attachments/{attachmentId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/tasks/{taskId}/attachments/{attachmentId}` | Delete an attachment on a task | taskId (path,required), attachmentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| attachmentId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the task and attachment were found and the attachment is deleted. Response body is left empty intentionally.
- **404**: Indicates the requested task was not found or the tasks does not have a attachment with the given ID.

## DELETE /runtime/tasks/{taskId}/attachments/{attachmentId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/attachments/{attachmentId}/content` | Get the content for an attachment | taskId (path,required), attachmentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| attachmentId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task and attachment was found and the requested content is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested task was not found or the task does not have an attachment with the given id or the attachment does not have a binary stream available. Status message provides additional information.

## GET /runtime/tasks/{taskId}/attachments/{attachmentId}/content

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/comments` | List comments on a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task was found and the comments are returned.
```json
[ {
  "id" : "string",
  "author" : "string",
  "message" : "string",
  "time" : "1970-01-01T00:00:00Z",
  "taskId" : "string",
  "taskUrl" : "string",
  "processInstanceId" : "string",
  "processInstanceUrl" : "string"
} ]
```
- **404**: Indicates the requested task was not found.

## GET /runtime/tasks/{taskId}/comments

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/tasks/{taskId}/comments` | Create a new comment on a task | taskId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/CommentRequest |  |  |

#### Responses
- **201**: Indicates the comment was created and the result is returned.
```json
{
  "id" : "string",
  "author" : "string",
  "message" : "string",
  "time" : "1970-01-01T00:00:00Z",
  "taskId" : "string",
  "taskUrl" : "string",
  "processInstanceId" : "string",
  "processInstanceUrl" : "string"
}
```
- **400**: Indicates the comment is missing from the request.
- **404**: Indicates the requested task was not found.

## POST /runtime/tasks/{taskId}/comments

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/comments/{commentId}` | Get a comment on a task | taskId (path,required), commentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| commentId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task and comment were found and the comment is returned.
```json
{
  "id" : "string",
  "author" : "string",
  "message" : "string",
  "time" : "1970-01-01T00:00:00Z",
  "taskId" : "string",
  "taskUrl" : "string",
  "processInstanceId" : "string",
  "processInstanceUrl" : "string"
}
```
- **404**: Indicates the requested task was not found or the tasks does not have a comment with the given ID.

## GET /runtime/tasks/{taskId}/comments/{commentId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/tasks/{taskId}/comments/{commentId}` | Delete a comment on a task | taskId (path,required), commentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| commentId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the task and comment were found and the comment is deleted. Response body is left empty intentionally.
- **404**: Indicates the requested task was not found or the tasks does not have a comment with the given ID.

## DELETE /runtime/tasks/{taskId}/comments/{commentId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/events` | List events for a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task was found and the events are returned.
```json
[ {
  "url" : "string",
  "id" : "string",
  "action" : "string",
  "userId" : "string",
  "time" : "1970-01-01T00:00:00Z",
  "taskUrl" : "string",
  "processInstanceUrl" : "string",
  "message" : [ "string" ]
} ]
```
- **404**: Indicates the requested task was not found.

## GET /runtime/tasks/{taskId}/events

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/events/{eventId}` | Get an event on a task | taskId (path,required), eventId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| eventId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task and event were found and the event is returned.
```json
{
  "url" : "string",
  "id" : "string",
  "action" : "string",
  "userId" : "string",
  "time" : "1970-01-01T00:00:00Z",
  "taskUrl" : "string",
  "processInstanceUrl" : "string",
  "message" : [ "string" ]
}
```
- **404**: Indicates the requested task was not found or the tasks does not have an event with the given ID.

## GET /runtime/tasks/{taskId}/events/{eventId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/tasks/{taskId}/events/{eventId}` | Delete an event on a task | taskId (path,required), eventId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| eventId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the task was found and the events are returned.
- **404**: Indicates the requested task was not found or the task does not have the requested event.

## DELETE /runtime/tasks/{taskId}/events/{eventId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/form` | Get a task form | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the task form is returned
```json
"string"
```
- **404**: Indicates the requested task was not found.

## GET /runtime/tasks/{taskId}/form

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/identitylinks` | List identity links for a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task was found and the requested identity links are returned.
```json
[ {
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
} ]
```
- **404**: Indicates the requested task was not found.

## GET /runtime/tasks/{taskId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/tasks/{taskId}/identitylinks` | Create an identity link on a task | taskId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

#### Responses
- **201**: Indicates the task was found and the identity link was created.
```json
{
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
}
```
- **404**: Indicates the requested task was not found or the task does not have the requested identityLink. The status contains additional information about this error.

## POST /runtime/tasks/{taskId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/identitylinks/{family}` | List identity links for a task for either groups or users | taskId (path,required), family (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| family | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task was found and the requested identity links are returned.
```json
[ {
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
} ]
```
- **404**: Indicates the requested task was not found.

## GET /runtime/tasks/{taskId}/identitylinks/{family}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Get a single identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task and identity link was found and returned.
```json
{
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
}
```
- **404**: Indicates the requested task was not found or the task does not have the requested identityLink. The status contains additional information about this error.

## GET /runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Delete an identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

#### Responses
- **204**: Indicates the task and identity link were found and the link has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested task was not found or the task does not have the requested identityLink. The status contains additional information about this error.

## DELETE /runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/subtasks` | List of sub tasks for a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the  sub tasks are returned
```json
[ {
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
} ]
```
- **404**: Indicates the requested task was not found.

## GET /runtime/tasks/{taskId}/subtasks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/variables` | List variables for a task | taskId (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

#### Responses
- **200**: Indicates the task was found and the requested variables are returned
```json
[ {
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
} ]
```
- **404**: Indicates the requested task was not found..

## GET /runtime/tasks/{taskId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/runtime/tasks/{taskId}/variables` | Create new variables on a task | taskId (path,required), body (body), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskVariableCollectionResource | Create a variable on a task |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is created. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable that is created. If omitted, local is assumed. |  |

#### Responses
- **201**: Indicates the variables were created and the result is returned.
```json
{ }
```
- **400**: Indicates the name of a variable to create was missing or that an attempt is done to create a variable on a standalone task (without a process associated) with scope global or an empty array of variables was included in the request or request did not contain an array of variables. Status message provides additional information.
- **404**: Indicates the requested task was not found.
- **409**: Indicates the task already has a variable with the given name. Use the PUT method to update the task variable instead.
- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.

## POST /runtime/tasks/{taskId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/tasks/{taskId}/variables` | Delete all local variables on a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **204**: Indicates all local task variables have been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested task was not found.

## DELETE /runtime/tasks/{taskId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/variables/{variableName}` | Get a variable from a task | taskId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

#### Responses
- **200**: Indicates the task was found and the requested variables are returned.
```json
{
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
}
```
- **404**: Indicates the requested task was not found or the task does not have a variable with the given name (in the given scope). Status message provides additional information.

## GET /runtime/tasks/{taskId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/runtime/tasks/{taskId}/variables/{variableName}` | Update an existing variable on a task | taskId (path,required), variableName (path,required), body (body), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/TaskVariableResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

#### Responses
- **200**: Indicates the variables was updated and the result is returned.
```json
{
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
}
```
- **400**: Indicates the name of a variable to update was missing or that an attempt is done to update a variable on a standalone task (without a process associated) with scope global. Status message provides additional information.
- **404**: Indicates the requested task was not found or the task does not have a variable with the given name in the given scope. Status message contains additional information about the error.
- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.

## PUT /runtime/tasks/{taskId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/runtime/tasks/{taskId}/variables/{variableName}` | Delete a variable on a task | taskId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

#### Responses
- **204**: Indicates the task variable was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested task was not found or the task does not have a variable with the given name. Status message contains additional information about the error.

## DELETE /runtime/tasks/{taskId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/tasks/{taskId}/variables/{variableName}/data` | Get the binary data for a variable | taskId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

#### Responses
- **200**: Indicates the task was found and the requested variables are returned.
```json
[ "string" ]
```
- **404**: Indicates the requested task was not found or the task does not have a variable with the given name (in the given scope). Status message provides additional information.

## GET /runtime/tasks/{taskId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/variable-instances` | List of variable instances | processInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | query |  |  | The process instance id of the variable instance. |  |
| taskId | query |  |  | The task id of the variable instance. |  |
| excludeTaskVariables | query |  |  | Indication to exclude the task variables from the result. |  |
| excludeLocalVariables | query |  |  | Indication to exclude local variables or not. |  |
| variableName | query |  |  | The variable name of the variable instance. |  |
| variableNameLike | query |  |  | The variable name using the like operator for the variable instance. |  |
| sort | query |  |  | The field to sort by. Defaults to 'variableName'. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

#### Responses
- **200**: Indicates that variable instances could be queried.
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

## GET /runtime/variable-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/runtime/variable-instances/{varInstanceId}/data` | Get the binary data for a variable instance | varInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| varInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the variable instance was found and the requested variable data is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested variable instance was not found or the variable instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
