package com.itqiwen.shiro.dao;

import com.itqiwen.shiro.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    User findUserByUsername(@Param("username")String username);
}
