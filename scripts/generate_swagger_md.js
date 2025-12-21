const fs = require('fs');
const path = require('path');

const inDir = path.join(__dirname, '..', 'docs', 'openapi');
const outFile = path.join(inDir, 'flowable-api.md');

function safe(s) { return s ? String(s).trim() : ''; }

let files = fs.readdirSync(inDir).filter(f => f.startsWith('flowable-swagger-') && f.endsWith('.json'));
const serverFetchDir = path.join(inDir, 'server_fetch');
if (fs.existsSync(serverFetchDir)) {
  const serverFiles = fs.readdirSync(serverFetchDir).filter(f => f.startsWith('flowable-swagger-') && f.endsWith('.json'))
    .map(f => path.join('server_fetch', f));
  files = files.concat(serverFiles);
}
let out = [];
out.push('# Flowable REST API (generated from per-module Swagger JSON)\n');
out.push('> NOTE: integration tests require CMMN *create* endpoints (e.g. POST /cmmn-api/case-instances). If your image exposes only query endpoints, tests will fail.\n');
out.push('Generated from:');
for (const f of files) { out.push('- docs/openapi/' + f); }
out.push('\n---\n');

const yaml = require('js-yaml');
for (const f of files) {
  const baseName = path.basename(f);
  const mod = baseName.replace('flowable-swagger-', '').replace('.json','');
  out.push('## Module: ' + mod + '\n');
  const raw = fs.readFileSync(path.join(inDir, f), 'utf8');
  let json;
  try {
    json = JSON.parse(raw);
  } catch (e) {
    // Fallback to YAML parser which is more tolerant for some Swagger dumps
    try { json = yaml.load(raw); } catch (e2) { console.error('Failed to parse', f, e2); continue; }
  }
  const paths = json.paths || {};
  const rows = [];
  for (const p of Object.keys(paths).sort()) {
    for (const m of Object.keys(paths[p])) {
      const op = paths[p][m];
      const summary = safe(op.summary) || (safe(op.description).split('\n')[0] || '');
      const params = (op.parameters || []).map(pr => pr.name + ' (' + pr.in + (pr.required ? ',required' : '') + ')').join(', ');
      rows.push({p,m,summary,params,op});
    }
  }
  if (rows.length === 0) {
    out.push('_No paths found in this module._\n');
    continue;
  }
  // Build a per-module markdown file as well
  const moduleLines = [];
  moduleLines.push('# flowable-swagger-' + mod + '\n');
  moduleLines.push('> Generated subset extracted from ' + f + '\n');
  moduleLines.push('| Method | Path | Summary | Params |');
  moduleLines.push('|---|---|---|---|');
  for (const r of rows) {
    const line = '| ' + r.m.toUpperCase() + ' | `' + r.p + '` | ' + r.summary + ' | ' + r.params + ' |';
    moduleLines.push(line);
    out.push('| ' + r.m.toUpperCase() + ' | `' + r.p + '` | ' + r.summary + ' | ' + r.params + ' |');

    // add detailed operation info
    if (r.op) {
      moduleLines.push('');
      moduleLines.push('### ' + r.m.toUpperCase() + ' ' + r.p);
      if (r.op.summary || r.op.description) {
        moduleLines.push('');
        moduleLines.push(safe(r.op.description || r.op.summary));
      }

      const allParams = (r.op.parameters || []);
      if (allParams.length > 0) {
        moduleLines.push('');
        moduleLines.push('| Name | In | Required | Schema | Description | Example |');
        moduleLines.push('|---|---|---:|---|---|---|');
        for (const pinfo of allParams) {
          const name = safe(pinfo.name);
          const loc = safe(pinfo.in);
          const req = pinfo.required ? 'yes' : '';
          let schema = '';
          if (pinfo.schema) schema = pinfo.schema.$ref || pinfo.schema.type || '';
          let ex = '';
          if (pinfo.example) ex = JSON.stringify(pinfo.example, null, 2);
          else if (pinfo.schema && pinfo.schema.example) ex = JSON.stringify(pinfo.schema.example, null, 2);
          moduleLines.push('| ' + name + ' | ' + loc + ' | ' + req + ' | ' + schema + ' | ' + safe(pinfo.description) + ' | ' + ex + ' |');
        }
      }

      const rb = r.op.requestBody || (r.op.parameters || []).find(x => x.in === 'body');
      if (rb) {
        moduleLines.push('');
        moduleLines.push('**Request**');
        if (rb.content && rb.content['application/json']) {
          const app = rb.content['application/json'];
          if (app.example) moduleLines.push('\n```json\n' + JSON.stringify(app.example, null, 2) + '\n```');
          else if (app.examples) {
            const exName = Object.keys(app.examples)[0];
            const exVal = app.examples[exName] && app.examples[exName].value ? app.examples[exName].value : null;
            if (exVal) moduleLines.push('\n```json\n' + JSON.stringify(exVal, null, 2) + '\n```');
          } else if (app.schema) {
            moduleLines.push('\n```json\n' + JSON.stringify(app.schema, null, 2) + '\n```');
          }
        } else if (rb.schema) {
          moduleLines.push('\n```json\n' + JSON.stringify(rb.schema, null, 2) + '\n```');
        }
      }

      if (r.op.responses) {
        moduleLines.push('');
        moduleLines.push('**Responses**');
        for (const code of Object.keys(r.op.responses)) {
          const resp = r.op.responses[code];
          moduleLines.push('');
          moduleLines.push('- **' + code + '**: ' + safe(resp.description));
          if (resp.content && resp.content['application/json']) {
            const app = resp.content['application/json'];
            if (app.example) moduleLines.push('\n```json\n' + JSON.stringify(app.example, null, 2) + '\n```');
            else if (app.examples) {
              const exName = Object.keys(app.examples)[0];
              const exVal = app.examples[exName] && app.examples[exName].value ? app.examples[exName].value : null;
              if (exVal) moduleLines.push('\n```json\n' + JSON.stringify(exVal, null, 2) + '\n```');
            } else if (app.schema) {
              moduleLines.push('\n```json\n' + JSON.stringify(app.schema, null, 2) + '\n```');
            }
          } else if (resp.schema) {
            moduleLines.push('\n```json\n' + JSON.stringify(resp.schema, null, 2) + '\n```');
          }
        }
      }
    }
  }
  out.push('\n');
  const moduleFile = path.join(inDir, 'flowable-swagger-' + mod + '.md');
  fs.writeFileSync(moduleFile, moduleLines.join('\n') + '\n', 'utf8');
  console.log('Wrote', moduleFile);
}

fs.writeFileSync(outFile, out.join('\n'), 'utf8');
console.log('Wrote', outFile);
