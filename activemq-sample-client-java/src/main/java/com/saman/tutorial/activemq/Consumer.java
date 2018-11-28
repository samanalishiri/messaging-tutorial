package com.saman.tutorial.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author Saman Alishiri, @mail samanalishiri@gmail.com
 */
public class Consumer extends BaseActiveMQMessenger {

    public Consumer() {
       super("SampleQueue");
    }

    @Override
    public void start(String subject) {
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination queue = session.createQueue(subject);

            MessageConsumer consumer = session.createConsumer(queue);

            Message message = consumer.receive();

            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Received message '" + textMessage.getText() + "'");
            }

            connection.close();

        } catch (JMSException e) {
            System.out.println("connection failed");
        }
    }

    public static void main(String[] args) {
        new Consumer();
    }
}