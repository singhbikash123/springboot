package com.java.codeganges.activemq.logistics;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsumer {
	

    @JmsListener(destination = "codeganges.request")
    public void consume(String msg) {
        System.out.println("Picked up message: " + msg);
    }  

}
