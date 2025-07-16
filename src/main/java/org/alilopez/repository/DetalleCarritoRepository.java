package org.alilopez.repository;

import org.alilopez.config.DatabaseConfig;
import org.alilopez.model.Carrito;
import org.alilopez.model.DetalleCarrito;

import java.sql.*;

public class DetalleCarritoRepository {
    public void save(DetalleCarrito detalleCarrito) throws SQLException {
        int idCliente = 0;
        String query = "INSERT INTO detalle_carrito (idcarrito, idproducto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, detalleCarrito.getIdCarrito());
            stmt.setInt(2, detalleCarrito.getIdProducto());
            stmt.setInt(3, detalleCarrito.getCantidad());
            stmt.setFloat(4, detalleCarrito.getPrecioUnitario());
            stmt.executeUpdate();
        }
    }
}
