# flowable-swagger-cmmn.md — cmmn-runtime (cmmn-runtime)

> Generated subset extracted from flowable-swagger-cmmn.md

## GET /cmmn-repository/deployments/{deploymentId}/resources/**

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances` | List case instances | id (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), caseDefinitionId (query), caseDefinitionCategory (query), caseDefinitionCategoryLike (query), caseDefinitionCategoryLikeIgnoreCase (query), caseDefinitionName (query), caseDefinitionNameLike (query), caseDefinitionNameLikeIgnoreCase (query), name (query), nameLike (query), nameLikeIgnoreCase (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), caseInstanceParentId (query), startedBy (query), startedBefore (query), startedAfter (query), state (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), referenceId (query), referenceType (query), lastReactivatedBy (query), lastReactivatedBefore (query), lastReactivatedAfter (query), includeCaseVariables (query), includeCaseVariablesName (query), activePlanItemDefinitionId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), sort (query) |

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
- **400**: Indicates a parameter was passed in the wrong format . The status message contains additional information.

## GET /cmmn-runtime/case-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/case-instances` | Start a case instance | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/CaseInstanceCreateRequest |  |  |

#### Responses
- **201**: Indicates the case instance was created.
```json
{
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
}
```
- **400**: Indicates either the case definition was not found (based on id or key), no process is started by sending the given message or an invalid variable has been passed. Status description contains additional information about the error.

## POST /cmmn-runtime/case-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/case-instances/delete` | Post action request to delete/terminate a bulk of case instances | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkDeleteInstancesRestActionRequest |  |  |

#### Responses
- **204**: Indicates the bulk of case instances was found and deleted. Response body is left empty intentionally.
- **404**: Indicates at least one requested case instance was not found.

## POST /cmmn-runtime/case-instances/delete

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}` | Get a case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the case instance was found and returned.
```json
{
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
}
```
- **404**: Indicates the requested case instance was not found.

## GET /cmmn-runtime/case-instances/{caseInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}` | Update case instance properties or execute an action on a case instance (body needs to contain an 'action' property for the latter). | caseInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceUpdateRequest |  |  |

#### Responses
- **200**: Indicates the case instance was found and the action/update is performed.
```json
{
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
}
```
- **204**: Indicates the case was found, the change was performed and it caused the case instance to end.
- **400**: Indicates an illegal parameter was passed, required parameters are missing in the request body or illegal variables are passed in. Status description contains additional information about the error.
- **404**: Indicates the case instance was not found.

## PUT /cmmn-runtime/case-instances/{caseInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}` | Terminate a case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the case instance was found and terminate. Response body is left empty intentionally.
- **404**: Indicates the requested case instance was not found.

## DELETE /cmmn-runtime/case-instances/{caseInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/change-state` | Change the state of a case instance | caseInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/ChangePlanItemStateRequest |  |  |

#### Responses
- **200**: Indicates the case instance was found and change state activity was executed.
- **404**: Indicates the requested case instance was not found.

## POST /cmmn-runtime/case-instances/{caseInstanceId}/change-state

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/delete` | Delete a case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the case instance was found and deleted. Response body is left empty intentionally.
- **404**: Indicates the requested case instance was not found.

## DELETE /cmmn-runtime/case-instances/{caseInstanceId}/delete

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/diagram` | Get diagram for a case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the case instance was found and the diagram was returned.
```json
[ "string" ]
```
- **400**: Indicates the requested case instance was not found but the process does not contain any graphical information (CMMN DI) and no diagram can be created.
- **404**: Indicates the requested case instance was not found.

## GET /cmmn-runtime/case-instances/{caseInstanceId}/diagram

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks` | Get involved people for case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the case instance was found and links are returned.
```json
[ {
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
} ]
```
- **404**: Indicates the requested case instance was not found.

## GET /cmmn-runtime/case-instances/{caseInstanceId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks` | Add an involved user to a case instance | caseInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

#### Responses
- **201**: Indicates the case instance was found and the link is created.
```json
{
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
}
```
- **400**: Indicates the requested body did not contain a userId or a type.
- **404**: Indicates the requested case instance was not found.

## POST /cmmn-runtime/case-instances/{caseInstanceId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}` | Get a specific involved people from case instance | caseInstanceId (path,required), identityId (path,required), type (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

#### Responses
- **200**: Indicates the case instance was found and the specified link is retrieved.
```json
{
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
}
```
- **404**: Indicates the requested case instance was not found or the link to delete does not exist. The response status contains additional information about the error.

## GET /cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}` | Remove an involved user to from case instance | caseInstanceId (path,required), identityId (path,required), type (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

#### Responses
- **204**: Indicates the case instance was found and the link has been deleted. Response body is left empty intentionally.
- **404**: Indicates the requested case instance was not found or the link to delete does not exist. The response status contains additional information about the error.

## DELETE /cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/migrate` | Migrate case instance | caseInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | string |  |  |

#### Responses
- **200**: Indicates the case instance was found and migration was executed.
- **404**: Indicates the requested case instance was not found.
- **409**: Indicates the requested case instance action cannot be executed since the case-instance is already activated/suspended.

## POST /cmmn-runtime/case-instances/{caseInstanceId}/migrate

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/stage-overview` |  | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **200**: successful operation
```json
[ {
  "id" : "string",
  "name" : "string",
  "ended" : false,
  "endTime" : "1970-01-01T00:00:00Z",
  "current" : false
} ]
```

## GET /cmmn-runtime/case-instances/{caseInstanceId}/stage-overview

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | List variables for a case instance | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the case instance was found and variables are returned.
```json
[ {
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
} ]
```
- **400**: Indicates the requested case instance was not found.

## GET /cmmn-runtime/case-instances/{caseInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Create variables or new binary variable on a case instance | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableCollectionResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **200**: successful operation
```json
{ }
```
- **201**: Indicates the case instance was found and variable is created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the requested case instance was not found.
- **409**: Indicates the case instance was found but already contains a variable with the given name (only thrown when POST method is used). Use the update-method instead.

## POST /cmmn-runtime/case-instances/{caseInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Update a multiple/single (non)binary variable on a case instance | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableCollectionResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **200**: successful operation
```json
{ }
```
- **201**: Indicates the case instance was found and variable is created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the requested case instance was not found.
- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.

## PUT /cmmn-runtime/case-instances/{caseInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Delete all variables | caseInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |

#### Responses
- **204**: Indicates variables were found and have been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested case instance was not found.

## DELETE /cmmn-runtime/case-instances/{caseInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async` | Create variables or new binary variable on a case instance asynchronously | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableCollectionResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **201**: Indicates the job to create the variables has been created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **409**: Indicates the case instance contains a variable with the given name (only thrown when POST method is used). Use the update-method instead.

## POST /cmmn-runtime/case-instances/{caseInstanceId}/variables-async

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async` | Update a multiple/single (non)binary variable on a case instance asynchronously | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableCollectionResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **201**: Indicates the job to update the variables has been created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **415**: Indicates the serializable data contains an object for which no class is present in the JVM running the Flowable engine and therefore cannot be deserialized.

## PUT /cmmn-runtime/case-instances/{caseInstanceId}/variables-async

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async/{variableName}` | Update a single variable on a case instance asynchronously | caseInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableResource | Create a variable on a case instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |

#### Responses
- **201**: Indicates the job to update the variable has been created.
- **404**: Indicates the case instance does not have a variable with the given name. Status description contains additional information about the error.

## PUT /cmmn-runtime/case-instances/{caseInstanceId}/variables-async/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Get a variable for a case instance | caseInstanceId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates both the case instance and variable were found and variable is returned.
```json
{
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
}
```
- **404**: Indicates the requested case instance was not found or the case instance does not have a variable with the given name. Status description contains additional information about the error.

## GET /cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Update a single variable on a case instance | caseInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/CaseInstanceVariableResource | Create a variable on a case instance |  |
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
- **201**: Indicates both the case instance and variable were found and variable is updated.
- **404**: Indicates the requested case instance was not found or the case instance does not have a variable with the given name. Status description contains additional information about the error.

## PUT /cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Delete a variable | caseInstanceId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **204**: Indicates the variable was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested variable was not found.

## DELETE /cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | caseInstanceId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| caseInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates the case instance was found and the requested variables are returned.
```json
[ "string" ]
```
- **404**: Indicates the requested case was not found or the case does not have a variable with the given name (in the given scope). Status message provides additional information.

## GET /cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/event-subscriptions` | List of event subscriptions | id (query), eventType (query), eventName (query), activityId (query), caseInstanceId (query), withoutScopeId (query), caseDefinitionId (query), withoutScopeDefinitionId (query), planItemInstanceId (query), createdBefore (query), createdAfter (query), tenantId (query), withoutTenantId (query), configuration (query), withoutConfiguration (query), withoutProcessInstanceId (query), withoutProcessDefinitionId (query), sort (query), order (query), start (query), size (query) |

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
    "caseInstanceId" : "string",
    "caseInstanceUrl" : "string",
    "caseDefinitionId" : "string",
    "caseDefinitionUrl" : "string",
    "planItemInstanceId" : "string",
    "planItemInstanceUrl" : "string",
    "executionId" : "string",
    "processInstanceId" : "string",
    "processDefinitionId" : "string",
    "scopeDefinitionId" : "string",
    "scopeId" : "string",
    "subScopeId" : "string",
    "scopeType" : "string",
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

## GET /cmmn-runtime/event-subscriptions

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/event-subscriptions/{eventSubscriptionId}` | Get a single event subscription | eventSubscriptionId (path,required) |

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
  "caseInstanceId" : "string",
  "caseInstanceUrl" : "string",
  "caseDefinitionId" : "string",
  "caseDefinitionUrl" : "string",
  "planItemInstanceId" : "string",
  "planItemInstanceUrl" : "string",
  "executionId" : "string",
  "processInstanceId" : "string",
  "processDefinitionId" : "string",
  "scopeDefinitionId" : "string",
  "scopeId" : "string",
  "subScopeId" : "string",
  "scopeType" : "string",
  "created" : "1970-01-01T00:00:00Z",
  "configuration" : "string",
  "tenantId" : "string"
}
```
- **404**: Indicates the requested event subscription does not exist.

## GET /cmmn-runtime/event-subscriptions/{eventSubscriptionId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/plan-item-instances` | List of plan item instances | id (query), caseDefinitionId (query), caseInstanceId (query), stageInstanceId (query), planItemDefinitionId (query), planItemDefinitionType (query), planItemDefinitionTypes (query), state (query), name (query), elementId (query), referenceId (query), referenceType (query), createdBefore (query), createdAfter (query), startUserId (query), includeEnded (query), includeLocalVariables (query), tenantId (query), withoutTenantId (query), sort (query) |

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

#### Responses
- **200**: Indicates request was successful and the executions are returned
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
- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.

## GET /cmmn-runtime/plan-item-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}` | Get an plan item instance | planItemInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the plan item instance was found and returned.
```json
{
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
}
```
- **404**: Indicates the plan item instance was not found.

## GET /cmmn-runtime/plan-item-instances/{planItemInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}` | Execute an action on a plan item instance | planItemInstanceId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/RestActionRequest |  |  |

#### Responses
- **200**: Indicates the plan item instance was found and the action is performed.
```json
{
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
}
```
- **204**: Indicates the plan item instance was found, the action was performed and the action caused the plan item instance to end.
- **400**: Indicates an illegal action was requested, required parameters are missing in the request body or illegal variables are passed in. Status description contains additional information about the error.
- **404**: Indicates the plan item instance was not found.

## PUT /cmmn-runtime/plan-item-instances/{planItemInstanceId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables` | Create a variable on a plan item | planItemInstanceId (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/PlanItemInstanceVariableCollectionResource | Create a variable on a plan item instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

#### Responses
- **200**: successful operation
```json
{ }
```
- **201**: Indicates both the plan item instance and variable were found and variable is created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the requested plan item instance was not found or the plan item instance does not have a variable with the given name. Status description contains additional information about the error.
- **409**: Indicates the plan item instance was found but already contains a variable with the given name. Use the update-method instead.

## POST /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async` | Create a variable on a plan item asynchronously | planItemInstanceId (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| body | body |  | #/definitions/PlanItemInstanceVariableCollectionResource | Create a variable on a plan item instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

#### Responses
- **201**: Indicates the job to create a variable is created.
- **400**: Indicates the request body is incomplete or contains illegal values. The status description contains additional information about the error.
- **404**: Indicates the plan item instance does not have a variable with the given name. Status description contains additional information about the error.
- **409**: Indicates the plan item instance already contains a variable with the given name. Use the update-method instead.

## POST /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async/{variableName}` | Update a variable on a plan item asynchronously | planItemInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/PlanItemInstanceVariableResource | Update a variable on a plan item instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

#### Responses
- **200**: Indicates the job to update a variable is created.
- **404**: Indicates the plan item instance does not have a variable with the given name. Status description contains additional information about the error.

## PUT /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}` | Update a variable on a plan item | planItemInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| body | body |  | #/definitions/PlanItemInstanceVariableResource | Update a variable on a plan item instance |  |
| file | formData |  |  |  |  |
| name | formData |  |  |  |  |
| type | formData |  |  |  |  |
| scope | formData |  |  |  |  |

#### Responses
- **200**: Indicates both the plan item instance and variable were found and variable is updated.
```json
{
  "name" : "myVariable",
  "type" : "string",
  "value" : "test",
  "valueUrl" : "http://....",
  "scope" : "string"
}
```
- **404**: Indicates the requested plan item instance was not found or the plan item instance does not have a variable with the given name. Status description contains additional information about the error.

## PUT /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}` | Delete a variable for a plan item instance | planItemInstanceId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **204**: Indicates both the plan item and variable were found and variable has been deleted.
- **404**: Indicates the requested plan item was not found or the plan item does not have a variable with the given name in the requested scope. Status description contains additional information about the error.

## DELETE /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | planItemInstanceId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| planItemInstanceId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  |  |  |

#### Responses
- **200**: Indicates the plan item instance was found and the requested variables are returned.
```json
[ "string" ]
```
- **404**: Indicates the requested plan item was not found or the plan item does not have a variable with the given name (in the given scope). Status message provides additional information.

## GET /cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks` | List of tasks | taskId (query), name (query), nameLike (query), nameLikeIgnoreCase (query), description (query), priority (query), minimumPriority (query), maximumPriority (query), assignee (query), assigneeLike (query), owner (query), ownerLike (query), unassigned (query), delegationState (query), candidateUser (query), candidateGroup (query), candidateGroups (query), involvedUser (query), taskDefinitionKey (query), taskDefinitionKeyLike (query), caseInstanceId (query), caseInstanceIdWithChildren (query), caseDefinitionId (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), planItemInstanceId (query), propagatedStageInstanceId (query), scopeId (query), withoutScopeId (query), subScopeId (query), scopeType (query), createdOn (query), createdBefore (query), createdAfter (query), dueOn (query), dueBefore (query), dueAfter (query), withoutDueDate (query), excludeSubTasks (query), active (query), includeTaskLocalVariables (query), includeProcessVariables (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), withoutProcessInstanceId (query), candidateOrAssigned (query), category (query), categoryIn (query), categoryNotIn (query), withoutCategory (query), rootScopeId (query), parentScopeId (query) |

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

#### Responses
- **200**: Indicates request was successful and the tasks are returned
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
- **404**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.

## GET /cmmn-runtime/tasks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/tasks` | Create Task | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/TaskRequest |  |  |

#### Responses
- **201**: Indicates request was successful and the tasks are returned
```json
{
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
}
```
- **400**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.

## POST /cmmn-runtime/tasks

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/tasks` | Update Tasks | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/BulkTasksRequest |  |  |

#### Responses
- **200**: successful operation
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
- **201**: Indicates request was successful and the tasks are returned
- **400**: Indicates a parameter was passed in the wrong format or that delegationState has an invalid value (other than pending and resolved). The status-message contains additional information.

## PUT /cmmn-runtime/tasks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}` | Get a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the task was found and returned.
```json
{
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
}
```
- **404**: Indicates the requested task was not found.

## GET /cmmn-runtime/tasks/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/tasks/{taskId}` | Tasks actions | taskId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskActionRequest |  |  |

#### Responses
- **200**: Indicates the action was executed.
- **400**: When the body contains an invalid value or when the assignee is missing when the action requires it.
- **404**: Indicates the requested task was not found.
- **409**: Indicates the action cannot be performed due to a conflict. Either the task was updates simultaneously or the task was claimed by another user, in case of the claim action.

## POST /cmmn-runtime/tasks/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/tasks/{taskId}` | Update a task | taskId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| body | body |  | #/definitions/TaskRequest |  |  |

#### Responses
- **200**: Indicates the task was updated.
```json
{
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
}
```
- **404**: Indicates the requested task was not found.
- **409**: Indicates the requested task was updated simultaneously.

## PUT /cmmn-runtime/tasks/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/tasks/{taskId}` | Delete a task | taskId (path,required), cascadeHistory (query), deleteReason (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| cascadeHistory | query |  |  | Whether or not to delete the HistoricTask instance when deleting the task (if applicable). If not provided, this value defaults to false. |  |
| deleteReason | query |  |  | Reason why the task is deleted. This value is ignored when cascadeHistory is true. |  |

#### Responses
- **204**: Indicates the task was found and has been deleted. Response-body is intentionally empty.
- **403**: Indicates the requested task cannot be deleted because it’s part of a workflow.
- **404**: Indicates the requested task was not found.

## DELETE /cmmn-runtime/tasks/{taskId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}/form` | Get a task form | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the task form is returned
```json
"string"
```
- **404**: Indicates the requested task was not found.

## GET /cmmn-runtime/tasks/{taskId}/form

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks` | List identity links for a task | taskId (path,required) |

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

## GET /cmmn-runtime/tasks/{taskId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/tasks/{taskId}/identitylinks` | Create an identity link on a task | taskId (path,required), body (body) |

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

## POST /cmmn-runtime/tasks/{taskId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}` | List identity links for a task for either groups or users | taskId (path,required), family (path,required) |

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

## GET /cmmn-runtime/tasks/{taskId}/identitylinks/{family}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Get a single identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |

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

## GET /cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Delete an identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |
| type | path | yes |  |  |  |

#### Responses
- **204**: Indicates the task and identity link were found and the link has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested task was not found or the task does not have the requested identityLink. The status contains additional information about this error.

## DELETE /cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}/subtasks` | List of sub tasks for a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the  sub tasks are returned
```json
[ {
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
} ]
```
- **404**: Indicates the requested task was not found.

## GET /cmmn-runtime/tasks/{taskId}/subtasks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}/variables` | List variables for a task | taskId (path,required), scope (query) |

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

## GET /cmmn-runtime/tasks/{taskId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/cmmn-runtime/tasks/{taskId}/variables` | Create new variables on a task | taskId (path,required), body (body), name (formData), type (formData), scope (formData) |

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

## POST /cmmn-runtime/tasks/{taskId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/tasks/{taskId}/variables` | Delete all local variables on a task | taskId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |

#### Responses
- **204**: Indicates all local task variables have been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested task was not found.

## DELETE /cmmn-runtime/tasks/{taskId}/variables

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Get a variable from a task | taskId (path,required), variableName (path,required), scope (query) |

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

## GET /cmmn-runtime/tasks/{taskId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Update an existing variable on a task | taskId (path,required), variableName (path,required), body (body), name (formData), type (formData), scope (formData) |

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

## PUT /cmmn-runtime/tasks/{taskId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Delete a variable on a task | taskId (path,required), variableName (path,required), scope (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| taskId | path | yes |  |  |  |
| variableName | path | yes |  |  |  |
| scope | query |  |  | Scope of variable to be returned. When local, only task-local variable value is returned. When global, only variable value from the task’s parent execution-hierarchy are returned. When the parameter is omitted, a local variable will be returned if it exists, otherwise a global variable. |  |

#### Responses
- **204**: Indicates the task variable was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested task was not found or the task does not have a variable with the given name. Status message contains additional information about the error.

## DELETE /cmmn-runtime/tasks/{taskId}/variables/{variableName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}/data` | Get the binary data for a variable | taskId (path,required), variableName (path,required), scope (query) |

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

## GET /cmmn-runtime/tasks/{taskId}/variables/{variableName}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/variable-instances` | List of variable instances | caseInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates that variable instances could be queried.
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

## GET /cmmn-runtime/variable-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/cmmn-runtime/variable-instances/{varInstanceId}/data` | Get the binary data for a variable instance | varInstanceId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| varInstanceId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the variable instance was found and the requested variable data is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested variable instance was not found or the variable instance does not have a variable with the given name or the variable does not have a binary stream available. Status message provides additional information.
