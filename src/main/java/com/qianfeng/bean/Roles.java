package com.qianfeng.bean;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
public class Roles {
    private int id;
    private String roles_name;
    private String roles_status;
    private Users users;
    public Roles() {
    }

    public Roles(int id, String roles_name, String roles_status, Users users) {
        this.id = id;
        this.roles_name = roles_name;
        this.roles_status = roles_status;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoles_name() {
        return roles_name;
    }

    public void setRoles_name(String roles_name) {
        this.roles_name = roles_name;
    }

    public String getRoles_status() {
        return roles_status;
    }

    public void setRoles_status(String roles_status) {
        this.roles_status = roles_status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

