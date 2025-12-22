package com.example.flowable.tools;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * Small utility to split a large Swagger-generated Markdown file into smaller
 * per-path-prefix Markdown files. It mirrors the behavior of the Python
 * script `scripts/split_swagger_md_by_path.py` used in the project.
 *
 * Usage:
 *   mvn exec:java -Dexec.mainClass="com.example.flowable.tools.SplitSwaggerMdByPath" -Dexec.args="<input.md>"
 */
public class SplitSwaggerMdByPath {

    private static final Pattern HEADER_RE = Pattern.compile("^(#{1,6})\\s*(.*)");
    private static final Pattern TABLE_HEADER_RE = Pattern.compile("\\|\\s*Method\\s*\\|\\s*Path\\s*\\|", Pattern.CASE_INSENSITIVE);
    private static final Pattern TABLE_ROW_RE = Pattern.compile("\\|\\s*([^|]+)\\s*\\|\\s*([^|]+)\\s*\\|\\s*([^|]*)\\s*\\|\\s*([^|]*)\\s*\\|?");
    private static final Pattern INLINE_PATH_RE = Pattern.compile("`(GET|POST|PUT|DELETE|PATCH)?\\s*(/[^`\\s\\)]*)`", Pattern.CASE_INSENSITIVE);
    private static final Pattern VERB_PATH_RE = Pattern.compile("^(GET|POST|PUT|DELETE|PATCH)\\s+([^\\s]+)", Pattern.CASE_INSENSITIVE);

    enum Mode { MINIMAL, EXAMPLES, FULL }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: SplitSwaggerMdByPath <input.md> [--mode=minimal|examples|full]");
            System.exit(2);
        }

        Path input = Paths.get(args[0]);
        Mode mode = Mode.EXAMPLES;
        for (int ai = 1; ai < args.length; ai++) {
            String a = args[ai];
            if (a.startsWith("--mode=")) {
                String mv = a.substring("--mode=".length()).trim().toLowerCase();
                if (mv.equals("minimal")) mode = Mode.MINIMAL;
                else if (mv.equals("examples")) mode = Mode.EXAMPLES;
                else if (mv.equals("full")) mode = Mode.FULL;
            }
        }
        if (!Files.exists(input) || !Files.isRegularFile(input)) {
            System.err.println("Input not found: " + input.toAbsolutePath());
            System.exit(3);
        }

        Path outdir = input.getParent().resolve("split");
        Files.createDirectories(outdir);

        String text = Files.readString(input, StandardCharsets.UTF_8);
        String moduleHeader = extractFirstHeader(text);

        List<String> lines = List.of(text.split("\n"));

        Map<String, List<Entry>> groups = new LinkedHashMap<>();
        Map<String, String> opDetails = new LinkedHashMap<>();

        // First pass: collect '### METHOD /path' detailed blocks
        Pattern opHdr = Pattern.compile("^###\\s*(GET|POST|PUT|DELETE|PATCH|OPTIONS|HEAD)\\s+(`?)([^`\\s]+)\\2", Pattern.CASE_INSENSITIVE);
        for (int j = 0; j < lines.size(); j++) {
            String line = lines.get(j);
            Matcher mh = opHdr.matcher(line);
            if (mh.find()) {
                String method = mh.group(1).toUpperCase();
                String path = mh.group(3);
                String key = method + " " + path;
                StringBuilder buf = new StringBuilder();
                int k = j + 1;
                while (k < lines.size()) {
                    String l = lines.get(k);
                    if (l.startsWith("### ")) break;
                    buf.append(l).append('\n');
                    k++;
                }
                opDetails.put(key, buf.toString().trim());
            }
        }

        String lastSection = "";
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            Matcher hdr = HEADER_RE.matcher(line);
            if (hdr.find()) {
                lastSection = hdr.group(2).trim();
                continue;
            }

            if (TABLE_HEADER_RE.matcher(line).find()) {
                // skip separator line(s) after header
                i++;
                while (i < lines.size() && lines.get(i).trim().matches("^\\|?-?-.*")) {
                    i++;
                }
                // collect contiguous table rows
                while (i < lines.size() && lines.get(i).trim().startsWith("|")) {
                    String row = lines.get(i).trim();
                    String key = pathKeyFromTableRow(row);
                    if (key == null) {
                        key = fallbackKeyFromLine(row);
                    }
                    if (key == null) key = "misc";

                    // extract method and path from the table row to attach op details
                    String details = null;
                    Matcher rowM = TABLE_ROW_RE.matcher(row);
                    if (rowM.find()) {
                        String methodCol = rowM.group(1).trim();
                        String pathCol = rowM.group(2).trim();
                        // clean path (remove backticks, trailing HTTP/1.1)
                        pathCol = pathCol.replaceAll("^`|`$", "");
                        pathCol = pathCol.replaceAll("\\s+HTTP/\\d\\.\\d$", "");
                        String opKey = methodCol.toUpperCase() + " " + pathCol;
                        if (opDetails.containsKey(opKey)) details = opDetails.get(opKey);
                        else if (opDetails.containsKey(pathCol)) details = opDetails.get(pathCol);
                        else {
                            // try normalized path without prefix
                            String norm = pathCol.replaceFirst("^/flowable-rest", "");
                            if (opDetails.containsKey(methodCol.toUpperCase() + " " + norm)) details = opDetails.get(methodCol.toUpperCase() + " " + norm);
                        }
                    }

                    groups.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(lastSection, row, details));
                    i++;
                }
                i--; // adjust loop
                continue;
            }

            Matcher inline = INLINE_PATH_RE.matcher(line);
            if (inline.find()) {
                String path = inline.group(2);
                String key = pathPrefixKey(path);
                groups.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(lastSection, line.trim(), null));
                continue;
            }

            // Some docs include bare lines like 'GET /path HTTP/1.1'
            Matcher vp = VERB_PATH_RE.matcher(line.trim());
            if (vp.find()) {
                String path = vp.group(2);
                String key = pathPrefixKey(path);
                groups.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(lastSection, line.trim(), null));
            }
        }

        // Try to load companion OpenAPI JSON (server_fetch/<basename>.json) to enrich outputs
        JsonNode openapiJson = null;
        try {
            Path sf = input.getParent().resolve("server_fetch").resolve(input.getFileName().toString().replaceAll("\\.md$",".json"));
            if (Files.exists(sf)) {
                ObjectMapper om = new ObjectMapper();
                openapiJson = om.readTree(sf.toFile());
                System.err.println("Loaded OpenAPI JSON: " + sf);
            }
        } catch (Exception ex) {
            System.err.println("Failed to load companion OpenAPI JSON: " + ex.getMessage());
        }

        // Keep track of files we generate so we can prune stale files later
        final java.util.Set<String> expectedFiles = new java.util.HashSet<>();

        // Write out files
        // Merge small or unhelpful groups into a 'misc' group so we don't produce
        // per-letter or meaningless files (e.g., 'a', 'all', 'action').
        final int MIN_ENTRIES = 3;
        final java.util.Set<String> BLACKLIST = java.util.Set.of("a", "an", "the", "all", "action");
        List<String> toMerge = new ArrayList<>();
        for (Map.Entry<String, List<Entry>> me : new ArrayList<>(groups.entrySet())) {
            String k = me.getKey();
            List<Entry> list = me.getValue();
            if (k == null) continue;
            String lk = k.toLowerCase();
            if (lk.length() <= 1 || BLACKLIST.contains(lk) || list.size() < MIN_ENTRIES) {
                if (!"misc".equals(k)) toMerge.add(k);
            }
        }
        if (!toMerge.isEmpty()) {
            List<Entry> misc = groups.computeIfAbsent("misc", k -> new ArrayList<>());
            for (String k : toMerge) {
                List<Entry> moved = groups.remove(k);
                if (moved != null) misc.addAll(moved);
                System.err.println("Merged small/unused group '" + k + "' into 'misc'");
            }
        }
        for (Map.Entry<String, List<Entry>> e : groups.entrySet()) {
            String key = sanitizeFileName(e.getKey());
            Path out = outdir.resolve(input.getFileName().toString() + "-" + key + ".md");
            List<String> outLines = new ArrayList<>();
            outLines.add("# " + input.getFileName().toString() + " — " + key + " (" + key + ")");
            outLines.add("\n> Generated subset extracted from " + input.getFileName().toString());

            String currentSection = null;
            for (Entry en : e.getValue()) {
                if (!en.section.equals(currentSection)) {
                    outLines.add("");
                    if (!en.section.isBlank()) outLines.add("## " + en.section);
                    outLines.add("");
                    outLines.add("| Method | Path | Summary | Params |");
                    outLines.add("|---|---|---|---|");
                    currentSection = en.section;
                }

                // Normalize the row
                String row = en.row;
                if (row.startsWith("|")) {
                    outLines.add(row);
                    // append any attached details (from ### op blocks)
                    if (en.details != null && !en.details.isEmpty()) {
                        outLines.add("");
                        for (String dl : en.details.split("\n")) outLines.add(dl);
                    }
                    // If we have OpenAPI JSON available, enrich the pipe table rows with examples
                    if (openapiJson != null) {
                        // avoid duplicating if details already contain request/response info
                        String det = en.details == null ? "" : en.details;
                        if (!det.contains("**Responses**") && !det.contains("**Request**") && !det.contains("| Name | In |")) {
                            Matcher tr = TABLE_ROW_RE.matcher(row);
                            if (tr.find()) {
                                String methodCol = tr.group(1).trim();
                                String pathCol = tr.group(2).trim().replaceAll("^`|`$", "").replaceAll("\\s+HTTP/\\d\\.\\d$", "");
                                String method = methodCol.toUpperCase();
                                String path = pathCol;
                                OpResult or = findOperation(openapiJson, method, path);
                                if (or != null && or.opNode != null) {
                                    JsonNode opNode = or.opNode;
                                    List<JsonNode> collectedParams = new ArrayList<>();
                                    if (or.pathNode != null) {
                                        JsonNode pp = or.pathNode.path("parameters");
                                        if (pp.isArray()) pp.forEach(collectedParams::add);
                                    }
                                    JsonNode opParams = opNode.path("parameters");
                                    if (opParams.isArray()) opParams.forEach(collectedParams::add);
                                    if ((mode == Mode.EXAMPLES || mode == Mode.FULL) && !collectedParams.isEmpty()) {
                                        List<String> paramTable = buildParametersTableFromList(collectedParams, openapiJson);
                                        outLines.addAll(paramTable);
                                    }
                                    JsonNode req = opNode.path("requestBody");
                                    if (req.isMissingNode()) {
                                        for (JsonNode pnode : collectedParams) {
                                            if (pnode.path("in").asText("").equals("body")) { req = pnode; break; }
                                        }
                                    }
                                    String reqExample = null;
                                    if (!req.isMissingNode()) {
                                        reqExample = exampleForRequest(req, openapiJson);
                                        if (reqExample == null && (mode == Mode.FULL || mode == Mode.EXAMPLES)) {
                                            JsonNode schema = req.path("content").path("application/json").path("schema");
                                            if (!schema.isMissingNode()) {
                                                JsonNode sample = generatePopulatedExample(schema, openapiJson);
                                                reqExample = prettyJson(sample);
                                            }
                                        }
                                    }
                                    if (reqExample != null && (mode == Mode.EXAMPLES || mode == Mode.FULL)) {
                                        outLines.add("");
                                        outLines.add("#### Request");
                                        outLines.add("```json");
                                        outLines.add(reqExample);
                                        outLines.add("```");
                                    }
                                    JsonNode responses = opNode.path("responses");
                                    if (!responses.isMissingNode() && responses.fieldNames().hasNext()) {
                                        outLines.add("");
                                        outLines.add("#### Responses");
                                        for (Iterator<String> it = responses.fieldNames(); it.hasNext(); ) {
                                            String code = it.next();
                                            JsonNode resp = responses.path(code);
                                            String desc = resp.path("description").asText("");
                                            outLines.add(String.format("- **%s**: %s", code, desc));
                                            JsonNode content = resp.path("content");
                                            String ex = null;
                                            if (!content.isMissingNode()) {
                                                JsonNode appJson = content.path("application/json");
                                                if (!appJson.isMissingNode()) {
                                                    ex = exampleForResponse(appJson, openapiJson);
                                                    if (ex == null && (mode == Mode.FULL || mode == Mode.EXAMPLES)) {
                                                        JsonNode schema = appJson.path("schema");
                                                        if (!schema.isMissingNode()) {
                                                            JsonNode sample = generatePopulatedExample(schema, openapiJson);
                                                            ex = prettyJson(sample);
                                                        }
                                                    }
                                                }
                                            }
                                            if (ex == null) {
                                                JsonNode s = resp.path("schema");
                                                if (!s.isMissingNode()) {
                                                    JsonNode sample = generatePopulatedExample(s, openapiJson);
                                                    ex = prettyJson(sample);
                                                }
                                            }
                                            if (ex != null && (mode == Mode.EXAMPLES || mode == Mode.FULL)) {
                                                outLines.add("```json");
                                                outLines.add(ex);
                                                outLines.add("```");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    String cleaned = row;
                    if (cleaned.startsWith("`") && cleaned.endsWith("`")) cleaned = cleaned.substring(1, cleaned.length() - 1).trim();
                    cleaned = cleaned.replaceAll("\\s+HTTP/\\d\\.\\d$", "");
                    Matcher m = VERB_PATH_RE.matcher(cleaned);
                    if (m.find()) {
                        String method = m.group(1).toUpperCase();
                        String path = m.group(2);
                        outLines.add("| " + method + " | " + path + " |  |  |");

                        // Enrich with request/response samples from OpenAPI JSON when available
                        if (openapiJson != null) {
                            OpResult or = findOperation(openapiJson, method, path);
                            if (or != null && or.opNode != null) {
                                JsonNode opNode = or.opNode;

                                // Collect parameters from path and operation and render table (EXAMPLES/FULL)
                                List<JsonNode> collectedParams = new ArrayList<>();
                                if (or.pathNode != null) {
                                    JsonNode pp = or.pathNode.path("parameters");
                                    if (pp.isArray()) pp.forEach(collectedParams::add);
                                }
                                JsonNode opParams = opNode.path("parameters");
                                if (opParams.isArray()) opParams.forEach(collectedParams::add);
                                if ((mode == Mode.EXAMPLES || mode == Mode.FULL) && !collectedParams.isEmpty()) {
                                    List<String> paramTable = buildParametersTableFromList(collectedParams, openapiJson);
                                    outLines.addAll(paramTable);
                                }

                                // Request body (OAS3 requestBody or Swagger2 body parameter)
                                JsonNode req = opNode.path("requestBody");
                                if (req.isMissingNode()) {
                                    // look for body param
                                    for (JsonNode pnode : collectedParams) {
                                        if (pnode.path("in").asText("").equals("body")) {
                                            req = pnode; // use the parameter node as request holder for swagger2
                                            break;
                                        }
                                    }
                                }
                                String reqExample = null;
                                if (!req.isMissingNode()) {
                                    reqExample = exampleForRequest(req, openapiJson);
                                    if (reqExample == null && (mode == Mode.FULL || mode == Mode.EXAMPLES)) {
                                        JsonNode schema = req.path("content").path("application/json").path("schema");
                                        if (!schema.isMissingNode()) {
                                            JsonNode sample = generatePopulatedExample(schema, openapiJson);
                                            reqExample = prettyJson(sample);
                                        }
                                    }
                                }
                                if (reqExample != null && (mode == Mode.EXAMPLES || mode == Mode.FULL)) {
                                    outLines.add("");
                                    outLines.add("#### Request");
                                    outLines.add("```json");
                                    outLines.add(reqExample);
                                    outLines.add("```");
                                }

                                // Responses (handle OpenAPI3 content and Swagger2 schema)
                                JsonNode responses = opNode.path("responses");
                                if (!responses.isMissingNode() && responses.fieldNames().hasNext()) {
                                    outLines.add("");
                                    outLines.add("#### Responses");
                                    for (Iterator<String> it = responses.fieldNames(); it.hasNext(); ) {
                                        String code = it.next();
                                        JsonNode resp = responses.path(code);
                                        String desc = resp.path("description").asText("");
                                        outLines.add(String.format("- **%s**: %s", code, desc));
                                        // OpenAPI3: content.application/json
                                        JsonNode content = resp.path("content");
                                        String ex = null;
                                        if (!content.isMissingNode()) {
                                            JsonNode appJson = content.path("application/json");
                                            if (!appJson.isMissingNode()) {
                                                ex = exampleForResponse(appJson, openapiJson);
                                                if (ex == null && (mode == Mode.FULL || mode == Mode.EXAMPLES)) {
                                                    JsonNode schema = appJson.path("schema");
                                                    if (!schema.isMissingNode()) {
                                                        JsonNode sample = generatePopulatedExample(schema, openapiJson);
                                                        ex = prettyJson(sample);
                                                    }
                                                }
                                            }
                                        }
                                        // Swagger2: resp.schema
                                        if (ex == null) {
                                            JsonNode s = resp.path("schema");
                                            if (!s.isMissingNode()) {
                                                JsonNode sample = generatePopulatedExample(s, openapiJson);
                                                ex = prettyJson(sample);
                                            }
                                        }
                                        if (ex != null && (mode == Mode.EXAMPLES || mode == Mode.FULL)) {
                                            outLines.add("```json");
                                            outLines.add(ex);
                                            outLines.add("```");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        outLines.add("|  | `" + row + "` |  |  |");
                        if (en.details != null && !en.details.isEmpty()) {
                            outLines.add("");
                            for (String dl : en.details.split("\n")) outLines.add(dl);
                        }
                    }
                }
            }

            Files.writeString(out, String.join("\n", outLines) + "\n", StandardCharsets.UTF_8);
            System.err.println("Wrote " + out + " (" + e.getValue().size() + " entries)");
            expectedFiles.add(out.getFileName().toString());
        }

        // Write README
        Path readme = outdir.resolve("README.md");
        List<String> r = new ArrayList<>();
        r.add("# Split API docs for " + input.getFileName().toString());
        r.add("");
        r.add("This folder contains extracted subsets of the large API markdown grouped by path prefix.");
        r.add("");
        r.add("| File | Entries | Heading sample |");
        r.add("|---|---:|---|");
        for (Map.Entry<String, List<Entry>> e : groups.entrySet()) {
            String fname = input.getFileName().toString() + "-" + sanitizeFileName(e.getKey()) + ".md";
            String sample = e.getValue().isEmpty() ? "" : e.getValue().get(0).section;
            r.add("| `" + fname + "` | " + e.getValue().size() + " | " + (sample == null ? "" : sample) + " |");
        }
        Files.writeString(readme, String.join("\n", r) + "\n", StandardCharsets.UTF_8);
        System.err.println("Wrote " + readme);
        expectedFiles.add(readme.getFileName().toString());

        // Prune stale split files for this input: any file in outdir that starts with
        // `<inputFileName>-` and ends with `.md` but was not generated in this pass
        try {
            String prefix = input.getFileName().toString() + "-";
            Files.list(outdir).forEach(p -> {
                String fn = p.getFileName().toString();
                if (!fn.startsWith(prefix) || !fn.endsWith(".md")) return;
                if (!expectedFiles.contains(fn)) {
                    try {
                        Files.deleteIfExists(p);
                        System.err.println("Pruned stale split file: " + p.getFileName());
                    } catch (Exception ex) {
                        System.err.println("Failed to prune " + p + " : " + ex.getMessage());
                    }
                }
            });
        } catch (Exception ex) {
            System.err.println("Failed to prune split dir: " + ex.getMessage());
        }
    }

    private static String extractFirstHeader(String text) {
        Matcher m = Pattern.compile("^(#\\s+.*)$", Pattern.MULTILINE).matcher(text);
        if (m.find()) return m.group(1);
        return "";
    }

    private static String pathKeyFromTableRow(String row) {
        Matcher m = TABLE_ROW_RE.matcher(row);
        if (m.find()) {
            String pathCol = m.group(2).trim();
            Matcher pm = Pattern.compile("`?([A-Za-z]*\\s*)?(/[^`\\s\\)]*)`?").matcher(pathCol);
            if (pm.find()) return pathPrefixKey(pm.group(2));
            // try verb-like content
            Matcher m2 = VERB_PATH_RE.matcher(pathCol);
            if (m2.find()) return pathPrefixKey(m2.group(2));
        }
        return null;
    }

    private static String fallbackKeyFromLine(String line) {
        Matcher m = VERB_PATH_RE.matcher(line);
        if (m.find()) return pathPrefixKey(m.group(2));
        return null;
    }

    private static String pathPrefixKey(String path) {
        if (path == null) return "misc";
        path = path.replaceFirst("^/flowable-rest/", "/");
        String trimmed = path.trim();
        if (trimmed.isEmpty() || trimmed.equals("/")) return "root";
        String[] segs = trimmed.replaceAll("^/+", "").split("/");
        return segs.length > 0 ? segs[0] : "root";
    }

    // Find operation node in OpenAPI JSON for given method and path. Tries several
    // normalized path forms so both '/flowable-rest/...' and '/cmmn-repository/...' match.
    private static JsonNode findOperationNode(JsonNode openapiJson, String method, String path) {
        if (openapiJson == null) return null;
        JsonNode paths = openapiJson.path("paths");
        if (paths.isMissingNode()) return null;

        String[] tries = new String[] { path, path.replaceFirst("^/flowable-rest/cmmn-api","/"), path.replaceFirst("^/flowable-rest","/"), path.replaceFirst("^/cmmn-api", "/") };
        for (String p : tries) {
            if (p == null || p.isBlank()) continue;
            if (!p.startsWith("/")) p = "/" + p;
            JsonNode node = paths.path(p);
            if (!node.isMissingNode()) {
                JsonNode op = node.path(method.toLowerCase());
                if (!op.isMissingNode() && op.size() > 0) return op;
            }
        }
        return null;
    }

    private static String exampleForRequest(JsonNode requestBodyNode, JsonNode root) {
        // Try to find an explicit example, otherwise fall back to schema-based generation
        JsonNode content = requestBodyNode.path("content");
        if (!content.isMissingNode()) {
            JsonNode app = content.path("application/json");
            if (!app.isMissingNode()) {
                JsonNode ex = app.path("example");
                if (!ex.isMissingNode()) return prettyJson(ex);
                JsonNode examples = app.path("examples");
                if (!examples.isMissingNode() && examples.fieldNames().hasNext()) {
                    JsonNode first = examples.elements().next();
                    JsonNode value = first.path("value");
                    if (!value.isMissingNode()) return prettyJson(value);
                }
                JsonNode schema = app.path("schema");
                if (!schema.isMissingNode()) {
                    JsonNode resolved = resolveSchema(schema, root);
                    if (resolved != null) return prettyJson(generateExampleFromSchema(resolved, root));
                }
            }
        }
        return null;
    }

    private static String exampleForResponse(JsonNode appJsonNode, JsonNode root) {
        if (!appJsonNode.isMissingNode()) {
            JsonNode ex = appJsonNode.path("example");
            if (!ex.isMissingNode()) return prettyJson(ex);
            JsonNode examples = appJsonNode.path("examples");
            if (!examples.isMissingNode() && examples.fieldNames().hasNext()) {
                JsonNode first = examples.elements().next();
                JsonNode value = first.path("value");
                if (!value.isMissingNode()) return prettyJson(value);
            }
            JsonNode schema = appJsonNode.path("schema");
            if (!schema.isMissingNode()) {
                JsonNode resolved = resolveSchema(schema, root);
                if (resolved != null) return prettyJson(generateExampleFromSchema(resolved, root));
            }
        }
        return null;
    }

    // Resolve $ref if present
    private static JsonNode resolveSchema(JsonNode schemaNode, JsonNode root) {
        if (schemaNode.has("$ref")) {
            String ref = schemaNode.get("$ref").asText();
            // typical ref: '#/components/schemas/MyModel'
            if (ref.startsWith("#/")) {
                String[] parts = ref.substring(2).split("/");
                JsonNode cur = root;
                for (String p : parts) {
                    cur = cur.path(p);
                    if (cur.isMissingNode()) return null;
                }
                return cur;
            }
        }
        return schemaNode;
    }

    private static class OpResult {
        final JsonNode pathNode;
        final JsonNode opNode;
        final String path;

        OpResult(JsonNode pathNode, JsonNode opNode, String path) {
            this.pathNode = pathNode; this.opNode = opNode; this.path = path;
        }
    }

    // Find operation and its parent path node
    private static OpResult findOperation(JsonNode openapiJson, String method, String path) {
        if (openapiJson == null) return null;
        JsonNode paths = openapiJson.path("paths");
        if (paths.isMissingNode()) return null;

        String[] tries = new String[] { path, path.replaceFirst("^/flowable-rest/cmmn-api","/"), path.replaceFirst("^/flowable-rest","/"), path.replaceFirst("^/cmmn-api", "/") };
        for (String p : tries) {
            if (p == null || p.isBlank()) continue;
            if (!p.startsWith("/")) p = "/" + p;
            JsonNode pathNode = paths.path(p);
            if (!pathNode.isMissingNode()) {
                JsonNode op = pathNode.path(method.toLowerCase());
                if (!op.isMissingNode() && op.size() > 0) return new OpResult(pathNode, op, p);
            }
        }
        return null;
    }

    private static String prettyJson(JsonNode n) {
        try {
            ObjectMapper om = new ObjectMapper();
            return om.writerWithDefaultPrettyPrinter().writeValueAsString(n);
        } catch (Exception ex) {
            return n.toString();
        }
    }

    // Build a markdown table of parameters (name, in, required, schema, desc, example)
    private static List<String> buildParametersTableFromList(List<JsonNode> paramsList, JsonNode root) {
        List<String> table = new ArrayList<>();
        if (paramsList == null || paramsList.isEmpty()) return table;
        table.add("");
        table.add("| Name | In | Required | Schema | Description | Example |");
        table.add("|---|---|---:|---|---|---|");
        List<String> extraExamples = new ArrayList<>();
        for (JsonNode p : paramsList) {
            String name = p.path("name").asText("");
            String in = p.path("in").asText("");
            boolean req = p.path("required").asBoolean(false);
            String desc = p.path("description").asText("");
            String schemaText = "";
            JsonNode schema = p.path("schema");
            if (schema.isMissingNode() && p.has("schema")) schema = p.get("schema");
            if (!schema.isMissingNode()) {
                if (schema.has("$ref")) schemaText = schema.get("$ref").asText();
                else if (schema.has("type")) schemaText = schema.get("type").asText();
            }
            String example = "";
            if (p.has("example")) example = prettyJson(p.path("example"));
            else if (!schema.isMissingNode() && schema.has("example")) example = prettyJson(schema.path("example"));
            else if (!schema.isMissingNode() && schema.has("default")) example = prettyJson(schema.path("default"));
            String exampleShort = example;
            if (example.length() > 200) {
                exampleShort = example.substring(0, 200).replaceAll("\n", " ") + "... (truncated)";
                // Prepare expanded example block to append after the table
                extraExamples.add("");
                extraExamples.add("> **Expanded example for parameter `" + name + "`**");
                extraExamples.add("");
                extraExamples.add("```json");
                extraExamples.add(example);
                extraExamples.add("```");
            }
            table.add(String.format("| %s | %s | %s | %s | %s | %s |", name, in, req ? "yes" : "", schemaText, desc.replaceAll("\n"," ").trim(), exampleShort));
        }
        // append any expanded examples after the table
        if (!extraExamples.isEmpty()) table.addAll(extraExamples);
        return table;
    }

    // Generate a populated example from schema (more detailed values when possible)
    private static JsonNode generatePopulatedExample(JsonNode schema, JsonNode root) {
        return generatePopulatedExample(schema, root, 6);
    }

    private static JsonNode generatePopulatedExample(JsonNode schema, JsonNode root, int depth) {
        ObjectMapper om = new ObjectMapper();
        if (depth <= 0) return om.createObjectNode();
        JsonNode resolved = resolveSchema(schema, root);
        if (resolved == null) return om.createObjectNode();
        if (resolved.has("example")) return resolved.get("example");
        if (resolved.has("default")) return resolved.get("default");
        String t = resolved.path("type").asText("");
        switch (t) {
            case "string":
                // Try enum or format hints
                if (resolved.has("enum") && resolved.get("enum").isArray() && resolved.get("enum").size() > 0) {
                    return resolved.get("enum").get(0);
                }
                if (resolved.has("format") && "date-time".equals(resolved.get("format").asText())) {
                    return om.convertValue("1970-01-01T00:00:00Z", JsonNode.class);
                }
                return om.convertValue("string", JsonNode.class);
            case "integer": return om.convertValue(0, JsonNode.class);
            case "number": return om.convertValue(0.0, JsonNode.class);
            case "boolean": return om.convertValue(false, JsonNode.class);
            case "array": {
                ArrayNode arr = om.createArrayNode();
                JsonNode items = resolved.path("items");
                if (!items.isMissingNode()) arr.add(generatePopulatedExample(items, root, depth - 1));
                return arr;
            }
            case "object": {
                ObjectNode obj = om.createObjectNode();
                JsonNode props = resolved.path("properties");
                if (props.isObject()) {
                    for (Iterator<String> it = props.fieldNames(); it.hasNext(); ) {
                        String name = it.next();
                        JsonNode prop = props.path(name);
                        JsonNode ex = generatePopulatedExample(prop, root, depth - 1);
                        obj.set(name, ex == null ? om.nullNode() : ex);
                    }
                }
                return obj;
            }
            default:
                return om.convertValue("", JsonNode.class);
        }
    }

    // Generate a simple example from a schema by walking 'properties'
    private static JsonNode generateExampleFromSchema(JsonNode schema, JsonNode root) {
        ObjectMapper om = new ObjectMapper();
        if (schema.isObject() && schema.has("type") && "object".equals(schema.get("type").asText())) {
            ObjectNode obj = om.createObjectNode();
            JsonNode props = schema.path("properties");
            for (Iterator<String> it = props.fieldNames(); it.hasNext(); ) {
                String name = it.next();
                JsonNode prop = props.path(name);
                JsonNode resolved = resolveSchema(prop, root);
                if (resolved == null) continue;
                String t = resolved.path("type").asText("");
                switch (t) {
                    case "string": obj.put(name, ""); break;
                    case "integer": obj.put(name, 0); break;
                    case "number": obj.put(name, 0.0); break;
                    case "boolean": obj.put(name, false); break;
                    case "array":
                        ArrayNode arr = om.createArrayNode();
                        JsonNode items = resolved.path("items");
                        if (!items.isMissingNode()) {
                            JsonNode itemEx = generateExampleFromSchema(resolveSchema(items, root), root);
                            if (itemEx != null) arr.add(itemEx);
                        }
                        obj.set(name, arr);
                        break;
                    case "object":
                        obj.set(name, generateExampleFromSchema(resolved, root));
                        break;
                    default:
                        obj.put(name, "");
                }
            }
            return obj;
        }
        // fallback: return empty object
        return om.createObjectNode();
    }

    private static String sanitizeFileName(String s) {
        return s.replaceAll("[^A-Za-z0-9._-]", "_");
    }

    private static class Entry {
        final String section;
        final String row;
        final String details;

        Entry(String section, String row) {
            this(section, row, null);
        }

        Entry(String section, String row, String details) {
            this.section = section == null ? "" : section;
            this.row = row == null ? "" : row;
            this.details = details == null ? "" : details;
        }
    }
}
