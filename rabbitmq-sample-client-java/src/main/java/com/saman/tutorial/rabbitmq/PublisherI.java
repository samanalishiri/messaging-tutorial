package com.saman.tutorial.rabbitmq;

/**
 * @author Saman Alishiri, samanalishiri@gmail.com
 */
public interface PublisherI {
    void publish(String message);

    void close();
}
