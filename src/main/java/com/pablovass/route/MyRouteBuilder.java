package com.pablovass.route;
import com.pablovass.process.ProcessDataUri;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {


    public MyRouteBuilder() {

    }

    public void configure() {

        from("timer:simple?period=1000")
                .to("direct:consumirWSRest")
                .end();

        from("direct:consumirWSRest")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("https://jsonplaceholder.typicode.com/users")

                .process(new ProcessDataUri());
        // .log("respose ws Rest: ${body}"); no uso el log uso el process
    }
}