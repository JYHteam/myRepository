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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServices {

        @Resource
        private OrdersDao od;

    /**
     * 前台创建订单
     * @param cart
     */
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

    /**
     * 分页查询所有订单
     * @param page
     * @param pagesize
     * @return
     */
        public Map<String,Object> findAllBorders(int page,int pagesize){
            int start=(page-1)*pagesize;
            int total=1;

            List<Orders> allBorders = od.findAllBorders(start,pagesize);
            Map<String,Object> ordersMap=new HashMap<String, Object>();
            ordersMap.put("total",total);
            ordersMap.put("allBorders",allBorders);
            return  ordersMap;
        }

    /**
     * 根据订单ID查询订单详情
     * @param order_id
     * @return
     */
   /* public ModelAndView findOrderDetialById( String order_id){

        List<Orderdetail> orderDetial = od.findOrderDetialById(order_id);
        ModelAndView mv=new ModelAndView("borders");
        mv.addObject("orderDetial",orderDetial);
        return mv;

    }*/
    public List<Orderdetail> findOrderDetialById( String order_id){
        return od.findOrderDetialById(order_id);
    }

    public int sureOrder(Orders orders){
        int msg=1;
        try {
            od.sureOrders(orders);
        } catch (Exception e) {
            e.printStackTrace();
            msg=-1;
        }
       return msg;
    }
}
