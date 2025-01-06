package com.codartfun.kafkademospringmessage.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "codartfun-kafka-topic", groupId = "myGroup")
    public void consume(String message) {
        LOGGER.info("Consumed message: {}", message);
    }
}
