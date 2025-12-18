#!/usr/bin/env bash
set -euo pipefail

BASE=${BASE_URL:-http://localhost:8080}
DEPLOY_NAME=${1:-example-deployment}

FILES=(examples/resources/simpleProcess.bpmn examples/resources/simpleCase.cmmn)

echo "POST $BASE/repository/deployments (files: ${FILES[*]})"

# Build curl args for files
ARGS=( -sS -X POST "$BASE/repository/deployments" -F "deploymentName=$DEPLOY_NAME" )
for f in "${FILES[@]}"; do
  ARGS+=( -F "files=@${f}" )
done

# Execute request and capture response
RESP_FILE=$(mktemp)
trap 'rm -f "$RESP_FILE"' EXIT

if command -v jq >/dev/null 2>&1; then
  curl "${ARGS[@]}" -o "$RESP_FILE"
  jq . "$RESP_FILE"
else
  # When jq isn't installed, use curl and print raw response
  curl "${ARGS[@]}" -o "$RESP_FILE"
  cat "$RESP_FILE"
fi

# Extract deployment id
if command -v jq >/dev/null 2>&1; then
  DEPLOY_ID=$(jq -r '.id // .deploymentId // .data?.id // empty' "$RESP_FILE")
else
  DEPLOY_ID=$(sed -n 's/.*"id"[[:space:]]*:[[:space:]]*"\([^"]*\)".*/\1/p' "$RESP_FILE" | head -n1)
fi

if [ -z "$DEPLOY_ID" ]; then
  echo "Could not determine deployment id from response" >&2
  exit 1
fi

echo "Deployment created: id=$DEPLOY_ID"

echo "GET $BASE/repository/deployments/$DEPLOY_ID"
if command -v jq >/dev/null 2>&1; then
  curl -sS "$BASE/repository/deployments/$DEPLOY_ID" | jq .
else
  curl -sS "$BASE/repository/deployments/$DEPLOY_ID"
fi

echo "OK"
