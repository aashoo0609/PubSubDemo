package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;

@SpringBootApplication
public class PubSubDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubSubDemoApplication.class, args);
	}

	@Bean
	@ServiceActivator(inputChannel = "demoOutputChannel")
	public MessageHandler messageHandler(PubSubTemplate pubSubTemplate){
		return new PubSubMessageHandler(pubSubTemplate,"testTopic");
	}


}
