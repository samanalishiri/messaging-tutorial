package com.saman.tutorial.springactivemq.messaging;

import com.saman.tutorial.springactivemq.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.Map;

import static com.saman.tutorial.springactivemq.config.MessagingConfiguration.PRODUCT_QUEUE;

@Component
public class QueueListenerService {

    private static final Logger LOG = LoggerFactory.getLogger(QueueListenerService.class);

    @JmsListener(containerFactory = "jmsListenerContainerFactory", destination = PRODUCT_QUEUE)
    public void receiveMessage(@Payload Product product,
                               @Headers Map<String, Object> headers) throws JMSException {

        LOG.info("Application : message received : {}", product);
    }

}