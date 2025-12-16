#!/usr/bin/env python3
"""Generate a JUnit integration test from a minimal OpenAPI YAML.
This script is intentionally simple and only generates tests for POST/GET endpoints
with JSON bodies or query/path params based on the spec in docs/openapi/flowable-7.2.0-openapi.yaml
"""
import sys
from pathlib import Path

try:
    import yaml
except Exception:
    print("PyYAML is required. Install with: pip install pyyaml", file=sys.stderr)
    sys.exit(2)

ROOT = Path(__file__).resolve().parents[1]
SPEC = ROOT / 'docs' / 'openapi' / 'flowable-7.2.0-openapi.yaml'
OUT = ROOT / 'src' / 'test' / 'java' / 'com' / 'example' / 'flowable' / 'GeneratedOpenApiIntegrationTest.java'

with open(SPEC, 'r') as fh:
    spec = yaml.safe_load(fh)

paths = spec.get('paths', {})

imports = '''package com.example.flowable;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.*;
import java.util.Map;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GeneratedOpenApiIntegrationTest {

    @Autowired
    TestRestTemplate rest;
'''

methods = []

cnt = 1
for path, ops in paths.items():
    for method, op in ops.items():
        name = f"test_{method}_{path.strip('/').replace('/', '_').replace('{','').replace('}','')}"
        fn = []
        fn.append(f"    @Test")
        fn.append(f"    public void {name}() throws Exception {{")
        # build request based on requestBody/examples
        req_schema = None
        if 'requestBody' in op and op['requestBody']:
            content = op['requestBody'].get('content', {})
            json = content.get('application/json')
            if json and '$ref' in json.get('schema', {}):
                # simple map example
                ref = json['schema']['$ref']
                # use simple example content
                fn.append("        HttpHeaders headers = new HttpHeaders();")
                fn.append("        headers.setContentType(MediaType.APPLICATION_JSON);")
                # make body examples per path
                if 'decision' in path:
                    body = '{\"decisionKey\": \"isAdult\", \"variables\": {\"age\": 20}}'
                elif 'message' in path:
                    body = '{\"messageName\": \"Ping\", \"processInstanceId\": \"fake-id\"}'
                elif 'instances' in path:
                    body = '{\"approved\": true}'
                elif 'start' in path and 'process' in path:
                    body = '{\"key\": \"simpleProcess\"}'
                elif 'start' in path and 'case' in path:
                    body = '{\"key\": \"simpleCase\"}'
                else:
                    body = '{}'
                fn.append(f"        HttpEntity<String> entity = new HttpEntity<>(\"{body}\", headers);")
                fn.append(f"        ResponseEntity<String> resp = rest.postForEntity(\"{path}\", entity, String.class);")
                fn.append("        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();")
            else:
                # no body -> simple get
                fn.append(f"        ResponseEntity<String> resp = rest.getForEntity(\"{path}\", String.class);")
                fn.append("        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();")
        else:
            # GET operations or endpoints without request bodies
            if method.lower() == 'get':
                # include a dummy query for tasks
                url = path
                if '{' in url:
                    # replace path params with dummy values
                    url = url.replace('{id}', 'dummy-id')
                if 'tasks' in url and 'processInstanceId' in op.get('parameters', [{}])[0].get('name',''):
                    url = url + "?processInstanceId=dummy-id"
                fn.append(f"        ResponseEntity<String> resp = rest.getForEntity(\"{url}\", String.class);")
                fn.append("        assertThat(resp.getStatusCode().is2xxSuccessful()).isTrue();")
            else:
                fn.append("        // request body not provided in spec; skipping")
        fn.append("    }")
        methods.append('\n'.join(fn))
        cnt += 1

out = imports + '\n\n' + '\n\n'.join(methods) + '\n}\n'

OUT.parent.mkdir(parents=True, exist_ok=True)
with open(OUT, 'w') as fh:
    fh.write(out)

print(f"Generated test file: {OUT}")
