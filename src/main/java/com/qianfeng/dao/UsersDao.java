package com.qianfeng.dao;

import com.qianfeng.bean.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao {
    //只查询单个用户
    void login(Users users);
    //查询需求的用户,用于模糊查询
    void findUsers(String str);
    //查询所有用户，用于管理员操作
    void findAllUsers();
}
