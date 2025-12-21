# flowable-swagger-process

> Generated subset extracted from server_fetch/flowable-swagger-process.json

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/form/form-data` | Get form data | taskId (query), processDefinitionId (query) |

### GET /form/form-data

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

### POST /form/form-data

Submit task form data

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/SubmitFormRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/SubmitFormRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the form data was submitted

```json
{
  "$ref": "#/definitions/ProcessInstanceResponse"
}
```

- **204**: If TaskId has been provided, Indicates request was successful and the form data was submitted. Returns empty

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/history/historic-activity-instances` | List historic activity instances | activityId (query), activityInstanceId (query), activityName (query), activityType (query), executionId (query), finished (query), taskAssignee (query), processInstanceId (query), processDefinitionId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query) |

### GET /history/historic-activity-instances

List historic activity instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| activityId | query |  |  | An id of the activity instance. |  |
| activityInstanceId | query |  |  | An id of the historic activity instance. |  |
| activityName | query |  |  | The name of the historic activity instance. |  |
| activityType | query |  |  | The element type of the historic activity instance. |  |
| executionId | query |  |  | The execution id of the historic activity instance. |  |
| finished | query |  |  | Indication if the historic activity instance is finished. |  |
| taskAssignee | query |  |  | The assignee of the historic activity instance. |  |
| processInstanceId | query |  |  | The process instance id of the historic activity instance. |  |
| processDefinitionId | query |  |  | The process definition id of the historic activity instance. |  |
| tenantId | query |  |  | Only return instances with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return instances with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |

**Responses**

- **200**: Indicates that historic activity instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricActivityInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/history/historic-detail` | Get historic detail | id (query), processInstanceId (query), executionId (query), activityInstanceId (query), taskId (query), selectOnlyFormProperties (query), selectOnlyVariableUpdates (query) |

### GET /history/historic-detail

Get historic detail

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | The id of the historic detail. |  |
| processInstanceId | query |  |  | The process instance id of the historic detail. |  |
| executionId | query |  |  | The execution id of the historic detail. |  |
| activityInstanceId | query |  |  | The activity instance id of the historic detail. |  |
| taskId | query |  |  | The task id of the historic detail. |  |
| selectOnlyFormProperties | query |  |  | Indication to only return form properties in the result. |  |
| selectOnlyVariableUpdates | query |  |  | Indication to only return variable updates in the result. |  |

**Responses**

- **200**: Indicates that historic detail could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricDetailResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/history/historic-detail/{detailId}/data` | Get the binary data for a historic detail variable | detailId (path,required) |

### GET /history/historic-detail/{detailId}/data

The response body contains the binary value of the variable. When the variable is of type binary, the content-type of the response is set to application/octet-stream, regardless of the content of the variable or the request accept-type header. In case of serializable, application/x-java-serialized-object is used as content-type.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| detailId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the historic detail instance was found and the requested variable data is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested historic detail instance was not found or the historic detail instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
| GET | `/history/historic-process-instances` | List of historic process instances | processInstanceId (query), processInstanceName (query), processInstanceNameLike (query), processInstanceNameLikeIgnoreCase (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionKeyLikeIgnoreCase (query), processDefinitionId (query), processDefinitionName (query), processDefinitionNameLike (query), processDefinitionNameLikeIgnoreCase (query), processDefinitionCategory (query), processDefinitionCategoryLike (query), processDefinitionCategoryLikeIgnoreCase (query), processDefinitionVersion (query), deploymentId (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), activeActivityId (query), involvedUser (query), finished (query), superProcessInstanceId (query), excludeSubprocesses (query), finishedAfter (query), finishedBefore (query), startedAfter (query), startedBefore (query), startedBy (query), includeProcessVariables (query), includeProcessVariablesName (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), withoutCallbackId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query) |

### GET /history/historic-process-instances

List of historic process instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | query |  |  | An id of the historic process instance. |  |
| processInstanceName | query |  |  | A name of the historic process instance. |  |
| processInstanceNameLike | query |  |  | A name of the historic process instance used in a like query. |  |
| processInstanceNameLikeIgnoreCase | query |  |  | A name of the historic process instance used in a like query ignoring case. |  |
| processDefinitionKey | query |  |  | The process definition key of the historic process instance. |  |
| processDefinitionKeyLike | query |  |  | The process definition key used in a like query. |  |
| processDefinitionKeyLikeIgnoreCase | query |  |  | The process definition key used in a like query ignoring case. |  |
| processDefinitionId | query |  |  | The process definition id of the historic process instance. |  |
| processDefinitionName | query |  |  | The process definition name of the historic process instance. |  |
| processDefinitionNameLike | query |  |  | The process definition name used in a like query. |  |
| processDefinitionNameLikeIgnoreCase | query |  |  | The process definition name used in a like query ignoring case. |  |
| processDefinitionCategory | query |  |  | The process definition category of the historic process instance. |  |
| processDefinitionCategoryLike | query |  |  | The process definition category used in a like query. |  |
| processDefinitionCategoryLikeIgnoreCase | query |  |  | The process definition category used in a like query ignoring case. |  |
| processDefinitionVersion | query |  |  | The process definition version of the historic process instance. |  |
| deploymentId | query |  |  | The deployment id of the historic process instance. |  |
| rootScopeId | query |  |  | Only return process instances which have the given root scope id (that can be a process or case instance ID). |  |
| parentScopeId | query |  |  | Only return process instances which have the given parent scope id (that can be a process or case instance ID). |  |
| businessKey | query |  |  | The business key of the historic process instance. |  |
| businessKeyLike | query |  |  | Only return instances with a business key like this key. |  |
| businessKeyLikeIgnoreCase | query |  |  | Only return instances with a business key like this key ignoring case. |  |
| businessStatus | query |  |  | The business status of the historic process instance. |  |
| businessStatusLike | query |  |  | Only return instances with a business status like this status. |  |
| businessStatusLikeIgnoreCase | query |  |  | Only return instances with a business status like this status ignoring case. |  |
| activeActivityId | query |  |  | Only return instances which have an active activity instance with the provided activity id. |  |
| involvedUser | query |  |  | An involved user of the historic process instance. |  |
| finished | query |  |  | Indication if the historic process instance is finished. |  |
| superProcessInstanceId | query |  |  | An optional parent process id of the historic process instance. |  |
| excludeSubprocesses | query |  |  | Return only historic process instances which are not sub processes. |  |
| finishedAfter | query |  |  | Return only historic process instances that were finished after this date. |  |
| finishedBefore | query |  |  | Return only historic process instances that were finished before this date. |  |
| startedAfter | query |  |  | Return only historic process instances that were started after this date. |  |
| startedBefore | query |  |  | Return only historic process instances that were started before this date. |  |
| startedBy | query |  |  | Return only historic process instances that were started by this user. |  |
| includeProcessVariables | query |  |  | An indication if the historic process instance variables should be returned as well. |  |
| includeProcessVariablesName | query |  |  | Indication to include process variables with the given names in the result. |  |
| callbackId | query |  |  | Only return instances with the given callbackId. |  |
| callbackType | query |  |  | Only return instances with the given callbackType. |  |
| parentCaseInstanceId | query |  |  | Only return instances with the given parent case instance id. |  |
| withoutCallbackId | query |  |  | Only return instances that do not have a callbackId. |  |
| tenantId | query |  |  | Only return instances with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return instances with a tenant id like the given value. |  |
| tenantIdLikeIgnoreCase | query |  |  | Only return instances with a tenant id like the given value ignoring case. |  |
| withoutTenantId | query |  |  | If true, only returns instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |

**Responses**

- **200**: Indicates that historic process instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricProcessInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/history/historic-process-instances/delete` | Post action request to delete a bulk of historic process instances | bulkDeleteRestActionRequest (body) |

### POST /history/historic-process-instances/delete

Post action request to delete a bulk of historic process instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| bulkDeleteRestActionRequest | body |  | #/definitions/BulkDeleteInstancesRestActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/BulkDeleteInstancesRestActionRequest"
}
```

**Responses**

- **204**: Indicates the bulk of historic process instances was found and deleted. Response body is left empty intentionally.

- **404**: Indicates at least one requested process instance was not found.
| GET | `/history/historic-process-instances/{processInstanceId}` | Get a historic process instance | processInstanceId (path,required) |

### GET /history/historic-process-instances/{processInstanceId}

Get a historic process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates that the historic process instances could be found.

```json
{
  "$ref": "#/definitions/HistoricProcessInstanceResponse"
}
```

- **404**: Indicates that the historic process instances could not be found.
| DELETE | `/history/historic-process-instances/{processInstanceId}` | Delete a historic process instance | processInstanceId (path,required) |

### DELETE /history/historic-process-instances/{processInstanceId}

Delete a historic process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **204**: Indicates that the historic process instance was deleted.

- **404**: Indicates that the historic process instance could not be found.
| GET | `/history/historic-process-instances/{processInstanceId}/comments` | List comments on a historic process instance | processInstanceId (path,required) |

### GET /history/historic-process-instances/{processInstanceId}/comments

List comments on a historic process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and the comments are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/CommentResponse"
  }
}
```

- **404**: Indicates that the historic process instance could not be found.
| POST | `/history/historic-process-instances/{processInstanceId}/comments` | Create a new comment on a historic process instance | processInstanceId (path,required), body (body) |

### POST /history/historic-process-instances/{processInstanceId}/comments

Parameter saveProcessInstanceId is optional, if true save process instance id of task with comment.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CommentResponse |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CommentResponse"
}
```

**Responses**

- **201**: Indicates the comment was created and the result is returned.

```json
{
  "$ref": "#/definitions/CommentResponse"
}
```

- **400**: Indicates the comment is missing from the request.

- **404**: Indicates that the historic process instance could not be found.
| GET | `/history/historic-process-instances/{processInstanceId}/comments/{commentId}` | Get a comment on a historic process instance | processInstanceId (path,required), commentId (path,required) |

### GET /history/historic-process-instances/{processInstanceId}/comments/{commentId}

Get a comment on a historic process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| commentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the historic process instance and comment were found and the comment is returned.

```json
{
  "$ref": "#/definitions/CommentResponse"
}
```

- **404**: Indicates the requested historic process instance was not found or the historic process instance does not have a comment with the given ID.
| DELETE | `/history/historic-process-instances/{processInstanceId}/comments/{commentId}` | Delete a comment on a historic process instance | processInstanceId (path,required), commentId (path,required) |

### DELETE /history/historic-process-instances/{processInstanceId}/comments/{commentId}

Delete a comment on a historic process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| commentId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the historic process instance and comment were found and the comment is deleted. Response body is left empty intentionally.

- **404**: Indicates the requested historic process instance was not found or the historic process instance does not have a comment with the given ID.
| GET | `/history/historic-process-instances/{processInstanceId}/identitylinks` | List identity links of a historic process instance | processInstanceId (path,required) |

### GET /history/historic-process-instances/{processInstanceId}/identitylinks

List identity links of a historic process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the identity links are returned

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/HistoricIdentityLinkResponse"
  }
}
```

- **404**: Indicates the process instance could not be found..
| GET | `/history/historic-process-instances/{processInstanceId}/variables/{variableName}/data` | Get the binary data for a historic process instance variable | processInstanceId (path,required), variableName (path,required) |

### GET /history/historic-process-instances/{processInstanceId}/variables/{variableName}/data

The response body contains the binary value of the variable. When the variable is of type binary, the content-type of the response is set to application/octet-stream, regardless of the content of the variable or the request accept-type header. In case of serializable, application/x-java-serialized-object is used as content-type.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and the requested variable data is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested process instance was not found or the process instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
| GET | `/history/historic-task-instances` | List historic task instances | taskId (query), processInstanceId (query), processInstanceIdWithChildren (query), withoutProcessInstanceId (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionId (query), processDefinitionName (query), processDefinitionNameLike (query), processBusinessKey (query), processBusinessKeyLike (query), executionId (query), taskDefinitionKey (query), taskDefinitionKeys (query), taskName (query), taskNameLike (query), taskNameLikeIgnoreCase (query), taskDescription (query), taskDescriptionLike (query), taskCategory (query), taskCategoryIn (query), taskCategoryNotIn (query), taskWithoutCategory (query), taskDeleteReason (query), taskDeleteReasonLike (query), taskAssignee (query), taskAssigneeLike (query), taskOwner (query), taskOwnerLike (query), taskInvolvedUser (query), taskCandidateGroup (query), taskPriority (query), finished (query), processFinished (query), parentTaskId (query), dueDate (query), dueDateAfter (query), dueDateBefore (query), withoutDueDate (query), taskCompletedOn (query), taskCompletedAfter (query), taskCompletedBefore (query), taskCreatedOn (query), taskCreatedBefore (query), taskCreatedAfter (query), includeTaskLocalVariables (query), includeProcessVariables (query), scopeDefinitionId (query), scopeId (query), withoutScopeId (query), scopeType (query), propagatedStageInstanceId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), rootScopeId (query), parentScopeId (query) |

### GET /history/historic-task-instances

List historic task instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | query |  |  | An id of the historic task instance. |  |
| processInstanceId | query |  |  | The process instance id of the historic task instance. |  |
| processInstanceIdWithChildren | query |  |  | Selects the historic task instances for the process instance and its children. |  |
| withoutProcessInstanceId | query |  |  | If true, only returns historic task instances without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| processDefinitionKey | query |  |  | The process definition key of the historic task instance. |  |
| processDefinitionKeyLike | query |  |  | The process definition key of the historic task instance, which matches the given value. |  |
| processDefinitionId | query |  |  | The process definition id of the historic task instance. |  |
| processDefinitionName | query |  |  | The process definition name of the historic task instance. |  |
| processDefinitionNameLike | query |  |  | The process definition name of the historic task instance, which matches the given value. |  |
| processBusinessKey | query |  |  | The process instance business key of the historic task instance. |  |
| processBusinessKeyLike | query |  |  | The process instance business key of the historic task instance that matches the given value. |  |
| executionId | query |  |  | The execution id of the historic task instance. |  |
| taskDefinitionKey | query |  |  | The task definition key for tasks part of a process |  |
| taskDefinitionKeys | query |  |  | The task definition key for tasks part of a process |  |
| taskName | query |  |  | The task name of the historic task instance. |  |
| taskNameLike | query |  |  | The task name with like operator for the historic task instance. |  |
| taskNameLikeIgnoreCase | query |  |  | The task name with like operator for the historic task instance ignoring case. |  |
| taskDescription | query |  |  | The task description of the historic task instance. |  |
| taskDescriptionLike | query |  |  | The task description with like operator for the historic task instance. |  |
| taskCategory | query |  |  | Select tasks with the given category. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| taskCategoryIn | query |  |  | Select tasks with the given categories. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| taskCategoryNotIn | query |  |  | Select tasks not assigned to the given categories. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| taskWithoutCategory | query |  |  | Select tasks with no category assigned. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| taskDeleteReason | query |  |  | The task delete reason of the historic task instance. |  |
| taskDeleteReasonLike | query |  |  | The task delete reason with like operator for the historic task instance. |  |
| taskAssignee | query |  |  | The assignee of the historic task instance. |  |
| taskAssigneeLike | query |  |  | The assignee with like operator for the historic task instance. |  |
| taskOwner | query |  |  | The owner of the historic task instance. |  |
| taskOwnerLike | query |  |  | The owner with like operator for the historic task instance. |  |
| taskInvolvedUser | query |  |  | An involved user of the historic task instance |  |
| taskCandidateGroup | query |  |  | Only return tasks that can be claimed by a user in the given group. |  |
| taskPriority | query |  |  | The priority of the historic task instance. |  |
| finished | query |  |  | Indication if the historic task instance is finished. |  |
| processFinished | query |  |  | Indication if the process instance of the historic task instance is finished. |  |
| parentTaskId | query |  |  | An optional parent task id of the historic task instance. |  |
| dueDate | query |  |  | Return only historic task instances that have a due date equal this date. |  |
| dueDateAfter | query |  |  | Return only historic task instances that have a due date after this date. |  |
| dueDateBefore | query |  |  | Return only historic task instances that have a due date before this date. |  |
| withoutDueDate | query |  |  | Return only historic task instances that have no due-date. When false is provided as value, this parameter is ignored. |  |
| taskCompletedOn | query |  |  | Return only historic task instances that have been completed on this date. |  |
| taskCompletedAfter | query |  |  | Return only historic task instances that have been completed after this date. |  |
| taskCompletedBefore | query |  |  | Return only historic task instances that have been completed before this date. |  |
| taskCreatedOn | query |  |  | Return only historic task instances that were created on this date. |  |
| taskCreatedBefore | query |  |  | Return only historic task instances that were created before this date. |  |
| taskCreatedAfter | query |  |  | Return only historic task instances that were created after this date. |  |
| includeTaskLocalVariables | query |  |  | An indication if the historic task instance local variables should be returned as well. |  |
| includeProcessVariables | query |  |  | An indication if the historic task instance global variables should be returned as well. |  |
| scopeDefinitionId | query |  |  | Only return historic task instances with the given scopeDefinitionId. |  |
| scopeId | query |  |  | Only return historic task instances with the given scopeId. |  |
| withoutScopeId | query |  |  | If true, only returns historic task instances without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| scopeType | query |  |  | Only return historic task instances with the given scopeType. |  |
| propagatedStageInstanceId | query |  |  | Only return tasks which have the given id as propagated stage instance id |  |
| tenantId | query |  |  | Only return historic task instances with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return historic task instances with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns historic task instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| rootScopeId | query |  |  | Only return case instances which have the given root scope id (that can be a process or case instance ID). |  |
| parentScopeId | query |  |  | Only return case instances which have the given parent scope id (that can be a process or case instance ID). |  |

**Responses**

- **200**: Indicates that historic task instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricTaskInstanceResponse"
}
```

- **404**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/history/historic-task-instances/{taskId}` | Get a single historic task instance | taskId (path,required) |

### GET /history/historic-task-instances/{taskId}

Get a single historic task instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates that the historic task instances could be found.

```json
{
  "$ref": "#/definitions/HistoricTaskInstanceResponse"
}
```

- **404**: Indicates that the historic task instances could not be found.
| DELETE | `/history/historic-task-instances/{taskId}` | Delete a historic task instance | taskId (path,required) |

### DELETE /history/historic-task-instances/{taskId}

Delete a historic task instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **204**: Indicates that the historic task instance was deleted.

- **404**: Indicates that the historic task instance could not be found.
| GET | `/history/historic-task-instances/{taskId}/form` | Get a historic task instance form | taskId (path,required) |

### GET /history/historic-task-instances/{taskId}/form

Get a historic task instance form

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the task form is returned

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested task was not found.
| GET | `/history/historic-task-instances/{taskId}/identitylinks` | List identity links of a historic task instance | taskId (path,required) |

### GET /history/historic-task-instances/{taskId}/identitylinks

List identity links of a historic task instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the identity links are returned

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/HistoricIdentityLinkResponse"
  }
}
```

- **404**: Indicates the task instance could not be found.
| GET | `/history/historic-task-instances/{taskId}/variables/{variableName}/data` | Get the binary data for a historic task instance variable | taskId (path,required), variableName (path,required), scope (query) |

### GET /history/historic-task-instances/{taskId}/variables/{variableName}/data

The response body contains the binary value of the variable. When the variable is of type binary, the content-type of the response is set to application/octet-stream, regardless of the content of the variable or the request accept-type header. In case of serializable, application/x-java-serialized-object is used as content-type.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates the task instance was found and the requested variable data is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested task instance was not found or the process instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
| GET | `/history/historic-task-log-entries` | List historic task log entries | taskId (query), type (query), userId (query), processInstanceId (query), processDefinitionId (query), scopeId (query), scopeDefinitionId (query), subScopeId (query), scopeType (query), from (query), to (query), tenantId (query), fromLogNumber (query), toLogNumber (query), sort (query), order (query), start (query), size (query) |

### GET /history/historic-task-log-entries

List historic task log entries

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | query |  |  | An id of the historic task instance. |  |
| type | query |  |  | The type of the log entry. |  |
| userId | query |  |  | The user who produced the task change. |  |
| processInstanceId | query |  |  | The process instance id of the historic task log entry. |  |
| processDefinitionId | query |  |  | The process definition id of the historic task log entry. |  |
| scopeId | query |  |  | Only return historic task log entries with the given scopeId. |  |
| scopeDefinitionId | query |  |  | Only return historic task log entries with the given scopeDefinitionId. |  |
| subScopeId | query |  |  | Only return historic task log entries with the given subScopeId |  |
| scopeType | query |  |  | Only return historic task log entries with the given scopeType. |  |
| from | query |  |  | Return task log entries starting from a date. |  |
| to | query |  |  | Return task log entries up to a date. |  |
| tenantId | query |  |  | Only return historic task log entries with the given tenantId. |  |
| fromLogNumber | query |  |  | Return task log entries starting from a log number |  |
| toLogNumber | query |  |  | Return task log entries up to specific a log number |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates that historic task log entries could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricTaskLogEntryResponse"
}
```

- **404**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/history/historic-variable-instances` | List of historic variable instances | processInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (body), order (query), start (query), size (query) |

### GET /history/historic-variable-instances

List of historic variable instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | query |  |  | The process instance id of the historic variable instance. |  |
| taskId | query |  |  | The task id of the historic variable instance. |  |
| excludeTaskVariables | query |  |  | Indication to exclude the task variables from the result. |  |
| excludeLocalVariables | query |  |  | Indication to exclude local variables or not. |  |
| variableName | query |  |  | The variable name of the historic variable instance. |  |
| variableNameLike | query |  |  | The variable name using the like operator for the historic variable instance. |  |
| sort | body |  | #/definitions/HistoricVariableInstanceCollectionResource | The field to sort by. Defaults to 'variableName'. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricVariableInstanceCollectionResource"
}
```

**Responses**

- **200**: Indicates that historic variable instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricVariableInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/history/historic-variable-instances/{varInstanceId}/data` | Get the binary data for a historic task instance variable | varInstanceId (path,required) |

### GET /history/historic-variable-instances/{varInstanceId}/data

The response body contains the binary value of the variable. When the variable is of type binary, the content-type of the response is set to application/octet-stream, regardless of the content of the variable or the request accept-type header. In case of serializable, application/x-java-serialized-object is used as content-type.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| varInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the variable instance was found and the requested variable data is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested variable instance was not found or the variable instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
| GET | `/identity/groups` | List groups | id (query), name (query), type (query), nameLike (query), member (query), potentialStarter (query), sort (query), order (query), start (query), size (query) |

### GET /identity/groups

List groups

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return group with the given id |  |
| name | query |  |  | Only return groups with the given name |  |
| type | query |  |  | Only return groups with the given type |  |
| nameLike | query |  |  | Only return groups with a name like the given value. Use % as wildcard-character. |  |
| member | query |  |  | Only return groups which have a member with the given username. |  |
| potentialStarter | query |  |  | Only return groups which members are potential starters for a process-definition with the given id. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates the requested groups were returned.

```json
{
  "$ref": "#/definitions/DataResponseGroupResponse"
}
```
| POST | `/identity/groups` | Create a group | body (body) |

### POST /identity/groups

Create a group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/GroupRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/GroupRequest"
}
```

**Responses**

- **201**: Indicates the group was created.

```json
{
  "$ref": "#/definitions/GroupResponse"
}
```

- **400**: Indicates the id of the group was missing.
| GET | `/identity/groups/{groupId}` | Get a single group | groupId (path,required) |

### GET /identity/groups/{groupId}

Get a single group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the group exists and is returned.

```json
{
  "$ref": "#/definitions/GroupResponse"
}
```

- **404**: Indicates the requested group does not exist.
| PUT | `/identity/groups/{groupId}` | Update a group | groupId (path,required), body (body) |

### PUT /identity/groups/{groupId}

All request values are optional. For example, you can only include the name attribute in the request body JSON-object, only updating the name of the group, leaving all other fields unaffected. When an attribute is explicitly included and is set to null, the group-value will be updated to null.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |
| body | body |  | #/definitions/GroupRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/GroupRequest"
}
```

**Responses**

- **200**: Indicates the group was updated.

```json
{
  "$ref": "#/definitions/GroupResponse"
}
```

- **404**: Indicates the requested group was not found.

- **409**: Indicates the requested group was updated simultaneously.
| DELETE | `/identity/groups/{groupId}` | Delete a group | groupId (path,required) |

### DELETE /identity/groups/{groupId}

Delete a group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the group was found and  has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested group does not exist.
| POST | `/identity/groups/{groupId}/members` | Add a member to a group | groupId (path,required), body (body) |

### POST /identity/groups/{groupId}/members

Add a member to a group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |
| body | body |  | #/definitions/MembershipRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/MembershipRequest"
}
```

**Responses**

- **201**: Indicates the group was found and the member has been added.

```json
{
  "$ref": "#/definitions/MembershipResponse"
}
```

- **400**: Indicates the userId was not included in the request body.

- **404**: Indicates the requested group was not found.

- **409**: Indicates the requested user is already a member of the group.
| DELETE | `/identity/groups/{groupId}/members/{userId}` | Delete a member from a group | groupId (path,required), userId (path,required) |

### DELETE /identity/groups/{groupId}/members/{userId}

Delete a member from a group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |
| userId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the group was found and the member has been deleted. The response body is left empty intentionally.

- **404**: Indicates the requested group was not found or that the user is not a member of the group. The status description contains additional information about the error.
| GET | `/identity/users` | List users | id (query), firstName (query), lastName (query), displayName (query), email (query), firstNameLike (query), lastNameLike (query), displayNameLike (query), emailLike (query), memberOfGroup (query), tenantId (query), potentialStarter (query), sort (query), order (query), start (query), size (query) |

### GET /identity/users

List users

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return group with the given id |  |
| firstName | query |  |  | Only return users with the given firstname |  |
| lastName | query |  |  | Only return users with the given lastname |  |
| displayName | query |  |  | Only return users with the given displayName |  |
| email | query |  |  | Only return users with the given email |  |
| firstNameLike | query |  |  | Only return userswith a firstname like the given value. Use % as wildcard-character. |  |
| lastNameLike | query |  |  | Only return users with a lastname like the given value. Use % as wildcard-character. |  |
| displayNameLike | query |  |  | Only return users with a displayName like the given value. Use % as wildcard-character. |  |
| emailLike | query |  |  | Only return users with an email like the given value. Use % as wildcard-character. |  |
| memberOfGroup | query |  |  | Only return users which are a member of the given group. |  |
| tenantId | query |  |  | Only return users which are a members of the given tenant. |  |
| potentialStarter | query |  |  | Only return users  which members are potential starters for a process-definition with the given id. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates the group exists and is returned.

```json
{
  "$ref": "#/definitions/DataResponseUserResponse"
}
```
| POST | `/identity/users` | Create a user | body (body) |

### POST /identity/users

Create a user

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/UserRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/UserRequest"
}
```

**Responses**

- **201**: Indicates the user was created.

```json
{
  "$ref": "#/definitions/UserResponse"
}
```

- **400**: Indicates the id of the user was missing.
| GET | `/identity/users/{userId}` | Get a single user | userId (path,required) |

### GET /identity/users/{userId}

Get a single user

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the user exists and is returned.

```json
{
  "$ref": "#/definitions/UserResponse"
}
```

- **404**: Indicates the requested user does not exist.
| PUT | `/identity/users/{userId}` | Update a user | userId (path,required), body (body) |

### PUT /identity/users/{userId}

All request values are optional. For example, you can only include the firstName attribute in the request body JSON-object, only updating the firstName of the user, leaving all other fields unaffected. When an attribute is explicitly included and is set to null, the user-value will be updated to null. Example: {"firstName" : null} will clear the firstName of the user).

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| body | body |  | #/definitions/UserRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/UserRequest"
}
```

**Responses**

- **200**: Indicates the user was updated.

```json
{
  "$ref": "#/definitions/UserResponse"
}
```

- **404**: Indicates the requested user was not found.

- **409**: Indicates the requested user was updated simultaneously.
| DELETE | `/identity/users/{userId}` | Delete a user | userId (path,required) |

### DELETE /identity/users/{userId}

Delete a user

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the user was found and  has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested user was not found.
| GET | `/identity/users/{userId}/info` | List user’s info | userId (path,required) |

### GET /identity/users/{userId}/info

List user’s info

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the user was found and list of info (key and url) is returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/UserInfoResponse"
  }
}
```

- **404**: Indicates the requested user was not found.
| POST | `/identity/users/{userId}/info` | Create a new user’s info entry | userId (path,required), body (body) |

### POST /identity/users/{userId}/info

Create a new user’s info entry

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| body | body |  | #/definitions/UserInfoRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/UserInfoRequest"
}
```

**Responses**

- **201**: Indicates the user was found and the info has been created.

```json
{
  "$ref": "#/definitions/UserInfoResponse"
}
```

- **400**: Indicates the key or value was missing from the request body. Status description contains additional information about the error.

- **404**: Indicates the requested user was not found.

- **409**: Indicates there is already an info-entry with the given key for the user, update the resource instance (PUT).
| GET | `/identity/users/{userId}/info/{key}` | Get a user’s info | userId (path,required), key (path,required) |

### GET /identity/users/{userId}/info/{key}

Get a user’s info

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| key | path | yes |  |  |  |

**Responses**

- **200**: Indicates the user was found and the user has info for the given key.

```json
{
  "$ref": "#/definitions/UserInfoResponse"
}
```

- **404**: Indicates the requested user was not found or the user does ot have info for the given key. Status description contains additional information about the error.
| PUT | `/identity/users/{userId}/info/{key}` | Update a user’s info | userId (path,required), key (path,required), body (body) |

### PUT /identity/users/{userId}/info/{key}

Update a user’s info

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| key | path | yes |  |  |  |
| body | body |  | #/definitions/UserInfoRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/UserInfoRequest"
}
```

**Responses**

- **200**: Indicates the user was found and the info has been updated.

```json
{
  "$ref": "#/definitions/UserInfoResponse"
}
```

- **400**: Indicates the value was missing from the request body.

- **404**: Indicates the requested user was not found or the user does not have info for the given key. Status description contains additional information about the error.
| DELETE | `/identity/users/{userId}/info/{key}` | Delete a user’s info | userId (path,required), key (path,required) |

### DELETE /identity/users/{userId}/info/{key}

Delete a user’s info

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| key | path | yes |  |  |  |

**Responses**

- **204**: Indicates the user was found and the info for the given key has been deleted. Response body is left empty intentionally.

- **404**: Indicates the requested user was not found or the user does not have info for the given key. Status description contains additional information about the error.
| GET | `/identity/users/{userId}/picture` | Get a user’s picture | userId (path,required) |

### GET /identity/users/{userId}/picture

The response body contains the raw picture data, representing the user’s picture. The Content-type of the response corresponds to the mimeType that was set when creating the picture.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the user was found and has a picture, which is returned in the body.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested user was not found or the user does not have a profile picture. Status-description contains additional information about the error.
| PUT | `/identity/users/{userId}/picture` | Updating a user’s picture | userId (path,required), file (formData,required) |

### PUT /identity/users/{userId}/picture

The request should be of type multipart/form-data. There should be a single file-part included with the binary value of the picture. On top of that, the following additional form-fields can be present:

mimeType: Optional mime-type for the uploaded picture. If omitted, the default of image/jpeg is used as a mime-type for the picture.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| file | formData | yes |  | Picture to update |  |

**Responses**

- **204**: Indicates the user was found and the picture has been updated. The response-body is left empty intentionally.

- **404**: Indicates the requested user was not found.
| GET | `/management/batch-parts/{batchPartId}` | Get a single batch part | batchPartId (path,required) |

### GET /management/batch-parts/{batchPartId}

Get a single batch part

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchPartId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the batch part exists and is returned.

```json
{
  "$ref": "#/definitions/BatchPartResponse"
}
```

- **404**: Indicates the requested batch part does not exist.
| GET | `/management/batch-parts/{batchPartId}/batch-part-document` | Get the batch part document | batchPartId (path,required) |

### GET /management/batch-parts/{batchPartId}/batch-part-document

Get the batch part document

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchPartId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the requested batch part was found and the batch part document has been returned. The response contains the raw batch part document and always has a Content-type of application/json.

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested batch part was not found or the job does not have a batch part document. Status-description contains additional information about the error.
| GET | `/management/batches` | List batches | id (query), batchType (query), searchKey (query), searchKey2 (query), createTimeBefore (query), createTimeAfter (query), completeTimeBefore (query), completeTimeAfter (query), status (query), tenantId (query), tenantIdLike (query), withoutTenantId (query) |

### GET /management/batches

List batches

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

**Responses**

- **200**: Indicates the requested batches were returned.

```json
{
  "$ref": "#/definitions/DataResponseBatchResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.
| GET | `/management/batches/{batchId}` | Get a single batch | batchId (path,required) |

### GET /management/batches/{batchId}

Get a single batch

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the batch exists and is returned.

```json
{
  "$ref": "#/definitions/BatchResponse"
}
```

- **404**: Indicates the requested batch does not exist.
| DELETE | `/management/batches/{batchId}` | Delete a batch | batchId (path,required) |

### DELETE /management/batches/{batchId}

Delete a batch

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the batch was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested batch was not found.
| GET | `/management/batches/{batchId}/batch-document` | Get the batch document | batchId (path,required) |

### GET /management/batches/{batchId}/batch-document

Get the batch document

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the requested batch was found and the batch document has been returned. The response contains the raw batch document and always has a Content-type of application/json.

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested batch was not found or the job does not have a batch document. Status-description contains additional information about the error.
| GET | `/management/batches/{batchId}/batch-parts` | List batch parts | batchId (path,required), status (query) |

### GET /management/batches/{batchId}/batch-parts

List batch parts

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| batchId | path | yes |  |  |  |
| status | query |  |  | Only return batch parts for the given status |  |

**Responses**

- **200**: Indicates the requested batch parts were returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/BatchPartResponse"
  }
}
```

- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.
| GET | `/management/deadletter-jobs` | List deadletter jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |

### GET /management/deadletter-jobs

List deadletter jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.
| POST | `/management/deadletter-jobs` | Move a bulk of deadletter jobs. Accepts 'move' and 'moveToHistoryJob' as action. | body (body) |

### POST /management/deadletter-jobs

Move a bulk of deadletter jobs. Accepts 'move' and 'moveToHistoryJob' as action.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkMoveDeadLetterActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/BulkMoveDeadLetterActionRequest"
}
```

**Responses**

- **204**: Indicates the dead letter jobs where moved. Response-body is intentionally empty.

- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.
| GET | `/management/deadletter-jobs/{jobId}` | Get a single deadletter job | jobId (path,required) |

### GET /management/deadletter-jobs/{jobId}

Get a single deadletter job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the suspended job exists and is returned.

```json
{
  "$ref": "#/definitions/JobResponse"
}
```

- **404**: Indicates the requested job does not exist.
| POST | `/management/deadletter-jobs/{jobId}` | Move a single deadletter job. Accepts 'move' and 'moveToHistoryJob' as action. | jobId (path,required), body (body) |

### POST /management/deadletter-jobs/{jobId}

Move a single deadletter job. Accepts 'move' and 'moveToHistoryJob' as action.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestActionRequest"
}
```

**Responses**

- **204**: Indicates the dead letter job was moved. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.

- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.
| DELETE | `/management/deadletter-jobs/{jobId}` | Delete a deadletter job | jobId (path,required) |

### DELETE /management/deadletter-jobs/{jobId}

Delete a deadletter job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/management/deadletter-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a deadletter job | jobId (path,required) |

### GET /management/deadletter-jobs/{jobId}/exception-stacktrace

Get the exception stacktrace for a deadletter job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.
| GET | `/management/engine` | Get engine info |  |

### GET /management/engine

Get engine info

**Responses**

- **200**: Indicates the engine info is returned.

```json
{
  "$ref": "#/definitions/EngineInfoResponse"
}
```
| GET | `/management/engine-properties` | Get all engine properties |  |

### GET /management/engine-properties

Get all engine properties

**Responses**

- **200**: Indicates that engine properties were found and returned.

```json
{
  "type": "object",
  "additionalProperties": {
    "type": "string"
  }
}
```
| POST | `/management/engine-properties` | Create a new engine property | body (body) |

### POST /management/engine-properties

Create a new engine property

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/PropertyRequestBody |  |  |

**Request**

```json
{
  "$ref": "#/definitions/PropertyRequestBody"
}
```

**Responses**

- **201**: Indicates the property is created

- **409**: Indicates the property already exists
| PUT | `/management/engine-properties/{engineProperty}` | Update an engine property | engineProperty (path,required), body (body) |

### PUT /management/engine-properties/{engineProperty}

Update an engine property

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| engineProperty | path | yes |  |  |  |
| body | body |  | #/definitions/PropertyRequestBody |  |  |

**Request**

```json
{
  "$ref": "#/definitions/PropertyRequestBody"
}
```

**Responses**

- **200**: Indicates the property is updated

- **404**: Indicates the property is not found
| DELETE | `/management/engine-properties/{engineProperty}` | Delete an engine property | engineProperty (path,required) |

### DELETE /management/engine-properties/{engineProperty}

Delete an engine property

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| engineProperty | path | yes |  |  |  |

**Responses**

- **204**: Indicates the property was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested property was not found.
| GET | `/management/history-jobs` | List history jobs | id (query), withException (query), exceptionMessage (query), scopeType (query), handlerType (query), handlerTypes (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), lockOwner (query), locked (query), unlocked (query), sort (query), order (query), start (query), size (query) |

### GET /management/history-jobs

List history jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseHistoryJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.
| GET | `/management/history-jobs/{jobId}` | Get a single history job job | jobId (path,required) |

### GET /management/history-jobs/{jobId}

Get a single history job job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the history job exists and is returned.

```json
{
  "$ref": "#/definitions/HistoryJobResponse"
}
```

- **404**: Indicates the requested job does not exist.
| POST | `/management/history-jobs/{jobId}` | Execute a history job | jobId (path,required), body (body) |

### POST /management/history-jobs/{jobId}

Execute a history job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestActionRequest"
}
```

**Responses**

- **204**: Indicates the job was executed. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.

- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.
| DELETE | `/management/history-jobs/{jobId}` | Delete a history job | jobId (path,required) |

### DELETE /management/history-jobs/{jobId}

Delete a history job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the history job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/management/jobs` | List jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |

### GET /management/jobs

List jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.
| GET | `/management/jobs/{jobId}` | Get a single job | jobId (path,required) |

### GET /management/jobs/{jobId}

Get a single job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the job exists and is returned.

```json
{
  "$ref": "#/definitions/JobResponse"
}
```

- **404**: Indicates the requested job does not exist.
| POST | `/management/jobs/{jobId}` | Execute a single job | jobId (path,required), body (body) |

### POST /management/jobs/{jobId}

Execute a single job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestActionRequest"
}
```

**Responses**

- **204**: Indicates the job was executed. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.

- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.
| DELETE | `/management/jobs/{jobId}` | Delete a job | jobId (path,required) |

### DELETE /management/jobs/{jobId}

Delete a job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/management/jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a job | jobId (path,required) |

### GET /management/jobs/{jobId}/exception-stacktrace

Get the exception stacktrace for a job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.
| GET | `/management/properties` | List engine properties |  |

### GET /management/properties

List engine properties

**Responses**

- **200**: Indicates the properties are returned.

```json
{
  "type": "object",
  "additionalProperties": {
    "type": "string"
  }
}
```
| GET | `/management/suspended-jobs` | List suspended jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |

### GET /management/suspended-jobs

List suspended jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.
| GET | `/management/suspended-jobs/{jobId}` | Get a single suspended job | jobId (path,required) |

### GET /management/suspended-jobs/{jobId}

Get a single suspended job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the suspended job exists and is returned.

```json
{
  "$ref": "#/definitions/JobResponse"
}
```

- **404**: Indicates the requested job does not exist.
| DELETE | `/management/suspended-jobs/{jobId}` | Delete a suspended job | jobId (path,required) |

### DELETE /management/suspended-jobs/{jobId}

Delete a suspended job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/management/suspended-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a suspended job | jobId (path,required) |

### GET /management/suspended-jobs/{jobId}/exception-stacktrace

Get the exception stacktrace for a suspended job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.
| GET | `/management/tables` | List tables |  |

### GET /management/tables

List tables

**Responses**

- **200**: Indicates the request was successful.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/TableResponse"
  }
}
```
| GET | `/management/tables/{tableName}` | Get a single table | tableName (path,required) |

### GET /management/tables/{tableName}

Get a single table

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| tableName | path | yes |  |  |  |

**Responses**

- **200**: Indicates the table exists and the table count is returned.

```json
{
  "$ref": "#/definitions/TableResponse"
}
```

- **404**: Indicates the requested table does not exist.
| GET | `/management/tables/{tableName}/columns` | Get column info for a single table | tableName (path,required) |

### GET /management/tables/{tableName}/columns

Get column info for a single table

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| tableName | path | yes |  |  |  |

**Responses**

- **200**: Indicates the table exists and the table column info is returned.

```json
{
  "$ref": "#/definitions/TableMetaData"
}
```

- **404**: Indicates the requested table does not exist.
| GET | `/management/tables/{tableName}/data` | Get row data for a single table | tableName (path,required), start (query), size (query), orderAscendingColumn (query), orderDescendingColumn (query) |

### GET /management/tables/{tableName}/data

Get row data for a single table

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| tableName | path | yes |  |  |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |
| orderAscendingColumn | query |  |  | Name of the column to sort the resulting rows on, ascending. |  |
| orderDescendingColumn | query |  |  | Name of the column to sort the resulting rows on, descending. |  |

**Responses**

- **200**: Indicates the table exists and the table row data is returned

```json
{
  "$ref": "#/definitions/DataResponseListMapStringObject"
}
```

- **404**: Indicates the requested table does not exist.
| GET | `/management/timer-jobs` | List timer jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |

### GET /management/timer-jobs

List timer jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.
| GET | `/management/timer-jobs/{jobId}` | Get a single timer job | jobId (path,required) |

### GET /management/timer-jobs/{jobId}

Get a single timer job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the timer job exists and is returned.

```json
{
  "$ref": "#/definitions/JobResponse"
}
```

- **404**: Indicates the requested job does not exist.
| POST | `/management/timer-jobs/{jobId}` | Execute a single job action (move or reschedule) | jobId (path,required), body (body) |

### POST /management/timer-jobs/{jobId}

Execute a single job action (move or reschedule)

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/TimerJobActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/TimerJobActionRequest"
}
```

**Responses**

- **204**: Indicates the timer job action was executed. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.

- **500**: Indicates the an exception occurred while executing the job. The status-description contains additional detail about the error. The full error-stacktrace can be fetched later on if needed.
| DELETE | `/management/timer-jobs/{jobId}` | Delete a timer job | jobId (path,required) |

### DELETE /management/timer-jobs/{jobId}

Delete a timer job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/management/timer-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a timer job | jobId (path,required) |

### GET /management/timer-jobs/{jobId}/exception-stacktrace

Get the exception stacktrace for a timer job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the requested job was not found and the stacktrace has been returned. The response contains the raw stacktrace and always has a Content-type of text/plain.

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested job was not found or the job does not have an exception stacktrace. Status-description contains additional information about the error.
| POST | `/query/activity-instances` | Query for activity instances | body (body), sort (body) |

### POST /query/activity-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic task instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ActivityInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/ActivityInstanceQueryResource | The field to sort by. Defaults to 'startTime'. |  |

**Request**

```json
{
  "$ref": "#/definitions/ActivityInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the activities are returned

```json
{
  "$ref": "#/definitions/DataResponseActivityInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information
| POST | `/query/executions` | Query executions | body (body), sort (body) |

### POST /query/executions

The request body can contain all possible filters that can be used in the List executions URL query. On top of these, it’s possible to provide an array of variables and processInstanceVariables to include in the query, with their format described here.

The general paging and sorting query-parameters can be used for this URL.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ExecutionQueryRequest |  |  |
| sort | body |  | #/definitions/ExecutionQueryResource | The field to sort by. Defaults to 'processInstanceId'. |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the executions are returned.

```json
{
  "$ref": "#/definitions/DataResponseExecutionResponse"
}
```

- **404**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.
| POST | `/query/historic-activity-instances` | Query for historic activity instances | body (body), sort (body) |

### POST /query/historic-activity-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic task instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricActivityInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricActivityInstanceQueryResource | The field to sort by. Defaults to 'startTime'. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricActivityInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the activities are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricActivityInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information
| POST | `/query/historic-detail` | Query for historic details | body (body), sort (body) |

### POST /query/historic-detail

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic process instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricDetailQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricDetailQueryResource | The field to sort by. Defaults to 'processInstanceId'. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricDetailQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the historic details are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricDetailResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/query/historic-process-instances` | Query for historic process instances | body (body), sort (body) |

### POST /query/historic-process-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic process instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long. On top of that, the query allows for filtering based on process variables. The variables property is a JSON-array containing objects with the format as described here.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricProcessInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricProcessInstanceQueryResource | The field to sort by. Defaults to 'processInstanceId'. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricProcessInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the process instances are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricProcessInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/query/historic-task-instances` | Query for historic task instances | body (body), sort (body) |

### POST /query/historic-task-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic task instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long. On top of that, the query allows for filtering based on process variables. The taskVariables and processVariables properties are JSON-arrays containing objects with the format as described here.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricTaskInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricTaskInstanceQueryResource | The field to sort by. Defaults to 'taskInstanceId'. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricTaskInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the tasks are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricTaskInstanceResponse"
}
```

- **404**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/query/historic-variable-instances` | Query for historic variable instances | body (body), sort (body) |

### POST /query/historic-variable-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic process instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long. On top of that, the query allows for filtering based on process variables. The variables property is a JSON-array containing objects with the format as described here.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricVariableInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricVariableInstanceQueryResource | The field to sort by. Defaults to 'variableName'. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricVariableInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the tasks are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricVariableInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/query/process-instances` | Query process instances | body (body), sort (body) |

### POST /query/process-instances

The request body can contain all possible filters that can be used in the List process instances URL query. On top of these, it’s possible to provide an array of variables to include in the query, with their format described here.

The general paging and sorting query-parameters can be used for this URL.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ProcessInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/ProcessInstanceQueryResource | The field to sort by. Defaults to 'id'. |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the process-instances are returned

```json
{
  "$ref": "#/definitions/DataResponseProcessInstanceResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.
| POST | `/query/tasks` | Query for tasks | body (body), sort (body) |

### POST /query/tasks

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of tasks (except for candidateGroupIn which is only available in this POST task query REST service), but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long. On top of that, the query allows for filtering based on task and process variables. The taskVariables and processInstanceVariables are both JSON-arrays containing objects with the format as described here.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/TaskQueryRequest |  |  |
| sort | body |  | #/definitions/TaskQueryResource | The field to sort by. Defaults to 'id'. |  |

**Request**

```json
{
  "$ref": "#/definitions/TaskQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the tasks are returned.

```json
{
  "$ref": "#/definitions/DataResponseTaskResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.
| POST | `/query/variable-instances` | Query for variable instances | body (body), sort (body) |

### POST /query/variable-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of variable instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/VariableInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/VariableInstanceQueryResource | The field to sort by. Defaults to 'variableName'. |  |

**Request**

```json
{
  "$ref": "#/definitions/VariableInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the tasks are returned

```json
{
  "$ref": "#/definitions/DataResponseVariableInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/repository/deployments` | List Deployments | name (query), nameLike (query), category (query), categoryNotEquals (query), parentDeploymentId (query), parentDeploymentIdLike (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

### GET /repository/deployments

List Deployments

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| name | query |  |  | Only return deployments with the given name. |  |
| nameLike | query |  |  | Only return deployments with a name like the given name. |  |
| category | query |  |  | Only return deployments with the given category. |  |
| categoryNotEquals | query |  |  | Only return deployments which do not have the given category. |  |
| parentDeploymentId | query |  |  | Only return deployments with the given parent deployment id. |  |
| parentDeploymentIdLike | query |  |  | Only return deployments with a parent deployment id like the given value. |  |
| tenantId | query |  |  | Only return deployments with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return deployments with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns deployments without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates the request was successful.

```json
{
  "$ref": "#/definitions/DataResponseDeploymentResponse"
}
```
| POST | `/repository/deployments` | Create a new deployment | deploymentKey (query), deploymentName (query), tenantId (query), file (formData,required) |

### POST /repository/deployments

The request body should contain data of type multipart/form-data. There should be exactly one file in the request, any additional files will be ignored. The deployment name is the name of the file-field passed in. If multiple resources need to be deployed in a single deployment, compress the resources in a zip and make sure the file-name ends with .bar or .zip.

An additional parameter (form-field) can be passed in the request body with name tenantId. The value of this field will be used as the id of the tenant this deployment is done in.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentKey | query |  |  |  |  |
| deploymentName | query |  |  |  |  |
| tenantId | query |  |  |  |  |
| file | formData | yes |  |  |  |

**Responses**

- **201**: Indicates the deployment was created.

```json
{
  "$ref": "#/definitions/DeploymentResponse"
}
```

- **400**: Indicates there was no content present in the request body or the content mime-type is not supported for deployment. The status-description contains additional information.
| GET | `/repository/deployments/{deploymentId}` | Get a deployment | deploymentId (path,required) |

### GET /repository/deployments/{deploymentId}

Get a deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  | The id of the deployment to get. |  |

**Responses**

- **200**: Indicates the deployment was found and returned.

```json
{
  "$ref": "#/definitions/DeploymentResponse"
}
```

- **404**: Indicates the requested deployment was not found.
| DELETE | `/repository/deployments/{deploymentId}` | Delete a deployment | deploymentId (path,required), cascade (query) |

### DELETE /repository/deployments/{deploymentId}

Delete a deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |
| cascade | query |  |  |  |  |

**Responses**

- **204**: Indicates the deployment was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested deployment was not found.
| GET | `/repository/deployments/{deploymentId}/resourcedata/{resourceName}` | Get a deployment resource content | deploymentId (path,required), resourceName (path,required) |

### GET /repository/deployments/{deploymentId}/resourcedata/{resourceName}

The response body will contain the binary resource-content for the requested resource. The response content-type will be the same as the type returned in the resources mimeType property. Also, a content-disposition header is set, allowing browsers to download the file instead of displaying it.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |
| resourceName | path | yes |  | The name of the resource to get. Make sure you URL-encode the resourceName in case it contains forward slashes. Eg: use diagrams%2Fmy-process.bpmn20.xml instead of diagrams/my-process.bpmn20.xml. |  |

**Responses**

- **200**: Indicates both deployment and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested deployment was not found or there is no resource with the given id present in the deployment. The status-description contains additional information.
| GET | `/repository/deployments/{deploymentId}/resources` | List resources in a deployment | deploymentId (path,required) |

### GET /repository/deployments/{deploymentId}/resources

The dataUrl property in the resulting JSON for a single resource contains the actual URL to use for retrieving the binary resource.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the deployment was found and the resource list has been returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/DeploymentResourceResponse"
  }
}
```

- **404**: Indicates the requested deployment was not found.
| GET | `/repository/deployments/{deploymentId}/resources/**` | Get a deployment resource | deploymentId (path,required) |

### GET /repository/deployments/{deploymentId}/resources/**

Replace ** by ResourceId

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both deployment and resource have been found and the resource has been returned.

```json
{
  "$ref": "#/definitions/DeploymentResourceResponse"
}
```

- **404**: Indicates the requested deployment was not found or there is no resource with the given id present in the deployment. The status-description contains additional information.
| GET | `/repository/models` | List models | id (query), category (query), categoryLike (query), categoryNotEquals (query), name (query), nameLike (query), key (query), deploymentId (query), version (query), latestVersion (query), deployed (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

### GET /repository/models

List models

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return models with the given version. |  |
| category | query |  |  | Only return models with the given category. |  |
| categoryLike | query |  |  | Only return models with a category like the given name. |  |
| categoryNotEquals | query |  |  | Only return models which do not have the given category. |  |
| name | query |  |  | Only return models with the given name. |  |
| nameLike | query |  |  | Only return models with a name like the given name. |  |
| key | query |  |  | Only return models with the given key. |  |
| deploymentId | query |  |  | Only return models with the given category. |  |
| version | query |  |  | Only return models with the given version. |  |
| latestVersion | query |  |  | If true, only return models which are the latest version. Best used in combination with key. If false is passed in as value, this is ignored and all versions are returned. |  |
| deployed | query |  |  | If true, only deployed models are returned. If false, only undeployed models are returned (deploymentId is null). |  |
| tenantId | query |  |  | Only return models with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return models with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns models without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the models are returned

```json
{
  "$ref": "#/definitions/DataResponseModelResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/repository/models` | Create a model | body (body) |

### POST /repository/models

All request values are optional. For example, you can only include the name attribute in the request body JSON-object, only setting the name of the model, leaving all other fields null.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ModelRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ModelRequest"
}
```

**Responses**

- **201**: Indicates the model was created.

```json
{
  "$ref": "#/definitions/ModelResponse"
}
```
| GET | `/repository/models/{modelId}` | Get a model | modelId (path,required) |

### GET /repository/models/{modelId}

Get a model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the model was found and returned.

```json
{
  "$ref": "#/definitions/ModelResponse"
}
```

- **404**: Indicates the requested model was not found.
| PUT | `/repository/models/{modelId}` | Update a model | modelId (path,required), body (body) |

### PUT /repository/models/{modelId}

All request values are optional. For example, you can only include the name attribute in the request body JSON-object, only updating the name of the model, leaving all other fields unaffected. When an attribute is explicitly included and is set to null, the model-value will be updated to null.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |
| body | body |  | #/definitions/ModelRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ModelRequest"
}
```

**Responses**

- **200**: Indicates the model was found and updated.

```json
{
  "$ref": "#/definitions/ModelResponse"
}
```

- **404**: Indicates the requested model was not found.
| DELETE | `/repository/models/{modelId}` | Delete a model | modelId (path,required) |

### DELETE /repository/models/{modelId}

Delete a model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the model was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested model was not found.
| GET | `/repository/models/{modelId}/source` | Get the editor source for a model | modelId (path,required) |

### GET /repository/models/{modelId}/source

Response body contains the model’s raw editor source. The response’s content-type is set to application/octet-stream, regardless of the content of the source.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the model was found and source is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested model was not found.
| PUT | `/repository/models/{modelId}/source` | Set the editor source for a model | modelId (path,required), file (formData,required) |

### PUT /repository/models/{modelId}/source

Response body contains the model’s raw editor source. The response’s content-type is set to application/octet-stream, regardless of the content of the source.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |
| file | formData | yes |  |  |  |

**Responses**

- **204**: Indicates the model was found and the source has been updated.

- **404**: Indicates the requested model was not found.
| GET | `/repository/models/{modelId}/source-extra` | Get the extra editor source for a model | modelId (path,required) |

### GET /repository/models/{modelId}/source-extra

Response body contains the model’s raw editor source. The response’s content-type is set to application/octet-stream, regardless of the content of the source.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the model was found and source is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested model was not found.
| PUT | `/repository/models/{modelId}/source-extra` | Set the extra editor source for a model | modelId (path,required), file (formData,required) |

### PUT /repository/models/{modelId}/source-extra

Response body contains the model’s raw editor source. The response’s content-type is set to application/octet-stream, regardless of the content of the source.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |
| file | formData | yes |  |  |  |

**Responses**

- **204**: Indicates the model was found and the extra source has been updated.

- **404**: Indicates the requested model was not found.
| GET | `/repository/process-definitions` | List of process definitions | version (query), name (query), nameLike (query), nameLikeIgnoreCase (query), key (query), keyLike (query), resourceName (query), resourceNameLike (query), category (query), categoryLike (query), categoryNotEquals (query), deploymentId (query), parentDeploymentId (query), startableByUser (query), latest (query), suspended (query), sort (query), order (query), start (query), size (query) |

### GET /repository/process-definitions

List of process definitions

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| version | query |  |  | Only return process definitions with the given version. |  |
| name | query |  |  | Only return process definitions with the given name. |  |
| nameLike | query |  |  | Only return process definitions with a name like the given name. |  |
| nameLikeIgnoreCase | query |  |  | Only return process definitions with a name like the given name ignoring case. |  |
| key | query |  |  | Only return process definitions with the given key. |  |
| keyLike | query |  |  | Only return process definitions with a name like the given key. |  |
| resourceName | query |  |  | Only return process definitions with the given resource name. |  |
| resourceNameLike | query |  |  | Only return process definitions with a name like the given resource name. |  |
| category | query |  |  | Only return process definitions with the given category. |  |
| categoryLike | query |  |  | Only return process definitions with a category like the given name. |  |
| categoryNotEquals | query |  |  | Only return process definitions which do not have the given category. |  |
| deploymentId | query |  |  | Only return process definitions which are part of a deployment with the given deployment id. |  |
| parentDeploymentId | query |  |  | Only return process definitions which are part of a deployment with the given parent deployment id. |  |
| startableByUser | query |  |  | Only return process definitions which are part of a deployment with the given id. |  |
| latest | query |  |  | Only return the latest process definition versions. Can only be used together with key and keyLike parameters, using any other parameter will result in a 400-response. |  |
| suspended | query |  |  | If true, only returns process definitions which are suspended. If false, only active process definitions (which are not suspended) are returned. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the process-definitions are returned

```json
{
  "$ref": "#/definitions/DataResponseProcessDefinitionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format or that latest is used with other parameters other than key and keyLike. The status-message contains additional information.
| GET | `/repository/process-definitions/{processDefinitionId}` | Get a process definition | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}

Get a process definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the process-definitions are returned

```json
{
  "$ref": "#/definitions/ProcessDefinitionResponse"
}
```

- **404**: Indicates the requested process definition was not found.
| PUT | `/repository/process-definitions/{processDefinitionId}` | Execute actions for a process definition | processDefinitionId (path,required), body (body,required) |

### PUT /repository/process-definitions/{processDefinitionId}

Execute actions for a process definition (Update category, Suspend or Activate)

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| body | body | yes | #/definitions/ProcessDefinitionActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessDefinitionActionRequest"
}
```

**Responses**

- **200**: Indicates action has been executed for the specified process. (category altered, activate or suspend)

```json
{
  "$ref": "#/definitions/ProcessDefinitionResponse"
}
```

- **400**: Indicates no category was defined in the request body.

- **404**: Indicates the requested process definition was not found.

- **409**: Indicates the requested process definition is already suspended or active.
| POST | `/repository/process-definitions/{processDefinitionId}/batch-migrate` | Batch migrate all instances of process definition | processDefinitionId (path,required), body (body) |

### POST /repository/process-definitions/{processDefinitionId}/batch-migrate

Batch migrate all instances of process definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates process instances were found and batch migration was started.

- **404**: Indicates the requested process definition was not found.
| GET | `/repository/process-definitions/{processDefinitionId}/decision-tables` | List decision tables for a process-definition | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/decision-tables

List decision tables for a process-definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process definition was found and the decision tables are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/DecisionResponse"
  }
}
```

- **404**: Indicates the requested process definition was not found.
| GET | `/repository/process-definitions/{processDefinitionId}/decisions` | List decisions for a process-definition | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/decisions

List decisions for a process-definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process definition was found and the decisions are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/DecisionResponse"
  }
}
```

- **404**: Indicates the requested process definition was not found.
| GET | `/repository/process-definitions/{processDefinitionId}/form-definitions` | List form definitions for a process-definition | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/form-definitions

List form definitions for a process-definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process definition was found and the form definitions are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/FormDefinitionResponse"
  }
}
```

- **404**: Indicates the requested process definition was not found.
| GET | `/repository/process-definitions/{processDefinitionId}/identitylinks` | List candidate starters for a process-definition | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/identitylinks

List candidate starters for a process-definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process definition was found and the requested identity links are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestIdentityLink"
  }
}
```

- **404**: Indicates the requested process definition was not found.
| POST | `/repository/process-definitions/{processDefinitionId}/identitylinks` | Add a candidate starter to a process definition | processDefinitionId (path,required), body (body) |

### POST /repository/process-definitions/{processDefinitionId}/identitylinks

It is possible to add either a user or a group.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

**Responses**

- **201**: Indicates the process definition was found and the identity link was created.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **400**: Indicates the body does not contain the correct information.

- **404**: Indicates the requested process definition was not found.
| GET | `/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}` | Get a candidate starter from a process definition | processDefinitionId (path,required), family (path,required), identityId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}

Get a candidate starter from a process definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process definition was found and the identity link was returned.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **404**: Indicates the requested process definition was not found or the process definition does not have an identity-link that matches the url.
| DELETE | `/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}` | Delete a candidate starter from a process definition | processDefinitionId (path,required), family (path,required), identityId (path,required) |

### DELETE /repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}

Delete a candidate starter from a process definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the process definition was found and the identity link was removed. The response body is intentionally empty.

- **404**: Indicates the requested process definition was not found or the process definition does not have an identity-link that matches the url.
| GET | `/repository/process-definitions/{processDefinitionId}/image` | Get a process definition image | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/image

Get a process definition image

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the process-definitions are returned

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested process definition was not found.
| POST | `/repository/process-definitions/{processDefinitionId}/migrate` | Migrate all instances of process definition | processDefinitionId (path,required), body (body) |

### POST /repository/process-definitions/{processDefinitionId}/migrate

Migrate all instances of process definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates process instances were found and migration was executed.

- **404**: Indicates the requested process definition was not found.
| GET | `/repository/process-definitions/{processDefinitionId}/model` | Get a process definition BPMN model | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/model

Get a process definition BPMN model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process definition was found and the model is returned. The response contains the full process definition model.

```json
{
  "$ref": "#/definitions/BpmnModel"
}
```

- **404**: Indicates the requested process definition was not found.
| GET | `/repository/process-definitions/{processDefinitionId}/resourcedata` | Get a process definition resource content | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/resourcedata

Get a process definition resource content

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both process definition and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested process definition was not found or there is no resource with the given id present in the process definition. The status-description contains additional information.
| GET | `/repository/process-definitions/{processDefinitionId}/start-form` | Get a process definition start form | processDefinitionId (path,required) |

### GET /repository/process-definitions/{processDefinitionId}/start-form

Get a process definition start form

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the process definition form is returned

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested process definition was not found.
| GET | `/runtime/activity-instances` | List activity instances | activityId (query), activityInstanceId (query), activityName (query), activityType (query), executionId (query), finished (query), taskAssignee (query), processInstanceId (query), processDefinitionId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

### GET /runtime/activity-instances

List activity instances

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

**Responses**

- **200**: Indicates that activity instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseActivityInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/runtime/event-subscriptions` | List of event subscriptions | id (query), eventType (query), eventName (query), activityId (query), executionId (query), processInstanceId (query), withoutProcessInstanceId (query), processDefinitionId (query), withoutProcessDefinitionId (query), scopeId (query), subScopeId (query), withoutScopeId (query), scopeDefinitionId (query), withoutScopeDefinitionId (query), createdBefore (query), createdAfter (query), tenantId (query), withoutTenantId (query), configuration (query), withoutConfiguration (query), sort (query), order (query), start (query), size (query) |

### GET /runtime/event-subscriptions

List of event subscriptions

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

**Responses**

- **200**: Indicates the requested event subscriptions were returned.

```json
{
  "$ref": "#/definitions/DataResponseEventSubscriptionResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.
| GET | `/runtime/event-subscriptions/{eventSubscriptionId}` | Get a single event subscription | eventSubscriptionId (path,required) |

### GET /runtime/event-subscriptions/{eventSubscriptionId}

Get a single event subscription

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| eventSubscriptionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the event subscription exists and is returned.

```json
{
  "$ref": "#/definitions/EventSubscriptionResponse"
}
```

- **404**: Indicates the requested event subscription does not exist.
| GET | `/runtime/executions` | List of executions | id (query), activityId (query), processDefinitionKey (query), processDefinitionId (query), processInstanceId (query), messageEventSubscriptionName (query), signalEventSubscriptionName (query), parentId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query) |

### GET /runtime/executions

List of executions

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

**Responses**

- **200**: Indicates request was successful and the executions are returned

```json
{
  "$ref": "#/definitions/DataResponseExecutionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.
| PUT | `/runtime/executions` | Signal event received | body (body) |

### PUT /runtime/executions

Signal event received

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ExecutionActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionActionRequest"
}
```

**Responses**

- **204**: Indicates request was successful and the executions are returned

- **404**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.
| GET | `/runtime/executions/{executionId}` | Get an execution | executionId (path,required) |

### GET /runtime/executions/{executionId}

Get an execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the execution was found and returned.

```json
{
  "$ref": "#/definitions/ExecutionResponse"
}
```

- **404**: Indicates the execution was not found.
| PUT | `/runtime/executions/{executionId}` | Execute an action on an execution | executionId (path,required), body (body) |

### PUT /runtime/executions/{executionId}

Execute an action on an execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionActionRequest"
}
```

**Responses**

- **200**: Indicates the execution was found and the action is performed.

```json
{
  "$ref": "#/definitions/ExecutionResponse"
}
```

- **204**: Indicates the execution was found, the action was performed and the action caused the execution to end.

- **400**: Indicates an illegal action was requested, required parameters are missing in the request body or illegal variables are passed in. Status description contains additional information about the error.

- **404**: Indicates the execution was not found.
| GET | `/runtime/executions/{executionId}/activities` | List active activities in an execution | executionId (path,required) |

### GET /runtime/executions/{executionId}/activities

Returns all activities which are active in the execution and in all child-executions (and their children, recursively), if any.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the execution was found and activities are returned.

```json
{
  "type": "array",
  "items": {
    "type": "string"
  }
}
```

- **404**: Indicates the execution was not found.
| POST | `/runtime/executions/{executionId}/change-state` | Change the state of an execution | executionId (path,required), body (body) |

### POST /runtime/executions/{executionId}/change-state

Change the state of an execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionChangeActivityStateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionChangeActivityStateRequest"
}
```

**Responses**

- **200**: Indicates the execution was found and the action is performed.

- **404**: Indicates the execution was not found.
| GET | `/runtime/executions/{executionId}/variables` | List variables for an execution | executionId (path,required), scope (query) |

### GET /runtime/executions/{executionId}/variables

List variables for an execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates the execution was found and variables are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestVariable"
  }
}
```

- **404**: Indicates the requested execution was not found.
| POST | `/runtime/executions/{executionId}/variables` | Create variables on an execution | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |

### POST /runtime/executions/{executionId}/variables

This endpoint can be used in 2 ways: By passing a JSON Body (array of RestVariable) or by passing a multipart/form-data Object.
Any number of variables can be passed into the request body array.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableCollectionResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionVariableCollectionResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "type": "object"
}
```

- **201**: Indicates the execution was found and variable is created/updated.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the requested execution was not found.

- **409**: Indicates the execution was found but already contains a variable with the given name. Use the update-method instead.
| PUT | `/runtime/executions/{executionId}/variables` | Update variables on an execution | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |

### PUT /runtime/executions/{executionId}/variables

This endpoint can be used in 2 ways: By passing a JSON Body (array of RestVariable) or by passing a multipart/form-data Object.
Any number of variables can be passed into the request body array.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableCollectionResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionVariableCollectionResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "type": "object"
}
```

- **201**: Indicates the execution was found and variable is created/updated.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the requested execution was not found.
| DELETE | `/runtime/executions/{executionId}/variables` | Delete all variables for an execution | executionId (path,required) |

### DELETE /runtime/executions/{executionId}/variables

Delete all variables for an execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the execution was found and variables have been deleted.

- **404**: Indicates the requested execution was not found.
| POST | `/runtime/executions/{executionId}/variables-async` | Create variables on an execution asynchronously | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |

### POST /runtime/executions/{executionId}/variables-async

This endpoint can be used in 2 ways: By passing a JSON Body (array of RestVariable) or by passing a multipart/form-data Object.
Any number of variables can be passed into the request body array.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableCollectionResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionVariableCollectionResource"
}
```

**Responses**

- **201**: Indicates the job to create the variables has been created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **409**: Indicates the execution already contains a variable with the given name. Use the update-method instead.
| PUT | `/runtime/executions/{executionId}/variables-async` | Update variables on an execution asynchronously | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |

### PUT /runtime/executions/{executionId}/variables-async

This endpoint can be used in 2 ways: By passing a JSON Body (array of RestVariable) or by passing a multipart/form-data Object.
Any number of variables can be passed into the request body array.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableCollectionResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionVariableCollectionResource"
}
```

**Responses**

- **201**: Indicates the job to update the variables has been created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
| PUT | `/runtime/executions/{executionId}/variables-async/{variableName}` | Update a variable on an execution asynchronously | executionId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

### PUT /runtime/executions/{executionId}/variables-async/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableResource | Update a variable on an execution |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionVariableResource"
}
```

**Responses**

- **200**: Indicates both the process instance and variable were found and variable is updated.

- **404**: Indicates the process instance does not have a variable with the given name. Status description contains additional information about the error.
| GET | `/runtime/executions/{executionId}/variables/{variableName}` | Get a variable for an execution | executionId (path,required), variableName (path,required), scope (query) |

### GET /runtime/executions/{executionId}/variables/{variableName}

Get a variable for an execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates both the execution and variable were found and variable is returned.

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the requested execution was not found or the execution does not have a variable with the given name in the requested scope (in case scope-query parameter was omitted, variable does not exist in local and global scope). Status description contains additional information about the error.
| PUT | `/runtime/executions/{executionId}/variables/{variableName}` | Update a variable on an execution | executionId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

### PUT /runtime/executions/{executionId}/variables/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionVariableResource | Update a variable on an execution |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionVariableResource"
}
```

**Responses**

- **200**: Indicates both the process instance and variable were found and variable is updated.

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **404**: Indicates the requested process instance was not found or the process instance does not have a variable with the given name. Status description contains additional information about the error.
| DELETE | `/runtime/executions/{executionId}/variables/{variableName}` | Delete a variable for an execution | executionId (path,required), variableName (path,required), scope (query) |

### DELETE /runtime/executions/{executionId}/variables/{variableName}

Delete a variable for an execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **204**: Indicates both the execution and variable were found and variable has been deleted.

- **404**: Indicates the requested execution was not found or the execution does not have a variable with the given name in the requested scope. Status description contains additional information about the error.
| GET | `/runtime/executions/{executionId}/variables/{variableName}/data` | Get the binary data for an execution | executionId (path,required), variableName (path,required), scope (query) |

### GET /runtime/executions/{executionId}/variables/{variableName}/data

Get the binary data for an execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| executionId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates the execution was found and the requested variables are returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested execution was not found or the task does not have a variable with the given name (in the given scope). Status message provides additional information.
| GET | `/runtime/process-instances` | List process instances | id (query), name (query), nameLike (query), nameLikeIgnoreCase (query), processDefinitionName (query), processDefinitionNameLike (query), processDefinitionNameLikeIgnoreCase (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionKeyLikeIgnoreCase (query), processDefinitionId (query), processDefinitionCategory (query), processDefinitionCategoryLike (query), processDefinitionCategoryLikeIgnoreCase (query), processDefinitionVersion (query), processDefinitionEngineVersion (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), startedBy (query), startedBefore (query), startedAfter (query), activeActivityId (query), involvedUser (query), suspended (query), superProcessInstanceId (query), rootScopeId (query), parentScopeId (query), subProcessInstanceId (query), excludeSubprocesses (query), includeProcessVariables (query), includeProcessVariablesName (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

### GET /runtime/process-instances

List process instances

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

**Responses**

- **200**: Indicates request was successful and the process-instances are returned

```json
{
  "$ref": "#/definitions/DataResponseProcessInstanceResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.
| POST | `/runtime/process-instances` | Start a process instance | body (body) |

### POST /runtime/process-instances

Note that also a *transientVariables* property is accepted as part of this json, that follows the same structure as the *variables* property.

Only one of *processDefinitionId*, *processDefinitionKey* or *message* can be used in the request body. 

Parameters *businessKey*, *variables* and *tenantId* are optional.

If tenantId is omitted, the default tenant will be used.

 It is possible to send variables, transientVariables and startFormVariables in one request.

More information about the variable format can be found in the REST variables section.

 Note that the variable-scope that is supplied is ignored, process-variables are always local.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ProcessInstanceCreateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceCreateRequest"
}
```

**Responses**

- **201**: Indicates the process instance was created.

```json
{
  "$ref": "#/definitions/ProcessInstanceResponse"
}
```

- **400**: Indicates either the process-definition was not found (based on id or key), no process is started by sending the given message or an invalid variable has been passed. Status description contains additional information about the error.
| POST | `/runtime/process-instances/delete` | Bulk delete process instances | body (body) |

### POST /runtime/process-instances/delete

Bulk delete process instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkDeleteInstancesRestActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/BulkDeleteInstancesRestActionRequest"
}
```

**Responses**

- **204**: Indicates the bulk of process instances was found and deleted. Response body is left empty intentionally.

- **404**: Indicates at least one requested process instance was not found.
| GET | `/runtime/process-instances/{processInstanceId}` | Get a process instance | processInstanceId (path,required) |

### GET /runtime/process-instances/{processInstanceId}

Get a process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and returned.

```json
{
  "$ref": "#/definitions/ProcessInstanceResponse"
}
```

- **404**: Indicates the requested process instance was not found.
| PUT | `/runtime/process-instances/{processInstanceId}` | Update process instance properties or execute an action on a process instance (body needs to contain an 'action' property for the latter). | processInstanceId (path,required), body (body) |

### PUT /runtime/process-instances/{processInstanceId}

Update process instance properties or execute an action on a process instance (body needs to contain an 'action' property for the latter).

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceUpdateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceUpdateRequest"
}
```

**Responses**

- **200**: Indicates the process instance was found and the update/action was executed.

```json
{
  "$ref": "#/definitions/ProcessInstanceResponse"
}
```

- **400**: Indicates a invalid parameters are supplied.

- **404**: Indicates the requested process instance was not found.

- **409**: Indicates the requested process instance change cannot be executed since the process-instance is in a wrong status which doesn't accept the change
| DELETE | `/runtime/process-instances/{processInstanceId}` | Delete a process instance | processInstanceId (path,required), deleteReason (query) |

### DELETE /runtime/process-instances/{processInstanceId}

Delete a process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| deleteReason | query |  |  |  |  |

**Responses**

- **204**: Indicates the process instance was found and deleted. Response body is left empty intentionally.

- **404**: Indicates the requested process instance was not found.
| POST | `/runtime/process-instances/{processInstanceId}/change-state` | Change the state a process instance | processInstanceId (path,required), body (body) |

### POST /runtime/process-instances/{processInstanceId}/change-state

Change the state a process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ExecutionChangeActivityStateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExecutionChangeActivityStateRequest"
}
```

**Responses**

- **200**: Indicates the process instance was found and change state activity was executed.

- **404**: Indicates the requested process instance was not found.

- **409**: Indicates the requested process instance action cannot be executed since the process-instance is already activated/suspended.
| GET | `/runtime/process-instances/{processInstanceId}/diagram` | Get diagram for a process instance | processInstanceId (path,required) |

### GET /runtime/process-instances/{processInstanceId}/diagram

Get diagram for a process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and the diagram was returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **400**: Indicates the requested process instance was not found but the process does not contain any graphical information (BPMN:DI) and no diagram can be created.

- **404**: Indicates the requested process instance was not found.
| POST | `/runtime/process-instances/{processInstanceId}/evaluate-conditions` | Evaluate the conditions of a process instance | processInstanceId (path,required) |

### POST /runtime/process-instances/{processInstanceId}/evaluate-conditions

Evaluate the conditions of a process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and the evaluation of the conditions was executed.

- **404**: Indicates the requested process instance was not found.

- **409**: Indicates the requested process instance action cannot be executed since the process-instance is already activated/suspended.
| GET | `/runtime/process-instances/{processInstanceId}/identitylinks` | Get involved people for process instance | processInstanceId (path,required) |

### GET /runtime/process-instances/{processInstanceId}/identitylinks

Note that the groupId in Response Body will always be null, as it’s only possible to involve users with a process-instance.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and links are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestIdentityLink"
  }
}
```

- **404**: Indicates the requested process instance was not found.
| POST | `/runtime/process-instances/{processInstanceId}/identitylinks` | Add an involved user to a process instance | processInstanceId (path,required), body (body) |

### POST /runtime/process-instances/{processInstanceId}/identitylinks

Note that the groupId in Response Body will always be null, as it’s only possible to involve users with a process-instance.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

**Responses**

- **201**: Indicates the process instance was found and the link is created.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **400**: Indicates the requested body did not contain a userId or a type.

- **404**: Indicates the requested process instance was not found.
| GET | `/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}` | Get a specific involved people from process instance | processInstanceId (path,required), identityId (path,required), type (path,required) |

### GET /runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}

Get a specific involved people from process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and the specified link is retrieved.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **404**: Indicates the requested process instance was not found or the link to delete does not exist. The response status contains additional information about the error.
| DELETE | `/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}` | Remove an involved user to from process instance | processInstanceId (path,required), identityId (path,required), type (path,required) |

### DELETE /runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}

Remove an involved user to from process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

**Responses**

- **204**: Indicates the process instance was found and the link has been deleted. Response body is left empty intentionally.

- **404**: Indicates the requested process instance was not found or the link to delete does not exist. The response status contains additional information about the error.
| POST | `/runtime/process-instances/{processInstanceId}/inject` | Inject activity in a process instance | processInstanceId (path,required), body (body) |

### POST /runtime/process-instances/{processInstanceId}/inject

Inject activity in a process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/InjectActivityRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/InjectActivityRequest"
}
```

**Responses**

- **200**: Indicates the process instance was updated and the activity injection was executed.

- **404**: Indicates the requested process instance was not found.

- **409**: Indicates the requested process instance action cannot be executed since the process-instance is already activated/suspended.
| POST | `/runtime/process-instances/{processInstanceId}/migrate` | Migrate process instance | processInstanceId (path,required), body (body) |

### POST /runtime/process-instances/{processInstanceId}/migrate

Migrate process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates the process instance was found and migration was executed.

- **404**: Indicates the requested process instance was not found.

- **409**: Indicates the requested process instance action cannot be executed since the process-instance is already activated/suspended.
| GET | `/runtime/process-instances/{processInstanceId}/variables` | List variables for a process instance | processInstanceId (path,required), scope (query) |

### GET /runtime/process-instances/{processInstanceId}/variables

In case the variable is a binary variable or serializable, the valueUrl points to an URL to fetch the raw value. If it’s a plain variable, the value is present in the response. Note that only local scoped variables are returned, as there is no global scope for process-instance variables.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and variables are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestVariable"
  }
}
```

- **400**: Indicates the requested process instance was not found.
| POST | `/runtime/process-instances/{processInstanceId}/variables` | Create variables or new binary variable on a process instance | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

### POST /runtime/process-instances/{processInstanceId}/variables

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an array of RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the process-instance and existing ones are overridden without any error.
Any number of variables can be passed into the request body array.
Note that scope is ignored, only local variables can be set in a process instance.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableCollectionResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceVariableCollectionResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "type": "object"
}
```

- **201**: Indicates the process instance was found and variable is created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the requested process instance was not found.

- **409**: Indicates the process instance was found but already contains a variable with the given name (only thrown when POST method is used). Use the update-method instead.
| PUT | `/runtime/process-instances/{processInstanceId}/variables` | Update a multiple/single (non)binary variable on a process instance | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

### PUT /runtime/process-instances/{processInstanceId}/variables

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an array of RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the process-instance and existing ones are overridden without any error.
Any number of variables can be passed into the request body array.
Note that scope is ignored, only local variables can be set in a process instance.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableCollectionResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceVariableCollectionResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "type": "object"
}
```

- **201**: Indicates the process instance was found and variable is created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the requested process instance was not found.

- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.
| DELETE | `/runtime/process-instances/{processInstanceId}/variables` | Delete all variables | processInstanceId (path,required) |

### DELETE /runtime/process-instances/{processInstanceId}/variables

Delete all variables

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

**Responses**

- **204**: Indicates variables were found and have been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested process instance was not found.
| POST | `/runtime/process-instances/{processInstanceId}/variables-async` | Create variables or new binary variable on a process instance asynchronously | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

### POST /runtime/process-instances/{processInstanceId}/variables-async

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an array of RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the process-instance and existing ones are overridden without any error.
Any number of variables can be passed into the request body array.
Note that scope is ignored, only local variables can be set in a process instance.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableCollectionResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceVariableCollectionResource"
}
```

**Responses**

- **201**: Indicates the job to create the variables was created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **409**: Indicates the process instance was found but already contains a variable with the given name (only thrown when POST method is used). Use the update-method instead.
| PUT | `/runtime/process-instances/{processInstanceId}/variables-async` | Update multiple/single (non)binary variables on a process instance asynchronously | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

### PUT /runtime/process-instances/{processInstanceId}/variables-async

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an array of RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the process-instance and existing ones are overridden without any error.
Any number of variables can be passed into the request body array.
Note that scope is ignored, only local variables can be set in a process instance.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableCollectionResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceVariableCollectionResource"
}
```

**Responses**

- **201**: Indicates the job to create or update the variables was created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.
| PUT | `/runtime/process-instances/{processInstanceId}/variables-async/{variableName}` | Update a single variable on a process instance asynchronously | processInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |

### PUT /runtime/process-instances/{processInstanceId}/variables-async/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the process-instance and existing ones are overridden without any error.
Note that scope is ignored, only local variables can be set in a process instance.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceVariableResource"
}
```

**Responses**

- **201**: Indicates the job to update the variable has been created.

- **404**: Indicates the process instance does not have a variable with the given name. Status description contains additional information about the error.
| GET | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Get a variable for a process instance | processInstanceId (path,required), variableName (path,required), scope (query) |

### GET /runtime/process-instances/{processInstanceId}/variables/{variableName}

Get a variable for a process instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates both the process instance and variable were found and variable is returned.

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **404**: Indicates the requested process instance was not found or the process instance does not have a variable with the given name. Status description contains additional information about the error.
| PUT | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Update a single variable on a process instance | processInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |

### PUT /runtime/process-instances/{processInstanceId}/variables/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the process-instance and existing ones are overridden without any error.
Note that scope is ignored, only local variables can be set in a process instance.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/ProcessInstanceVariableResource | Create a variable on a process instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ProcessInstanceVariableResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **201**: Indicates both the process instance and variable were found and variable is updated.

- **404**: Indicates the requested process instance was not found or the process instance does not have a variable with the given name. Status description contains additional information about the error.
| DELETE | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Delete a variable | processInstanceId (path,required), variableName (path,required), scope (query) |

### DELETE /runtime/process-instances/{processInstanceId}/variables/{variableName}

Delete a variable

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **204**: Indicates the variable was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested variable was not found.
| GET | `/runtime/process-instances/{processInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | processInstanceId (path,required), variableName (path,required), scope (query) |

### GET /runtime/process-instances/{processInstanceId}/variables/{variableName}/data

Get the binary data for a variable

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates the process instance was found and the requested variables are returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested task was not found or the task does not have a variable with the given name (in the given scope). Status message provides additional information.
| POST | `/runtime/signals` | Signal event received | body (body) |

### POST /runtime/signals

Signal event received

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/SignalEventReceivedRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/SignalEventReceivedRequest"
}
```

**Responses**

- **202**: Indicated signal processing is queued as a job, ready to be executed.

- **204**: Indicated signal has been processed and no errors occurred.

- **400**: Signal not processed. The signal name is missing or variables are used together with async, which is not allowed. Response body contains additional information about the error.
| GET | `/runtime/tasks` | List of tasks | taskId (query), name (query), nameLike (query), nameLikeIgnoreCase (query), description (query), priority (query), minimumPriority (query), maximumPriority (query), assignee (query), assigneeLike (query), owner (query), ownerLike (query), unassigned (query), delegationState (query), candidateUser (query), candidateGroup (query), candidateGroups (query), involvedUser (query), taskDefinitionKey (query), taskDefinitionKeyLike (query), taskDefinitionKeys (query), processInstanceId (query), processInstanceIdWithChildren (query), withoutProcessInstanceId (query), processInstanceBusinessKey (query), processInstanceBusinessKeyLike (query), processDefinitionId (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionName (query), processDefinitionNameLike (query), executionId (query), createdOn (query), createdBefore (query), createdAfter (query), dueDate (query), dueBefore (query), dueAfter (query), withoutDueDate (query), excludeSubTasks (query), active (query), includeTaskLocalVariables (query), includeProcessVariables (query), scopeDefinitionId (query), scopeId (query), withoutScopeId (query), scopeType (query), propagatedStageInstanceId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), candidateOrAssigned (query), category (query), categoryIn (query), categoryNotIn (query), withoutCategory (query), rootScopeId (query), parentScopeId (query), sort (query), order (query), start (query), size (query) |

### GET /runtime/tasks

List of tasks

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

**Responses**

- **200**: Indicates request was successful and the tasks are returned

```json
{
  "$ref": "#/definitions/DataResponseTaskResponse"
}
```

- **404**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.
| POST | `/runtime/tasks` | Create Task | body (body) |

### POST /runtime/tasks

Create Task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/TaskRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/TaskRequest"
}
```

**Responses**

- **201**: Indicates request was successful and the tasks are returned

```json
{
  "$ref": "#/definitions/TaskResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.
| PUT | `/runtime/tasks` | Update Tasks | body (body) |

### PUT /runtime/tasks

Update Tasks

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkTasksRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/BulkTasksRequest"
}
```

**Responses**

- **200**: successful operation

```json
{
  "$ref": "#/definitions/DataResponseTaskResponse"
}
```

- **201**: Indicates request was successful and the tasks are returned

- **400**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.
| GET | `/runtime/tasks/{taskId}` | Get a task | taskId (path,required) |

### GET /runtime/tasks/{taskId}

Get a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task was found and returned.

```json
{
  "$ref": "#/definitions/TaskResponse"
}
```

- **404**: Indicates the requested task was not found.
| POST | `/runtime/tasks/{taskId}` | Tasks actions | taskId (path,required), body (body) |

### POST /runtime/tasks/{taskId}

Tasks actions

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/TaskActionRequest"
}
```

**Responses**

- **200**: Indicates the action was executed.

- **400**: When the body contains an invalid value or when the assignee is missing when the action requires it.

- **404**: Indicates the requested task was not found.

- **409**: Indicates the action cannot be performed due to a conflict. Either the task was updates simultaneously or the task was claimed by another user, in case of the claim action.
| PUT | `/runtime/tasks/{taskId}` | Update a task | taskId (path,required), body (body) |

### PUT /runtime/tasks/{taskId}

All request values are optional. For example, you can only include the assignee attribute in the request body JSON-object, only updating the assignee of the task, leaving all other fields unaffected. When an attribute is explicitly included and is set to null, the task-value will be updated to null. Example: {"dueDate" : null} will clear the duedate of the task).

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/TaskRequest"
}
```

**Responses**

- **200**: Indicates the task was updated.

```json
{
  "$ref": "#/definitions/TaskResponse"
}
```

- **404**: Indicates the requested task was not found.

- **409**: Indicates the requested task was updated simultaneously.
| DELETE | `/runtime/tasks/{taskId}` | Delete a task | taskId (path,required), cascadeHistory (query), deleteReason (query) |

### DELETE /runtime/tasks/{taskId}

Delete a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| cascadeHistory | query |  |  | Whether or not to delete the HistoricTask instance when deleting the task (if applicable). If not provided, this value defaults to false. |  |
| deleteReason | query |  |  | Reason why the task is deleted. This value is ignored when cascadeHistory is true. |  |

**Responses**

- **204**: Indicates the task was found and has been deleted. Response-body is intentionally empty.

- **403**: Indicates the requested task cannot be deleted because it’s part of a workflow.

- **404**: Indicates the requested task was not found.
| GET | `/runtime/tasks/{taskId}/attachments` | List attachments on a task | taskId (path,required) |

### GET /runtime/tasks/{taskId}/attachments

List attachments on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task was found and the attachments are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/AttachmentResponse"
  }
}
```

- **404**: Indicates the requested task was not found.
| POST | `/runtime/tasks/{taskId}/attachments` | Create a new attachment on a task, containing a link to an external resource or an attached file | taskId (path,required), body (body), file (formData), name (formData), description (formData), type (formData) |

### POST /runtime/tasks/{taskId}/attachments

This endpoint can be used in 2 ways: By passing a JSON Body (AttachmentRequest) to link an external resource or by passing a multipart/form-data Object to attach a file.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskAttachmentCollectionResource | create an attachment containing a link to an external resource |  |
| file | formData |  |  | Attachment file |  |
| name | formData |  |  | Required name of the variable |  |
| description | formData |  |  | Description of the attachment, optional |  |
| type | formData |  |  | Type of attachment, optional. Supports any arbitrary string or a valid HTTP content-type. |  |

**Request**

```json
{
  "$ref": "#/definitions/TaskAttachmentCollectionResource"
}
```

**Responses**

- **201**: Indicates the attachment was created and the result is returned.

```json
{
  "$ref": "#/definitions/AttachmentResponse"
}
```

- **400**: Indicates the attachment name is missing from the request.

- **404**: Indicates the requested task was not found.
| GET | `/runtime/tasks/{taskId}/attachments/{attachmentId}` | Get an attachment on a task | taskId (path,required), attachmentId (path,required) |

### GET /runtime/tasks/{taskId}/attachments/{attachmentId}

Get an attachment on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| attachmentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task and attachment were found and the attachment is returned.

```json
{
  "$ref": "#/definitions/AttachmentResponse"
}
```

- **404**: Indicates the requested task was not found or the tasks does not have a attachment with the given ID.
| DELETE | `/runtime/tasks/{taskId}/attachments/{attachmentId}` | Delete an attachment on a task | taskId (path,required), attachmentId (path,required) |

### DELETE /runtime/tasks/{taskId}/attachments/{attachmentId}

Delete an attachment on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| attachmentId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the task and attachment were found and the attachment is deleted. Response body is left empty intentionally.

- **404**: Indicates the requested task was not found or the tasks does not have a attachment with the given ID.
| GET | `/runtime/tasks/{taskId}/attachments/{attachmentId}/content` | Get the content for an attachment | taskId (path,required), attachmentId (path,required) |

### GET /runtime/tasks/{taskId}/attachments/{attachmentId}/content

The response body contains the binary content. By default, the content-type of the response is set to application/octet-stream unless the attachment type contains a valid Content-type.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| attachmentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task and attachment was found and the requested content is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested task was not found or the task does not have an attachment with the given id or the attachment does not have a binary stream available. Status message provides additional information.
| GET | `/runtime/tasks/{taskId}/comments` | List comments on a task | taskId (path,required) |

### GET /runtime/tasks/{taskId}/comments

List comments on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task was found and the comments are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/CommentResponse"
  }
}
```

- **404**: Indicates the requested task was not found.
| POST | `/runtime/tasks/{taskId}/comments` | Create a new comment on a task | taskId (path,required), body (body) |

### POST /runtime/tasks/{taskId}/comments

Create a new comment on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/CommentRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CommentRequest"
}
```

**Responses**

- **201**: Indicates the comment was created and the result is returned.

```json
{
  "$ref": "#/definitions/CommentResponse"
}
```

- **400**: Indicates the comment is missing from the request.

- **404**: Indicates the requested task was not found.
| GET | `/runtime/tasks/{taskId}/comments/{commentId}` | Get a comment on a task | taskId (path,required), commentId (path,required) |

### GET /runtime/tasks/{taskId}/comments/{commentId}

Get a comment on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| commentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task and comment were found and the comment is returned.

```json
{
  "$ref": "#/definitions/CommentResponse"
}
```

- **404**: Indicates the requested task was not found or the tasks does not have a comment with the given ID.
| DELETE | `/runtime/tasks/{taskId}/comments/{commentId}` | Delete a comment on a task | taskId (path,required), commentId (path,required) |

### DELETE /runtime/tasks/{taskId}/comments/{commentId}

Delete a comment on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| commentId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the task and comment were found and the comment is deleted. Response body is left empty intentionally.

- **404**: Indicates the requested task was not found or the tasks does not have a comment with the given ID.
| GET | `/runtime/tasks/{taskId}/events` | List events for a task | taskId (path,required) |

### GET /runtime/tasks/{taskId}/events

List events for a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task was found and the events are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/EventResponse"
  }
}
```

- **404**: Indicates the requested task was not found.
| GET | `/runtime/tasks/{taskId}/events/{eventId}` | Get an event on a task | taskId (path,required), eventId (path,required) |

### GET /runtime/tasks/{taskId}/events/{eventId}

Get an event on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| eventId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task and event were found and the event is returned.

```json
{
  "$ref": "#/definitions/EventResponse"
}
```

- **404**: Indicates the requested task was not found or the tasks does not have an event with the given ID.
| DELETE | `/runtime/tasks/{taskId}/events/{eventId}` | Delete an event on a task | taskId (path,required), eventId (path,required) |

### DELETE /runtime/tasks/{taskId}/events/{eventId}

Delete an event on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| eventId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the task was found and the events are returned.

- **404**: Indicates the requested task was not found or the task does not have the requested event.
| GET | `/runtime/tasks/{taskId}/form` | Get a task form | taskId (path,required) |

### GET /runtime/tasks/{taskId}/form

Get a task form

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the task form is returned

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested task was not found.
| GET | `/runtime/tasks/{taskId}/identitylinks` | List identity links for a task | taskId (path,required) |

### GET /runtime/tasks/{taskId}/identitylinks

List identity links for a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task was found and the requested identity links are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestIdentityLink"
  }
}
```

- **404**: Indicates the requested task was not found.
| POST | `/runtime/tasks/{taskId}/identitylinks` | Create an identity link on a task | taskId (path,required), body (body) |

### POST /runtime/tasks/{taskId}/identitylinks

It is possible to add either a user or a group.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

**Responses**

- **201**: Indicates the task was found and the identity link was created.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **404**: Indicates the requested task was not found or the task does not have the requested identityLink. The status contains additional information about this error.
| GET | `/runtime/tasks/{taskId}/identitylinks/{family}` | List identity links for a task for either groups or users | taskId (path,required), family (path,required) |

### GET /runtime/tasks/{taskId}/identitylinks/{family}

Returns only identity links targeting either users or groups. Response body and status-codes are exactly the same as when getting the full list of identity links for a task.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| family | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task was found and the requested identity links are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestIdentityLink"
  }
}
```

- **404**: Indicates the requested task was not found.
| GET | `/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Get a single identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |

### GET /runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}

Get a single identity link on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

**Responses**

- **200**: Indicates the task and identity link was found and returned.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **404**: Indicates the requested task was not found or the task does not have the requested identityLink. The status contains additional information about this error.
| DELETE | `/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Delete an identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |

### DELETE /runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}

Delete an identity link on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

**Responses**

- **204**: Indicates the task and identity link were found and the link has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested task was not found or the task does not have the requested identityLink. The status contains additional information about this error.
| GET | `/runtime/tasks/{taskId}/subtasks` | List of sub tasks for a task | taskId (path,required) |

### GET /runtime/tasks/{taskId}/subtasks

List of sub tasks for a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the  sub tasks are returned

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/TaskResponse"
  }
}
```

- **404**: Indicates the requested task was not found.
| GET | `/runtime/tasks/{taskId}/variables` | List variables for a task | taskId (path,required), scope (query) |

### GET /runtime/tasks/{taskId}/variables

List variables for a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

**Responses**

- **200**: Indicates the task was found and the requested variables are returned

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestVariable"
  }
}
```

- **404**: Indicates the requested task was not found..
| POST | `/runtime/tasks/{taskId}/variables` | Create new variables on a task | taskId (path,required), body (body), name (formData), type (formData), scope (formData) |

### POST /runtime/tasks/{taskId}/variables

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an Array of RestVariable) or by passing a multipart/form-data Object.
It is possible to create simple (non-binary) variable or list of variables or new binary variable 
Any number of variables can be passed into the request body array.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskVariableCollectionResource | Create a variable on a task |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is created. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable that is created. If omitted, local is assumed. |  |

**Request**

```json
{
  "$ref": "#/definitions/TaskVariableCollectionResource"
}
```

**Responses**

- **201**: Indicates the variables were created and the result is returned.

```json
{
  "type": "object"
}
```

- **400**: Indicates the name of a variable to create was missing or that an attempt is done to create a variable on a standalone task (without a process associated) with scope global or an empty array of variables was included in the request or request did not contain an array of variables. Status message provides additional information.

- **404**: Indicates the requested task was not found.

- **409**: Indicates the task already has a variable with the given name. Use the PUT method to update the task variable instead.

- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.
| DELETE | `/runtime/tasks/{taskId}/variables` | Delete all local variables on a task | taskId (path,required) |

### DELETE /runtime/tasks/{taskId}/variables

Delete all local variables on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **204**: Indicates all local task variables have been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested task was not found.
| GET | `/runtime/tasks/{taskId}/variables/{variableName}` | Get a variable from a task | taskId (path,required), variableName (path,required), scope (query) |

### GET /runtime/tasks/{taskId}/variables/{variableName}

Get a variable from a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

**Responses**

- **200**: Indicates the task was found and the requested variables are returned.

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **404**: Indicates the requested task was not found or the task does not have a variable with the given name (in the given scope). Status message provides additional information.
| PUT | `/runtime/tasks/{taskId}/variables/{variableName}` | Update an existing variable on a task | taskId (path,required), variableName (path,required), body (body), name (formData), type (formData), scope (formData) |

### PUT /runtime/tasks/{taskId}/variables/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
It is possible to update simple (non-binary) variable or  binary variable 
Any number of variables can be passed into the request body array.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/TaskVariableResource | Update a task variable |  |
| name | formData |  |  | Required name of the variable |  |
| type | formData |  |  | Type of variable that is updated. If omitted, reverts to raw JSON-value type (string, boolean, integer or double) |  |
| scope | formData |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable.. |  |

**Request**

```json
{
  "$ref": "#/definitions/TaskVariableResource"
}
```

**Responses**

- **200**: Indicates the variables was updated and the result is returned.

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **400**: Indicates the name of a variable to update was missing or that an attempt is done to update a variable on a standalone task (without a process associated) with scope global. Status message provides additional information.

- **404**: Indicates the requested task was not found or the task does not have a variable with the given name in the given scope. Status message contains additional information about the error.

- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.
| DELETE | `/runtime/tasks/{taskId}/variables/{variableName}` | Delete a variable on a task | taskId (path,required), variableName (path,required), scope (query) |

### DELETE /runtime/tasks/{taskId}/variables/{variableName}

Delete a variable on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

**Responses**

- **204**: Indicates the task variable was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested task was not found or the task does not have a variable with the given name. Status message contains additional information about the error.
| GET | `/runtime/tasks/{taskId}/variables/{variableName}/data` | Get the binary data for a variable | taskId (path,required), variableName (path,required), scope (query) |

### GET /runtime/tasks/{taskId}/variables/{variableName}/data

The response body contains the binary value of the variable. When the variable is of type binary, the content-type of the response is set to application/octet-stream, regardless of the content of the variable or the request accept-type header. In case of serializable, application/x-java-serialized-object is used as content-type.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

**Responses**

- **200**: Indicates the task was found and the requested variables are returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested task was not found or the task does not have a variable with the given name (in the given scope). Status message provides additional information.
| GET | `/runtime/variable-instances` | List of variable instances | processInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |

### GET /runtime/variable-instances

List of variable instances

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

**Responses**

- **200**: Indicates that variable instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseVariableInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/runtime/variable-instances/{varInstanceId}/data` | Get the binary data for a variable instance | varInstanceId (path,required) |

### GET /runtime/variable-instances/{varInstanceId}/data

The response body contains the binary value of the variable. When the variable is of type binary, the content-type of the response is set to application/octet-stream, regardless of the content of the variable or the request accept-type header. In case of serializable, application/x-java-serialized-object is used as content-type.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| varInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the variable instance was found and the requested variable data is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested variable instance was not found or the variable instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
