package org.alilopez.routes;

import io.javalin.Javalin;
import org.alilopez.controller.StatsController;
import org.alilopez.controller.UserController;

public class StatsRoutes {
    private final StatsController statsController;
    public StatsRoutes(StatsController statsController) {
        this.statsController = statsController;
    }
    public void register(Javalin app) {
        app.get("/stats/average", statsController::createStatsAverage);
    }
}
