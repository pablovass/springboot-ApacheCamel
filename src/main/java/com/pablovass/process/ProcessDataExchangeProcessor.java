package com.pablovass.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessDataExchangeProcessor implements Processor {
    @Override
    public  void process(Exchange exchange)throws Exception{
        exchange.getOut().setBody("2. Body definido a partir de process");
        exchange.getOut().setHeader("2. Cabecera1", "Body definido a partir de process");
    }
}
