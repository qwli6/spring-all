package com.itqiwen.service.impl;

import com.itqiwen.dao.UserRepository;
import com.itqiwen.entity.User;
import com.itqiwen.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;

    @Override
    public List<User> findUserList() {
        System.out.println("Service-Module ===》 findUserList() ");
        return ((List<User>) userRepository.findAll());
    }

    @Override
    public User findUserById(String uid) {
        System.out.println("Service-Module ===》 findUserById() ");
        return userRepository.findOne(Long.parseLong(uid));
    }
}
