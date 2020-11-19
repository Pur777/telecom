package com.example.publisher.service;

import com.example.publisher.model.Action;
import com.example.publisher.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PublisherService {

    private final static Logger log = LoggerFactory.getLogger(PublisherService.class);

    public static volatile AtomicInteger count = new AtomicInteger();

    private final String URL = "http://localhost:8080/";

    public synchronized void sendMessage() throws URISyntaxException {
        log.info("Start send message");

        RestTemplate restTemplate = new RestTemplate();

        URI uri = new URI(URL);

        restTemplate.postForEntity(uri, generateMessage(), String.class);

        log.info("Message with id {} sent", count.get());
    }

    private Message generateMessage() {
        Message message = new Message();

        message.setId(count.incrementAndGet());
        message.setMsisdn(generateMsisdn());
        message.setAction(generateAction());
        message.setTimestamp(new Date());
        return message;
    }

    private Integer generateMsisdn() {
        Random random = new Random();
        return random.ints(0, Integer.MAX_VALUE).findFirst().getAsInt();
    }

    private Action generateAction() {
        Random random = new Random();

        return Action.values()[random.ints(0, 2).findFirst().getAsInt()];
    }
}
