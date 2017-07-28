package com.qianfeng.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class Order_logistics implements Serializable{
    private String id;
    private String express_no;
    private String consignee_realname;
    private String consignee_telphone;
    private String consignee_telphone2;
    private String consignee_address;
    private float delivery_amount;
    private float logistics_fee;
    private String logistics_type;
    private String consignee_zip;
    private int orderlogistics_status;
    private Date logistics_create_time;
    private Date logistics_settlement_time;
    private int pay_channel;
    private int reconciliation_status;
    private Date reconciliation_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpress_no() {
        return express_no;
    }

    public void setExpress_no(String express_no) {
        this.express_no = express_no;
    }

    public String getConsignee_realname() {
        return consignee_realname;
    }

    public void setConsignee_realname(String consignee_realname) {
        this.consignee_realname = consignee_realname;
    }

    public String getConsignee_telphone() {
        return consignee_telphone;
    }

    public void setConsignee_telphone(String consignee_telphone) {
        this.consignee_telphone = consignee_telphone;
    }

    public String getConsignee_telphone2() {
        return consignee_telphone2;
    }

    public void setConsignee_telphone2(String consignee_telphone2) {
        this.consignee_telphone2 = consignee_telphone2;
    }

    public String getConsignee_address() {
        return consignee_address;
    }

    public void setConsignee_address(String consignee_address) {
        this.consignee_address = consignee_address;
    }

    public float getDelivery_amount() {
        return delivery_amount;
    }

    public void setDelivery_amount(float delivery_amount) {
        this.delivery_amount = delivery_amount;
    }

    public float getLogistics_fee() {
        return logistics_fee;
    }

    public void setLogistics_fee(float logistics_fee) {
        this.logistics_fee = logistics_fee;
    }

    public String getLogistics_type() {
        return logistics_type;
    }

    public void setLogistics_type(String logistics_type) {
        this.logistics_type = logistics_type;
    }

    public String getConsignee_zip() {
        return consignee_zip;
    }

    public void setConsignee_zip(String consignee_zip) {
        this.consignee_zip = consignee_zip;
    }

    public int getOrderlogistics_status() {
        return orderlogistics_status;
    }

    public void setOrderlogistics_status(int orderlogistics_status) {
        this.orderlogistics_status = orderlogistics_status;
    }

    public Date getLogistics_create_time() {
        return logistics_create_time;
    }

    public void setLogistics_create_time(Date logistics_create_time) {
        this.logistics_create_time = logistics_create_time;
    }

    public Date getLogistics_settlement_time() {
        return logistics_settlement_time;
    }

    public void setLogistics_settlement_time(Date logistics_settlement_time) {
        this.logistics_settlement_time = logistics_settlement_time;
    }

    public int getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(int pay_channel) {
        this.pay_channel = pay_channel;
    }

    public int getReconciliation_status() {
        return reconciliation_status;
    }

    public void setReconciliation_status(int reconciliation_status) {
        this.reconciliation_status = reconciliation_status;
    }

    public Date getReconciliation_time() {
        return reconciliation_time;
    }

    public void setReconciliation_time(Date reconciliation_time) {
        this.reconciliation_time = reconciliation_time;
    }
}
