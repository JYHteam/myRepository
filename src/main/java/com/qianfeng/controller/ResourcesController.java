package com.qianfeng.controller;

import com.qianfeng.bean.Resources;
import com.qianfeng.bean.Users;
import com.qianfeng.dao.ResourcesDao;
import com.qianfeng.service.ResourcesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ResourcesController {
    @Resource
    private ResourcesDao rd;
    @Resource
    private ResourcesService rs;



    /**
     * 查询所有资源
     * @return 返回的树格式的JSON数据
     */
    @RequestMapping("findAllResources.do")
    @ResponseBody
    public Map<String,Object> findAllResources(){
        return rs.findAllResources();
    }

    /**
     * 根据角色查询所属资源
     * @param session
     * @return
     */
    @RequestMapping("findResourceByRole.do")
    @ResponseBody
    public List<Resources> findResourcesByRole(int roleId){
        //Users users =(Users) session.getAttribute("users");

        //return rs.findResourcesByRole(users.getId());
        return rs.findResourcesByRole(roleId);
    }

    /**
     *
     * @param arrjson
     * @return
     */
    @RequestMapping("fenpResource.do")
    @ResponseBody
    public int fenpResources(@RequestBody ArrayList<Integer> arrjson){

        return rs.fenpResources(arrjson);
    }
}
