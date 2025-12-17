#!/usr/bin/env bash
# Minimal Gradle wrapper bootstrapper: downloads a Gradle distribution on first run
set -euo pipefail

GRADLE_VERSION="8.5"
DIST_URL="https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
ROOT_DIR=$(cd "$(dirname "$0")" && pwd)
CACHE_DIR="$ROOT_DIR/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}-bin"
ZIP_FILE="$CACHE_DIR/gradle-${GRADLE_VERSION}-bin.zip"
EXTRACT_DIR="$CACHE_DIR/gradle-${GRADLE_VERSION}"

mkdir -p "$CACHE_DIR"

if [ ! -x "$EXTRACT_DIR/bin/gradle" ]; then
  echo "Gradle ${GRADLE_VERSION} not found, downloading ${DIST_URL}..."
  tmpzip=$(mktemp)
  if command -v curl >/dev/null 2>&1; then
    curl -fSL "$DIST_URL" -o "$tmpzip"
  elif command -v wget >/dev/null 2>&1; then
    wget -O "$tmpzip" "$DIST_URL"
  else
    echo "Error: neither curl nor wget is available to download Gradle." >&2
    exit 1
  fi
  unzip -q "$tmpzip" -d "$CACHE_DIR"
  rm -f "$tmpzip"
  # The unzip will create a folder like gradle-<version>
  actual_dir=$(ls -d "$CACHE_DIR"/gradle-* | head -n1)
  if [ "$actual_dir" != "$EXTRACT_DIR" ]; then
    mv "$actual_dir" "$EXTRACT_DIR"
  fi
  chmod +x "$EXTRACT_DIR/bin/gradle"
fi

exec "$EXTRACT_DIR/bin/gradle" "$@"
