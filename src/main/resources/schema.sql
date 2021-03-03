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