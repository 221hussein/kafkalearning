package com.codartfun.producer;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class WikimediaChangesProducer {

    private static final Logger LOG = Logger.getLogger(WikimediaChangesProducer.class.getName());


    private final KafkaTemplate<String, String> kafkaTemplate ;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendWikimediaChanges() throws StreamException, InterruptedException {
        String topic = "wikimedia_recentchange";
        // Pour lire les données en temps réel de Wikimedia, nous utilisons EventSource
        BackgroundEventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);

        URI url = URI.create("https://stream.wikimedia.org/v2/stream/recentchange");

        // Utilisation correcte de la construction du Builder
        BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(eventHandler, new EventSource.Builder(url));

        // Assurez-vous d'utiliser la bonne méthode pour démarrer l'EventSource
        BackgroundEventSource eventSource = builder.build();

        // Démarre l'écoute des événements
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }


}
