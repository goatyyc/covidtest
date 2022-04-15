package com.example.covidtest.mapper;

import com.example.covidtest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    
    @Select("select * from user where id = #{id}")
    User findById(int id);

    @Select("select * from user where username=#{username} and password=#{password}")
    User selectUserByParam(String username, String password);
}
