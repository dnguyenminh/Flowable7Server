#!/usr/bin/env bash
set -euo pipefail

BASE=${BASE_URL:-http://localhost:8080}
PROCESS_INSTANCE_ID=${1:-dummy-process}

echo "GET $BASE/runtime/tasks?processInstanceId=$PROCESS_INSTANCE_ID"
URL="$BASE/runtime/tasks?processInstanceId=$PROCESS_INSTANCE_ID"

if command -v jq >/dev/null 2>&1; then
  curl -sS "$URL" | jq .
else
  curl -sS "$URL"
fi
