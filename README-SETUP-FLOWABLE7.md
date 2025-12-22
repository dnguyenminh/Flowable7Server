# Flowable 7 — Server Setup Instructions ✅

## 🔧 Overview
This document explains how to set up and run a Flowable **version 7** server from source (or from a built artifact). It covers prerequisites, building, running locally, a simple Docker Compose example for the database and the application, configuration examples, verification steps, and troubleshooting tips.

> Note: Always consult the official Flowable docs for version-specific details: https://www.flowable.com/open-source/

---

## 🧰 Prerequisites
- **Java JDK 21** (LTS recommended). Java 17 is still compatible for many flows, but this repository is compiled for **Java 21**.
- **Apache Maven 3.6+** (3.8/3.9 recommended for best compatibility; this project was built with Maven 3.9.x)
- **Git** (if cloning source)
- **Docker & Docker Compose** (optional — for running DB or containerized app)
- A supported relational database (PostgreSQL or MySQL recommended)

---

## 1) Prepare the database (Docker example) 🐘
A simple Postgres Compose definition you can use for local development:

```yaml
# docker-compose.db.yml
version: '3.7'
services:
  postgres:
    image: postgres:14
    environment:
      - POSTGRES_USER=flowable
      - POSTGRES_PASSWORD=flowable
      - POSTGRES_DB=flowable
    ports:
      - "5432:5432"
    volumes:
      - flowable-pg-data:/var/lib/postgresql/data

volumes:
  flowable-pg-data:
```

Start DB:

```bash
docker compose -f docker-compose.db.yml up -d
```

---

## 2) Build Flowable server from source (or build artifact) ⚙️
If you're working from this repository root or the Flowable server module:

1. Ensure environment variables (or application.properties) are set for DB connection:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/flowable
spring.datasource.username=flowable
spring.datasource.password=flowable
spring.jpa.hibernate.ddl-auto=update
```

2. Build using Maven:

```bash
# from project root
mvn -DskipTests clean package
```

Notes:
- If the server is a Spring Boot microservice/module, you can run it directly with:
  ```bash
  mvn -pl <server-module> spring-boot:run
  # or
  java -jar <module>/target/<artifact>.jar
  ```
- If the project is multi-module, adjust <server-module> to point to the appropriate module (e.g., `flowable-spring-boot-server`, `flowable-rest`, or similar).

---

## 3) Run the server locally ▶️
- If using `spring-boot:run`:

```bash
mvn -pl <server-module> spring-boot:run -Dspring-boot.run.arguments="--spring.datasource.url=jdbc:postgresql://localhost:5432/flowable --spring.datasource.username=flowable --spring.datasource.password=flowable"
```

- If using a packaged JAR:

```bash
java -Xms512m -Xmx1g -jar target/<artifact>.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/flowable --spring.datasource.username=flowable --spring.datasource.password=flowable
```

Check logs for successful startup and that the application has connected to the database.

---

## 4) Dockerize the app (optional) 🐳
Simple `Dockerfile` example (build the JAR with Maven first):

```dockerfile
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
```

Add a service to a `docker-compose.yml`:

```yaml
version: '3.7'
services:
  db:
    image: postgres:14
    environment:
      - POSTGRES_USER=flowable
      - POSTGRES_PASSWORD=flowable
      - POSTGRES_DB=flowable
  flowable-app:
    build: .
    depends_on:
      - db
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/flowable
      - SPRING_DATASOURCE_USERNAME=flowable
      - SPRING_DATASOURCE_PASSWORD=flowable
    ports:
      - "8080:8080"
```

Run:
```bash
docker compose up --build
```

---

## 5) Verify the server is running ✅
- Check the application logs; look for successful startup lines produced by Spring Boot (e.g., "Started" and listening port).
- If Actuator is enabled, check:
  ```bash
  curl -s http://localhost:8080/actuator/health | jq
  ```
- If Flowable provides REST endpoints or UI in your build, browse to `http://localhost:8080/` and follow the UI paths (e.g., /task, /modeler, or /flowable-rest depending on packaging).

---

## 6) Configuration & environment variables 🔧
Common Spring Boot properties to set (examples):

```properties
# DB
spring.datasource.url=jdbc:postgresql://localhost:5432/flowable
spring.datasource.username=flowable
spring.datasource.password=flowable
# Server
server.port=8080
# Logging / actuator
management.endpoints.web.exposure.include=health,info,metrics
```

Test note: there is a Testcontainers-based integration test that starts the official Flowable REST image and performs a REST smoke check. To run the full deploy/start workflow the test reads the following environment variables and will skip authenticated steps if they are not set:

- `FLOWABLE_REST_ADMIN_USER` — admin username for the REST API
- `FLOWABLE_REST_ADMIN_PASSWORD` — password for the REST API

Example (run locally with credentials):

```bash
FLOWABLE_REST_ADMIN_USER=admin FLOWABLE_REST_ADMIN_PASSWORD=test mvn -Dtest=FlowableRestIT test
```

### Other integration tests & test utilities 🔬

- The repository also includes a focused CMMN integration test `CmmnApiCaseCreationIT` which attempts to create a case via the CMMN REST API. It will try to deploy `src/test/resources/cases/skip-tracing.cmmn` before creating the case (if the file exists), probe likely endpoints, and will skip the test if a compatible CMMN create endpoint is not available on the image used.
- Useful test helpers are available in `src/test/java/com/example/flowable/FlowableTestUtils.java` (deployment helpers, await helpers that use Awaitility, and HTTP/Feign helpers) and `FlowableFeignClient.java` (typed Feign clients used by tests).

Tip: If you want to run only the focused CMMN test locally, set the credentials and run:

```bash
FLOWABLE_REST_ADMIN_USER=rest-admin FLOWABLE_REST_ADMIN_PASSWORD=test mvn -Dtest=CmmnApiCaseCreationIT test
```

The test will log diagnostics on non-success responses to help debugging when running different Flowable REST image variants.

CI note: to run the authenticated REST integration job in GitHub Actions, add the following repository secrets:

- `FLOWABLE_REST_ADMIN_USER` — admin username to be used by the test job
- `FLOWABLE_REST_ADMIN_PASSWORD` — password for that user

After adding these secrets, the `REST Integration Tests (Flowable - authenticated)` workflow will run a full deployment and start sequence against the official Flowable REST container and assert process/case creation.

You can pass these as CLI args, environment variables (SPRING_DATASOURCE_URL), or in `application.properties` / `application.yml`.

---

## 7) Troubleshooting ⚠️
- DB connection errors: ensure the DB container is up and credentials/URL match.
- Schema errors: check `spring.jpa.hibernate.ddl-auto` or Flowable DB migration logs.
- Port conflicts: change `server.port`.
- Memory issues: increase JVM Xmx or reduce other processes.

---

## 8) Next steps / tips 💡
- To run UI components (Modeler, Task, Admin), refer to the official docs for the correct modules and endpoints.
- For production deployments, use a managed DB, configure connection pooling, enable HTTPS, and secure endpoints.
- Consult the official docs for Flowable 7 for version-specific guidance: https://www.flowable.com/open-source/

---

## ❓ Need custom instructions?
If you want, I can:

If you'd like any of those, tell me which one to do next.

---

## Included repo files (added) 📁
The repository now includes example files you can use as a starting point:

- `Dockerfile` — basic image that expects a built JAR at `target/*.jar` and exposes port `8080`.
- `docker-compose.yml` — brings up a `postgres:14` database and builds/runs the `flowable-app` image.
- `src/main/resources/application.yml` — sample Spring Boot configuration for Postgres and Actuator.
 - `src/test/resources/processes/simple-process.bpmn20.xml` — sample BPMN used by the H2-based integration tests (moved from main resources to test resources).
 - `src/main/resources/application.yml` — sample Spring Boot configuration for Postgres and Actuator.

### OpenAPI-based test generator 🔧

- This repository includes a small Java utility that generates basic integration test scaffolding from the OpenAPI subset in `docs/openapi/`.
- It runs automatically during the Maven `generate-test-sources` phase and writes `src/test/java/com/example/flowable/GeneratedOpenApiIntegrationTest.java`.
- To regenerate tests locally run:

```bash
mvn generate-test-sources
```

The generator is implemented in `com.example.flowable.tools.OpenApiToTestsGenerator` and uses SnakeYAML to parse the minimal OpenAPI YAML.

Note: This repository currently uses **Spring Boot 3.2.12** and **Flowable 7.2.0**.
- `.dockerignore` — ignores `target/` and other files from Docker builds.

Quick usage:

1. Build the JAR locally:

```bash
mvn -DskipTests clean package
```

2. Start DB + app with Docker Compose:

```bash
docker compose up --build
```

3. Verify the app is reachable on `http://localhost:8080/` and check health at `/actuator/health`.

If you'd like, I can also create a small `Makefile` or GitHub Actions workflow to build and push an image.

---

*File generated by GitHub Copilot — use as a starting point and confirm module names/paths against the repository and official docs.*
