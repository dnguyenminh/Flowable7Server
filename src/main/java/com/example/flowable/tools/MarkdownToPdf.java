package com.example.flowable.tools;
// Minimal tool to convert Markdown -> PDF using Flexmark and OpenHTMLToPDF.
// Save this file as tools/MarkdownToPdf.java and compile with a Maven project that includes
// the dependencies shown below (or add them to your existing pom).
//
// pom.xml dependencies (paste into your pom's <dependencies>):
/*
<dependency>
  <groupId>com.vladsch.flexmark</groupId>
  <artifactId>flexmark-all</artifactId>
  <version>0.64.0</version>
</dependency>
<dependency>
  <groupId>com.openhtmltopdf</groupId>
  <artifactId>openhtmltopdf-core</artifactId>
  <version>1.0.10</version>
</dependency>
<dependency>Markdown


  <groupId>com.openhtmltopdf</groupId>
  <artifactId>openhtmltopdf-pdfbox</artifactId>
  <version>1.0.10</version>
</dependency>
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.io.MemoryUsageSetting;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.FilterOutputStream;

/**
 * Usage:
 *   mvn compile
 *   mvn exec:java -Dexec.mainClass="MarkdownToPdf" -Dexec.args="input.md output.pdf"
 *
 * Or package into a jar with dependencies and run:
 *   java -cp "yourjar-with-deps.jar" MarkdownToPdf input.md output.pdf
 */
public class MarkdownToPdf {

    public static void main(String[] args) {
        try {
            if (args.length == 1) {
                // single file mode: arg is input file
                File input = new File(args[0]);
                File output = new File(args[0].replaceAll("\\.md$", ".pdf"));
                convert(input, output);
                return;
            } else if (args.length == 0) {
                // no args: if split dir exists, render all md files inside
                File splitDir = new File("docs/openapi/split");
                if (splitDir.exists() && splitDir.isDirectory()) {
                    File[] mds = splitDir.listFiles((d,n) -> n.endsWith(".md"));
                    if (mds != null) {
                        for (File md : mds) {
                            File out = new File(md.getParentFile(), md.getName().replaceAll("\\.md$", ".pdf"));
                            convert(md, out);
                        }
                        return;
                    }
                }
                // fallback: original single file
                File input = new File("docs/openapi/flowable-swagger-cmmn.md");
                File output = new File("docs/openapi/flowable-swagger-cmmn.pdf");
                convert(input, output);
                return;
            } else {
                System.err.println("Usage: java MarkdownToPdf [<input.md>]  (no args renders docs/openapi/split/*.md)");
                System.exit(2);
            }
        } catch (Exception e) {
            System.err.println("Conversion failed: " + e.getMessage());
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private static void convert(File input, File output) throws Exception {
        if (!input.exists() || !input.isFile()) {
            System.err.println("Input file not found: " + input.getAbsolutePath());
            return;
        }
        System.err.println("Converting: " + input + " -> " + output);
        System.err.print("[1/5] Reading input... ");
        String md = readFileUtf8(input);
            System.err.println("done");

            // Configure flexmark
            System.err.print("[2/5] Parsing Markdown -> HTML... ");
            MutableDataSet options = new MutableDataSet();
            Parser parser = Parser.builder(options).build();
            HtmlRenderer renderer = HtmlRenderer.builder(options).build();
            String htmlBody = renderer.render(parser.parse(md));
            System.err.println("done");

            // Basic HTML wrapper and CSS; tweak for large docs (page-breaks, font-size, etc.)
            String css = "body { font-family: Arial, Helvetica, sans-serif; font-size: 11pt; margin: 20px; }"
                       + "pre { white-space: pre-wrap; word-wrap: break-word; background:#f8f8f8; padding:8px; border-radius:4px; }"
                       + "code { font-family: monospace; background:#f4f4f4; padding:2px 4px; font-size:9pt; }"
                       + "table { border-collapse: collapse; width: 100%; table-layout: fixed; word-wrap: break-word; }"
                       + "th, td { border: 1px solid #ddd; padding: 6px 8px; vertical-align: top; }"
                       + "th { background: #f6f6f6; font-weight: bold; }"
                       + "td { white-space: pre-wrap; word-wrap: break-word; }"
                       + "thead { display: table-header-group; }"
                       + "h1, h2 { page-break-after: avoid; }"
                       + "h2 { page-break-before: always; padding-top: 12pt; }";

            // Ensure we have well-formed XHTML for OpenHTMLToPDF (self-closing meta,
            // xmlns, and strip possible BOM leading chars).
            md = md.replace("\uFEFF", "");

            String html = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                        + "<!DOCTYPE html>\n"
                        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                        + "<head><meta charset=\"utf-8\"/>"
                        + "<style>" + css + "</style>"
                        + "</head><body>"
                        + htmlBody
                        + "</body></html>";

            // Chunk the markdown to render PDF in parts so we can show exact progress
            System.err.print("[3/5] Splitting document into chunks... ");
            List<String> chunks = splitIntoChunks(md, 80_000); // ~80KB chunks
            System.err.println(chunks.size() + " chunk(s)");

            List<File> tempPdfs = new ArrayList<>();
            String baseUri = input.getParentFile() != null ? input.getParentFile().toURI().toString() : null;

            // moving average of bytes per HTML char (used to estimate final PDF bytes)
            double avgBytesPerChar = 0.35; // initial heuristic
            long totalPdfBytes = 0L;
            long totalHtmlChars = 0L;

            int i = 0;
            while (i < chunks.size()) {
                int chunkIndex = i + 1;
                System.err.printf("[3/5] Rendering chunk %d/%d...%n", chunkIndex, chunks.size());
                String chunkMd = chunks.get(i);
                String chunkHtmlBody = renderer.render(parser.parse(chunkMd));
                String chunkHtml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<!DOCTYPE html>\n" +
                        "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                        "<head><meta charset=\"utf-8\"/>" +
                        "<style>" + css + "</style>" +
                        "</head><body>" +
                        chunkHtmlBody +
                        "</body></html>";

                File temp = Files.createTempFile("mdchunk-" + chunkIndex + "-", ".pdf").toFile();
                long expectedBytes = Math.max(32_768L, (long) (avgBytesPerChar * chunkHtml.length()));

                boolean rendered = false;
                try {
                    rendered = tryRenderChunk(chunkIndex, chunks.size(), chunkHtml, baseUri, temp, expectedBytes);
                } catch (Exception e) {
                    // try sanitizing HTML with jsoup and retry
                    System.err.println("[3/5] Chunk " + chunkIndex + " failed with: " + e.getMessage());
                    try {
                        Document doc = Jsoup.parse(chunkHtml);
                        doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
                        doc.outputSettings().charset("utf-8");
                        doc.outputSettings().prettyPrint(false);
                        String fixedHtml = doc.outerHtml();
                        System.err.println("[3/5] Retrying chunk " + chunkIndex + " with sanitized HTML...");
                        rendered = tryRenderChunk(chunkIndex, chunks.size(), fixedHtml, baseUri, temp, expectedBytes);
                    } catch (Exception e2) {
                        System.err.println("[3/5] Sanitized retry failed: " + e2.getMessage());
                        // Split this chunk into two smaller ones and process them
                        int mid = chunkMd.length() / 2;
                        int nl = chunkMd.lastIndexOf('\n', mid);
                        if (nl <= 0) nl = mid;
                        String part1 = chunkMd.substring(0, nl);
                        String part2 = chunkMd.substring(nl);
                        chunks.set(i, part1);
                        chunks.add(i + 1, part2);
                        System.err.println("[3/5] Split chunk " + chunkIndex + " into two smaller chunks; will retry.");
                        rendered = false;
                    }
                }

                if (rendered) {
                    tempPdfs.add(temp);
                    long actualBytes = temp.length();
                    totalPdfBytes += actualBytes;
                    totalHtmlChars += chunkHtml.length();
                    if (totalHtmlChars > 0) avgBytesPerChar = (double) totalPdfBytes / (double) totalHtmlChars;
                    int pct = (int) ((chunkIndex * 100L) / chunks.size());
                    System.err.printf("[3/5] Completed chunk %d/%d (%d%%) — %d bytes\n", chunkIndex, chunks.size(), pct, actualBytes);
                    i++; // proceed to next chunk
                } else {
                    // we split the chunk and will retry the new parts at the same index
                    // do not increment i
                }
            }

            // Merge PDFs
            System.err.print("[4/5] Merging " + tempPdfs.size() + " part(s) into final PDF... ");
            PDFMergerUtility merger = new PDFMergerUtility();
            merger.setDestinationFileName(output.getAbsolutePath());
            for (File f : tempPdfs) {
                merger.addSource(f);
            }
            merger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
            System.err.println("done");

            // Cleanup temp parts
            for (File f : tempPdfs) {
                try { Files.deleteIfExists(f.toPath()); } catch (Exception ignored) {}
            }

            System.out.println("Wrote PDF: " + output.getAbsolutePath());
        
    }

    private static boolean tryRenderChunk(int chunkIndex, int totalChunks, String html, String baseUri, File outFile, long expectedBytes) throws Exception {
        try (OutputStream fos = new FileOutputStream(outFile);
             CountingOutputStream cos = new CountingOutputStream(fos)) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, baseUri);
            builder.toStream(cos);

            ChunkProgressReporter reporter = new ChunkProgressReporter("Chunk " + chunkIndex + "/" + totalChunks, cos, expectedBytes);
            try {
                builder.run();
                return true;
            } finally {
                reporter.stop();
            }
        }
    }

    private static String readFileUtf8(File f) throws IOException {
        StringBuilder sb = new StringBuilder(Math.max(1024, (int) Math.min(f.length(), 10_000_000)));
        try (InputStream in = new FileInputStream(f);
             InputStreamReader ir = new InputStreamReader(in, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(ir)) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }
        return sb.toString();
    }

    private static List<String> splitIntoChunks(String md, int approxMaxChars) {
        List<String> chunks = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        String[] lines = md.split("\n");
        Pattern headerPattern = Pattern.compile("^#{1,2}\\s+.*");
        for (String line : lines) {
            boolean isHeader = headerPattern.matcher(line).matches();
            if (isHeader && cur.length() > approxMaxChars) {
                chunks.add(cur.toString());
                cur.setLength(0);
            }
            cur.append(line).append('\n');
        }
        if (cur.length() > 0) chunks.add(cur.toString());

        // Ensure no chunk is larger than approxMaxChars. For any oversized chunk,
        // split it into smaller pieces at a newline boundary when possible to
        // keep splits between lines (and headers) readable.
        List<String> normalized = new ArrayList<>();
        for (String c : chunks) {
            if (c.length() <= approxMaxChars) {
                normalized.add(c);
                continue;
            }
            // split large chunk into smaller parts, preferring newline boundaries
            int start = 0;
            int len = c.length();
            while (start < len) {
                int end = Math.min(len, start + approxMaxChars);
                if (end < len) {
                    // try to find last newline between start and end
                    int nl = c.lastIndexOf('\n', end);
                    if (nl <= start) nl = end; // fallback to hard split
                    end = nl;
                }
                normalized.add(c.substring(start, end));
                start = end;
            }
        }
        chunks = normalized;
        return chunks;
    }

    // Counts bytes written through the stream
    private static class CountingOutputStream extends FilterOutputStream {
        private volatile long written = 0L;

        CountingOutputStream(OutputStream out) { super(out); }

        @Override public void write(int b) throws IOException { super.write(b); written++; }
        @Override public void write(byte[] b, int off, int len) throws IOException { super.write(b, off, len); written += len; }
        public long getWritten() { return written; }
    }

    // Polls the counting stream and prints intra-chunk progress
    private static class ChunkProgressReporter {
        private final Thread thread;
        private volatile boolean running = true;

        ChunkProgressReporter(String label, CountingOutputStream cos, long expectedBytes) {
            thread = new Thread(() -> {
                try {
                    while (running) {
                        long written = cos.getWritten();
                        int pct = (int) Math.min(99, (written * 100) / Math.max(1L, expectedBytes));
                        System.err.print('\r' + "[3/5] " + label + " " + String.format("%3d%%", pct) + " " + written + " bytes");
                        Thread.sleep(150);
                    }
                } catch (InterruptedException ignored) {
                }
                System.err.print('\r' + "[3/5] " + label + " 100%\n");
            });
            thread.setDaemon(true);
            thread.start();
        }

        void stop() {
            running = false;
            try { thread.join(500); } catch (InterruptedException ignored) {}
        }
    }

    // Progress spinner that shows an *estimated* percent-complete during long operations.
    // Note: OpenHTMLToPDF does not provide a progress callback; we estimate completion
    // by comparing elapsed time to an expected duration. The percentage is therefore
    // approximate but useful for user feedback.
    private static class ProgressSpinner {
        private final Thread thread;
        private volatile boolean running = true;
        private final long expectedMillis;

        ProgressSpinner(String label, long expectedMillis) {
            this.expectedMillis = Math.max(1000L, expectedMillis);
            thread = new Thread(() -> {
                String[] frames = new String[] {"|", "/", "-", "\\"};
                int i = 0;
                final long start = System.currentTimeMillis();
                try {
                    while (running) {
                        long elapsed = System.currentTimeMillis() - start;
                        int pct = (int) Math.min(99, (elapsed * 100) / this.expectedMillis);
                        if (pct < 0) pct = 0;
                        System.err.print('\r' + label + " " + String.format("%3d%%", pct) + " " + frames[i % frames.length] + " ");
                        i++;
                        Thread.sleep(200);
                    }
                } catch (InterruptedException ignored) {
                    // ignore
                }
                System.err.print('\r' + label + " 100% done\n");
            });
            thread.setDaemon(true);
            thread.start();
        }

        void stop() {
            running = false;
            try {
                thread.join(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
