package com.qianfeng.controller;

import com.qianfeng.bean.Roles;
import com.qianfeng.bean.Users;
import com.qianfeng.dao.RolesDao;
import com.qianfeng.dao.UsersDao;
import com.qianfeng.service.UsersServices;
import com.qianfeng.utils.*;
import com.qianfeng.utils.Properties;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

@Controller
public class UsersController {
    @Resource
    private UsersDao ud;
    //private RolesDao rd;
    @Resource
    private UsersServices us;


    //后台登录
    @RequestMapping("backLogin.do")
    @ResponseBody
    public int backLogin(Users users, HttpSession session){
        int msg=1;
        Properties properties = new Properties();
        List<String> manager = properties.readProperties();
        String admin_account = manager.get(0);
        String admin_pwd = manager.get(1);
        //先使用MD5算法加密密码
        String users_pwd= MD5Utils.md5(users.getUsers_pwd());
        String users_account = users.getUsers_account();
        //超级管理员登录
        if(users_account.equals(admin_account)&&users_pwd.equals(admin_pwd)){
            session.setAttribute("admins",manager);
        }else{
            Users loginUser = ud.backLogin(users_account,users_pwd);
            if(loginUser!=null) {
                //普通用户的登录
                Roles rolesByUser = ud.findRolesByUser(loginUser.getId());
                if(rolesByUser!=null){
                    System.out.print("登录的角色ID："+rolesByUser.getId());
                    session.setAttribute("role",rolesByUser);
                    session.setAttribute("user",loginUser);
                }else{
                    //角色为空，没有权限
                    msg=0;
                }
                // return 1;
            }else{
                //用户或者密码错误
                msg= -1;
            }

        }

      return msg;
    }
    //退出登录
    @RequestMapping("backOutLogin.do")
    @ResponseBody
    public  int backOutLogin(HttpSession session){
        session.invalidate();
        return 1;
    }
    //查询所有用户
    @RequestMapping("findAllUsers.do")
    @ResponseBody
    public Map<String,Object> findAllUsers(int page,int pagesize){
        return us.findAllUsers(page,pagesize);
    }
    //添加新用户
    @RequestMapping("addUsers.do")
    @ResponseBody
    public int addUsers(Users users){
       return us.addUsers(users);
    }
    //删除用户信息
    @RequestMapping("removeUsersByStatus.do")
    @ResponseBody
    public String removeUsersByStatus(@RequestBody ArrayList<Integer> data){
        System.out.println("删除data"+data);
        return  us.removeUsersByStatus(data);
    }
    //修改用户信息
    @RequestMapping("updateUsers.do")
    @ResponseBody
    public int updateUsers(Users users, @RequestParam( value = "roles_name") String  roles_name){
        System.out.println("角色名字***************"+roles_name);
        return us.updateUsers(users.getId(),roles_name);
    }
    //搜索用户
    @RequestMapping("searchUsersBylike.do")
    @ResponseBody
    public List<Users> searchUsersBylike(String type,String key){
        return us.searchUsersBylike(type,key);
    }

}
