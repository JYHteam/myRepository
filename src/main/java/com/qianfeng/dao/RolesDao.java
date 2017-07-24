package com.qianfeng.dao;

import com.qianfeng.bean.Roles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
@Repository
public interface RolesDao {
    //查询显示所有的角色
    List<Roles> findAllRoles(@Param(value="start") int start,@Param(value="pagesize") int pagesize);

    int countRoles();



    //通过查询角色显示对应的用户
    List<Roles> findUsersByRoles(int roles_id);

    //删除
    void deleteOldRoles(int user_id);

    // 分配
    void fenp(Map<String, Object> data);
}