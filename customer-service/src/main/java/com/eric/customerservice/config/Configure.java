package com.eric.customerservice.config;

import com.eric.customerservice.intercept.TestClientHttpIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * description
 *
 * @author ericzhang 2021/11/17 7:36 下午
 */
@Configuration
@EnableDiscoveryClient
@EnableHystrix
@ComponentScan(basePackages = "com.eric.customerservice")
@EnableFeignClients(basePackages = "com.eric.customerservice.feign")
public class Configure {

    @Autowired
    private TestClientHttpIntercept testClientHttpIntercept;

    @Bean
    @LoadBalanced
    @Order(value = 1)
     //loadbalance的源码在spring cloud common中
    public RestTemplate create(){
        RestTemplate restTemplate = new RestTemplate();
//        所有ClientHttpRequestInterceptor这类的拦截器都需要注入到restTemplate中
        ArrayList<ClientHttpRequestInterceptor> clientHttpRequestInterceptors = new ArrayList<>();
        clientHttpRequestInterceptors.add(testClientHttpIntercept);
        restTemplate.setInterceptors(clientHttpRequestInterceptors);
        return restTemplate;
    }

}
