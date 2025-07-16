package org.alilopez.di;

import org.alilopez.controller.ProductController;
import org.alilopez.controller.StatsController;
import org.alilopez.controller.UserController;
import org.alilopez.controller.VentasController;
import org.alilopez.repository.*;
import org.alilopez.routes.ProductsRoutes;
import org.alilopez.routes.StatsRoutes;
import org.alilopez.routes.UserRoutes;
import org.alilopez.routes.VentasRoutes;
import org.alilopez.service.ProductService;
import org.alilopez.service.StatsService;
import org.alilopez.service.UserService;
import org.alilopez.service.VentasService;

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

    public static VentasRoutes initVentas() {
        CarritoRepository carritoRepository = new CarritoRepository();
        DetalleCarritoRepository detalleCarritoRepository = new DetalleCarritoRepository();
        VentasService ventasService = new VentasService(carritoRepository, detalleCarritoRepository);
        VentasController  ventasController = new VentasController(ventasService);
        VentasRoutes ventasRoutes = new VentasRoutes(ventasController);
        return ventasRoutes;
    }

    public static StatsRoutes initStats() {
        StatsRepository  statsRepository = new StatsRepository();
        StatsService statsService = new StatsService(statsRepository);
        StatsController  statsController = new StatsController(statsService);
        StatsRoutes statsRoutes = new StatsRoutes(statsController);
        return statsRoutes;
    }
}
