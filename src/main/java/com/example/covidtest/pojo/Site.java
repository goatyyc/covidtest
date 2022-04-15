package com.example.covidtest.pojo;

import lombok.Data;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/14 23:07
 */
@Data
public class Site {
    private int id;
    private String name;
    private String place;
    private String type;
    private String status;
    private String book;
    private String time;
}
