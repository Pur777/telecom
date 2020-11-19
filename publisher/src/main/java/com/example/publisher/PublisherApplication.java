package com.example.publisher;

import com.example.publisher.service.PublisherService;
import com.example.publisher.service.Worker;
import com.example.publisher.util.StaticContextAccessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class PublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);

		PublisherService publisherService = StaticContextAccessor.getBean(PublisherService.class);

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Worker(publisherService));
		}
	}

}
