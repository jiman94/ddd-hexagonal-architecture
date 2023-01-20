# Domain Driven Design and Hexagonal Architecture
An example approach for designing and implementing a **DDD Hexagonal Architecture** with **Spring Boot**

## 1. Domain Driven Design
**Micro-services** should be designed around business capabilities & they should have loose coupling and high functional cohesion. Micro-services are loosely coupled if you can change one service without requiring other services to be updated at the same time. A micro-service is cohesive if it has a single, well-defined purpose, such as managing user accounts or tracking delivery history. A service should encapsulate domain knowledge and abstract that knowledge from clients\

![DDD!](/assets/images/ddd.png "Domain Driven Design")

## 2. DDD & Hexagonal Architecture
**Hexagonal** architecture is an alternative to the layered architectural style. The hexagonal architecture style organizes the logical view in a way that places the business logic at the center. Instead of the presentation layer, the application has one or more inbound adapters that handle requests from the outside by invoking the business logic. Similarly, instead of a data persistence tier, the application has one or more outbound adapters that are invoked by the business logic and invoke external applications. A key characteristic and benefit of this architecture is that the business logic doesn’t depend on the adapters. Instead, they depend upon it

The business logic has one or more **ports**. A **port** defines a set of operations and is how the business logic interacts with what’s outside of it. In Java, for example, a **port** is often a Java interface. There are two kinds of ports: inbound and outbound ports. An inbound port is an API exposed by the business logic, which enables it to be invoked by external applications. An example of an inbound port is a service interface, which defines a service’s public methods. An outbound port is how the business logic invokes external systems. An example of an output port is a repository interface, which defines a collection of data access operations

An important benefit of the hexagonal architectural style is that it decouples the business logic from the presentation and data access logic in the adapters. The business logic doesn’t depend on either the presentation logic or the data access logic

Because of this decoupling, it’s much easier to test the business logic in isolation. Another benefit is that it more accurately reflects the architecture of a modern application. The business logic can be invoked via multiple adapters, each of which implements a particular API or UI. The business logic can also invoke multiple adapters, each one of which invokes a different external system. Hexagonal architecture is a great way to describe the architecture of each service in a microservice architecture

![DDD & Hexagonal Architecture!](/assets/images/ddd_hexagonal_architecture.png "DDD & Hexagonal Architecture")

## 3. Logging and Monitoring Solution
The 3 pillars of observability: **logs**, **metrics** and **traces**
- **Logs** are files that record events, warnings and errors as they occur within a software environment
- **Metrics** are quantifiable measurements that reflect the health and performance of applications or infrastructure (e.g. application metrics might track how many transactions the application handles per second, while infrastructure metrics measure how many CPU or memory resources are consumed on a server)
- A **Distributed Trace** is data that tracks an application request as it flows through the various parts of an application

This demo application demonstrates how to monitor a Java Spring Boot application using open source observability software. The following projects are used:
- [OpenTelemetry](https://opentelemetry.io/) - Instrument the application and send observability data to each backend
- [Jaeger](https://www.jaegertracing.io/) - Distributed tracing backend
- [Prometheus](https://prometheus.io/) - Metrics and alerting backend
- [Loki](https://grafana.com/oss/loki/) - Logs aggregation system
- [Grafana](https://grafana.com/) - Visualize all of our observability data

**Logging and Monitoring Solution**\
![Logging and Monitoring Solution!](/assets/images/logging_monitoring_solution.png "Logging and Monitoring Solution")

3.1. Install & run Jaeger
```
$ docker run -d --name jaeger \
  -e COLLECTOR_ZIPKIN_HOST_PORT=:9411 \
  -e COLLECTOR_OTLP_ENABLED=true \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 4317:4317 \
  -p 4318:4318 \
  -p 14250:14250 \
  -p 14268:14268 \
  -p 14269:14269 \
  -p 9411:9411 \
  jaegertracing/all-in-one:latest
```
3.2. Access to the link http://localhost:16686 to test the Jaeger UI\

3.3. Automatic instrumentation with Java uses a Java agent JAR (opentelemetry-javaagent.jar the latest version download from https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases
```
$ java -javaagent:./assets/tracing/opentelemetry-javaagent.jar \
     -Dotel.resource.attributes=service.name=DDDHexagonalArchitectureApplication \
     -Dotel.traces.exporter=jaeger \
     -Dotel.metrics.exporter=prometheus \
     -Dotel.traces.exporter=logging \
     -jar target/dddhexagonalarchitecture-0.0.1.jar
     
 $ java -javaagent:./assets/tracing/opentelemetry-javaagent.jar -Dotel.resource.attributes=service.name=DDDHexagonalArchitectureApplication -Dotel.traces.exporter=jaeger -jar target/dddhexagonalarchitecture-0.0.1.jar
```
3.4. Search Logs
![Jaeger Search!](/assets/images/jaeger_ui.png "Jaeger Search")

## 4. API Documentation - Swagger
To have springdoc-openapi automatically generate the OpenAPI 3 specification docs for API, just simply add the springdoc-openapi-ui dependency to the **pom.xml**:
```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.14</version>
</dependency>
```

After running the application go to the following address to see the API documentation
http://localhost:9090/swagger-ui.html

![The Order Swagger!](/assets/images/order_swagger.png "Order Swagger")

## 5. API Testing
Import ***[assets/ddd_hexagonal_architecture_postman_collection.json]*** file to the **Postman** application to test API

## 6. Reference
[OpenTelemetry in Java](https://opentelemetry.io/docs/instrumentation/java/automatic)\
[Using domain analysis to model microservices](https://docs.microsoft.com/en-us/azure/architecture/microservices/model/domain-analysis)