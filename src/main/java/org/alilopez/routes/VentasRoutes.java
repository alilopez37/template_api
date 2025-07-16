package org.alilopez.routes;

import io.javalin.Javalin;
import org.alilopez.controller.ProductController;
import org.alilopez.controller.VentasController;

public class VentasRoutes {
    private final VentasController ventasController;
    public VentasRoutes(VentasController ventasController) {
        this.ventasController = ventasController;
    }
    public void register(Javalin app) {
        app.post("/ventas", ventasController::create);
    }
}
