package com.example.covidtest.service;

import com.example.covidtest.dto.UserInfoDTO;
import com.example.covidtest.pojo.Booking;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class IBookingServiceTest {

    @Autowired
    private IBookingService bookingService;
    
    @Test
    void insert() {
        Booking booking = bookingService.insert(1);
        log.info("data:{}",booking);
//        queryTest(booking.getPin());
        updateBookingTest(booking.getPin());
        booking = bookingService.queryStatus(booking.getPin());
        log.info("update:{}",booking);
    }
    
    @Test
    void queryTest(String pin){
        Booking booking = bookingService.queryStatus(pin);
        log.info("data:{}",booking);
    }
    
    @Test
    void updateBookingTest(String pin){
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setPin(pin);
        userInfoDTO.setSymptoms("no");
        bookingService.updateBooking(userInfoDTO);
        
    }
    
}