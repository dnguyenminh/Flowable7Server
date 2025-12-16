# Simple Dockerfile for running the Flowable 7 Spring Boot app
# Assumes a JAR is produced at target/*.jar (build locally with Maven first)
FROM eclipse-temurin:21-jre
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
