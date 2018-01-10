package com.itqiwen.chapter42.controller;


import com.alibaba.fastjson.JSON;
import com.itqiwen.chapter42.dao.UserRepository;
import com.itqiwen.chapter42.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //指定每页显示的页大小
    private static final Integer PAGE_SIZE = 4;

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String userList(){
        List<User> all = (List<User>) userRepository.findAll();
        String s = JSON.toJSONString(all);
        return s;
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String findUserByName(){
        User user = userRepository.findUserByName("二花");
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public String findUserById(@PathVariable Long uid){
        User one = userRepository.findOne(uid);
        return JSON.toJSONString(one);
    }

    /**
     *  user/小白/0
     * @param name
     * @param sex
     * @return
     */
    @RequestMapping(value = "/{name}/{sex}", method = RequestMethod.GET)
    public String findUserByNameAndSex(@PathVariable String name, @PathVariable String sex){
        User user = userRepository.findUserByNameAndSex(name, sex);
        return JSON.toJSONString(user);
    }

    /**
     * 模糊查询就写死参数了
     * @return
     */
    @RequestMapping(value = "/like")
    public String findUserByNameAndSex2(){
        List<User> userList = userRepository.findUserByNameAndSex2("%凰%", "女");
        return JSON.toJSONString(userList);
    }

    /**
     * 添加分页方法
     * 不添加条件
     * 添加条件的分页方法在注释中
     */
    @RequestMapping(value = "/page/{pageCode}", method = RequestMethod.GET)
    public String findUserByPage(@PathVariable("pageCode")String pageCode){
        Integer page = Integer.parseInt(pageCode);
        Pageable userPage = new PageRequest(page-1, PAGE_SIZE);

        Page<User> users = userRepository.findAll(userPage);

//        查询 users 用户中所有性别为 1 的用户进行分页
//        User user = new User();
//        user.setSex("1");
//        Example<User> userExample = Example.of(user);
//        Page<User> users = userRepository.findAll(userExample, userPage);

        users.getTotalPages();//总页数
        return JSON.toJSONString(users.getContent());
    }

}

