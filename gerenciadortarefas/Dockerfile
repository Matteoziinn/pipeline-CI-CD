# Stage 1: build (usa Maven com JDK 17)
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /workspace
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

# Stage 2: runtime (imagem oficial OpenJDK disponível)
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
