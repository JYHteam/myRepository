package com.qianfeng.service;

import com.qianfeng.bean.Users;
import com.qianfeng.dao.UsersDao;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServices {
    @Resource
    private UsersDao ud;
    //多单个用户查询服务
    public void login(){

    }

//    public List<Users> findAllUsers(int start){
//        List<Users> allusers=ud.findAllUsers(start);
//            return allusers;
//    }
    //添加
    public int addUsers(Users users ){
      try {
          ud.addUsers(users);
          return 0;
      }catch (Exception e){
          e.printStackTrace();
          return -1;
      }


    }
    //删除
    public String removeUsers( ArrayList<Integer> data){
       try {
           ud.removeUsers(data);
           return "删除用户信息成功";
       }catch (Exception e){
           e.printStackTrace();
           return "删除用户信息失败";
       }

    }
    //修改
    public int updateUsers(Users users){
        try{
            ud.updateUsers(users);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
