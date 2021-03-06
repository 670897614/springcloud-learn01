package com.ljerii.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudnetConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(StudnetConsumer80.class,args);
    }
}
