package com.qianfeng.service;

import com.qianfeng.bean.Roles;
import com.qianfeng.dao.RolesDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RolesService {
    @Resource
    private RolesDao rd;

    //填充数据
    public Map<String, Object> findAllRoles(int page, int pagesize) {
        try {
            //以start开始显示
            int start = (page - 1) * pagesize;
            //以start开始显示pagesize条数据
            List<Roles> allRoles = rd.findAllRoles(start, pagesize);

            //一共有total条数据
            int total = rd.countRoles();
            Map<String, Object> rolesMap = new HashMap<String, Object>();

            rolesMap.put("start",start);
            rolesMap.put("total", total);
            rolesMap.put("allroles", allRoles);
            return rolesMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //添加角色
    public int addRoles(Roles roles) {
    //  int xhr= rd.countRoles();
        int xhr = -1;
        try {
            Map<String, String> map = rd.isfindroles(roles);
            System.out.println("fffff" + map);
            if (map != null) {
                xhr = 0;
            }
            if (map == null) {

                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("roles_name", roles.getRoles_name());
                map1.put("roles_status", roles.getRoles_status());
                rd.addRoles(map1);
                xhr = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xhr;
    }

    //删除
    public String deleteRoles(ArrayList<Integer> data) {
        try {
            rd.deleteRoles(data);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "删除失败";
    }
    //修改

    public int updaterole(Roles roles) {
        int msg=1;
        try {
            System.out.println(roles);
            rd.updaterole(roles);

        } catch (Exception e) {
           msg=-1;
        }
        return  msg;
    }

    //搜索
    public List<Roles> searchRolesBylike(String type, String key) {
        try {
            Map<String, String> data = new HashMap<String, String>();
            data.put("type", type);
            data.put("key", "%" + key + "%");
            return rd.searchRolesBylike(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
