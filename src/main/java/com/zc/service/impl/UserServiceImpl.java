package com.zc.service.impl;

import com.zc.mapper.UserMapper;
import com.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/9 17:43
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String getPassword(String userName) {
        return userMapper.getByName(userName).getPassword();
    }
}
