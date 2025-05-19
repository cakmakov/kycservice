# 🛡️ KYC (Know Your Customer) Microservice

This project is a banking-grade microservice designed to manage the Know Your Customer (KYC) process. It allows a financial institution to register new users, validate their data, and manage their verification status through a structured approval flow.

---

## 🚀 Technologies Used

- Java 17  
- Spring Boot 3.4.x  
- Spring Data JPA  
- PostgreSQL  
- MapStruct  
- Bean Validation  
- Swagger / OpenAPI  
- Lombok  

---

## 📐 Project Architecture

```
com.cakmakov.kycservice
├── controller        -> REST API endpoints
├── service           -> Business logic interfaces
│   └── impl          -> Service implementations
├── repository        -> JPA data access layers
├── dto               -> Data Transfer Objects
├── entity            -> Database models (JPA entities)
├── mapper            -> MapStruct mappers
├── exception         -> Custom exception handling
├── config            -> Application and Swagger configuration
```

---

## 📦 Features

- Register new customers
- Retrieve customer data
- Update KYC status: `PENDING` → `APPROVED` / `REJECTED`
- Exception handling with meaningful error messages
- Swagger UI for real-time API documentation and testing

---

## 📖 API Documentation

Access the interactive Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

---

## 🧪 Example Endpoints

- `POST /api/customers` → Create new customer  
- `GET /api/customers/{id}` → Get customer by ID  
- `PATCH /api/customers/{id}/status?status=APPROVED` → Update KYC status  

---

## 🛠️ Configuration

### application.yml

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/kyc_db
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## 💻 Run the Application

```bash
./mvnw spring-boot:run
```

Or using Maven:

```bash
mvn clean install
mvn spring-boot:run
```

---

## 📌 Notes

- This project is built for demonstration and educational purposes.  
- In production, consider implementing:  
  - JWT authentication  
  - Role-based access control  
  - Secure logging and auditing  
  - Encryption of sensitive fields  

---

## 👨‍💻 Author

**cakmakov**  
[GitHub](https://github.com/cakmakov)

---

## 🏁 License

This project is open-source and available under the [MIT License](LICENSE).
