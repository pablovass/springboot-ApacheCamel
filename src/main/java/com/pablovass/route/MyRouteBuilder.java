package com.pablovass.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {
    public void configure() {

        from("timer:simple?period=1000")
                .to("direct:consumirWSRest")
                .end();

        from("direct:consumirWSRest")
               .setHeader(Exchange.HTTP_METHOD,constant("GET"))
                .to("https://jsonplaceholder.typicode.com/users")
                .log("respose ws Rest: ${body}");
    }
}