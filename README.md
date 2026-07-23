# API RESTful de Gestión de Inventario y Ventas

Backend profesional para la gestión de productos, control de stock y procesamiento de ventas en tiempo real. Desarrollado con **Java 17** y **Spring Boot 3**, implementando persistencia de datos relacional y arquitectura limpia en capas.

## Arquitectura y Tecnologías
* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3 (Spring Web, Spring Data JPA)
* **Base de Datos:** H2 Database (Relacional en memoria)
* **Testing:** JUnit 5 y Mockito
* **Gestión de Dependencias:** Maven
* **Manejo de Errores:** Manejador global centralizado con `@RestControllerAdvice` y respuestas JSON estándar.

## Estructura del Proyecto
```text
src/main/java/com/miusuario/sistemainventario/
├── controller/     # Endpoints HTTP REST
├── service/        # Lógica de negocio y validaciones
├── repository/     # Comunicación con la base de datos (Spring Data JPA)
├── model/          # Entidades JPA mapeadas a SQL
└── exception/      # Excepciones de negocio y manejador global HTTP