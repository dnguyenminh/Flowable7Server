# Flowable 7 — Server Setup Instructions ✅

## 🔧 Overview
This document explains how to set up and run a Flowable **version 7** server from source (or from a built artifact). It covers prerequisites, building, running locally, a simple Docker Compose example for the database and the application, configuration examples, verification steps, and troubleshooting tips.

> Note: Always consult the official Flowable docs for version-specific details: https://www.flowable.com/open-source/

---

## 🧰 Prerequisites
- **Java JDK 17+** (LTS recommended — 17 or 21)
- **Apache Maven 3.6+** (for building from source)
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
FROM eclipse-temurin:17-jre
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
