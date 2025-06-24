package org.alilopez.routes;

import io.javalin.Javalin;
import org.alilopez.controller.UserController;

public class UserRoutes {
    private final UserController userController = new UserController();

    public void register(Javalin app) {
        app.get("/users", userController::getAll);      // GET /users
        app.post("/users", userController::create);     // POST /users
        // Ejemplo de más rutas:
        // app.get("/users/:id", userController::getById);
        // app.put("/users/:id", userController::update);
        // app.delete("/users/:id", userController::delete);
    }
}
