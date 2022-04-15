package com.example.covidtest.pojo;

import lombok.Data;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/13 0:48
 */
@Data
public class User {
    int id;
    String username;
    String password;
    String email;
    String type;
    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
