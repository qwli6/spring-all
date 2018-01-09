package com.itqiwen.web;

import com.alibaba.fastjson.JSON;
import com.itqiwen.entity.User;
import com.itqiwen.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 查找所有用户
     * @return
     */
    @RequestMapping("/list")
    public String findUserList(){
        List<User> userList = userService.findUserList();
        return JSON.toJSONString(userList);
    }

    /**
     * 根据 id 查找用户
     */
    @RequestMapping("/user/{uid}")
    public String findUserById(@PathVariable("uid")String uid){

        User user = userService.findUserById(uid);
        return JSON.toJSONString(user);
    }
}
