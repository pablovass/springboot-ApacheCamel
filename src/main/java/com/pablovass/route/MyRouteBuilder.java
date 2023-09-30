package com.pablovass.route;

import com.pablovass.processor.ProcessDataExchangeProcessor;
import com.pablovass.processor.SetDataExchangeProcessor;
import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    public void configure() {

        from("timer:simple?period=1000")
                .process(new SetDataExchangeProcessor())
                .to("direct:processarMensaje")
                .end();

        // Definir rutas de transformación aquí
        from("direct:processarMensaje")
                .log("inicio procesamiento de mensaje")
                .log("Body = ${body}, Cabecera1 = ${header.cabecera1}")
                .process(new ProcessDataExchangeProcessor())
                .end();


    }
}