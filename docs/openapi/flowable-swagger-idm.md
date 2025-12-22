# flowable-swagger-idm

> Generated subset extracted from server_fetch/flowable-swagger-idm.json

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/groups` | List groups | id (query), name (query), type (query), nameLike (query), member (query), sort (query), order (query), start (query), size (query) |

### GET /groups

List groups

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return group with the given id |  |
| name | query |  |  | Only return groups with the given name |  |
| type | query |  |  | Only return groups with the given type |  |
| nameLike | query |  |  | Only return groups with a name like the given value. |  |
| member | query |  |  | Only return groups which have a member with the given username. |  |
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
| POST | `/groups` | Create a group | body (body) |

### POST /groups

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
| GET | `/groups/{groupId}` | Get a single group | groupId (path,required) |

### GET /groups/{groupId}

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
| PUT | `/groups/{groupId}` | Update a group | groupId (path,required), body (body) |

### PUT /groups/{groupId}

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
| DELETE | `/groups/{groupId}` | Delete a group | groupId (path,required) |

### DELETE /groups/{groupId}

Delete a group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the group was found and  has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested group does not exist.
| POST | `/groups/{groupId}/members` | Add a member to a group | groupId (path,required), body (body) |

### POST /groups/{groupId}/members

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
| DELETE | `/groups/{groupId}/members/{userId}` | Delete a member from a group | groupId (path,required), userId (path,required) |

### DELETE /groups/{groupId}/members/{userId}

Delete a member from a group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |
| userId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the group was found and the member has been deleted. The response body is left empty intentionally.

- **404**: Indicates the requested group was not found or that the user is not a member of the group. The status description contains additional information about the error.
| GET | `/idm-management/engine` | Get IDM engine info |  |

### GET /idm-management/engine

Returns a read-only view of the engine that is used in this REST-service.

**Responses**

- **200**: Indicates the engine info is returned.

```json
{
  "$ref": "#/definitions/EngineInfoResponse"
}
```
| GET | `/privileges` | List privileges | id (query), name (query), userId (query), groupId (query), start (query), size (query) |

### GET /privileges

List privileges

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return privileges with the given id |  |
| name | query |  |  | Only return privileges with the given name |  |
| userId | query |  |  | Only return privileges with the given userId |  |
| groupId | query |  |  | Only return privileges with the given groupId |  |
| start | query |  |  | Index of the first row to fetch. Defaults to 0. |  |
| size | query |  |  | Number of rows to fetch, starting from start. Defaults to 10. |  |

**Responses**

- **200**: Indicates the requested privileges were returned.

```json
{
  "$ref": "#/definitions/DataResponsePrivilegeResponse"
}
```
| GET | `/privileges/{privilegeId}` | Get a single privilege | privilegeId (path,required) |

### GET /privileges/{privilegeId}

Get a single privilege

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| privilegeId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the privilege exists and is returned.

```json
{
  "$ref": "#/definitions/PrivilegeResponse"
}
```

- **404**: Indicates the requested privilege does not exist.
| DELETE | `/privileges/{privilegeId}/group/{groupId}` | Deletes a privilege for a group | privilegeId (path,required), groupId (path,required) |

### DELETE /privileges/{privilegeId}/group/{groupId}

Deletes a privilege for a group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| privilegeId | path | yes |  |  |  |
| groupId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the group privilege has been deleted
| GET | `/privileges/{privilegeId}/groups` | List all groups for a given privilege | privilegeId (path,required) |

### GET /privileges/{privilegeId}/groups

List all groups for a given privilege

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| privilegeId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the privilege exists and its groups are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/GroupResponse"
  }
}
```
| POST | `/privileges/{privilegeId}/groups` | Adds a privilege for a group | privilegeId (path,required), body (body) |

### POST /privileges/{privilegeId}/groups

Adds a privilege for a group

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| privilegeId | path | yes |  |  |  |
| body | body |  | #/definitions/AddGroupPrivilegeRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/AddGroupPrivilegeRequest"
}
```

**Responses**

- **200**: Indicates the group privilege has been added
| GET | `/privileges/{privilegeId}/users` | List all users for a given privilege | privilegeId (path,required) |

### GET /privileges/{privilegeId}/users

List all users for a given privilege

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| privilegeId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the privilege exists and its users are returned.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/UserResponse"
  }
}
```
| POST | `/privileges/{privilegeId}/users` | Adds a privilege for a user | privilegeId (path,required), body (body) |

### POST /privileges/{privilegeId}/users

Adds a privilege for a user

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| privilegeId | path | yes |  |  |  |
| body | body |  | #/definitions/AddUserPrivilegeRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/AddUserPrivilegeRequest"
}
```

**Responses**

- **200**: Indicates the user privilege has been added
| DELETE | `/privileges/{privilegeId}/users/{userId}` | Deletes a privilege for a user | privilegeId (path,required), userId (path,required) |

### DELETE /privileges/{privilegeId}/users/{userId}

Deletes a privilege for a user

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| privilegeId | path | yes |  |  |  |
| userId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the user privilege has been deleted
| GET | `/users` | List users | id (query), firstName (query), lastName (query), displayName (query), email (query), firstNameLike (query), lastNameLike (query), displayNameLike (query), emailLike (query), memberOfGroup (query), sort (query), order (query), start (query), size (query) |

### GET /users

List users

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| id | query |  |  | Only return group with the given id |  |
| firstName | query |  |  | Only return users with the given firstname |  |
| lastName | query |  |  | Only return users with the given lastname |  |
| displayName | query |  |  | Only return users with the given displayName |  |
| email | query |  |  | Only return users with the given email |  |
| firstNameLike | query |  |  | Only return users with a firstname like the given value. |  |
| lastNameLike | query |  |  | Only return users with a lastname like the given value. |  |
| displayNameLike | query |  |  | Only return users with a displayName like the given value. |  |
| emailLike | query |  |  | Only return users with an email like the given value. |  |
| memberOfGroup | query |  |  | Only return users which are a member of the given group. |  |
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
| POST | `/users` | Create a user | body (body) |

### POST /users

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
| GET | `/users/{userId}` | Get a single user | userId (path,required) |

### GET /users/{userId}

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
| PUT | `/users/{userId}` | Update a user | userId (path,required), body (body) |

### PUT /users/{userId}

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
| DELETE | `/users/{userId}` | Delete a user | userId (path,required) |

### DELETE /users/{userId}

Delete a user

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

**Responses**

- **204**: Indicates the user was found and  has been deleted. Response-body is intentionally empty.

- **404**: Indicates the requested user was not found.
