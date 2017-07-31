<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/29 0029
  Time: 下午 02:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="order_return"></div>
<script>
    function init() {
        $("#order_return").datagrid({
            title:"退货订单处理",
            pagination:true,
            columns:[[
                {field:"id",title:"退货订单序号",checkbox:true,width:80},
                {field:"order_no",title:"退货订单号",width:100},
                {field:"member",title:"会员名",width:100,
                formatter:function (value,row,index) {
                    if (row.member){
                        return row['member']['member_nickname'];
                    }else{
                        return value;
                    }
                }},
                {field:"orders",title:"下单时间",width:150,
                    formatter:function (value,row,index) {
                        if(row.orders){
                            return row['orders']['Oreder_time'];
                        }else {
                            return value;
                        }

                    }},
                {field:"return_type",title:"退货类型",width:100},
                {field:"return_submit_time",title:"退货申请时间",width:150},
                {field:"return_status",title:"退货状态",width:100}

            ]]
        });
    }
    function load1() {

    }

</script>