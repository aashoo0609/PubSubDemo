package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubMessageController {

    @Autowired
    private PubSubOutboudGateway gateway;

    @PostMapping("/publishMsg")
    public ResponseEntity publishMessage(@RequestParam("message") String message){
        gateway.sendToPubSub(message);
        return new ResponseEntity(HttpStatus.OK);
    }
}
