package com.qianfeng.dao;

import com.qianfeng.bean.BookTypes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooktypesDao {
    List<BookTypes> findAllBookTypes(@Param(value="start") int start, @Param(value="pagesize") int pagesize);
    List<BookTypes> pfindAllBookTypes();
    int BookTypesCount();
    void addBookType(BookTypes bookTypes);

}
