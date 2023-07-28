package com.pablovass;

import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    public  void configure(){

        configureInputRoutes();
        configureTransformationRoutes();
        configureOutputRoutes();

    }
    private void configureInputRoutes() {
        // Definir rutas de entrada aquí
        from("timer:simple?period=1000" )
                .log("Prosesando").end();
    }

    private void configureTransformationRoutes() {
        // Definir rutas de transformación aquí
    }

    private void configureOutputRoutes() {
        // Definir rutas de salida aquí
    }
}
