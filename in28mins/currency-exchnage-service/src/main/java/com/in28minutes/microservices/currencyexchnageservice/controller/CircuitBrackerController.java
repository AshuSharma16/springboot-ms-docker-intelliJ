package com.in28minutes.microservices.currencyexchnageservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBrackerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBrackerController.class);
    @GetMapping("/sample-api")
   //@Retry(name= "sample-api" , fallbackMethod = "hardCodedResponse")
    @CircuitBreaker(name= "sample-api" , fallbackMethod = "hardCodedResponse")
    public String sampleApi() {
        logger.info("sample api call recieved");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);
        return forEntity.getBody();
    }

    private String hardCodedResponse(Exception ex) {
        return "sample-api-response";
    }
}
