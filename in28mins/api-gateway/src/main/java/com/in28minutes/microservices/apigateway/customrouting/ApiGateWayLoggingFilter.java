package com.in28minutes.microservices.apigateway.customrouting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ApiGateWayLoggingFilter implements GlobalFilter {
private Logger logger = LoggerFactory.getLogger(ApiGateWayLoggingFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Path of teh request recieved is : {}", exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
