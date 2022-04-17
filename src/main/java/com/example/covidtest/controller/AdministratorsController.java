package com.example.covidtest.controller;

import com.example.covidtest.config.annotation.AfterLogin;
import com.example.covidtest.dto.UserInfoDTO;
import com.example.covidtest.pojo.Booking;
import com.example.covidtest.pojo.Response;
import com.example.covidtest.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 居家预定子系统
 * @author: yyc
 * @time: 2022/4/17 14:17
 */
@RestController
public class AdministratorsController {

    @Autowired
    private IBookingService bookingService;
    
    /**
     * 扫描二维码，发放RAT，并更新用户预约的信息
     * @return
     */
    @AfterLogin
    @PostMapping("/updateBookingInfo")
    public Response updateBooking(@RequestParam("code") String code){
        // 验证用户信息
        // 根据code验证是否存在用户预定信息
        Booking booking = bookingService.queryStatus(code);
        if(booking==null){
            return Response.error("预约信息不存在");
        }

        // 更新booking状态 => checking
        booking.setStatus("checking");
        booking.setType("RAT");
        bookingService.update(booking);

        return Response.success();
    }
    

}
