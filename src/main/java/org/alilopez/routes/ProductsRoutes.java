package org.alilopez.routes;

import io.javalin.Javalin;
import org.alilopez.controller.ProductController;
import org.alilopez.controller.UserController;

public class ProductsRoutes {
    private final ProductController productController;
    public ProductsRoutes(ProductController productController) {
        this.productController = productController;
    }
    public void register(Javalin app) {
        app.get("/products", productController::getAll);
        app.post("/products", productController::create);
        app.post("/products/image", productController::createImage);
        //app.get("/products/{id}", productController::getById);
        // app.put("/products/:id", productController::update);
        // app.delete("/products/:id", productController::delete);
    }
}
