package com.example.covidtest.service;

import com.example.covidtest.pojo.Site;

import java.util.List;

public interface ISiteService {
    List<Site> getSiteList();

    List<Site> searchByKey(String keyWord);
}
