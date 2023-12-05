# Student Management System
Student Management Spring Boot Application


![](https://github.com/Suresh170411/PayPal_assignment/blob/main/Images/Checklist.jpg)

## About
Student Management application is able to perform all the CRUD based operation and can manage data to the database
hassle free.

## Features

- User records can be registered to the database
- User can see the student details using the student roll
- User can able to update the data
- User can able to delete the data from the database



## Technologies and Dependencies Used
- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- Devtools
- MySQL
- Lombok
- Maven
- Swagger-ui

## Swagger Documentation
```
http://localhost:8888/swagger-ui/index.html
```

## API Root and Endpoint

- Register one user to the database
- Method : POST
```
http://localhost:8888/person/signUp
```
- Get the student details using roll
- Method : GET
```
http://localhost:8888/task/{taskId}
```

- Get all the students data
- Method : GET
```
http://localhost:8888/tasks
```

- Delete the student from the database
- Method : DELETE
```
http://localhost:8888/task/data/percent
```
- Update the student details
- Method : PUT
```
http://localhost:8888/task/data/percent
```
