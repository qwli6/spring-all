package com.itqiwen.chapter41.service;

import com.itqiwen.chapter41.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveUser(User user) {
        jdbcTemplate.update("insert into user(name, sex, address) VALUES (?,?,?)",
                user.getName(), user.getSex(), user.getAddress());
    }

    @Override
    public List<User> findAllUser() {
        return jdbcTemplate.queryForList("select * from user", User.class);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from user where name = ?", name);

    }

    @Override
    public void updateUserById(Long uid, String newName) {

    }
}
