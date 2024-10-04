package com.example.rabbitmq.demoreceiver;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class AmqpConfig {

	@Bean
	public TopicExchange orderExchange() {
		return new TopicExchange("demo");
	}

	@Bean
	public Queue orderEventQueue() {
		return QueueBuilder.durable("demo.event").quorum().build();
	}

	@Bean
	public Binding orderEventBinding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("event");
	}

	@Bean
	public Jackson2JsonMessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}