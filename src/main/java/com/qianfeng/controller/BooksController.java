package com.qianfeng.controller;

import com.qianfeng.bean.Books;
import com.qianfeng.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class BooksController {
    @Resource
    private BooksService bs;
    @RequestMapping("addBooks.do")
    @ResponseBody
    public int addBooks(@RequestParam("book_image")MultipartFile book_image, @RequestParam Map<String,String> data){
       // System.out.println(book_image+"***"+data);
      return bs.addBooks(book_image,data);
    }
    @RequestMapping("bfindAllBooks.do")
    @ResponseBody
    public Map<String, Object> findAllBooks(int page,int pagesize){

        return bs.bfindAllBooks(page,pagesize);
    }
    @RequestMapping("findAllBooksById.do")
    @ResponseBody
    public Books findAllBooksById(String id){
        return bs.findAllBooksById(id);
    }

}
