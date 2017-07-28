package com.qianfeng.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class Delivery_address implements Serializable {
  private String id;
  private String member_id;
  private String Order_no;
  private String order_logistics_id;
  private String realname;
  private String delivery_phone;
  private String delivery_phone2;
  private String province;
  private String  city;
  private String area;
  private String street;
  private String zip;
  private int is_defult_address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getOrder_no() {
        return Order_no;
    }

    public void setOrder_no(String order_no) {
        Order_no = order_no;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDelivery_phone() {
        return delivery_phone;
    }

    public void setDelivery_phone(String delivery_phone) {
        this.delivery_phone = delivery_phone;
    }

    public String getDelivery_phone2() {
        return delivery_phone2;
    }

    public void setDelivery_phone2(String delivery_phone2) {
        this.delivery_phone2 = delivery_phone2;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getIs_defult_address() {
        return is_defult_address;
    }

    public void setIs_defult_address(int is_defult_address) {
        this.is_defult_address = is_defult_address;
    }

    public String getOrder_logistics_id() {
        return order_logistics_id;
    }

    public void setOrder_logistics_id(String order_logistics_id) {
        this.order_logistics_id = order_logistics_id;
    }
}
