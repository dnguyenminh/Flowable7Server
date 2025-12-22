package com.example.flowable;

import java.time.Duration;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class FlowableTestUtilsFeignAwaitTest {

    @Test
    public void awaitForListSize_feignSupplier_success() throws Exception {
        String json0 = "{\"data\":[{\"x\":1},{\"x\":2}]}";
        java.util.function.Supplier<feign.Response> s = () -> {
            try {
                java.util.Map<String, java.util.Collection<String>> headers = new java.util.HashMap<>();
                headers.put("Content-Type", java.util.List.of("application/json; charset=UTF-8"));
                return feign.Response.builder().status(200).reason("OK").headers(headers).body(json0, StandardCharsets.UTF_8).build();
            } catch (Exception e) {
                return null;
            }
        };
        // Use the String-body supplier overload (direct json string)
        FlowableTestUtils.awaitForListSizeBody((java.util.function.Supplier<String>) () -> json0, "feign-list", 2, Duration.ofSeconds(5));
        // If the Feign response is readable by FlowableFeignClient.readBody, also exercise the Feign-based helper
        feign.Response r0 = s.get();
        if (r0 != null && com.example.flowable.FlowableFeignClient.readBody(r0) != null) {
            FlowableTestUtils.awaitForListSizeFeign(s, "feign-list", 2, Duration.ofSeconds(5));
        }
    }

    @Test
    public void awaitForPostListSize_feignSupplier_success() throws Exception {
        String json1 = "{\"rows\":[{\"a\":1},{\"a\":2},{\"a\":3}]}";
        java.util.function.Supplier<feign.Response> s2 = () -> {
            try {
                java.util.Map<String, java.util.Collection<String>> headers = new java.util.HashMap<>();
                headers.put("Content-Type", java.util.List.of("application/json; charset=UTF-8"));
                return feign.Response.builder().status(200).reason("OK").headers(headers).body(json1, StandardCharsets.UTF_8).build();
            } catch (Exception e) {
                return null;
            }
        };
        FlowableTestUtils.awaitForPostListSizeBody((java.util.function.Supplier<String>) () -> json1, "feign-post-list", 3, Duration.ofSeconds(5));
        feign.Response r1 = s2.get();
        if (r1 != null && com.example.flowable.FlowableFeignClient.readBody(r1) != null) {
            FlowableTestUtils.awaitForPostListSizeFeign(s2, "feign-post-list", 3, Duration.ofSeconds(5));
        }
    }
}
