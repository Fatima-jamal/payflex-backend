# PayFlex Backend

This repository contains the complete Spring Boot backend for the PayFlex digital Request to Pay (RTP) system. It serves as the centralized API gateway for all frontend modules—Merchant Management System, Merchant Portal, and Customer App.

## Features

- Spring Boot 3 with RESTful API architecture
- PostgreSQL integration via Spring Data JPA
- Merchant onboarding (approval/rejection, credential generation)
- Real-time payment request handling
- QR-based payment processing support
- Refund submission and tracking
- Dashboard metrics and transaction summaries
- Role-based authentication (Admin, Merchant)
- CORS-enabled endpoints for frontend integration

## Modules

- `controllers/`: API routing and business endpoint definitions
- `services/`: Business logic and data transformations
- `models/`: JPA-mapped entity classes
- `repositories/`: Data access layers for CRUD operations
- `dtos/`: Data Transfer Objects for frontend consumption
- `config/`: CORS and application-level configuration

## API Highlights

- `POST /api/login` – Merchant login
- `GET /api/merchants/pending` – Admin: View pending merchants
- `PUT /api/merchants/{id}/approve` – Admin: Approve merchant
- `POST /api/payment-requests` – Customer: Submit payment
- `POST /api/refund-requests` – Merchant: Submit refund
- `GET /api/dashboard-summary/{merchantId}` – Merchant: Dashboard data

## Technology Stack

- Java 17
- Spring Boot 3
- PostgreSQL
- Maven
- GitHub Actions for CI/CD
- Postman for API testing

## Setup Instructions

1. Clone the repo  
2. Configure `application.properties` for PostgreSQL  
3. Run using `mvn spring-boot:run`  
4. Use Postman to test endpoints or connect via frontend apps

## License

© 2025 Fatima Jamal – All rights reserved.
