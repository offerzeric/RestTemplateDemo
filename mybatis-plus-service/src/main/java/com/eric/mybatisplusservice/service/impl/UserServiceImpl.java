package com.eric.mybatisplusservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.AbstractChainWrapper;
import com.eric.mybatisplusservice.exception.TestException;
import com.eric.mybatisplusservice.mapper.UserMapper;
import com.eric.mybatisplusservice.pojo.DemoUser;
import com.eric.mybatisplusservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author ericzhang 2021/11/17 10:16 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String findAll() {
        QueryWrapper<DemoUser> demoUserQueryWrapper = new QueryWrapper<DemoUser>();
        try {
            List<DemoUser> demoUsers = userMapper.selectList(demoUserQueryWrapper);
            return JSON.toJSONString(demoUsers);
        }catch (Exception e){
            TestException testException = new TestException(e.getCause(),Boolean.TRUE);
            throw testException;
        }
    }
}
