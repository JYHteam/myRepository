package com.qianfeng.controller;

import com.qianfeng.bean.BookTypes;
import com.qianfeng.dao.BooktypesDao;
import com.qianfeng.service.BooktypesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class BooktypesController {
    @Resource
    private BooktypesService bts;
    @RequestMapping("findAllBookTypes.do")
    public Map<String,Object> findAllBookTypes(int page,int pagesize){
        return bts.findAllBookTypes(page,pagesize);
    }
    @RequestMapping("pfindAllBookTypes.do")
    public List<BookTypes> findAllBookTypes(){
        return bts.pfindAllBookTypes();
    }
    @RequestMapping("addBookType.do")
    public int addBookType(BookTypes bookTypes){
        return bts.addBookType(bookTypes);
    }
}
