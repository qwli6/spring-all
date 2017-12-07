package com.itqiwen.chapter43.mapper;


import com.itqiwen.chapter43.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    @ResultType(value = User.class)
    List<User> findAllUser();


    @Insert("insert into user(name, sex, address) values(#{name}, #{sex}, #{address})")
    void insertUser(@Param("name")String name, @Param("sex")String sex, @Param("address")String address);


    @Delete("delete from user where uid = #{uid}")
    void deleteUser(@Param("uid")Long uid);
}
