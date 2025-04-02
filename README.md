# Proyecto Spring Boot - CRUD de Estudiantes con PostgreSQL

Este proyecto es una aplicación de **Spring Boot** que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre un conjunto de estudiantes utilizando una base de datos **PostgreSQL**.

## Descripción

El proyecto simula una gestión de estudiantes en una universidad, permitiendo almacenar, consultar, actualizar y eliminar la información de los estudiantes. Se utiliza **Spring Boot** para el desarrollo del backend, **PostgreSQL** como base de datos y **JPA (Hibernate)** para la gestión de la persistencia de datos.

## Funcionalidades

- **Obtener todos los estudiantes**
- **Obtener estudiante por ID**
- **Crear un nuevo estudiante**
- **Actualizar información de un estudiante**
- **Eliminar un estudiante**

## Tecnologías Utilizadas

- **Spring Boot**: Framework para el desarrollo de aplicaciones Java basadas en microservicios.
- **PostgreSQL**: Sistema de gestión de bases de datos relacional.
- **JPA (Hibernate)**: Proveedor de persistencia para manejar la base de datos.
- **Java**: Lenguaje de programación principal.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   ```
2. Abre el proyecto en tu IDE favorito (como IntelliJ IDEA o Eclipse).
3. Configura la conexión a la base de datos en el archivo ```application.properties:```
```
	spring.datasource.url=jdbc:postgresql://localhost:5432/universidad
	spring.datasource.username=luz
	spring.datasource.password=1234
   ```
4. Crea la base de datos universidad en PostgreSQL (si no existe aún).
5. Ejecuta la aplicación con Maven:
```mvn spring-boot:run```
6. La aplicación estará corriendo en http://localhost:8081.

## Endpoints

### 1. Obtener todos los estudiantes

- **Método**: `GET`
- **URL**: `/API/universidad/estudiantes`
- **Respuesta**: Lista de todos los estudiantes.

### 2. Obtener estudiante por ID

- **Método**: `GET`
- **URL**: `/API/universidad/estudiantes/{id}`
- **Parámetros**: `{id}` - ID del estudiante.
- **Respuesta**: Datos del estudiante con el ID especificado.

### 3. Crear un nuevo estudiante

- **Método**: `POST`
- **URL**: `/API/universidad/estudiantes`
- **Cuerpo**: JSON con los datos del estudiante.

  ```json
  {
    "nombre": "Juan",
    "apellido": "Pérez",
    "email": "juan.perez@example.com",
    "fechaNacimiento": "2000-01-01",
    "numeroInscripcion": "2023001"
  }
### 4. Actualizar un estudiante

- **Método**: `PUT`
- **URL**: `/API/universidad/estudiantes/{id}`
- **Parámetros**: `{id}` - ID del estudiante.
- **Cuerpo**: JSON con los datos actualizados del estudiante.

### 5. Eliminar un estudiante

- **Método**: `DELETE`
- **URL**: `/API/universidad/estudiantes/{id}`
- **Parámetros**: `{id}` - ID del estudiante a eliminar.

## Configuración de la Base de Datos

La base de datos utilizada en este proyecto es **PostgreSQL**. Asegúrate de tener PostgreSQL instalado y configurado en tu máquina. Luego, crea una base de datos llamada `universidad` y la tabla `estudiantes`  y usa las credenciales definidas en el archivo `application.properties`.

## Consideraciones

- El archivo `application.properties` debe contener las credenciales correctas para la base de datos.
- La propiedad `spring.jpa.hibernate.ddl-auto=update` asegura que Hibernate actualizará el esquema de la base de datos de acuerdo con las entidades del proyecto, lo que es útil durante el desarrollo.
