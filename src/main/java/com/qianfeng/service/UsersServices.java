package com.qianfeng.service;

import com.qianfeng.bean.Users;
import com.qianfeng.dao.RolesDao;
import com.qianfeng.dao.UsersDao;
import com.qianfeng.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServices {
    @Resource
    private UsersDao ud;
    @Resource
    private RolesDao rd;
    //多单个用户查询服务
    public void login(){

    }

    public Map<String,Object> findAllUsers(int page,int pagesize){
       try {
           Map<String, Object> map = new HashMap<String, Object>();
           int start = (page-1)*pagesize;
           List<Users> allusers = ud.findAllUsers(start,pagesize);
           int total = ud.findUsersByCount();
           map.put("total", total);
           map.put("users", allusers);
           return map;
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }
    //添加
    @Transactional
    public int addUsers(Users users){
        int xhr=-1;
      try {
         Map<String,String> map=ud.validboxFindUsers(users);
            if (map!=null) {
              xhr=0;
            }
          if (map==null) {
              String users_pwd= MD5Utils.md5(users.getUsers_pwd());
              //添加user
              Users users1=new Users(users.getUsers_account(),users_pwd,1);
              //添加用户
              ud.addUsers(users1);
              //通过用户查询ID
              int user_id = ud.findIdByName(users1.getUsers_account());
              //插入中间表
              ud.insertUR(Integer.parseInt(users.getRoles().getRoles_name()),user_id);
              xhr=1;
          }
      }catch (Exception e){
          e.printStackTrace();
      }
      return xhr;
    }
    //删除
    public String removeUsersByStatus( ArrayList<Integer> data){
       try {
           ud.removeUsersByStatus(data);
           return "删除用户信息成功";
       }catch (Exception e){
           e.printStackTrace();
       }
        return "删除用户信息失败";
    }
    //修改(只能修改角色)
    public int updateUsers(int user_id, String roles_name){
        try{
            ud.editRolesUsers(Integer.parseInt(roles_name),user_id);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    //搜索
    public List<Users> searchUsersBylike(String type,String key){
       try {
           Map<String, String> data = new HashMap<String, String>();
           data.put("type", type);
           data.put("key", "%" + key + "%");
           return ud.searchUsersBylike(data);
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }
}
