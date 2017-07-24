package com.qianfeng.service;

import com.qianfeng.bean.Users;
import com.qianfeng.dao.UsersDao;
import com.qianfeng.utils.MD5Utils;
import org.springframework.stereotype.Service;
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
    //多单个用户查询服务
    public void login(){

    }

    public Map<String,Object> findAllUsers(int page,int pagesize){
       try {
           Map<String, Object> map = new HashMap<String, Object>();
           int start = (page-1)*pagesize;
           System.out.println(start);
           List<Users> allusers = ud.findAllUsers(start,pagesize);
           System.out.println("........"+allusers);
           int total = ud.findUsersByCount();
           System.out.println("////////total"+total);
           map.put("total", total);
           map.put("users", allusers);
           return map;
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }
    //添加
    public int addUsers(Users users){


        int xhr=-1;
      try {
         Map<String,String> map=ud.validboxFindUsers(users);

          System.out.println(map);
            if (map!=null) {
              xhr=0;
            }
          if (map==null) {
              String users_pwd= MD5Utils.md5(users.getUsers_pwd());
              Map<String,Object> map1=new HashMap<String, Object>();
              map1.put("users_account",users.getUsers_account());
              map1.put("users_pwd",users_pwd);
              ud.addUsers(map1);
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
    //修改
    public int updateUsers(Users users){
        System.out.println("修改"+users);
        Map<String,Object> map=new HashMap<String, Object>();
        try{
            String users_pwd = MD5Utils.md5(users.getUsers_pwd());
            map.put("users_account",users.getUsers_account());
            map.put("users_pwd",users.getUsers_pwd());
            ud.updateUsers(map);
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
