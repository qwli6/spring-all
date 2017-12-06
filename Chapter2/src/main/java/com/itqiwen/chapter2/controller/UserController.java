package com.itqiwen.chapter2.controller;

import com.itqiwen.chapter2.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * Controller 用来处理 http 请求，
 * RestController 用来给页面返回 json 字符串
 *
 * 如果 Controller 也要返回 Json 字符串，需要和 ResponseBody 配合
 *
 * 利用 springboot 构建 restful 风格的 api
 */

@RestController
@RequestMapping("/user")  //所有请求都在 /user 下
public class UserController {


    /**
     * 查询用户列表
     * 访问地址： http://localhost:8080/user/list
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String userList(){

        //查询出全部的用户，将 userList 转换成 json 串返回

        return "userList";
    }


    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user){

        return "save Success";
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id){

        return "Delete User success";
    }
}
