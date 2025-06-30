# Online Bookstore Management System

A full-stack web application for managing an online bookstore, built with Spring Boot, JWT authentication, and a modern responsive frontend.

## Features
- User registration & login (JWT-based)
- Role-based access: Admin & User
- Book CRUD (Admin)
- Book browsing & search
- Shopping cart & checkout
- RESTful API

## Tech Stack
- Java, Spring Boot, Spring Security, JPA
- H2 (in-memory) or MySQL (optional)
- HTML, CSS, Bootstrap 5, JavaScript

## Getting Started
1. Clone the repo:
   ```sh
   git clone https://github.com/Voltrix101/online-book-store-management.git
   cd online-book-store-management
   ```
2. Run the app:
   ```sh
   .\mvnw spring-boot:run "-Dmaven.test.skip=true"
   ```
3. Access the API at [http://localhost:8080](http://localhost:8080)

## Default Admin Login
- **Username:** admin
- **Password:** admin123

---
Feel free to contribute or open issues! 