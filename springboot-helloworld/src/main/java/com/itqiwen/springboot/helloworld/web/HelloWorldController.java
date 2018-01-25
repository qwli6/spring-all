package com.itqiwen.springboot.helloworld.web;


import com.itqiwen.springboot.helloworld.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqiwen
 */
@RestController
public class HelloWorldController {

    @Value("${name}")
    private String username;

    @Value("${sex}")
    private String userSex;

    @RequestMapping(value = "/index")
    public String index(){

        return "hello spring boot";
    }

    @RequestMapping(value = "/user/list")
    public String userList(){
        User user = new User();
        user.setName(username);
        user.setSex(userSex);
        return user.toString();
    }
}
