# Domain Driven Design and Hexagonal Architecture
An example approach for designing and implementing a **DDD Hexagonal Architecture** with **Spring Boot** with different input adapters like **REST** or **GraphQL**

Regarding the Microservice architecture please refer to my repository to see details [Microservice Architecture](https://github.com/raycad/go-microservices)

## 1. Domain Driven Design
**Micro-services** should be designed around business capabilities & they should have loose coupling and high functional cohesion. **Micro-services** are loosely coupled if you can change one service without requiring other services to be updated at the same time. A micro-service is cohesive if it has a single, well-defined purpose, such as managing user accounts or tracking delivery history. A service should encapsulate domain knowledge and abstract that knowledge from clients

![DDD!](/assets/images/ddd.png "Domain Driven Design")

## 2. Hexagonal Architecture
**Hexagonal Architecture** creates dependency rules can decouple the layers. The hexagonal architecture is also called the **Ports** and **Adapters**. The outer layers may only depend on the inner layers, and the inner layers should not rely on the outer ones. Each layer is defined as follows:

### 2.1. Infrastructure Layer
The **Infrastructure Layer** contains code interfaces with application infrastructure – controllers, UI, presenters, persistence, and gateways through the **input/output adapters** to external systems

### 2.2. Application Layer
The **Application Layer** provides an API for all **functionality/use cases** provided by the application. It contains **input/output ports**, **application-specific business rules** and **decision making**. It accepts commands from the client (web, API, or CLI) and translates them into values understood by the domain layer. For example, a RegisterUser service would accept a Data Transfer Object containing a new user's credentials and delegate responsibility for creating a user to the domain layer

### 2.3. Domain Layer
The **Domain Layer** contains any **domain model**, **domain constraints/rules**. It deals entirely with **domain concepts** and **lacks knowledge of the outer layers**

### The application layer has incoming ports (use cases) that are called from incoming adapters, implemented by services, that use outcoming ports that are implemented by outgoing adapters

![Hexagonal Architecture!](/assets/images/ddd_hexagonal_architecture.png "Hexagonal Architecture")

**Port**
It is an interface for a task. The toolkit ports are designed to work on their own. For example: you can use the http_server module without importing the templates one, and the other way around (taking only the dependencies you need for your application).
Each **Port** may have different **implementations** (**Adapters**)
**Ports** *cannot be used by themselves* and in their place, an **adapter** *implementing* them should be added to the list of dependencies

**Adapter**
They are **implementations of a functionality/use cases** (**Port**) for a given **product/technology/use case**. Clients should only use **ports**' code (*not* **Adapters** *specific code*), *this makes them easy to switch among different adapters with minimum impact*
**Adapters** are independent of each other, and you can use **several adapters** for the **same port** in a **single application**. For example, you could use many Template adapters to support several template engines
**Adapter** names must start with their Port name

**Example**:

| PORT | ADAPTERS |
| --- | --- |
| HTTP Server | Netty, Netty Epoll, Jetty, Servlet |
| HTTP Client | Jetty |
| Templates | Pebble, FreeMarker |
| Serialization Formats | JSON, YAML, CSV, XML, TOML |

**Project Structure**
```
│   DDDHexagonalArchitectureApplication.java                     
│                                                                
├───application                                                  
│   ├───port                                                     
│   │   ├───input                                                
│   │   │   └───usecase                                          
│   │   │           CreateOrderUseCase.java                      
│   │   │           CreateRestaurantUseCase.java                 
│   │   │           GetOrderUseCase.java                         
│   │   │           GetRestaurantUseCase.java                    
│   │   │                                                        
│   │   └───output                                               
│   │       ├───eventsourcing                                    
│   │       │       OrderEventPublisherPort.java                 
│   │       │                                                    
│   │       └───persistence                                      
│   │               OrderPersistencePort.java                    
│   │               RestaurantPersistencePort.java               
│   │                                                            
│   └───service                                                  
│           OrderService.java                                    
│           RestaurantService.java                               
│                                                                
├───domain                                                       
│   ├───exception                                                
│   │       OrderNotFound.java                                   
│   │       RestaurantNotFound.java                              
│   │                                                            
│   ├───model                                                    
│   │       Order.java                                           
│   │       Restaurant.java                                      
│   │                                                            
│   └───validation                                               
│           OrderValidator.java                                  
│                                                                
└───infrastructure                                               
    └───adapter                                                  
        ├───config                                               
        │       BeanConfiguration.java                           
        │                                                        
        ├───input                                                
        │   ├───eventsourcing                                    
        │   │   └───eventlistener                                
        │   │           OrderEventListenerAdapter.java           
        │   │                                                    
        │   ├───graphql                                          
        │   │   │   OrderGraphQLAdapter.java                     
        │   │   │                                                
        │   │   ├───data                                         
        │   │   │   └───request                                  
        │   │   │           OrderInput.java                      
        │   │   │                                                
        │   │   └───mapper                                       
        │   │           OrderGraphQLMapper.java                  
        │   │                                                    
        │   └───rest                                             
        │       │   OrderRestAdapter.java                        
        │       │   RestaurantRestAdapter.java                   
        │       │                                                
        │       ├───data                                         
        │       │   ├───request                                  
        │       │   │       OrderCreateRequest.java              
        │       │   │       RestaurantCreateRequest.java         
        │       │   │                                            
        │       │   └───response                                 
        │       │           OrderCreateResponse.java             
        │       │           OrderQueryResponse.java              
        │       │           RestaurantCreateResponse.java        
        │       │           RestaurantQueryResponse.java         
        │       │                                                
        │       └───mapper                                       
        │               OrderRestMapper.java                     
        │               RestaurantRestMapper.java                
        │                                                        
        └───output                                               
            ├───customizedexception                              
            │   │   CustomizedExceptionAdapter.java              
            │   │                                                
            │   └───data                                         
            │       └───response                                 
            │               ExceptionResponse.java               
            │                                                    
            ├───eventsourcing                                    
            │   └───eventpublisher                               
            │       │   OrderEventPublisherAdapter.java          
            │       │                                            
            │       └───event                                    
            │               OrderCreatedEvent.java               
            │                                                    
            └───persistence                                      
                │   OrderPersistenceAdapter.java                 
                │   RestaurantPersistenceAdapter.java            
                │                                                
                ├───entity                                       
                │       OrderEntity.java                         
                │       RestaurantEntity.java                    
                │                                                
                ├───mapper                                       
                │       OrderPersistenceMapper.java              
                │       RestaurantPersistenceMapper.java         
                │                                                
                └───repository                                   
                        OrderRepository.java                     
                        RestaurantRepository.java                                                                                                                                              
```
**Create Order Sequence Diagram Example**
![Create Order Sequence Diagram!](/assets/images/create_order_sequence_diagram.png "Create Order Sequence Diagram")

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
- [Grafana](https://grafana.com/) - Visualize all of observability data

**Logging and Monitoring Solution**\
![Logging and Monitoring Solution!](/assets/images/logging_monitoring_solution.png "Logging and Monitoring Solution")

**3.1. Install & Run Jaeger**
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
Access to the links:
- http://localhost:16686 to test the Jaeger UI
- http://localhost:9464/metrics to test the Prometheus exporter server

3.2. Install & Run Prometheus
```
$ docker run -d --name prometheus -p 9090:9090 prom/prometheus:latest
```
Access to the link http://localhost:9090 to test the Prometheus

3.3. Automatic instrumentation with Java uses a Java agent JAR (opentelemetry-javaagent.jar the latest version download from https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases
```
$ export OTEL_METRICS_EXPORTER=otlp
$ java -javaagent:./assets/tracing/opentelemetry-javaagent.jar \
     -Dotel.resource.attributes=service.name=DDDHexagonalArchitectureApplication \
     -Dotel.traces.exporter=jaeger \
     -Dotel.metrics.exporter=prometheus \
     -Dotel.logs.exporter=logging \
     -jar target/dddhexagonalarchitecture-0.0.1.jar
```
**3.4. Search Logs**
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
http://localhost:2706/swagger-ui.html

![The Order Swagger!](/assets/images/order_swagger.png "Order Swagger")

## 5. API Testing
Import [Postman Collection](/assets/ddd_hexagonal_architecture_postman_collection.json) ***[assets/ddd_hexagonal_architecture_postman_collection.json]*** file to the **Postman** application to test REST API in the **REST folder**

## 6. GraphQL
GraphQL is a query language to retrieve data from a server. It is an alternative to REST, SOAP or gRPC. Imagine you have an API frontend implemented with GraphQL for the Order microservice. As shown in the below image, there are different services in your Order backend microservice that are accessible via different technologies. For example, user profile data is stored in a highly scalable NoSQL table. Orders are accessed through a REST API. The current inventory stock is checked through an Inventory Service. And the pricing information is in an SQL database

![GraphQL!](/assets/images/graphql.png "GraphQL")

Without using GraphQL, client applications must make multiple separate calls to each one of these services (or using an **API Composition/Aggregator** backend). Because each service is exposed through different API endpoints, the complexity of accessing data from the client side increases significantly. In order to get the data, you have to **make multiple calls**. In some cases, you might over fetch data as the data source would send you an entire payload including data you might not need. In some other circumstances, you might under fetch data as a single data source would not have all your required data

A GraphQL API **combines the data from all these different services** into a single payload that the client defines based on its needs. For example, a smartphone has a smaller screen than a desktop application. A smartphone application might require less data. The data is retrieved from multiple data sources automatically. The client just sees a single constructed payload. This payload might be receiving user profile data from MongoDB, or order details from Order Service. Or it could involve the injection of specific fields with inventory availability and price data from Inventory Service and PostgreSQL DB

When modernizing frontend APIs with GraphQL, you can build applications faster because your frontend developers don’t need to wait for backend service teams to create new APIs for integration. GraphQL simplifies data access by interacting with data from multiple data sources using a single API. This reduces the number of API requests and network traffic, which results in improved application performance. Furthermore, [GraphQL subscriptions](https://aws.amazon.com/graphql/graphql-subscriptions-real-time) enable two-way communication between the backend and client. It supports publishing updates to data in real time to subscribed clients. You can create engaging applications in real time with use cases such as updating sports scores, bidding statuses, and more

### GraphQL API Testing

**Option 1**

Import [Postman Collection](/assets/ddd_hexagonal_architecture_postman_collection.json) ***[assets/ddd_hexagonal_architecture_postman_collection.json]*** file to the **Postman** application to test GraphQL APIs in the **GraphQL folder**

**Option 2**

Access to http://localhost:2706/graphiql and type the following queries to get data

- Create a New Order

```graphql
mutation {
    createOrder(orderInput: {
        name: "Cake" 
        description: "Sweet Cake"
        total: 100
    }) {
        id
        name
        description
        total
    }
}
```

![GraphQL - Create Order!](/assets/images/graphql_create_order.png "GraphQL - Create Order")

- Query Specified Order by ID

```graphql
{
  order(id: "1") {
    id
    name
    description
    total
  }
}
```

![GraphQL - Get Order!](/assets/images/graphql_get_order.png "GraphQL - Get Order")

## 7. REST API vs GraphQL
| No | GraphQL | REST |
| --- | --- | --- |
| 1 | GraphQL is an application layer server-side technology which is developed by Facebook for executing queries with existing data | REST is a software architectural style that defines a set of constraints for creating Web services |
| 2 | It follows client-driven architecture | It follows server-driven architecture |
| 3 | GraphQL can be organized in terms of a schema | REST can be arranged in terms of endpoints |
| 4 | GraphQL is a growing community | REST is a large community |
| 5 | The development speed in GraphQL is fast | The development speed in REST is Slow |
| 6 | The learning curve in GraphQL is difficult | The learning curve in REST is moderate |
| 7 | The identity is separated from how you fetch it | The endpoint you call in REST is the identity of an object |
| 8 | In GraphQL,  the server determines available resources | The shape and size of the resource are determined by the server in REST |
| 9 | GraphQL provides high consistency across all platforms | It is hard to get consistency across all platforms |
| 10 | The message format for GraphQL mutations should be a string | The message format for REST mutations can be anything |
| 11 | It is strongly typed | It is weakly typed |
| 12 | GraphQL API endpoints are single | REST API endpoints are multiple |
| 13 | It uses metadata for query validation | It does not have machine-readable metadata cacheable |
| 14 | Provides consistent and high-quality UX across all operating systems | It is difficult to get consistency across all operating systems |
| 15 | Partners of GraphQL require API customization | It offers flexible public API that can easily enable new applications |

### 7.1. GraphQL Pros/Cons
| No | Advantages of GraphQL | Disadvantages of GraphQL |
| --- | --- | --- |
| 1 | It provides declarative query language which is not imperative | Lack of resources on the backend part |
| 2 | It is hierarchical and product-centric | Missing design pattern for a complex app |
| 3 | GraphQL is strongly typed. It means queries are executed within the context of a particular system | Performance issues with complex queries |
| 4 | Queries in GraphQL are encoded in the client not in the server | Overkill for small applications |
| 5 | It has all the features of the application layer of the OSI model | It does not base on the HTTP caching methods that enable storing request content |
| 6 | GraphQL provides a human-readable query | You need to learn the GraphQL Schema Definition Language before you implement GraphQL strategies |
| 7 | In GraphQL it is easy to deal with many databases | GraphQL uses a single endpoint instead of following the HTTP caching |
| 8 | You can fetch data with a single API call | It is not a good solution for simple applications as it can add complexity |
| 9 | It helps you with query batching and caching |  |
| 10 | Tailoring requests to your needs |
| 11 | It helps you to discover the schema in the appropriate format |  |
| 12 | GraphQL automatically keeps documentation in sync with API changes |  |
| 13 | API evolution is possible without versioning |  |
| 14 | It can be used for rapid application prototyping |  |
| 15 | GraphQL fields can be shared to a higher component level for reuse |  |
| 16 | It allows you to select which functions to expose and how they work |  |

### 7.2. REST API Pros/Cons
| No | Advantages of REST API | Disadvantages of REST API |
| --- | --- | --- |
| 1 | It enables you to scale software without any difficulty | REST does not maintain states of a previous interaction between client and server |
| 2 | You can perform migration from one server to another with ease | If you have to retrieve any data from two endpoints |  you need to send two separate requests to API |
| 3 | The protocol becomes easy for developments across different projects | There is no way to get limited fields |
| 4 | REST API offers the opportunity to try various project environments while developing it | Manipulating nested resources is not possible |
| 5 | REST is very easy to build and adapt | Poor data searching facility |
| 6 | You can create process instances explicitly | Query validation is not available |
| 7 | The client machine does not need routing information | It does not handle API additions |  deprecations |  and changes |
| 8 | Developers can build API that can meet a user-specific need | There is no tooling or framework guidance |

## 8. Reference
[OpenTelemetry in Java](https://opentelemetry.io/docs/instrumentation/java/automatic)\
[Using domain analysis to model microservices](https://docs.microsoft.com/en-us/azure/architecture/microservices/model/domain-analysis)