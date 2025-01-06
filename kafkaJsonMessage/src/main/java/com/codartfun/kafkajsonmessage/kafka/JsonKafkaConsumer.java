package com.codartfun.kafkajsonmessage.kafka;

import com.codartfun.kafkajsonmessage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);


    @KafkaListener(
            topics = "${spring.application.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(User user) {
        LOGGER.info("Consumed user: {}", user.toString());
    }
}
