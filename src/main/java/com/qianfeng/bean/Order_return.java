package com.qianfeng.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Order_return implements Serializable{
    private String id;//退货订单自动编号
    private String return_no;//退货编号
    private String express_no;//物流单号
    private Orders orders;//订单类，对应订单编号order_no
    private Order_logistics orderlog;//订单物流类，对应着卖家的姓名，电话，地址，运费，物流方式等信息consignee_realname，consignee_telphone，consignee_telphone2，consignee_address，logistics_fee，logistics_type
    private String returns_type;//退货类型
    private String return_status;//退火状态
    private float returns_amount;//退款金额
    private String return_submit_time;//退货申请时间
    private String handling_time;//退货处理时间
    private String return_reason;//退货理由
    private Members member;//会员信息表类，对应会员信息

    public Order_return() {}

    public Order_return(String id, String return_no, String express_no, String returns_type, String return_status, float returns_amount, String return_submit_time, String handling_time, String return_reason) {
        this.id = id;
        this.return_no = return_no;
        this.express_no = express_no;
        this.returns_type = returns_type;
        this.return_status = return_status;
        this.returns_amount = returns_amount;
        this.return_submit_time = return_submit_time;
        this.handling_time = handling_time;
        this.return_reason = return_reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReturn_no() {
        return return_no;
    }

    public void setReturn_no(String return_no) {
        this.return_no = return_no;
    }

    public String getExpress_no() {
        return express_no;
    }

    public void setExpress_no(String express_no) {
        this.express_no = express_no;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Order_logistics getOrderlog() {
        return orderlog;
    }

    public void setOrderlog(Order_logistics orderlog) {
        this.orderlog = orderlog;
    }

    public String getReturns_type() {
        return returns_type;
    }

    public void setReturns_type(String returns_type) {
        this.returns_type = returns_type;
    }

    public String getReturn_status() {
        return return_status;
    }

    public void setReturn_status(String return_status) {
        this.return_status = return_status;
    }

    public float getReturns_amount() {
        return returns_amount;
    }

    public void setReturns_amount(float returns_amount) {
        this.returns_amount = returns_amount;
    }

    public String getReturn_submit_time() {
        return return_submit_time;
    }

    public void setReturn_submit_time(String return_submit_time) {
        this.return_submit_time = return_submit_time;
    }

    public String getHandling_time() {
        return handling_time;
    }

    public void setHandling_time(String handling_time) {
        this.handling_time = handling_time;
    }

    public String getReturn_reason() {
        return return_reason;
    }

    public void setReturn_reason(String return_reason) {
        this.return_reason = return_reason;
    }

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }
}
