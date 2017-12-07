package com.itqiwen.chapter44.service.impl;

import com.itqiwen.chapter44.domain.User;
import com.itqiwen.chapter44.mapper.UserMapper;
import com.itqiwen.chapter44.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
