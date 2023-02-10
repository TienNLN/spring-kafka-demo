package com.tiennln.practicespringkafka.services.impl;

import com.tiennln.practicespringkafka.services.KafkaService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author TienNLN on 08/02/2023
 */
@AllArgsConstructor
@Service
public class KafkaServiceImpl implements KafkaService {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String topicName, String message) {
        CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(topicName, message);

        completableFuture.whenComplete((sendResult, throwable) -> {
            if (throwable != null) {
                System.out.println("Error happened");
            }

            System.out.println("Sent message: [" + sendResult.getRecordMetadata().offset() + "]");
        });
    }

    @Override
    @KafkaListener(topics = "notificationTopic")
    public void consumeMessage(String text) {
        System.out.println("Consume message: " + text);
    }
}
