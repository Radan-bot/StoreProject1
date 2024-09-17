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

