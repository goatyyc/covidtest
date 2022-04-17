package com.example.covidtest.dto;

import lombok.Data;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/17 11:24
 */
@Data
public class BookingDTO {
    private int id;
    private int uid;
    private String pin;
    private String status;
}
