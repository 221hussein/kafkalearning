package com.codartfun.producer;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.beans.EventHandler;


public class WikimediaChangesHandler implements BackgroundEventHandler {

    private static final Logger sLogger = LoggerFactory.getLogger(WikimediaChangesHandler.class);

    private KafkaTemplate<String, String> mKafkaTemplate;
    private String topic;

    public WikimediaChangesHandler(KafkaTemplate<String, String> mKafkaTemplate, String topic) {
        this.mKafkaTemplate = mKafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        sLogger.info("onMessage: {}", messageEvent.getData());
        mKafkaTemplate.send(topic, messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
