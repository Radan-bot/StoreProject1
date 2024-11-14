package com.store;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final DatabaseHelper databaseHelper;

    public ProductService(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addProduct(String productName) {
        databaseHelper.createProduct(productName);
    }

    public List<String> getAllProducts() {
        return databaseHelper.readProducts();
    }

    public void updateProduct(int id, String newName) {
        databaseHelper.updateProduct(id, newName);
    }

    public void deleteProduct(int id) {
        databaseHelper.deleteProduct(id);
    }
}
