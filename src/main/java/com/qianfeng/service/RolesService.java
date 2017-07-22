package com.qianfeng.service;

import com.qianfeng.bean.Roles;
import com.qianfeng.dao.RolesDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
@Service
public class RolesService {
    @Resource
    private RolesDao rd;


    public Map<String,Object> findAllRoles(int page,int pagesize){
        int start=(page-1)*pagesize;
        List<Roles> allRoles = rd.findAllRoles(start, pagesize);
       // System.out.print("duixiang"+allRoles);
        int total= rd.countRoles();
        //System.out.print("duixiang"+total);
        Map<String,Object> rolesMap=new HashMap<String, Object>();
        rolesMap.put("total",total);
        rolesMap.put("allroles",allRoles);
        return rolesMap;
    }

    //角色分配
    public void fenp(ArrayList<Integer> data) {
        //获取所选的用户
        int userid = data.get(0);
        data.remove(0);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", userid);
        map.put("role_id", data);
        //删除原先角色
        rd.deleteOldRoles(userid);
        //分配新角色
        rd.fenp(map);
    }
}
