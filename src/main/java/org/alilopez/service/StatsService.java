package org.alilopez.service;

import org.alilopez.model.Product;
import org.alilopez.model.Stat;
import org.alilopez.repository.CarritoRepository;
import org.alilopez.repository.DetalleCarritoRepository;
import org.alilopez.repository.StatsRepository;

import java.sql.SQLException;
import java.util.List;

public class StatsService {
    private final StatsRepository statsRepository;
    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public List<Stat> createStatsAverage() throws SQLException {
        return statsRepository.createStatsAverage();
    }
}
