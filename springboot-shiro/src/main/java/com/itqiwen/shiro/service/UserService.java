package com.itqiwen.shiro.service;

import com.itqiwen.shiro.domain.User;

public interface UserService {
    User findByLoginName(String currentLoginName);

}
