# Online Banking Transaction Management System

A backend application for managing users, bank accounts, and financial transactions using Java and Spring Boot. The application provides secure REST APIs with JWT authentication and role-based authorization.

## Tech Stack

* Java 17
* Spring Boot
* Spring Security & JWT
* Spring Data JPA & Hibernate
* MySQL
* REST APIs
* JUnit 5 & Mockito
* Swagger/OpenAPI
* Maven
* Git & GitHub

## Features

* User registration and login with BCrypt password hashing
* JWT-based authentication and role-based authorization
* Savings and Current account management
* Automatic account number generation
* Deposit, withdrawal, and fund transfer
* Transaction history and status tracking
* Input validation and exception handling
* Unit testing with JUnit 5 and Mockito
* REST API documentation using Swagger/OpenAPI

## Architecture

```text
Client
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
MySQL
```

The application follows a layered architecture with separate DTO, Security, Configuration, and Exception Handling components.

## Database

Main entities:

```text
User 1 ───── * Account
Account 1 ── * Transaction
```

## API Endpoints

| Method | Endpoint                        | Description          |
| ------ | ------------------------------- | -------------------- |
| POST   | `/api/auth/register`            | Register user        |
| POST   | `/api/auth/login`               | Login & generate JWT |
| POST   | `/api/accounts`                 | Create account       |
| GET    | `/api/accounts`                 | View user accounts   |
| POST   | `/api/transactions/deposit`     | Deposit money        |
| POST   | `/api/transactions/withdraw`    | Withdraw money       |
| POST   | `/api/transactions/transfer`    | Transfer money       |
| GET    | `/api/transactions/{accountId}` | Transaction history  |

## Configuration

Create `application.properties` and configure your local MySQL database and JWT secret.

Sensitive configuration files are excluded using `.gitignore`.

## How to Run

```bash
git clone <repository-url>
cd online-banking-transaction-management-system
mvn clean install
mvn spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```
