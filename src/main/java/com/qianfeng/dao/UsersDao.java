package com.qianfeng.dao;

import com.qianfeng.bean.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao {
    void login(Users users);
}
