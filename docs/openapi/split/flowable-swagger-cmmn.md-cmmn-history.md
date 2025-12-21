# flowable-swagger-cmmn.md — cmmn-history (cmmn-history)

> Generated subset extracted from flowable-swagger-cmmn.md

## flowable-swagger-cmmn

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-case-instances` | List of historic case instances | caseInstanceId (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), caseDefinitionId (query), caseDefinitionCategory (query), caseDefinitionCategoryLike (query), caseDefinitionCategoryLikeIgnoreCase (query), caseDefinitionName (query), caseDefinitionNameLike (query), caseDefinitionNameLikeIgnoreCase (query), name (query), nameLike (query), nameLikeIgnoreCase (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), involvedUser (query), finished (query), finishedAfter (query), finishedBefore (query), startedAfter (query), startedBefore (query), startedBy (query), state (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), referenceId (query), referenceType (query), lastReactivatedBy (query), lastReactivatedBefore (query), lastReactivatedAfter (query), activePlanItemDefinitionId (query), includeCaseVariables (query), includeCaseVariablesName (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), withoutCaseInstanceParentId (query), withoutCaseInstanceCallbackId (query) |

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

## GET /cmmn-history/historic-case-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-history/historic-case-instances/delete` | Post action request to delete a bulk of historic case instances | bulkDeleteRestActionRequest (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| bulkDeleteRestActionRequest | body |  | #/definitions/BulkDeleteInstancesRestActionRequest |  |  |

#### Responses
- **204**: Indicates the bulk of historic case instances was found and deleted. Response body is left empty intentionally.
- **404**: Indicates at least one requested case instance was not found.

## POST /cmmn-history/historic-case-instances/delete

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}` | Get a historic case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates that the historic process instances could be found.
```json
{
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
}
```
- **404**: Indicates that the historic process instances could not be found.

## GET /cmmn-history/historic-case-instances/{caseInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-history/historic-case-instances/{caseInstanceId}` | Delete a historic case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **204**: Indicates that the historic process instance was deleted.
- **404**: Indicates that the historic process instance could not be found.

## DELETE /cmmn-history/historic-case-instances/{caseInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/identitylinks` | List identity links of a historic case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the identity links are returned
```json
[ {
  "type" : "participant",
  "userId" : "kermit",
  "groupId" : "sales",
  "taskId" : "null",
  "taskUrl" : "null",
  "caseInstanceId" : "5",
  "caseInstanceUrl" : "http://localhost:8182/cmmn-history/historic-case-instances/5"
} ]
```
- **404**: Indicates the process instance could not be found..

## GET /cmmn-history/historic-case-instances/{caseInstanceId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-history/historic-case-instances/{caseInstanceId}/migrate` | Migrate historic case instance | caseInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | string |  |  |

#### Responses
- **200**: Indicates the historiccase instance was found and migration was executed.
- **404**: Indicates the requested historic case instance was not found.

## POST /cmmn-history/historic-case-instances/{caseInstanceId}/migrate

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/stage-overview` | Get a stage overview of historic case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates that the historic case instance was found.
- **204**: successful operation
```json
[ {
  "id" : "string",
  "name" : "string",
  "ended" : false,
  "endTime" : "1970-01-01T00:00:00Z",
  "current" : false
} ]
```
- **404**: Indicates that the historic case instance could not be found.

## GET /cmmn-history/historic-case-instances/{caseInstanceId}/stage-overview

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/variables/{variableName}/data` | Get the binary data for a historic case instance variable | caseInstanceId (path,required), variableName (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |

#### Responses
- **200**: Indicates the case instance was found and the requested variable data is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested case instance was not found or the process instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.

## GET /cmmn-history/historic-case-instances/{caseInstanceId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-milestone-instances` | List of historic milestone instances | milestoneId (query), milestoneName (query), caseInstanceId (query), caseDefinitionId (query), reachedBefore (query), reachedAfter (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| milestoneId | query |  |  | An id of the historic milestone instance. |  |
| milestoneName | query |  |  | The name of the historic milestone instance |  |
| caseInstanceId | query |  |  | The id of the case instance containing the milestone. |  |
| caseDefinitionId | query |  |  | The id of the definition of the case where the milestone is defined. |  |
| reachedBefore | query |  |  | Return only historic milestone instances that were reached before this date. |  |
| reachedAfter | query |  |  | Return only historic milestone instances that were reached after this date. |  |

#### Responses
- **200**: Indicates that historic milestone instances could be queried.
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

## GET /cmmn-history/historic-milestone-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-milestone-instances/{milestoneInstanceId}` | Get a historic milestone instance by id | milestoneInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| milestoneInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates that the historic milestone instances could be found.
```json
{
  "id" : "5",
  "name" : "milestoneName",
  "elementId" : "milestonePlanItemId",
  "timestamp" : "2013-04-18T14:06:32.715+0000",
  "caseInstanceId" : "12345",
  "caseDefinitionId" : "oneMilestoneCase%3A1%3A4",
  "url" : "http://localhost:8182/cmmn-history/historic-milestone-instances/5",
  "historicCaseInstanceUrl" : "http://localhost:8182/cmmn-history/historic-case-instances/12345",
  "caseDefinitionUrl" : "http://localhost:8182/cmmn-repository/case-definitions/oneMilestoneCase%3A1%3A4"
}
```
- **404**: Indicates that the historic milestone instances could not be found.

## GET /cmmn-history/historic-milestone-instances/{milestoneInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-planitem-instances` | List of historic plan item instances | planItemInstanceId (query), planItemInstanceName (query), planItemInstanceState (query), caseDefinitionId (query), caseInstanceId (query), stageInstanceId (query), elementId (query), planItemDefinitionId (query), planItemDefinitionType (query), createdBefore (query), createdAfter (query), lastAvailableBefore (query), lastAvailableAfter (query), lastEnabledBefore (query), lastEnabledAfter (query), lastDisabledBefore (query), lastDisabledAfter (query), lastStartedBefore (query), lastStartedAfter (query), lastSuspendedBefore (query), lastSuspendedAfter (query), completedBefore (query), completedAfter (query), terminatedBefore (query), terminatedAfter (query), occurredBefore (query), occurredAfter (query), exitBefore (query), exitAfter (query), endedBefore (query), endedAfter (query), startUserId (query), referenceId (query), referenceType (query), tenantId (query), withoutTenantId (query) |

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

#### Responses
- **200**: Indicates that historic planItem instances could be queried.
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

## GET /cmmn-history/historic-planitem-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-planitem-instances/{planItemInstanceId}` | Get a historic plan item instance | planItemInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates that the historic plan item instances could be found.
```json
{
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
}
```
- **404**: Indicates that the historic plan item instances could not be found.

## GET /cmmn-history/historic-planitem-instances/{planItemInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-task-instances` | List historic task instances | taskId (query), caseInstanceId (query), caseInstanceIdWithChildren (query), caseDefinitionId (query), propagatedStageInstanceId (query), withoutScopeId (query), taskDefinitionKey (query), taskName (query), taskNameLike (query), taskNameLikeIgnoreCase (query), taskDescription (query), taskDescriptionLike (query), taskCategory (query), taskCategoryIn (query), taskCategoryNotIn (query), taskWithoutCategory (query), taskDeleteReason (query), taskDeleteReasonLike (query), taskAssignee (query), taskAssigneeLike (query), taskOwner (query), taskOwnerLike (query), taskInvolvedUser (query), taskCandidateGroup (query), taskPriority (query), finished (query), processFinished (query), parentTaskId (query), dueDate (query), dueDateAfter (query), dueDateBefore (query), withoutDueDate (query), taskCompletedOn (query), taskCompletedAfter (query), taskCompletedBefore (query), taskCreatedOn (query), taskCreatedBefore (query), taskCreatedAfter (query), includeTaskLocalVariables (query), includeProcessVariables (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), withoutProcessInstanceId (query), planItemInstanceId (query), rootScopeId (query), parentScopeId (query) |

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

#### Responses
- **200**: Indicates that historic task instances could be queried.
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

## GET /cmmn-history/historic-task-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-task-instances/{taskId}` | Get a single historic task instance | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates that the historic task instances could be found.
```json
{
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
}
```
- **404**: Indicates that the historic task instances could not be found.

## GET /cmmn-history/historic-task-instances/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-history/historic-task-instances/{taskId}` | Delete a historic task instance | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **204**: Indicates that the historic task instance was deleted.
- **404**: Indicates that the historic task instance could not be found.

## DELETE /cmmn-history/historic-task-instances/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-task-instances/{taskId}/form` | Get a historic task instance form | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the task form is returned
```json
"string"
```
- **404**: Indicates the requested task was not found.

## GET /cmmn-history/historic-task-instances/{taskId}/form

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-task-instances/{taskId}/identitylinks` | List identity links of a historic task instance | taskId (path,required) |

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
  "caseInstanceId" : "5",
  "caseInstanceUrl" : "http://localhost:8182/cmmn-history/historic-case-instances/5"
} ]
```
- **404**: Indicates the task instance could not be found.

## GET /cmmn-history/historic-task-instances/{taskId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-task-instances/{taskId}/variables/{variableName}/data` | Get the binary data for a historic task instance variable | taskId (path,required), variableName (path,required), scope (query) |

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
- **404**: Indicates the requested task instance was not found or the process instance does not have a variable with the given name or the variable does not  have a binary stream available. Status message provides additional information.

## GET /cmmn-history/historic-task-instances/{taskId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-variable-instances` | List of historic variable instances | caseInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates that historic variable instances could be queried.
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

## GET /cmmn-history/historic-variable-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-history/historic-variable-instances/{varInstanceId}/data` | Get the binary data for a historic task instance variable | varInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| varInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the variable instance was found and the requested variable data is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested variable instance was not found or the variable instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
