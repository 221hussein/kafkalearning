package com.codartfun.consumer;

import com.codartfun.model.WikimediaData;
import com.codartfun.repos.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private final WikimediaRepository wikimediaRepository;

    public KafkaConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup"
    )
    public void consume(String enventMessage) {
        LOGGER.info("Received enventMessage: {}", enventMessage);
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(enventMessage);
        wikimediaRepository.save(wikimediaData);
    }


}
