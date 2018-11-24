package com.saman.tutorial.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
public abstract class BaseRabbitMQMessenger {

    protected static final String UTF_8 = "UTF-8";

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final String name;
    protected final String host;
    protected final String queue;

    protected final Connection connection;
    protected final Channel channel;

    protected BaseRabbitMQMessenger(Builder builder) {
        this.name = builder.name;
        this.host = builder.host;
        this.queue = builder.queue;
        this.connection = createConnection();
        this.channel = createChannel();
    }

    private final Connection createConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);

        try {
            return factory.newConnection();

        } catch (IOException e) {
            logger.error("can not connect to message broker!");
        } catch (TimeoutException e) {
            logger.error("time out!");
        }

        return null;
    }

    private final Channel createChannel() {

        try {
            Channel channel = connection.createChannel();
            channel.queueDeclare(queue, false, false, false, null);

            return channel;
        } catch (IOException e) {
            logger.error("can not create channel!");
        }

        return null;
    }

    public static abstract class Builder {
        private String name = "publisher/consumer";
        private String host = "localhost";
        private String queue = "sampleQueue";

        protected Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder host(String val) {
            host = val;
            return this;
        }

        public Builder queue(String val) {
            queue = val;
            return this;
        }

        public abstract <E extends BaseRabbitMQMessenger> E build();
    }
}
