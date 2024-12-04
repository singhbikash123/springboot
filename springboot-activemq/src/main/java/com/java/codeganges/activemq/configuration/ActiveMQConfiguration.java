package com.java.codeganges.activemq.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Queue;

@Component
@PropertySource("classpath:application.properties")
public class ActiveMQConfiguration {
	
	 @Value("${spring.activemq.broker-url}")
	    private String brokerUrl;

	    @Bean
	    public ConnectionFactory connectionFactory(){
	        ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
	        activeMQConnectionFactory.setBrokerURL(brokerUrl);
	        return  activeMQConnectionFactory;
	    }

	    @Bean
	    public JmsTemplate jmsTemplate(){
	        JmsTemplate jmsTemplate = new JmsTemplate();
	        jmsTemplate.setConnectionFactory(connectionFactory());
	        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
	        return jmsTemplate;
	    }
	
	    
	    @Bean
	    public Queue queue() {
	        return new ActiveMQQueue("codeganges.request");
	    } 

}
