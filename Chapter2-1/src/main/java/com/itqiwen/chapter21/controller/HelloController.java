package com.itqiwen.chapter21.controller;

import com.itqiwen.chapter21.domain.User;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model){
        User user = new User();
        user.setId(1L);
        user.setName("小华");
        user.setSex("男");
        User user2 = new User();
        user2.setId(2L);
        user2.setName("小红");
        user2.setSex("男");
        User user3 = new User();
        user3.setId(3L);
        user3.setName("小蓝");
        user3.setSex("女");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        model.addAttribute("name", "小华");

        model.addAttribute("userList", userList);
        return "hello";
    }
}
