package com.saman.tutorial.springactivemq.messaging;

import com.saman.tutorial.springactivemq.model.MessageModel;
import com.saman.tutorial.springactivemq.model.ProductStatus;
import com.saman.tutorial.springactivemq.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

import static com.saman.tutorial.springactivemq.config.MessagingConfiguration.PRODUCT_QUEUE;

@Component
public class QueueListenerService {

    private static final Logger LOG = LoggerFactory.getLogger(QueueListenerService.class);

    @Autowired
    private ProductService productService;

    @JmsListener(destination = PRODUCT_QUEUE)
    public void receiveMessage(final Message<MessageModel> message) throws JMSException {

        MessageHeaders headers = message.getHeaders();
        LOG.info("Application : headers received : {}", headers);

        MessageModel model = message.getPayload();
        LOG.info("Application : model received : {}", model);

        productService.updateStatus(model.getProductId(), ProductStatus.getByCode(model.getReturnCode()));
    }

}