package com.qianfeng.dao;

import com.qianfeng.bean.Orders;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface OrdersDao {
    void addOrders(Orders orders);
    void addOrderDetails(Map<String,Object> data);
}
