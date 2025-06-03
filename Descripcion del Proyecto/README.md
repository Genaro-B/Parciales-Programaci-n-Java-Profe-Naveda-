# Proyecto de Gestión de Alumnos y Cursos (Consola - JDBC - MySQL)

Este proyecto es una aplicación de consola desarrollada en Java 17 utilizando JDBC para gestionar alumnos y cursos almacenados en una base de datos MySQL.

## Estructura del Proyecto

```
├── Modelo/
│   ├── Alumno.java
│   └── Curso.java
│
├── Persistencia/
│   ├── Conexion.java
│   ├── AlumnoDAO.java
│   ├── CursoDAO.java
│   ├── AlumnoDAOImpl.java
│   └── CursoDAOImpl.java
│
├── Logica/
│   ├── AlumnoService.java
│   └── CursoService.java
│
├── Principal/
│   └── Principal.java
│
├── build.gradle.kts
└── README.md
```

## Requisitos

- Java 17
- Gradle
- MySQL (ej. instalado mediante XAMPP)
- Driver JDBC de MySQL (se gestiona automáticamente desde Gradle)

## Configuración de la Base de Datos

1. Asegúrate de que el servicio de MySQL esté corriendo (por ejemplo, desde XAMPP).
2. Accede a phpMyAdmin y crea la base de datos:

```
CREATE DATABASE escuela;
```

3. Luego crea las tablas necesarias:

```sql
CREATE TABLE cursos (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE alumnos (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    curso_id INT,
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
```

## Configuración de Gradle (build.gradle.kts)

```kotlin
plugins {
    id("java")
}

group = "org.usuario"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("mysql:mysql-connector-java:8.0.33")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
```

## Configuración de la Conexión JDBC

En `Conexion.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/escuela?useSSL=false&serverTimezone=UTC";
private static final String USUARIO = "root";
private static final String CLAVE = "";
```

> Cambia `USUARIO` y `CLAVE` si tu instalación de MySQL tiene credenciales distintas.

## Cómo Ejecutar

1. Asegúrate de tener MySQL activo y la base de datos creada.
2. Importa el proyecto en IntelliJ (como proyecto de Gradle).
3. Ejecuta `Principal.java` como aplicación de consola.
4. Desde el menú podrás crear cursos, listar cursos, crear alumnos y listar alumnos.

---

© Proyecto educativo simple para gestionar relaciones entre alumnos y cursos mediante Java y JDBC.