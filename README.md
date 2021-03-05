# Spring Boot CRUD application with MySQL

This is sample application using Springboot and MySQL 

### Senario

This application contains two Modules 
* User Module
* Course Module

In this application User module was developed by using JPA and Course module was developed by using JDBC template.
There are few operations on both modules
1. create User/Course
2. edit User/Course
3. Delete User/Course
4. View User/Course
5. Search User/Course

There are some test cases are included for testing the  operations.
This  Application Endpoints are checked by using Postman and here the postman collection links

User Module - 
https://www.getpostman.com/collections/8103168dcf9fe53a4b5f

Course Module -
https://www.getpostman.com/collections/bbe787f0215d2e29e61b

## How to run the application 

1. Clone the project and checkout master branch

` git clone <clone-url> `

`git checkout master`

2. Go to the project folder

`cd  spingboot-crud-demo`

3. Build the project with Maven

`mvn clean package `

4. Go to the target folder and run the application 

`cd target`

`java -jar spring-crud-0.0.1-SNAPSHOT.jar`

5. After started application you can test the endpoints of the application using postman