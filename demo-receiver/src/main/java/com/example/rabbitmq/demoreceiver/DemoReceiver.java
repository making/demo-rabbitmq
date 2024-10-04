package com.example.rabbitmq.demoreceiver;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class DemoReceiver {

	private final Logger logger = LoggerFactory.getLogger(DemoReceiver.class);

	@RabbitListener(queues = "demo.event")
	public void receive(Event event, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag)
			throws InterruptedException, IOException {
		logger.info("Received event: {}", event);
		Thread.sleep(500);
		channel.basicAck(tag, false);
	}

}
