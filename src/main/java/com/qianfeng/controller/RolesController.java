package com.qianfeng.controller;

import com.qianfeng.bean.Roles;
import com.qianfeng.bean.Users;
import com.qianfeng.dao.RolesDao;
import com.qianfeng.service.RolesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.management.relation.Role;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class RolesController {
    @Resource
    private RolesDao rd;
    @Resource
    private RolesService rs;

    //显示所有的角色
    @RequestMapping("findAllRoles.do")
    @ResponseBody
    public Map<String, Object> findAllRoles(int page, int pagesize) {

        return rs.findAllRoles(page, pagesize);
    }
    @RequestMapping("bfindAllRoles.do")
    @ResponseBody
    public List<Roles> findAllRoles() {

        return rd.bfindAllRoles();
    }
    //用于下拉框的查询
    @RequestMapping("boxfindAllRoles.do")
    public List<Roles> boxfindAllRoles(){
        return  rd.boxfindAllRoles();

    }

    //添加角色
    @RequestMapping("addRoles.do")
    @ResponseBody
    public int addRoles(Roles roles) {
        return rs.addRoles(roles);
    }

    //删除角色
    @RequestMapping("deleteRoles.do")
    @ResponseBody
    public String deleteRoles(@RequestBody ArrayList<Integer> data) {

        return rs.deleteRoles(data);
    }

    //修改角色
    @RequestMapping("updaterole.do")
    @ResponseBody
    public int updaterole(Roles roles) {
        return rs.updaterole(roles);
    }
    //搜索
    @RequestMapping("search.do")
    @ResponseBody
    public List<Roles> searchRolesBylike(String type,String key){
        return rs.searchRolesBylike(type,key);
    }

}
