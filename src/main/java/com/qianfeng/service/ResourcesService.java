package com.qianfeng.service;

import com.qianfeng.bean.Resources;
import com.qianfeng.bean.Roles;
import com.qianfeng.bean.Users;
import com.qianfeng.dao.ResourcesDao;
import com.qianfeng.dao.RolesDao;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.management.relation.Role;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResourcesService {
    @Resource
    private ResourcesDao rd;
    @Resource
    private RolesDao rolesDao;
    /**
     * 查询所有资源，显示权限树
     * @return 返回的树形式的map集合
     */
    public Map<String,Object> findAllResources(){
        Map<String,Object> map=new HashMap();
        List<Resources> resources=  rd.findAllResources();
        map.put("rows",resources);
        return map;
    }
    /**
     * 查询所有资源，显示树
     * @return 返回的树形式的map集合
     */
    public Map<String,Object> findAllResources1(){
        Map<String,Object> map=new HashMap();
        List<Resources> resources=  rd.findAllResources1();
        map.put("rows",resources);
        return map;
    }
    /**
     * 通过登录用户角色查询资源
     * @param role_id 登录的用户的角色ID
     * @return
     */
    public Map<String,Object>  findResourcesByRole(int role_id){
        Map<String,Object> map=new HashMap();
        List<Resources> resourcesByRole = rd.findResourcesByRole(role_id);
        map.put("rows",resourcesByRole);
        return map;
    }

    /**
     * 分配权限
     * @param arrjson 要匹配的id数组
     * @return
     */
    public int fenpResources(ArrayList<Integer> arrjson){
        int x=-1;
        int role_id = arrjson.get(0);
        arrjson.remove(0);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("roles_id",role_id);
        map.put("arrjson",arrjson);
        try {
            //重新分配权限的时候先删除原来的权限
            rd.deleteResourcesByRole(role_id);
            //重新分配权限
            rd.fenpResource(map);
            x=1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
}
