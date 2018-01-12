package com.itqiwen.shiro;

import com.itqiwen.shiro.domain.Role;
import com.itqiwen.shiro.domain.User;
import com.itqiwen.shiro.service.RoleService;
import com.itqiwen.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class UserRealm extends AuthorizingRealm{


    private Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    /**
     * 授权方法
     * 获取通过认证之后的用户权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {
        //获取登录参数
        String currentLoginName = (String) principalCollection.getPrimaryPrincipal();
        List<String> userRoles = new ArrayList<String>();
        List<String> userPermissions = new ArrayList<>();
        //从数据库中获取当前登录用户的详细信息
        User user = userService.findByLoginName(currentLoginName);
        if(user != null){
            //获取当前用户下的权限列表
            List<Role> roleList = roleService.findByUserId(user.getUsername());
            for (int i = 0; i < roleList.size(); i++) {
                userRoles.add(roleList.get(i).getRolename());
            }
        }else{
            throw new AuthorizationException();
        }

        System.out.println("#######获取角色：" + userRoles);
        System.out.println("#######获取权限：" + userPermissions);

        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(userRoles);
        authorizationInfo.addStringPermissions(userPermissions);
        return authorizationInfo;
    }

    /**
     * 用户认证
     * 获取即将要认证的信息
     * @param authenticationToken 代表用户在界面输入的用户名和密码
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("###【开始认证[sessionId]】" + SecurityUtils.getSubject().getSession().getId());
        String loginName = (String) authenticationToken.getPrincipal();
        System.out.println("###【开始认证查询用户】###");
        User userInfo = userService.findByLoginName(loginName);
        if(userInfo == null){
            throw new UnknownAccountException();//没找到账号信息
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo.getUsername(),
                new Md5Hash(userInfo.getPassword()).toHex(),
                ByteSource.Util.bytes(new Md5Hash(userInfo.getPassword()).toHex()),
                getName());//realm name
        logger.info("进入密码匹配器进行 用户： ["+ userInfo.getUsername() +"]");
        return authenticationInfo;
    }
}
