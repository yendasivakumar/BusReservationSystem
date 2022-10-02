

## REST API for a Bus Reservation System Portal

## Description


- We have developed this REST API for an Bus reservation application. This API performs all the fundamental CRUD operations of any Bus reservation platform with user validation at every step.
- This project is developed by team of 4 Back-end Developers during project week in Masai School.


 
## Techstack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL



## Modules

- User Module
- Bus Module
- Route Module
- Reservation Module
- Feedback Module

## ER Diagram
Following ER diagram indicates the database tables and thier interaction which we are using.
![Untitled Workspace](https://github.com/yendasivakumar/BusReservationSystem/blob/main/ER%20Diagram.png)


## Features

* User and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete driver or customer from main database
    * Admin can access the details of different users, buses and routes.
* Customer Features:
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available bus and booking a reservatioon.
    * Only logged in users can update his/her reservation, profile updation and other features.




## Contributors
- [@Vamsi Krishna](https://github.com/Vamsi4612)
- [@Vineet Kumar Singh](https://github.com/vineet221713)
- [@Shubham Garg](https://github.com/shubhamgarg7239)
- [@Siva Kumar](https://github.com/yendasivakumar)
## Installation & Run

- Before running the API server, you should update the database config inside the [application.properties](https://github.com/yendasivakumar/BusReservationSystem/tree/main/src/main/resources) file.
- Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/busdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```


## API Module Endpoints

### User Module



* `POST /login` : Logging in user with valid mobile number & password
* `POST /logout` : Logging out user based on session token
* `POST /BRSystem/user` : To register user himself
* `POST /feedback/userId/busId` : To give feedback by user based on userId and busId
* `GET /bus/busId` : Getting the details of the bus by its id
* `GET /buses` : Getting All the buses
* `GET /busByType/busType` : Getting details of bus by its type
* `GET /reservation/userId` :  To do reservation by user by his/her id
* `GET /reservation/reservationId` : Getting the reservation details by reservation id
* `PUT /reservation/userId` : Update reservation details by user id
* `PUT /BRSystem/user` : Update user details by himself
* `PUT /feedback` : To update feedback given by user.
* `DELETE /reservation/userId/reservationId` : Cancel reservation by reservationId, userId


