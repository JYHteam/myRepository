package com.qianfeng.service;

import com.qianfeng.bean.Books;
import com.qianfeng.bean.Orderdetail;
import com.qianfeng.bean.Orders;
import com.qianfeng.common.Cart;
import com.qianfeng.dao.OrdersDao;
import com.qianfeng.utils.PrimaryKey;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrdersServices {

        @Resource
        private OrdersDao od;
        @Transactional
        public void createOders(Cart cart){
            //添加订单
            Orders orders=new Orders();
            orders.setId(PrimaryKey.makePrimaryKey());
            String order_no =""+System.currentTimeMillis();
            orders.setOrder_no(order_no);
            orders.setOrder_totalprice(cart.total());
            od.addOrders(orders);
            //添加订单详情
            Orderdetail orderdetail=new Orderdetail();

            Collection<Books> books = cart.showCart();
            Map<String,Object> data=new HashMap<String, Object>();

            data.put("order_id",orders.getId());
            data.put("list",books);
            od.addOrderDetails(data);
        }

}
