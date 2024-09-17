# StoreRDN

Este proyecto es una demostración de operaciones CRUD utilizando Java y MySQL. El propósito es ilustrar cómo conectar una aplicación Java a una base de datos MySQL y realizar operaciones básicas de manipulación de datos.

## Requisitos

- JDK 11 o superior
- MySQL Server
- MySQL Connector/J

## Instalación

### 1. Configurar MySQL

1. **Descargar e instalar MySQL Server**: Asegúrate de tener MySQL Server en funcionamiento.
2. **Crear una base de datos**:
   - Abre MySQL Workbench.
   - Conéctate al servidor MySQL.
   - Ejecuta el siguiente comando para crear la base de datos:
     ```sql
     CREATE DATABASE storeproject;
     ```

### 2. Configurar el Proyecto

1. **Descargar el conector MySQL JDBC**:
   - Descarga el archivo ZIP del conector desde [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
   - Descomprime el archivo ZIP.
   - Encuentra el archivo JAR en la carpeta descomprimida, por ejemplo, `mysql-connector-j-9.0.0.jar`.

2. **Configurar el Proyecto en VS Code**:
   - Crea una carpeta para tu proyecto, por ejemplo, `StoreRDN`.
   - Dentro de la carpeta `StoreRDN`, crea una subcarpeta llamada `lib` y coloca el archivo JAR del conector MySQL en esta carpeta.
   - Crea una subcarpeta llamada `src` para el código fuente.

### 3. Código

#### `Main.java`

El archivo `Main.java` realiza las siguientes operaciones:

- **Conexión a la base de datos**: Usa JDBC para conectarse a la base de datos MySQL.
- **Operaciones CRUD**:
  - **Crear**: Crea una tabla `productos` si no existe.
  - **Leer**: Consulta y muestra los registros en la tabla `productos`.
  - **Actualizar**: Actualiza un registro en la tabla `productos`.
  - **Eliminar**: Elimina un registro de la tabla `productos`.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Cargar el driver de JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar a la base de datos
            String url = "jdbc:mysql://localhost:3306/storeproject";
            conn = DriverManager.getConnection(url, "root", "Jean1210.");

            // Crear una consulta
            Statement stmt = conn.createStatement();
            
            // Crear la tabla (si no existe)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS productos (id INT PRIMARY KEY, nombre VARCHAR(50))";
            stmt.executeUpdate(createTableSQL);

            // Insertar un nuevo registro
            String insertSQL = "INSERT INTO productos (id, nombre) VALUES (1, 'Producto A')";
            stmt.executeUpdate(insertSQL);

            // Consultar registros
            String selectSQL = "SELECT * FROM productos";
            ResultSet rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

            // Actualizar un registro
            String updateSQL = "UPDATE productos SET nombre = 'Producto Actualizado' WHERE id = 1";
            stmt.executeUpdate(updateSQL);

            // Eliminar un registro
            String deleteSQL = "DELETE FROM productos WHERE id = 1";
            stmt.executeUpdate(deleteSQL);

            System.out.println("Operaciones CRUD realizadas exitosamente.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
