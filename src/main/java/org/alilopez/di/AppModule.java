package org.alilopez.di;

import org.alilopez.controller.UserController;
import org.alilopez.repository.UserRepository;
import org.alilopez.routes.UserRoutes;
import org.alilopez.service.UserService;

public class AppModule {
    public static UserRoutes initUser() {
        UserRepository userRepo = new UserRepository();
        UserService userService = new UserService(userRepo);
        UserController userController = new UserController(userService);
        return new UserRoutes(userController);
    }
}
