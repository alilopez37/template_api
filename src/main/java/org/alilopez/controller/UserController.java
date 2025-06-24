package org.alilopez.controller;

import io.javalin.http.Context;
import org.alilopez.model.User;
import org.alilopez.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private final UserService userService = new UserService();

    public void getAll(Context ctx) {
        try {
            List<User> users = userService.getAllUsers();
            ctx.json(users);
        } catch (SQLException e) {
            ctx.status(500).result("Error al obtener usuarios");
        }
    }

    public void create(Context ctx) {
        try {
            User user = ctx.bodyAsClass(User.class);
            userService.createUser(user);
            ctx.status(201).result("Usuario creado");
        } catch (Exception e) {
            ctx.status(400).result("Error al crear usuario");
        }
    }
}
