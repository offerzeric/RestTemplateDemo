package com.eric.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CustomerServiceApplication.class, args);
        Object test = run.getBean("normalHandlerIntecepter");

    }

}
