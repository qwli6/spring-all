package com.itqiwen.shiro.config;

import com.itqiwen.shiro.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;

/**
 * 该配置文件相当于 application-shiro.xml 文件的 java 配置
 *
 * shiro 配置
 * 这里定义 shiro 的规则
 * Apache Shiro 的核心是通过 Filter 来实现的，和 SpringMvc 通过
 * DispatchServlet 作为核心控制器一样。
 *
 * 通过 URL 规则来进行过滤和权限校验，因此我们需要定义一系列的访问权限
 */
@Configuration
public class ShiroConfig {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);


    @Bean
    public EhCacheManager getEnCacheManager(){
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    /**
     * shiro 的 web 过滤器，命名为：shiroFilter
     * org.apache.shiro.mgt.SecurityManager;
     * @param securityManager 这个是 shiro 包下的 安全管理器，lang 包下面也有一个，别导包导入错了
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        logger.info("注入 shiro 的 web 过滤器---> shiroFilter");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //Shiro 的核心安全接口，这个属性必须要
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //要求登录的连接，根据羡慕的 url 替换，不是必须的属性，
        shiroFilterFactoryBean.setLoginUrl("/login");

        //登录成功后要跳转的连接，逻辑也可以自定义
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //用户在没有权限的情况下访问资源显示的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/page/403");




        return shiroFilterFactoryBean;
    }


    /**
     * Shiro的安全管理，主要是身份认证的管理，缓存管理，cookie管理
     * @return
     */
    @Bean(name = "securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        userRealm.setCacheManager(cacheManager);
        return userRealm;
    }

    /**
     * 凭证匹配器
     * 告诉 shiro 该使用什么方式（加密算法）来匹配密码，默认是 Base64 编码
     * @return
     */
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){

        logger.info("正在密码匹配器中进行高效匹配中....");
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }


    /**
     * shiro 生命周期处理器
     * 保证实现了Shiro内部lifecycle函数的bean执行。
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

















}
