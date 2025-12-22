# flowable-swagger-decision

> Generated subset extracted from server_fetch/flowable-swagger-decision.json

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/dmn-history/historic-decision-executions` | List of historic decision executions | id (query), decisionDefinitionId (query), deploymentId (query), decisionKey (query), activityId (query), executionId (query), instanceId (query), scopeType (query), withoutScopeType (query), processInstanceIdWithChildren (query), caseInstanceIdWithChildren (query), failed (query), tenantId (query), tenantIdLike (query), sort (query), order (query), start (query), size (query) |

### GET /dmn-history/historic-decision-executions

List of historic decision executions

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return historic decision executions with the given id. |  |
| decisionDefinitionId | query |  |  | Only return historic decision executions with the given definition id. |  |
| deploymentId | query |  |  | Only return historic decision executions with the given deployment id. |  |
| decisionKey | query |  |  | Only return historic decision executions with the given decision key. |  |
| activityId | query |  |  | Only return historic decision executions with the given activity id. |  |
| executionId | query |  |  | Only return historic decision executions with the given execution id. |  |
| instanceId | query |  |  | Only return historic decision executions with the given instance id. |  |
| scopeType | query |  |  | Only return historic decision executions with the given scope type. |  |
| withoutScopeType | query |  |  | Only return historic decision executions without a scope type. |  |
| processInstanceIdWithChildren | query |  |  | Return all historic decision executions with the given process instance id or its entity link children. |  |
| caseInstanceIdWithChildren | query |  |  | Return all historic decision executions with the given case instance id or its entity link children. |  |
| failed | query |  |  | Only return historic decision executions with the failed state. |  |
| tenantId | query |  |  | Only return historic decision executions with the given tenant id. |  |
| tenantIdLike | query |  |  | Only return historic decision executions like the given tenant id. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the historic decision executions are returned

```json
{
  "$ref": "#/definitions/DataResponseHistoricDecisionExecutionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format. The status-message contains additional information.
| GET | `/dmn-history/historic-decision-executions/{historicDecisionExecutionId}` | Get a historic decision execution | historicDecisionExecutionId (path,required) |

### GET /dmn-history/historic-decision-executions/{historicDecisionExecutionId}

Get a historic decision execution

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| historicDecisionExecutionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the historic decision execution is returned

```json
{
  "$ref": "#/definitions/HistoricDecisionExecutionResponse"
}
```

- **404**: Indicates the requested historic decision execution was not found.
| GET | `/dmn-history/historic-decision-executions/{historicDecisionExecutionId}/auditdata` | Get a historic decision execution audit content | historicDecisionExecutionId (path,required) |

### GET /dmn-history/historic-decision-executions/{historicDecisionExecutionId}/auditdata

Get a historic decision execution audit content

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| historicDecisionExecutionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the historic decision execution has been found and the audit data has been returned.

```json
{
  "type": "string"
}
```

- **404**: Indicates the requested historic decision execution was not found. The status-description contains additional information.
| GET | `/dmn-management/engine` | Get DMN engine info |  |

### GET /dmn-management/engine

Returns a read-only view of the DMN engine that is used in this REST-service.

**Responses**

- **200**: Indicates the engine info is returned.

```json
{
  "$ref": "#/definitions/EngineInfoResponse"
}
```
| GET | `/dmn-repository/decision-tables` | List of decision tables | category (query), categoryLike (query), categoryNotEquals (query), key (query), keyLike (query), name (query), nameLike (query), resourceName (query), resourceNameLike (query), version (query), latest (query), deploymentId (query), tenantId (query), sort (query), order (query), start (query), size (query) |

### GET /dmn-repository/decision-tables

List of decision tables

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| category | query |  |  | Only return decision tables with the given category. |  |
| categoryLike | query |  |  | Only return decision tables with a category like the given name. |  |
| categoryNotEquals | query |  |  | Only return decision tables which do not have the given category. |  |
| key | query |  |  | Only return decision tables with the given key. |  |
| keyLike | query |  |  | Only return decision tables with a name like the given key. |  |
| name | query |  |  | Only return decision tables with the given name. |  |
| nameLike | query |  |  | Only return decision tables with a name like the given name. |  |
| resourceName | query |  |  | Only return decision tables with the given resource name. |  |
| resourceNameLike | query |  |  | Only return decision tables with a name like the given resource name. |  |
| version | query |  |  | Only return decision tables with the given version. |  |
| latest | query |  |  | Only return the latest decision tables versions. Can only be used together with key and keyLike parameters, using any other parameter will result in a 400-response. |  |
| deploymentId | query |  |  | Only return decision tables with the given category. |  |
| tenantId | query |  |  | Only return decision tables with the given tenant ID. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the process-definitions are returned

```json
{
  "$ref": "#/definitions/DataResponseDecisionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format or that latest is used with other parameters other than key and keyLike. The status-message contains additional information.
| GET | `/dmn-repository/decision-tables/{decisionTableId}` | Get a decision table | decisionTableId (path,required) |

### GET /dmn-repository/decision-tables/{decisionTableId}

Get a decision table

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| decisionTableId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the decision table is returned

```json
{
  "$ref": "#/definitions/DecisionResponse"
}
```

- **404**: Indicates the requested decision table was not found.
| GET | `/dmn-repository/decision-tables/{decisionTableId}/model` | Get a decision table DMN (definition) model | decisionTableId (path,required) |

### GET /dmn-repository/decision-tables/{decisionTableId}/model

Get a decision table DMN (definition) model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| decisionTableId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the decision table was found and the model is returned.

```json
{
  "$ref": "#/definitions/DmnDefinition"
}
```

- **404**: Indicates the requested decision table was not found.
| GET | `/dmn-repository/decision-tables/{decisionTableId}/resourcedata` | Get a decision table resource content | decisionTableId (path,required) |

### GET /dmn-repository/decision-tables/{decisionTableId}/resourcedata

Get a decision table resource content

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| decisionTableId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both decision table and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested decision table was not found or there is no resource with the given id present in the decision table. The status-description contains additional information.
| GET | `/dmn-repository/decisions` | List of decision | category (query), categoryLike (query), categoryNotEquals (query), key (query), keyLike (query), name (query), nameLike (query), resourceName (query), resourceNameLike (query), version (query), latest (query), deploymentId (query), parentDeploymentId (query), tenantId (query), decisionType (query), decisionTypeLike (query), sort (query), order (query), start (query), size (query) |

### GET /dmn-repository/decisions

List of decision

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| category | query |  |  | Only return decision with the given category. |  |
| categoryLike | query |  |  | Only return decision with a category like the given name. |  |
| categoryNotEquals | query |  |  | Only return decision which do not have the given category. |  |
| key | query |  |  | Only return decision with the given key. |  |
| keyLike | query |  |  | Only return decision with a name like the given key. |  |
| name | query |  |  | Only return decision with the given name. |  |
| nameLike | query |  |  | Only return decision with a name like the given name. |  |
| resourceName | query |  |  | Only return decision with the given resource name. |  |
| resourceNameLike | query |  |  | Only return decision with a name like the given resource name. |  |
| version | query |  |  | Only return decision with the given version. |  |
| latest | query |  |  | Only return the latest decision versions. Can only be used together with key and keyLike parameters, using any other parameter will result in a 400-response. |  |
| deploymentId | query |  |  | Only return decisions which are part of a deployment with the given deployment id. |  |
| parentDeploymentId | query |  |  | Only return decisions which are part of a deployment with the given parent deployment id. |  |
| tenantId | query |  |  | Only return decision with the given tenant ID. |  |
| decisionType | query |  |  | Only return decision with the given type. |  |
| decisionTypeLike | query |  |  | Only return decision like the given type. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the process-definitions are returned

```json
{
  "$ref": "#/definitions/DataResponseDecisionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format or that latest is used with other parameters other than key and keyLike. The status-message contains additional information.
| GET | `/dmn-repository/decisions/{decisionId}` | Get a decision | decisionId (path,required) |

### GET /dmn-repository/decisions/{decisionId}

Get a decision

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| decisionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the decision is returned

```json
{
  "$ref": "#/definitions/DecisionResponse"
}
```

- **404**: Indicates the requested decision was not found.
| GET | `/dmn-repository/decisions/{decisionId}/image` | Get a decision requirements diagram image | decisionId (path,required) |

### GET /dmn-repository/decisions/{decisionId}/image

Get a decision requirements diagram image

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| decisionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the decision requirements diagram image returned

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested decision requirements diagram image was not found.
| GET | `/dmn-repository/decisions/{decisionId}/model` | Get a decision DMN (definition) model | decisionId (path,required) |

### GET /dmn-repository/decisions/{decisionId}/model

Get a decision DMN (definition) model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| decisionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the decision was found and the model is returned.

```json
{
  "$ref": "#/definitions/DmnDefinition"
}
```

- **404**: Indicates the requested decision was not found.
| GET | `/dmn-repository/decisions/{decisionId}/resourcedata` | Get a decision resource content | decisionId (path,required) |

### GET /dmn-repository/decisions/{decisionId}/resourcedata

Get a decision resource content

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| decisionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both decision and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested decision was not found or there is no resource with the given id present in the decision . The status-description contains additional information.
| GET | `/dmn-repository/deployments` | List of decision deployments | name (query), nameLike (query), category (query), categoryNotEquals (query), parentDeploymentId (query), parentDeploymentIdLike (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

### GET /dmn-repository/deployments

List of decision deployments

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| name | query |  |  | Only return decision deployments with the given name. |  |
| nameLike | query |  |  | Only return decision deployments with a name like the given name. |  |
| category | query |  |  | Only return decision deployments with the given category. |  |
| categoryNotEquals | query |  |  | Only return decision deployments which do not have the given category. |  |
| parentDeploymentId | query |  |  | Only return decision deployments with the given parent deployment id. |  |
| parentDeploymentIdLike | query |  |  | Only return decision deployments with a parent deployment id like the given value. |  |
| tenantId | query |  |  | Only return decision deployments with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return decision deployments with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns decision deployments without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates the request was successful.

```json
{
  "$ref": "#/definitions/DataResponseDmnDeploymentResponse"
}
```
| POST | `/dmn-repository/deployments` | Create a new decision deployment | tenantId (query), file (formData) |

### POST /dmn-repository/deployments

The request body should contain data of type multipart/form-data. There should be exactly one file in the request, any additional files will be ignored. The deployment name is the name of the file-field passed in. If multiple resources need to be deployed in a single deployment, compress the resources in a zip and make sure the file-name ends with .bar or .zip.

An additional parameter (form-field) can be passed in the request body with name tenantId. The value of this field will be used as the id of the tenant this deployment is done in.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| tenantId | query |  |  |  |  |
| file | formData |  |  |  |  |

**Responses**

- **201**: Indicates the deployment was created.

```json
{
  "$ref": "#/definitions/DmnDeploymentResponse"
}
```

- **400**: Indicates there was no content present in the request body or the content mime-type is not supported for deployment. The status-description contains additional information.
| GET | `/dmn-repository/deployments/{deploymentId}` | Get a decision deployment | deploymentId (path,required) |

### GET /dmn-repository/deployments/{deploymentId}

Get a decision deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the deployment was found and returned.

```json
{
  "$ref": "#/definitions/DmnDeploymentResponse"
}
```

- **404**: Indicates the requested deployment was not found.
| DELETE | `/dmn-repository/deployments/{deploymentId}` | Delete a decision deployment | deploymentId (path,required) |

### DELETE /dmn-repository/deployments/{deploymentId}

Delete a decision deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the deployment was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested deployment was not found.
| GET | `/dmn-repository/deployments/{deploymentId}/resourcedata/{resourceName}` | Get a decision deployment resource content | deploymentId (path,required), resourceName (path,required) |

### GET /dmn-repository/deployments/{deploymentId}/resourcedata/{resourceName}

The response body will contain the binary resource-content for the requested resource. The response content-type will be the same as the type returned in the resources mimeType property. Also, a content-disposition header is set, allowing browsers to download the file instead of displaying it.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |
| resourceName | path | yes |  |  |  |

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
| POST | `/dmn-rule/execute` | Execute a Decision | body (body) |

### POST /dmn-rule/execute

Execute a Decision

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/DmnRuleServiceRequest | request |  |

**Request**

```json
{
  "$ref": "#/definitions/DmnRuleServiceRequest"
}
```

**Responses**

- **201**: Indicates the Decision has been executed

```json
{
  "$ref": "#/definitions/DmnRuleServiceResponse"
}
```
| POST | `/dmn-rule/execute-decision` | Execute a decision | body (body) |

### POST /dmn-rule/execute-decision

Execute a decision

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/DmnRuleServiceRequest | request |  |

**Request**

```json
{
  "$ref": "#/definitions/DmnRuleServiceRequest"
}
```

**Responses**

- **201**: Indicates the decision has been executed

```json
{
  "$ref": "#/definitions/DmnRuleServiceResponse"
}
```
| POST | `/dmn-rule/execute-decision-service` | Execute a decision service | body (body) |

### POST /dmn-rule/execute-decision-service

Execute a decision service

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/DmnRuleServiceRequest | request |  |

**Request**

```json
{
  "$ref": "#/definitions/DmnRuleServiceRequest"
}
```

**Responses**

- **201**: Indicates the decision service has been executed

```json
{
  "$ref": "#/definitions/DmnRuleServiceResponse"
}
```
| POST | `/dmn-rule/execute-decision-service/single-result` | Execute a decision service expecting a single result | body (body) |

### POST /dmn-rule/execute-decision-service/single-result

Execute a decision service expecting a single result

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/DmnRuleServiceRequest | request |  |

**Request**

```json
{
  "$ref": "#/definitions/DmnRuleServiceRequest"
}
```

**Responses**

- **201**: Indicates the decision service has been executed

```json
{
  "$ref": "#/definitions/DmnRuleServiceSingleResponse"
}
```

- **500**: Indicates the decision service returned multiple results
| POST | `/dmn-rule/execute-decision/single-result` | Execute a decision expecting a single result | body (body) |

### POST /dmn-rule/execute-decision/single-result

Execute a decision expecting a single result

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/DmnRuleServiceRequest | request |  |

**Request**

```json
{
  "$ref": "#/definitions/DmnRuleServiceRequest"
}
```

**Responses**

- **201**: Indicates the decision or decision service has been executed

```json
{
  "$ref": "#/definitions/DmnRuleServiceSingleResponse"
}
```

- **500**: Indicates the decision returned multiple results
| POST | `/dmn-rule/execute/single-result` | Execute a decision or a decision service expecting a single result | body (body) |

### POST /dmn-rule/execute/single-result

Execute a decision or a decision service expecting a single result

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/DmnRuleServiceRequest | request |  |

**Request**

```json
{
  "$ref": "#/definitions/DmnRuleServiceRequest"
}
```

**Responses**

- **201**: Indicates the decision or decision service has been executed

```json
{
  "$ref": "#/definitions/DmnRuleServiceSingleResponse"
}
```

- **500**: Indicates the decision or decision service returned multiple results
