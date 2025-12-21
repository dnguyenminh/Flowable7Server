package com.example.flowable;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.flowable.cmmn.api.CmmnRepositoryService;
import org.flowable.cmmn.api.CmmnRuntimeService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;

import java.util.List;

/**
 * Small collection of best-effort cleanup utilities used by tests to remove
 * created cases, process instances and deployments. Methods swallow exceptions
 * so cleanup never causes test failures.
 */
public final class TestCleanupHelper {

    private TestCleanupHelper() {}

    // Engine-based helpers
    public static void cleanupCmmnCases(CmmnRuntimeService cmmnRuntimeService, String caseDefinitionKey) {
        if (cmmnRuntimeService == null) return;
        try {
            var list = cmmnRuntimeService.createCaseInstanceQuery().caseDefinitionKey(caseDefinitionKey).list();
            for (var ci : list) {
                try { cmmnRuntimeService.deleteCaseInstance(ci.getId()); } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
    }

    public static void cleanupProcessInstances(RuntimeService runtimeService, String processDefinitionKey) {
        if (runtimeService == null) return;
        try {
            var list = runtimeService.createProcessInstanceQuery().processDefinitionKey(processDefinitionKey).list();
            for (var pi : list) {
                try { runtimeService.deleteProcessInstance(pi.getId(), "test-cleanup"); } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
    }

    public static void deleteDeploymentsByName(RepositoryService repositoryService, String deploymentName, boolean cascade) {
        if (repositoryService == null) return;
        try {
            var list = repositoryService.createDeploymentQuery().deploymentName(deploymentName).list();
            for (var d : list) {
                try { repositoryService.deleteDeployment(d.getId(), cascade); } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
    }

    public static void deleteCmmnDeploymentsByName(CmmnRepositoryService cmmnRepositoryService, String deploymentName, boolean cascade) {
        if (cmmnRepositoryService == null) return;
        try {
            var list = cmmnRepositoryService.createDeploymentQuery().deploymentName(deploymentName).list();
            for (var d : list) {
                try { cmmnRepositoryService.deleteDeployment(d.getId(), cascade); } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}
    }

    // REST-based helpers (best-effort listing + deletion)
    public static void cleanupCmmnCasesRest(String base, String caseDefKey, String user, String pass) {
        try {
            Response r = given().auth().basic(user, pass).get(base + "/cmmn-runtime/case-instances?caseDefinitionKey=" + caseDefKey);
            if (r.getStatusCode() == 200 && sizeFromResponse(r) > 0) {
                var list = r.jsonPath().getList("data") != null ? r.jsonPath().getList("data") : r.jsonPath().getList("rows");
                for (Object o : list) {
                    try {
                        String id = null;
                        try { id = ((java.util.Map) o).get("id").toString(); } catch (Exception ex) {}
                        try { if (id == null) id = ((java.util.Map) o).get("caseInstanceId").toString(); } catch (Exception ex) {}
                        if (id != null) {
                            try { given().auth().basic(user, pass).delete(base + "/cmmn-api/case-instances/" + id); } catch (Exception ex) {}
                        }
                    } catch (Exception ignored) {}
                }
            } else {
                Response p = given().auth().basic(user, pass).contentType("application/json").body("{\"caseDefinitionKey\":\"" + caseDefKey + "\"}").post(base + "/cmmn-api/cmmn-query/case-instances").andReturn();
                if (p.getStatusCode() == 200 && sizeFromResponse(p) > 0) {
                    var list = p.jsonPath().getList("data") != null ? p.jsonPath().getList("data") : p.jsonPath().getList("rows");
                    for (Object o : list) {
                        try {
                            String id = null;
                            try { id = ((java.util.Map) o).get("id").toString(); } catch (Exception ex) {}
                            try { if (id == null) id = ((java.util.Map) o).get("caseInstanceId").toString(); } catch (Exception ex) {}
                            if (id != null) {
                                try { given().auth().basic(user, pass).delete(base + "/cmmn-api/case-instances/" + id); } catch (Exception ex) {}
                            }
                        } catch (Exception ignored) {}
                    }
                }
            }
        } catch (Exception ignored) {}
    }

    public static void cleanupProcessInstancesRest(String base, String processDefKey, String user, String pass) {
        try {
            Response pr = given().auth().basic(user, pass).get(base + "/runtime/process-instances?processDefinitionKey=" + processDefKey);
            if (pr.getStatusCode() == 200 && sizeFromResponse(pr) > 0) {
                var list = pr.jsonPath().getList("data") != null ? pr.jsonPath().getList("data") : pr.jsonPath().getList("rows");
                for (Object o : list) {
                    try {
                        String id = ((java.util.Map) o).get("id").toString();
                        try { given().auth().basic(user, pass).delete(base + "/runtime/process-instances/" + id); } catch (Exception ex) {}
                    } catch (Exception ignored) {}
                }
            }
        } catch (Exception ignored) {}
    }

    public static void deleteDeploymentsRest(String base, String deploymentName, String user, String pass) {
        try {
            Response d = given().auth().basic(user, pass).get(base + "/repository/deployments?deploymentName=" + deploymentName);
            if (d.getStatusCode() == 200 && sizeFromResponse(d) > 0) {
                var list = d.jsonPath().getList("data") != null ? d.jsonPath().getList("data") : d.jsonPath().getList("rows");
                for (Object o : list) {
                    try { String id = ((java.util.Map) o).get("id").toString(); given().auth().basic(user, pass).delete(base + "/repository/deployments/" + id + "?cascade=true"); } catch (Exception ignored) {}
                }
            }
        } catch (Exception ignored) {}
    }

    private static int sizeFromResponse(Response r) {
        if (r == null || r.getStatusCode() != 200) return 0;
        try { var l = r.jsonPath().getList("data"); if (l != null && !l.isEmpty()) return l.size(); } catch (Exception ignored) {}
        try { var l = r.jsonPath().getList("rows"); if (l != null && !l.isEmpty()) return l.size(); } catch (Exception ignored) {}
        try { var l = r.jsonPath().getList(""); if (l != null) return l.size(); } catch (Exception ignored) {}
        return 0;
    }
}
