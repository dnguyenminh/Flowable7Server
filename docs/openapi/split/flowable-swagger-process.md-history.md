# flowable-swagger-process.md — history (history)

> Generated subset extracted from flowable-swagger-process.md

## POST /form/form-data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-activity-instances` | List historic activity instances | activityId (query), activityInstanceId (query), activityName (query), activityType (query), executionId (query), finished (query), taskAssignee (query), processInstanceId (query), processDefinitionId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query) |

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

#### Responses
- **200**: Indicates that historic activity instances could be queried.
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
- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## GET /history/historic-activity-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-detail` | Get historic detail | id (query), processInstanceId (query), executionId (query), activityInstanceId (query), taskId (query), selectOnlyFormProperties (query), selectOnlyVariableUpdates (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | The id of the historic detail. |  |
| processInstanceId | query |  |  | The process instance id of the historic detail. |  |
| executionId | query |  |  | The execution id of the historic detail. |  |
| activityInstanceId | query |  |  | The activity instance id of the historic detail. |  |
| taskId | query |  |  | The task id of the historic detail. |  |
| selectOnlyFormProperties | query |  |  | Indication to only return form properties in the result. |  |
| selectOnlyVariableUpdates | query |  |  | Indication to only return variable updates in the result. |  |

#### Responses
- **200**: Indicates that historic detail could be queried.
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

## GET /history/historic-detail

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-detail/{detailId}/data` | Get the binary data for a historic detail variable | detailId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| detailId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the historic detail instance was found and the requested variable data is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested historic detail instance was not found or the historic detail instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.

## GET /history/historic-detail/{detailId}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-process-instances` | List of historic process instances | processInstanceId (query), processInstanceName (query), processInstanceNameLike (query), processInstanceNameLikeIgnoreCase (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionKeyLikeIgnoreCase (query), processDefinitionId (query), processDefinitionName (query), processDefinitionNameLike (query), processDefinitionNameLikeIgnoreCase (query), processDefinitionCategory (query), processDefinitionCategoryLike (query), processDefinitionCategoryLikeIgnoreCase (query), processDefinitionVersion (query), deploymentId (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), activeActivityId (query), involvedUser (query), finished (query), superProcessInstanceId (query), excludeSubprocesses (query), finishedAfter (query), finishedBefore (query), startedAfter (query), startedBefore (query), startedBy (query), includeProcessVariables (query), includeProcessVariablesName (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), withoutCallbackId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query) |

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

#### Responses
- **200**: Indicates that historic process instances could be queried.
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

## GET /history/historic-process-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/history/historic-process-instances/delete` | Post action request to delete a bulk of historic process instances | bulkDeleteRestActionRequest (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| bulkDeleteRestActionRequest | body |  | #/definitions/BulkDeleteInstancesRestActionRequest |  |  |

#### Responses
- **204**: Indicates the bulk of historic process instances was found and deleted. Response body is left empty intentionally.
- **404**: Indicates at least one requested process instance was not found.

## POST /history/historic-process-instances/delete

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-process-instances/{processInstanceId}` | Get a historic process instance | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates that the historic process instances could be found.
```json
{
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
}
```
- **404**: Indicates that the historic process instances could not be found.

## GET /history/historic-process-instances/{processInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/history/historic-process-instances/{processInstanceId}` | Delete a historic process instance | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **204**: Indicates that the historic process instance was deleted.
- **404**: Indicates that the historic process instance could not be found.

## DELETE /history/historic-process-instances/{processInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-process-instances/{processInstanceId}/comments` | List comments on a historic process instance | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and the comments are returned.
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
- **404**: Indicates that the historic process instance could not be found.

## GET /history/historic-process-instances/{processInstanceId}/comments

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/history/historic-process-instances/{processInstanceId}/comments` | Create a new comment on a historic process instance | processInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CommentResponse |  |  |

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
- **404**: Indicates that the historic process instance could not be found.

## POST /history/historic-process-instances/{processInstanceId}/comments

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-process-instances/{processInstanceId}/comments/{commentId}` | Get a comment on a historic process instance | processInstanceId (path,required), commentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| commentId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the historic process instance and comment were found and the comment is returned.
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
- **404**: Indicates the requested historic process instance was not found or the historic process instance does not have a comment with the given ID.

## GET /history/historic-process-instances/{processInstanceId}/comments/{commentId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/history/historic-process-instances/{processInstanceId}/comments/{commentId}` | Delete a comment on a historic process instance | processInstanceId (path,required), commentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| commentId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the historic process instance and comment were found and the comment is deleted. Response body is left empty intentionally.
- **404**: Indicates the requested historic process instance was not found or the historic process instance does not have a comment with the given ID.

## DELETE /history/historic-process-instances/{processInstanceId}/comments/{commentId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-process-instances/{processInstanceId}/identitylinks` | List identity links of a historic process instance | processInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the identity links are returned
```json
[ {
  "type" : "participant",
  "userId" : "kermit",
  "groupId" : "sales",
  "taskId" : "null",
  "taskUrl" : "null",
  "processInstanceId" : "5",
  "processInstanceUrl" : "http://localhost:8182/history/historic-process-instances/5"
} ]
```
- **404**: Indicates the process instance could not be found..

## GET /history/historic-process-instances/{processInstanceId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-process-instances/{processInstanceId}/variables/{variableName}/data` | Get the binary data for a historic process instance variable | processInstanceId (path,required), variableName (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process instance was found and the requested variable data is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested process instance was not found or the process instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.

## GET /history/historic-process-instances/{processInstanceId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-task-instances` | List historic task instances | taskId (query), processInstanceId (query), processInstanceIdWithChildren (query), withoutProcessInstanceId (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionId (query), processDefinitionName (query), processDefinitionNameLike (query), processBusinessKey (query), processBusinessKeyLike (query), executionId (query), taskDefinitionKey (query), taskDefinitionKeys (query), taskName (query), taskNameLike (query), taskNameLikeIgnoreCase (query), taskDescription (query), taskDescriptionLike (query), taskCategory (query), taskCategoryIn (query), taskCategoryNotIn (query), taskWithoutCategory (query), taskDeleteReason (query), taskDeleteReasonLike (query), taskAssignee (query), taskAssigneeLike (query), taskOwner (query), taskOwnerLike (query), taskInvolvedUser (query), taskCandidateGroup (query), taskPriority (query), finished (query), processFinished (query), parentTaskId (query), dueDate (query), dueDateAfter (query), dueDateBefore (query), withoutDueDate (query), taskCompletedOn (query), taskCompletedAfter (query), taskCompletedBefore (query), taskCreatedOn (query), taskCreatedBefore (query), taskCreatedAfter (query), includeTaskLocalVariables (query), includeProcessVariables (query), scopeDefinitionId (query), scopeId (query), withoutScopeId (query), scopeType (query), propagatedStageInstanceId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), rootScopeId (query), parentScopeId (query) |

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

#### Responses
- **200**: Indicates that historic task instances could be queried.
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

## GET /history/historic-task-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-task-instances/{taskId}` | Get a single historic task instance | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates that the historic task instances could be found.
```json
{
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
}
```
- **404**: Indicates that the historic task instances could not be found.

## GET /history/historic-task-instances/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/history/historic-task-instances/{taskId}` | Delete a historic task instance | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **204**: Indicates that the historic task instance was deleted.
- **404**: Indicates that the historic task instance could not be found.

## DELETE /history/historic-task-instances/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-task-instances/{taskId}/form` | Get a historic task instance form | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the task form is returned
```json
"string"
```
- **404**: Indicates the requested task was not found.

## GET /history/historic-task-instances/{taskId}/form

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-task-instances/{taskId}/identitylinks` | List identity links of a historic task instance | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the identity links are returned
```json
[ {
  "type" : "participant",
  "userId" : "kermit",
  "groupId" : "sales",
  "taskId" : "null",
  "taskUrl" : "null",
  "processInstanceId" : "5",
  "processInstanceUrl" : "http://localhost:8182/history/historic-process-instances/5"
} ]
```
- **404**: Indicates the task instance could not be found.

## GET /history/historic-task-instances/{taskId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-task-instances/{taskId}/variables/{variableName}/data` | Get the binary data for a historic task instance variable | taskId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates the task instance was found and the requested variable data is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested task instance was not found or the process instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.

## GET /history/historic-task-instances/{taskId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-task-log-entries` | List historic task log entries | taskId (query), type (query), userId (query), processInstanceId (query), processDefinitionId (query), scopeId (query), scopeDefinitionId (query), subScopeId (query), scopeType (query), from (query), to (query), tenantId (query), fromLogNumber (query), toLogNumber (query), sort (query), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates that historic task log entries could be queried.
```json
{
  "data" : [ {
    "logNumber" : 0,
    "type" : "string",
    "taskId" : "string",
    "timeStamp" : "1970-01-01T00:00:00Z",
    "userId" : "string",
    "data" : "string",
    "executionId" : "string",
    "processInstanceId" : "string",
    "processDefinitionId" : "string",
    "scopeId" : "string",
    "scopeDefinitionId" : "string",
    "subScopeId" : "string",
    "scopeType" : "string",
    "tenantId" : "string"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **404**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.

## GET /history/historic-task-log-entries

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-variable-instances` | List of historic variable instances | processInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (body), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates that historic variable instances could be queried.
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

## GET /history/historic-variable-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/history/historic-variable-instances/{varInstanceId}/data` | Get the binary data for a historic task instance variable | varInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| varInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the variable instance was found and the requested variable data is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested variable instance was not found or the variable instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
