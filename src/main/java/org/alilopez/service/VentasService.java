package org.alilopez.service;

import org.alilopez.dto.CarritoRequestDTO;
import org.alilopez.dto.ventas.DetalleCarritoDTO;
import org.alilopez.model.Carrito;
import org.alilopez.model.DetalleCarrito;
import org.alilopez.model.Product;
import org.alilopez.repository.CarritoRepository;
import org.alilopez.repository.DetalleCarritoRepository;
import org.alilopez.repository.ProductRepository;

import java.sql.SQLException;

public class VentasService {
    private final CarritoRepository carritoRepository;
    private final DetalleCarritoRepository detalleCarritoRepository;
    public VentasService(CarritoRepository carritoRepository, DetalleCarritoRepository detalleCarritoRepository) {
        this.carritoRepository = carritoRepository;
        this.detalleCarritoRepository = detalleCarritoRepository;
    }

    public int create(CarritoRequestDTO dto) throws SQLException {
        // 1. Crear entidad Carrito
        Carrito carrito = new Carrito(dto.idCliente, Float.valueOf(dto.carrito.total));

        int idCarrito = carritoRepository.save(carrito);

        // 2. Crear detalle
        for (DetalleCarritoDTO detalleDTO : dto.carrito.detalleCarrito) {
            DetalleCarrito detalleCarrito = new DetalleCarrito();
            detalleCarrito.setIdCarrito(idCarrito);
            detalleCarrito.setIdProducto(detalleDTO.idProducto);
            detalleCarrito.setCantidad(detalleDTO.cantidad);
            detalleCarrito.setPrecioUnitario(detalleDTO.precioUnitario);
            detalleCarritoRepository.save(detalleCarrito);
        }

        return idCarrito;
    }
}
