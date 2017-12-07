package com.itqiwen.chapter44.controller;

import com.alibaba.fastjson.JSON;
import com.itqiwen.chapter44.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;


    @RequestMapping("/list")
    public String findAllUser(){
        return JSON.toJSONString(userService.findAllUser());
    }
}
