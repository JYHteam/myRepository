package com.qianfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {
    @RequestMapping("dologin.do")
    @ResponseBody
    public String doLogin(){
        return "success";
    }
    @ResponseBody
    public String Login1(){
        return "success";
    }
}
