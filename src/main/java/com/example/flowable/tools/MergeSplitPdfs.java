package com.example.flowable.tools;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.io.MemoryUsageSetting;

/**
 * Merge split PDFs produced by MarkdownToPdf into per-module PDFs.
 * Usage: mvn -DskipTests compile exec:java -Dexec.mainClass="com.example.flowable.tools.MergeSplitPdfs"
 */
public class MergeSplitPdfs {

    public static void main(String[] args) throws Exception {
        Path splitDir = Paths.get("docs", "openapi", "split");
        if (!Files.exists(splitDir) || !Files.isDirectory(splitDir)) {
            System.err.println("Split directory not found: " + splitDir.toAbsolutePath());
            System.exit(2);
        }

        // Map module -> list of pdf files
        Map<String, List<Path>> groups = new HashMap<>();
        Files.list(splitDir).filter(p -> p.getFileName().toString().endsWith(".pdf")).forEach(p -> {
            String fn = p.getFileName().toString();
            // expected format: flowable-swagger-<module>.md-<suffix>.pdf
            if (!fn.startsWith("flowable-swagger-")) return;
            int start = "flowable-swagger-".length();
            int mdIdx = fn.indexOf(".md-", start);
            if (mdIdx < 0) return;
            String module = fn.substring(start, mdIdx);
            groups.computeIfAbsent(module, k -> new ArrayList<>()).add(p);
        });

        if (groups.isEmpty()) {
            System.err.println("No split PDFs found to merge in " + splitDir);
            return;
        }

        Path outDir = Paths.get("docs","openapi");
        Files.createDirectories(outDir);

        for (Map.Entry<String, List<Path>> e : groups.entrySet()) {
            String module = e.getKey();
            List<Path> parts = e.getValue();
            parts.sort(Comparator.comparing(Path::toString));
            Path out = outDir.resolve("flowable-swagger-" + module + ".pdf");
            System.err.println("Merging " + parts.size() + " part(s) for module '" + module + "' -> " + out.getFileName());

            if (parts.size() == 1) {
                // copy single file
                Files.copy(parts.get(0), out, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                System.err.println("Copied single part to " + out);
                continue;
            }

            PDFMergerUtility merger = new PDFMergerUtility();
            merger.setDestinationFileName(out.toAbsolutePath().toString());
            for (Path p : parts) merger.addSource(p.toFile());
            merger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
            System.err.println("Wrote merged PDF: " + out);
        }
    }
}
