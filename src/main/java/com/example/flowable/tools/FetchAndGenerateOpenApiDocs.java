package com.example.flowable.tools;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Fetches OpenAPI spec files (or discovers them from Swagger UI HTML pages),
 * saves JSON into docs/openapi/server_fetch, then runs the existing
 * `scripts/generate_swagger_md.js` and splits module markdowns using
 * SplitSwaggerMdByPath.
 *
 * Usage:
 *   mvn -DskipTests compile exec:java -Dexec.mainClass="com.example.flowable.tools.FetchAndGenerateOpenApiDocs"
 * or run with args: <user> <pass> [mode]
 */
public class FetchAndGenerateOpenApiDocs {

    private static final String[] DOC_LINKS = new String[] {
        "http://localhost:32988/flowable-rest/docs/?url=specfile/process/flowable-swagger-process.json#",
        "http://localhost:32988/flowable-rest/docs/?url=specfile/idm/flowable-swagger-idm.json#",
        "http://localhost:32988/flowable-rest/docs/?url=specfile/dmn/flowable-swagger-decision.json#",
        "http://localhost:32988/flowable-rest/docs/?url=specfile/eventregistry/flowable-swagger-eventregistry.json#",
        "http://localhost:32988/flowable-rest/docs/?url=specfile/app/flowable-swagger-app.json#",
        "http://localhost:32988/flowable-rest/docs/?url=specfile/external-worker/flowable-swagger-external-worker.json#"
    };

    private final HttpClient client;
    private final String user;
    private final String pass;
    private final Path serverFetchDir;
    private final ObjectMapper om = new ObjectMapper();

    public FetchAndGenerateOpenApiDocs(String user, String pass) throws IOException {
        this.user = user;
        this.pass = pass;
        this.client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
        this.serverFetchDir = Paths.get("docs", "openapi", "server_fetch");
        Files.createDirectories(serverFetchDir);
    }

    public static void main(String[] args) throws Exception {
        String user = args.length > 0 ? args[0] : "rest-admin";
        String pass = args.length > 1 ? args[1] : "test";
        // default to 'full' so request/response structures and samples are included
        String mode = args.length > 2 ? args[2] : "full";
        // any additional args after mode are treated as extra doc URLs to fetch
        List<String> extraLinks = new ArrayList<>();
        if (args.length > 3) {
            for (int i = 3; i < args.length; i++) extraLinks.add(args[i]);
        }

        FetchAndGenerateOpenApiDocs tool = new FetchAndGenerateOpenApiDocs(user, pass);
        tool.fetchAllAndGenerate(mode, extraLinks);
    }

    public void fetchAllAndGenerate(String mode, List<String> extraLinks) throws Exception {
        Set<URI> discovered = new HashSet<>();

        for (String link : DOC_LINKS) {
            // if extraLinks provided, skip falling back until after DOC_LINKS processed
            URI uri = URI.create(link);
            try {
                System.err.println("Fetching docs page: " + uri);
                FetchResult r = fetchWithAuth(uri);
                if (r.isJson()) {
                    Path out = saveJson(uri, r.body);
                    discovered.add(out.toUri());
                } else if (r.isHtml()) {
                    // try to extract json links from HTML
                    List<URI> links = extractJsonLinks(uri, r.body);
                    for (URI l : links) {
                        try {
                            System.err.println("Found JSON link in HTML: " + l);
                            FetchResult rr = fetchWithAuth(l);
                            if (rr.isJson()) {
                                Path out = saveJson(l, rr.body);
                                discovered.add(out.toUri());
                            } else if (rr.isHtml()) {
                                // attempt to extract embedded JSON
                                Path out = tryExtractEmbeddedJson(rr.body, l);
                                if (out != null) discovered.add(out.toUri());
                            }
                        } catch (Exception e) {
                            System.err.println("Failed to fetch discovered json: " + e.getMessage());
                        }
                    }
                    // also try to extract embedded JSON from the original HTML page
                    Path emb = tryExtractEmbeddedJson(r.body, uri);
                    if (emb != null) discovered.add(emb.toUri());
                }
                    // As a fallback, if the original URI had a 'url=' query param pointing
                    // at a specfile, try to fetch that spec directly (some servers redirect
                    // the docs page to a single spec and do not expose others via HTML links).
                    try {
                        Pattern p = Pattern.compile("[?&]url=([^#&]+)", Pattern.CASE_INSENSITIVE);
                        Matcher m = p.matcher(uri.toString());
                        if (m.find()) {
                            String specPath = m.group(1);
                            URI direct = URI.create(uri.getScheme() + "://" + uri.getHost() + (uri.getPort() != -1 ? ":" + uri.getPort() : "") + uri.getPath() + specPath);
                            System.err.println("Attempting direct fetch of spec: " + direct);
                            FetchResult dr = fetchWithAuth(direct);
                            if (dr.isJson()) {
                                Path out = saveJson(direct, dr.body);
                                discovered.add(out.toUri());
                            }
                        }
                    } catch (Exception ignored) {}
            } catch (Exception ex) {
                System.err.println("Failed to fetch " + uri + " : " + ex.getMessage());
            }
        }

        // Fetch any explicit additional URLs provided on the command line
        if (extraLinks != null) {
            for (String lnk : extraLinks) {
            try {
                URI uri = URI.create(lnk);
                System.err.println("Fetching extra docs page: " + uri);
                FetchResult r = fetchWithAuth(uri);
                if (r.isJson()) {
                    Path out = saveJson(uri, r.body);
                    discovered.add(out.toUri());
                } else if (r.isHtml()) {
                    List<URI> links = extractJsonLinks(uri, r.body);
                    for (URI u : links) {
                        try {
                            FetchResult rr = fetchWithAuth(u);
                            if (rr.isJson()) {
                                Path out = saveJson(u, rr.body);
                                discovered.add(out.toUri());
                            } else if (rr.isHtml()) {
                                Path out = tryExtractEmbeddedJson(rr.body, u);
                                if (out != null) discovered.add(out.toUri());
                            }
                        } catch (Exception ex) { System.err.println("Failed to fetch discovered json: " + ex.getMessage()); }
                    }
                    Path emb = tryExtractEmbeddedJson(r.body, uri);
                    if (emb != null) discovered.add(emb.toUri());
                }
            } catch (Exception ex) { System.err.println("Failed to fetch extra link " + lnk + " : " + ex.getMessage()); }
            }
        }

        // Now call the node generator (existing script)
        System.err.println("Running generate_swagger_md.js (node)");
        // Ensure any embedded or generically-named JSON specs are mapped to names
        // that the Node generator expects (flowable-swagger-<module>.json)
        ensureNamedSpecFiles();
        ProcessBuilder pb = new ProcessBuilder("node", "scripts/generate_swagger_md.js");
        pb.inheritIO();
        Process p = pb.start();
        int rc = p.waitFor();
        if (rc != 0) throw new RuntimeException("generate_swagger_md.js failed: rc=" + rc);

        // Split each generated module markdown
        System.err.println("Splitting module markdown files (mode=" + mode + ")");
        Files.list(Paths.get("docs","openapi")).filter(pf -> pf.getFileName().toString().startsWith("flowable-swagger-") && pf.getFileName().toString().endsWith(".md")).forEach(md -> {
            try {
                System.err.println("Splitting " + md);
                SplitSwaggerMdByPath.main(new String[]{ md.toString(), "--mode=" + mode });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        System.err.println("Done. Generated and split docs are under docs/openapi and docs/openapi/split/");
    }

    /**
     * Map any saved JSON specs in server_fetch that are not already named
     * `flowable-swagger-*.json` to a reasonable module name based on either
     * their existing filename, their `info.title` or the paths they contain.
     */
    private void ensureNamedSpecFiles() {
        try {
            Files.list(serverFetchDir).filter(p -> p.getFileName().toString().endsWith(".json")).forEach(p -> {
                String fn = p.getFileName().toString();
                if (fn.startsWith("flowable-swagger-")) return; // already good
                try {
                    String raw = Files.readString(p, StandardCharsets.UTF_8);
                    JsonNode n = om.readTree(raw);
                    String mod = null;
                    // try info.title
                    if (n.has("info") && n.path("info").has("title")) {
                        String t = n.path("info").path("title").asText("");
                        if (t.toLowerCase().contains("cmmn")) mod = "cmmn";
                        else if (t.toLowerCase().contains("process")) mod = "process";
                        else if (t.toLowerCase().contains("decision") || t.toLowerCase().contains("dmn")) mod = "decision";
                        else if (t.toLowerCase().contains("idm") || t.toLowerCase().contains("identity")) mod = "idm";
                        else if (t.toLowerCase().contains("app")) mod = "app";
                        else if (t.toLowerCase().contains("event")) mod = "eventregistry";
                    }
                    // try to inspect paths
                    if (mod == null && n.has("paths")) {
                        Iterator<String> it = n.path("paths").fieldNames();
                        while (it.hasNext() && mod == null) {
                            String pth = it.next();
                            if (pth.startsWith("/cmmn")) mod = "cmmn";
                            else if (pth.startsWith("/process") || pth.contains("/runtime")) mod = "process";
                            else if (pth.contains("/decision") || pth.contains("/dmn")) mod = "decision";
                            else if (pth.contains("/idm")) mod = "idm";
                            else if (pth.contains("/app")) mod = "app";
                            else if (pth.contains("/event")) mod = "eventregistry";
                        }
                    }
                    if (mod == null) {
                        // fallback: use hash-based name to avoid collisions
                        mod = "embedded-" + Math.abs(raw.hashCode());
                    }
                    Path tgt = serverFetchDir.resolve("flowable-swagger-" + mod + ".json");
                    if (!Files.exists(tgt)) {
                        Files.copy(p, tgt);
                        System.err.println("Mapped " + p.getFileName() + " -> " + tgt.getFileName());
                    }
                } catch (Exception ex) {
                    System.err.println("Failed to map spec file " + p + " : " + ex.getMessage());
                }
            });
        } catch (IOException e) {
            System.err.println("Failed to enumerate server_fetch: " + e.getMessage());
        }
    }

    private FetchResult fetchWithAuth(URI uri) throws IOException, InterruptedException {
        HttpRequest req = HttpRequest.newBuilder().uri(uri)
            .timeout(Duration.ofSeconds(20))
            .header("Authorization", "Basic " + Base64.getEncoder().encodeToString((user + ":" + pass).getBytes(StandardCharsets.UTF_8)))
            .header("Accept", "application/json,text/html;q=0.9,application/*+json;q=0.8")
            .GET().build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        String ct = resp.headers().firstValue("content-type").orElse("");
        return new FetchResult(uri, resp.statusCode(), ct, resp.body());
    }

    private Path saveJson(URI src, String body) {
        // normalize name
        String name = Paths.get(src.getPath()).getFileName().toString();
        if (name == null || name.isBlank()) name = "spec.json";
        Path out = serverFetchDir.resolve(name);
        try {
            // validate JSON
            JsonNode n = om.readTree(body);
            // pretty write
            Files.writeString(out, om.writerWithDefaultPrettyPrinter().writeValueAsString(n), StandardCharsets.UTF_8);
            System.err.println("Saved JSON: " + out);
            return out;
        } catch (Exception e) {
            // write raw for inspection
            try { Files.writeString(out, body, StandardCharsets.UTF_8); } catch (IOException ioe) { throw new UncheckedIOException(ioe); }
            System.err.println("Saved (raw) JSON to: " + out + " (parse failed: " + e.getMessage() + ")");
            return out;
        }
    }

    private List<URI> extractJsonLinks(URI base, String html) {
        List<URI> out = new ArrayList<>();
        Document doc = Jsoup.parse(html, base.toString());
        // href/src links
        doc.select("a[href], link[href], script[src]").forEach(el -> {
            String href = el.hasAttr("href") ? el.attr("href") : el.attr("src");
            if (href != null && href.toLowerCase().contains(".json")) {
                try { out.add(URI.create(href).isAbsolute() ? URI.create(href) : base.resolve(href)); } catch (Exception ignored) {}
            }
        });
        // look for ?url= query parameters inside html
        Pattern p = Pattern.compile("[?&]url=([^\"'&<>\\)]+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(html);
        while (m.find()) {
            try { out.add(base.resolve(URI.create(m.group(1)))); } catch (Exception ignored) {}
        }
        return out;
    }

    private Path tryExtractEmbeddedJson(String html, URI base) {
        Document doc = Jsoup.parse(html);
        // check for <script type="application/json"> or inline script containing openapi
        for (var s : doc.select("script")) {
            String type = s.attr("type");
            String text = s.html();
            if ("application/json".equalsIgnoreCase(type) || text.contains("openapi") || text.contains("swagger")) {
                // attempt to find JSON substring
                int idx = Math.max(text.indexOf("openapi"), text.indexOf("swagger"));
                if (idx < 0) idx = 0;
                int from = text.lastIndexOf('{', idx);
                if (from >= 0) {
                    int stack = 0;
                    int end = -1;
                    for (int i = from; i < text.length(); i++) {
                        char c = text.charAt(i);
                        if (c == '{') stack++; else if (c == '}') { stack--; if (stack == 0) { end = i; break; } }
                    }
                    if (end > from) {
                        String json = text.substring(from, end + 1);
                        try {
                            JsonNode obj = om.readTree(json);
                            String outname = "embedded-" + Math.abs(json.hashCode()) + ".json";
                            Path out = serverFetchDir.resolve(outname);
                            Files.writeString(out, om.writerWithDefaultPrettyPrinter().writeValueAsString(obj), StandardCharsets.UTF_8);
                            System.err.println("Extracted embedded JSON to " + out);
                            return out;
                        } catch (Exception ex) {
                            // ignore parse errors
                        }
                    }
                }
            }
        }
        return null;
    }

    private static final class FetchResult {
        final URI uri; final int status; final String contentType; final String body;
        FetchResult(URI uri, int status, String contentType, String body) { this.uri = uri; this.status = status; this.contentType = contentType; this.body = body; }
        boolean isJson() { return contentType != null && contentType.toLowerCase().contains("json") || looksLikeJson(body); }
        boolean isHtml() { return contentType != null && contentType.toLowerCase().contains("html") || body != null && body.trim().toLowerCase().startsWith("<!doctype"); }
        static boolean looksLikeJson(String s) { if (s == null) return false; s = s.trim(); return s.startsWith("{") || s.startsWith("["); }
    }
}
