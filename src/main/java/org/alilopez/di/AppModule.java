package org.alilopez.di;

import org.alilopez.controller.ProductController;
import org.alilopez.controller.UserController;
import org.alilopez.repository.ProductRepository;
import org.alilopez.repository.UserRepository;
import org.alilopez.routes.ProductsRoutes;
import org.alilopez.routes.UserRoutes;
import org.alilopez.service.ProductService;
import org.alilopez.service.UserService;

public class AppModule {
    public static UserRoutes initUser() {
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);
        UserController userController = new UserController(userService);
        return new UserRoutes(userController);
    }

    public static ProductsRoutes initProducts() {
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);
        ProductController productController = new ProductController(productService);
        ProductsRoutes productsRoutes = new ProductsRoutes(productController);
        return productsRoutes;
    }
}
