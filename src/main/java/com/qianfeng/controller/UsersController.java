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
import java.util.List;

@Controller
public class UsersController {
    @Resource
    private UsersDao ud;
    @Resource
    private UsersServices us;

    @RequestMapping("dologin.do")
    @ResponseBody
    public String doLogin(Users users){
        ud.login(users);
        return "success";
    }
    @RequestMapping("findUsersByAcc.do")
    @ResponseBody
    public void findUsersByAcc(){

    }
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
}
