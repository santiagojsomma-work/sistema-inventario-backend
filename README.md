# Sistema de Inventario - REST API

API REST desarrollada con Spring Boot 3, securizada con JWT y contenedorizada mediante Docker y Docker Compose junto a una base de datos PostgreSQL.

---

## Tecnologías Utilizadas

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3 (Spring Data JPA, Spring Security)
* **Base de Datos:** PostgreSQL 15 (Alpine)
* **Contenedores:** Docker & Docker Compose
* **Documentación:** OpenAPI / Swagger UI
* **Seguridad:** JWT (JSON Web Tokens)

---

## Requisitos Previos

* Docker Engine (versión 20.10 o superior)
* Docker Compose (versión 2.0 o superior)
* Git

---

## Estructura de Servicios en Docker Compose

El proyecto está configurado para ejecutar dos servicios intercomunicados a través de una red privada (`app-network`):

1. **`postgres-db`**: Instancia de PostgreSQL en el puerto `5432`.
2. **`app`**: Aplicación Spring Boot en el puerto `8080`, configurada para esperar a que la base de datos esté completamente inicializada (`healthcheck`).

---

## Instalación y Despliegue# Sistema de Inventario - REST API

API REST desarrollada con Spring Boot 3, securizada con JWT y contenedorizada mediante Docker y Docker Compose junto a una base de datos PostgreSQL.

---

## Tecnologías Utilizadas

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3 (Spring Data JPA, Spring Security)
* **Base de Datos:** PostgreSQL 15 (Alpine)
* **Contenedores:** Docker & Docker Compose
* **Documentación:** OpenAPI / Swagger UI
* **Seguridad:** JWT (JSON Web Tokens)

---

## Requisitos Previos

* Docker Engine (versión 20.10 o superior)
* Docker Compose (versión 2.0 o superior)
* Git

---

## Estructura de Servicios en Docker Compose

El proyecto está configurado para ejecutar dos servicios intercomunicados a través de una red privada (`app-network`):

1. **`postgres-db`**: Instancia de PostgreSQL en el puerto `5432`.
2. **`app`**: Aplicación Spring Boot en el puerto `8080`, configurada para esperar a que la base de datos esté completamente inicializada (`healthcheck`).

---

## Instalación y Despliegue

### 1. Clonar el repositorio

```bash
git clone [https://github.com/tu-usuario/tu-repositorio.git](https://github.com/tu-usuario/tu-repositorio.git)
cd tu-repositorio