package com.itqiwen.dao;

import com.itqiwen.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

}
