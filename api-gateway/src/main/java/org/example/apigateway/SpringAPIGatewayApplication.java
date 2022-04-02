package org.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringAPIGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringAPIGatewayApplication.class,args);
    }
}
