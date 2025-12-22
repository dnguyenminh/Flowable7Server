package com.example.flowable;

import org.junit.jupiter.api.Test;

public class FlowableTestUtilsHistoryAwaitTest {

    @Test
    public void awaitForListSize_feignProcessHistorySucceeds() throws Exception {
        java.net.InetSocketAddress addr = new java.net.InetSocketAddress(0);
        com.sun.net.httpserver.HttpServer s = com.sun.net.httpserver.HttpServer.create(addr, 0);
        try {
            s.createContext("/flowable-rest/history/historic-process-instances", ex -> {
                String body = "{\"data\":[{\"id\":\"p1\"}]}";
                byte[] bytes = body.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                ex.getResponseHeaders().add("Content-Type", "application/json");
                ex.sendResponseHeaders(200, bytes.length);
                try (var os = ex.getResponseBody()) { os.write(bytes); }
            });
            s.start();
            int port = s.getAddress().getPort();
            String base = "http://127.0.0.1:" + port + "/flowable-rest";

            FlowableTestUtils.awaitForListSize(base, "/history/historic-process-instances?processDefinitionKey=proc", "u", "p", 1, java.time.Duration.ofSeconds(5));
        } finally {
            s.stop(0);
        }
    }

    @Test
    public void awaitForListSize_feignVariableHistorySucceeds() throws Exception {
        java.net.InetSocketAddress addr = new java.net.InetSocketAddress(0);
        com.sun.net.httpserver.HttpServer s = com.sun.net.httpserver.HttpServer.create(addr, 0);
        try {
            s.createContext("/flowable-rest/history/historic-variable-instances", ex -> {
                String body = "{\"data\":[{\"name\":\"assignmentList\"}]}";
                byte[] bytes = body.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                ex.getResponseHeaders().add("Content-Type", "application/json");
                ex.sendResponseHeaders(200, bytes.length);
                try (var os = ex.getResponseBody()) { os.write(bytes); }
            });
            s.start();
            int port = s.getAddress().getPort();
            String base = "http://127.0.0.1:" + port + "/flowable-rest";

            FlowableTestUtils.awaitForListSize(base, "/history/historic-variable-instances?variableName=assignmentList", "u", "p", 1, java.time.Duration.ofSeconds(5));
        } finally {
            s.stop(0);
        }
    }
}
