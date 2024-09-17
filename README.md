# StoreRDN

## Descripción

Este proyecto es una aplicación que utiliza JDBC para conectarse a una base de datos MySQL. La aplicación realiza operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una tabla llamada `productos` en la base de datos `storeproject`.

## Estructura del Proyecto

- **src/**: Contiene el código fuente de la aplicación.
  - `Main.java`: Clase principal que realiza la conexión con la base de datos y ejecuta operaciones CRUD.
- **lib/**: Contiene el conector JDBC para MySQL.
  - `mysql-connector-j-9.0.0.jar`: Archivo JAR del conector JDBC.
- **README.md**: Este archivo con información sobre el proyecto.

## Requisitos

- Java Development Kit (JDK) 11 o superior.
- MySQL 8.0 o superior.
- MySQL Connector/J.

## Configuración

1. **Instalar el conector JDBC**:
   - Descarga el archivo `mysql-connector-j-9.0.0.jar` desde [MySQL](https://dev.mysql.com/downloads/connector/j/).

2. **Configurar la base de datos**:
   - Asegúrate de que MySQL esté instalado y en ejecución.
   - Crea una base de datos llamada `storeproject`.
   - En MySQL Workbench, ejecuta el siguiente comando para crear la tabla `productos`:
     ```sql
     CREATE TABLE IF NOT EXISTS productos (
       id INT PRIMARY KEY AUTO_INCREMENT,
       nombre VARCHAR(50)
     );
     ```

3. **Compilación y Ejecución**:

   - **Compilar**:
     ```bash
     javac -cp ".;lib/mysql-connector-j-9.0.0.jar" src/Main.java
     ```

   - **Ejecutar**:
     ```bash
     java -cp ".;lib/mysql-connector-j-9.0.0.jar;src" Main
     ```

## Funcionalidades

- **Conexión a la base de datos**: Conecta con la base de datos MySQL `storeproject`.
- **Operaciones CRUD**:
  - **Crear**: Inserta un nuevo producto en la base de datos.
  - **Leer**: Consulta y muestra los productos existentes en la base de datos.
  - **Actualizar**: Actualiza el nombre de un producto específico.
  - **Eliminar**: Elimina un producto de la base de datos.

## Documentación de Código

- **Nombramiento de Variables**: Utilizar nombres descriptivos y en minúsculas con guiones bajos (ej. `product_id`).
- **Nombramiento de Métodos**: Utilizar camelCase (ej. `createProduct`).
- **Nombramiento de Clases**: Utilizar PascalCase (ej. `Main`).
- **Nombramiento de Paquetes**: Utilizar minúsculas y separadas por puntos (ej. `com.example.store`).

## Uso

Después de compilar y ejecutar la aplicación, se mostrará en la consola un mensaje indicando que la conexión fue exitosa y que las operaciones CRUD se realizaron correctamente.

## Contribuciones

Si deseas contribuir a este proyecto, por favor realiza un fork del repositorio, realiza tus cambios y envía un pull request para revisión.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

