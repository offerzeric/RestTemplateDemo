package com.eric.customerservice.controller;

import com.alibaba.fastjson.JSON;
import com.eric.customerservice.pojo.DemoUser;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * description
 *
 * @author ericzhang 2021/11/17 7:46 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(method = RequestMethod.GET, path="/findAll")
    @HystrixCommand(groupKey = "defaultGroup",defaultFallback = "defaultGroupFallback")
    public String findAll(){
//        String forObject = restTemplate.getForObject("http://localhost:9000/eric/user/findAll", String.class);
//        DemoUser demoUser = JSON.parseObject(forObject,DemoUser.class);
        //discoveryClient在eureka client spring factories中被自动配置
        List<ServiceInstance> instances = discoveryClient.getInstances("server-service");
        ServiceInstance serviceInstance = instances.get(0);
        URI uri = serviceInstance.getUri();
        //原生restTemplate方法
//        String forObject = restTemplate.getForObject(instances.get(0).getUri()+"/eric/user/findAll", String.class);
        //laod balacne 访问方法
        String forObject = restTemplate.getForObject("http://server-service"+"/eric/user/findAll", String.class);

        return forObject;
    }


    public String defaultGroupFallback(){
        return "defaultFallback";
    }

}
