package com.example.covidtest.mapper;

import com.example.covidtest.dto.BookingDTO;
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
class BookingMapperTest {

    @Autowired
    private BookingMapper bookingMapper;
    
    @Test
    void insert() {
        Booking dto = new Booking();
        dto.setUid(1);
        dto.setPin("abc");
        dto.setStatus("uncheck");
        bookingMapper.insert(dto);
    }
    
    @Test
    void updateTest(){
        
        
        
    }
}