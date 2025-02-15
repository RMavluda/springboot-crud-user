# User Management System

This project is a simple **User Management System** built with **Spring Boot**, **Spring Data JPA**, and **Thymeleaf**.

## Features
- View a list of users
- Add a new user
- Update user information
- Delete a user

## Technologies Used
- **Spring Boot** – for building the web application
- **Spring Data JPA** – for database interactions
- **PostgreSQL** – as the database
- **Thymeleaf** – for rendering web pages
- **Lombok** – for reducing boilerplate code
- **Docker** – for running PostgreSQL

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/RMavluda/springboot-crud-user.git
cd user-management
```

### 2. Run PostgreSQL using Docker
Make sure you have **Docker** installed, then run:
```sh
docker-compose up -d
```
This will start a PostgreSQL database container.

### 3. Configure Database Connection
Modify `application.properties` if necessary:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=user
spring.datasource.password=password
```

### 4. Run the Application
```sh
mvn spring-boot:run
```
The application will be available at **http://localhost:8080/user-management/users**.

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/user-management/users` | View all users |
| POST | `/user-management/user-create` | Add a new user |
| GET | `/user-management/user-delete/{id}` | Delete a user by ID |
| GET | `/user-management/user-update/{id}` | View user update form |
| POST | `/user-management/user-update` | Update user info |

## License
This project is open-source and available under the MIT License.

---
Feel free to contribute and improve the project!

