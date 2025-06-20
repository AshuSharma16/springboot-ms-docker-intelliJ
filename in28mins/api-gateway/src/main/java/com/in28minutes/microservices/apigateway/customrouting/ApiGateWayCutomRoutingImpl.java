package com.in28minutes.microservices.apigateway.customrouting;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGateWayCutomRoutingImpl {

    /*@Bean
    public RouteLocator getwayRouter(RouteLocatorBuilder builder) {
        //builder.routes().build();
        Function<PredicateSpec, Buildable<Route>> routeFunction =
                p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("MyHeader", "MyValue")
                                .addRequestParameter("MyParam", "MyParameters"))

                        .uri("http://httpbin.org:80");

      return  builder.routes().route(routeFunction).build();

    }*/

  /*  @Bean
    public RouteLocator getwayRouter(RouteLocatorBuilder builder) {
        //builder.routes().build();
      *//*  Function<PredicateSpec, Buildable<Route>> routeFunction =
                p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchnage-service");*//*

        return builder.routes().route(
                p -> p.path("/currency-exchange/**")
                .uri("lb://currency-exchnage-service"))
                .build();

    }*/

   @Bean
    public RouteLocator getwayRouter(RouteLocatorBuilder builder) {
            return builder.routes()
                .route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchnage-service"))

                .route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service"))

                .route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-service"))

                .route(p -> p.path("/currency-conversion-new/**)")
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                "/currency-conversion-feign/${segment}"))
                                          .uri("lb://currency-conversion-service"))

                .build();

    }
}
