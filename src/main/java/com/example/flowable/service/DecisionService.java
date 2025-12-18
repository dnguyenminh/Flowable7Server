package com.example.flowable.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.flowable.dto.DecisionEvaluateRequest;
import com.example.flowable.dto.DecisionResult;

@Service
public class DecisionService {

    public List<DecisionResult> evaluate(DecisionEvaluateRequest req) {
        if (req == null || req.getDecisionKey() == null) return Collections.emptyList();
        String key = req.getDecisionKey();
        Map<String,Object> vars = req.getVariables() == null ? Collections.emptyMap() : req.getVariables();
        if ("isAdult".equals(key)) {
            Object ageObj = vars.get("age");
            int age = 0; try { if (ageObj != null) age = Integer.parseInt(ageObj.toString()); } catch (Exception ignored) {}
            return List.of(new DecisionResult(Map.of("isAdult", age >= 18)));
        }
        return Collections.emptyList();
    }
}
