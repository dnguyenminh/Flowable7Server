# flowable-swagger-eventregistry

> Generated subset extracted from server_fetch/flowable-swagger-eventregistry.json

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/event-registry-management/engine` | Get engine info |  |

### GET /event-registry-management/engine

Get engine info

**Responses**

- **200**: Indicates the engine info is returned.

```json
{
  "$ref": "#/definitions/EngineInfoResponse"
}
```
| GET | `/event-registry-repository/channel-definitions` | List of channel definitions | version (query), name (query), nameLike (query), nameLikeIgnoreCase (query), key (query), keyLike (query), keyLikeIgnoreCase (query), createTime (query), createTimeAfter (query), createTimeBefore (query), resourceName (query), resourceNameLike (query), category (query), categoryLike (query), categoryNotEquals (query), deploymentId (query), parentDeploymentId (query), latest (query), onlyInbound (query), onlyOutbound (query), implementation (query), sort (query), order (query), start (query), size (query) |

### GET /event-registry-repository/channel-definitions

List of channel definitions

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| version | query |  |  | Only return channel definitions with the given version. |  |
| name | query |  |  | Only return channel definitions with the given name. |  |
| nameLike | query |  |  | Only return channel definitions with a name like the given name. |  |
| nameLikeIgnoreCase | query |  |  | Only return channel definitions with a name like the given name (case-insensitive). |  |
| key | query |  |  | Only return channel definitions with the given key. |  |
| keyLike | query |  |  | Only return channel definitions with a name like the given key. |  |
| keyLikeIgnoreCase | query |  |  | Only return channel definitions with a name like the given key (case-insensitive). |  |
| createTime | query |  |  | Only return channel definitions with the given create time. |  |
| createTimeAfter | query |  |  | Only return channel definitions with a create time after the given date. |  |
| createTimeBefore | query |  |  | Only return channel definitions with a create time before the given date. |  |
| resourceName | query |  |  | Only return channel definitions with the given resource name. |  |
| resourceNameLike | query |  |  | Only return channel definitions with a name like the given resource name. |  |
| category | query |  |  | Only return channel definitions with the given category. |  |
| categoryLike | query |  |  | Only return channel definitions with a category like the given name. |  |
| categoryNotEquals | query |  |  | Only return channel definitions which do not have the given category. |  |
| deploymentId | query |  |  | Only return channel definitions which are part of a deployment with the given deployment id. |  |
| parentDeploymentId | query |  |  | Only return channel definitions which are part of a deployment awith the given parent deployment id. |  |
| latest | query |  |  | Only return the latest channel definition versions. Can only be used together with key and keyLike parameters, using any other parameter will result in a 400-response. |  |
| onlyInbound | query |  |  | Only return the inbound channel definitions. Mutually exclusive with onlyOutbound |  |
| onlyOutbound | query |  |  | Only return the outbound channel definitions. Mutually exclusive with onlyInbound |  |
| implementation | query |  |  | Only return the channel definitions with the given implementation type. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the channel definitions are returned

```json
{
  "$ref": "#/definitions/DataResponseChannelDefinitionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format or that latest is used with other parameters other than key and keyLike. The status-message contains additional information.
| GET | `/event-registry-repository/channel-definitions/{channelDefinitionId}` | Get a channel definition | channelDefinitionId (path,required) |

### GET /event-registry-repository/channel-definitions/{channelDefinitionId}

Get a channel definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| channelDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the channel definitions are returned

```json
{
  "$ref": "#/definitions/ChannelDefinitionResponse"
}
```

- **404**: Indicates the requested channel definition was not found.
| GET | `/event-registry-repository/channel-definitions/{channelDefinitionId}/model` | Get a channel definition JSON model | channelDefinitionId (path,required) |

### GET /event-registry-repository/channel-definitions/{channelDefinitionId}/model

Get a channel definition JSON model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| channelDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the event definition was found and the model is returned. The response contains the full event definition model.

```json
{
  "$ref": "#/definitions/ChannelModel"
}
```

- **404**: Indicates the requested event definition was not found.
| GET | `/event-registry-repository/channel-definitions/{channelDefinitionId}/resourcedata` | Get a channel definition resource content | channelDefinitionId (path,required) |

### GET /event-registry-repository/channel-definitions/{channelDefinitionId}/resourcedata

Get a channel definition resource content

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| channelDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both channel definition and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested channel definition was not found or there is no resource with the given id present in the channel definition. The status-description contains additional information.
| GET | `/event-registry-repository/deployments` | List Deployments | name (query), nameLike (query), category (query), categoryNotEquals (query), parentDeploymentId (query), parentDeploymentIdLike (query), tenantIdLike (query), tenantId (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |

### GET /event-registry-repository/deployments

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
  "$ref": "#/definitions/DataResponseEventDeploymentResponse"
}
```
| POST | `/event-registry-repository/deployments` | Create a new deployment | category (query), deploymentName (query), tenantId (query), file (formData,required) |

### POST /event-registry-repository/deployments

The request body should contain data of type multipart/form-data. There should be exactly one file in the request, any additional files will be ignored. The deployment name is the name of the file-field passed in. If multiple resources need to be deployed in a single deployment, compress the resources in a zip and make sure the file-name ends with .bar or .zip.

An additional parameter (form-field) can be passed in the request body with name tenantId. The value of this field will be used as the id of the tenant this deployment is done in.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| category | query |  |  |  |  |
| deploymentName | query |  |  |  |  |
| tenantId | query |  |  |  |  |
| file | formData | yes |  |  |  |

**Responses**

- **201**: Indicates the deployment was created.

```json
{
  "$ref": "#/definitions/EventDeploymentResponse"
}
```

- **400**: Indicates there was no content present in the request body or the content mime-type is not supported for deployment. The status-description contains additional information.
| GET | `/event-registry-repository/deployments/{deploymentId}` | Get a deployment | deploymentId (path,required) |

### GET /event-registry-repository/deployments/{deploymentId}

Get a deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  | The id of the deployment to get. |  |

**Responses**

- **200**: Indicates the deployment was found and returned.

```json
{
  "$ref": "#/definitions/EventDeploymentResponse"
}
```

- **404**: Indicates the requested deployment was not found.
| DELETE | `/event-registry-repository/deployments/{deploymentId}` | Delete a deployment | deploymentId (path,required) |

### DELETE /event-registry-repository/deployments/{deploymentId}

Delete a deployment

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the deployment was found and has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested deployment was not found.
| GET | `/event-registry-repository/deployments/{deploymentId}/resourcedata/{resourceName}` | Get a deployment resource content | deploymentId (path,required), resourceName (path,required) |

### GET /event-registry-repository/deployments/{deploymentId}/resourcedata/{resourceName}

The response body will contain the binary resource-content for the requested resource. The response content-type will be the same as the type returned in the resources mimeType property. Also, a content-disposition header is set, allowing browsers to download the file instead of displaying it.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| deploymentId | path | yes |  |  |  |
| resourceName | path | yes |  | The name of the resource to get. |  |

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
| GET | `/event-registry-repository/deployments/{deploymentId}/resources` | List resources in a deployment | deploymentId (path,required) |

### GET /event-registry-repository/deployments/{deploymentId}/resources

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
| GET | `/event-registry-repository/deployments/{deploymentId}/resources/**` | Get a deployment resource | deploymentId (path,required) |

### GET /event-registry-repository/deployments/{deploymentId}/resources/**

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
| GET | `/event-registry-repository/event-definitions` | List of event definitions | version (query), name (query), nameLike (query), nameLikeIgnoreCase (query), key (query), keyLike (query), keyLikeIgnoreCase (query), resourceName (query), resourceNameLike (query), category (query), categoryLike (query), categoryNotEquals (query), deploymentId (query), parentDeploymentId (query), latest (query), sort (query), order (query), start (query), size (query) |

### GET /event-registry-repository/event-definitions

List of event definitions

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| version | query |  |  | Only return event definitions with the given version. |  |
| name | query |  |  | Only return event definitions with the given name. |  |
| nameLike | query |  |  | Only return event definitions with a name like the given name. |  |
| nameLikeIgnoreCase | query |  |  | Only return event definitions with a name like the given name (case-insensitive). |  |
| key | query |  |  | Only return event definitions with the given key. |  |
| keyLike | query |  |  | Only return event definitions with a name like the given key. |  |
| keyLikeIgnoreCase | query |  |  | Only return event definitions with a name like the given key (case-insensitive). |  |
| resourceName | query |  |  | Only return event definitions with the given resource name. |  |
| resourceNameLike | query |  |  | Only return event definitions with a name like the given resource name. |  |
| category | query |  |  | Only return event definitions with the given category. |  |
| categoryLike | query |  |  | Only return event definitions with a category like the given name. |  |
| categoryNotEquals | query |  |  | Only return event definitions which do not have the given category. |  |
| deploymentId | query |  |  | Only return event definitions which are part of a deployment with the given deployment id. |  |
| parentDeploymentId | query |  |  | Only return event definitions which are part of a deployment with the given parent deployment id. |  |
| latest | query |  |  | Only return the latest event definition versions. Can only be used together with key and keyLike parameters, using any other parameter will result in a 400-response. |  |
| sort | query |  |  | Property to sort on, to be used together with the order. |  |
| order | query |  |  | The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates request was successful and the event definitions are returned

```json
{
  "$ref": "#/definitions/DataResponseEventDefinitionResponse"
}
```

- **400**: Indicates a parameter was passed in the wrong format or that latest is used with other parameters other than key and keyLike. The status-message contains additional information.
| GET | `/event-registry-repository/event-definitions/{eventDefinitionId}` | Get an event definition | eventDefinitionId (path,required) |

### GET /event-registry-repository/event-definitions/{eventDefinitionId}

Get an event definition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| eventDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates request was successful and the event definitions are returned

```json
{
  "$ref": "#/definitions/EventDefinitionResponse"
}
```

- **404**: Indicates the requested event definition was not found.
| GET | `/event-registry-repository/event-definitions/{eventDefinitionId}/model` | Get an event definition JSON model | eventDefinitionId (path,required) |

### GET /event-registry-repository/event-definitions/{eventDefinitionId}/model

Get an event definition JSON model

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| eventDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the event definition was found and the model is returned. The response contains the full event definition model.

```json
{
  "$ref": "#/definitions/EventModel"
}
```

- **404**: Indicates the requested event definition was not found.
| GET | `/event-registry-repository/event-definitions/{eventDefinitionId}/resourcedata` | Get an event definition resource content | eventDefinitionId (path,required) |

### GET /event-registry-repository/event-definitions/{eventDefinitionId}/resourcedata

Get an event definition resource content

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| eventDefinitionId | path | yes |  |  |  |

**Responses**

- **200**: Indicates both event definition and resource have been found and the resource data has been returned.

```json
{
  "type": "array",
  "items": {
    "type": "string",
    "format": "byte"
  }
}
```

- **404**: Indicates the requested event definition was not found or there is no resource with the given id present in the event definition. The status-description contains additional information.
| POST | `/event-registry-runtime/event-instances` | Send an event instance | body (body) |

### POST /event-registry-runtime/event-instances

Only one of *eventDefinitionId* or *eventDefinitionKey* an be used in the request body.

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/EventInstanceCreateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/EventInstanceCreateRequest"
}
```

**Responses**

- **204**: Indicates the event instance was created.

- **400**: Indicates either the event definition was not found (based on id or key), no event was send. Status description contains additional information about the error.
