#!/usr/bin/env bash
set -euo pipefail

# Usage: ./scripts/regenerate_server_openapi_docs.sh [base-url] [user] [pass] [mode]
# Example: ./scripts/regenerate_server_openapi_docs.sh http://localhost:32988/flowable-rest rest-admin test examples

BASE=${1:-http://localhost:32988/flowable-rest}
USER=${2:-rest-admin}
PASS=${3:-test}
MODE=${4:-examples}

echo "Fetching OpenAPI JSON specs from $BASE (user=$USER)"
node scripts/fetch_swagger_specs.js "$BASE" "$USER" "$PASS"

echo "Generating combined markdown..."
node scripts/generate_swagger_md.js

echo "Splitting module markdowns into per-prefix files (mode=$MODE)..."
for md in docs/openapi/flowable-swagger-*.md; do
	echo "Splitting $md"
	mvn -DskipTests compile exec:java -Dexec.mainClass="com.example.flowable.tools.SplitSwaggerMdByPath" -Dexec.args="$md --mode=$MODE"
done

echo "Done"
