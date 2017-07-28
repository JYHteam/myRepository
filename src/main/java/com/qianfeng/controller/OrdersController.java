package com.qianfeng.controller;

import com.qianfeng.common.Cart;
import com.qianfeng.service.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    @RequestMapping("findAllBorders.do")
    @ResponseBody
    public Map<String,Object> findAllBorders(int page, int pagesize){
        return os.findAllBorders(page,pagesize);
    }
}
