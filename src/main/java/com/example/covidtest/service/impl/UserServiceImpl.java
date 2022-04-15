package com.example.covidtest.service.impl;

import com.example.covidtest.mapper.UserMapper;
import com.example.covidtest.pojo.User;
import com.example.covidtest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/14 20:57
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = userMapper.selectUserByParam(username,password);
        return user;
    }
}
