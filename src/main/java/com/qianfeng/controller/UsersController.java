package com.qianfeng.controller;

import com.qianfeng.bean.Users;
import com.qianfeng.dao.UsersDao;
import com.qianfeng.service.UsersServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    @Resource
    private UsersDao ud;
    @Resource
    private UsersServices us;
    //查询单个用户
    @RequestMapping("dologin.do")
    @ResponseBody
    public String doLogin(Users users){
        ud.login(users);
        return "success";
    }
    //查询所有用户
    @RequestMapping("findAllUsers.do")
    @ResponseBody
    public List<Users> findAllUsers(int page){
        System.out.println("......."+page);
        int start=(page-1)*2;
        List<Users> allusers= ud.findAllUsers(start);
        System.out.println(">>>>>>>>>"+allusers);
        return allusers;
    }
    //添加新用户
    @RequestMapping("addUsers.do")
    @ResponseBody
    public int addUsers(Users users){
       return us.addUsers(users);
    }
    //删除用户信息
    @RequestMapping("removeUsers.do")
    @ResponseBody
    public String removeUsers(@RequestBody ArrayList<Integer> data){

        return  us.removeUsers(data);
    }
    //修改用户信息
    @RequestMapping("updateUsers.do")
    @ResponseBody
    public int updateUsers(Users users){
        return us.updateUsers(users);
    }
    //搜索用户
    @RequestMapping("searchUsersBylike.do")
    @ResponseBody
    public List<Users> searchUsersBylike(String type,String key){
        return us.searchUsersBylike(type,key);
    }
}
