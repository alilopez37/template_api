package org.alilopez.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseConfig {
    private static HikariDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/db_hexagonal");
            config.setUsername("user_hex");
            config.setPassword("IvE1357");
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource = new HikariDataSource(config);
        }
        return dataSource;
    }
}
