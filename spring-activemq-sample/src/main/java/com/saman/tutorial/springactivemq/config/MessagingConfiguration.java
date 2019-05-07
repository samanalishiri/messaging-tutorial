package com.saman.tutorial.springactivemq.config;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import java.util.Arrays;

@Configuration
public class MessagingConfiguration {

    public static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

    public static final String ORDER_QUEUE = "product-queue";
    public static final String ORDER_RESPONSE_QUEUE = "product-response-queue";


    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("com.saman.tutorial"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(ORDER_QUEUE);
        return template;
    }

}