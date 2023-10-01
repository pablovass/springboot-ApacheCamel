package com.pablovass.process;

import com.pablovass.pojo.Person;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SetDataExchangeProcessor implements Processor {
    @Override
    public  void process(Exchange exchange)throws Exception{
        // exchange.getOut() esta deprecado asi que usamos exchange.getMessage
      //  exchange.getOut().setBody("Body definido a partir de process");
      //  exchange.getOut().setHeader("Cabecera1", "Body definido a partir de process");
        Person person = new Person("Luis",24);
        Person person1 = new Person("Maria",29);
        exchange.getMessage().setBody(person);
        Person person2 =exchange.getIn().getBody(Person.class);// persona nula
    }
}
