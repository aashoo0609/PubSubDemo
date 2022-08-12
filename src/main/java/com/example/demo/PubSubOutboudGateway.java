package com.example.demo;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "demoOutputChannel")
public interface PubSubOutboudGateway {
    void sendToPubSub(String text);

}
