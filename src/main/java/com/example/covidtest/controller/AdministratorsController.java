package com.example.covidtest.controller;

import com.example.covidtest.pojo.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 居家预定子系统
 * @author: yyc
 * @time: 2022/4/17 14:17
 */
@RestController
public class AdministratorsController {

    /**
     * 扫描二维码，发放RAT，并更新用户预约的信息
     * @return
     */
    @PostMapping("/updateBookingInfo")
    public Response updateBooking(){
        // 验证用户信息
        

        // 更新booking状态


        return Response.success();
    }
    

}
