package com.example.flowable;

import org.junit.jupiter.api.Test;

public class FlowableTestUtilsAwaitPostTest {

    @Test
    public void awaitForPostListSize_feignPostSucceeds() throws Exception {
        java.net.InetSocketAddress addr = new java.net.InetSocketAddress(0);
        com.sun.net.httpserver.HttpServer s = com.sun.net.httpserver.HttpServer.create(addr, 0);
        try {
            s.createContext("/flowable-rest/cmmn-api/cmmn-query/historic-case-instances", ex -> {
                String body = "{\"data\":[{\"businessKey\":\"123\"},{\"businessKey\":\"456\"}]}";
                byte[] bytes = body.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                ex.getResponseHeaders().add("Content-Type", "application/json");
                ex.sendResponseHeaders(200, bytes.length);
                try (var os = ex.getResponseBody()) { os.write(bytes); }
            });
            s.start();
            int port = s.getAddress().getPort();
            String base = "http://127.0.0.1:" + port + "/flowable-rest";

            // This should not throw; Feign POST will return JSON with data size >= 1
            FlowableTestUtils.awaitForPostListSize(base, "/cmmn-api/cmmn-query/historic-case-instances", "{\"caseDefinitionKey\":\"skipTracingCase\"}", "u", "p", 1, java.time.Duration.ofSeconds(5));
        } finally {
            s.stop(0);
        }
    }
}
