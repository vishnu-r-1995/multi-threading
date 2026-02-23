# Multi-stage build for Java multithreading examples
# Build stage
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
# Download dependencies first (cached layer)
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests -B

# Run stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
COPY --from=builder /app/target/classes /app/classes

# For running individual classes directly
ENTRYPOINT ["java", "-cp", "/app/classes"]