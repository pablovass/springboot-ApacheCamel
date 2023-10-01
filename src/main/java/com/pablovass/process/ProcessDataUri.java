package com.pablovass.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessDataUri implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Body -> " +exchange.getIn().getBody(String.class));
    }
}
