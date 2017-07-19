package com.qianfeng.bean;

import java.io.Serializable;


public class Users implements Serializable {
    private int id;
    private String account;
    private String pwd;
    private int status;

    public Users() {
    }

    public Users(int id, String account, String pwd, int status) {
        this.id = id;
        this.account = account;
        this.pwd = pwd;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
