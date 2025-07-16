package org.alilopez.repository;

import org.alilopez.config.DatabaseConfig;
import org.alilopez.model.Stat;
import org.alilopez.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatsRepository {
    public List<Stat> createStatsAverage() throws SQLException {
        List<Stat> stats = new ArrayList<>();
        String query = "SELECT \n" +
                "  DATE(fecha) AS fecha,\n" +
                "  SUM(total) AS total_ventas\n" +
                "FROM venta\n" +
                "WHERE fecha BETWEEN '2025-07-01' AND '2025-07-31 23:59:59'\n" +
                "GROUP BY DATE(fecha)\n" +
                "ORDER BY fecha;";
        try (
                Connection conn = DatabaseConfig.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Stat s = new Stat();
                s.setLabel(rs.getDate("fecha").toString());
                s.setValue(rs.getFloat("total_ventas"));
                stats.add(s);
            }
        }
        return stats;
    }
}
