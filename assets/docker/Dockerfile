FROM openjdk:18-ea-11-jdk-alpine3.15
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG JAR_AGENT_FILE=assets/tracing/*.jar
COPY ${JAR_FILE} app.jar
COPY ${JAR_AGENT_FILE} otel_agent.jar
EXPOSE 2706
ENTRYPOINT ["java","-javaagent:./otel_agent.jar", "-Dotel.service.name=ddd_hexagonal_architecture", "-Dotel.traces.exporter=jaeger", "-Dotel.metrics.exporter=prometheus", "-Dotel.logs.exporter=logging", "-jar", "app.jar"]