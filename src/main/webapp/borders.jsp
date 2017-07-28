
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="order_tree"></div>
<div id="look_window" >

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
                    field:"deliveryAddress",
                    title:"收货人名称",
                    width:100,
                    formatter: function(value,row,index){
                        if (row){
                            return row['deliveryAddress']['realname'];
                        } else {
                            return value;
                        }
                    }
                },
               /* {
                    field:"users_account",
                    title:"订单总额",
                    width:100
                },*/
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
                    width:100
                },
                {
                    field:"orderset_status",
                    title:"订单状态",
                    width:100
                },
               /* {
                    field:"users_account",
                    title:"支付状态",
                    width:100
                },*/
                {
                    field:"orderlogistics_status",
                    title:"物流状态",
                    width:100,
                    formatter: function(value,row,index){
                            if (row){
                                return row.orderLogistics.orderlogistics_status;
                            } else {
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
                    handler:function () {updateUsers();}
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

                    load1(page,pagesize);
                },
                beforePageText:'第',
                afterPageText:'页  共{pages}页',
                displayMsg:'共 {total} 条记录',

            });
        });
    }
    $(init);
</script>
