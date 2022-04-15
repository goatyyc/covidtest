package com.example.covidtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.covidtest.mapper")
public class CovidTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidTestApplication.class, args);
    }

}
