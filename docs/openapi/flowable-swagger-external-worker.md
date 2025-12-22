# flowable-swagger-external-worker

> Generated subset extracted from server_fetch/flowable-swagger-external-worker.json

| Method | Path | Summary | Params |
|---|---|---|---|
| POST | `/acquire/jobs` | Acquire External Worker Jobs | body (body) |

### POST /acquire/jobs

Acquire External Worker Jobs

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/AcquireExternalWorkerJobRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/AcquireExternalWorkerJobRequest"
}
```

**Responses**

- **200**: Indicates the jobs were acquired and locked.

```json
{
  "type": "array",
  "items": {
    "$ref": "#/definitions/AcquiredExternalWorkerJobResponse"
  }
}
```

- **400**: Indicates the request was invalid.

- **403**: Indicates the user does not have the rights acquire the jobs.
| POST | `/acquire/jobs/{jobId}/bpmnError` | Complete an External Worker Job with a BPMN Error | jobId (path,required), body (body) |

### POST /acquire/jobs/{jobId}/bpmnError

Complete an External Worker Job with a BPMN Error

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/ExternalWorkerJobErrorRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExternalWorkerJobErrorRequest"
}
```

**Responses**

- **204**: Indicates the job was successfully completed.

```json
{
  "type": "object"
}
```

- **400**: Indicates the request was invalid.

- **403**: Indicates the user does not have the rights complete the job.

- **404**: Indicates the job does not exist.
| POST | `/acquire/jobs/{jobId}/cmmnTerminate` | Complete an External Worker Job with a cmmn terminate transition | jobId (path,required), body (body) |

### POST /acquire/jobs/{jobId}/cmmnTerminate

Complete an External Worker Job with a cmmn terminate transition

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/ExternalWorkerJobTerminateRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExternalWorkerJobTerminateRequest"
}
```

**Responses**

- **204**: Indicates the job was successfully transitioned.

```json
{
  "type": "object"
}
```

- **400**: Indicates the request was invalid.

- **403**: Indicates the user does not have the rights complete the job.

- **404**: Indicates the job does not exist.
| POST | `/acquire/jobs/{jobId}/complete` | Complete an External Worker Jobs | jobId (path,required), body (body) |

### POST /acquire/jobs/{jobId}/complete

Complete an External Worker Jobs

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/ExternalWorkerJobCompleteRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExternalWorkerJobCompleteRequest"
}
```

**Responses**

- **204**: Indicates the job was successfully completed.

```json
{
  "type": "object"
}
```

- **400**: Indicates the request was invalid.

- **403**: Indicates the user does not have the rights complete the job.

- **404**: Indicates the job does not exist.
| POST | `/acquire/jobs/{jobId}/fail` | Fail an External Worker Job | jobId (path,required), body (body) |

### POST /acquire/jobs/{jobId}/fail

Fail an External Worker Job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/ExternalWorkerJobFailureRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/ExternalWorkerJobFailureRequest"
}
```

**Responses**

- **204**: Indicates the job was successfully completed.

```json
{
  "type": "object"
}
```

- **400**: Indicates the request was invalid.

- **403**: Indicates the user does not have the rights complete the job.

- **404**: Indicates the job does not exist.
| GET | `/jobs` | List External Worker Jobs | elementId (query), elementName (query), exceptionMessage (query), executionId (query), id (query), locked (query), order (query), processDefinitionId (query), processInstanceId (query), scopeDefinitionId (query), scopeId (query), size (query), start (query), subScopeId (query), tenantId (query), tenantIdLike (query), unlocked (query), withException (query), withoutProcessInstanceId (query), withoutScopeId (query), withoutScopeType (query), withoutTenantId (query), sort (body) |

### GET /jobs

List External Worker Jobs

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| elementId | query |  |  | Only return jobs with the given elementId |  |
| elementName | query |  |  | Only return jobs with the given elementName |  |
| exceptionMessage | query |  |  | Only return jobs with the given exception message |  |
| executionId | query |  |  | Only return jobs with the given executionId |  |
| id | query |  |  | Only return job with the given id |  |
| locked | query |  |  | Only return jobs that are locked |  |
| order | query |  |  | From the paginate request.  The sort order, either 'asc' or 'desc'. Defaults to 'asc'. |  |
| processDefinitionId | query |  |  | Only return jobs with the given processDefinitionId |  |
| processInstanceId | query |  |  | Only return jobs with the processInstanceId |  |
| scopeDefinitionId | query |  |  | Only return jobs with the given scopeDefinitionId |  |
| scopeId | query |  |  | Only return jobs with the given scopeId |  |
| size | query |  |  | From the paginate request. Number of rows to fetch, starting from start. Defaults to 10. |  |
| start | query |  |  | From the paginate request. Index of the first row to fetch. Defaults to 0. |  |
| subScopeId | query |  |  | Only return jobs with the given subScopeId |  |
| tenantId | query |  |  | Only return jobs with the given tenant id |  |
| tenantIdLike | query |  |  | Only return jobs with a tenantId like the given value |  |
| unlocked | query |  |  | Only return jobs that are unlocked |  |
| withException | query |  |  | Only return jobs with an exception |  |
| withoutProcessInstanceId | query |  |  | Only return jobs without a process instance id |  |
| withoutScopeId | query |  |  | Only return jobs without a scope id |  |
| withoutScopeType | query |  |  | Only return jobs without a scope type |  |
| withoutTenantId | query |  |  | Only return jobs without a tenantId |  |
| sort | body |  | #/definitions/ExternalWorkerJobCollectionResource | The field to sort by. Defaults to 'id'. |  |

**Request**

```json
{
  "$ref": "#/definitions/ExternalWorkerJobCollectionResource"
}
```

**Responses**

- **200**: Indicates the requested jobs were returned.

```json
{
  "$ref": "#/definitions/DataResponseExternalWorkerJobResponse"
}
```

- **400**: Indicates an illegal value has been used in a url query parameter. Status description contains additional details about the error.

- **403**: Indicates the user does not have the rights to query for external worker jobs.
| GET | `/jobs/{jobId}` | Get a single external worker job | jobId (path,required) |

### GET /jobs/{jobId}

Get a single external worker job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |

**Responses**

- **200**: Indicates the requested job was returned.

```json
{
  "$ref": "#/definitions/ExternalWorkerJobResponse"
}
```

- **403**: Indicates the user does not have the rights access the job.

- **404**: Indicates the requested job was not found.
| POST | `/unacquire/jobs` | Unacquire External Worker Jobs | body (body) |

### POST /unacquire/jobs

Unacquire External Worker Jobs

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| body | body |  | #/definitions/UnacquireExternalWorkerJobsRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/UnacquireExternalWorkerJobsRequest"
}
```

**Responses**

- **200**: successful operation

```json
{
  "type": "object"
}
```

- **204**: Indicates the jobs were unacquired.

- **400**: Indicates the request was invalid.

- **403**: Indicates the user does not have the rights to unacquire the jobs.
| POST | `/unacquire/jobs/{jobId}` | Unaquire an External Worker Job | jobId (path,required), body (body) |

### POST /unacquire/jobs/{jobId}

Unaquire an External Worker Job

| Name | In | Required | Schema | Description | Example |
|---|---|---:|---|---|---|
| jobId | path | yes |  |  |  |
| body | body |  | #/definitions/UnacquireExternalWorkerJobsRequest |  |  |

**Request**

```json
{
  "$ref": "#/definitions/UnacquireExternalWorkerJobsRequest"
}
```

**Responses**

- **204**: Indicates the job was successfully unaquired.

```json
{
  "type": "object"
}
```

- **400**: Indicates the request was invalid.

- **403**: Indicates the user does not have the rights to unacquire the job.

- **404**: Indicates the job does not exist.
