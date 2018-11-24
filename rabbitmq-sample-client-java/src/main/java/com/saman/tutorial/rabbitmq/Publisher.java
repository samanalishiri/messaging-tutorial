package com.saman.tutorial.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
public class Publisher extends BaseRabbitMQMessenger implements PublisherI {

    private Publisher(Builder builder) {
        super(builder);
    }

    @Override
    public final void publish(String message) {

        try {
            channel.basicPublish("", this.queue, null, message.getBytes(UTF_8));
            logger.info(String.format("%s: %s", name, message));

        } catch (IOException e) {
            logger.error("unsupported utf-8!");
        }
    }

    @Override
    public final void close() {
        try {
            channel.close();
            connection.close();

        } catch (IOException e) {
            logger.error("can not close!");
        } catch (TimeoutException e) {
            logger.error("time out!");
        }
    }

    public static PublisherBuilder newBuilder() {
        return new PublisherBuilder();
    }

    public static class PublisherBuilder extends Builder {

        @Override
        public Publisher build() {
            return new Publisher(this);
        }
    }

    public static void main(String[] args) {
        PublisherI publisher = Publisher.newBuilder()
                .name("publisher")
                .host("localhost")
                .queue("sampleQueue")
                .build();

        publisher.publish("Hello");
        publisher.close();
    }
}