package com.itqiwen.chapter42.controller;


import com.alibaba.fastjson.JSON;
import com.itqiwen.chapter42.dao.UserRepository;
import com.itqiwen.chapter42.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

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
}

