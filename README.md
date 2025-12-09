# Spring Boot Consumer CRUD with Kafka

A Spring Boot–based REST API for managing **Consumer** entities with full CRUD functionality and **Apache Kafka** integration for event/message publishing.

---

## 🚀 Features
- Full CRUD (Create, Read, Update, Delete) for Consumer entity
- Kafka Producer integration for publishing consumer data
- PostgreSQL database support
- Liquibase for database migrations
- MapStruct for DTO ↔ Entity mapping
- Swagger (OpenAPI) for API documentation
- Docker support for database setup

---

## 🛠 Tech Stack
- Java 17
- Spring Boot 3.2
- Spring Web
- Spring Data JPA
- Spring Kafka
- PostgreSQL
- Liquibase
- MapStruct
- Lombok
- Swagger (springdoc-openapi)
- Docker

---

## 🧱 Architecture Overview

```

┌───────────────┐
│   Client      │
│ (Swagger /    │
│  REST Client) │
└───────┬───────┘
│ HTTP
▼
┌─────────────────────┐
│ ConsumerController  │
│  REST Endpoints     │
└───────┬─────────────┘
│
▼
┌─────────────────────┐
│  ConsumerService    │
│  Business Logic     │
└───────┬─────────────┘
│
│ JPA
▼
┌─────────────────────┐
│ ConsumerRepository  │
│  (Spring Data JPA)  │
└───────┬─────────────┘
│
▼
┌─────────────────────┐
│  PostgreSQL DB      │
│  (Liquibase)       │
└─────────────────────┘

```
    ┌─────────────────────┐
    │    KafkaProducer     │
    │ (Spring Kafka)      │
    └─────────┬───────────┘
              │
              ▼
    ┌─────────────────────┐
    │   Kafka Topic       │
    │     "course"        │
    └─────────────────────┘
```

```

---

## 📂 Project Structure
```

UserManagement
├── consumer
│   ├── controller
│   ├── dto
│   ├── mapper
│   ├── model
│   ├── repository
│   ├── service
│   └── validation
├── kafka
│   ├── KafkaProducer
│   └── KafkaConfiguration
└── resources
└── liquibase

````

---

## 🗄 Database Setup (PostgreSQL)

PostgreSQL is started using Docker:

```bash
docker compose up -d
````

**Database configuration:**

* Database name: `user-management-db`
* Username: `user`
* Password: `password`
* Port: `5432`

Liquibase automatically creates the `consumers` table and applies constraints.

---

## ▶️ Run the Application

```bash
./mvnw spring-boot:run
```

---

## 📚 API Endpoints

### Consumer API

| Method | Endpoint          | Description           |
| ------ | ----------------- | --------------------- |
| GET    | `/consumers`      | Get all consumers     |
| GET    | `/consumers/{id}` | Get consumer by ID    |
| POST   | `/consumers`      | Create a new consumer |
| POST   | `/consumers/{id}` | Update consumer       |
| DELETE | `/consumers/{id}` | Delete consumer       |

---

### Kafka API

| Method | Endpoint              | Description                 |
| ------ | --------------------- | --------------------------- |
| POST   | `/kafka/send?id={id}` | Send consumer data to Kafka |

**Kafka topic:** `course`

---

## 🧾 Kafka Integration

Kafka Producer sends messages to Kafka topic:

```java
kafkaTemplate.send("course", message);
```

Kafka topic is auto-created on application startup:

```java
@Bean
public NewTopic newTopic() {
    return new NewTopic("course", 1, (short) 1);
}
```

---

## 📖 Swagger UI

Access Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

Use it to explore and test REST APIs.

---

## ✅ Validation & Error Handling

* Email must be unique
* `404 Not Found` if consumer does not exist
* `400 Bad Request` for invalid or duplicate data

---

## 🔮 Possible Improvements

* Add Kafka Consumer for event processing
* Event-driven architecture (ConsumerCreatedEvent)
* Pagination and filtering
* Global exception handling
* Authentication & authorization (Spring Security)

---

## 👩‍💻 Author

**Mavluda Raximquliyeva**

---

## 📝 Notes

* Kafka broker must be running before sending messages
* Kafka functionality was tested separately in a dedicated `kafka-demo` project

---
