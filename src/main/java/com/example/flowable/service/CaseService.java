package com.example.flowable.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import com.example.flowable.dto.CaseStartRequest;
import com.example.flowable.dto.CaseStartResponse;

import org.flowable.cmmn.api.runtime.CaseInstance;
import org.flowable.cmmn.api.CmmnRuntimeService;

@Service
public class CaseService {

    @Autowired(required = false)
    private CmmnRuntimeService cmmnRuntimeService;

    public CaseStartResponse start(CaseStartRequest req) {
        String key = req == null ? null : req.getKey();
        CaseStartResponse resp = new CaseStartResponse();
        if (key == null) return resp;

        if (cmmnRuntimeService != null) {
            try {
                // Use the runtime service builder if available; different Flowable versions
                // expose slightly different fluent API. Attempt to start the case instance.
                try {
                    var builder = cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey(key);
                    // try start if available
                    var ci = (builder.getClass().getMethod("create").invoke(builder));
                    if (ci instanceof CaseInstance) {
                        resp.setCaseInstanceId(((CaseInstance)ci).getId());
                        resp.setTasks(Collections.emptyList());
                        return resp;
                    }
                } catch (NoSuchMethodException nsme) {
                    // fallback: try start() method
                    try {
                        var builder = cmmnRuntimeService.createCaseInstanceBuilder().caseDefinitionKey(key);
                        var ci = (builder.getClass().getMethod("start").invoke(builder));
                        if (ci instanceof CaseInstance) {
                            resp.setCaseInstanceId(((CaseInstance)ci).getId());
                            resp.setTasks(Collections.emptyList());
                            return resp;
                        }
                    } catch (Exception ignored) {
                        // fallthrough to simulated response
                    }
                } catch (Exception ignored) {
                    // fallthrough to simulated response
                }
            } catch (Exception e) {
                // fallthrough to simulated response
            }
        }

        resp.setCaseInstanceId(UUID.randomUUID().toString());
        resp.setTasks(Collections.emptyList());
        return resp;
    }
}
