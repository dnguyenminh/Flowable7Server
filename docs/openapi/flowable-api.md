# Flowable REST API (generated from per-module Swagger JSON)

> NOTE: integration tests require CMMN *create* endpoints (e.g. POST /cmmn-api/case-instances). If your image exposes only query endpoints, tests will fail.

Generated from:
- docs/openapi/server_fetch/flowable-swagger-cmmn.json
- docs/openapi/server_fetch/flowable-swagger-process.json

---

## Module: cmmn

| GET | `/cmmn-history/historic-case-instances` | List of historic case instances | caseInstanceId (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), caseDefinitionId (query), caseDefinitionCategory (query), caseDefinitionCategoryLike (query), caseDefinitionCategoryLikeIgnoreCase (query), caseDefinitionName (query), caseDefinitionNameLike (query), caseDefinitionNameLikeIgnoreCase (query), name (query), nameLike (query), nameLikeIgnoreCase (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), involvedUser (query), finished (query), finishedAfter (query), finishedBefore (query), startedAfter (query), startedBefore (query), startedBy (query), state (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), referenceId (query), referenceType (query), lastReactivatedBy (query), lastReactivatedBefore (query), lastReactivatedAfter (query), activePlanItemDefinitionId (query), includeCaseVariables (query), includeCaseVariablesName (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), withoutCaseInstanceParentId (query), withoutCaseInstanceCallbackId (query) |
| POST | `/cmmn-history/historic-case-instances/delete` | Post action request to delete a bulk of historic case instances | bulkDeleteRestActionRequest (body) |
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}` | Get a historic case instance | caseInstanceId (path,required) |
| DELETE | `/cmmn-history/historic-case-instances/{caseInstanceId}` | Delete a historic case instance | caseInstanceId (path,required) |
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/identitylinks` | List identity links of a historic case instance | caseInstanceId (path,required) |
| POST | `/cmmn-history/historic-case-instances/{caseInstanceId}/migrate` | Migrate historic case instance | caseInstanceId (path,required), body (body) |
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/stage-overview` | Get a stage overview of historic case instance | caseInstanceId (path,required) |
| GET | `/cmmn-history/historic-case-instances/{caseInstanceId}/variables/{variableName}/data` | Get the binary data for a historic case instance variable | caseInstanceId (path,required), variableName (path,required) |
| GET | `/cmmn-history/historic-milestone-instances` | List of historic milestone instances | milestoneId (query), milestoneName (query), caseInstanceId (query), caseDefinitionId (query), reachedBefore (query), reachedAfter (query) |
| GET | `/cmmn-history/historic-milestone-instances/{milestoneInstanceId}` | Get a historic milestone instance by id | milestoneInstanceId (path,required) |
| GET | `/cmmn-history/historic-planitem-instances` | List of historic plan item instances | planItemInstanceId (query), planItemInstanceName (query), planItemInstanceState (query), caseDefinitionId (query), caseInstanceId (query), stageInstanceId (query), elementId (query), planItemDefinitionId (query), planItemDefinitionType (query), createdBefore (query), createdAfter (query), lastAvailableBefore (query), lastAvailableAfter (query), lastEnabledBefore (query), lastEnabledAfter (query), lastDisabledBefore (query), lastDisabledAfter (query), lastStartedBefore (query), lastStartedAfter (query), lastSuspendedBefore (query), lastSuspendedAfter (query), completedBefore (query), completedAfter (query), terminatedBefore (query), terminatedAfter (query), occurredBefore (query), occurredAfter (query), exitBefore (query), exitAfter (query), endedBefore (query), endedAfter (query), startUserId (query), referenceId (query), referenceType (query), tenantId (query), withoutTenantId (query) |
| GET | `/cmmn-history/historic-planitem-instances/{planItemInstanceId}` | Get a historic plan item instance | planItemInstanceId (path,required) |
| GET | `/cmmn-history/historic-task-instances` | List historic task instances | taskId (query), caseInstanceId (query), caseInstanceIdWithChildren (query), caseDefinitionId (query), propagatedStageInstanceId (query), withoutScopeId (query), taskDefinitionKey (query), taskName (query), taskNameLike (query), taskNameLikeIgnoreCase (query), taskDescription (query), taskDescriptionLike (query), taskCategory (query), taskCategoryIn (query), taskCategoryNotIn (query), taskWithoutCategory (query), taskDeleteReason (query), taskDeleteReasonLike (query), taskAssignee (query), taskAssigneeLike (query), taskOwner (query), taskOwnerLike (query), taskInvolvedUser (query), taskCandidateGroup (query), taskPriority (query), finished (query), processFinished (query), parentTaskId (query), dueDate (query), dueDateAfter (query), dueDateBefore (query), withoutDueDate (query), taskCompletedOn (query), taskCompletedAfter (query), taskCompletedBefore (query), taskCreatedOn (query), taskCreatedBefore (query), taskCreatedAfter (query), includeTaskLocalVariables (query), includeProcessVariables (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), withoutProcessInstanceId (query), planItemInstanceId (query), rootScopeId (query), parentScopeId (query) |
| GET | `/cmmn-history/historic-task-instances/{taskId}` | Get a single historic task instance | taskId (path,required) |
| DELETE | `/cmmn-history/historic-task-instances/{taskId}` | Delete a historic task instance | taskId (path,required) |
| GET | `/cmmn-history/historic-task-instances/{taskId}/form` | Get a historic task instance form | taskId (path,required) |
| GET | `/cmmn-history/historic-task-instances/{taskId}/identitylinks` | List identity links of a historic task instance | taskId (path,required) |
| GET | `/cmmn-history/historic-task-instances/{taskId}/variables/{variableName}/data` | Get the binary data for a historic task instance variable | taskId (path,required), variableName (path,required), scope (query) |
| GET | `/cmmn-history/historic-variable-instances` | List of historic variable instances | caseInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |
| GET | `/cmmn-history/historic-variable-instances/{varInstanceId}/data` | Get the binary data for a historic task instance variable | varInstanceId (path,required) |
| GET | `/cmmn-management/deadletter-jobs` | List deadletter jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |
| POST | `/cmmn-management/deadletter-jobs` | Move a bulk of deadletter jobs. Accepts 'move' and 'moveToHistoryJob' as action. | body (body) |
| GET | `/cmmn-management/deadletter-jobs/{jobId}` | Get a single deadletter job | jobId (path,required) |
| POST | `/cmmn-management/deadletter-jobs/{jobId}` | Move a single deadletter job. Accepts 'move' and 'moveToHistoryJob' as action. | jobId (path,required), body (body) |
| DELETE | `/cmmn-management/deadletter-jobs/{jobId}` | Delete a deadletter job | jobId (path,required) |
| GET | `/cmmn-management/deadletter-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a deadletter job | jobId (path,required) |
| GET | `/cmmn-management/engine` | Get engine info |  |
| GET | `/cmmn-management/history-jobs` | List history jobs | id (query), withException (query), exceptionMessage (query), scopeType (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), lockOwner (query), locked (query), unlocked (query), sort (query), order (query), start (query), size (query) |
| GET | `/cmmn-management/history-jobs/{jobId}` | Get a single history job job | jobId (path,required) |
| POST | `/cmmn-management/history-jobs/{jobId}` | Execute a history job | jobId (path,required), body (body) |
| DELETE | `/cmmn-management/history-jobs/{jobId}` | Delete a history job | jobId (path,required) |
| GET | `/cmmn-management/jobs` | List jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |
| GET | `/cmmn-management/jobs/{jobId}` | Get a single job | jobId (path,required) |
| POST | `/cmmn-management/jobs/{jobId}` | Execute a single job | jobId (path,required), body (body) |
| DELETE | `/cmmn-management/jobs/{jobId}` | Delete a job | jobId (path,required) |
| GET | `/cmmn-management/jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a job | jobId (path,required) |
| GET | `/cmmn-management/suspended-jobs` | List suspended jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |
| GET | `/cmmn-management/suspended-jobs/{jobId}` | Get a single suspended job | jobId (path,required) |
| DELETE | `/cmmn-management/suspended-jobs/{jobId}` | Delete a suspended job | jobId (path,required) |
| GET | `/cmmn-management/suspended-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a suspended job | jobId (path,required) |
| GET | `/cmmn-management/timer-jobs` | List timer jobs | id (query), caseInstanceId (query), withoutScopeId (query), planItemInstanceId (query), caseDefinitionId (query), scopeDefinitionId (query), scopeType (query), elementId (query), elementName (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutProcessInstanceId (query), sort (query), order (query), start (query), size (query) |
| GET | `/cmmn-management/timer-jobs/{jobId}` | Get a single timer job | jobId (path,required) |
| POST | `/cmmn-management/timer-jobs/{jobId}` | Execute a single job action (move or reschedule) | jobId (path,required), body (body) |
| DELETE | `/cmmn-management/timer-jobs/{jobId}` | Delete a timer job | jobId (path,required) |
| GET | `/cmmn-management/timer-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a timer job | jobId (path,required) |
| POST | `/cmmn-query/case-instances` | Query case instances | body (body), sort (body) |
| POST | `/cmmn-query/historic-case-instances` | Query for historic case instances | body (body), sort (body) |
| POST | `/cmmn-query/historic-milestone-instances` | Query for historic milestone instances | body (body), sort (body) |
| POST | `/cmmn-query/historic-planitem-instances` | Query for historic plan item instances | body (body), sort (body) |
| POST | `/cmmn-query/historic-task-instances` | Query for historic task instances | body (body), sort (body) |
| POST | `/cmmn-query/historic-variable-instances` | Query for historic variable instances | body (body), sort (query) |
| POST | `/cmmn-query/plan-item-instances` | Query plan item instances | body (body), sort (body) |
| POST | `/cmmn-query/tasks` | Query for tasks | body (body), sort (body) |
| POST | `/cmmn-query/variable-instances` | Query for variable instances | body (body), sort (query) |
| GET | `/cmmn-repository/case-definitions` | List of case definitions | version (query), name (query), nameLike (query), nameLikeIgnoreCase (query), key (query), keyLike (query), resourceName (query), resourceNameLike (query), category (query), categoryLike (query), categoryNotEquals (query), deploymentId (query), parentDeploymentId (query), startableByUser (query), latest (query), suspended (query), sort (query), order (query), start (query), size (query) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}` | Get a case definition | caseDefinitionId (path,required) |
| PUT | `/cmmn-repository/case-definitions/{caseDefinitionId}` | Execute actions for a case definition | caseDefinitionId (path,required), body (body,required) |
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/batch-migrate` | Batch migrate all instances of case definition | caseDefinitionId (path,required), body (body) |
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/batch-migrate-historic-instances` | Batch migrate all historic instances of case definition | caseDefinitionId (path,required), body (body) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/decision-tables` | List decision tables for a case definition | caseDefinitionId (path,required) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/decisions` | List decisions for a case definition | caseDefinitionId (path,required) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/form-definitions` | List form definitions for a case definition | caseDefinitionId (path,required) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks` | List candidate starters for a case definition | caseDefinitionId (path,required) |
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks` | Add a candidate starter to a case definition | caseDefinitionId (path,required), body (body) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks/{family}/{identityId}` | Get a candidate starter from a case definition | caseDefinitionId (path,required), family (path,required), identityId (path,required) |
| DELETE | `/cmmn-repository/case-definitions/{caseDefinitionId}/identitylinks/{family}/{identityId}` | Delete a candidate starter from a case definition | caseDefinitionId (path,required), family (path,required), identityId (path,required) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/image` | Get a case definition image | caseDefinitionId (path,required) |
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/migrate` | Migrate all instances of case definition | caseDefinitionId (path,required), body (body) |
| POST | `/cmmn-repository/case-definitions/{caseDefinitionId}/migrate-historic-instances` | Migrate all historic case instances of case definition | caseDefinitionId (path,required), body (body) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/model` | Get a case definition CMMN model | caseDefinitionId (path,required) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/resourcedata` | Get a case definition resource content | caseDefinitionId (path,required) |
| GET | `/cmmn-repository/case-definitions/{caseDefinitionId}/start-form` | Get a case definition start form | caseDefinitionId (path,required) |
| GET | `/cmmn-repository/deployments` | List Deployments | name (query), nameLike (query), category (query), categoryNotEquals (query), parentDeploymentId (query), parentDeploymentIdLike (query), tenantIdLike (query), tenantId (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |
| POST | `/cmmn-repository/deployments` | Create a new deployment | deploymentKey (query), deploymentName (query), tenantId (query), file (formData,required) |
| GET | `/cmmn-repository/deployments/{deploymentId}` | Get a deployment | deploymentId (path,required) |
| DELETE | `/cmmn-repository/deployments/{deploymentId}` | Delete a deployment | deploymentId (path,required), cascade (query) |
| GET | `/cmmn-repository/deployments/{deploymentId}/resourcedata/{resourceName}` | Get a deployment resource content | deploymentId (path,required), resourceName (path,required) |
| GET | `/cmmn-repository/deployments/{deploymentId}/resources` | List resources in a deployment | deploymentId (path,required) |
| GET | `/cmmn-repository/deployments/{deploymentId}/resources/**` | Get a deployment resource | deploymentId (path,required) |
| GET | `/cmmn-runtime/case-instances` | List case instances | id (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), caseDefinitionId (query), caseDefinitionCategory (query), caseDefinitionCategoryLike (query), caseDefinitionCategoryLikeIgnoreCase (query), caseDefinitionName (query), caseDefinitionNameLike (query), caseDefinitionNameLikeIgnoreCase (query), name (query), nameLike (query), nameLikeIgnoreCase (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), caseInstanceParentId (query), startedBy (query), startedBefore (query), startedAfter (query), state (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), referenceId (query), referenceType (query), lastReactivatedBy (query), lastReactivatedBefore (query), lastReactivatedAfter (query), includeCaseVariables (query), includeCaseVariablesName (query), activePlanItemDefinitionId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), sort (query) |
| POST | `/cmmn-runtime/case-instances` | Start a case instance | body (body) |
| POST | `/cmmn-runtime/case-instances/delete` | Post action request to delete/terminate a bulk of case instances | body (body) |
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}` | Get a case instance | caseInstanceId (path,required) |
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}` | Update case instance properties or execute an action on a case instance (body needs to contain an 'action' property for the latter). | caseInstanceId (path,required), body (body) |
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}` | Terminate a case instance | caseInstanceId (path,required) |
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/change-state` | Change the state of a case instance | caseInstanceId (path,required), body (body) |
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/delete` | Delete a case instance | caseInstanceId (path,required) |
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/diagram` | Get diagram for a case instance | caseInstanceId (path,required) |
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks` | Get involved people for case instance | caseInstanceId (path,required) |
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks` | Add an involved user to a case instance | caseInstanceId (path,required), body (body) |
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}` | Get a specific involved people from case instance | caseInstanceId (path,required), identityId (path,required), type (path,required) |
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/identitylinks/users/{identityId}/{type}` | Remove an involved user to from case instance | caseInstanceId (path,required), identityId (path,required), type (path,required) |
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/migrate` | Migrate case instance | caseInstanceId (path,required), body (body) |
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/stage-overview` |  | caseInstanceId (path,required) |
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | List variables for a case instance | caseInstanceId (path,required) |
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Create variables or new binary variable on a case instance | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Update a multiple/single (non)binary variable on a case instance | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/variables` | Delete all variables | caseInstanceId (path,required) |
| POST | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async` | Create variables or new binary variable on a case instance asynchronously | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async` | Update a multiple/single (non)binary variable on a case instance asynchronously | caseInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables-async/{variableName}` | Update a single variable on a case instance asynchronously | caseInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Get a variable for a case instance | caseInstanceId (path,required), variableName (path,required), scope (query) |
| PUT | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Update a single variable on a case instance | caseInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |
| DELETE | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}` | Delete a variable | caseInstanceId (path,required), variableName (path,required), scope (query) |
| GET | `/cmmn-runtime/case-instances/{caseInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | caseInstanceId (path,required), variableName (path,required), scope (query) |
| GET | `/cmmn-runtime/event-subscriptions` | List of event subscriptions | id (query), eventType (query), eventName (query), activityId (query), caseInstanceId (query), withoutScopeId (query), caseDefinitionId (query), withoutScopeDefinitionId (query), planItemInstanceId (query), createdBefore (query), createdAfter (query), tenantId (query), withoutTenantId (query), configuration (query), withoutConfiguration (query), withoutProcessInstanceId (query), withoutProcessDefinitionId (query), sort (query), order (query), start (query), size (query) |
| GET | `/cmmn-runtime/event-subscriptions/{eventSubscriptionId}` | Get a single event subscription | eventSubscriptionId (path,required) |
| GET | `/cmmn-runtime/plan-item-instances` | List of plan item instances | id (query), caseDefinitionId (query), caseInstanceId (query), stageInstanceId (query), planItemDefinitionId (query), planItemDefinitionType (query), planItemDefinitionTypes (query), state (query), name (query), elementId (query), referenceId (query), referenceType (query), createdBefore (query), createdAfter (query), startUserId (query), includeEnded (query), includeLocalVariables (query), tenantId (query), withoutTenantId (query), sort (query) |
| GET | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}` | Get an plan item instance | planItemInstanceId (path,required) |
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}` | Execute an action on a plan item instance | planItemInstanceId (path,required), body (body) |
| POST | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables` | Create a variable on a plan item | planItemInstanceId (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |
| POST | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async` | Create a variable on a plan item asynchronously | planItemInstanceId (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables-async/{variableName}` | Update a variable on a plan item asynchronously | planItemInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |
| PUT | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}` | Update a variable on a plan item | planItemInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |
| DELETE | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}` | Delete a variable for a plan item instance | planItemInstanceId (path,required), variableName (path,required), scope (query) |
| GET | `/cmmn-runtime/plan-item-instances/{planItemInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | planItemInstanceId (path,required), variableName (path,required), scope (query) |
| GET | `/cmmn-runtime/tasks` | List of tasks | taskId (query), name (query), nameLike (query), nameLikeIgnoreCase (query), description (query), priority (query), minimumPriority (query), maximumPriority (query), assignee (query), assigneeLike (query), owner (query), ownerLike (query), unassigned (query), delegationState (query), candidateUser (query), candidateGroup (query), candidateGroups (query), involvedUser (query), taskDefinitionKey (query), taskDefinitionKeyLike (query), caseInstanceId (query), caseInstanceIdWithChildren (query), caseDefinitionId (query), caseDefinitionKey (query), caseDefinitionKeyLike (query), caseDefinitionKeyLikeIgnoreCase (query), planItemInstanceId (query), propagatedStageInstanceId (query), scopeId (query), withoutScopeId (query), subScopeId (query), scopeType (query), createdOn (query), createdBefore (query), createdAfter (query), dueOn (query), dueBefore (query), dueAfter (query), withoutDueDate (query), excludeSubTasks (query), active (query), includeTaskLocalVariables (query), includeProcessVariables (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), withoutProcessInstanceId (query), candidateOrAssigned (query), category (query), categoryIn (query), categoryNotIn (query), withoutCategory (query), rootScopeId (query), parentScopeId (query) |
| POST | `/cmmn-runtime/tasks` | Create Task | body (body) |
| PUT | `/cmmn-runtime/tasks` | Update Tasks | body (body) |
| GET | `/cmmn-runtime/tasks/{taskId}` | Get a task | taskId (path,required) |
| POST | `/cmmn-runtime/tasks/{taskId}` | Tasks actions | taskId (path,required), body (body) |
| PUT | `/cmmn-runtime/tasks/{taskId}` | Update a task | taskId (path,required), body (body) |
| DELETE | `/cmmn-runtime/tasks/{taskId}` | Delete a task | taskId (path,required), cascadeHistory (query), deleteReason (query) |
| GET | `/cmmn-runtime/tasks/{taskId}/form` | Get a task form | taskId (path,required) |
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks` | List identity links for a task | taskId (path,required) |
| POST | `/cmmn-runtime/tasks/{taskId}/identitylinks` | Create an identity link on a task | taskId (path,required), body (body) |
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}` | List identity links for a task for either groups or users | taskId (path,required), family (path,required) |
| GET | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Get a single identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |
| DELETE | `/cmmn-runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Delete an identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |
| GET | `/cmmn-runtime/tasks/{taskId}/subtasks` | List of sub tasks for a task | taskId (path,required) |
| GET | `/cmmn-runtime/tasks/{taskId}/variables` | List variables for a task | taskId (path,required), scope (query) |
| POST | `/cmmn-runtime/tasks/{taskId}/variables` | Create new variables on a task | taskId (path,required), body (body), name (formData), type (formData), scope (formData) |
| DELETE | `/cmmn-runtime/tasks/{taskId}/variables` | Delete all local variables on a task | taskId (path,required) |
| GET | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Get a variable from a task | taskId (path,required), variableName (path,required), scope (query) |
| PUT | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Update an existing variable on a task | taskId (path,required), variableName (path,required), body (body), name (formData), type (formData), scope (formData) |
| DELETE | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}` | Delete a variable on a task | taskId (path,required), variableName (path,required), scope (query) |
| GET | `/cmmn-runtime/tasks/{taskId}/variables/{variableName}/data` | Get the binary data for a variable | taskId (path,required), variableName (path,required), scope (query) |
| GET | `/cmmn-runtime/variable-instances` | List of variable instances | caseInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |
| GET | `/cmmn-runtime/variable-instances/{varInstanceId}/data` | Get the binary data for a variable instance | varInstanceId (path,required) |


## Module: process

| GET | `/form/form-data` | Get form data | taskId (query), processDefinitionId (query) |
| POST | `/form/form-data` | Submit task form data | body (body) |
| GET | `/history/historic-activity-instances` | List historic activity instances | activityId (query), activityInstanceId (query), activityName (query), activityType (query), executionId (query), finished (query), taskAssignee (query), processInstanceId (query), processDefinitionId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query) |
| GET | `/history/historic-detail` | Get historic detail | id (query), processInstanceId (query), executionId (query), activityInstanceId (query), taskId (query), selectOnlyFormProperties (query), selectOnlyVariableUpdates (query) |
| GET | `/history/historic-detail/{detailId}/data` | Get the binary data for a historic detail variable | detailId (path,required) |
| GET | `/history/historic-process-instances` | List of historic process instances | processInstanceId (query), processInstanceName (query), processInstanceNameLike (query), processInstanceNameLikeIgnoreCase (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionKeyLikeIgnoreCase (query), processDefinitionId (query), processDefinitionName (query), processDefinitionNameLike (query), processDefinitionNameLikeIgnoreCase (query), processDefinitionCategory (query), processDefinitionCategoryLike (query), processDefinitionCategoryLikeIgnoreCase (query), processDefinitionVersion (query), deploymentId (query), rootScopeId (query), parentScopeId (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), activeActivityId (query), involvedUser (query), finished (query), superProcessInstanceId (query), excludeSubprocesses (query), finishedAfter (query), finishedBefore (query), startedAfter (query), startedBefore (query), startedBy (query), includeProcessVariables (query), includeProcessVariablesName (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), withoutCallbackId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query) |
| POST | `/history/historic-process-instances/delete` | Post action request to delete a bulk of historic process instances | bulkDeleteRestActionRequest (body) |
| GET | `/history/historic-process-instances/{processInstanceId}` | Get a historic process instance | processInstanceId (path,required) |
| DELETE | `/history/historic-process-instances/{processInstanceId}` | Delete a historic process instance | processInstanceId (path,required) |
| GET | `/history/historic-process-instances/{processInstanceId}/comments` | List comments on a historic process instance | processInstanceId (path,required) |
| POST | `/history/historic-process-instances/{processInstanceId}/comments` | Create a new comment on a historic process instance | processInstanceId (path,required), body (body) |
| GET | `/history/historic-process-instances/{processInstanceId}/comments/{commentId}` | Get a comment on a historic process instance | processInstanceId (path,required), commentId (path,required) |
| DELETE | `/history/historic-process-instances/{processInstanceId}/comments/{commentId}` | Delete a comment on a historic process instance | processInstanceId (path,required), commentId (path,required) |
| GET | `/history/historic-process-instances/{processInstanceId}/identitylinks` | List identity links of a historic process instance | processInstanceId (path,required) |
| GET | `/history/historic-process-instances/{processInstanceId}/variables/{variableName}/data` | Get the binary data for a historic process instance variable | processInstanceId (path,required), variableName (path,required) |
| GET | `/history/historic-task-instances` | List historic task instances | taskId (query), processInstanceId (query), processInstanceIdWithChildren (query), withoutProcessInstanceId (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionId (query), processDefinitionName (query), processDefinitionNameLike (query), processBusinessKey (query), processBusinessKeyLike (query), executionId (query), taskDefinitionKey (query), taskDefinitionKeys (query), taskName (query), taskNameLike (query), taskNameLikeIgnoreCase (query), taskDescription (query), taskDescriptionLike (query), taskCategory (query), taskCategoryIn (query), taskCategoryNotIn (query), taskWithoutCategory (query), taskDeleteReason (query), taskDeleteReasonLike (query), taskAssignee (query), taskAssigneeLike (query), taskOwner (query), taskOwnerLike (query), taskInvolvedUser (query), taskCandidateGroup (query), taskPriority (query), finished (query), processFinished (query), parentTaskId (query), dueDate (query), dueDateAfter (query), dueDateBefore (query), withoutDueDate (query), taskCompletedOn (query), taskCompletedAfter (query), taskCompletedBefore (query), taskCreatedOn (query), taskCreatedBefore (query), taskCreatedAfter (query), includeTaskLocalVariables (query), includeProcessVariables (query), scopeDefinitionId (query), scopeId (query), withoutScopeId (query), scopeType (query), propagatedStageInstanceId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), rootScopeId (query), parentScopeId (query) |
| GET | `/history/historic-task-instances/{taskId}` | Get a single historic task instance | taskId (path,required) |
| DELETE | `/history/historic-task-instances/{taskId}` | Delete a historic task instance | taskId (path,required) |
| GET | `/history/historic-task-instances/{taskId}/form` | Get a historic task instance form | taskId (path,required) |
| GET | `/history/historic-task-instances/{taskId}/identitylinks` | List identity links of a historic task instance | taskId (path,required) |
| GET | `/history/historic-task-instances/{taskId}/variables/{variableName}/data` | Get the binary data for a historic task instance variable | taskId (path,required), variableName (path,required), scope (query) |
| GET | `/history/historic-task-log-entries` | List historic task log entries | taskId (query), type (query), userId (query), processInstanceId (query), processDefinitionId (query), scopeId (query), scopeDefinitionId (query), subScopeId (query), scopeType (query), from (query), to (query), tenantId (query), fromLogNumber (query), toLogNumber (query), sort (query), order (query), start (query), size (query) |
| GET | `/history/historic-variable-instances` | List of historic variable instances | processInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (body), order (query), start (query), size (query) |
| GET | `/history/historic-variable-instances/{varInstanceId}/data` | Get the binary data for a historic task instance variable | varInstanceId (path,required) |
| GET | `/identity/groups` | List groups | id (query), name (query), type (query), nameLike (query), member (query), potentialStarter (query), sort (query), order (query), start (query), size (query) |
| POST | `/identity/groups` | Create a group | body (body) |
| GET | `/identity/groups/{groupId}` | Get a single group | groupId (path,required) |
| PUT | `/identity/groups/{groupId}` | Update a group | groupId (path,required), body (body) |
| DELETE | `/identity/groups/{groupId}` | Delete a group | groupId (path,required) |
| POST | `/identity/groups/{groupId}/members` | Add a member to a group | groupId (path,required), body (body) |
| DELETE | `/identity/groups/{groupId}/members/{userId}` | Delete a member from a group | groupId (path,required), userId (path,required) |
| GET | `/identity/users` | List users | id (query), firstName (query), lastName (query), displayName (query), email (query), firstNameLike (query), lastNameLike (query), displayNameLike (query), emailLike (query), memberOfGroup (query), tenantId (query), potentialStarter (query), sort (query), order (query), start (query), size (query) |
| POST | `/identity/users` | Create a user | body (body) |
| GET | `/identity/users/{userId}` | Get a single user | userId (path,required) |
| PUT | `/identity/users/{userId}` | Update a user | userId (path,required), body (body) |
| DELETE | `/identity/users/{userId}` | Delete a user | userId (path,required) |
| GET | `/identity/users/{userId}/info` | List user’s info | userId (path,required) |
| POST | `/identity/users/{userId}/info` | Create a new user’s info entry | userId (path,required), body (body) |
| GET | `/identity/users/{userId}/info/{key}` | Get a user’s info | userId (path,required), key (path,required) |
| PUT | `/identity/users/{userId}/info/{key}` | Update a user’s info | userId (path,required), key (path,required), body (body) |
| DELETE | `/identity/users/{userId}/info/{key}` | Delete a user’s info | userId (path,required), key (path,required) |
| GET | `/identity/users/{userId}/picture` | Get a user’s picture | userId (path,required) |
| PUT | `/identity/users/{userId}/picture` | Updating a user’s picture | userId (path,required), file (formData,required) |
| GET | `/management/batch-parts/{batchPartId}` | Get a single batch part | batchPartId (path,required) |
| GET | `/management/batch-parts/{batchPartId}/batch-part-document` | Get the batch part document | batchPartId (path,required) |
| GET | `/management/batches` | List batches | id (query), batchType (query), searchKey (query), searchKey2 (query), createTimeBefore (query), createTimeAfter (query), completeTimeBefore (query), completeTimeAfter (query), status (query), tenantId (query), tenantIdLike (query), withoutTenantId (query) |
| GET | `/management/batches/{batchId}` | Get a single batch | batchId (path,required) |
| DELETE | `/management/batches/{batchId}` | Delete a batch | batchId (path,required) |
| GET | `/management/batches/{batchId}/batch-document` | Get the batch document | batchId (path,required) |
| GET | `/management/batches/{batchId}/batch-parts` | List batch parts | batchId (path,required), status (query) |
| GET | `/management/deadletter-jobs` | List deadletter jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |
| POST | `/management/deadletter-jobs` | Move a bulk of deadletter jobs. Accepts 'move' and 'moveToHistoryJob' as action. | body (body) |
| GET | `/management/deadletter-jobs/{jobId}` | Get a single deadletter job | jobId (path,required) |
| POST | `/management/deadletter-jobs/{jobId}` | Move a single deadletter job. Accepts 'move' and 'moveToHistoryJob' as action. | jobId (path,required), body (body) |
| DELETE | `/management/deadletter-jobs/{jobId}` | Delete a deadletter job | jobId (path,required) |
| GET | `/management/deadletter-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a deadletter job | jobId (path,required) |
| GET | `/management/engine` | Get engine info |  |
| GET | `/management/engine-properties` | Get all engine properties |  |
| POST | `/management/engine-properties` | Create a new engine property | body (body) |
| PUT | `/management/engine-properties/{engineProperty}` | Update an engine property | engineProperty (path,required), body (body) |
| DELETE | `/management/engine-properties/{engineProperty}` | Delete an engine property | engineProperty (path,required) |
| GET | `/management/history-jobs` | List history jobs | id (query), withException (query), exceptionMessage (query), scopeType (query), handlerType (query), handlerTypes (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), lockOwner (query), locked (query), unlocked (query), sort (query), order (query), start (query), size (query) |
| GET | `/management/history-jobs/{jobId}` | Get a single history job job | jobId (path,required) |
| POST | `/management/history-jobs/{jobId}` | Execute a history job | jobId (path,required), body (body) |
| DELETE | `/management/history-jobs/{jobId}` | Delete a history job | jobId (path,required) |
| GET | `/management/jobs` | List jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |
| GET | `/management/jobs/{jobId}` | Get a single job | jobId (path,required) |
| POST | `/management/jobs/{jobId}` | Execute a single job | jobId (path,required), body (body) |
| DELETE | `/management/jobs/{jobId}` | Delete a job | jobId (path,required) |
| GET | `/management/jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a job | jobId (path,required) |
| GET | `/management/properties` | List engine properties |  |
| GET | `/management/suspended-jobs` | List suspended jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |
| GET | `/management/suspended-jobs/{jobId}` | Get a single suspended job | jobId (path,required) |
| DELETE | `/management/suspended-jobs/{jobId}` | Delete a suspended job | jobId (path,required) |
| GET | `/management/suspended-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a suspended job | jobId (path,required) |
| GET | `/management/tables` | List tables |  |
| GET | `/management/tables/{tableName}` | Get a single table | tableName (path,required) |
| GET | `/management/tables/{tableName}/columns` | Get column info for a single table | tableName (path,required) |
| GET | `/management/tables/{tableName}/data` | Get row data for a single table | tableName (path,required), start (query), size (query), orderAscendingColumn (query), orderDescendingColumn (query) |
| GET | `/management/timer-jobs` | List timer jobs | id (query), processInstanceId (query), withoutProcessInstanceId (query), executionId (query), processDefinitionId (query), elementId (query), elementName (query), handlerType (query), handlerTypes (query), executable (query), timersOnly (query), messagesOnly (query), withException (query), dueBefore (query), dueAfter (query), exceptionMessage (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), locked (query), unlocked (query), withoutScopeId (query), withoutScopeType (query), sort (query), order (query), start (query), size (query) |
| GET | `/management/timer-jobs/{jobId}` | Get a single timer job | jobId (path,required) |
| POST | `/management/timer-jobs/{jobId}` | Execute a single job action (move or reschedule) | jobId (path,required), body (body) |
| DELETE | `/management/timer-jobs/{jobId}` | Delete a timer job | jobId (path,required) |
| GET | `/management/timer-jobs/{jobId}/exception-stacktrace` | Get the exception stacktrace for a timer job | jobId (path,required) |
| POST | `/query/activity-instances` | Query for activity instances | body (body), sort (body) |
| POST | `/query/executions` | Query executions | body (body), sort (body) |
| POST | `/query/historic-activity-instances` | Query for historic activity instances | body (body), sort (body) |
| POST | `/query/historic-detail` | Query for historic details | body (body), sort (body) |
| POST | `/query/historic-process-instances` | Query for historic process instances | body (body), sort (body) |
| POST | `/query/historic-task-instances` | Query for historic task instances | body (body), sort (body) |
| POST | `/query/historic-variable-instances` | Query for historic variable instances | body (body), sort (body) |
| POST | `/query/process-instances` | Query process instances | body (body), sort (body) |
| POST | `/query/tasks` | Query for tasks | body (body), sort (body) |
| POST | `/query/variable-instances` | Query for variable instances | body (body), sort (body) |
| GET | `/repository/deployments` | List Deployments | name (query), nameLike (query), category (query), categoryNotEquals (query), parentDeploymentId (query), parentDeploymentIdLike (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |
| POST | `/repository/deployments` | Create a new deployment | deploymentKey (query), deploymentName (query), tenantId (query), file (formData,required) |
| GET | `/repository/deployments/{deploymentId}` | Get a deployment | deploymentId (path,required) |
| DELETE | `/repository/deployments/{deploymentId}` | Delete a deployment | deploymentId (path,required), cascade (query) |
| GET | `/repository/deployments/{deploymentId}/resourcedata/{resourceName}` | Get a deployment resource content | deploymentId (path,required), resourceName (path,required) |
| GET | `/repository/deployments/{deploymentId}/resources` | List resources in a deployment | deploymentId (path,required) |
| GET | `/repository/deployments/{deploymentId}/resources/**` | Get a deployment resource | deploymentId (path,required) |
| GET | `/repository/models` | List models | id (query), category (query), categoryLike (query), categoryNotEquals (query), name (query), nameLike (query), key (query), deploymentId (query), version (query), latestVersion (query), deployed (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |
| POST | `/repository/models` | Create a model | body (body) |
| GET | `/repository/models/{modelId}` | Get a model | modelId (path,required) |
| PUT | `/repository/models/{modelId}` | Update a model | modelId (path,required), body (body) |
| DELETE | `/repository/models/{modelId}` | Delete a model | modelId (path,required) |
| GET | `/repository/models/{modelId}/source` | Get the editor source for a model | modelId (path,required) |
| PUT | `/repository/models/{modelId}/source` | Set the editor source for a model | modelId (path,required), file (formData,required) |
| GET | `/repository/models/{modelId}/source-extra` | Get the extra editor source for a model | modelId (path,required) |
| PUT | `/repository/models/{modelId}/source-extra` | Set the extra editor source for a model | modelId (path,required), file (formData,required) |
| GET | `/repository/process-definitions` | List of process definitions | version (query), name (query), nameLike (query), nameLikeIgnoreCase (query), key (query), keyLike (query), resourceName (query), resourceNameLike (query), category (query), categoryLike (query), categoryNotEquals (query), deploymentId (query), parentDeploymentId (query), startableByUser (query), latest (query), suspended (query), sort (query), order (query), start (query), size (query) |
| GET | `/repository/process-definitions/{processDefinitionId}` | Get a process definition | processDefinitionId (path,required) |
| PUT | `/repository/process-definitions/{processDefinitionId}` | Execute actions for a process definition | processDefinitionId (path,required), body (body,required) |
| POST | `/repository/process-definitions/{processDefinitionId}/batch-migrate` | Batch migrate all instances of process definition | processDefinitionId (path,required), body (body) |
| GET | `/repository/process-definitions/{processDefinitionId}/decision-tables` | List decision tables for a process-definition | processDefinitionId (path,required) |
| GET | `/repository/process-definitions/{processDefinitionId}/decisions` | List decisions for a process-definition | processDefinitionId (path,required) |
| GET | `/repository/process-definitions/{processDefinitionId}/form-definitions` | List form definitions for a process-definition | processDefinitionId (path,required) |
| GET | `/repository/process-definitions/{processDefinitionId}/identitylinks` | List candidate starters for a process-definition | processDefinitionId (path,required) |
| POST | `/repository/process-definitions/{processDefinitionId}/identitylinks` | Add a candidate starter to a process definition | processDefinitionId (path,required), body (body) |
| GET | `/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}` | Get a candidate starter from a process definition | processDefinitionId (path,required), family (path,required), identityId (path,required) |
| DELETE | `/repository/process-definitions/{processDefinitionId}/identitylinks/{family}/{identityId}` | Delete a candidate starter from a process definition | processDefinitionId (path,required), family (path,required), identityId (path,required) |
| GET | `/repository/process-definitions/{processDefinitionId}/image` | Get a process definition image | processDefinitionId (path,required) |
| POST | `/repository/process-definitions/{processDefinitionId}/migrate` | Migrate all instances of process definition | processDefinitionId (path,required), body (body) |
| GET | `/repository/process-definitions/{processDefinitionId}/model` | Get a process definition BPMN model | processDefinitionId (path,required) |
| GET | `/repository/process-definitions/{processDefinitionId}/resourcedata` | Get a process definition resource content | processDefinitionId (path,required) |
| GET | `/repository/process-definitions/{processDefinitionId}/start-form` | Get a process definition start form | processDefinitionId (path,required) |
| GET | `/runtime/activity-instances` | List activity instances | activityId (query), activityInstanceId (query), activityName (query), activityType (query), executionId (query), finished (query), taskAssignee (query), processInstanceId (query), processDefinitionId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |
| GET | `/runtime/event-subscriptions` | List of event subscriptions | id (query), eventType (query), eventName (query), activityId (query), executionId (query), processInstanceId (query), withoutProcessInstanceId (query), processDefinitionId (query), withoutProcessDefinitionId (query), scopeId (query), subScopeId (query), withoutScopeId (query), scopeDefinitionId (query), withoutScopeDefinitionId (query), createdBefore (query), createdAfter (query), tenantId (query), withoutTenantId (query), configuration (query), withoutConfiguration (query), sort (query), order (query), start (query), size (query) |
| GET | `/runtime/event-subscriptions/{eventSubscriptionId}` | Get a single event subscription | eventSubscriptionId (path,required) |
| GET | `/runtime/executions` | List of executions | id (query), activityId (query), processDefinitionKey (query), processDefinitionId (query), processInstanceId (query), messageEventSubscriptionName (query), signalEventSubscriptionName (query), parentId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), sort (query) |
| PUT | `/runtime/executions` | Signal event received | body (body) |
| GET | `/runtime/executions/{executionId}` | Get an execution | executionId (path,required) |
| PUT | `/runtime/executions/{executionId}` | Execute an action on an execution | executionId (path,required), body (body) |
| GET | `/runtime/executions/{executionId}/activities` | List active activities in an execution | executionId (path,required) |
| POST | `/runtime/executions/{executionId}/change-state` | Change the state of an execution | executionId (path,required), body (body) |
| GET | `/runtime/executions/{executionId}/variables` | List variables for an execution | executionId (path,required), scope (query) |
| POST | `/runtime/executions/{executionId}/variables` | Create variables on an execution | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |
| PUT | `/runtime/executions/{executionId}/variables` | Update variables on an execution | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |
| DELETE | `/runtime/executions/{executionId}/variables` | Delete all variables for an execution | executionId (path,required) |
| POST | `/runtime/executions/{executionId}/variables-async` | Create variables on an execution asynchronously | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |
| PUT | `/runtime/executions/{executionId}/variables-async` | Update variables on an execution asynchronously | executionId (path,required), body (body), name (formData), type (formData), scope (formData) |
| PUT | `/runtime/executions/{executionId}/variables-async/{variableName}` | Update a variable on an execution asynchronously | executionId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |
| GET | `/runtime/executions/{executionId}/variables/{variableName}` | Get a variable for an execution | executionId (path,required), variableName (path,required), scope (query) |
| PUT | `/runtime/executions/{executionId}/variables/{variableName}` | Update a variable on an execution | executionId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData), scope (formData) |
| DELETE | `/runtime/executions/{executionId}/variables/{variableName}` | Delete a variable for an execution | executionId (path,required), variableName (path,required), scope (query) |
| GET | `/runtime/executions/{executionId}/variables/{variableName}/data` | Get the binary data for an execution | executionId (path,required), variableName (path,required), scope (query) |
| GET | `/runtime/process-instances` | List process instances | id (query), name (query), nameLike (query), nameLikeIgnoreCase (query), processDefinitionName (query), processDefinitionNameLike (query), processDefinitionNameLikeIgnoreCase (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionKeyLikeIgnoreCase (query), processDefinitionId (query), processDefinitionCategory (query), processDefinitionCategoryLike (query), processDefinitionCategoryLikeIgnoreCase (query), processDefinitionVersion (query), processDefinitionEngineVersion (query), businessKey (query), businessKeyLike (query), businessKeyLikeIgnoreCase (query), businessStatus (query), businessStatusLike (query), businessStatusLikeIgnoreCase (query), startedBy (query), startedBefore (query), startedAfter (query), activeActivityId (query), involvedUser (query), suspended (query), superProcessInstanceId (query), rootScopeId (query), parentScopeId (query), subProcessInstanceId (query), excludeSubprocesses (query), includeProcessVariables (query), includeProcessVariablesName (query), callbackId (query), callbackType (query), parentCaseInstanceId (query), tenantId (query), tenantIdLike (query), tenantIdLikeIgnoreCase (query), withoutTenantId (query), sort (query), order (query), start (query), size (query) |
| POST | `/runtime/process-instances` | Start a process instance | body (body) |
| POST | `/runtime/process-instances/delete` | Bulk delete process instances | body (body) |
| GET | `/runtime/process-instances/{processInstanceId}` | Get a process instance | processInstanceId (path,required) |
| PUT | `/runtime/process-instances/{processInstanceId}` | Update process instance properties or execute an action on a process instance (body needs to contain an 'action' property for the latter). | processInstanceId (path,required), body (body) |
| DELETE | `/runtime/process-instances/{processInstanceId}` | Delete a process instance | processInstanceId (path,required), deleteReason (query) |
| POST | `/runtime/process-instances/{processInstanceId}/change-state` | Change the state a process instance | processInstanceId (path,required), body (body) |
| GET | `/runtime/process-instances/{processInstanceId}/diagram` | Get diagram for a process instance | processInstanceId (path,required) |
| POST | `/runtime/process-instances/{processInstanceId}/evaluate-conditions` | Evaluate the conditions of a process instance | processInstanceId (path,required) |
| GET | `/runtime/process-instances/{processInstanceId}/identitylinks` | Get involved people for process instance | processInstanceId (path,required) |
| POST | `/runtime/process-instances/{processInstanceId}/identitylinks` | Add an involved user to a process instance | processInstanceId (path,required), body (body) |
| GET | `/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}` | Get a specific involved people from process instance | processInstanceId (path,required), identityId (path,required), type (path,required) |
| DELETE | `/runtime/process-instances/{processInstanceId}/identitylinks/users/{identityId}/{type}` | Remove an involved user to from process instance | processInstanceId (path,required), identityId (path,required), type (path,required) |
| POST | `/runtime/process-instances/{processInstanceId}/inject` | Inject activity in a process instance | processInstanceId (path,required), body (body) |
| POST | `/runtime/process-instances/{processInstanceId}/migrate` | Migrate process instance | processInstanceId (path,required), body (body) |
| GET | `/runtime/process-instances/{processInstanceId}/variables` | List variables for a process instance | processInstanceId (path,required), scope (query) |
| POST | `/runtime/process-instances/{processInstanceId}/variables` | Create variables or new binary variable on a process instance | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |
| PUT | `/runtime/process-instances/{processInstanceId}/variables` | Update a multiple/single (non)binary variable on a process instance | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |
| DELETE | `/runtime/process-instances/{processInstanceId}/variables` | Delete all variables | processInstanceId (path,required) |
| POST | `/runtime/process-instances/{processInstanceId}/variables-async` | Create variables or new binary variable on a process instance asynchronously | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |
| PUT | `/runtime/process-instances/{processInstanceId}/variables-async` | Update multiple/single (non)binary variables on a process instance asynchronously | processInstanceId (path,required), body (body), file (formData), name (formData), type (formData) |
| PUT | `/runtime/process-instances/{processInstanceId}/variables-async/{variableName}` | Update a single variable on a process instance asynchronously | processInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |
| GET | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Get a variable for a process instance | processInstanceId (path,required), variableName (path,required), scope (query) |
| PUT | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Update a single variable on a process instance | processInstanceId (path,required), variableName (path,required), body (body), file (formData), name (formData), type (formData) |
| DELETE | `/runtime/process-instances/{processInstanceId}/variables/{variableName}` | Delete a variable | processInstanceId (path,required), variableName (path,required), scope (query) |
| GET | `/runtime/process-instances/{processInstanceId}/variables/{variableName}/data` | Get the binary data for a variable | processInstanceId (path,required), variableName (path,required), scope (query) |
| POST | `/runtime/signals` | Signal event received | body (body) |
| GET | `/runtime/tasks` | List of tasks | taskId (query), name (query), nameLike (query), nameLikeIgnoreCase (query), description (query), priority (query), minimumPriority (query), maximumPriority (query), assignee (query), assigneeLike (query), owner (query), ownerLike (query), unassigned (query), delegationState (query), candidateUser (query), candidateGroup (query), candidateGroups (query), involvedUser (query), taskDefinitionKey (query), taskDefinitionKeyLike (query), taskDefinitionKeys (query), processInstanceId (query), processInstanceIdWithChildren (query), withoutProcessInstanceId (query), processInstanceBusinessKey (query), processInstanceBusinessKeyLike (query), processDefinitionId (query), processDefinitionKey (query), processDefinitionKeyLike (query), processDefinitionName (query), processDefinitionNameLike (query), executionId (query), createdOn (query), createdBefore (query), createdAfter (query), dueDate (query), dueBefore (query), dueAfter (query), withoutDueDate (query), excludeSubTasks (query), active (query), includeTaskLocalVariables (query), includeProcessVariables (query), scopeDefinitionId (query), scopeId (query), withoutScopeId (query), scopeType (query), propagatedStageInstanceId (query), tenantId (query), tenantIdLike (query), withoutTenantId (query), candidateOrAssigned (query), category (query), categoryIn (query), categoryNotIn (query), withoutCategory (query), rootScopeId (query), parentScopeId (query), sort (query), order (query), start (query), size (query) |
| POST | `/runtime/tasks` | Create Task | body (body) |
| PUT | `/runtime/tasks` | Update Tasks | body (body) |
| GET | `/runtime/tasks/{taskId}` | Get a task | taskId (path,required) |
| POST | `/runtime/tasks/{taskId}` | Tasks actions | taskId (path,required), body (body) |
| PUT | `/runtime/tasks/{taskId}` | Update a task | taskId (path,required), body (body) |
| DELETE | `/runtime/tasks/{taskId}` | Delete a task | taskId (path,required), cascadeHistory (query), deleteReason (query) |
| GET | `/runtime/tasks/{taskId}/attachments` | List attachments on a task | taskId (path,required) |
| POST | `/runtime/tasks/{taskId}/attachments` | Create a new attachment on a task, containing a link to an external resource or an attached file | taskId (path,required), body (body), file (formData), name (formData), description (formData), type (formData) |
| GET | `/runtime/tasks/{taskId}/attachments/{attachmentId}` | Get an attachment on a task | taskId (path,required), attachmentId (path,required) |
| DELETE | `/runtime/tasks/{taskId}/attachments/{attachmentId}` | Delete an attachment on a task | taskId (path,required), attachmentId (path,required) |
| GET | `/runtime/tasks/{taskId}/attachments/{attachmentId}/content` | Get the content for an attachment | taskId (path,required), attachmentId (path,required) |
| GET | `/runtime/tasks/{taskId}/comments` | List comments on a task | taskId (path,required) |
| POST | `/runtime/tasks/{taskId}/comments` | Create a new comment on a task | taskId (path,required), body (body) |
| GET | `/runtime/tasks/{taskId}/comments/{commentId}` | Get a comment on a task | taskId (path,required), commentId (path,required) |
| DELETE | `/runtime/tasks/{taskId}/comments/{commentId}` | Delete a comment on a task | taskId (path,required), commentId (path,required) |
| GET | `/runtime/tasks/{taskId}/events` | List events for a task | taskId (path,required) |
| GET | `/runtime/tasks/{taskId}/events/{eventId}` | Get an event on a task | taskId (path,required), eventId (path,required) |
| DELETE | `/runtime/tasks/{taskId}/events/{eventId}` | Delete an event on a task | taskId (path,required), eventId (path,required) |
| GET | `/runtime/tasks/{taskId}/form` | Get a task form | taskId (path,required) |
| GET | `/runtime/tasks/{taskId}/identitylinks` | List identity links for a task | taskId (path,required) |
| POST | `/runtime/tasks/{taskId}/identitylinks` | Create an identity link on a task | taskId (path,required), body (body) |
| GET | `/runtime/tasks/{taskId}/identitylinks/{family}` | List identity links for a task for either groups or users | taskId (path,required), family (path,required) |
| GET | `/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Get a single identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |
| DELETE | `/runtime/tasks/{taskId}/identitylinks/{family}/{identityId}/{type}` | Delete an identity link on a task | taskId (path,required), family (path,required), identityId (path,required), type (path,required) |
| GET | `/runtime/tasks/{taskId}/subtasks` | List of sub tasks for a task | taskId (path,required) |
| GET | `/runtime/tasks/{taskId}/variables` | List variables for a task | taskId (path,required), scope (query) |
| POST | `/runtime/tasks/{taskId}/variables` | Create new variables on a task | taskId (path,required), body (body), name (formData), type (formData), scope (formData) |
| DELETE | `/runtime/tasks/{taskId}/variables` | Delete all local variables on a task | taskId (path,required) |
| GET | `/runtime/tasks/{taskId}/variables/{variableName}` | Get a variable from a task | taskId (path,required), variableName (path,required), scope (query) |
| PUT | `/runtime/tasks/{taskId}/variables/{variableName}` | Update an existing variable on a task | taskId (path,required), variableName (path,required), body (body), name (formData), type (formData), scope (formData) |
| DELETE | `/runtime/tasks/{taskId}/variables/{variableName}` | Delete a variable on a task | taskId (path,required), variableName (path,required), scope (query) |
| GET | `/runtime/tasks/{taskId}/variables/{variableName}/data` | Get the binary data for a variable | taskId (path,required), variableName (path,required), scope (query) |
| GET | `/runtime/variable-instances` | List of variable instances | processInstanceId (query), taskId (query), excludeTaskVariables (query), excludeLocalVariables (query), variableName (query), variableNameLike (query), sort (query), order (query), start (query), size (query) |
| GET | `/runtime/variable-instances/{varInstanceId}/data` | Get the binary data for a variable instance | varInstanceId (path,required) |

