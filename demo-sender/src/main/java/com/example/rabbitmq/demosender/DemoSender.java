package com.example.rabbitmq.demosender;

import java.time.Instant;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoSender {
	private final RabbitTemplate rabbitTemplate;

	private final Random random = new Random(System.nanoTime());

	public DemoSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Scheduled(fixedRate = 1000)
	public void send() {
		int num = this.random.nextInt(10) + 1;
		for (int i = 0; i < num; i++) {
			this.rabbitTemplate.convertAndSend("demo", "event", new Event("Hello World(%d) @%s".formatted(i, Instant.now())));
		}
	}
}
