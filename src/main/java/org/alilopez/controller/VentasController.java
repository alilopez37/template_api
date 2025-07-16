package org.alilopez.controller;

import io.javalin.http.Context;
import org.alilopez.dto.CarritoRequestDTO;
import org.alilopez.service.VentasService;

import java.util.Map;

public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    public void create(Context ctx) {
        try {
            CarritoRequestDTO dto = ctx.bodyAsClass(CarritoRequestDTO.class);
            int idCarrito = ventasService.create(dto);
            ctx.status(201).json(Map.of("id_carrito", idCarrito));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ctx.status(400).result("Error al crear la venta");
        }
    }
}
