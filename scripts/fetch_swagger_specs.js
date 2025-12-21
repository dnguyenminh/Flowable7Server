#!/usr/bin/env node
const http = require('http');
const https = require('https');
const fs = require('fs');
const path = require('path');

const specs = [
  'specfile/process/flowable-swagger-process.json',
  'specfile/idm/flowable-swagger-idm.json',
  'specfile/dmn/flowable-swagger-decision.json',
  'specfile/eventregistry/flowable-swagger-eventregistry.json',
  'specfile/app/flowable-swagger-app.json',
  'specfile/external-worker/flowable-swagger-external-worker.json'
];

const base = process.argv[2] || process.env.FLOWABLE_BASE || 'http://localhost:32988/flowable-rest';
const user = process.argv[3] || process.env.FLOWABLE_USER || 'rest-admin';
const pass = process.argv[4] || process.env.FLOWABLE_PASS || 'test';

const outdir = path.join(__dirname, '..', 'docs', 'openapi', 'server_fetch');
fs.mkdirSync(outdir, { recursive: true });

function fetchOne(relPath) {
  return new Promise((resolve, reject) => {
    const url = new URL(relPath, base);
    const mod = url.protocol === 'https:' ? https : http;
    const opts = {
      hostname: url.hostname,
      port: url.port || (url.protocol === 'https:' ? 443 : 80),
      path: url.pathname + (url.search || ''),
      method: 'GET',
      headers: {
        'Authorization': 'Basic ' + Buffer.from(user + ':' + pass).toString('base64'),
        'Accept': 'application/json'
      }
    };
    console.error('Fetching', url.href);
    const req = mod.request(opts, res => {
      let data = '';
      res.setEncoding('utf8');
      res.on('data', chunk => data += chunk);
      res.on('end', () => {
        if (res.statusCode >= 200 && res.statusCode < 300) {
          // if HTML returned, try to extract specfile query param or error
          const ctype = (res.headers['content-type'] || '').toLowerCase();
          if (ctype.includes('text/html')) {
            // write HTML for inspection
            const fname = path.basename(relPath).replace(/[^A-Za-z0-9._-]/g, '_') + '.html';
            const fpath = path.join(outdir, fname);
            fs.writeFileSync(fpath, data, 'utf8');
            console.error('Wrote HTML to', fname);

            // Try to discover JSON spec URLs inside the HTML
            const found = new Set();
            const patterns = [
              /url\s*[:=]\s*['"]([^'"\)]+\.json[^'"\)]*)['"]/ig,
              /href\s*=\s*['"]([^'"\)]+\.json[^'"\)]*)['"]/ig,
              /src\s*=\s*['"]([^'"\)]+\.json[^'"\)]*)['"]/ig,
              /['"](https?:[^'"\)]+\.json[^'"\)]*)['"]/ig,
              /\?url=([^'"&>\)]+)/ig
            ];
            for (const pat of patterns) {
              let m;
              while ((m = pat.exec(data)) !== null) {
                let candidate = m[1];
                // strip wrapping quotes or trailing params
                candidate = candidate.replace(/\s+$/,'');
                // If query param form '?url=specfile/..', decode
                try { candidate = decodeURIComponent(candidate); } catch (e) {}
                // normalize absolute or relative
                try {
                  const absolute = new URL(candidate, url.href).href;
                  found.add(absolute);
                } catch (e) {
                  // ignore
                }
              }
            }

            // Try to extract embedded JSON in <script> blocks (contains "openapi" or "swagger")
            const scriptJsonRe = /<script[^>]*>([\s\S]*?)<\/script>/ig;
            let sMatch;
            while ((sMatch = scriptJsonRe.exec(data)) !== null) {
              const body = sMatch[1];
              // find object containing "openapi" or "swagger"
              const keyRe = /("openapi"|"swagger")/i;
              if (keyRe.test(body)) {
                // try to find JSON substring starting near the key
                const idx = body.search(keyRe);
                const from = body.lastIndexOf('{', idx);
                if (from >= 0) {
                  // attempt to find the matching closing brace
                  let stack = 0;
                  let end = -1;
                  for (let i = from; i < body.length; i++) {
                    if (body[i] === '{') stack++;
                    else if (body[i] === '}') { stack--; if (stack === 0) { end = i; break; } }
                  }
                  if (end > from) {
                    const jsonStr = body.substring(from, end + 1);
                    try {
                      const obj = JSON.parse(jsonStr);
                      const outname = path.basename(relPath).replace(/\.html$/,'') + '-embedded.json';
                      fs.writeFileSync(path.join(outdir, outname), JSON.stringify(obj, null, 2), 'utf8');
                      console.error('Extracted embedded JSON to', outname);
                      found.add(new URL(outname, 'file:').href);
                    } catch (e) {
                      // not valid JSON, skip
                    }
                  }
                }
              }
            }

            // Follow discovered JSON URLs
            (async () => {
              for (const u of found) {
                if (!fetched.has(u)) {
                  try {
                    console.error('Following discovered JSON URL:', u);
                    await fetchOne(u);
                  } catch (e) {
                    console.error('Failed to fetch discovered URL', u, e.message);
                  }
                }
              }
            })().then(() => resolve({ type: 'html', path: fname })).catch(err => reject(err));
          } else {
            // save as json file with original basename
            const fname = path.basename(relPath);
            fs.writeFileSync(path.join(outdir, fname), data, 'utf8');
            console.error('Saved', fname);
            resolve({ type: 'json', path: fname });
          }
        } else {
          reject(new Error('HTTP ' + res.statusCode + ' for ' + url.href));
        }
      });
    });
    req.on('error', err => reject(err));
    req.end();
  });
}

(async () => {
  for (const s of specs) {
    try {
      await fetchOne(s);
    } catch (e) {
      console.error('Failed to fetch', s, e.message);
    }
  }
  console.error('Done');
})();
