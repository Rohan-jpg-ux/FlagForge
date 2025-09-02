# Build stage
FROM gradle:8.8-jdk21 AS build
WORKDIR /app/backed
COPY backend/ ./
RUN gradle clean bootJar --no-daemon

# Runtime stage (multi-arch; works on Apple Silicon)
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/backend/build/libs/backend-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]