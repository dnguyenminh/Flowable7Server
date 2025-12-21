#!/usr/bin/env python3
"""Split a large Swagger-generated Markdown file into smaller files grouped by path prefix.

Usage:
  python3 scripts/split_swagger_md_by_path.py docs/openapi/flowable-swagger-cmmn.md

This script finds table rows that contain a path (backticked) and writes per-prefix
Markdown files under docs/openapi/split/<module>-<prefix>.md
"""
import sys
from pathlib import Path
import re

def main():
    if len(sys.argv) < 2:
        print("Usage: split_swagger_md_by_path.py <input.md>")
        raise SystemExit(2)

    inp = Path(sys.argv[1])
    if not inp.exists():
        print("Input not found:", inp)
        raise SystemExit(1)

    outdir = inp.parent / 'split'
    outdir.mkdir(parents=True, exist_ok=True)

    text = inp.read_text(encoding='utf-8')

    # Capture module header/title (first H1 or H2)
    m = re.search(r'^(#\s+.*)$', text, flags=re.M)
    header = m.group(1) + '\n\n' if m else ''

    # We'll collect lines that contain path-like tokens. Patterns include:
    # - backticked paths: `GET /cmmn-history/...` or `/cmmn-apicase-instances`
    # - plain occurrences: /flowable-rest/cmmn-api/...
    path_re = re.compile(r'`?(?:[A-Z]+\s+)?(/(?:flowable-rest/)?cmmn[-/][^`\s\)\,]*)`?', re.IGNORECASE)

    # We'll extract full table rows when possible. Strategy:
    # - Find table headers like '| Method | Path | Summary | Params |' and capture the contiguous
    #   table rows that follow.
    # - For each row, extract the Path (second column) and group by the first path segment.
    # - Also capture the nearest preceding section heading to provide context in the output file.
    table_header_re = re.compile(r'\|\s*Method\s*\|\s*Path\s*\|', re.IGNORECASE)
    row_re = re.compile(r'\|\s*([^|]+)\s*\|\s*([^|]+)\s*\|\s*([^|]*)\s*\|\s*([^|]*)\s*\|?')

    groups = {}

    lines = text.splitlines()
    last_section = ''
    i = 0
    while i < len(lines):
        line = lines[i]
        # Update last_section when we see a header (## or ### or #)
        hdr = re.match(r'^(#{1,6})\s*(.*)', line)
        if hdr:
            last_section = hdr.group(2).strip()
            i += 1
            continue

        if table_header_re.search(line):
            # consume header and separator line(s)
            i += 1
            # skip the separator line like '|---|---|'
            while i < len(lines) and re.match(r'^\|?-?-', lines[i].strip()):
                i += 1
            # now collect rows
            while i < len(lines) and lines[i].strip().startswith('|'):
                row_line = lines[i].strip()
                m = row_re.match(row_line)
                if m:
                    method = m.group(1).strip()
                    path_col = m.group(2).strip()
                    summary = m.group(3).strip()
                    params = m.group(4).strip()

                    # extract first path token from path_col (handles ` `/backticks or full URLs)
                    path_match = re.search(r'`?([A-Za-z]*\s*)?(/[^`\s\)]*)`?', path_col)
                    if path_match:
                        path = path_match.group(2)
                        path = re.sub(r'^/flowable-rest/', '/', path)
                        seg = '/' + path.strip('/').split('/')[0]
                        key = seg.strip('/').replace('/', '-')
                        fname = re.sub(r'[^A-Za-z0-9._-]', '_', key)
                        groups.setdefault(fname, []).append((last_section, row_line))
                i += 1
            continue

        # fallback: detect single-line backticked path occurrences
        mo = re.search(r'`(GET|POST|PUT|DELETE|PATCH)?\s*(/[^`\s\)]*)`', line)
        if mo:
            path = mo.group(2)
            path = re.sub(r'^/flowable-rest/', '/', path)
            seg = '/' + path.strip('/').split('/')[0]
            key = seg.strip('/').replace('/', '-')
            fname = re.sub(r'[^A-Za-z0-9._-]', '_', key)
            groups.setdefault(fname, []).append((last_section, line.strip()))

        i += 1

    # Now write out the groups into files. Each group gets a small Markdown doc with
    # the module header, and sections for each nearest-heading with a small table of
    # Method | Path | Summary | Params. We normalize raw lines like 'GET /path ...' into
    # pipe-separated rows when needed.
    for key, entries in groups.items():
        fname = f"{inp.stem}-{key}.md"
        outp = outdir / fname
        buf = []
        buf.append(f"# {inp.stem} — {key} ({key})\n")
        buf.append('> Generated subset extracted from ' + inp.name + '\n')
        current_section = None
        for section, row in entries:
            if section != current_section:
                buf.append('\n')
                if section:
                    buf.append(f"## {section}\n\n")
                # Add table header
                buf.append('| Method | Path | Summary | Params |\n')
                buf.append('|---|---|---|---|\n')
                current_section = section

            # Normalize row into table row if it's not pipe-separated
            if row.strip().startswith('|'):
                buf.append(row + '\n')
            else:
                cleaned = row.strip()
                # strip surrounding backticks if present
                if cleaned.startswith('`') and cleaned.endswith('`'):
                    cleaned = cleaned[1:-1].strip()
                # remove trailing HTTP version if present
                cleaned = re.sub(r'\s+HTTP/\d\.\d$', '', cleaned, flags=re.IGNORECASE)
                m = re.match(r'^(GET|POST|PUT|DELETE|PATCH)\s+([^\s]+)', cleaned, re.IGNORECASE)
                if m:
                    method = m.group(1).upper()
                    path = m.group(2)
                    buf.append(f"| {method} | {path} |  |  |\n")
                else:
                    # fallback: include raw line as a code block row
                    buf.append(f"|  | `{row.strip()}` |  |  |\n")

        outp.write_text('\n'.join(buf), encoding='utf-8')
        print('Wrote', outp)

    # Write a small README that indexes the generated files
    readme = outdir / 'README.md'
    lines = [f"# Split API docs for {inp.name}", "", "This folder contains extracted subsets of the large API markdown grouped by path prefix.", "", "| File | Entries | Heading sample |", "|---|---:|---|"]
    for key, entries in sorted(groups.items()):
        fname = f"{inp.stem}-{key}.md"
        sample_heading = entries[0][0] if entries and entries[0][0] else ''
        lines.append(f"| `{fname}` | {len(entries)} | {sample_heading} |")

    readme.write_text('\n'.join(lines) + '\n', encoding='utf-8')
    print('Wrote', readme)
