package com.pablovass.camelRouteExamples;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
//ejemplo mas simple
public class MyRouteBuilder00 extends RouteBuilder {
    public void configure() {

        // Definir rutas de entrada aquí
        from("timer:simple?period=1000")
           // .log("Procesando")
           // .setBody(constant("Mensaje a procesar"))
           // .setHeader("Cabecera1", constant("valor cabecera 1"))  las lineas comentadas son cuando se requiere definirlas en cada from
            .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("1 Body in= " + exchange.getIn().getBody());
                        exchange.getOut().setBody("Body definido a partir de process");
                        exchange.getOut().setHeader("Cabecera1", "Body definido a partir de process");

                    }
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
