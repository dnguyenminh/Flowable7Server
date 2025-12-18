#!/usr/bin/env bash
set -euo pipefail

BASE=${BASE_URL:-http://localhost:8080}
TASK_ID=${1:?"Usage: $0 {taskId}"}

echo "POST $BASE/runtime/tasks/$TASK_ID"
PAYLOAD='{"action":"complete","variables":[{"name":"approved","value":true}]}'

if command -v jq >/dev/null 2>&1; then
  curl -sS -X POST "$BASE/runtime/tasks/$TASK_ID" -H 'Content-Type: application/json' -d "$PAYLOAD" | jq .
else
  curl -sS -X POST "$BASE/runtime/tasks/$TASK_ID" -H 'Content-Type: application/json' -d "$PAYLOAD"
fi
