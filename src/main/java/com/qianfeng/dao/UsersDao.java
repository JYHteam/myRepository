package com.qianfeng.dao;

import com.qianfeng.bean.Roles;
import com.qianfeng.bean.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface UsersDao {
    //查询数据总数
    int findUsersByCount();
    //只查询单个用户
    Users backLogin(@Param(value="users_account") String users_account, @Param(value="users_pwd") String users_pwd);
    //查询需求的用户,用于模糊查询
    void findUsers(String str);
    //查询所有用户，用于管理员操作
    List<Users> findAllUsers(@Param(value="start") int start, @Param(value="pagesize") int pagesize);
    //添加用户
    void addUsers(Users users);
    void insertUR(@Param(value="role_id") int role_id, @Param(value="user_id") int user_id);
    //用于在添加用户时，验证数据库中是否已存在
    Map<String,String> validboxFindUsers(Users users);
    //删除用户
    void removeUsersByStatus(ArrayList<Integer> data);
    //修改用户信息
    void updateUsers(Users users);
    void editRolesUsers(@Param(value="role_id") int role_id, @Param(value="user_id") int user_id);
    //搜索
    List<Users> searchUsersBylike(Map<String,String>data);
    //通过用户查询角色
    Roles findRolesByUser(int user_id);
    int findIdByName(String users_account);
}
