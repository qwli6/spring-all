package com.itqiwen.shiro.service;

import com.itqiwen.shiro.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> findByUserId(String username) {
        return null;
    }
}
