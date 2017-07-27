package com.qianfeng.bean;

import java.io.Serializable;


public class Orderdetail implements Serializable{
  private int id;
  private String  product_id;
  private String order_id;
  private String product_name;
  private float product_price;
  private int product_number;
  private String product_remark;

    public Orderdetail() {
    }

    public Orderdetail(int id, String product_id, String order_id, String product_name, float product_price, int product_number, String product_remark) {
        this.id = id;
        this.product_id = product_id;
        this.order_id = order_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_number = product_number;
        this.product_remark = product_remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    public String getProduct_remark() {
        return product_remark;
    }

    public void setProduct_remark(String product_remark) {
        this.product_remark = product_remark;
    }
}
