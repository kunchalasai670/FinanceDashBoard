# FinanceDashBoard

A comprehensive Finance Dashboard Backend API built with Spring Boot, providing secure transaction management, userEntity roles, and advanced data processing capabilities.

## Overview

FinanceDashBoard is a robust backend API designed to manage financial transactions with enterprise-grade security. It provides userEntity authentication, role-based access control, transaction management, and comprehensive data processing using JPA and H2 database.

*Key Purpose:*
- Secure transaction management for multiple users
- Role-based access control (ROLE_VIEWER,ROLE_ANALYST,ROLE_ADMIN)
- Real-time financial data processing
- RESTful API for frontend integration

---

## Features

- *User Management*
  - User registration and authentication
  - Role-based access control (RBAC)

- *Transaction Management*
  - Create, read, update, and delete transactions
  - Transaction filtering and search
  - Transaction history tracking

- *Data Processing*
  - Data persistence with JPA

- *Security*
  - Secure password management
  - Role-based endpoint protection
  - Input validation

- *API Features*
  - RESTful API design
  - Error handling and logging

---

## Tech Stack

| Component | Technology                             |
|-----------|----------------------------------------|
| *Language* | Java                                   |
| *Framework* | Spring Boot                            |
| *ORM* | JPA (Java Persistence API)|
| *Database* | H2 (Embedded Database)                 |
| *Build Tool* | Gradle                                 |
| *API* | RESTful Web Services                   |
| *Security* | Spring Security                        |

---

### Prerequisites
- Java 11 or higher
- Gradle 3.6+
- Git

---

## Role-Based Access Control (RBAC)

This backend enforces strict role-based permissions for all endpoints using JWT Bearer authentication. Each user is assigned a role:

- *ROLE_VIEWER*: Can view dashboard summaries only
- *ROLE_ANALYST*: Can view dashboard and transactions
- *ROLE_ADMIN*: Full access (manage users, create/update/delete/view transactions, view dashboard)

### Endpoint Permissions

| Endpoint                  | Viewer | Analyst | Admin |
|--------------------------|:------:|:-------:|:-----:|
| POST   /users/register    |   ✔    |   ✔     |  ✔    |
| POST   /auth/login        |   ✔    |   ✔     |  ✔    |
| GET    /dashboard/summary |   ✔    |   ✔     |  ✔    |
| GET    /transactions      |        |   ✔     |  ✔    |
| POST   /transactions      |        |         |  ✔    |
| DELETE /transactions/{id} |        |         |  ✔    |
| GET    /users/{email}     |        |         |  ✔    |

✔ = allowed, blank = forbidden (403)

### How to Test with Bearer Token

1. *Register a user* (choose role):
   json
   POST /users/register
   {
   "name": "Analyst User",
   "email": "analyst1@example.com",
   "password": "pass123",
   "role": "ROLE_ANALYST"
   }

2. *Login to get JWT token:*
   json
   POST /auth/login
   {
   "email": "analyst1@example.com",
   "password": "pass123"
   }
   Response: { "token": "..." }

3. *Use the token in requests:*
  - Add Authorization: Bearer <your_token>

### Example: Forbidden Action
If an Analyst tries to POST /transactions, the response will be 403 Forbidden.

### Notes
- After restarting the backend, always login again to get a new token.
- Only Admins can manage users and perform transaction modifications.
- All endpoints require a valid JWT except /auth/login and /users/register.

---

## Usage

### Start the Application

#### Option 1: Using IntelliJ IDEA (Recommended for Windows)
1. Open the project in IntelliJ IDEA.
2. Wait for Gradle to finish importing and indexing.
3. In the Project panel, navigate to:
   src/main/java/org/financedashboard/FinanceDashboardApplication.java
4. Right-click on FinanceDashboardApplication.java and select *Run 'FinanceDashboardApplication.main()'*.
5. The application will start on [http://localhost:8081](http://localhost:8081).

### Error Handling
- Standardized error responses for API consistency.
- Common HTTP status codes used:
  - 200 OK: Successful requests
  - 201 Created: Resource created (e.g., on user registration)
  - 204 No Content: Successful request with no content (e.g., on deletion)
  - 400 Bad Request: Invalid request parameters
  - 401 Unauthorized: Missing or invalid JWT
  - 403 Forbidden: Insufficient permissions
  - 404 Not Found: Resource not found
  - 500 Internal Server Error: Unexpected server errors

---

## API Documentation

> *Note:* Swagger UI is not implemented in this project. Please refer to the endpoint and role-based access details above for API usage. You can use tools like Postman or curl to interact with the API.

## Troubleshooting

### Common Issues
- *Application fails to start*: Check if the correct Java version is being used. Ensure all environment variables are set.
- *Database issues*: Ensure the H2 database is running. Check connection settings in application.properties.
- *JWT issues*: If receiving 401 Unauthorized, ensure the token is valid and not expired. Check if the Authorization header is set correctly.

*Note*: This README is a living document and will be updated as the project evolves. For the latest information, always refer to the API documentation and Swagger UI.
