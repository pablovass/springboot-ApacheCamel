package com.pablovass.camelRouteExamples;
import org.apache.camel.builder.RouteBuilder;
// ejemplo usando lambda
public class MyRouteBuilder01 extends RouteBuilder {
    public void configure() {

        from("timer:simple?period=1000")
         .process((exchange)->{   System.out.println("1 Body in= " + exchange.getIn().getBody());
                        exchange.getOut().setBody("Body definido a partir de process");
                        exchange.getOut().setHeader("Cabecera1", "Body definido a partir de process");
         })
            .to("direct:processarMensaje")
                .end();

        // Definir rutas de transformación aquí
        from("direct:processarMensaje")
            .log("inicio procesamiento de mensaje")
            .log("Body = ${body}, Cabecera1 = ${header.cabecera1}")
                .end();


    }
}
