package org.alilopez;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import org.alilopez.di.AppModule;

public class Main {
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(CorsPluginConfig.CorsRule::anyHost);
            });
        }).start(7000);

        // Rutas generales
        app.get("/", ctx -> ctx.result("API Javalin"));

        AppModule.initUser().register(app);
        AppModule.initProducts().register(app);
        AppModule.initVentas().register(app);
        AppModule.initStats().register(app);
    }
}