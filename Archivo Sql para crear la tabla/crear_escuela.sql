
-- Crear la base de datos
CREATE DATABASE escuela;

-- Usar la base de datos
USE escuela;

-- Crear tabla cursos
CREATE TABLE cursos (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Crear tabla alumnos
CREATE TABLE alumnos (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
