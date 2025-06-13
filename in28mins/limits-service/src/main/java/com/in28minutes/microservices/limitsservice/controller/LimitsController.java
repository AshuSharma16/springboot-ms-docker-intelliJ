package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.beans.Limits;
import com.in28minutes.microservices.limitsservice.utils.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public Limits getLimits() {
        Limits limits = new Limits(configuration.getMinimum(), configuration.getMaximum());
        return limits;
    }
}
