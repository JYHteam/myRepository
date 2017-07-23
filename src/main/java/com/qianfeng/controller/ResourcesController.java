package com.qianfeng.controller;

import com.qianfeng.bean.Resources;
import com.qianfeng.bean.Roles;
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
    public Map<String,Object> findResourcesByRole(HttpSession session){
        Object admins = session.getAttribute("admins");
        //超管登录显示所有资源
        if(admins!=null){
            return rs.findAllResources();
        }else {
            //普通用户登录查询资源权限
            Roles role = (Roles) session.getAttribute("role");
            return rs.findResourcesByRole(role.getId());
        }
    }
    /**
     *分配资源
     * @param arrjson
     * @return
     */
    @RequestMapping("fenpResource.do")
    @ResponseBody
    public int fenpResources(@RequestBody ArrayList<Integer> arrjson){
        return rs.fenpResources(arrjson);
    }
}
