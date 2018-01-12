package com.itqiwen.shiro.service;

import com.itqiwen.shiro.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findByUserId(String username);
}
