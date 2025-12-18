#!/usr/bin/env bash
set -euo pipefail

BASE=${BASE_URL:-http://localhost:8080}

echo "POST $BASE/cmmn-runtime/case-instances"
PAYLOAD='{"caseDefinitionKey":"simpleCase"}'

if command -v jq >/dev/null 2>&1; then
  curl -sS -X POST "$BASE/cmmn-runtime/case-instances" -H 'Content-Type: application/json' -d "$PAYLOAD" | jq .
else
  curl -sS -X POST "$BASE/cmmn-runtime/case-instances" -H 'Content-Type: application/json' -d "$PAYLOAD"
fi
