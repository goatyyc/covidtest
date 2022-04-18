package com.example.covidtest.controller;

import com.example.covidtest.pojo.Booking;
import com.example.covidtest.pojo.Response;
import com.example.covidtest.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 预约子系统
 * @author: yyc
 * @time: 2022/4/17 10:48
 */
@RestController
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    /**
     * 对应前端传递一个表单参数 : 用户id
     * @param uid
     * @return
     */
    @PostMapping("/generate")
    public Response generatePin(@RequestParam("uid") Integer uid){
        Booking booking = bookingService.insert(uid);
        return Response.success(booking);
    }
    
    @GetMapping("/checkStatus")
    public Response check(@RequestParam("pin") String pin){
        Booking booking = bookingService.queryStatus(pin);
        return Response.success(booking);
    }


}
