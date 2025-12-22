package com.example.flowable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FlowableFeignClientTest {

    @Test
    public void tryCreateCase_returnsFalseOnUnreachableBase() {
        boolean ok = FlowableFeignClient.tryCreateCase("http://127.0.0.1:1/flowable-rest", "u", "p",
                "{\"caseDefinitionKey\":\"skipTracingCase\",\"businessKey\":\"bk-1\"}");
        assertThat(ok).isFalse();
    }

    @Test
    public void tryCompleteTask_returnsFalseOnUnreachableBase() {
        boolean ok = FlowableFeignClient.tryCompleteTask("http://127.0.0.1:1/flowable-rest", "u", "p", "tid", "pid");
        assertThat(ok).isFalse();
    }

    @Test
    public void tryCompleteTask_handlesNullPlanItemId() {
        boolean ok = FlowableFeignClient.tryCompleteTask("http://127.0.0.1:1/flowable-rest", "u", "p", "tid", null);
        assertThat(ok).isFalse();
    }
}
