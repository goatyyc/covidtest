package com.example.covidtest.service.impl;

import com.example.covidtest.dto.BookingDTO;
import com.example.covidtest.dto.UserInfoDTO;
import com.example.covidtest.mapper.BookingMapper;
import com.example.covidtest.pojo.Booking;
import com.example.covidtest.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/17 11:00
 */
@Service
public class BookingServiceImpl implements IBookingService {
    
    @Autowired
    private BookingMapper bookingMapper;
    
    @Override
    public Booking insert(Integer uid) {
        Booking dto = new Booking();
        dto.setUid(uid);
        dto.setPin(uid+":"+ LocalDateTime.now());
        dto.setStatus("uncheck");
        bookingMapper.insert(dto);
        return dto;
    }

    @Override
    public Booking queryStatus(String pin) {
        return bookingMapper.query(pin);
    }

    @Override
    public void updateBooking(UserInfoDTO userInfoDTO) {
        Booking booking = bookingMapper.query(userInfoDTO.getPin());
        booking.setStatus("check");
        String symptoms = userInfoDTO.getSymptoms();
        if(symptoms.equals("no") || symptoms.equals("slightly")){
            symptoms = "RAT";
        }else if(symptoms.equals("severe")){
            symptoms = "PCR";
        }else {
            symptoms = "RAT";
        }
        booking.setType(symptoms);
        // 更新
        bookingMapper.update(booking);
    }

    @Override
    public void update(Booking booking) {
        bookingMapper.update(booking);
    }

    /**
     * 预定后生成url和二维码
     * @param uid
     */
    @Override
    public void addBooking(int uid,String code,String flag) {
        // 生成二维码和url
        // 生成一个唯一标识
        Booking booking = new Booking();
        booking.setPin(code);
        // flag 为 已经拥有设备，则状态为checking
        if(flag.equals("own")){
            booking.setStatus("checking");
        }else {
            booking.setStatus("uncheck");
        }
        booking.setQrcode(code);
        booking.setUrl(code);
        bookingMapper.insert(booking);
    }
}
