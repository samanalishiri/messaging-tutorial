package com.saman.tutorial.springactivemq.messaging;

import com.saman.tutorial.springactivemq.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final Product product) {
        jmsTemplate.send(session -> session.createObjectMessage(product));
    }

}