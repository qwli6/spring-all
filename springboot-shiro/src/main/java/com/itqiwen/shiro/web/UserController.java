package com.itqiwen.shiro.web;

import com.itqiwen.shiro.domain.User;
import com.itqiwen.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liqiwen
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request){
        logger.info("进到 login Controller 中，开始登录...");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {//调用 subject 的登录方法，进入到 Realm 进行检查
            logger.info("开始利用 shiro 进行检查：检查用户[" + user.getUsername()+"]，校验开始....");
            subject.login(usernamePasswordToken);
            logger.info("开始利用 shiro 进行检查：检查用户[" + user.getUsername()+"]，校验通过....");

        }catch (UnknownAccountException e){
            logger.info("对用户[" + user.getUsername() + "]进行登录验证..验证未通过,未知账户");
            request.setAttribute("message", "未知账户");
        }

        if(subject.isAuthenticated()){
            //验证成功
            logger.info("恭喜您！用户[" + user.getUsername()+"]，校验成功....");
            return "index";
        }else{
            logger.info("恭喜您！用户[" + user.getUsername()+"]，登录失败....");
            return "redirect:/login";
        }

    }
}
