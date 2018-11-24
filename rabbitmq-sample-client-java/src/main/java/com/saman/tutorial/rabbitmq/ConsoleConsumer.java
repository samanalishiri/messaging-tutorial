package com.saman.tutorial.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
public class ConsoleConsumer extends BaseRabbitMQMessenger implements ConsumerI {

    private ConsoleConsumer(Builder builder) {
        super(builder);
    }

    @Override
    public final void consume() {
        logger.info("waiting!!!");
        try {
            Consumer consumer = new DefaultConsumerImpl(this.channel);
            channel.basicConsume(queue, true, consumer);

        } catch (IOException e) {
            logger.error("can not add consumer to channel");
        }
    }

    private final class DefaultConsumerImpl extends DefaultConsumer {

        public DefaultConsumerImpl(Channel channel) {
            super(channel);
        }

        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                throws IOException {

            logger.info(String.format("%s: %s", name, new String(body, UTF_8)));
        }
    }

    public static ConsumerBuilder newBuilder() {
        return new ConsumerBuilder();
    }

    public static final class ConsumerBuilder extends Builder {

        @Override
        public ConsoleConsumer build() {
            return new ConsoleConsumer(this);
        }
    }

    public static void main(String[] args) {
        ConsumerI consumer = ConsoleConsumer.newBuilder()
                .name("consumer")
                .host("localhost")
                .queue("sampleQueue")
                .build();

        consumer.consume();
    }
}
