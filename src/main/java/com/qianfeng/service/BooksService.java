package com.qianfeng.service;

import com.qianfeng.bean.Books;
import com.qianfeng.dao.BooksDao;
import com.qianfeng.dao.BooktypesDao;
import com.qianfeng.utils.PrimaryKey;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BooksService {
    @Resource
    private BooksDao bd;

    public int addBooks(final MultipartFile book_image, Map<String, String> data) {
        int msg = 1;
        final String filename = book_image.getOriginalFilename();
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        book_image.transferTo(new File("d:/a4/" + filename));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            Books books = new Books(PrimaryKey.makePrimaryKey(), data.get("book_name"), data.get("book_introduce"), filename, Float.parseFloat(data.get("book_price")), Integer.parseInt(data.get("book_count")), data.get("book_typeid"));
            bd.addBooks(books);
        } catch (Exception e) {
            e.printStackTrace();
            msg = -1;
        }
        return msg;
    }

    //显示书籍列表
    public List<Books> findAllBooks() {
        return bd.findAllBooks();
    }

    //后台分页显示
    public Map<String, Object> bfindAllBooks(int page, int pagesize) {
        int start = (page - 1) * pagesize;
        System.out.println(page + "***" + pagesize);
        int total = bd.BooksCount();
        List<Books> books = bd.bfindAllBooks(start, pagesize);
        Map<String, Object> booksMap = new HashMap<String, Object>();
        booksMap.put("total", total);
        booksMap.put("books", books);
        return booksMap;

    }

    public Books findAllBooksById(String id) {
        return bd.findAllBooksById(id);
    }


    //删除书籍
    public int deleteBooks(ArrayList<String> dbook) {
        int x = -1;
        try {
            bd.deleteBooks(dbook);
            x = 1;
        } catch (Exception e) {
            x = -1;
        }

        return x;
    }
    //修改书籍
    public int updateBook(final MultipartFile book_image, Map<String, String> datas) {
        int msg = 1;
        final String filename = book_image.getOriginalFilename();
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        book_image.transferTo(new File("d:/a4/" + filename));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            Books books = new Books(PrimaryKey.makePrimaryKey(), datas.get("book_name"), datas.get("book_introduce"), filename, Float.parseFloat(datas.get("book_price")), Integer.parseInt(datas.get("book_count")), datas.get("book_typeid"));
            bd.updateBooks(books);
        } catch (Exception e) {
            e.printStackTrace();
            msg = -1;
        }
        return msg;
    }
}