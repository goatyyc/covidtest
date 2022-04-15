package com.example.covidtest.controller;

import com.example.covidtest.config.annotation.AfterLogin;
import com.example.covidtest.mapper.UserMapper;
import com.example.covidtest.pojo.Response;
import com.example.covidtest.pojo.Site;
import com.example.covidtest.service.ISiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/14 20:17
 */
@Slf4j
@RestController
public class InfoController {
    
    @Autowired
    private ISiteService siteService;
    
    @AfterLogin
    @GetMapping("/getSites")
    public Response getSites(){
        siteService.getSiteList();
        return Response.success();
    }
    
    @AfterLogin
    @GetMapping("/searchSites")
    public Response search(String keyWord){
        List<Site> siteList = siteService.searchByKey(keyWord);
        return Response.success(siteList);
    }

}
