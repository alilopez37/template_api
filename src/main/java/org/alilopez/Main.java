package org.alilopez;

import io.javalin.Javalin;
import org.alilopez.routes.UserRoutes;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        /*Javalin app = Javalin.create(config -> {
            config.plugins.enableCors(cors -> {
                cors.add(it -> {
                    it.anyHost(); // ⚠️ Permite todos los orígenes. Usa con cuidado en producción.
                });
            });
        }).start(7000);*/

        // Rutas generales
        app.get("/", ctx -> ctx.result("API Javalin modularizada"));

        new UserRoutes().register(app);
    }
}