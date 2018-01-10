package com.itqiwen.chapter42.dao;

import com.itqiwen.chapter42.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 继承哪一个都行，一般继承 Crud 这个就够了
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    /**
     * spring-data-jpa 内置了一些实现，
     * 所以我们并不需要书写查询语句
     * @param name
     * @return
     */
    User findUserByName(String name);

    /**
     * 自己书写 HQL 语句
     * @param name
     * @param sex
     * @return
     */
    @Query("select u from User u where u.name = ?1 and u.sex = ?2")
    User findUserByNameAndSex(String name, String sex);


    /**
     * 模糊查询
     * @param name
     * @param sex
     * @return
     */
    @Query("select u from User u where u.name like ?1 and u.sex = ?2")
    List<User> findUserByNameAndSex2(String name, String sex);
}
