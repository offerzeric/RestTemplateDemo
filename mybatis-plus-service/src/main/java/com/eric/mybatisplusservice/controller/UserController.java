package com.eric.mybatisplusservice.controller;

import com.eric.mybatisplusservice.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * UserService
 *
 * @author ericzhang 2021/11/17 9:57 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String hello(){
        String all = userService.findAll();
        return all;
    }

}
