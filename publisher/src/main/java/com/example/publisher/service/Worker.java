package com.example.publisher.service;

import java.net.URISyntaxException;

public class Worker implements Runnable {

    private PublisherService publisherService;

    public Worker(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(15000);
                publisherService.sendMessage();
            } catch (URISyntaxException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
