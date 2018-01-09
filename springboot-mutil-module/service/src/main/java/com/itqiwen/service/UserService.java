package com.itqiwen.service;

import com.itqiwen.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUserList();

    User findUserById(String uid);
}
