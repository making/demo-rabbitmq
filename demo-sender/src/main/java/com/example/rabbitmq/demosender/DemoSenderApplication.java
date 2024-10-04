package com.example.rabbitmq.demosender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSenderApplication.class, args);
	}

}
