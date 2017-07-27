package com.qianfeng.bean;

import java.io.Serializable;


public class BookTypes implements Serializable {
    private String id;
    private String books_type;

    public BookTypes() {
    }

    public BookTypes(String id, String books_type) {
        this.id = id;
        this.books_type = books_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBooks_type() {
        return books_type;
    }

    public void setBooks_type(String books_type) {
        this.books_type = books_type;
    }
}
