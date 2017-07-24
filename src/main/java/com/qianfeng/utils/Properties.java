package com.qianfeng.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class Properties {
    //超级管理员的配置文档
    public List<String> readProperties(){
        try {
            //FileInputStream fis=new FileInputStream("/configuration.properties");
            java.util.Properties properties=new java.util.Properties();
            properties.load(this.getClass().getResourceAsStream("/configuration.properties"));
            //fis.close();
            String users_account = properties.getProperty("users_account");
            String users_pwd = properties.getProperty("users_pwd");
            System.out.print("账户"+users_pwd);
            List<String> propers= new ArrayList<String>();
            propers.add(users_account);
            propers.add(users_pwd);
            return propers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
