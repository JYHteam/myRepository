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
  private String product_marque;
  private String product_mode_desc;
  private String product_mode_params;
  private float discount_rate;
  private  float discount_amount;
  private int number;
  private  float subtotal;
  private String remark;

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

    public String getProduct_marque() {
        return product_marque;
    }

    public void setProduct_marque(String product_marque) {
        this.product_marque = product_marque;
    }

    public String getProduct_mode_desc() {
        return product_mode_desc;
    }

    public void setProduct_mode_desc(String product_mode_desc) {
        this.product_mode_desc = product_mode_desc;
    }

    public String getProduct_mode_params() {
        return product_mode_params;
    }

    public void setProduct_mode_params(String product_mode_params) {
        this.product_mode_params = product_mode_params;
    }

    public float getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(float discount_rate) {
        this.discount_rate = discount_rate;
    }

    public float getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(float discount_amount) {
        this.discount_amount = discount_amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
