package com.example.rabbitmq.demoreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DemoReceiver {
	private final Logger logger = LoggerFactory.getLogger(DemoReceiver.class);

	@RabbitListener(queues = "demo.event")
	public void receive(Event event) {
		logger.info("receive event: {}", event);
	}
}
