package com.example.covidtest.service.impl;

import com.example.covidtest.mapper.SiteMapper;
import com.example.covidtest.pojo.Site;
import com.example.covidtest.service.ISiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: yyc
 * @time: 2022/4/14 23:09
 */
@Slf4j
@Service
public class SiteServiceImpl implements ISiteService {
    
    @Autowired
    private SiteMapper siteMapper;
    
    @Override
    public List<Site> getSiteList() {
        List<Site> list = siteMapper.getSiteList();
        for (Site site : list) {
            log.info("::{}",site);
        }
        return list;
    }

    @Override
    public List<Site> searchByKey(String keyWord) {
        return siteMapper.search(keyWord);
    }
}
