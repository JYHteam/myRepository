package com.qianfeng.service;

import com.qianfeng.dao.UsersDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServices {
    @Resource
    private UsersDao ud;
    //多单个用户查询服务
    public void login(){

    }
}
