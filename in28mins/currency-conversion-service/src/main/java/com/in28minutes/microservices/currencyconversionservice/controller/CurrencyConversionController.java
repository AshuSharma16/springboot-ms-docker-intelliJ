package com.in28minutes.microservices.currencyconversionservice.controller;

import com.in28minutes.microservices.currencyconversionservice.beans.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.utils.CurencyExchangeProxy;
import com.in28minutes.microservices.currencyconversionservice.utils.RestTemplateConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class CurrencyConversionController {
    private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
    @Autowired
    private CurencyExchangeProxy proxy;

    @Autowired
    RestTemplate template;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getTotalCalculatedAmount(@PathVariable String from, @PathVariable String to,
                                                       @PathVariable BigDecimal quantity) {

        logger.info("stating of getTotalCalculatedAmount  >>>>>");

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("from", from);
        uriParams.put("to", to);


       /* ResponseEntity<CurrencyConversion> responseEntity =
                new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, uriParams);*/
        ResponseEntity<CurrencyConversion> responseEntity =
                template.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversion.class, uriParams);
        CurrencyConversion finalResp = responseEntity.getBody();

        return new CurrencyConversion(finalResp.getId(), finalResp.getFrom(), finalResp.getTo(), finalResp.getConversionMultiple(),
                finalResp.getEnvironment(), quantity.multiply(finalResp.getConversionMultiple()), quantity);

    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getTotalCalculatedAmountUsingFeign(@PathVariable String from, @PathVariable String to,
                                                                 @PathVariable BigDecimal quantity) {


        CurrencyConversion finalResp = proxy.exchnageCurrency(from, to);

        return new CurrencyConversion(finalResp.getId(), finalResp.getFrom(), finalResp.getTo(), finalResp.getConversionMultiple(),
                finalResp.getEnvironment(), quantity.multiply(finalResp.getConversionMultiple()), quantity);

    }
}
