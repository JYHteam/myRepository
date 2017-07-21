package com.qianfeng.controller;

import com.qianfeng.bean.Users;
import com.qianfeng.dao.UsersDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UsersController {
    @Resource
    private UsersDao ud;
  /*  @RequestMapping("dologin.do")
    @ResponseBody
    public List<Users> doLogin(){

        return ud.findAllUsers();
    }*/

}
