package org.alilopez.service;

import org.alilopez.model.Product;
import org.alilopez.model.User;
import org.alilopez.repository.ProductRepository;
import org.alilopez.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepo;
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public void create(Product product) throws SQLException {
        // Podrías validar aquí si el email ya existe, etc.
        productRepo.save(product);
    }

    public void createWithImage(Product product) throws SQLException {
        // Podrías validar aquí si el email ya existe, etc.
        productRepo.saveWithImage(product);
    }

    public List<Product> getAll() throws SQLException {
        return productRepo.findAll();
    }
}
