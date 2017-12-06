package com.itqiwen.chapter41.service;

import com.itqiwen.chapter41.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {

    void saveUser(User user);

    List<User> findAllUser();


    void deleteByName(String name);

    void updateUserById(Long uid, String name);
}
