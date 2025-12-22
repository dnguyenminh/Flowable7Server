package com.example.flowable;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

public class FlowableFeignClientCmmnDeploymentTest {

    @Test
    public void findCmmnDeploymentEndpoint_unreachable_returnsNull() {
        String r = FlowableFeignClient.findCmmnDeploymentEndpoint("http://127.0.0.1:1/flowable-rest", "u", "p", "d");
        assertThat(r).isNull();
    }

    @Test
    public void findCmmnDeploymentEndpoint_httpServer_returnsCmmnEndpoint() throws Exception {
        java.net.InetSocketAddress addr = new java.net.InetSocketAddress(0);
        com.sun.net.httpserver.HttpServer s = com.sun.net.httpserver.HttpServer.create(addr, 0);
        try {
            s.createContext("/flowable-rest/cmmn-api/cmmn-repository/deployments", ex -> {
                byte[] body = "[]".getBytes(java.nio.charset.StandardCharsets.UTF_8);
                ex.sendResponseHeaders(200, body.length);
                try (var os = ex.getResponseBody()) {
                    os.write(body);
                }
            });
            s.start();
            int port = s.getAddress().getPort();
            String base = "http://127.0.0.1:" + port + "/flowable-rest";

            String deploymentName = "my-cmmn-deploy";
            String expected = base + "/cmmn-api/cmmn-repository/deployments?deploymentName=" + URLEncoder.encode(deploymentName, StandardCharsets.UTF_8);
            String found = FlowableFeignClient.findCmmnDeploymentEndpoint(base, "u", "p", deploymentName);
            assertThat(found).isEqualTo(expected);
        } finally {
            s.stop(0);
        }
    }
}
