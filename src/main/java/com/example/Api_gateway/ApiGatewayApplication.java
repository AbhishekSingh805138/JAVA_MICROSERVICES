package com.example.Api_gateway;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/api/products/**")
                        .uri("http://localhost:1111"))
                .route("customer-service", r -> r.path("/api/customers/**")
                        .uri("http://localhost:2222"))
                .route("order-service", r -> r.path("/api/orders/**")
                        .uri("http://localhost:3333"))
                .build();
    }

}
