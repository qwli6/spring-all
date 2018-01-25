package com.itqiwen.shiro.service;

import com.itqiwen.shiro.dao.UserRepository;
import com.itqiwen.shiro.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Override
    public User findByLoginName(String currentLoginName) {
        return userRepository.findUserByUsername(currentLoginName);
    }
}
