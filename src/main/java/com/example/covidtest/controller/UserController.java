package com.example.covidtest.controller;

import com.example.covidtest.dto.UserLoginDTO;
import com.example.covidtest.mapper.UserMapper;
import com.example.covidtest.pojo.Response;
import com.example.covidtest.pojo.User;
import com.example.covidtest.service.IUserService;
import com.example.covidtest.utils.JwtUtils;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/13 0:27
 */
@Slf4j
@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    
    @PostMapping("/login")
    public String userLogin(HttpServletResponse httpServletResponse, @RequestParam("username") String username, @RequestParam("password") String password,Model model){
        // 打印参数信息
        log.info("data:{}",username);
        log.info("data:{}",password);
        // 生成token 设置cookie
        User user = userService.findUserByUsernameAndPassword(username, password);
        if(user==null){
            return "login";
        }
        // 生成token
        String token = JwtUtils.generateToken(user.getId());
        // 设置token到cookie中
        Cookie cookie = new Cookie("token",token);
        httpServletResponse.addCookie(cookie);
        model.addAttribute("username",username);
//        model.addAttribute("tpye",user.getType());
        // 根据不用类型切换不同路由
        return routerByType(user.getType());
    }

    private String routerByType(String type) {
        String router;
        switch (type){
            case "user":
                router="index";
                break;
            case "administrators":
                router="adminIndex";
                break;
            case "customer":
                router="customerIndex";
                break;
            case "administerer":
                router="administererIndex";
                break;
            default:
                router="error";
        }
        return router;
    }

    private String generateToken(String username) {
        return "sec"+":"+username;
    }


    @GetMapping("/getUser")
    public void getUser(int id){
    }
    
    @GetMapping("/testCookie")
    public String getCookie(HttpServletRequest httpServletRequest){
        log.info("cookie:{}",httpServletRequest.getCookies());
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                log.info("token:{}",token);
                int uid = JwtUtils.getUserIdByToken(token);
                log.info("userId:{}",uid);
            }
        }
        return "index";
    }
    
}
