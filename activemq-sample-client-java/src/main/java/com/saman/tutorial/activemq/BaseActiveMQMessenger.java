package com.saman.tutorial.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * @author Saman Alishiri, @mail samanalishiri@gmail.com
 *
 */
public abstract class BaseActiveMQMessenger {

    protected static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    protected ConnectionFactory connectionFactory;

    public BaseActiveMQMessenger(String queueName) {
        connectionFactory = new ActiveMQConnectionFactory(URL);
        start(queueName);
    }

    public abstract void start(String subject);
}
