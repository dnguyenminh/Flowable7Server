#!/usr/bin/env bash
set -euo pipefail

BASE=${BASE_URL:-http://localhost:8080}
INSTANCE_ID=${1:?"Usage: $0 {processInstanceId}"}

echo "POST $BASE/runtime/process-instances/$INSTANCE_ID/variables"
PAYLOAD='[{"name":"approved","value":true},{"name":"count","value":5}]'

if command -v jq >/dev/null 2>&1; then
  curl -sS -X POST "$BASE/runtime/process-instances/$INSTANCE_ID/variables" -H 'Content-Type: application/json' -d "$PAYLOAD" | jq .
else
  curl -sS -X POST "$BASE/runtime/process-instances/$INSTANCE_ID/variables" -H 'Content-Type: application/json' -d "$PAYLOAD"
fi
