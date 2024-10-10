import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Clase DatabaseHelper para manejar las operaciones de la base de datos
public class DatabaseHelper {
    private Connection conn;

    // Constructor para establecer la conexión con la base de datos MySQL
    public DatabaseHelper() {
        try {
            // Cargar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión con la base de datos storeproject
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/storeproject", "root", "Jean1210.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para crear un nuevo producto en la base de datos
    public void createProduct(int id, String name) {
        String sql = "INSERT INTO productos (id, nombre) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);      // Asignar el ID del producto
            pstmt.setString(2, name); // Asignar el nombre del producto
            pstmt.executeUpdate();    // Ejecutar la inserción
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todos los productos de la base de datos
    public void readProducts() {
        String sql = "SELECT * FROM productos";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            // Iterar sobre los resultados y mostrar cada producto
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar el nombre de un producto existente
    public void updateProduct(int id, String newName) {
        String sql = "UPDATE productos SET nombre = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName); // Asignar el nuevo nombre del producto
            pstmt.setInt(2, id);         // Especificar el producto que se actualizará por ID
            pstmt.executeUpdate();       // Ejecutar la actualización
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un producto de la base de datos
    public void deleteProduct(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);         // Especificar el producto a eliminar por ID
            pstmt.executeUpdate();       // Ejecutar la eliminación
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para limpiar todos los productos de la tabla
    public void clearProducts() {
        String sql = "DELETE FROM productos";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);    // Ejecutar la eliminación de todos los productos
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
