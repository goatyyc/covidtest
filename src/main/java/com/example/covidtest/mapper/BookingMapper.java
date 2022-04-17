package com.example.covidtest.mapper;

import com.example.covidtest.dto.BookingDTO;
import com.example.covidtest.pojo.Booking;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/17 11:03
 */

@Repository
@Mapper
public interface BookingMapper {
    
    void insert(Booking dto);

    Booking query(String pin);

    void update(Booking booking);

    void insertBooking(Booking booking);
}
