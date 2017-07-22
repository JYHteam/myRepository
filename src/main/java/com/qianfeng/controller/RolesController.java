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
    public Map<String,Object> findAllRoles(int page, int pagesize){

       return rs.findAllRoles(page,pagesize);
    }

    //通过用户查询对应角色
    @RequestMapping("findRolesByUser")
    public List<Roles> findRolesByUser(HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        return rd.findRolesByUser(user.getId());
    }

   /* //通过角色查询对应的所有用户
    @RequestMapping("findUsersByRoles")
    public List<Users> findUsersByRoles(HttpSession session) {
        Roles role = (Roles) session.getAttribute("role");
        return rd.findUsersByRoles(role.getId());
    }*/

    //删除角色
    @RequestMapping("removeOldRoles")
    public void deleteOldRoles(int id) {
        rd.deleteOldRoles(id);
    }

    //分配角色(增+改)
    @RequestMapping("fenp")
    public String fenp(@RequestBody ArrayList<Integer> data) {
        return "rd.fenp(data)";
    }

}
