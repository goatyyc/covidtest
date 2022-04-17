package com.example.covidtest.pojo;

import lombok.Data;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/17 11:01
 */
@Data
public class Booking {
    private int id;
    private int uid;
    private String pin;
    private String status;
    private String type;
    private String qrcode;
    private String url;
}
