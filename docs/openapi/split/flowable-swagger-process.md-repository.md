# flowable-swagger-process.md — repository (repository)

> Generated subset extracted from flowable-swagger-process.md

## POST /query/variable-instances

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/deployments` | List Deployments | name (query), nameLike (query), category (query), categoryNotEquals (query), parentDeploymentId (query), parentDeploymentIdLike (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates the request was successful.
```json
{
  "data" : [ {
    "id" : "10",
    "name" : "flowable-examples.bar",
    "deploymentTime" : "2010-10-13T14:54:26.750+02:00",
    "category" : "examples",
    "parentDeploymentId" : "12",
    "url" : "http://localhost:8081/flowable-rest/service/repository/deployments/10",
    "tenantId" : "string"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```

## GET /repository/deployments

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/repository/deployments` | Create a new deployment | deploymentKey (query), deploymentName (query), tenantId (query), file (formData,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentKey | query |  |  |  |  |
| deploymentName | query |  |  |  |  |
| tenantId | query |  |  |  |  |
| file | formData | yes |  |  |  |

#### Responses
- **201**: Indicates the deployment was created.
```json
{
  "id" : "10",
  "name" : "flowable-examples.bar",
  "deploymentTime" : "2010-10-13T14:54:26.750+02:00",
  "category" : "examples",
  "parentDeploymentId" : "12",
  "url" : "http://localhost:8081/flowable-rest/service/repository/deployments/10",
  "tenantId" : "string"
}
```
- **400**: Indicates there was no content present in the request body or the content mime-type is not supported for deployment. The status-description contains additional information.

## POST /repository/deployments

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/deployments/{deploymentId}` | Get a deployment | deploymentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  | The id of the deployment to get. |  |

#### Responses
- **200**: Indicates the deployment was found and returned.
```json
{
  "id" : "10",
  "name" : "flowable-examples.bar",
  "deploymentTime" : "2010-10-13T14:54:26.750+02:00",
  "category" : "examples",
  "parentDeploymentId" : "12",
  "url" : "http://localhost:8081/flowable-rest/service/repository/deployments/10",
  "tenantId" : "string"
}
```
- **404**: Indicates the requested deployment was not found.

## GET /repository/deployments/{deploymentId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/repository/deployments/{deploymentId}` | Delete a deployment | deploymentId (path,required), cascade (query) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |
| cascade | query |  |  |  |  |

#### Responses
- **204**: Indicates the deployment was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested deployment was not found.

## DELETE /repository/deployments/{deploymentId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/deployments/{deploymentId}/resourcedata/{resourceName}` | Get a deployment resource content | deploymentId (path,required), resourceName (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |
| resourceName | path | yes |  | The name of the resource to get. Make sure you URL-encode the resourceName in case it contains forward slashes. Eg: use diagrams%2Fmy-process.bpmn20.xml instead of diagrams/my-process.bpmn20.xml. |  |

#### Responses
- **200**: Indicates both deployment and resource have been found and the resource data has been returned.
```json
[ "string" ]
```
- **404**: Indicates the requested deployment was not found or there is no resource with the given id present in the deployment. The status-description contains additional information.

## GET /repository/deployments/{deploymentId}/resourcedata/{resourceName}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/deployments/{deploymentId}/resources` | List resources in a deployment | deploymentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the deployment was found and the resource list has been returned.
```json
[ {
  "id" : "diagrams/my-process.bpmn20.xml",
  "url" : "http://localhost:8081/flowable-rest/service/repository/deployments/10/resources/diagrams%2Fmy-process.bpmn20.xml",
  "contentUrl" : "http://localhost:8081/flowable-rest/service/repository/deployments/10/resourcedata/diagrams%2Fmy-process.bpmn20.xml",
  "mediaType" : "text/xml",
  "type" : "processDefinition"
} ]
```
- **404**: Indicates the requested deployment was not found.

## GET /repository/deployments/{deploymentId}/resources

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/deployments/{deploymentId}/resources/**` | Get a deployment resource | deploymentId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

#### Responses
- **200**: Indicates both deployment and resource have been found and the resource has been returned.
```json
{
  "id" : "diagrams/my-process.bpmn20.xml",
  "url" : "http://localhost:8081/flowable-rest/service/repository/deployments/10/resources/diagrams%2Fmy-process.bpmn20.xml",
  "contentUrl" : "http://localhost:8081/flowable-rest/service/repository/deployments/10/resourcedata/diagrams%2Fmy-process.bpmn20.xml",
  "mediaType" : "text/xml",
  "type" : "processDefinition"
}
```
- **404**: Indicates the requested deployment was not found or there is no resource with the given id present in the deployment. The status-description contains additional information.

## GET /repository/deployments/{deploymentId}/resources/**

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/models` | List models | id (query), category (query), categoryLike (query), categoryNotEquals (query), name (query), nameLike (query), key (query), deploymentId (query), version (query), latestVersion (query), deployed (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates request was successful and the models are returned
```json
{
  "data" : [ {
    "name" : "Model name",
    "key" : "Model key",
    "category" : "Model category",
    "version" : 2,
    "metaInfo" : "Model metainfo",
    "deploymentId" : "7",
    "tenantId" : "null",
    "id" : "5",
    "url" : "http://localhost:8182/repository/models/5",
    "createTime" : "2013-06-12T12:31:19.861+0000",
    "lastUpdateTime" : "2013-06-12T12:31:19.861+0000",
    "deploymentUrl" : "http://localhost:8182/repository/deployments/2",
    "sourceUrl" : "string",
    "sourceExtraUrl" : "string"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates a parameter was passed in the wrong format. The status-message contains additional information.

## GET /repository/models

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/repository/models` | Create a model | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/ModelRequest |  |  |

#### Responses
- **201**: Indicates the model was created.
```json
{
  "name" : "Model name",
  "key" : "Model key",
  "category" : "Model category",
  "version" : 2,
  "metaInfo" : "Model metainfo",
  "deploymentId" : "7",
  "tenantId" : "null",
  "id" : "5",
  "url" : "http://localhost:8182/repository/models/5",
  "createTime" : "2013-06-12T12:31:19.861+0000",
  "lastUpdateTime" : "2013-06-12T12:31:19.861+0000",
  "deploymentUrl" : "http://localhost:8182/repository/deployments/2",
  "sourceUrl" : "string",
  "sourceExtraUrl" : "string"
}
```

## POST /repository/models

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/models/{modelId}` | Get a model | modelId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the model was found and returned.
```json
{
  "name" : "Model name",
  "key" : "Model key",
  "category" : "Model category",
  "version" : 2,
  "metaInfo" : "Model metainfo",
  "deploymentId" : "7",
  "tenantId" : "null",
  "id" : "5",
  "url" : "http://localhost:8182/repository/models/5",
  "createTime" : "2013-06-12T12:31:19.861+0000",
  "lastUpdateTime" : "2013-06-12T12:31:19.861+0000",
  "deploymentUrl" : "http://localhost:8182/repository/deployments/2",
  "sourceUrl" : "string",
  "sourceExtraUrl" : "string"
}
```
- **404**: Indicates the requested model was not found.

## GET /repository/models/{modelId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/repository/models/{modelId}` | Update a model | modelId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |
| body | body |  | #/definitions/ModelRequest |  |  |

#### Responses
- **200**: Indicates the model was found and updated.
```json
{
  "name" : "Model name",
  "key" : "Model key",
  "category" : "Model category",
  "version" : 2,
  "metaInfo" : "Model metainfo",
  "deploymentId" : "7",
  "tenantId" : "null",
  "id" : "5",
  "url" : "http://localhost:8182/repository/models/5",
  "createTime" : "2013-06-12T12:31:19.861+0000",
  "lastUpdateTime" : "2013-06-12T12:31:19.861+0000",
  "deploymentUrl" : "http://localhost:8182/repository/deployments/2",
  "sourceUrl" : "string",
  "sourceExtraUrl" : "string"
}
```
- **404**: Indicates the requested model was not found.

## PUT /repository/models/{modelId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/repository/models/{modelId}` | Delete a model | modelId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the model was found and has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested model was not found.

## DELETE /repository/models/{modelId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/models/{modelId}/source` | Get the editor source for a model | modelId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the model was found and source is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested model was not found.

## GET /repository/models/{modelId}/source

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/repository/models/{modelId}/source` | Set the editor source for a model | modelId (path,required), file (formData,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |
| file | formData | yes |  |  |  |

#### Responses
- **204**: Indicates the model was found and the source has been updated.
- **404**: Indicates the requested model was not found.

## PUT /repository/models/{modelId}/source

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/models/{modelId}/source-extra` | Get the extra editor source for a model | modelId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the model was found and source is returned.
```json
[ "string" ]
```
- **404**: Indicates the requested model was not found.

## GET /repository/models/{modelId}/source-extra

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/repository/models/{modelId}/source-extra` | Set the extra editor source for a model | modelId (path,required), file (formData,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| modelId | path | yes |  |  |  |
| file | formData | yes |  |  |  |

#### Responses
- **204**: Indicates the model was found and the extra source has been updated.
- **404**: Indicates the requested model was not found.

## PUT /repository/models/{modelId}/source-extra

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions` | List of process definitions | version (query), name (query), nameLike (query), nameLikeIgnoreCase (query), key (query), keyLike (query), resourceName (query), resourceNameLike (query), category (query), categoryLike (query), categoryNotEquals (query), deploymentId (query), parentDeploymentId (query), startableByUser (query), latest (query), suspended (query), sort (query), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates request was successful and the process-definitions are returned
```json
{
  "data" : [ {
    "id" : "oneTaskProcess:1:4",
    "url" : "http://localhost:8182/repository/process-definitions/oneTaskProcess%3A1%3A4",
    "key" : "oneTaskProcess",
    "version" : 1,
    "name" : "The One Task Process",
    "description" : "This is a process for testing purposes",
    "tenantId" : "null",
    "deploymentId" : "2",
    "deploymentUrl" : "http://localhost:8081/repository/deployments/2",
    "resource" : "http://localhost:8182/repository/deployments/2/resources/testProcess.xml",
    "diagramResource" : "http://localhost:8182/repository/deployments/2/resources/testProcess.png",
    "category" : "Examples",
    "graphicalNotationDefined" : false,
    "suspended" : false,
    "startFormDefined" : false
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```
- **400**: Indicates a parameter was passed in the wrong format or that latest is used with other parameters other than key and keyLike. The status-message contains additional information.

## GET /repository/process-definitions

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}` | Get a process definition | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the process-definitions are returned
```json
{
  "id" : "oneTaskProcess:1:4",
  "url" : "http://localhost:8182/repository/process-definitions/oneTaskProcess%3A1%3A4",
  "key" : "oneTaskProcess",
  "version" : 1,
  "name" : "The One Task Process",
  "description" : "This is a process for testing purposes",
  "tenantId" : "null",
  "deploymentId" : "2",
  "deploymentUrl" : "http://localhost:8081/repository/deployments/2",
  "resource" : "http://localhost:8182/repository/deployments/2/resources/testProcess.xml",
  "diagramResource" : "http://localhost:8182/repository/deployments/2/resources/testProcess.png",
  "category" : "Examples",
  "graphicalNotationDefined" : false,
  "suspended" : false,
  "startFormDefined" : false
}
```
- **404**: Indicates the requested process definition was not found.

## GET /repository/process-definitions/{processDefinitionId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/repository/process-definitions/{processDefinitionId}` | Execute actions for a process definition | processDefinitionId (path,required), body (body,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| body | body | yes | #/definitions/ProcessDefinitionActionRequest |  |  |

#### Responses
- **200**: Indicates action has been executed for the specified process. (category altered, activate or suspend)
```json
{
  "id" : "oneTaskProcess:1:4",
  "url" : "http://localhost:8182/repository/process-definitions/oneTaskProcess%3A1%3A4",
  "key" : "oneTaskProcess",
  "version" : 1,
  "name" : "The One Task Process",
  "description" : "This is a process for testing purposes",
  "tenantId" : "null",
  "deploymentId" : "2",
  "deploymentUrl" : "http://localhost:8081/repository/deployments/2",
  "resource" : "http://localhost:8182/repository/deployments/2/resources/testProcess.xml",
  "diagramResource" : "http://localhost:8182/repository/deployments/2/resources/testProcess.png",
  "category" : "Examples",
  "graphicalNotationDefined" : false,
  "suspended" : false,
  "startFormDefined" : false
}
```
- **400**: Indicates no category was defined in the request body.
- **404**: Indicates the requested process definition was not found.
- **409**: Indicates the requested process definition is already suspended or active.

## PUT /repository/process-definitions/{processDefinitionId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/repository/process-definitions/{processDefinitionId}/batch-migrate` | Batch migrate all instances of process definition | processDefinitionId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| body | body |  | string |  |  |

#### Responses
- **200**: Indicates process instances were found and batch migration was started.
- **404**: Indicates the requested process definition was not found.

## POST /repository/process-definitions/{processDefinitionId}/batch-migrate

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/decision-tables` | List decision tables for a process-definition | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process definition was found and the decision tables are returned.
```json
[ {
  "id" : "string",
  "category" : "string",
  "name" : "string",
  "key" : "string",
  "description" : "string",
  "version" : 0,
  "resourceName" : "string",
  "deploymentId" : "string",
  "tenantId" : "string",
  "url" : "string"
} ]
```
- **404**: Indicates the requested process definition was not found.

## GET /repository/process-definitions/{processDefinitionId}/decision-tables

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/decisions` | List decisions for a process-definition | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process definition was found and the decisions are returned.
```json
[ {
  "id" : "string",
  "category" : "string",
  "name" : "string",
  "key" : "string",
  "description" : "string",
  "version" : 0,
  "resourceName" : "string",
  "deploymentId" : "string",
  "tenantId" : "string",
  "url" : "string"
} ]
```
- **404**: Indicates the requested process definition was not found.

## GET /repository/process-definitions/{processDefinitionId}/decisions

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/form-definitions` | List form definitions for a process-definition | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process definition was found and the form definitions are returned.
```json
[ {
  "id" : "string",
  "url" : "string",
  "category" : "string",
  "name" : "string",
  "key" : "string",
  "description" : "string",
  "version" : 0,
  "resourceName" : "string",
  "deploymentId" : "string",
  "tenantId" : "string"
} ]
```
- **404**: Indicates the requested process definition was not found.

## GET /repository/process-definitions/{processDefinitionId}/form-definitions

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/identitylinks` | List candidate starters for a process-definition | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process definition was found and the requested identity links are returned.
```json
[ {
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
} ]
```
- **404**: Indicates the requested process definition was not found.

## GET /repository/process-definitions/{processDefinitionId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/repository/process-definitions/{processDefinitionId}/identitylinks` | Add a candidate starter to a process definition | processDefinitionId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| body | body |  | #/definitions/RestIdentityLink |  |  |

#### Responses
- **201**: Indicates the process definition was found and the identity link was created.
```json
{
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
}
```
- **400**: Indicates the body does not contain the correct information.
- **404**: Indicates the requested process definition was not found.

## POST /repository/process-definitions/{processDefinitionId}/identitylinks

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}` | Get a candidate starter from a process definition | processDefinitionId (path,required), family (path,required), identityId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process definition was found and the identity link was returned.
```json
{
  "url" : "string",
  "user" : "kermit",
  "group" : "sales",
  "type" : "candidate"
}
```
- **404**: Indicates the requested process definition was not found or the process definition does not have an identity-link that matches the url.

## GET /repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}` | Delete a candidate starter from a process definition | processDefinitionId (path,required), family (path,required), identityId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| family | path | yes |  |  |  |
| identityId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the process definition was found and the identity link was removed. The response body is intentionally empty.
- **404**: Indicates the requested process definition was not found or the process definition does not have an identity-link that matches the url.

## DELETE /repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/image` | Get a process definition image | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the process-definitions are returned
```json
[ "string" ]
```
- **404**: Indicates the requested process definition was not found.

## GET /repository/process-definitions/{processDefinitionId}/image

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/repository/process-definitions/{processDefinitionId}/migrate` | Migrate all instances of process definition | processDefinitionId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |
| body | body |  | string |  |  |

#### Responses
- **200**: Indicates process instances were found and migration was executed.
- **404**: Indicates the requested process definition was not found.

## POST /repository/process-definitions/{processDefinitionId}/migrate

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/model` | Get a process definition BPMN model | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the process definition was found and the model is returned. The response contains the full process definition model.
```json
{
  "definitionsAttributes" : { },
  "processes" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "name" : "string",
    "executable" : false,
    "documentation" : "string",
    "ioSpecification" : {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "dataInputs" : [ {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "name" : { },
        "itemSubjectRef" : { },
        "collection" : { }
      } ],
      "dataOutputs" : [ {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "name" : { },
        "itemSubjectRef" : { },
        "collection" : { }
      } ],
      "dataInputRefs" : [ "string" ],
      "dataOutputRefs" : [ "string" ]
    },
    "executionListeners" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "event" : "string",
      "implementationType" : "string",
      "implementation" : "string",
      "fieldExtensions" : [ { } ],
      "onTransaction" : "string",
      "customPropertiesResolverImplementationType" : "string",
      "customPropertiesResolverImplementation" : "string",
      "scriptInfo" : {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "language" : { },
        "resultVariable" : { },
        "script" : { }
      }
    } ],
    "lanes" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "parentProcess" : {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "name" : { },
        "executable" : { },
        "documentation" : { },
        "ioSpecification" : { },
        "executionListeners" : { },
        "lanes" : { },
        "dataObjects" : { },
        "candidateStarterUsers" : { },
        "candidateStarterGroups" : { },
        "eventListeners" : { },
        "flowElementMap" : { },
        "artifactMap" : { },
        "initialFlowElement" : { },
        "enableEagerExecutionTreeFetching" : { },
        "artifacts" : { },
        "flowElements" : { }
      },
      "flowReferences" : [ { } ]
    } ],
    "dataObjects" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "documentation" : "string",
      "executionListeners" : [ { } ],
      "itemSubjectRef" : {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "structureRef" : { },
        "itemKind" : { }
      },
      "value" : { },
      "type" : "string"
    } ],
    "candidateStarterUsers" : [ "string" ],
    "candidateStarterGroups" : [ "string" ],
    "eventListeners" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "events" : "string",
      "implementationType" : "string",
      "implementation" : "string",
      "entityType" : "string",
      "onTransaction" : "string"
    } ],
    "flowElementMap" : { },
    "artifactMap" : { },
    "initialFlowElement" : {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "documentation" : "string",
      "executionListeners" : [ {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "event" : { },
        "implementationType" : { },
        "implementation" : { },
        "fieldExtensions" : { },
        "onTransaction" : { },
        "customPropertiesResolverImplementationType" : { },
        "customPropertiesResolverImplementation" : { },
        "scriptInfo" : { }
      } ]
    },
    "enableEagerExecutionTreeFetching" : false,
    "artifacts" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { }
    } ],
    "flowElements" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "documentation" : "string",
      "executionListeners" : [ { } ]
    } ]
  } ],
  "locationMap" : { },
  "labelLocationMap" : { },
  "flowLocationMap" : { },
  "edgeMap" : { },
  "signals" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "name" : "string",
    "scope" : "string"
  } ],
  "pools" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "name" : "string",
    "processRef" : "string",
    "executable" : false
  } ],
  "imports" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "importType" : "string",
    "location" : "string",
    "namespace" : "string"
  } ],
  "interfaces" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "name" : "string",
    "implementationRef" : "string",
    "operations" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "implementationRef" : "string",
      "inMessageRef" : "string",
      "outMessageRef" : "string",
      "errorMessageRef" : [ { } ]
    } ]
  } ],
  "globalArtifacts" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { }
  } ],
  "resources" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "name" : "string"
  } ],
  "targetNamespace" : "string",
  "sourceSystemId" : "string",
  "userTaskFormTypes" : [ "string" ],
  "startEventFormTypes" : [ "string" ],
  "exporter" : "string",
  "exporterVersion" : "string",
  "errors" : { },
  "messages" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "name" : "string",
    "itemRef" : "string"
  } ],
  "mainProcess" : {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "name" : "string",
    "executable" : false,
    "documentation" : "string",
    "ioSpecification" : {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "dataInputs" : [ {
        "id" : "string",
        "xmlRowNumber" : 0,
        "xmlColumnNumber" : 0,
        "extensionElements" : { },
        "attributes" : { },
        "name" : "string",
        "itemSubjectRef" : "string",
        "collection" : false
      } ],
      "dataOutputs" : [ {
        "id" : "string",
        "xmlRowNumber" : 0,
        "xmlColumnNumber" : 0,
        "extensionElements" : { },
        "attributes" : { },
        "name" : "string",
        "itemSubjectRef" : "string",
        "collection" : false
      } ],
      "dataInputRefs" : [ "string" ],
      "dataOutputRefs" : [ "string" ]
    },
    "executionListeners" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "event" : "string",
      "implementationType" : "string",
      "implementation" : "string",
      "fieldExtensions" : [ {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "fieldName" : { },
        "stringValue" : { },
        "expression" : { }
      } ],
      "onTransaction" : "string",
      "customPropertiesResolverImplementationType" : "string",
      "customPropertiesResolverImplementation" : "string",
      "scriptInfo" : {
        "id" : "string",
        "xmlRowNumber" : 0,
        "xmlColumnNumber" : 0,
        "extensionElements" : { },
        "attributes" : { },
        "language" : "string",
        "resultVariable" : "string",
        "script" : "string"
      }
    } ],
    "lanes" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "parentProcess" : {
        "id" : "string",
        "xmlRowNumber" : 0,
        "xmlColumnNumber" : 0,
        "extensionElements" : { },
        "attributes" : { },
        "name" : "string",
        "executable" : false,
        "documentation" : "string",
        "ioSpecification" : {
          "id" : { },
          "xmlRowNumber" : { },
          "xmlColumnNumber" : { },
          "extensionElements" : { },
          "attributes" : { },
          "dataInputs" : { },
          "dataOutputs" : { },
          "dataInputRefs" : { },
          "dataOutputRefs" : { }
        },
        "executionListeners" : [ { } ],
        "lanes" : [ { } ],
        "dataObjects" : [ { } ],
        "candidateStarterUsers" : [ { } ],
        "candidateStarterGroups" : [ { } ],
        "eventListeners" : [ { } ],
        "flowElementMap" : { },
        "artifactMap" : { },
        "initialFlowElement" : {
          "id" : { },
          "xmlRowNumber" : { },
          "xmlColumnNumber" : { },
          "extensionElements" : { },
          "attributes" : { },
          "name" : { },
          "documentation" : { },
          "executionListeners" : { }
        },
        "enableEagerExecutionTreeFetching" : false,
        "artifacts" : [ { } ],
        "flowElements" : [ { } ]
      },
      "flowReferences" : [ "string" ]
    } ],
    "dataObjects" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "documentation" : "string",
      "executionListeners" : [ {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "event" : { },
        "implementationType" : { },
        "implementation" : { },
        "fieldExtensions" : { },
        "onTransaction" : { },
        "customPropertiesResolverImplementationType" : { },
        "customPropertiesResolverImplementation" : { },
        "scriptInfo" : { }
      } ],
      "itemSubjectRef" : {
        "id" : "string",
        "xmlRowNumber" : 0,
        "xmlColumnNumber" : 0,
        "extensionElements" : { },
        "attributes" : { },
        "structureRef" : "string",
        "itemKind" : "string"
      },
      "value" : { },
      "type" : "string"
    } ],
    "candidateStarterUsers" : [ "string" ],
    "candidateStarterGroups" : [ "string" ],
    "eventListeners" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "events" : "string",
      "implementationType" : "string",
      "implementation" : "string",
      "entityType" : "string",
      "onTransaction" : "string"
    } ],
    "flowElementMap" : { },
    "artifactMap" : { },
    "initialFlowElement" : {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "documentation" : "string",
      "executionListeners" : [ {
        "id" : "string",
        "xmlRowNumber" : 0,
        "xmlColumnNumber" : 0,
        "extensionElements" : { },
        "attributes" : { },
        "event" : "string",
        "implementationType" : "string",
        "implementation" : "string",
        "fieldExtensions" : [ { } ],
        "onTransaction" : "string",
        "customPropertiesResolverImplementationType" : "string",
        "customPropertiesResolverImplementation" : "string",
        "scriptInfo" : {
          "id" : { },
          "xmlRowNumber" : { },
          "xmlColumnNumber" : { },
          "extensionElements" : { },
          "attributes" : { },
          "language" : { },
          "resultVariable" : { },
          "script" : { }
        }
      } ]
    },
    "enableEagerExecutionTreeFetching" : false,
    "artifacts" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { }
    } ],
    "flowElements" : [ {
      "id" : "string",
      "xmlRowNumber" : 0,
      "xmlColumnNumber" : 0,
      "extensionElements" : { },
      "attributes" : { },
      "name" : "string",
      "documentation" : "string",
      "executionListeners" : [ {
        "id" : { },
        "xmlRowNumber" : { },
        "xmlColumnNumber" : { },
        "extensionElements" : { },
        "attributes" : { },
        "event" : { },
        "implementationType" : { },
        "implementation" : { },
        "fieldExtensions" : { },
        "onTransaction" : { },
        "customPropertiesResolverImplementationType" : { },
        "customPropertiesResolverImplementation" : { },
        "scriptInfo" : { }
      } ]
    } ]
  },
  "messageFlows" : { },
  "escalations" : [ {
    "id" : "string",
    "xmlRowNumber" : 0,
    "xmlColumnNumber" : 0,
    "extensionElements" : { },
    "attributes" : { },
    "name" : "string",
    "escalationCode" : "string"
  } ],
  "itemDefinitions" : { },
  "dataStores" : { },
  "namespaces" : { }
}
```
- **404**: Indicates the requested process definition was not found.

## GET /repository/process-definitions/{processDefinitionId}/model

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/resourcedata` | Get a process definition resource content | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates both process definition and resource have been found and the resource data has been returned.
```json
[ "string" ]
```
- **404**: Indicates the requested process definition was not found or there is no resource with the given id present in the process definition. The status-description contains additional information.

## GET /repository/process-definitions/{processDefinitionId}/resourcedata

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/repository/process-definitions/{processDefinitionId}/start-form` | Get a process definition start form | processDefinitionId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| processDefinitionId | path | yes |  |  |  |

#### Responses
- **200**: Indicates request was successful and the process definition form is returned
```json
"string"
```
- **404**: Indicates the requested process definition was not found.
