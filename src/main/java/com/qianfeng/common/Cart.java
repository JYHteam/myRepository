package com.qianfeng.common;

import com.qianfeng.bean.Books;
import com.qianfeng.dao.BooksDao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//购物车类
public class Cart {
    //存放购买的书籍
    Map<String,Books> CartMap=new HashMap<String, Books>();
    //添加到购物车
    public void addCart(Books books){
       // System.out.println("要购买的"+books.getId());
        //购物车中不存在此书
        if(!CartMap.containsKey(books.getId())){
            books.setCart_count(books.getCart_count()+1);
            CartMap.put(books.getId(),books);
        }else{
            //购物车中存在该书
            Books books1 = CartMap.get(books.getId());
            books1.setCart_count(books1.getCart_count()+1);
        }
    }

    public Collection<Books> showCart(){
        //System.out.println("购物车的书籍"+CartMap.values());
        return CartMap.values();
    }

    /**
     * 计算购物车的总价格
     * @return
     */
    public float total(){
        float zj=0;
        Collection<Books> bs = CartMap.values();
        for(Books bk:bs){
             zj =zj+bk.getCart_count() * bk.getBook_price();
        }
        return zj;
    }
}
