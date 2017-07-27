package com.qianfeng.bean;

import java.io.Serializable;


public class Books implements Serializable {
    private String id;
    private String book_name;
    private String book_introduce;
    private String book_image;
    private float book_price;
    private int book_count;
    private String book_typeid;

    private BookTypes bookTypes;
    private int cart_count;
    public Books() {
    }

    public Books(String id, String book_name, String book_introduce, String book_image, float book_price, int book_count, String book_typeid) {
        this.id = id;
        this.book_name = book_name;
        this.book_introduce = book_introduce;
        this.book_image = book_image;
        this.book_price = book_price;
        this.book_count = book_count;
        this.book_typeid = book_typeid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_introduce() {
        return book_introduce;
    }

    public void setBook_introduce(String book_introduce) {
        this.book_introduce = book_introduce;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public float getBook_price() {
        return book_price;
    }

    public void setBook_price(float book_price) {
        this.book_price = book_price;
    }

    public int getBook_count() {
        return book_count;
    }

    public void setBook_count(int book_count) {
        this.book_count = book_count;
    }

    public String getBook_typeid() {
        return book_typeid;
    }

    public void setBook_typeid(String book_typeid) {
        this.book_typeid = book_typeid;
    }

    public BookTypes getBookTypes() {
        return bookTypes;
    }

    public void setBookTypes(BookTypes bookTypes) {
        this.bookTypes = bookTypes;
    }

    public int getCart_count() {
        return cart_count;
    }

    public void setCart_count(int cart_count) {
        this.cart_count = cart_count;
    }
}
