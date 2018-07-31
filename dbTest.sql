CREATE DATABASE dbTest;
USE dbTest;
CREATE TABLE empleado (
    id INT(10) AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    creacion DATE NOT NULL,
    PRIMARY KEY(id)
);