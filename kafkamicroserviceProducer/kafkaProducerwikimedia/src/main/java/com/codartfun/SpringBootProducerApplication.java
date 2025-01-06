package com.codartfun;

import com.codartfun.producer.WikimediaChangesProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootProducerApplication.class);

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendWikimediaChanges();
    }
}
