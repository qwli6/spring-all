package com.itqiwen.shiro.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rolename;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private List<Permission> permissionList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    @Transient
    public List<String> getPermissionsName(){
        List<String> list = new ArrayList<>();
        List<Permission> permissionList = getPermissionList();

        for (Permission p :
                permissionList) {
            list.add(p.getPermissionname());
        }
        return list;
    }
}
