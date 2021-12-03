package com.eric.serverservice.service.imp;

import com.alibaba.fastjson.JSON;
import com.eric.serverservice.mapper.UserMapper;
import com.eric.serverservice.pojo.DemoUser;
import com.eric.serverservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author ericzhang 2021/11/17 8:34 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String findAll() {
        List<DemoUser> demoUsers = userMapper.selectAll();
        String s = JSON.toJSONString(demoUsers);
        return s;
    }
}
