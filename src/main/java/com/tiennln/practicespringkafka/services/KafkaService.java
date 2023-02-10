package com.tiennln.practicespringkafka.services;

/**
 * The interface Kafka service.
 *
 * @author TienNLN on 08/02/2023
 */
public interface KafkaService {

    /**
     * Send message.
     *
     * @param topicName the topic name
     * @param message   the message
     */
    void sendMessage(String topicName, String message);

    /**
     * Consume message.
     *
     * @param text the text
     */
    void consumeMessage(String text);
}
