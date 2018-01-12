package com.itqiwen.shiro.domain;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "用户名不能为空")
    private String username; //账号

    @NotEmpty(message = "密码不能为空")
    private String password; //密码


    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中加载数据
    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns ={@JoinColumn(name = "role_id")})
    private List<Role> roleList; //一个用户具有多个角色

    public User() {
        super();
    }

    public User(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }


    public List<Role> getRoleList() {
        return roleList;
    }

    @Transient
    public Set<String> getRolesName(){
        List<Role> roles = getRoleList();
        Set<String> set = new HashSet<>();
        for (Role role :
                roles) {
            set.add(role.getRolename());
        }
        return set;
    }

}
