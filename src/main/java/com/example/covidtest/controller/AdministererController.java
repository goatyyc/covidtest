package com.example.covidtest.controller;

import com.example.covidtest.dto.UserInfoDTO;
import com.example.covidtest.pojo.Booking;
import com.example.covidtest.pojo.Response;
import com.example.covidtest.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/17 11:53
 */
@RestController
public class AdministererController {

    @Autowired
    private IBookingService bookingService;
    
    @PostMapping("/testOnSite")
    public Response testOnSite(@RequestBody UserInfoDTO userInfoDTO){
        // 业务处理：为booking记录给更新symptoms 、 状态：check
        bookingService.updateBooking(userInfoDTO);
        Booking booking = bookingService.queryStatus(userInfoDTO.getPin());
        return Response.success(booking);
    }
    
}
