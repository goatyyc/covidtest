package com.example.covidtest.mapper;

import com.example.covidtest.pojo.Site;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SiteMapper {
    @Select("select * from site")
    List<Site> getSiteList();

    List<Site> search(String keyWord);
}
