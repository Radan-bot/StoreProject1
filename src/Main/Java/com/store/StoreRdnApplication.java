package com.store.StoreRDN;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que arranca la aplicación Spring Boot.
 */
@SpringBootApplication
public class StoreRdnApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreRdnApplication.class, args);  // Arranca la aplicación Spring Boot
    }

    @Bean
    public CommandLineRunner demo(DatabaseHelper dbHelper) {
        return (args) -> {
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Crear producto");
                System.out.println("2. Leer productos");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Eliminar producto");
                System.out.println("5. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        dbHelper.createProduct(nombre);  // Llamada al método para crear el producto
                        break;
                    case 2:
                        List<String> productos = dbHelper.readProducts();
                        System.out.println("Productos:");
                        for (String producto : productos) {
                            System.out.println("- " + producto);
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el ID del producto a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese el nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        dbHelper.updateProduct(idActualizar, nuevoNombre);
                        break;
                    case 4:
                        System.out.print("Ingrese el ID del producto a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        dbHelper.deleteProduct(idEliminar);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        };
    }
}
