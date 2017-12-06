package com.itqiwen.chapter41.controller;


import com.itqiwen.chapter41.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public String saveUser(){

        return "hehe";
    }
}
