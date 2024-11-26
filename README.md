
This project is a simplified backend system for managing patient data, user registration, and heart rate monitoring. It includes a set of RESTful APIs built using Spring Boot and connected to a MySQL database.

Table of Contents

Project Overview
Technologies Used
Database Setup
Application Setup
API Endpoints
Error Handling
Assumptions & Decisions

Project Overview
This project is designed to handle the backend functionalities of a device that monitors the patient's heart rate. The primary goal is to develop RESTful APIs to:
Register users and handle login using email and password.
Manage patient data (add, retrieve patient details).
Record and retrieve heart rate data for patients.

Technologies Used
Spring Boot: For building the backend APIs.
Spring Data JPA: For database interactions.
MySQL: Relational database for storing user, patient, and heart rate data.
Maven: For project management and dependency management.

Database Setup
MySQL Database:
Ensure MySQL is installed and running on your system.
Create a database named dataBaseName(or any name you prefer).
Create the necessary tables (Spring Boot will automatically generate them for you based on the entity classes).
Create Database in MySQL: Run the following command in the MySQL CLI or MySQL Workbench to create the database:

CREATE DATABASE dataBaseName;

Application Setup
Clone the repository:
Import the project into your IDE (e.g., IntelliJ IDEA, Eclipse).

Configure MySQL Connection:

Open src/main/resources/application.properties and configure the MySQL connection:
spring.datasource.url=jdbc:mysql://localhost:3306/janitri_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
Run the Application:

Use the following command to run the Spring Boot application:
mvn spring-boot:run
Alternatively, run the main class JanitriBackendApplication.java from your IDE.

API Endpoints
The following RESTful API endpoints are provided:

1. User Registration and Login
POST /api/users/register

Registers a new user with email and password.

Request Body:

{
  "email": "user@example.com",
  "password": "password123"
}
Response:

{
  "message": "User registered successfully!"
}
POST /api/users/login

Logs in a user by matching email and password.

Request Body:

{
  "email": "user@example.com",
  "password": "password123"
}
Response:

{
  "message": "Login successful!"
}
2. Patient Management
POST /api/patients

Adds a new patient.

Request Body:

{
  "name": "John Doe",
  "age": 30
}
Response:

{
  "id": 1,
  "name": "John Doe",
  "age": 30
}
GET /api/patients/{id}

Retrieves details of a specific patient by ID.

Response:

{
  "id": 1,
  "name": "John Doe",
  "age": 30
}
GET /api/patients

Retrieves a list of all patients.

Response:

[
  {
    "id": 1,
    "name": "John Doe",
    "age": 30
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "age": 25
  }
]
3. Heart Rate Management
POST /api/heart-rates/{patientId}

Records a new heart rate for a patient.

Request Body:

{
  "bpm": 75
}
Response:

{
  "id": 1,
  "bpm": 75,
  "patient": {
    "id": 1,
    "name": "John Doe"
  }
}
GET /api/heart-rates/{patientId}

Retrieves all heart rate records for a patient.

Response:

[
  {
    "id": 1,
    "bpm": 75,
    "patient": {
      "id": 1,
      "name": "John Doe"
    }
  }
]
Error Handling
The following error responses are provided for invalid inputs:

400 Bad Request: Invalid input data (e.g., email already exists during registration).
401 Unauthorized: Invalid credentials during login.
404 Not Found: When a patient or heart rate record is not found.

Assumptions & Decisions
Database Design:

The Patient entity has a one-to-many relationship with the HeartRate entity, as a patient can have multiple heart rate records.
The User entity is only used for authentication (email and password validation) and does not involve advanced security protocols like JWT or OAuth2.
Validation:

Simple email and password validation are implemented for login.
No additional security mechanisms (e.g., hashing of passwords, email verification) are required for this assignment, as specified in the requirements.
Testing:

This project does not include unit tests. However, unit tests can be written using JUnit and MockMvc to test the endpoints.

Conclusion
This Spring Boot backend provides an efficient and simple implementation for managing users, patients, and heart rate data, along with clean and extendable API design practices. The APIs are designed for easy integration with a front-end application or any other service that requires access to this data.

