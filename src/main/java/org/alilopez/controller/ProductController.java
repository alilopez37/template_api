package org.alilopez.controller;

import io.javalin.http.Context;
import org.alilopez.model.Product;
import org.alilopez.model.User;
import org.alilopez.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void create(Context ctx) {
        try {
            Product product = ctx.bodyAsClass(Product.class);

            productService.create(product);
            ctx.status(201).result("Producto creado");
        } catch (Exception e) {
            ctx.status(400).result("Error al crear producto");
        }
    }

    public void getAll(Context ctx) {
        try {
            List<Product> products = productService.getAll();
            ctx.json(products);
        } catch (SQLException e) {
            ctx.status(500).result("Error al obtener usuarios");
        }
    }
}
