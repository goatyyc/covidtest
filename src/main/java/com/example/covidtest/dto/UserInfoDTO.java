package com.example.covidtest.dto;

import lombok.Data;

/**
 * @description: 现场测试用户信息表单
 * @author: yyc
 * @time: 2022/4/17 11:53
 */
@Data
public class UserInfoDTO {
    private int uid;
    private String username;
    private String symptoms;    // 症状
    private String pin;
}
