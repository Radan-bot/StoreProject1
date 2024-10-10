public class Main {
    public static void main(String[] args) {
        // Crea una instancia de DatabaseHelper para interactuar con la base de datos
        DatabaseHelper dbHelper = new DatabaseHelper();

        // Limpia la tabla de productos antes de comenzar
        dbHelper.clearProducts();

        // Inserta algunos productos en la base de datos
        System.out.println("Insertando productos...");
        dbHelper.createProduct(1, "Producto A");
        dbHelper.createProduct(2, "Producto B");

        // Muestra los productos actuales almacenados en la base de datos
        System.out.println("\nProductos en la base de datos:");
        dbHelper.readProducts();

        // Actualiza un producto existente en la base de datos
        System.out.println("\nActualizando el producto con ID 1...");
        dbHelper.updateProduct(1, "Producto A Actualizado");

        // Muestra los productos después de la actualización
        System.out.println("\nProductos después de la actualización:");
        dbHelper.readProducts();

        // Elimina un producto de la base de datos
        System.out.println("\nEliminando el producto con ID 2...");
        dbHelper.deleteProduct(2);

        // Muestra los productos después de la eliminación
        System.out.println("\nProductos después de la eliminación:");
        dbHelper.readProducts();
    }
}
