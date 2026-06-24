## Microservices Architecture

This project follows a distributed microservices architecture where each service is independently deployable and registered with Eureka Service Registry.

### Service Communication

The application uses OpenFeign for inter-service communication.

Example:

```text
Quiz Service
     |
     | OpenFeign
     v
Question Service
```

The Quiz Service does not directly access the Question database.

Instead, it communicates with Question Service through Feign Client interfaces.

### Feign Client Operations

Quiz Service invokes Question Service APIs for:

1. Generating Question IDs for a quiz
2. Retrieving Question Details
3. Calculating Quiz Score

```java
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface
```

Benefits:

* Loose Coupling
* Service Discovery Integration
* Simplified REST Communication
* Improved Maintainability

---

## Centralized Configuration

The application uses Spring Cloud Config Server for centralized configuration management.

### Config Server

Port: `8080`

Responsibilities:

* Centralized configuration management
* Environment-specific configuration
* Externalized properties

Configuration files:

```text
config/
 ├── question-service.yaml
 └── quiz-service.yaml
```

All microservices can fetch their configuration from Config Server instead of maintaining duplicate configuration files.

---

## Service Discovery

The application uses Netflix Eureka for service registration and discovery.

### Eureka Server

Port: `8761`

Dashboard:

```text
http://localhost:8761
```

Registered Services:

* API-GATEWAY
* QUESTION-SERVICE
* QUIZ-SERVICE

Benefits:

* Dynamic Service Discovery
* Load Balancing Support
* Reduced Hard-Coded URLs
* Better Scalability

---

## API Gateway

Port: `8089`

The API Gateway acts as the single entry point for all incoming requests.

### Routing Configuration

| Route        | Destination Service |
| ------------ | ------------------- |
| /question/** | QUESTION-SERVICE    |
| /quiz/**     | QUIZ-SERVICE        |

Examples:

```http
GET http://localhost:8089/question/all
```

```http
POST http://localhost:8089/quiz/create
```

The Gateway automatically resolves service locations through Eureka Registry.

---

## Project Highlights

### Implemented Features

* Microservices Architecture
* API Gateway Pattern
* Service Discovery using Eureka
* Centralized Configuration using Config Server
* OpenFeign Client Communication
* RESTful APIs
* Spring Data JPA
* MySQL Integration
* Quiz Generation
* Score Evaluation

### Design Patterns Used

* API Gateway Pattern
* Service Registry Pattern
* Client-Side Service Discovery
* Externalized Configuration Pattern
* Declarative REST Client Pattern (Feign)

---

## Future Improvements

* JWT Authentication & Authorization
* Kafka Event Streaming
* Circuit Breaker using Resilience4j
* Docker Containerization
* Kubernetes Deployment
* Distributed Tracing
* Centralized Logging using ELK Stack
* CI/CD Pipeline using GitHub Actions
* Unit & Integration Testing
