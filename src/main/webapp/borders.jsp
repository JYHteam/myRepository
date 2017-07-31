<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="order_tree"></div>
<div id="look_window" class="easyui-window" title="订单详情" data-options="iconCls:'icon-save',modal:true,closed:true"  style="width:100%;height:100%">
    <div>
        <button type="button" class="btn btn-warning" onclick="sureOrder()">确定订单</button>
    </div>
    <div class="col-md-12">
        <table class="table  table-bordered table-hover">
            <caption>商品信息</caption>
            <thead>
            <tr class="success">
                <th>商品编号</th>
                <th>商品名称</th>
                <th>成交价</th>
                <th>数量</th>
                <th>小计</th>
            </tr>
            </thead>
            <tbody id="myTable">


            </tbody>
        </table>

    </div>
    <div class="col-md-12">

    </div>
</div>
<script type="text/javascript">
    function  init() {
        $("#order_tree").datagrid({
            title : "订单管理",
            pagination:true,
            rownumbers:true,
            columns:[[
                {
                    field:"id",
                    title:"序号",
                    checkbox:true,
                    width:80
                },
                {
                    field:"order_no",
                    title:"订单编号",
                    width:100
                },
                {
                    field:"members",
                    title:"会员名",
                    width:100,
                    formatter: function(value,row,index){
                        if (row.members){
                            return row['members']['member_nickname'];
                        } else {
                            return value;
                        }
                    }
                },
               {
                    field:"realname",
                    title:"收货人名称",
                    width:100,
                    formatter: function(value,row,index){
                        if (row){
                            return row.deliveryAddress.realname;
                        } else {
                            return value;
                        }
                    }
                },
                {
                    field:"order_time",
                    title:"下单日期",
                    width:100
                },
                {
                    field:"logistics_type",
                    title:"物流类型",
                    width:100,
                    formatter: function(value,row,index){
                        if (row){
                            return row.orderLogistics.logistics_type;
                        } else {
                            return value;
                        }
                    }
                }
                ,
                {
                    field:"pay_channel",
                    title:"支付方式",
                    width:100,
                    formatter: function(value,row,index){
                        if (row.pay_channel==0){
                            return "支付宝付款";
                        } else if(row.pay_channel==1){
                            return '微信付款';
                        }else if(row.pay_channel==2) {
                            return '网银支付';
                        }else {
                            return value;
                        }
                    }
                },
                {
                    field:"order_status",
                    title:"订单状态",
                    width:100,
                     formatter: function(value,row,index){
                  if (row.order_status==0){
                return "未确认";
                      } else if(row.order_status==1){
                return '已确认';
                      }else {
                return value;
                }
        }
                },
                {
                    field:"orderlogistics_status",
                    title:"物流状态",
                    width:100,
                    formatter: function(value,row,index){
                        if (row.orderLogistics.orderlogistics_status==0){
                            return '已发货';
                        }
                        else if(row.orderLogistics.orderlogistics_status==1){
                            return '未发货';
                        }
                        else {
                            return value;
                        }
                    }
                }
            ]],
            toolbar:[
                {
                    text:"修改",
                    iconCls:"icon-add",
                    handler:function () {addUsers();}
                },
                {
                    text:"删除",
                    iconCls:"icon-remove",
                    handler:function () {removeUsersByStatus();}
                },
                {
                    text:"查看",
                    iconCls:"icon-edit",
                    handler:function () {lookOeders();}
                },
                {
                    text:"配送状态",
                    iconCls:"icon-edit",
                    handler:function () {updateUsers();}
                }
            ]
        })
        load2(1,10);
    }
    //数据加载
    function load2(page,pagesize) {
        $.getJSON("findAllBorders.do",{
            page:page,
            pagesize:pagesize
        },function (d) {
            //解析json字符串
            var json= JSON.stringify(d.allBorders);
            var datas=d.allBorders;
            //填充数据
            $("#order_tree").datagrid("loadData",datas);
            //获取分页组件
            var pager= $("#order_tree").datagrid("getPager");
            pager.pagination({
                total:d.total,
                pageSize:pagesize,
                pageList:[10,20],
                pageNumber:page,
                onSelectPage:function(page,pagesize){

                    load2(page,pagesize);
                },
                beforePageText:'第',
                afterPageText:'页  共{pages}页',
                displayMsg:'共 {total} 条记录',

            });
        });
    }

    function lookOeders() {
        var data = $("#order_tree").datagrid("getSelected");
        // alert(data.id);
        $.get("findOrderDetialById.do",{order_id:data.id},function (d) {
            if(d){
               /* var stringify = JSON.stringify(d);
                alert(stringify)*/
                var data = JSON.parse(d);
                $("#look_window").window("open") ;
                var html = "";
                var total=0;
                for(var i=0;i<data.length;i++){
                    var price=parseInt(data[i].product_price);
                    var number=data[i].number;
                    //alert(price)
                    total+=(price*number);
                    html += "<tr>";
                    html +=     "<td>" + data[i].id + "</td>"
                    html +=     "<td>" + data[i].product_name + "</td>"
                    html +=     "<td>" + data[i].product_price + "</td>"
                    html +=     "<td>" + data[i].number + "</td>"
                    html +="<td>" +(price*number) + "</td>"
                    html += "</tr>";
                }
                html += "<tr>";
                html +=     "<td colspan='4'>" + '总计' + "</td>"
                html +=     "<td>" + total + "</td>"
                html += "</tr>";
                $("#myTable").html(html);
            }else
            {
                $.messager.alert("提示","请先选择要查看的订单");
            }
        })

    }
    function sureOrder() {
        var data = $("#order_tree").datagrid("getSelected");
        $.messager.confirm('提示框', '您是否确定确认该订单?', function(r){
            if (r){
                $.get("sureOrder.do",{id:data.id,order_status:1},function(d){
                    if(d==1){
                        $.messager.alert("提示框","确认订单成功");
                        load2(1,10);
                        //当添加完用户后，关闭该界面（窗口）
                        $("#look_window").window("close");
                    }
                })

            }
        });
    }
    $(init);
</script>
