# Edic Backend

This is the backend service for the Edic application, built using Spring Boot. It provides APIs for user registration, login, and other functionalities, with JWT-based authentication and PostgreSQL as the database.

---

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [License](#license)

---

## Features

- User registration with hashed passwords using BCrypt.
- User login with JWT-based authentication.
- Validation for user input using `javax.validation`.
- PostgreSQL database integration.
- RESTful APIs for user management.
- Security configuration using Spring Security.

---

## Technologies Used

- **Java 17**
- **Spring Boot 3.4.4**
  - Spring Data JPA
  - Spring Security
  - Spring Web
- **PostgreSQL** (Database)
- **JWT (JSON Web Tokens)** for authentication
- **Lombok** for reducing boilerplate code
- **Hibernate Validator** for input validation

---

## Setup Instructions

### Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL




