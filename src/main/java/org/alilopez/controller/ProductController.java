package org.alilopez.controller;

import io.github.cdimascio.dotenv.Dotenv;
import io.javalin.http.Context;
import io.javalin.http.UploadedFile;
import org.alilopez.model.Product;
import org.alilopez.model.User;
import org.alilopez.service.ProductService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class ProductController {
    Dotenv dotenv = Dotenv.load();
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

    public void createImage(Context ctx) {
        try {
            var name = ctx.formParam("name");
            var stock = ctx.formParam("stock");
            var price = ctx.formParam("price");
            var file = ctx.uploadedFile("image");

            String fileUrl = saveFile(file);
            Product product = new Product(name,Integer.parseInt(stock),Float.parseFloat(price),fileUrl);

            productService.createWithImage(product);
            ctx.status(201).result("Producto creado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ctx.status(400).result("Error al crear producto");
        }
    }

    private String saveFile(UploadedFile file) throws IOException {
        // Ruta de guardado (dentro de carpeta estática)
        String staticPath = "uploads";
        File uploadDir = new File(staticPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        // Nombre único del archivo
        String fileName = System.currentTimeMillis() + "_" + file.filename();
        File destino = new File(uploadDir, fileName);

        // Guardar el archivo
        try (InputStream is = file.content();
             FileOutputStream os = new FileOutputStream(destino)) {
            is.transferTo(os);
        }

        // Construcción de la URL completa
        String host =  dotenv.get("STATIC_IP"); // incluye IP:puerto
        String fileUrl = String.format("http://%s:7000/uploads/%s", host, fileName);
        return  fileUrl;
    }

    public void getAll(Context ctx) {
        try {
            List<Product> products = productService.getAll();
            ctx.json(products);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ctx.status(500).result("Error al obtener productos");
        }
    }
}
