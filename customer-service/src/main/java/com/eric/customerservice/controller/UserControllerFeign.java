package com.eric.customerservice.controller;

import com.eric.customerservice.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author ericzhang 2021/11/21 1:56 下午
 */
@RestController
@RequestMapping("/cf/user")
public class UserControllerFeign {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    public String findAll(){
        String all = userFeign.findAll();
        return all;
    }

}
