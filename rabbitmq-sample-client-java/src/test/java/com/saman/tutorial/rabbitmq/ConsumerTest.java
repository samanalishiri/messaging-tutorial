package com.saman.tutorial.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConsumerTest {

    @Test
    public void publishMessage() {
        ConsumerI consumer = ConsoleConsumer.newBuilder()
                .name("consumer")
                .host("localhost")
                .queue("sampleQueue")
                .build();

        consumer.consume();
    }
}
