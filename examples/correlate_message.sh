#!/usr/bin/env bash
set -euo pipefail

BASE=${BASE_URL:-http://localhost:8080}
EXECUTION_ID=${1:?"Usage: $0 {executionId}"}

echo "POST $BASE/runtime/executions/$EXECUTION_ID/message"
PAYLOAD='{"messageName":"Ping","processInstanceId":"0000-1111-2222","variables":{"approved":true}}'

if command -v jq >/dev/null 2>&1; then
  curl -sS -X POST "$BASE/runtime/executions/$EXECUTION_ID/message" -H 'Content-Type: application/json' -d "$PAYLOAD" | jq .
else
  curl -sS -X POST "$BASE/runtime/executions/$EXECUTION_ID/message" -H 'Content-Type: application/json' -d "$PAYLOAD"
fi
