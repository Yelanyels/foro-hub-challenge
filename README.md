# 🏛️ ForoHub - Challenge Back End Alura Latam

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk" alt="Java">
  <img src="https://img.shields.io/badge/Spring_Boot-3.2.0-6DB33F?style=for-the-badge&logo=spring-boot" alt="Spring Boot">
  <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white" alt="Security">
</p>

---

## 📝 Descripción del Proyecto
**ForoHub** es una API REST robusta diseñada para gestionar un foro de discusión. El proyecto replica el funcionamiento a nivel de servidor 
de una plataforma donde los usuarios pueden interactuar a través de tópicos. Se centra en la implementación de un **CRUD completo** 
(Crear, Leer, Actualizar, Eliminar) y un sistema de **seguridad profesional** para proteger la integridad de los datos.

---

## ✨ Funcionalidades Principales
* 🔐 **Autenticación con JWT**: Sistema de inicio de sesión que genera tokens únicos para cada usuario.
* 🛡️ **Seguridad Stateless**: Implementación de **Spring Security** para restringir el acceso a usuarios no autorizados.
* 📚 **Gestión de Tópicos**: Operaciones completas sobre los temas del foro, persistidos en base de datos.
* ✅ **Validaciones de Negocio**: Control de datos para evitar registros duplicados o campos vacíos.
* 💾 **Persistencia**: Integración total con **MySQL** utilizando Spring Data JPA.

---

## 🛠️ Stack Tecnológico
| Componente | Tecnología |
| :--- | :--- |
| **Lenguaje** | Java 17 |
| **Framework** | Spring Boot 3 |
| **Seguridad** | Spring Security & Auth0 JWT |
| **Base de Datos** | MySQL |
| **Migraciones** | Flyway |
| **Gestor Dependencias** | Maven |

---

## ⚙️ Configuración del Proyecto
Para ejecutar este proyecto en tu entorno local, sigue estos pasos:

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/foro-hub-challenge.git](https://github.com/tu-usuario/foro-hub-challenge.git)
    ```
2.  **Configurar Base de Datos:**
    Modifica el archivo `src/main/resources/application.properties` con tus credenciales:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/forohub_db
    spring.datasource.username=root
    spring.datasource.password=tu_contraseña
    ```
3.  **Compilar y Ejecutar:**
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

---

## 🚦 Guía de Uso (API Endpoints)
La API utiliza un flujo de seguridad **Stateless**. Para probar los endpoints, sigue este orden:

1.  **Login**: Envía un `POST` a `/login` con tus credenciales. Recibirás un `jwTtoken`.
2.  **Autorización**: En tus peticiones a `/topicos`, agrega un encabezado de tipo **Authorization** con el valor `Bearer <tu_token>`.

### Endpoints Disponibles:
* `GET /topicos` - Listar todos los tópicos.
* `POST /topicos` - Crear un nuevo tópico.
* `GET /topicos/{id}` - Ver detalle de un tópico.
* `PUT /topicos/{id}` - Actualizar información.
* `DELETE /topicos/{id}` - Eliminar un tópico.

---

## 👤 Autor
Desarrollado por **Junnior Cueva** – *Estudiante de Java y Back-End en Alura Latam.*
