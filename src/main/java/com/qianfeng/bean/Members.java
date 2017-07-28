package com.qianfeng.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class Members implements Serializable {
   private String id;
   private String member_name;
   private String member_nickname;
   private String member_phone;
   private int member_type;
   private String member_pwd;
   private String member_email;
   private int member_status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname;
    }

    public String getMember_phone() {
        return member_phone;
    }

    public void setMember_phone(String member_phone) {
        this.member_phone = member_phone;
    }

    public int getMember_type() {
        return member_type;
    }

    public void setMember_type(int member_type) {
        this.member_type = member_type;
    }

    public String getMember_pwd() {
        return member_pwd;
    }

    public void setMember_pwd(String member_pwd) {
        this.member_pwd = member_pwd;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public int getMember_status() {
        return member_status;
    }

    public void setMember_status(int member_status) {
        this.member_status = member_status;
    }
}
