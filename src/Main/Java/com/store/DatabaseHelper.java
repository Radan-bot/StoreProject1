package com.store;

import java.sql.*;  
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DatabaseHelper para gestionar la conexión y las operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar) sobre la tabla de productos en la base de datos MySQL.
 */
public class DatabaseHelper {
    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/storeproject"; 
    private static final String USER = "root"; // Usuario de MySQL
    private static final String PASSWORD = "Jean1210."; // Contraseña de MySQL

    /**
     * Establece una conexión con la base de datos MySQL.
     * 
     * @return una conexión activa con la base de datos.
     * @throws SQLException si hay un error al conectar.
     */
    public Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el controlador
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Inserta un nuevo producto en la base de datos.
     * 
     * @param nombre el nombre del producto a crear.
     */
    public void createProduct(String nombre) {
        String sql = "INSERT INTO productos (nombre) VALUES (?)"; // Consulta SQL para insertar producto
        try (Connection conn = connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);  // Asigna el nombre al primer parámetro de la consulta
            pstmt.executeUpdate();  // Ejecuta la consulta
            System.out.println("Producto creado: " + nombre); // Confirma la creación del producto
        } catch (SQLException e) {
            System.out.println("Error al crear producto: " + e.getMessage()); // Manejo de error
        }
    }

    /**
     * Obtiene una lista de todos los productos de la base de datos.
     * 
     * @return una lista de nombres de productos.
     */
    public List<String> readProducts() {
        List<String> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos"; // Consulta SQL para seleccionar todos los productos

        try (Connection conn = connect(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                productos.add(rs.getString("nombre")); // Agrega cada producto a la lista
            }
        } catch (SQLException e) {
            System.out.println("Error al leer productos: " + e.getMessage()); // Manejo de error
        }
        return productos;
    }

    /**
     * Actualiza el nombre de un producto existente en la base de datos.
     * 
     * @param id el ID del producto a actualizar.
     * @param nuevoNombre el nuevo nombre del producto.
     */
    public void updateProduct(int id, String nuevoNombre) {
        String sql = "UPDATE productos SET nombre = ? WHERE id = ?"; // Consulta SQL para actualizar el producto
        try (Connection conn = connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);  // Asigna el nuevo nombre al primer parámetro
            pstmt.setInt(2, id);  // Asigna el ID al segundo parámetro
            pstmt.executeUpdate();  // Ejecuta la consulta de actualización
            System.out.println("Producto actualizado: " + nuevoNombre); // Confirma la actualización
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage()); // Manejo de error
        }
    }

    /**
     * Elimina un producto de la base de datos.
     * 
     * @param id el ID del producto a eliminar.
     */
    public void deleteProduct(int id) {
        String sql = "DELETE FROM productos WHERE id = ?"; // Consulta SQL para eliminar producto
        try (Connection conn = connect(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);  // Asigna el ID al primer parámetro de la consulta
            pstmt.executeUpdate();  // Ejecuta la consulta de eliminación
            System.out.println("Producto eliminado con ID: " + id); // Confirma la eliminación
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage()); // Manejo de error
        }
    }
}
