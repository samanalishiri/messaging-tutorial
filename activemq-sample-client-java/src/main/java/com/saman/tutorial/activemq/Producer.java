package com.saman.tutorial.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author Saman Alishiri, @mail samanalishiri@gmail.com
 */
public class Producer extends BaseActiveMQMessenger {


    public Producer() {
        super("SampleQueue");
    }

    @Override
    public void start(String subject) {
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination queue = session.createQueue(subject);

            MessageProducer producer = session.createProducer(queue);
            TextMessage message = session.createTextMessage("Hello");
            producer.send(message);

            connection.close();

        } catch (JMSException e) {
            System.out.println("connection failed");
        }
    }

    public static void main(String[] args) {
        new Producer();
    }
}