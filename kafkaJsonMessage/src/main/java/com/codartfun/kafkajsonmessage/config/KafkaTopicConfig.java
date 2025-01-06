package com.codartfun.kafkajsonmessage.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.application.name}")
    private String topicName;

//    create a topic
    @Bean
    public NewTopic myTopicJson() {
        return TopicBuilder.name(topicName).build();
    }




}
