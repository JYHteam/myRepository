package com.qianfeng.service;

import com.qianfeng.dao.RolesDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
@Service
public class RolesRervice {
    @Resource
    private RolesDao rd;

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
