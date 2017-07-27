package com.qianfeng.dao;

import com.qianfeng.bean.Roles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
@Repository
public interface RolesDao {
    //查询显示所有的角色
    List<Roles> findAllRoles(@Param(value = "start") int start, @Param(value = "pagesize") int pagesize);

    int countRoles();

    //用于下拉框的查询
    List<Roles> boxfindAllRoles();

    //添加角色
    void addRoles(Map<String, Object> map);

    //添加用户时验证数据库是否存在
    Map<String, String> isfindroles(Roles roles);

    //删除
    void deleteRoles(ArrayList<Integer> data);

    //修改
    void updaterole(Roles roles);

    //模糊搜索
    List<Roles> searchRolesBylike(Map<String, String> data);
}