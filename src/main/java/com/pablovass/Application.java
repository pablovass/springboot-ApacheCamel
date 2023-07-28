package com.pablovass;

import org.apache.camel.main.Main;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws  Exception {
		SpringApplication.run(Application.class, args);
		Main main = new Main();
		main.configure().addRoutesBuilder(new MyRouteBuilder());
		main.run(args);
	}
    }


