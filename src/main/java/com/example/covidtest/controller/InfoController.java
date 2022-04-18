package com.example.covidtest.controller;

import com.example.covidtest.config.annotation.AfterLogin;
import com.example.covidtest.pojo.Booking;
import com.example.covidtest.pojo.Response;
import com.example.covidtest.pojo.Site;
import com.example.covidtest.service.IBookingService;
import com.example.covidtest.service.ISiteService;
import com.example.covidtest.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
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
        List<Site> siteList = siteService.getSiteList();
        return Response.success(siteList);
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
    public Response booking(HttpServletRequest request,@RequestParam("flag") String flag){
        // 获取token中的用户信息
        int uid = JwtUtils.getCurrentUserId(request);
        // 生成二维码和url : 同pin码 作为唯一标识
        String code = uid+":"+(LocalDateTime.now());
        bookingService.addBooking(uid,code,flag);
        Booking booking = bookingService.queryStatus(code);
        return Response.success(booking);
    }
    

}
