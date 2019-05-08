package com.saman.tutorial.springactivemq.messaging;

import com.saman.tutorial.springactivemq.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final Product product) {
        LOG.info("Application : message sent : {}", product);
        jmsTemplate.send(session -> session.createObjectMessage(product));
    }

}