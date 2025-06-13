package com.in28minutes.microservices.currencyexchnageservice.controller;

import com.in28minutes.microservices.currencyexchnageservice.beans.CurrencyExchange;
import com.in28minutes.microservices.currencyexchnageservice.service.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchnageController {
    @Autowired
    CurrencyExchangeRepository repository;
@Autowired
    Environment env;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange exchnageCurrency(@PathVariable String from , @PathVariable String to) {

        CurrencyExchange currencyExchangeResponse = repository.findByFromAndTo(from, to);
        CurrencyExchange currencyExchange=   new CurrencyExchange(currencyExchangeResponse.getId(), currencyExchangeResponse.getFrom(), currencyExchangeResponse.getTo(),
                currencyExchangeResponse.getConversionMultiple());
        String serverPort = env.getProperty("local.server.port");
        currencyExchange.setEnvironment(serverPort);
        return currencyExchange;
    }
}
