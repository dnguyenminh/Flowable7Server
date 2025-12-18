#!/usr/bin/env bash
set -euo pipefail

BASE=${BASE_URL:-http://localhost:8080}

echo "POST $BASE/dmn-rule/execute-decision-service"
PAYLOAD='{"decisionKey":"isAdult","variables":{"age":20}}'

if command -v jq >/dev/null 2>&1; then
  curl -sS -X POST "$BASE/dmn-rule/execute-decision-service" -H 'Content-Type: application/json' -d "$PAYLOAD" | jq .
else
  curl -sS -X POST "$BASE/dmn-rule/execute-decision-service" -H 'Content-Type: application/json' -d "$PAYLOAD"
fi
