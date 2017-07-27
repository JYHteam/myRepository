package com.qianfeng.bean;


import java.io.Serializable;

public class Orders implements Serializable {
    private String id;
    private String order_no;
    private int product_count;
    private float order_totalprice;
    private float product_totalprice;
    private String address_id;
    private int pay_channel;
    private int order_status;

    public Orders() {
    }

    public Orders(String id, String order_no, int product_count, float order_totalprice, float product_totalprice, String address_id, int pay_channel, int order_status) {
        this.id = id;
        this.order_no = order_no;
        this.product_count = product_count;
        this.order_totalprice = order_totalprice;
        this.product_totalprice = product_totalprice;
        this.address_id = address_id;
        this.pay_channel = pay_channel;
        this.order_status = order_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public float getOrder_totalprice() {
        return order_totalprice;
    }

    public void setOrder_totalprice(float order_totalprice) {
        this.order_totalprice = order_totalprice;
    }

    public float getProduct_totalprice() {
        return product_totalprice;
    }

    public void setProduct_totalprice(float product_totalprice) {
        this.product_totalprice = product_totalprice;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public int getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(int pay_channel) {
        this.pay_channel = pay_channel;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
}
