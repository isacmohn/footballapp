# FootballApp

FootballApp is a backend application for managing football pitches, users, bookings, matches, reviews and messages.

The application is built with Java and Spring Boot and uses PostgreSQL for persistent data storage.

## Project Status

This is an ongoing learning project and is still under active development.

The main purpose of the project is to strengthen my understanding of Java, Spring Boot, REST APIs, relational databases, backend architecture and application security by building the application step by step.

I have deliberately focused on understanding and implementing the different parts of the application rather than treating the project as a finished product.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven
- REST APIs
- BCrypt

## Architecture

The application follows a layered architecture:

```text
Client
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
PostgreSQL
```

The main responsibilities of the layers are:

- **Controller** – exposes REST endpoints and handles incoming HTTP requests.
- **Service** – contains application and business logic.
- **Repository** – communicates with the database using Spring Data JPA.
- **Entity** – represents the application's domain objects and database entities.
- **DTO** – represents data transferred through selected API operations.

## Domain Model

The application currently contains domain entities for:

- Users
- Football pitches
- Bookings
- Teams
- Matches
- Reviews
- Messages

The goal is to allow users to find football pitches, create bookings and interact with other parts of the football application.

## Current Functionality

Current functionality includes:

- User management
- Football pitch management
- Booking management
- Match-related functionality
- Reviews and messages
- User registration
- Password hashing with BCrypt
- Database-backed authentication
- REST endpoints for accessing application data
- Persistence using PostgreSQL and Spring Data JPA

The application is still evolving, so some functionality and API design will be improved as development continues.

## Authentication and Security

Spring Security is used to protect API endpoints.

When a user registers, the password is hashed using BCrypt before it is stored in the database.

Authentication uses a database-backed `UserDetailsService`, which retrieves users through the application's repository layer.

Protected API endpoints currently use HTTP Basic authentication.

Database passwords are not stored directly in the source code. The PostgreSQL password is supplied through the `DB_PASSWORD` environment variable.

## Running the Application Locally

### Requirements

- Java 17
- PostgreSQL
- Maven Wrapper (included in the project)

A PostgreSQL database named `footballapp` is expected by the current local configuration.

Before starting the application, set the database password as an environment variable.

Example using Git Bash:

```bash
export DB_PASSWORD='your-database-password'
```

Then start the application:

```bash
./mvnw spring-boot:run
```

By default, the application runs on:

```text
http://localhost:8080
```

## Testing

The project can be compiled and tested using:

```bash
./mvnw clean test
```

API endpoints can also be tested manually using tools such as Postman.

## Planned Improvements

This project is still under development. Areas I plan to continue working on include:

- More appropriate HTTP responses using `ResponseEntity`
- Improved validation of incoming data
- Improved exception and error handling
- Role-based authorization
- Additional automated tests
- API documentation
- Further code cleanup and consistent formatting
- Continued development of booking and match functionality

### Next Steps: Containers and Cloud

Over the coming weeks, one of my main goals is to take the application beyond local development and gain more hands-on experience with modern development and deployment practices.

I plan to:

- Containerize the application using Podman or Docker
- Run the application and PostgreSQL in a containerized environment
- Deploy the application to a cloud-hosted environment
- Manage configuration and secrets using environment variables
- Explore CI/CD for automated building, testing and deployment
- Connect the project to modern development and deployment workflows
- Gain practical experience with operating and maintaining a backend application outside my local development environment

The goal is not only to deploy the application, but to use the project to better understand the complete journey from writing application code to building containers, deploying them to cloud infrastructure and maintaining a running service.

## Learning Goals

This project is also used as a practical environment for improving my understanding of:

- Java and object-oriented programming
- Spring Boot architecture
- REST API development
- HTTP communication
- Spring Security
- Authentication and authorization
- Relational databases and JPA
- Backend application design
- Testing and debugging
- Git and version control
- Containerization
- Cloud deployment
- CI/CD and modern development workflows

As I learn new concepts, I plan to gradually apply them to the project and improve the architecture and implementation.