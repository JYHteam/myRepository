package com.qianfeng.controller;

import com.qianfeng.bean.Orderdetail;
import com.qianfeng.bean.Orders;
import com.qianfeng.common.Cart;
import com.qianfeng.service.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {

    @Resource
    private OrdersServices os;

    @RequestMapping("toOders.do")
    public String toOders(HttpSession session){
        Cart cart =(Cart) session.getAttribute("cart");
        os.createOders(cart);
        return "orders";
    }

    /**
     * 后台查找所有的订单
     * @param page
     * @param pagesize
     * @return
     */
    @RequestMapping("findAllBorders.do")
    @ResponseBody
    public Map<String,Object> findAllBorders(int page, int pagesize){
        return os.findAllBorders(page,pagesize);
    }
    @RequestMapping("findOrderDetialById.do")
    @ResponseBody
    public List<Orderdetail> findOrderDetialById(@RequestParam(value ="order_id") String order_id){
        return os.findOrderDetialById(order_id);
    }
    @RequestMapping("sureOrder.do")
    @ResponseBody
    public int sureOrder(Orders orders){
        //System.out.print("*********"+order_id);
        return os.sureOrder(orders);
    }
}
