# Lluvia de Ideas – Stories API

API REST desarrollada con **Spring Boot + PostgreSQL (Neon)** para la gestión y moderación de cuentos infantiles.

Este proyecto forma parte de mi portafolio como desarrolladora backend.  
La idea es crear una plataforma segura donde niños y familias puedan leer, compartir y crear historias con un sistema de **moderación por administradores**.

---

## Funcionalidades

###  Usuario
- Registro e inicio de sesión
- Ver cuentos publicados
- Dar "me gusta"
- Comentar historias
- Solicitar publicación de cuentos propios

### Administrador
- Aprobar/rechazar cuentos antes de su publicación
- Moderar comentarios
- Activar/desactivar usuarios
- Crear y gestionar categorías

---

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Neon (Base de datos cloud)
- Maven
- Dotenv (.env para variables de entorno)
- Git / GitHub

---

## Modelo de datos

Entidades principales:

- Usuario
- Cuento
- Comentario
- Categoría
- Me gusta

Relaciones:

- Un usuario puede crear muchos cuentos
- Un cuento puede tener muchas categorías
- Un cuento tiene muchos comentarios
- Un cuento tiene muchos "me gusta"
- Cada comentario pertenece a un usuario

---

## Configuración local

### Clonar repositorio

git clone https://github.com/belAlmendras/lluvia-de-ideas-api.git  
cd lluvia-de-ideas-api

---

### Crear archivo `.env`

Crea un archivo en la raíz del proyecto:

.env

Ejemplo:

DB_URL=jdbc:postgresql://xxxx.neon.tech/neondb?sslmode=require  
DB_USERNAME=tu_usuario  
DB_PASSWORD=tu_password  

⚠️ Este archivo no se sube al repositorio (está en `.gitignore`)

---

### Ejecutar la aplicación

Linux / Mac:

./mvnw spring-boot:run

Windows:

mvnw spring-boot:run

La API iniciará en:

http://localhost:8080

---

## Seguridad

Las credenciales de la base de datos se manejan mediante **variables de entorno** y no se almacenan en el código fuente.

---

## Estado del proyecto

En desarrollo 🚧

Próximas mejoras:

- Autenticación JWT
- Roles (USER / ADMIN)
- Sistema de moderación
- Tests
- Documentación con Swagger
- Deploy en Render
- Moderación hibrida con integración de IA
---

## Objetivo

Practicar desarrollo backend profesional aplicando:

- Arquitectura por capas
- Buenas prácticas con JPA
- Manejo de base de datos cloud
- Seguridad con variables de entorno
- Diseño de API REST real

---

## Autora

Belén Almendros  
Desarrolladora Full Stack 
