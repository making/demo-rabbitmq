package com.example.rabbitmq.demosender;

import org.springframework.boot.SpringApplication;

public class TestDemoSenderApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoSenderApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
