package com.example.covidtest.service;

import com.example.covidtest.pojo.User;

public interface IUserService {
    public User findById(int id);
    
    public User findUserByUsernameAndPassword(String username,String password);
}
