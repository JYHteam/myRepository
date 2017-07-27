package com.qianfeng.controller;

import com.qianfeng.common.Cart;
import com.qianfeng.service.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
}
