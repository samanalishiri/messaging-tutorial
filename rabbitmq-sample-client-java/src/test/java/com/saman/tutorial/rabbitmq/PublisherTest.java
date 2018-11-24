package com.saman.tutorial.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PublisherTest {

    @Test
    public void publishMessage() {
        PublisherI publisher = Publisher.newBuilder()
                .name("publisher")
                .host("localhost")
                .queue("sampleQueue")
                .build();

        publisher.publish("Hello");
        publisher.close();
    }
}
