package com.qianfeng.dao;

import com.qianfeng.bean.Orderdetail;
import com.qianfeng.bean.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrdersDao {
    void addOrders(Orders orders);
    void addOrderDetails(Map<String,Object> data);
    List<Orders> findAllBorders(@Param(value="start") int start, @Param(value="pagesize") int pagesize);
    //根据订单ID查询订单详情
    List<Orderdetail> findOrderDetialById(String order_id);
    void sureOrders(Orders orders);
}
