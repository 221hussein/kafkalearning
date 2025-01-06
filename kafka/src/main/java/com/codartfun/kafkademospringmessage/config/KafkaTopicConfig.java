package com.codartfun.kafkademospringmessage.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

//    create a topic
    @Bean
    public NewTopic myTopic() {
        return TopicBuilder.name("codartfun-kafka-topic").build();
    }




}
