package com.example.covidtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description: 前端控制器，返回页面
 * @author: yyc
 * @time: 2022/4/14 20:32
 */
@Controller
public class FrontEndController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
