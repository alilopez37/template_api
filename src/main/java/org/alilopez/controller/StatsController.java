package org.alilopez.controller;

import io.javalin.http.Context;
import org.alilopez.dto.StatsDTO;
import org.alilopez.model.Product;
import org.alilopez.model.Stat;
import org.alilopez.service.StatsService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    public void createStatsAverage(Context ctx) {
        try {
            List<Stat> stats = statsService.createStatsAverage();
            List<String> tempLabels = new ArrayList<>();
            List<Float> tempData = new ArrayList<>();
            for (Stat stat : stats) {
                tempLabels.add(stat.getLabel());
                tempData.add(stat.getValue());
            }
            StatsDTO statsDTO = new StatsDTO(tempLabels, tempData);
            ctx.json(statsDTO);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ctx.status(500).result("Error al obtener productos");
        }
    }
}
