package com.itqiwen.chapter44.mapper;

import com.itqiwen.chapter44.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    void insertUser();

    void deleteUser();

    List<User> findAllUser();
}
