FROM openjdk:18-ea-11-jdk-alpine3.15
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG JAR_AGENT_FILE=assets/tracing/*.jar
COPY ${JAR_FILE} ddd_hexagonal_architecture.jar
COPY ${JAR_AGENT_FILE} opentelemetry_javaagent.jar
EXPOSE 9090
ENTRYPOINT ["java","-javaagent:./opentelemetry_javaagent.jar", "-Dotel.service.name=ddd_hexagonal_architecture", "-Dotel.traces.exporter=zipkin", "-jar", "ddd_hexagonal_architecture.jar"]