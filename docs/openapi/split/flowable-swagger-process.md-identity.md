# flowable-swagger-process.md — identity (identity)

> Generated subset extracted from flowable-swagger-process.md

## GET /history/historic-variable-instances/{varInstanceId}/data

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/identity/groups` | List groups | id (query), name (query), type (query), nameLike (query), member (query), potentialStarter (query), sort (query), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates the requested groups were returned.
```json
{
  "data" : [ {
    "id" : "testgroup",
    "url" : "http://localhost:8182/identity/groups/testgroup",
    "name" : "Test group",
    "type" : "Test type"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```

## GET /identity/groups

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/identity/groups` | Create a group | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/GroupRequest |  |  |

#### Responses
- **201**: Indicates the group was created.
```json
{
  "id" : "testgroup",
  "url" : "http://localhost:8182/identity/groups/testgroup",
  "name" : "Test group",
  "type" : "Test type"
}
```
- **400**: Indicates the id of the group was missing.

## POST /identity/groups

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/identity/groups/{groupId}` | Get a single group | groupId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the group exists and is returned.
```json
{
  "id" : "testgroup",
  "url" : "http://localhost:8182/identity/groups/testgroup",
  "name" : "Test group",
  "type" : "Test type"
}
```
- **404**: Indicates the requested group does not exist.

## GET /identity/groups/{groupId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/identity/groups/{groupId}` | Update a group | groupId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |
| body | body |  | #/definitions/GroupRequest |  |  |

#### Responses
- **200**: Indicates the group was updated.
```json
{
  "id" : "testgroup",
  "url" : "http://localhost:8182/identity/groups/testgroup",
  "name" : "Test group",
  "type" : "Test type"
}
```
- **404**: Indicates the requested group was not found.
- **409**: Indicates the requested group was updated simultaneously.

## PUT /identity/groups/{groupId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/identity/groups/{groupId}` | Delete a group | groupId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the group was found and  has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested group does not exist.

## DELETE /identity/groups/{groupId}

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/identity/groups/{groupId}/members` | Add a member to a group | groupId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |
| body | body |  | #/definitions/MembershipRequest |  |  |

#### Responses
- **201**: Indicates the group was found and the member has been added.
```json
{
  "userId" : "kermit",
  "url" : "http://localhost:8182/identity/groups/sales/members/kermit",
  "groupId" : "sales"
}
```
- **400**: Indicates the userId was not included in the request body.
- **404**: Indicates the requested group was not found.
- **409**: Indicates the requested user is already a member of the group.

## POST /identity/groups/{groupId}/members

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/identity/groups/{groupId}/members/{userId}` | Delete a member from a group | groupId (path,required), userId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| groupId | path | yes |  |  |  |
| userId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the group was found and the member has been deleted. The response body is left empty intentionally.
- **404**: Indicates the requested group was not found or that the user is not a member of the group. The status description contains additional information about the error.

## DELETE /identity/groups/{groupId}/members/{userId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/identity/users` | List users | id (query), firstName (query), lastName (query), displayName (query), email (query), firstNameLike (query), lastNameLike (query), displayNameLike (query), emailLike (query), memberOfGroup (query), tenantId (query), potentialStarter (query), sort (query), order (query), start (query), size (query) |

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

#### Responses
- **200**: Indicates the group exists and is returned.
```json
{
  "data" : [ {
    "id" : "testuser",
    "firstName" : "Fred",
    "lastName" : "Smith",
    "displayName" : "Fred Smith",
    "url" : "http://localhost:8182/identity/users/testuser",
    "email" : "no-reply@flowable.org",
    "tenantId" : "companyTenantId",
    "pictureUrl" : "http://localhost:8182/identity/users/testuser/picture",
    "password" : "string"
  } ],
  "total" : 0,
  "start" : 0,
  "sort" : "string",
  "order" : "string",
  "size" : 0
}
```

## GET /identity/users

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/identity/users` | Create a user | body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/UserRequest |  |  |

#### Responses
- **201**: Indicates the user was created.
```json
{
  "id" : "testuser",
  "firstName" : "Fred",
  "lastName" : "Smith",
  "displayName" : "Fred Smith",
  "url" : "http://localhost:8182/identity/users/testuser",
  "email" : "no-reply@flowable.org",
  "tenantId" : "companyTenantId",
  "pictureUrl" : "http://localhost:8182/identity/users/testuser/picture",
  "password" : "string"
}
```
- **400**: Indicates the id of the user was missing.

## POST /identity/users

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/identity/users/{userId}` | Get a single user | userId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the user exists and is returned.
```json
{
  "id" : "testuser",
  "firstName" : "Fred",
  "lastName" : "Smith",
  "displayName" : "Fred Smith",
  "url" : "http://localhost:8182/identity/users/testuser",
  "email" : "no-reply@flowable.org",
  "tenantId" : "companyTenantId",
  "pictureUrl" : "http://localhost:8182/identity/users/testuser/picture",
  "password" : "string"
}
```
- **404**: Indicates the requested user does not exist.

## GET /identity/users/{userId}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/identity/users/{userId}` | Update a user | userId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| body | body |  | #/definitions/UserRequest |  |  |

#### Responses
- **200**: Indicates the user was updated.
```json
{
  "id" : "testuser",
  "firstName" : "Fred",
  "lastName" : "Smith",
  "displayName" : "Fred Smith",
  "url" : "http://localhost:8182/identity/users/testuser",
  "email" : "no-reply@flowable.org",
  "tenantId" : "companyTenantId",
  "pictureUrl" : "http://localhost:8182/identity/users/testuser/picture",
  "password" : "string"
}
```
- **404**: Indicates the requested user was not found.
- **409**: Indicates the requested user was updated simultaneously.

## PUT /identity/users/{userId}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/identity/users/{userId}` | Delete a user | userId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

#### Responses
- **204**: Indicates the user was found and  has been deleted. Response-body is intentionally empty.
- **404**: Indicates the requested user was not found.

## DELETE /identity/users/{userId}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/identity/users/{userId}/info` | List user’s info | userId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the user was found and list of info (key and url) is returned.
```json
[ {
  "key" : "jobTitle",
  "value" : "Muppet",
  "url" : "http://localhost:8080/flowable-rest/service/identity/users/kermit/info/jobTitle"
} ]
```
- **404**: Indicates the requested user was not found.

## GET /identity/users/{userId}/info

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/identity/users/{userId}/info` | Create a new user’s info entry | userId (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| body | body |  | #/definitions/UserInfoRequest |  |  |

#### Responses
- **201**: Indicates the user was found and the info has been created.
```json
{
  "key" : "jobTitle",
  "value" : "Muppet",
  "url" : "http://localhost:8080/flowable-rest/service/identity/users/kermit/info/jobTitle"
}
```
- **400**: Indicates the key or value was missing from the request body. Status description contains additional information about the error.
- **404**: Indicates the requested user was not found.
- **409**: Indicates there is already an info-entry with the given key for the user, update the resource instance (PUT).

## POST /identity/users/{userId}/info

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/identity/users/{userId}/info/{key}` | Get a user’s info | userId (path,required), key (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| key | path | yes |  |  |  |

#### Responses
- **200**: Indicates the user was found and the user has info for the given key.
```json
{
  "key" : "jobTitle",
  "value" : "Muppet",
  "url" : "http://localhost:8080/flowable-rest/service/identity/users/kermit/info/jobTitle"
}
```
- **404**: Indicates the requested user was not found or the user does ot have info for the given key. Status description contains additional information about the error.

## GET /identity/users/{userId}/info/{key}

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/identity/users/{userId}/info/{key}` | Update a user’s info | userId (path,required), key (path,required), body (body) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| key | path | yes |  |  |  |
| body | body |  | #/definitions/UserInfoRequest |  |  |

#### Responses
- **200**: Indicates the user was found and the info has been updated.
```json
{
  "key" : "jobTitle",
  "value" : "Muppet",
  "url" : "http://localhost:8080/flowable-rest/service/identity/users/kermit/info/jobTitle"
}
```
- **400**: Indicates the value was missing from the request body.
- **404**: Indicates the requested user was not found or the user does not have info for the given key. Status description contains additional information about the error.

## PUT /identity/users/{userId}/info/{key}

| Method | Path | Summary | Params |
|---|---|---|---|
| DELETE | `/identity/users/{userId}/info/{key}` | Delete a user’s info | userId (path,required), key (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| key | path | yes |  |  |  |

#### Responses
- **204**: Indicates the user was found and the info for the given key has been deleted. Response body is left empty intentionally.
- **404**: Indicates the requested user was not found or the user does not have info for the given key. Status description contains additional information about the error.

## DELETE /identity/users/{userId}/info/{key}

| Method | Path | Summary | Params |
|---|---|---|---|
| GET | `/identity/users/{userId}/picture` | Get a user’s picture | userId (path,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |

#### Responses
- **200**: Indicates the user was found and has a picture, which is returned in the body.
```json
[ "string" ]
```
- **404**: Indicates the requested user was not found or the user does not have a profile picture. Status-description contains additional information about the error.

## GET /identity/users/{userId}/picture

| Method | Path | Summary | Params |
|---|---|---|---|
| PUT | `/identity/users/{userId}/picture` | Updating a user’s picture | userId (path,required), file (formData,required) |

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| userId | path | yes |  |  |  |
| file | formData | yes |  | Picture to update |  |

#### Responses
- **204**: Indicates the user was found and the picture has been updated. The response-body is left empty intentionally.
- **404**: Indicates the requested user was not found.
