package com.pablovass.route;

import com.pablovass.pojo.Person;
import com.pablovass.process.ProcessDataUri;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.DataFormat;
import org.springframework.boot.json.JacksonJsonParser;

public class MyRouteBuilder extends RouteBuilder {
    private JacksonJsonParser dataFormat;
    private Person person = new Person();

    public MyRouteBuilder() {
        dataFormat = new JacksonJsonParser (Person.class);
    }

    public void configure() {

        from("timer:simple?period=1000")
                .to("direct:consumirWSRest")
                .end();

        from("direct:consumirWSRest")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("https://jsonplaceholder.typicode.com/users")
                .unmarshal((DataFormat) person)
                .process(new ProcessDataUri());
        // .log("respose ws Rest: ${body}"); no uso el log uso el process
    }
}