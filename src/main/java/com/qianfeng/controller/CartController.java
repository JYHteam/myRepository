package com.qianfeng.controller;

import com.qianfeng.bean.Books;
import com.qianfeng.common.Cart;
import com.qianfeng.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Resource
    private BooksService bs;

    @RequestMapping("findAllBooks.do")
    public String findAllBooks(HttpSession session){
        List<Books> allBooks = bs.findAllBooks();
        session.setAttribute("allBooks",allBooks);
        return  "bookslist";
    }

    /**
     * 添加购物车
     * @param book_id
     * @param session
     * @return
     */
    @RequestMapping("addCart.do")
    public String addCart(@RequestParam("book_id") String book_id, HttpSession session){
        Books allBooksById = bs.findAllBooksById(book_id);
        System.out.println(allBooksById.getId());
        Cart cart =(Cart)session.getAttribute("cart");
        if(cart==null){
            //session.setAttribute("BooksById",allBooksById);
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        cart.addCart(allBooksById);

        return "cartlist" ;
    }

}
