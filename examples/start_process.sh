#!/usr/bin/env bash
set -euo pipefail

BASE=${BASE_URL:-http://localhost:8080}

echo "POST $BASE/runtime/process-instances"
PAYLOAD='{"processDefinitionKey":"simpleProcess","variables":[{"name":"approved","value":true}]}'

if command -v jq >/dev/null 2>&1; then
  curl -sS -X POST "$BASE/runtime/process-instances" -H 'Content-Type: application/json' -d "$PAYLOAD" | jq .
else
  curl -sS -X POST "$BASE/runtime/process-instances" -H 'Content-Type: application/json' -d "$PAYLOAD"
fi
