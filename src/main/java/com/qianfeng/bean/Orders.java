package com.qianfeng.bean;


import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {
    private String id;
    private String order_no;
    private String product_id;
    private int product_count;
    private float order_totalprice;
    private float product_totalprice;
    private String address_id;
    private int pay_channel;
    private int order_status;
    private float freight_fee;
    private int is_bill;
    private String bill_id;
    private String order_remark;
    private int orderset_status;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date order_time;
    private String express_no;
    private Order_logistics orderLogistics;
    private Members members;
    private Delivery_address deliveryAddress;

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

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public float getFreight_fee() {
        return freight_fee;
    }

    public void setFreight_fee(float freight_fee) {
        this.freight_fee = freight_fee;
    }

    public int getIs_bill() {
        return is_bill;
    }

    public void setIs_bill(int is_bill) {
        this.is_bill = is_bill;
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    public String getOrder_remark() {
        return order_remark;
    }

    public void setOrder_remark(String order_remark) {
        this.order_remark = order_remark;
    }

    public int getOrderset_status() {
        return orderset_status;
    }

    public void setOrderset_status(int orderset_status) {
        this.orderset_status = orderset_status;
    }

    public String getExpress_no() {
        return express_no;
    }

    public void setExpress_no(String express_no) {
        this.express_no = express_no;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public Order_logistics getOrderLogistics() {
        return orderLogistics;
    }

    public void setOrderLogistics(Order_logistics orderLogistics) {
        this.orderLogistics = orderLogistics;
    }

    public Delivery_address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Delivery_address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
