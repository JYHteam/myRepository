package com.qianfeng.dao;

import com.qianfeng.bean.Resources;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface ResourcesDao {

    List<Resources> findAllResources();
    void deleteResourcesByRole(int role_id);
    List<Resources> findResourcesByRole(int role_id);
    void fenpResource(Map<String,Object> map);
}
