package com.qianfeng.dao;

import com.qianfeng.bean.BookTypes;
import com.qianfeng.bean.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface BooksDao {
    @CacheEvict(value = {"findAllBooks"},allEntries = true)//重建缓存
    @Cacheable("findAllBooks")//把该方法返回的数据缓存到redis
    List<Books> findAllBooks();
   /* @CacheEvict(value = {"bfindAllBooks"},allEntries = true)//重建缓存
    @Cacheable("bfindAllBooks")*/
    List<Books> bfindAllBooks(@Param(value="start") int start, @Param(value="pagesize") int pagesize);
    Books findAllBooksById(String id);
    int BooksCount();
    void addBooks(Books books);


    //删除书籍
    int deleteBooks(ArrayList<String> dbook);
    //修改书籍
    void updateBooks(Books books);
}
