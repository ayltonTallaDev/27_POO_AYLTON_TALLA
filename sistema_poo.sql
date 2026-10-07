CREATE DATABASE sistema_poo;

USE sistema_poo;

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    correo VARCHAR(150),
    estado VARCHAR(20)
);

INSERT INTO usuarios (nombre, apellido, correo, estado)
VALUES
('Ana', 'Pérez', 'ana@gmail.com', 'Activo'),
('Luis', 'Torres', 'luis@gmail.com', 'Activo'),
('Carla', 'Ramos', 'carla@gmail.com', 'Inactivo'); 

SELECT * FROM usuarios
