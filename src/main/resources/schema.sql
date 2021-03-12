CREATE DATABASE user;

USE user;

CREATE TABLE course (
                        course_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                        Course_name VARCHAR(30) NOT NULL,
                        content VARCHAR(40) NOT NULL
);

CREATE TABLE user (
                        id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(30) NOT NULL,
                        email VARCHAR(40) NOT NULL
);

INSERT INTO user VALUES ('Kamal','kamal@xyz.com'),('Tharindu','tharindu@gmail.com'),('Kasun','kasun@xyz.com'),(6,'Kasun Bandara','kasunb@xyz.com'),('Kamal','saman@gmail.com'),('SamanKumara','saman@gmail.com')

INSERT INTO course VALUES ('IT','SE,DBMS,IT'),('Maths','Calculas'),('Java','OOP'),('JavaScript','OOP,Asynchronus,'),('Python','Data types');