package com.example.covidtest.service;

import com.example.covidtest.dto.UserInfoDTO;
import com.example.covidtest.pojo.Booking;

public interface IBookingService {
    
    Booking insert(Integer uid);

    Booking queryStatus(String pin);

    void updateBooking(UserInfoDTO userInfoDTO);
    
    void update(Booking booking);

    void addBooking(int uid,String code,String flag);
}
