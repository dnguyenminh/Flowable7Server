# flowable-swagger-app

> Generated subset extracted from server_fetch/flowable-swagger-app.json

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/app-management/engine` | Get app engine info |  |

### GET /app-management/engine

Returns a read-only view of the engine that is used in this REST-service.

**Responses**

- **200**: Indicates the engine info is returned.

```json
{
  "$ref": "#/definitions/EngineInfoResponse"
}
```
| GET | `/app-repository/app-definitions` | List of app definitions | category (query), categoryLike (query), categoryNotEquals (query), key (query), keyLike (query), name (query), nameLike (query), resourceName (query), resourceNameLike (query), version (query), versionGreaterThan (query), versionGreaterThanOrEquals (query), versionLowerThan (query), versionLowerThanOrEquals (query), deploymentId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), latest (query), sort (query), order (query), start (query), size (query) |

### GET /app-repository/app-definitions

List of app definitions

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| category | query |  |  | Only return app definitions with the given category. |  |
| categoryLike | query |  |  | Only return app definitions with a category like the given value. |  |
| categoryNotEquals | query |  |  | Only return app definitions not with the given category. |  |
| key | query |  |  | Only return app definitions with the given key. |  |
| keyLike | query |  |  | Only return app definitions with a key like the given value. |  |
| name | query |  |  | Only return app definitions with the given name. |  |
| nameLike | query |  |  | Only return app definitions with a name like the given value. |  |
| resourceName | query |  |  | Only return app definitions with the given resource name. |  |
| resourceNameLike | query |  |  | Only return app definitions a resource name like the given value. |  |
| version | query |  |  | Only return app definitions with the given version. |  |
| versionGreaterThan | query |  |  | Only return app definitions with a version greater than the given value. |  |
| versionGreaterThanOrEquals | query |  |  | Only return app definitions with a version greater than or equal to the given value. |  |
| versionLowerThan | query |  |  | Only return app definitions with a version lower than the given value. |  |
| versionLowerThanOrEquals | query |  |  | Only return app definitions with a version lower than or equal to the given value. |  |
| deploymentId | query |  |  | Only return app definitions with the given deployment id. |  |
| tenantId | query |  |  | Only return app definitions with the given tenant id. |  |
| tenantIdLike | query |  |  | Only return app definitions with a tenant id like the given value. |  |
| withoutTenantId | query |  |  | Only return app definitions without a tenant id. |  |
| latest | query |  |  | If true; only the latest versions will be returned. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the app definitions are returned

```json
{
  "$ref": "#/definitions/DataResponseAppDefinitionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format . The status-message contains additional information.
| GET | `/app-repository/app-definitions/{appDefinitionId}` | Get a app definition | appDefinitionId (path,required) |

### GET /app-repository/app-definitions/{appDefinitionId}

Get a app definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| appDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the app definition was found returned.

```json
{
  "$ref": "#/definitions/AppDefinitionResponse"
}
```

- **404**: Indicates the app definition was not found.
| PUT | `/app-repository/app-definitions/{appDefinitionId}` | Execute actions for an app definition | appDefinitionId (path,required), body (body,required) |

### PUT /app-repository/app-definitions/{appDefinitionId}

Execute actions for an app definition (Update category)

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| appDefinitionId | path | yes |  |  |  |
| body | body | yes | #/definitions/AppDefinitionActionRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/AppDefinitionActionRequest"
}
```

**Responses**

- **200**: Indicates action has been executed for the specified app definition. (category altered)

```json
{
  "$ref": "#/definitions/AppDefinitionResponse"
}
```

- **400**: Indicates no category was defined in the request body.

- **404**: Indicates the requested app definition was not found.
| GET | `/app-repository/app-definitions/{appDefinitionId}/model` | Get an App model | appDefinitionId (path,required) |

### GET /app-repository/app-definitions/{appDefinitionId}/model

Get an App model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| appDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the app model was found returned.

```json
{
  "type": "string"
}
```

- **404**: Indicates the app model was not found.
| GET | `/app-repository/app-definitions/{appDefinitionId}/resourcedata` | Get an app definition resource content | appDefinitionId (path,required) |

### GET /app-repository/app-definitions/{appDefinitionId}/resourcedata

Get an app definition resource content

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| appDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both app definition and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested app definition was not found or there is no resource with the given id present in the app definition. The status-description contains additional information.
| GET | `/app-repository/deployments` | List of App Deployments | name (query), nameLike (query), category (query), categoryNotEquals (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

### GET /app-repository/deployments

List of App Deployments

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| name | query |  |  | Only return app deployments with the given name. |  |
| nameLike | query |  |  | Only return app deployments with a name like the given name. |  |
| category | query |  |  | Only return app deployments with the given category. |  |
| categoryNotEquals | query |  |  | Only return app deployments which do not have the given category. |  |
| tenantId | query |  |  | Only return app deployments with the given tenantId. |  |
| tenantIdLike | query |  |  | Only return app deployments with a tenantId like the given value. |  |
| withoutTenantId | query |  |  | If true, only returns app deployments without a tenantId set. If false, the withoutTenantId parameter is ignored. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates the request was successful.

```json
{
  "$ref": "#/definitions/DataResponseAppDeploymentResponse"
}
```
| POST | `/app-repository/deployments` | Create a new app deployment | tenantId (query), file (formData) |

### POST /app-repository/deployments

The request body should contain data of type multipart/form-data. There should be exactly one file in the request, any additional files will be ignored. The deployment name is the name of the file-field passed in. Make sure the file-name ends with .app, .zip or .bar.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| tenantId | query |  |  |  |  |
| file | formData |  |  |  |  |

**Responses**

- **201**: Indicates the app deployment was created.

```json
{
  "$ref": "#/definitions/AppDeploymentResponse"
}
```

- **400**: Indicates there was no content present in the request body or the content mime-type is not supported for app deployment. The status-description contains additional information.
| GET | `/app-repository/deployments/{deploymentId}` | Get an app deployment | deploymentId (path,required) |

### GET /app-repository/deployments/{deploymentId}

Get an app deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the app deployment was found and returned.

```json
{
  "$ref": "#/definitions/AppDeploymentResponse"
}
```

- **404**: Indicates the requested app deployment was not found.
| DELETE | `/app-repository/deployments/{deploymentId}` | Delete an app deployment | deploymentId (path,required) |

### DELETE /app-repository/deployments/{deploymentId}

Delete an app deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the App deployment was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested app deployment was not found.
| GET | `/app-repository/deployments/{deploymentId}/resourcedata/{resourceName}` | Get an app deployment resource content | deploymentId (path,required), resourceName (path,required) |

### GET /app-repository/deployments/{deploymentId}/resourcedata/{resourceName}

The response body will contain the binary resource-content for the requested resource. The response content-type will be the same as the type returned in the resources mimeType property. Also, a content-disposition header is set, allowing browsers to download the file instead of displaying it.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |
| resourceName | path | yes |  |  |  |

**Responses**

- **200**: Indicates both app deployment and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested app deployment was not found or there is no resource with the given id present in the app deployment. The status-description contains additional information.
| GET | `/app-repository/deployments/{deploymentId}/resources` | List resources in a deployment | deploymentId (path,required) |

### GET /app-repository/deployments/{deploymentId}/resources

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
    "$ref": "#/definitions/AppDeploymentResourceResponse"
  }
}
```

- **404**: Indicates the requested deployment was not found.
| GET | `/app-repository/deployments/{deploymentId}/resources/**` | Get a deployment resource | deploymentId (path,required) |

### GET /app-repository/deployments/{deploymentId}/resources/**

Replace ** by ResourceId

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both deployment and resource have been found and the resource has been returned.

```json
{
  "$ref": "#/definitions/AppDeploymentResourceResponse"
}
```

- **404**: Indicates the requested deployment was not found or there is no resource with the given id present in the deployment. The status-description contains additional information.
