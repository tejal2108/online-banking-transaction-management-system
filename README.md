# 🏦 Online Banking Transaction Management System

> A secure **RESTful backend application** for managing customers, bank accounts, and financial transactions. The system provides **JWT-based authentication, role-based authorization, account management, and transaction processing**, with MySQL for persistent data storage. Built using a **layered architecture** with Spring Boot, Spring Security, JPA/Hibernate, and REST APIs.


---

## 🛠️ Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot
* **Security:** Spring Security, JWT
* **ORM:** Spring Data JPA, Hibernate
* **Database:** MySQL
* **Testing:** JUnit 5, Mockito
* **API Documentation:** Swagger/OpenAPI
* **Build Tool:** Maven
* **Version Control:** Git, GitHub

---

## ✨ Features

* 🔐 **JWT Authentication** & BCrypt password hashing
* 👥 **Role-Based Authorization** for Customer & Admin
* 🏦 **Account Management** — Savings & Current accounts
* 💰 **Transaction Management** — Deposit, Withdrawal & Transfer
* 📜 **Transaction History** & status tracking
* ✅ Input validation & global exception handling
* 🧪 Unit testing with **JUnit 5 & Mockito**
* 📚 API documentation with **Swagger/OpenAPI**

---

## 🏗️ Architecture

```text
                 ┌──────────────┐
                 │    Client    │
                 │   Postman    │
                 └──────┬───────┘
                        ↓
                 ┌──────────────┐
                 │  Controller  │
                 └──────┬───────┘
                        ↓
                 ┌──────────────┐
                 │   Service    │
                 └──────┬───────┘
                        ↓
                 ┌──────────────┐
                 │  Repository  │
                 └──────┬───────┘
                        ↓
                 ┌──────────────┐
                 │    MySQL     │
                 └──────────────┘
```

---

## 🗄️ Database Design

```text
User
 │
 │ 1
 │
 └────────── * Account
                  │
                  │ 1
                  │
                  └────────── * Transaction
```

**Entities:** `User` • `Account` • `Transaction`

---

## 🔗 REST APIs

| Method | Endpoint                        | Purpose              |
| ------ | ------------------------------- | -------------------- |
| `POST` | `/api/auth/register`            | Register user        |
| `POST` | `/api/auth/login`               | Login & generate JWT |
| `POST` | `/api/accounts`                 | Create account       |
| `GET`  | `/api/accounts`                 | View user accounts   |
| `POST` | `/api/transactions/deposit`     | Deposit money        |
| `POST` | `/api/transactions/withdraw`    | Withdraw money       |
| `POST` | `/api/transactions/transfer`    | Transfer funds       |
| `GET`  | `/api/transactions/{accountId}` | Transaction history  |

---

## 🔒 Security

Protected APIs require a JWT token:

```text
Authorization: Bearer <JWT_TOKEN>
```

Passwords are securely stored using **BCrypt hashing**.

---

## 🚀 Run Locally

### Prerequisites

* Java 17+
* Maven
* MySQL

### Setup

```bash
git clone <repository-url>
cd online-banking-transaction-management-system
mvn clean install
mvn spring-boot:run
```

Configure your local MySQL credentials and JWT secret in `application.properties`.

The application runs on:

```text
http://localhost:8080
```

---
