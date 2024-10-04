package com.example.rabbitmq.demosender;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoSender {

	private final RabbitTemplate rabbitTemplate;

	private final Random random = new Random(System.nanoTime());

	private final Logger logger = LoggerFactory.getLogger(DemoSender.class);

	public DemoSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Scheduled(fixedRate = 1000)
	public void send() {
		int num = this.random.nextInt(10) + 1;
		for (int i = 0; i < num; i++) {
			CorrelationData correlationData = new CorrelationData();
			this.rabbitTemplate.convertAndSend("demo", "event",
					new Event("Hello World(%d) correlation_id=%s".formatted(i, correlationData.getId())),
					correlationData);
			correlationData.getFuture().thenAccept(confirm -> {
				if (confirm.isAck()) {
					logger.info("Received ack for correlation_id={}", correlationData.getId());
				}
				else {
					logger.warn("Received nack for correlation_id={}", correlationData.getId());
				}
			});

		}
	}

}
