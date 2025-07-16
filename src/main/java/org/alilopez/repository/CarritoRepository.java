package org.alilopez.repository;

import org.alilopez.config.DatabaseConfig;
import org.alilopez.model.Carrito;
import org.alilopez.model.Product;

import java.sql.*;

public class CarritoRepository {
    public int save(Carrito carrito) throws SQLException {
        int idCliente = 0;
        String query = "INSERT INTO carrito (idcliente, total) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, carrito.getIdCliente());
            stmt.setFloat(2, carrito.getTotal());

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idCliente = generatedKeys.getInt(1);
                        System.out.println("ID generado: " + idCliente);
                    }
                }
            }
        }
        return idCliente;
    }
}

