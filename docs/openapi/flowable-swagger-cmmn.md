# flowable-swagger-cmmn

> Generated subset extracted from server_fetch/flowable-swagger-cmmn.json

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-case-instances` | List of historic case instances | caseInstanceId (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), caseDefinitionId (query), caseDefinitionCategory (query), caseDefinitionCategoryLike (query), caseDefinitionCategoryLikeIgnoreCase (query), caseDefinitionName (query), caseDefinitionNameLike (query), caseDefinitionNameLikeIgnoreCase (query), name (query), nameLike (query), nameLikeIgnoreCase (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), involvedUser (query), finished (query), finishedAfter (query), finishedBefore (query), startedAfter (query), startedBefore (query), startedBy (query), state (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), referenceId (query), referenceType (query), lastReactivatedBy (query), lastReactivatedBefore (query), lastReactivatedAfter (query), activePlanItemDefinitionId (query), includeCaseVariables (query), includeCaseVariablesName (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), withoutCaseInstanceParentId (query), withoutCaseInstanceCallbackId (query) |

### GET /cmmn-history/historic-case-instances

List of historic case instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | query |  |  | An id of the historic case instance. |  |
| caseDefinitionKey | query |  |  | The case definition key of the historic case instance. |  |
| caseDefinitionKeyLike | query |  |  | Only return historic case instances like the given case definition key. |  |
| caseDefinitionKeyLikeIgnoreCase | query |  |  | Only return historic case instances like the given case definition key, ignoring case. |  |
| caseDefinitionId | query |  |  | The case definition id of the historic case instance. |  |
| caseDefinitionCategory | query |  |  | Only return historic case instances with the given case definition category. |  |
| caseDefinitionCategoryLike | query |  |  | Only return historic case instances like the given case definition category. |  |
| caseDefinitionCategoryLikeIgnoreCase | query |  |  | Only return historic case instances like the given case definition category, ignoring case. |  |
| caseDefinitionName | query |  |  | Only return historic case instances with the given case definition name. |  |
| caseDefinitionNameLike | query |  |  | Only return historic case instances like the given case definition name. |  |
| caseDefinitionNameLikeIgnoreCase | query |  |  | Only return historic case instances like the given case definition name, ignoring case. |  |
| name | query |  |  | Only return historic case instances with the given name. |  |
| nameLike | query |  |  | Only return historic case instances like the given name. |  |
| nameLikeIgnoreCase | query |  |  | Only return historic case instances like the given name ignoring case. |  |
| rootScopeId | query |  |  | Only return case instances which have the given root scope id (that can be a process or case instance ID). |  |
| parentScopeId | query |  |  | Only return case instances which have the given parent scope id (that can be a process or case instance ID). |  |
| businessKey | query |  |  | The business key of the historic case instance. |  |
| businessKeyLike | query |  |  | Only return historic case instances like the given business key. |  |
| businessKeyLikeIgnoreCase | query |  |  | Only return historic case instances like the given business key, ignoring case. |  |
| businessStatus | query |  |  | The business status of the historic case instance. |  |
| businessStatusLike | query |  |  | Only return historic case instances like the given business status. |  |
| businessStatusLikeIgnoreCase | query |  |  | Only return historic case instances like the given business status, ignoring case. |  |
| involvedUser | query |  |  | An involved user of the historic case instance. |  |
| finished | query |  |  | Indication if the historic case instance is finished. |  |
| finishedAfter | query |  |  | Return only historic case instances that were finished after this date. |  |
| finishedBefore | query |  |  | Return only historic case instances that were finished before this date. |  |
| startedAfter | query |  |  | Return only historic case instances that were started after this date. |  |
| startedBefore | query |  |  | Return only historic case instances that were started before this date. |  |
| startedBy | query |  |  | Return only historic case instances that were started by this user. |  |
| state | query |  |  | Only return historic case instances with the given state. |  |
| callbackId | query |  |  | Only return historic case instances which have the given callback id. |  |
| callbackType | query |  |  | Only return historic case instances which have the given callback type. |  |
| parentCaseInstanceId | query |  |  | Only return historic case instances which have the given parent case instance id. |  |
| referenceId | query |  |  | Only return historic case instances which have the given reference id. |  |
| referenceType | query |  |  | Only return historic case instances which have the given reference type. |  |
| lastReactivatedBy | query |  |  | Only return historic case instances last reactived by the given user. |  |
| lastReactivatedBefore | query |  |  | Only return historic case instances last reactivated before the given date. |  |
| lastReactivatedAfter | query |  |  | Only return historic case instances last reactivated after the given date. |  |
| activePlanItemDefinitionId | query |  |  | Only return historic case instances that have an active plan item instance with the given plan item definition id. |  |
| includeCaseVariables | query |  |  | An indication if the historic case instance variables should be returned as well. |  |
| includeCaseVariablesName | query |  |  | Indication to include case variables with the given names in the result. |  |
| tenantId | query |  |  | Only return instances with the given tenant id. |  |
| tenantIdLike | query |  |  | Only return instances like the given tenant id. |  |
| tenantIdLikeIgnoreCase | query |  |  | Only return instances like the given tenant id, ignoring case. |  |
| withoutTenantId | query |  |  | If true, only returns instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| withoutCaseInstanceParentId | query |  |  | If true, only returns instances without a parent set. If false, the withoutCaseInstanceParentId parameter is ignored. |  |
| withoutCaseInstanceCallbackId | query |  |  | If true, only returns instances without a callbackId set. If false, the withoutCaseInstanceCallbackId parameter is ignored. |  |

**Responses**

- **200**: Indicates that historic case instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricCaseInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/cmmn-history/historic-case-instances/delete` | Post action request to delete a bulk of historic case instances | bulkDeleteRestActionRequest (body) |

### POST /cmmn-history/historic-case-instances/delete

Post action request to delete a bulk of historic case instances

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

- **204**: Indicates the bulk of historic case instances was found and deleted. Response body is left empty intentionally.

- **404**: Indicates at least one requested case instance was not found.
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}` | Get a historic case instance | caseInstanceId (path,required) |

### GET /cmmn-history/historic-case-instances/{caseInstanceId}

Get a historic case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates that the historic process instances could be found.

```json
{
  "$ref": "#/definitions/HistoricCaseInstanceResponse"
}
```

- **404**: Indicates that the historic process instances could not be found.
| DELETE | `/cmmn-history/historic-case-instances/{caseInstanceId}` | Delete a historic case instance | caseInstanceId (path,required) |

### DELETE /cmmn-history/historic-case-instances/{caseInstanceId}

Delete a historic case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **204**: Indicates that the historic process instance was deleted.

- **404**: Indicates that the historic process instance could not be found.
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/identitylinks` | List identity links of a historic case instance | caseInstanceId (path,required) |

### GET /cmmn-history/historic-case-instances/{caseInstanceId}/identitylinks

List identity links of a historic case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

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
| POST | `/cmmn-history/historic-case-instances/{caseInstanceId}/migrate` | Migrate historic case instance | caseInstanceId (path,required), body (body) |

### POST /cmmn-history/historic-case-instances/{caseInstanceId}/migrate

Migrate historic case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates the historiccase instance was found and migration was executed.

- **404**: Indicates the requested historic case instance was not found.
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/stage-overview` | Get a stage overview of historic case instance | caseInstanceId (path,required) |

### GET /cmmn-history/historic-case-instances/{caseInstanceId}/stage-overview

Get a stage overview of historic case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates that the historic case instance was found.

- **204**: successful operation

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/StageResponse"
  }
}
```

- **404**: Indicates that the historic case instance could not be found.
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/variables/{variableName}/data` | Get the binary data for a historic case instance variable | caseInstanceId (path,required), variableName (path,required) |

### GET /cmmn-history/historic-case-instances/{caseInstanceId}/variables/{variableName}/data

The response body contains the binary value of the variable. When the variable is of type binary, the content-type of the response is set to application/octet-stream, regardless of the content of the variable or the request accept-type header. In case of serializable, application/x-java-serialized-object is used as content-type.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case instance was found and the requested variable data is returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested case instance was not found or the process instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
| GET | `/cmmn-history/historic-milestone-instances` | List of historic milestone instances | milestoneId (query), milestoneName (query), caseInstanceId (query), caseDefinitionId (query), reachedBefore (query), reachedAfter (query) |

### GET /cmmn-history/historic-milestone-instances

List of historic milestone instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| milestoneId | query |  |  | An id of the historic milestone instance. |  |
| milestoneName | query |  |  | The name of the historic milestone instance |  |
| caseInstanceId | query |  |  | The id of the case instance containing the milestone. |  |
| caseDefinitionId | query |  |  | The id of the definition of the case where the milestone is defined. |  |
| reachedBefore | query |  |  | Return only historic milestone instances that were reached before this date. |  |
| reachedAfter | query |  |  | Return only historic milestone instances that were reached after this date. |  |

**Responses**

- **200**: Indicates that historic milestone instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricMilestoneInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/cmmn-history/historic-milestone-instances/{milestoneInstanceId}` | Get a historic milestone instance by id | milestoneInstanceId (path,required) |

### GET /cmmn-history/historic-milestone-instances/{milestoneInstanceId}

Get a historic milestone instance by id

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| milestoneInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates that the historic milestone instances could be found.

```json
{
  "$ref": "#/definitions/HistoricMilestoneInstanceResponse"
}
```

- **404**: Indicates that the historic milestone instances could not be found.
| GET | `/cmmn-history/historic-planitem-instances` | List of historic plan item instances | planItemInstanceId (query), planItemInstanceName (query), planItemInstanceState (query), caseDefinitionId (query), caseInstanceId (query), stageInstanceId (query), elementId (query), planItemDefinitionId (query), planItemDefinitionType (query), createdBefore (query), createdAfter (query), lastAvailableBefore (query), lastAvailableAfter (query), lastEnabledBefore (query), lastEnabledAfter (query), lastDisabledBefore (query), lastDisabledAfter (query), lastStartedBefore (query), lastStartedAfter (query), lastSuspendedBefore (query), lastSuspendedAfter (query), completedBefore (query), completedAfter (query), terminatedBefore (query), terminatedAfter (query), occurredBefore (query), occurredAfter (query), exitBefore (query), exitAfter (query), endedBefore (query), endedAfter (query), startUserId (query), referenceId (query), referenceType (query), tenantId (query), withoutTenantId (query) |

### GET /cmmn-history/historic-planitem-instances

List of historic plan item instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | query |  |  | The id of the historic planItem instance. |  |
| planItemInstanceName | query |  |  | The name of the historic planItem instance. |  |
| planItemInstanceState | query |  |  | The state of the historic planItem instance. |  |
| caseDefinitionId | query |  |  | The id of the definition of the case were the historic planItem instance is defined. |  |
| caseInstanceId | query |  |  | The id of the case instance were the historic planItem instance existed. |  |
| stageInstanceId | query |  |  | The id of the stage were the historic planItem instance was contained. |  |
| elementId | query |  |  | The id of the planItem model of the historic planItem instance. |  |
| planItemDefinitionId | query |  |  | The id of the planItem model definition of the historic planItem instance. |  |
| planItemDefinitionType | query |  |  | The type of planItem of the historic planItem instance. |  |
| createdBefore | query |  |  | Return only historic planItem instances that were created before this date. |  |
| createdAfter | query |  |  | Return only historic planItem instances that were created after this date. |  |
| lastAvailableBefore | query |  |  | Return only historic planItem instances that were last in available before this date. |  |
| lastAvailableAfter | query |  |  | Return only historic planItem instances that were last in available state after this date. |  |
| lastEnabledBefore | query |  |  | Return only historic planItem instances that were last in enabled state before this date. |  |
| lastEnabledAfter | query |  |  | Return only historic planItem instances that were last in enabled state after this date. |  |
| lastDisabledBefore | query |  |  | Return only historic planItem instances that were last in disable state before this date. |  |
| lastDisabledAfter | query |  |  | Return only historic planItem instances that were last in disabled state after this date. |  |
| lastStartedBefore | query |  |  | Return only historic planItem instances that were last in active state before this date. |  |
| lastStartedAfter | query |  |  | Return only historic planItem instances that were last in active state after this date. |  |
| lastSuspendedBefore | query |  |  | Return only historic planItem instances that were last in suspended state before this date. |  |
| lastSuspendedAfter | query |  |  | Return only historic planItem instances that were last in suspended state after this date. |  |
| completedBefore | query |  |  | Return only historic planItem instances that were completed before this date. |  |
| completedAfter | query |  |  | Return only historic planItem instances that were completed after this date. |  |
| terminatedBefore | query |  |  | Return only historic planItem instances that were terminated before this date. |  |
| terminatedAfter | query |  |  | Return only historic planItem instances that were terminated after this date. |  |
| occurredBefore | query |  |  | Return only historic planItem instances that occurred before this date. |  |
| occurredAfter | query |  |  | Return only historic planItem instances that occurred after after this date. |  |
| exitBefore | query |  |  | Return only historic planItem instances that exit before this date. |  |
| exitAfter | query |  |  | Return only historic planItem instances that exit after this date. |  |
| endedBefore | query |  |  | Return only historic planItem instances that ended before this date. |  |
| endedAfter | query |  |  | Return only historic planItem instances that ended after this date. |  |
| startUserId | query |  |  | Return only historic planItem instances that were started by this user. |  |
| referenceId | query |  |  | The id of process that was referenced by this historic planItem instance. |  |
| referenceType | query |  |  | The type of reference to the process referenced by this historic planItem instance. |  |
| tenantId | query |  |  | Only return instances with the given tenantId. |  |
| withoutTenantId | query |  |  | If true, only returns instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |

**Responses**

- **200**: Indicates that historic planItem instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricPlanItemInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/cmmn-history/historic-planitem-instances/{planItemInstanceId}` | Get a historic plan item instance | planItemInstanceId (path,required) |

### GET /cmmn-history/historic-planitem-instances/{planItemInstanceId}

Get a historic plan item instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates that the historic plan item instances could be found.

```json
{
  "$ref": "#/definitions/HistoricPlanItemInstanceResponse"
}
```

- **404**: Indicates that the historic plan item instances could not be found.
| GET | `/cmmn-history/historic-task-instances` | List historic task instances | taskId (query), caseInstanceId (query), caseInstanceIdWithChildren (query), caseDefinitionId (query), propagatedStageInstanceId (query), withoutScopeId (query), taskDefinitionKey (query), taskName (query), taskNameLike (query), taskNameLikeIgnoreCase (query), taskDescription (query), taskDescriptionLike (query), taskCategory (query), taskCategoryIn (query), taskCategoryNotIn (query), taskWithoutCategory (query), taskDeleteReason (query), taskDeleteReasonLike (query), taskAssignee (query), taskAssigneeLike (query), taskOwner (query), taskOwnerLike (query), taskInvolvedUser (query), taskCandidateGroup (query), taskPriority (query), finished (query), processFinished (query), parentTaskId (query), dueDate (query), dueDateAfter (query), dueDateBefore (query), withoutDueDate (query), taskCompletedOn (query), taskCompletedAfter (query), taskCompletedBefore (query), taskCreatedOn (query), taskCreatedBefore (query), taskCreatedAfter (query), includeTaskLocalVariables (query), includeProcessVariables (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), withoutProcessInstanceId (query), planItemInstanceId (query), rootScopeId (query), parentScopeId (query) |

### GET /cmmn-history/historic-task-instances

List historic task instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | query |  |  | An id of the historic task instance. |  |
| caseInstanceId | query |  |  | The case instance id of the historic task instance. |  |
| caseInstanceIdWithChildren | query |  |  | Selects the historic task instance of a case instance and its children. |  |
| caseDefinitionId | query |  |  | The case definition id of the historic task instance. |  |
| propagatedStageInstanceId | query |  |  | Only return tasks which have the given id as propagated stage instance id |  |
| withoutScopeId | query |  |  | If true, only returns historic task instances without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| taskDefinitionKey | query |  |  | The task definition key for tasks part of a process |  |
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
| includeProcessVariables | query |  |  | Indication to include historic process variables in the result. |  |
| tenantId | query |  |  | Only return historic task instances with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return historic task instances with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns historic task instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| withoutProcessInstanceId | query |  |  | If true, only returns historic task instances without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| planItemInstanceId | query |  |  | The plan item instance instance id of the historic task instance. |  |
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
| GET | `/cmmn-history/historic-task-instances/{taskId}` | Get a single historic task instance | taskId (path,required) |

### GET /cmmn-history/historic-task-instances/{taskId}

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
| DELETE | `/cmmn-history/historic-task-instances/{taskId}` | Delete a historic task instance | taskId (path,required) |

### DELETE /cmmn-history/historic-task-instances/{taskId}

Delete a historic task instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **204**: Indicates that the historic task instance was deleted.

- **404**: Indicates that the historic task instance could not be found.
| GET | `/cmmn-history/historic-task-instances/{taskId}/form` | Get a historic task instance form | taskId (path,required) |

### GET /cmmn-history/historic-task-instances/{taskId}/form

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
| GET | `/cmmn-history/historic-task-instances/{taskId}/identitylinks` | List identity links of a historic task instance | taskId (path,required) |

### GET /cmmn-history/historic-task-instances/{taskId}/identitylinks

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
| GET | `/cmmn-history/historic-task-instances/{taskId}/variables/{variableName}/data` | Get the binary data for a historic task instance variable | taskId (path,required), variableName (path,required), scope (query) |

### GET /cmmn-history/historic-task-instances/{taskId}/variables/{variableName}/data

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

- **404**: Indicates the requested task instance was not found or the process instance does not have a variable with the given name or the variable does not  have a binary stream available. Status message provides additional information.
| GET | `/cmmn-history/historic-variable-instances` | List of historic variable instances | caseInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-history/historic-variable-instances

List of historic variable instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | query |  |  | The case instance id of the historic variable instance. |  |
| taskId | query |  |  | The task id of the historic variable instance. |  |
| excludeTaskVariables | query |  |  | Indication to exclude the task variables from the result. |  |
| excludeLocalVariables | query |  |  | Indication to exclude local variables or not. |  |
| variableName | query |  |  | The variable name of the historic variable instance. |  |
| variableNameLike | query |  |  | The variable name using the like operator for the historic variable instance. |  |
| sort | query |  |  | The field to sort by. Defaults to 'variableName'. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates that historic variable instances could be queried.

```json
{
  "$ref": "#/definitions/DataResponseHistoricVariableInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/cmmn-history/historic-variable-instances/{varInstanceId}/data` | Get the binary data for a historic task instance variable | varInstanceId (path,required) |

### GET /cmmn-history/historic-variable-instances/{varInstanceId}/data

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
| GET | `/cmmn-management/deadletter-jobs` | List deadletter jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-management/deadletter-jobs

List deadletter jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.
| POST | `/cmmn-management/deadletter-jobs` | Move a bulk of deadletter jobs. Accepts 'move' and 'moveToHistoryJob' as action. | body (body) |

### POST /cmmn-management/deadletter-jobs

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
| GET | `/cmmn-management/deadletter-jobs/{jobId}` | Get a single deadletter job | jobId (path,required) |

### GET /cmmn-management/deadletter-jobs/{jobId}

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
| POST | `/cmmn-management/deadletter-jobs/{jobId}` | Move a single deadletter job. Accepts 'move' and 'moveToHistoryJob' as action. | jobId (path,required), body (body) |

### POST /cmmn-management/deadletter-jobs/{jobId}

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
| DELETE | `/cmmn-management/deadletter-jobs/{jobId}` | Delete a deadletter job | jobId (path,required) |

### DELETE /cmmn-management/deadletter-jobs/{jobId}

Delete a deadletter job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/cmmn-management/deadletter-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a deadletter job | jobId (path,required) |

### GET /cmmn-management/deadletter-jobs/{jobId}/exception-stacktrace

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
| GET | `/cmmn-management/engine` | Get engine info |  |

### GET /cmmn-management/engine

Get engine info

**Responses**

- **200**: Indicates the engine info is returned.

```json
{
  "$ref": "#/definitions/EngineInfoResponse"
}
```
| GET | `/cmmn-management/history-jobs` | List history jobs | id (query), withException (query), exceptionMessage (query), scopeType (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), lockOwner (query), locked (query), unlocked (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-management/history-jobs

List history jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseHistoryJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.
| GET | `/cmmn-management/history-jobs/{jobId}` | Get a single history job job | jobId (path,required) |

### GET /cmmn-management/history-jobs/{jobId}

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
| POST | `/cmmn-management/history-jobs/{jobId}` | Execute a history job | jobId (path,required), body (body) |

### POST /cmmn-management/history-jobs/{jobId}

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
| DELETE | `/cmmn-management/history-jobs/{jobId}` | Delete a history job | jobId (path,required) |

### DELETE /cmmn-management/history-jobs/{jobId}

Delete a history job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the history job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/cmmn-management/jobs` | List jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-management/jobs

List jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.
| GET | `/cmmn-management/jobs/{jobId}` | Get a single job | jobId (path,required) |

### GET /cmmn-management/jobs/{jobId}

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
| POST | `/cmmn-management/jobs/{jobId}` | Execute a single job | jobId (path,required), body (body) |

### POST /cmmn-management/jobs/{jobId}

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
| DELETE | `/cmmn-management/jobs/{jobId}` | Delete a job | jobId (path,required) |

### DELETE /cmmn-management/jobs/{jobId}

Delete a job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found..
| GET | `/cmmn-management/jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a job | jobId (path,required) |

### GET /cmmn-management/jobs/{jobId}/exception-stacktrace

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
| GET | `/cmmn-management/suspended-jobs` | List suspended jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-management/suspended-jobs

List suspended jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.
| GET | `/cmmn-management/suspended-jobs/{jobId}` | Get a single suspended job | jobId (path,required) |

### GET /cmmn-management/suspended-jobs/{jobId}

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
| DELETE | `/cmmn-management/suspended-jobs/{jobId}` | Delete a suspended job | jobId (path,required) |

### DELETE /cmmn-management/suspended-jobs/{jobId}

Delete a suspended job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/cmmn-management/suspended-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a suspended job | jobId (path,required) |

### GET /cmmn-management/suspended-jobs/{jobId}/exception-stacktrace

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
| GET | `/cmmn-management/timer-jobs` | List timer jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-management/timer-jobs

List timer jobs

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

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter or the both 'messagesOnly' and 'timersOnly' are used as parameters. Status description contains additional details about the error.
| GET | `/cmmn-management/timer-jobs/{jobId}` | Get a single timer job | jobId (path,required) |

### GET /cmmn-management/timer-jobs/{jobId}

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
| POST | `/cmmn-management/timer-jobs/{jobId}` | Execute a single job action (move or reschedule) | jobId (path,required), body (body) |

### POST /cmmn-management/timer-jobs/{jobId}

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
| DELETE | `/cmmn-management/timer-jobs/{jobId}` | Delete a timer job | jobId (path,required) |

### DELETE /cmmn-management/timer-jobs/{jobId}

Delete a timer job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the job was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested job was not found.
| GET | `/cmmn-management/timer-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a timer job | jobId (path,required) |

### GET /cmmn-management/timer-jobs/{jobId}/exception-stacktrace

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
| POST | `/cmmn-query/case-instances` | Query case instances | body (body), sort (body) |

### POST /cmmn-query/case-instances

The request body can contain all possible filters that can be used in the List case instances URL query. On top of these, it’s possible to provide an array of variables to include in the query, with their format described here.

The general paging and sorting query-parameters can be used for this URL.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/CaseInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/CaseInstanceQueryResource | The field to sort by. Defaults to 'id'. |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the case instances are returned

```json
{
  "$ref": "#/definitions/DataResponseCaseInstanceResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.
| POST | `/cmmn-query/historic-case-instances` | Query for historic case instances | body (body), sort (body) |

### POST /cmmn-query/historic-case-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic case instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long. On top of that, the query allows for filtering based on process variables. The variables property is a JSON-array containing objects with the format as described here.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricCaseInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricCaseInstanceQueryResource | The field to sort by. Defaults to 'caseInstanceId'. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricCaseInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the case instances are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricCaseInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/cmmn-query/historic-milestone-instances` | Query for historic milestone instances | body (body), sort (body) |

### POST /cmmn-query/historic-milestone-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic milestone instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricMilestoneInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricMilestoneInstanceQueryResource | The field to sort by. Defaults to 'timestamp'. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricMilestoneInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the milestone instances are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricMilestoneInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/cmmn-query/historic-planitem-instances` | Query for historic plan item instances | body (body), sort (body) |

### POST /cmmn-query/historic-planitem-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic plan item instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricPlanItemInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/HistoricPlanItemInstanceQueryResource | The field to sort by. Defaults to 'createTime'. |  |

**Request**

```json
{
  "$ref": "#/definitions/HistoricPlanItemInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the plan item instances are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricPlanItemInstanceResponse"
}
```

- **400**: Indicates an parameter was passed in the wrong format. The status-message contains additional information.
| POST | `/cmmn-query/historic-task-instances` | Query for historic task instances | body (body), sort (body) |

### POST /cmmn-query/historic-task-instances

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
| POST | `/cmmn-query/historic-variable-instances` | Query for historic variable instances | body (body), sort (query) |

### POST /cmmn-query/historic-variable-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of historic process instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long. On top of that, the query allows for filtering based on process variables. The variables property is a JSON-array containing objects with the format as described here.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/HistoricVariableInstanceQueryRequest |  |  |
| sort | query |  |  | The field to sort by. Defaults to 'variableName'. |  |

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
| POST | `/cmmn-query/plan-item-instances` | Query plan item instances | body (body), sort (body) |

### POST /cmmn-query/plan-item-instances

The request body can contain all possible filters that can be used in the List plan item instances URL query. On top of these, it’s possible to provide an array of variables and caseInstanceVariables to include in the query, with their format described here.

The general paging and sorting query-parameters can be used for this URL.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/PlanItemInstanceQueryRequest |  |  |
| sort | body |  | #/definitions/PlanItemInstanceQueryResource | The field to sort by. Defaults to 'createTime'. |  |

**Request**

```json
{
  "$ref": "#/definitions/PlanItemInstanceQueryRequest"
}
```

**Responses**

- **200**: Indicates request was successful and the plan item instances are returned.

```json
{
  "$ref": "#/definitions/DataResponsePlanItemInstanceResponse"
}
```

- **404**: Indicates a parameter was passed in the wrong format. The status message contains additional information.
| POST | `/cmmn-query/tasks` | Query for tasks | body (body), sort (body) |

### POST /cmmn-query/tasks

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
| POST | `/cmmn-query/variable-instances` | Query for variable instances | body (body), sort (query) |

### POST /cmmn-query/variable-instances

All supported JSON parameter fields allowed are exactly the same as the parameters found for getting a collection of variable instances, but passed in as JSON-body arguments rather than URL-parameters to allow for more advanced querying and preventing errors with request-uri’s that are too long.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/VariableInstanceQueryRequest |  |  |
| sort | query |  |  | The field to sort by. Defaults to 'variableName'. |  |

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
| GET | `/cmmn-repository/case-definitions` | List of case definitions | version (query), name (query), nameLike (query), nameLikeIgnoreCase (query), key (query), keyLike (query), resourceName (query), resourceNameLike (query), category (query), categoryLike (query), categoryNotEquals (query), deploymentId (query), parentDeploymentId (query), startableByUser (query), latest (query), suspended (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-repository/case-definitions

List of case definitions

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| version | query |  |  | Only return case definitions with the given version. |  |
| name | query |  |  | Only return case definitions with the given name. |  |
| nameLike | query |  |  | Only return case definitions with a name like the given name. |  |
| nameLikeIgnoreCase | query |  |  | Only return case definitions with a name like the given name ignoring case. |  |
| key | query |  |  | Only return case definitions with the given key. |  |
| keyLike | query |  |  | Only return case definitions with a name like the given key. |  |
| resourceName | query |  |  | Only return case definitions with the given resource name. |  |
| resourceNameLike | query |  |  | Only return case definitions with a name like the given resource name. |  |
| category | query |  |  | Only return case definitions with the given category. |  |
| categoryLike | query |  |  | Only return case definitions with a category like the given name. |  |
| categoryNotEquals | query |  |  | Only return case definitions which do not have the given category. |  |
| deploymentId | query |  |  | Only return case definitions which are part of a deployment with the given deployment id. |  |
| parentDeploymentId | query |  |  | Only return case definitions which are part of a deployment with the given parent deployment id. |  |
| startableByUser | query |  |  | Only return case definitions which are part of a deployment with the given id. |  |
| latest | query |  |  | Only return the latest case definition versions. Can only be used together with key and keyLike parameters, using any other parameter will result in a 400-response. |  |
| suspended | query |  |  | If true, only returns case definitions which are suspended. If false, only active process definitions (which are not suspended) are returned. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the case definitions are returned

```json
{
  "$ref": "#/definitions/DataResponseCaseDefinitionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format or that latest is used with other parameters other than key and keyLike. The status-message contains additional information.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}` | Get a case definition | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}

Get a case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the case definitions are returned

```json
{
  "$ref": "#/definitions/CaseDefinitionResponse"
}
```

- **404**: Indicates the requested case definition was not found.
| PUT | `/cmmn-repository/case-definitions/{caseDefinitionId}` | Execute actions for a case definition | caseDefinitionId (path,required), body (body,required) |

### PUT /cmmn-repository/case-definitions/{caseDefinitionId}

Execute actions for a case definition (Update category)

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |
| body | body | yes | #/definitions/CaseDefinitionActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseDefinitionActionRequest"
}
```

**Responses**

- **200**: Indicates action has been executed for the specified process. (category altered)

```json
{
  "$ref": "#/definitions/CaseDefinitionResponse"
}
```

- **400**: Indicates no category was defined in the request body.

- **404**: Indicates the requested case definition was not found.
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/batch-migrate` | Batch migrate all instances of case definition | caseDefinitionId (path,required), body (body) |

### POST /cmmn-repository/case-definitions/{caseDefinitionId}/batch-migrate

Batch migrate all instances of case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates case instances were found and batch migration was started.

- **404**: Indicates the requested case definition was not found.
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/batch-migrate-historic-instances` | Batch migrate all historic instances of case definition | caseDefinitionId (path,required), body (body) |

### POST /cmmn-repository/case-definitions/{caseDefinitionId}/batch-migrate-historic-instances

Batch migrate all historic instances of case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates historic case instances were found and batch migration was started.

- **404**: Indicates the requested case definition was not found.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/decision-tables` | List decision tables for a case definition | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/decision-tables

List decision tables for a case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case definition was found and the decision tables are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/DmnDecision"
  }
}
```

- **404**: Indicates the requested case definition was not found.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/decisions` | List decisions for a case definition | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/decisions

List decisions for a case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case definition was found and the decisions are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/DmnDecision"
  }
}
```

- **404**: Indicates the requested case definition was not found.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/form-definitions` | List form definitions for a case definition | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/form-definitions

List form definitions for a case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case definition was found and the form definitions are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/FormDefinition"
  }
}
```

- **404**: Indicates the requested case definition was not found.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks` | List candidate starters for a case definition | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks

List candidate starters for a case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case definition was found and the requested identity links are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestIdentityLink"
  }
}
```

- **404**: Indicates the requested case definition was not found.
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks` | Add a candidate starter to a case definition | caseDefinitionId (path,required), body (body) |

### POST /cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks

It is possible to add either a user or a group.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

**Responses**

- **201**: Indicates the case definition was found and the identity link was created.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **400**: Indicates the body does not contain the correct information.

- **404**: Indicates the requested case definition was not found.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks/{family}/{identityId}` | Get a candidate starter from a case definition | caseDefinitionId (path,required), family (path,required), identityId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks/{family}/{identityId}

Get a candidate starter from a case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case definition was found and the identity link was returned.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **404**: Indicates the requested case definition was not found or the case definition does not have an identity-link that matches the url.
| DELETE | `/cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks/{family}/{identityId}` | Delete a candidate starter from a case definition | caseDefinitionId (path,required), family (path,required), identityId (path,required) |

### DELETE /cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks/{family}/{identityId}

Delete a candidate starter from a case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the case definition was found and the identity link was removed. The response body is intentionally empty.

- **404**: Indicates the requested case definition was not found or the case definition does not have an identity-link that matches the url.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/image` | Get a case definition image | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/image

Get a case definition image

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the case definitions are returned

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested case definition was not found.
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/migrate` | Migrate all instances of case definition | caseDefinitionId (path,required), body (body) |

### POST /cmmn-repository/case-definitions/{caseDefinitionId}/migrate

Migrate all instances of case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates case instances were found and migration was executed.

- **404**: Indicates the requested case definition was not found.
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/migrate-historic-instances` | Migrate all historic case instances of case definition | caseDefinitionId (path,required), body (body) |

### POST /cmmn-repository/case-definitions/{caseDefinitionId}/migrate-historic-instances

Migrate all historic case instances of case definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates historic case instances were found and migration was executed.

- **404**: Indicates the requested case definition was not found.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/model` | Get a case definition CMMN model | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/model

Get a case definition CMMN model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the process definition was found and the model is returned. The response contains the full process definition model.

```json
{
  "$ref": "#/definitions/CmmnModel"
}
```

- **404**: Indicates the requested process definition was not found.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/resourcedata` | Get a case definition resource content | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/resourcedata

Get a case definition resource content

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both case definition and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested case definition was not found or there is no resource with the given id present in the case definition. The status-description contains additional information.
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/start-form` | Get a case definition start form | caseDefinitionId (path,required) |

### GET /cmmn-repository/case-definitions/{caseDefinitionId}/start-form

Get a case definition start form

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the case definition form is returned

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested case definition was not found.
| GET | `/cmmn-repository/deployments` | List Deployments | name (query), nameLike (query), category (query), categoryNotEquals (query), parentDeploymentId (query), parentDeploymentIdLike (query), tenantIdLike (query), tenantId (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-repository/deployments

List Deployments

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| name | query |  |  | Only return deployments with the given name. |  |
| nameLike | query |  |  | Only return deployments with a name like the given name. |  |
| category | query |  |  | Only return deployments with the given category. |  |
| categoryNotEquals | query |  |  | Only return deployments which do not have the given category. |  |
| parentDeploymentId | query |  |  | Only return deployments with the given parent deployment id. |  |
| parentDeploymentIdLike | query |  |  | Only return deployments with a parent deployment id like the given value. |  |
| tenantIdLike | query |  |  | Only return deployments with a tenantId like the given value. |  |
| tenantId | query |  |  | Only return deployments with the given tenantId. |  |
| withoutTenantId | query |  |  | If true, only returns deployments without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates the request was successful.

```json
{
  "$ref": "#/definitions/DataResponseCmmnDeploymentResponse"
}
```
| POST | `/cmmn-repository/deployments` | Create a new deployment | deploymentKey (query), deploymentName (query), tenantId (query), file (formData,required) |

### POST /cmmn-repository/deployments

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
  "$ref": "#/definitions/CmmnDeploymentResponse"
}
```

- **400**: Indicates there was no content present in the request body or the content mime-type is not supported for deployment. The status-description contains additional information.
| GET | `/cmmn-repository/deployments/{deploymentId}` | Get a deployment | deploymentId (path,required) |

### GET /cmmn-repository/deployments/{deploymentId}

Get a deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  | The id of the deployment to get. |  |

**Responses**

- **200**: Indicates the deployment was found and returned.

```json
{
  "$ref": "#/definitions/CmmnDeploymentResponse"
}
```

- **404**: Indicates the requested deployment was not found.
| DELETE | `/cmmn-repository/deployments/{deploymentId}` | Delete a deployment | deploymentId (path,required), cascade (query) |

### DELETE /cmmn-repository/deployments/{deploymentId}

Delete a deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |
| cascade | query |  |  |  |  |

**Responses**

- **204**: Indicates the deployment was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested deployment was not found.
| GET | `/cmmn-repository/deployments/{deploymentId}/resourcedata/{resourceName}` | Get a deployment resource content | deploymentId (path,required), resourceName (path,required) |

### GET /cmmn-repository/deployments/{deploymentId}/resourcedata/{resourceName}

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
| GET | `/cmmn-repository/deployments/{deploymentId}/resources` | List resources in a deployment | deploymentId (path,required) |

### GET /cmmn-repository/deployments/{deploymentId}/resources

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
| GET | `/cmmn-repository/deployments/{deploymentId}/resources/**` | Get a deployment resource | deploymentId (path,required) |

### GET /cmmn-repository/deployments/{deploymentId}/resources/**

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
| GET | `/cmmn-runtime/case-instances` | List case instances | id (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), caseDefinitionId (query), caseDefinitionCategory (query), caseDefinitionCategoryLike (query), caseDefinitionCategoryLikeIgnoreCase (query), caseDefinitionName (query), caseDefinitionNameLike (query), caseDefinitionNameLikeIgnoreCase (query), name (query), nameLike (query), nameLikeIgnoreCase (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), caseInstanceParentId (query), startedBy (query), startedBefore (query), startedAfter (query), state (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), referenceId (query), referenceType (query), lastReactivatedBy (query), lastReactivatedBefore (query), lastReactivatedAfter (query), includeCaseVariables (query), includeCaseVariablesName (query), activePlanItemDefinitionId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), sort (query) |

### GET /cmmn-runtime/case-instances

List case instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return models with the given version. |  |
| caseDefinitionKey | query |  |  | Only return case instances with the given case definition key. |  |
| caseDefinitionKeyLike | query |  |  | Only return case instances like given case definition key. |  |
| caseDefinitionKeyLikeIgnoreCase | query |  |  | Only return case instances like given case definition key, ignoring case. |  |
| caseDefinitionId | query |  |  | Only return case instances with the given case definition id. |  |
| caseDefinitionCategory | query |  |  | Only return case instances with the given case definition category. |  |
| caseDefinitionCategoryLike | query |  |  | Only return case instances like the given case definition category. |  |
| caseDefinitionCategoryLikeIgnoreCase | query |  |  | Only return case instances like the given case definition category, ignoring case. |  |
| caseDefinitionName | query |  |  | Only return case instances with the given case definition name. |  |
| caseDefinitionNameLike | query |  |  | Only return case instances like the given case definition name. |  |
| caseDefinitionNameLikeIgnoreCase | query |  |  | Only return case instances like the given case definition name, ignoring case. |  |
| name | query |  |  | Only return case instances with the given name. |  |
| nameLike | query |  |  | Only return case instances like the given name. |  |
| nameLikeIgnoreCase | query |  |  | Only return case instances like the given name ignoring case. |  |
| rootScopeId | query |  |  | Only return case instances which have the given root scope id (that can be a process or case instance ID). |  |
| parentScopeId | query |  |  | Only return case instances which have the given parent scope id (that can be a process or case instance ID). |  |
| businessKey | query |  |  | Only return case instances with the given business key. |  |
| businessKeyLike | query |  |  | Only return case instances like the given business key. |  |
| businessKeyLikeIgnoreCase | query |  |  | Only return case instances like the given business key, ignoring case. |  |
| businessStatus | query |  |  | Only return case instances with the given business status. |  |
| businessStatusLike | query |  |  | Only return case instances like the given business status. |  |
| businessStatusLikeIgnoreCase | query |  |  | Only return case instances like the given business status, ignoring case. |  |
| caseInstanceParentId | query |  |  | Only return case instances with the given parent id. |  |
| startedBy | query |  |  | Only return case instances started by the given user. |  |
| startedBefore | query |  |  | Only return case instances started before the given date. |  |
| startedAfter | query |  |  | Only return case instances started after the given date. |  |
| state | query |  |  | Only return case instances with the given state. |  |
| callbackId | query |  |  | Only return case instances which have the given callback id. |  |
| callbackType | query |  |  | Only return case instances which have the given callback type. |  |
| parentCaseInstanceId | query |  |  | Only return case instances which have the given parent case instance id. |  |
| referenceId | query |  |  | Only return case instances which have the given reference id. |  |
| referenceType | query |  |  | Only return case instances which have the given reference type. |  |
| lastReactivatedBy | query |  |  | Only return case instances last reactivated by the given user. |  |
| lastReactivatedBefore | query |  |  | Only return case instances last reactivated before the given date. |  |
| lastReactivatedAfter | query |  |  | Only return case instances last reactivated after the given date. |  |
| includeCaseVariables | query |  |  | Indication to include case variables in the result. |  |
| includeCaseVariablesName | query |  |  | Indication to include case variables with the given names in the result. |  |
| activePlanItemDefinitionId | query |  |  | Only return case instances that have an active plan item instance with the given plan item definition id. |  |
| tenantId | query |  |  | Only return case instances with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return case instances with a tenantId like the given value. |  |
| tenantIdLikeIgnoreCase | query |  |  | Only return case instances with a tenantId like the given value, ignoring case. |  |
| withoutTenantId | query |  |  | If true, only returns case instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |

**Responses**

- **200**: Indicates request was successful and the case instances are returned

```json
{
  "$ref": "#/definitions/DataResponseCaseInstanceResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format . The status message contains additional information.
| POST | `/cmmn-runtime/case-instances` | Start a case instance | body (body) |

### POST /cmmn-runtime/case-instances

Note that also a *transientVariables* property is accepted as part of this json, that follows the same structure as the *variables* property.

Only one of *caseDefinitionId* or *caseDefinitionKey* an be used in the request body.

Parameters *businessKey*, *variables* and *tenantId* are optional.

If tenantId is omitted, the default tenant will be used.

 It is possible to send variables, transientVariables and startFormVariables in one request.

More information about the variable format can be found in the REST variables section.

 Note that the variable-scope that is supplied is ignored, case-variables are always local.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/CaseInstanceCreateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceCreateRequest"
}
```

**Responses**

- **201**: Indicates the case instance was created.

```json
{
  "$ref": "#/definitions/CaseInstanceResponse"
}
```

- **400**: Indicates either the case definition was not found (based on id or key), no process is started by sending the given message or an invalid variable has been passed. Status description contains additional information about the error.
| POST | `/cmmn-runtime/case-instances/delete` | Post action request to delete/terminate a bulk of case instances | body (body) |

### POST /cmmn-runtime/case-instances/delete

Post action request to delete/terminate a bulk of case instances

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

- **204**: Indicates the bulk of case instances was found and deleted. Response body is left empty intentionally.

- **404**: Indicates at least one requested case instance was not found.
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}` | Get a case instance | caseInstanceId (path,required) |

### GET /cmmn-runtime/case-instances/{caseInstanceId}

Get a case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case instance was found and returned.

```json
{
  "$ref": "#/definitions/CaseInstanceResponse"
}
```

- **404**: Indicates the requested case instance was not found.
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}` | Update case instance properties or execute an action on a case instance (body needs to contain an 'action' property for the latter). | caseInstanceId (path,required), body (body) |

### PUT /cmmn-runtime/case-instances/{caseInstanceId}

Update case instance properties or execute an action on a case instance (body needs to contain an 'action' property for the latter).

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceUpdateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceUpdateRequest"
}
```

**Responses**

- **200**: Indicates the case instance was found and the action/update is performed.

```json
{
  "$ref": "#/definitions/CaseInstanceResponse"
}
```

- **204**: Indicates the case was found, the change was performed and it caused the case instance to end.

- **400**: Indicates an illegal parameter was passed, required parameters are missing in the request body or illegal variables are passed in. Status description contains additional information about the error.

- **404**: Indicates the case instance was not found.
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}` | Terminate a case instance | caseInstanceId (path,required) |

### DELETE /cmmn-runtime/case-instances/{caseInstanceId}

Terminate a case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the case instance was found and terminate. Response body is left empty intentionally.

- **404**: Indicates the requested case instance was not found.
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/change-state` | Change the state of a case instance | caseInstanceId (path,required), body (body) |

### POST /cmmn-runtime/case-instances/{caseInstanceId}/change-state

Change the state of a case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ChangePlanItemStateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ChangePlanItemStateRequest"
}
```

**Responses**

- **200**: Indicates the case instance was found and change state activity was executed.

- **404**: Indicates the requested case instance was not found.
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/delete` | Delete a case instance | caseInstanceId (path,required) |

### DELETE /cmmn-runtime/case-instances/{caseInstanceId}/delete

Delete a case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the case instance was found and deleted. Response body is left empty intentionally.

- **404**: Indicates the requested case instance was not found.
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/diagram` | Get diagram for a case instance | caseInstanceId (path,required) |

### GET /cmmn-runtime/case-instances/{caseInstanceId}/diagram

Get diagram for a case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case instance was found and the diagram was returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **400**: Indicates the requested case instance was not found but the process does not contain any graphical information (CMMN DI) and no diagram can be created.

- **404**: Indicates the requested case instance was not found.
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks` | Get involved people for case instance | caseInstanceId (path,required) |

### GET /cmmn-runtime/case-instances/{caseInstanceId}/identitylinks

Note that the groupId in Response Body will always be null, as it’s only possible to involve users with a case instance.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case instance was found and links are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestIdentityLink"
  }
}
```

- **404**: Indicates the requested case instance was not found.
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks` | Add an involved user to a case instance | caseInstanceId (path,required), body (body) |

### POST /cmmn-runtime/case-instances/{caseInstanceId}/identitylinks

Note that the groupId in Response Body will always be null, as it’s only possible to involve users with a case instance.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

**Responses**

- **201**: Indicates the case instance was found and the link is created.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **400**: Indicates the requested body did not contain a userId or a type.

- **404**: Indicates the requested case instance was not found.
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}` | Get a specific involved people from case instance | caseInstanceId (path,required), identityId (path,required), type (path,required) |

### GET /cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}

Get a specific involved people from case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case instance was found and the specified link is retrieved.

```json
{
  "$ref": "#/definitions/RestIdentityLink"
}
```

- **404**: Indicates the requested case instance was not found or the link to delete does not exist. The response status contains additional information about the error.
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}` | Remove an involved user to from case instance | caseInstanceId (path,required), identityId (path,required), type (path,required) |

### DELETE /cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}

Remove an involved user to from case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

**Responses**

- **204**: Indicates the case instance was found and the link has been deleted. Response body is left empty intentionally.

- **404**: Indicates the requested case instance was not found or the link to delete does not exist. The response status contains additional information about the error.
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/migrate` | Migrate case instance | caseInstanceId (path,required), body (body) |

### POST /cmmn-runtime/case-instances/{caseInstanceId}/migrate

Migrate case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | string |  |  |

**Request**

```json
{
  "type": "string"
}
```

**Responses**

- **200**: Indicates the case instance was found and migration was executed.

- **404**: Indicates the requested case instance was not found.

- **409**: Indicates the requested case instance action cannot be executed since the case-instance is already activated/suspended.
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/stage-overview` |  | caseInstanceId (path,required) |

### GET /cmmn-runtime/case-instances/{caseInstanceId}/stage-overview

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **200**: successful operation

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/StageResponse"
  }
}
```
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | List variables for a case instance | caseInstanceId (path,required) |

### GET /cmmn-runtime/case-instances/{caseInstanceId}/variables

In case the variable is a binary variable or serializable, the valueUrl points to an URL to fetch the raw value. If it’s a plain variable, the value is present in the response. Note that only local scoped variables are returned, as there is no global scope for case-instance variables.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the case instance was found and variables are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/RestVariable"
  }
}
```

- **400**: Indicates the requested case instance was not found.
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Create variables or new binary variable on a case instance | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

### POST /cmmn-runtime/case-instances/{caseInstanceId}/variables

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an array of RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the case-instance and existing ones are overridden without any error.
Any number of variables can be passed into the request body array.
Note that scope is ignored, only global variables can be set in a case instance.
NB: Swagger V2 specification doesn't support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableCollectionResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceVariableCollectionResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "type": "object"
}
```

- **201**: Indicates the case instance was found and variable is created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the requested case instance was not found.

- **409**: Indicates the case instance was found but already contains a variable with the given name (only thrown when POST method is used). Use the update-method instead.
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Update a multiple/single (non)binary variable on a case instance | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

### PUT /cmmn-runtime/case-instances/{caseInstanceId}/variables

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an array of RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the case-instance and existing ones are overridden without any error.
Any number of variables can be passed into the request body array.
Note that scope is ignored, only global variables can be set in a case instance.
NB: Swagger V2 specification doesn't support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableCollectionResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceVariableCollectionResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "type": "object"
}
```

- **201**: Indicates the case instance was found and variable is created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the requested case instance was not found.

- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Delete all variables | caseInstanceId (path,required) |

### DELETE /cmmn-runtime/case-instances/{caseInstanceId}/variables

Delete all variables

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

**Responses**

- **204**: Indicates variables were found and have been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested case instance was not found.
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async` | Create variables or new binary variable on a case instance asynchronously | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

### POST /cmmn-runtime/case-instances/{caseInstanceId}/variables-async

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an array of RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the case-instance and existing ones are overridden without any error.
Any number of variables can be passed into the request body array.
Note that scope is ignored, only global variables can be set in a case instance.
NB: Swagger V2 specification doesn't support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableCollectionResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceVariableCollectionResource"
}
```

**Responses**

- **201**: Indicates the job to create the variables has been created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **409**: Indicates the case instance contains a variable with the given name (only thrown when POST method is used). Use the update-method instead.
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async` | Update a multiple/single (non)binary variable on a case instance asynchronously | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

### PUT /cmmn-runtime/case-instances/{caseInstanceId}/variables-async

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable or an array of RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the case-instance and existing ones are overridden without any error.
Any number of variables can be passed into the request body array.
Note that scope is ignored, only global variables can be set in a case instance.
NB: Swagger V2 specification doesn't support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableCollectionResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceVariableCollectionResource"
}
```

**Responses**

- **201**: Indicates the job to update the variables has been created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async/{variableName}` | Update a single variable on a case instance asynchronously | caseInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |

### PUT /cmmn-runtime/case-instances/{caseInstanceId}/variables-async/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the case instance and existing ones are overridden without any error.
Note that scope is ignored, only global variables can be set in a case instance.
NB: Swagger V2 specification doesn't support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceVariableResource"
}
```

**Responses**

- **201**: Indicates the job to update the variable has been created.

- **404**: Indicates the case instance does not have a variable with the given name. Status description contains additional information about the error.
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Get a variable for a case instance | caseInstanceId (path,required), variableName (path,required), scope (query) |

### GET /cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}

Get a variable for a case instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates both the case instance and variable were found and variable is returned.

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **404**: Indicates the requested case instance was not found or the case instance does not have a variable with the given name. Status description contains additional information about the error.
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Update a single variable on a case instance | caseInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |

### PUT /cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
Nonexistent variables are created on the case instance and existing ones are overridden without any error.
Note that scope is ignored, only global variables can be set in a case instance.
NB: Swagger V2 specification doesn't support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/CaseInstanceVariableResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **201**: Indicates both the case instance and variable were found and variable is updated.

- **404**: Indicates the requested case instance was not found or the case instance does not have a variable with the given name. Status description contains additional information about the error.
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Delete a variable | caseInstanceId (path,required), variableName (path,required), scope (query) |

### DELETE /cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}

Delete a variable

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **204**: Indicates the variable was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested variable was not found.
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | caseInstanceId (path,required), variableName (path,required), scope (query) |

### GET /cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}/data

Get the binary data for a variable

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates the case instance was found and the requested variables are returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested case was not found or the case does not have a variable with the given name (in the given scope). Status message provides additional information.
| GET | `/cmmn-runtime/event-subscriptions` | List of event subscriptions | id (query), eventType (query), eventName (query), activityId (query), caseInstanceId (query), withoutScopeId (query), caseDefinitionId (query), withoutScopeDefinitionId (query), planItemInstanceId (query), createdBefore (query), createdAfter (query), tenantId (query), withoutTenantId (query), configuration (query), withoutConfiguration (query), withoutProcessInstanceId (query), withoutProcessDefinitionId (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-runtime/event-subscriptions

List of event subscriptions

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return event subscriptions with the given id |  |
| eventType | query |  |  | Only return event subscriptions with the given event type |  |
| eventName | query |  |  | Only return event subscriptions with the given event name |  |
| activityId | query |  |  | Only return event subscriptions with the given activity id |  |
| caseInstanceId | query |  |  | Only return event subscriptions part of a process with the given id |  |
| withoutScopeId | query |  |  | Only return event subscriptions that have no process instance id |  |
| caseDefinitionId | query |  |  | Only return event subscriptions with the given process definition id |  |
| withoutScopeDefinitionId | query |  |  | Only return event subscriptions that have no process definition id |  |
| planItemInstanceId | query |  |  | Only return event subscriptions part of a scope with the given id |  |
| createdBefore | query |  |  | Only return event subscriptions which are created before the given date. |  |
| createdAfter | query |  |  | Only return event subscriptions which are created after the given date. |  |
| tenantId | query |  |  | Only return event subscriptions with the given tenant id. |  |
| withoutTenantId | query |  |  | Only return event subscriptions that have no tenant id |  |
| configuration | query |  |  | Only return event subscriptions with the given configuration value. |  |
| withoutConfiguration | query |  |  | Only return event subscriptions that have no configuration value |  |
| withoutProcessInstanceId | query |  |  | Only return event subscriptions that have no process instance id |  |
| withoutProcessDefinitionId | query |  |  | Only return event subscriptions that have no process definition id |  |
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
| GET | `/cmmn-runtime/event-subscriptions/{eventSubscriptionId}` | Get a single event subscription | eventSubscriptionId (path,required) |

### GET /cmmn-runtime/event-subscriptions/{eventSubscriptionId}

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
| GET | `/cmmn-runtime/plan-item-instances` | List of plan item instances | id (query), caseDefinitionId (query), caseInstanceId (query), stageInstanceId (query), planItemDefinitionId (query), planItemDefinitionType (query), planItemDefinitionTypes (query), state (query), name (query), elementId (query), referenceId (query), referenceType (query), createdBefore (query), createdAfter (query), startUserId (query), includeEnded (query), includeLocalVariables (query), tenantId (query), withoutTenantId (query), sort (query) |

### GET /cmmn-runtime/plan-item-instances

List of plan item instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return models with the given version. |  |
| caseDefinitionId | query |  |  | Only return plan item instances with the given case definition id. |  |
| caseInstanceId | query |  |  | Only return plan item instances which are part of the case instance with the given id. |  |
| stageInstanceId | query |  |  | Only return plan item instances which are part of the given stage instance. |  |
| planItemDefinitionId | query |  |  | Only return plan item instances which have the given plan item definition id. |  |
| planItemDefinitionType | query |  |  | Only return plan item instances which have the given plan item definition type. |  |
| planItemDefinitionTypes | query |  |  | Only return plan item instances which have any of the given plan item definition types. Comma-separated string e.g. humantask, stage |  |
| state | query |  |  | Only return plan item instances which have the given state. |  |
| name | query |  |  | Only return plan item instances which have the given name. |  |
| elementId | query |  |  | Only return plan item instances which have the given element id. |  |
| referenceId | query |  |  | Only return plan item instances which have the given reference id. |  |
| referenceType | query |  |  | Only return plan item instances which have the given reference type. |  |
| createdBefore | query |  |  | Only return plan item instances which are created before the given date. |  |
| createdAfter | query |  |  | Only return plan item instances which are created after the given date. |  |
| startUserId | query |  |  | Only return plan item instances which are started by the given user id. |  |
| includeEnded | query |  |  | Define if ended plan item instances should be included. |  |
| includeLocalVariables | query |  |  | Indication to include local variables in the result. |  |
| tenantId | query |  |  | Only return plan item instances with the given tenantId. |  |
| withoutTenantId | query |  |  | If true, only returns plan item instances without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |

**Responses**

- **200**: Indicates request was successful and the executions are returned

```json
{
  "$ref": "#/definitions/DataResponsePlanItemInstanceResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.
| GET | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}` | Get an plan item instance | planItemInstanceId (path,required) |

### GET /cmmn-runtime/plan-item-instances/{planItemInstanceId}

Get an plan item instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the plan item instance was found and returned.

```json
{
  "$ref": "#/definitions/PlanItemInstanceResponse"
}
```

- **404**: Indicates the plan item instance was not found.
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}` | Execute an action on a plan item instance | planItemInstanceId (path,required), body (body) |

### PUT /cmmn-runtime/plan-item-instances/{planItemInstanceId}

Execute an action on a plan item instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/RestActionRequest"
}
```

**Responses**

- **200**: Indicates the plan item instance was found and the action is performed.

```json
{
  "$ref": "#/definitions/PlanItemInstanceResponse"
}
```

- **204**: Indicates the plan item instance was found, the action was performed and the action caused the plan item instance to end.

- **400**: Indicates an illegal action was requested, required parameters are missing in the request body or illegal variables are passed in. Status description contains additional information about the error.

- **404**: Indicates the plan item instance was not found.
| POST | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables` | Create a variable on a plan item | planItemInstanceId (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

### POST /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/PlanItemInstanceVariableCollectionResource | Create a variable on a plan item instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/PlanItemInstanceVariableCollectionResource"
}
```

**Responses**

- **200**: successful operation

```json
{
  "type": "object"
}
```

- **201**: Indicates both the plan item instance and variable were found and variable is created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the requested plan item instance was not found or the plan item instance does not have a variable with the given name. Status description contains additional information about the error.

- **409**: Indicates the plan item instance was found but already contains a variable with the given name. Use the update-method instead.
| POST | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async` | Create a variable on a plan item asynchronously | planItemInstanceId (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

### POST /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/PlanItemInstanceVariableCollectionResource | Create a variable on a plan item instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/PlanItemInstanceVariableCollectionResource"
}
```

**Responses**

- **201**: Indicates the job to create a variable is created.

- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.

- **404**: Indicates the plan item instance does not have a variable with the given name. Status description contains additional information about the error.

- **409**: Indicates the plan item instance already contains a variable with the given name. Use the update-method instead.
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async/{variableName}` | Update a variable on a plan item asynchronously | planItemInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

### PUT /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/PlanItemInstanceVariableResource | Update a variable on a plan item instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/PlanItemInstanceVariableResource"
}
```

**Responses**

- **200**: Indicates the job to update a variable is created.

- **404**: Indicates the plan item instance does not have a variable with the given name. Status description contains additional information about the error.
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}` | Update a variable on a plan item | planItemInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

### PUT /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}

This endpoint can be used in 2 ways: By passing a JSON Body (RestVariable) or by passing a multipart/form-data Object.
NB: Swagger V2 specification does not support this use case that is why this endpoint might be buggy/incomplete if used with other tools.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/PlanItemInstanceVariableResource | Update a variable on a plan item instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

**Request**

```json
{
  "$ref": "#/definitions/PlanItemInstanceVariableResource"
}
```

**Responses**

- **200**: Indicates both the plan item instance and variable were found and variable is updated.

```json
{
  "$ref": "#/definitions/RestVariable"
}
```

- **404**: Indicates the requested plan item instance was not found or the plan item instance does not have a variable with the given name. Status description contains additional information about the error.
| DELETE | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}` | Delete a variable for a plan item instance | planItemInstanceId (path,required), variableName (path,required), scope (query) |

### DELETE /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}

Delete a variable for a plan item instance

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **204**: Indicates both the plan item and variable were found and variable has been deleted.

- **404**: Indicates the requested plan item was not found or the plan item does not have a variable with the given name in the requested scope. Status description contains additional information about the error.
| GET | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | planItemInstanceId (path,required), variableName (path,required), scope (query) |

### GET /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}/data

Get the binary data for a variable

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

**Responses**

- **200**: Indicates the plan item instance was found and the requested variables are returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested plan item was not found or the plan item does not have a variable with the given name (in the given scope). Status message provides additional information.
| GET | `/cmmn-runtime/tasks` | List of tasks | taskId (query), name (query), nameLike (query), nameLikeIgnoreCase (query), description (query), priority (query), minimumPriority (query), maximumPriority (query), assignee (query), assigneeLike (query), owner (query), ownerLike (query), unassigned (query), delegationState (query), candidateUser (query), candidateGroup (query), candidateGroups (query), involvedUser (query), taskDefinitionKey (query), taskDefinitionKeyLike (query), caseInstanceId (query), caseInstanceIdWithChildren (query), caseDefinitionId (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), planItemInstanceId (query), propagatedStageInstanceId (query), scopeId (query), withoutScopeId (query), subScopeId (query), scopeType (query), createdOn (query), createdBefore (query), createdAfter (query), dueOn (query), dueBefore (query), dueAfter (query), withoutDueDate (query), excludeSubTasks (query), active (query), includeTaskLocalVariables (query), includeProcessVariables (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), withoutProcessInstanceId (query), candidateOrAssigned (query), category (query), categoryIn (query), categoryNotIn (query), withoutCategory (query), rootScopeId (query), parentScopeId (query) |

### GET /cmmn-runtime/tasks

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
| caseInstanceId | query |  |  | Only return tasks which are part of the case instance with the given id. |  |
| caseInstanceIdWithChildren | query |  |  | Only return tasks which are part of the case instance and its children with the given id. |  |
| caseDefinitionId | query |  |  | Only return tasks which are part of a case instance which has a case definition with the given id. |  |
| caseDefinitionKey | query |  |  | Only return tasks which are part of a case instance which has a case definition with the given key. |  |
| caseDefinitionKeyLike | query |  |  | Only return tasks which are part of a case instance which has a case definition with the given key like the passed parameter. |  |
| caseDefinitionKeyLikeIgnoreCase | query |  |  | Only return tasks which are part of a case instance which has a case definition with the given key like the passed parameter. |  |
| planItemInstanceId | query |  |  | Only return tasks which are associated with the a plan item instance with the given id |  |
| propagatedStageInstanceId | query |  |  | Only return tasks which have the given id as propagated stage instance id |  |
| scopeId | query |  |  | Only return tasks which are part of the scope (e.g. case instance) with the given id. |  |
| withoutScopeId | query |  |  | If true, only returns tasks without a scope id set. If false, the withoutScopeId parameter is ignored. |  |
| subScopeId | query |  |  | Only return tasks which are part of the sub scope (e.g. plan item instance) with the given id. |  |
| scopeType | query |  |  | Only return tasks which are part of the scope type (e.g. bpmn, cmmn, etc). |  |
| createdOn | query |  |  | Only return tasks which are created on the given date. |  |
| createdBefore | query |  |  | Only return tasks which are created before the given date. |  |
| createdAfter | query |  |  | Only return tasks which are created after the given date. |  |
| dueOn | query |  |  | Only return tasks which are due on the given date. |  |
| dueBefore | query |  |  | Only return tasks which are due before the given date. |  |
| dueAfter | query |  |  | Only return tasks which are due after the given date. |  |
| withoutDueDate | query |  |  | Only return tasks which do not have a due date. The property is ignored if the value is false. |  |
| excludeSubTasks | query |  |  | Only return tasks that are not a subtask of another task. |  |
| active | query |  |  | If true, only return tasks that are not suspended (either part of a process that is not suspended or not part of a process at all). If false, only tasks that are part of suspended process instances are returned. |  |
| includeTaskLocalVariables | query |  |  | Indication to include task local variables in the result. |  |
| includeProcessVariables | query |  |  | Indication to include process variables in the result. |  |
| tenantId | query |  |  | Only return tasks with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return tasks with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns tasks without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| withoutProcessInstanceId | query |  |  | If true, only returns tasks without a process instance id set. If false, the withoutProcessInstanceId parameter is ignored. |  |
| candidateOrAssigned | query |  |  | Select tasks that has been claimed or assigned to user or waiting to claim by user (candidate user or groups). |  |
| category | query |  |  | Select tasks with the given category. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| categoryIn | query |  |  | Select tasks for the given categories. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| categoryNotIn | query |  |  | Select tasks which are not assigned to the given categories. Does not return tasks without categories. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| withoutCategory | query |  |  | Select tasks without a category assigned. Note that this is the task category, not the category of the process definition (namespace within the BPMN Xml). |  |
| rootScopeId | query |  |  | Only return tasks which have the given root scope id (that can be a process or case instance ID). |  |
| parentScopeId | query |  |  | Only return tasks which have the given parent scope id (that can be a process or case instance ID). |  |

**Responses**

- **200**: Indicates request was successful and the tasks are returned

```json
{
  "$ref": "#/definitions/DataResponseTaskResponse"
}
```

- **404**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.
| POST | `/cmmn-runtime/tasks` | Create Task | body (body) |

### POST /cmmn-runtime/tasks

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
| PUT | `/cmmn-runtime/tasks` | Update Tasks | body (body) |

### PUT /cmmn-runtime/tasks

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
| GET | `/cmmn-runtime/tasks/{taskId}` | Get a task | taskId (path,required) |

### GET /cmmn-runtime/tasks/{taskId}

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
| POST | `/cmmn-runtime/tasks/{taskId}` | Tasks actions | taskId (path,required), body (body) |

### POST /cmmn-runtime/tasks/{taskId}

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
| PUT | `/cmmn-runtime/tasks/{taskId}` | Update a task | taskId (path,required), body (body) |

### PUT /cmmn-runtime/tasks/{taskId}

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
| DELETE | `/cmmn-runtime/tasks/{taskId}` | Delete a task | taskId (path,required), cascadeHistory (query), deleteReason (query) |

### DELETE /cmmn-runtime/tasks/{taskId}

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
| GET | `/cmmn-runtime/tasks/{taskId}/form` | Get a task form | taskId (path,required) |

### GET /cmmn-runtime/tasks/{taskId}/form

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
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks` | List identity links for a task | taskId (path,required) |

### GET /cmmn-runtime/tasks/{taskId}/identitylinks

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
| POST | `/cmmn-runtime/tasks/{taskId}/identitylinks` | Create an identity link on a task | taskId (path,required), body (body) |

### POST /cmmn-runtime/tasks/{taskId}/identitylinks

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
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}` | List identity links for a task for either groups or users | taskId (path,required), family (path,required) |

### GET /cmmn-runtime/tasks/{taskId}/identitylinks/{family}

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
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Get a single identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |

### GET /cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}

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
| DELETE | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Delete an identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |

### DELETE /cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}

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
| GET | `/cmmn-runtime/tasks/{taskId}/subtasks` | List of sub tasks for a task | taskId (path,required) |

### GET /cmmn-runtime/tasks/{taskId}/subtasks

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
| GET | `/cmmn-runtime/tasks/{taskId}/variables` | List variables for a task | taskId (path,required), scope (query) |

### GET /cmmn-runtime/tasks/{taskId}/variables

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
| POST | `/cmmn-runtime/tasks/{taskId}/variables` | Create new variables on a task | taskId (path,required), body (body), name (formData), type (formData), scope (formData) |

### POST /cmmn-runtime/tasks/{taskId}/variables

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
| DELETE | `/cmmn-runtime/tasks/{taskId}/variables` | Delete all local variables on a task | taskId (path,required) |

### DELETE /cmmn-runtime/tasks/{taskId}/variables

Delete all local variables on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

**Responses**

- **204**: Indicates all local task variables have been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested task was not found.
| GET | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Get a variable from a task | taskId (path,required), variableName (path,required), scope (query) |

### GET /cmmn-runtime/tasks/{taskId}/variables/{variableName}

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
| PUT | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Update an existing variable on a task | taskId (path,required), variableName (path,required), body (body), name (formData), type (formData), scope (formData) |

### PUT /cmmn-runtime/tasks/{taskId}/variables/{variableName}

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
| DELETE | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Delete a variable on a task | taskId (path,required), variableName (path,required), scope (query) |

### DELETE /cmmn-runtime/tasks/{taskId}/variables/{variableName}

Delete a variable on a task

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

**Responses**

- **204**: Indicates the task variable was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested task was not found or the task does not have a variable with the given name. Status message contains additional information about the error.
| GET | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}/data` | Get the binary data for a variable | taskId (path,required), variableName (path,required), scope (query) |

### GET /cmmn-runtime/tasks/{taskId}/variables/{variableName}/data

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
| GET | `/cmmn-runtime/variable-instances` | List of variable instances | caseInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |

### GET /cmmn-runtime/variable-instances

List of variable instances

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | query |  |  | The case instance id of the variable instance. |  |
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
| GET | `/cmmn-runtime/variable-instances/{varInstanceId}/data` | Get the binary data for a variable instance | varInstanceId (path,required) |

### GET /cmmn-runtime/variable-instances/{varInstanceId}/data

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
