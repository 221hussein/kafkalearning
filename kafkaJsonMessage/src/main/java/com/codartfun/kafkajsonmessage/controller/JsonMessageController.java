package com.codartfun.kafkajsonmessage.controller;


import com.codartfun.kafkajsonmessage.kafka.JsonKafkaProducer;
import com.codartfun.kafkajsonmessage.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private final JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message published");
    }
}
