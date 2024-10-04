package com.example.rabbitmq.demoreceiver;

import org.springframework.boot.SpringApplication;

public class TestDemoReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoReceiverApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
