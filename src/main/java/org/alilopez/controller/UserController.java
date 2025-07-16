package org.alilopez.controller;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.alilopez.dto.UserDTO;
import org.alilopez.mapper.UserMapper;
import org.alilopez.model.User;
import org.alilopez.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void getAll(Context ctx) {
        try {
            List<User> users = userService.getAllUsers();
            // ---------------------------
            var dtoList = users.stream()
                    .map(UserMapper::toDTO)
                    .toList();
            ctx.json(dtoList);
            // ---------------------------
        } catch (SQLException e) {
            ctx.status(500).result("Error al obtener usuarios");
        }
    }

    public void getById(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            User user = userService.getByIdUser(id);
            if (user != null) {
                ctx.json(user);
            } else {
                ctx.status(HttpStatus.NOT_FOUND).result("Usuario no encontrado");
            }
        } catch (Exception e) {
            ctx.status(404).result("Error al obtener usuarios");
        }
    }

    public void create(Context ctx) {
        try {
            User user = ctx.bodyAsClass(User.class);
            userService.createUser(user);
            //UserDTO dto = ctx.bodyAsClass(UserDTO.class);
            //userService.createUser(UserMapper.toEntity(dto));

            ctx.status(201).result("Usuario creado");
        } catch (Exception e) {
            ctx.status(400).result("Error al crear usuario");
        }
    }
}
