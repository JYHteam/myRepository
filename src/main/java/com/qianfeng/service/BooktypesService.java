package com.qianfeng.service;

import com.qianfeng.bean.BookTypes;
import com.qianfeng.dao.BooktypesDao;
import com.qianfeng.utils.PrimaryKey;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BooktypesService {
    @Resource
    private BooktypesDao btd;
    public Map<String,Object>findAllBookTypes(int page,int pagesize){
        int start=(page-1)*pagesize;
        int total = btd.BookTypesCount();
        List<BookTypes> allBookTypes = btd.findAllBookTypes(start,pagesize);
        Map<String,Object> bookTypesMap=new HashMap<String, Object>();
        bookTypesMap.put("total",total);
        bookTypesMap.put("allBookType",allBookTypes);
        return bookTypesMap;
    }
    public List<BookTypes> pfindAllBookTypes(){

        return btd.pfindAllBookTypes();
    }

    public int addBookType(BookTypes bookTypes){
        int row=1;
        BookTypes bookTypes1=new BookTypes();
        bookTypes1.setId(PrimaryKey.makePrimaryKey());
        bookTypes1.setBooks_type(bookTypes.getBooks_type());
        try {
            btd.addBookType(bookTypes1);
        }catch (Exception e){
            row=-1;
         e.printStackTrace();
        }
        return row;
    }
}
