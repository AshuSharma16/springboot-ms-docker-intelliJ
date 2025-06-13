package com.in28minutes.microservices.currencyconversionservice.utils;

import com.in28minutes.microservices.currencyconversionservice.beans.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url="http://localhost:8000/", name= "currency-exchnage-service")
@FeignClient(name= "currency-exchnage-service")
public interface CurencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion exchnageCurrency(@PathVariable String from , @PathVariable String to) ;

}
