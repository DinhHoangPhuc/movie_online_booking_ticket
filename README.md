## Overview

This project is a movie ticket booking system that allows users to browse movies, book tickets, and view their bookings. The system is built with a React frontend and a Spring Boot backend.

## Features

- **User Registration and Authentication**: Secure user registration and login using JWT tokens.
- **Movie Browsing**: Browse and search for movies.
- **Ticket Booking**: Book tickets for movies.
- **Booking History**: View and your bookings.

## How to Run This

### Prerequisites

- Node.js and npm
- Java Development Kit (JDK)
- Maven
- SQL Server
- OpenSSL
- Intellij idea (for running Spring Boot)
- VSCode (for running ReactJS)

### Setup

1. **Clone the repository**:
    ```sh
    git clone https://github.com/DinhHoangPhuc/movie_online_booking_ticket.git
    cd movie_online_booking_ticket
    ```

2. **Generate Asymmetric Keys for JWT Authentication**:
    ```sh
    openssl genpkey -algorithm RSA -out private.pem -pkeyopt rsa_keygen_bits:2048
    openssl rsa -pubout -in private.pem -out public.pem
    ```

3. **Move the generated keys to the `back_end/src/main/resources/certs` directory**:
    ```sh
    mv private.pem back_end/src/main/resources/certs/private.pem
    mv public.pem back_end/src/main/resources/certs/public.pem
    ```

4. **Create `application.properties` file**:
    Create a file named `application.properties` in the `back_end/src/main/resources` directory with the following content:
    ```properties
    spring.application.name=movie_online_booking_ticket
    spring.datasource.url=jdbc:sqlserver://<your_sql_server_host>:<port>;databaseName=DatVeXemPhim;encrypt=false;trustServerCertificate=false;hostNameInCertificate=<your_sql_server_host>
    spring.datasource.username=<your_sql_server_username>
    spring.datasource.password=<your_sql_server_password>
    spring.jpa.hibernate.ddl-auto=update
    rsa.private-key=classpath:certs/private.pem
    rsa.public-key=classpath:certs/public.pem
    logging.level.org.springframework.security=DEBUG
    ```

5. **Import Database**:
    Use the `DatVeXemPhim.bacpac` file to import the database into your SQL Server:
    - Open SQL Server Management Studio (SSMS).
    - Connect to your SQL Server instance.
    - Right-click on the `Databases` node and select `Import Data-tier Application`.
    - Follow the wizard to import the `DatVeXemPhim.bacpac` file.

6. **Build and Run the Backend (open Intellij idea)**:
    ```sh
    cd back_end
    mvn clean install
    mvn spring-boot:run
    ```

7. **Install Frontend Dependencies (open VSCode)**:
    ```sh
    cd ../front_end/movie_booking_ticket
    npm install
    ```

8. **Run the Frontend**:
    ```sh
    npm start
    ```

Your application should now be running, and you can access it via your web browser.

