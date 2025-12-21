#!/usr/bin/env python3
"""Fix common malformed keys in Flowable CMMN Swagger JSON.

This script attempts to repair lines where path keys are missing a leading
double-quote, e.g.

    /cmmn-apicase-instances" : {

and converts them to:

    "/cmmn-apicase-instances" : {

It writes a fixed file next to the original with a `.fixed` suffix and
verifies the result parses as JSON.
"""
import json
from pathlib import Path
import re
import sys


def fix_file(path: Path) -> int:
    text = path.read_text(encoding="utf-8")

    # Add missing leading quote for path-like keys (lines that start with
    # optional whitespace then a slash and later a closing quote and colon)
    fixed = re.sub(r'(?m)^(\s*)(/[^\"]+\")\s*:\s*', r'\1"\2: ', text)

    # Also fix any occurrences where a path key is followed by a comma instead of colon
    fixed = re.sub(r'(?m)^(\s*)"(/[^\"]+)"\s*,\s*$', r'\1"\2",', fixed)

    out = path.with_suffix(path.suffix + ".fixed")
    out.write_text(fixed, encoding="utf-8")

    # Verify JSON parse
    try:
        json.loads(fixed)
    except json.JSONDecodeError as e:
        print(f"Failed to parse fixed JSON: {e}")
        return 2

    # If parse successful, replace the original file with fixed content
    backup = path.with_suffix(path.suffix + ".bak")
    path.replace(backup)
    out.replace(path)
    print(f"Repaired JSON and backed up original to {backup}")
    return 0


def main():
    p = Path("docs/openapi/flowable-swagger-cmmn.json")
    if not p.exists():
        print("CMMN swagger JSON not found at docs/openapi/flowable-swagger-cmmn.json")
        sys.exit(1)
    rc = fix_file(p)
    sys.exit(rc)


if __name__ == "__main__":
    main()
