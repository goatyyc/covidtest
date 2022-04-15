package com.example.covidtest.config.intercetor;

import com.example.covidtest.config.annotation.AfterLogin;
import com.example.covidtest.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/15 10:23
 */
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拦截token
        boolean haveAnnotation = handler.getClass().isAssignableFrom(HandlerMethod.class);
        if(haveAnnotation){
            AfterLogin login = ((HandlerMethod) handler).getMethodAnnotation(AfterLogin.class);
            if(login!=null){
                // 判断用户是否登录
                if(!isLogin(request)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isLogin(HttpServletRequest request){
        // 获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies==null) return false;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                boolean valid = JwtUtils.isValid(token);
                if(valid){
                    return true;
                }
            }
        }
        return false;
    }
}
