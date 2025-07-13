package org.alilopez.repository;

import org.alilopez.config.DatabaseConfig;
import org.alilopez.model.Product;
import org.alilopez.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public void save(Product product) throws SQLException {
        String query = "INSERT INTO product (name, stock, price) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStock());
            stmt.setFloat(3, product.getPrice());
            stmt.executeUpdate();
        }

    }

    public void saveWithImage(Product product) throws SQLException {
        String query = "INSERT INTO product (name, stock, price, url_image) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getStock());
            stmt.setFloat(3, product.getPrice());
            stmt.setString(4, product.getUrl_image());
            stmt.executeUpdate();
        }
    }

    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (
                Connection conn = DatabaseConfig.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Product p = new Product();
                p.setIdProduct(rs.getInt("idProduct"));
                p.setName(rs.getString("name"));
                p.setStock(rs.getInt("stock"));
                p.setPrice(rs.getFloat("price"));
                p.setUrl_image(rs.getString("url_image"));
                products.add(p);
            }
        }
        return products;
    }
}
