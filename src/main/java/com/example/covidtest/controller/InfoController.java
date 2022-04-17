package com.example.covidtest.controller;

import com.example.covidtest.config.annotation.AfterLogin;
import com.example.covidtest.mapper.UserMapper;
import com.example.covidtest.pojo.Response;
import com.example.covidtest.pojo.Site;
import com.example.covidtest.service.IBookingService;
import com.example.covidtest.service.ISiteService;
import com.example.covidtest.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/14 20:17
 */
@Slf4j
@RestController
public class InfoController {
    
    @Autowired
    private ISiteService siteService;
    
    @Autowired
    private IBookingService bookingService;
    
    @AfterLogin
    @GetMapping("/getSites")
    public Response getSites(){
        siteService.getSiteList();
        return Response.success();
    }
    
    @AfterLogin
    @GetMapping("/searchSites")
    public Response search(String keyWord){
        List<Site> siteList = siteService.searchByKey(keyWord);
        return Response.success(siteList);
    }

    /**
     * 用户进行申请
     * @param request
     * @return
     */
    @PostMapping("/bookingAtHome")
    public Response booking(HttpServletRequest request){
        // 获取token中的用户信息
        int uid = JwtUtils.getCurrentUserId(request);
        // 生成二维码和url : 插入一条新预定记录
        bookingService.addBooking(uid);
        // 
        return Response.success();
    }

    /**
     * 用户到测试中心领取设备
     * @param request
     * @return
     */
    @PostMapping("/getFacility")
    public Response getFacility(HttpServletRequest request){
        // 用户到测试中心接收RAT 

        return Response.success();
    }

}
