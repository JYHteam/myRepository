<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/23 0023
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="showResources"></div>
<script>
    function init() {
        $("#user_main").datagrid({
            pagination:true,
            columns:[[
                {
                    field:"id",
                    title:"序号",
                    checkbox:true,
                    width:80
                },
                {
                    field:"users_account",
                    title:"资源名字",
                    width:100
                }
            ]],
            toolbar:[
                {
                    text:"添加",
                    iconCls:"icon_add",
                    handler:function () {addUsers();}
                },
                {
                    text:"删除",
                    iconCls:"icon_remove",
                    handler:function () {removeUsersByStatus();}
                },
                {
                    text:"修改",
                    iconCls:"icon_edit",
                    handler:function () {updateUsers();}
                }
            ]

        });
        load1(1,5);
    }
    //数据加载
    function load1(page,pagesize) {
        $.getJSON("findAllResource.do",{
            page:page,
            pagesize:pagesize
        },function (d) {
            //解析json字符串
            var json= JSON.stringify(d.users);
            var datas=d.users;
            //填充数据
            $("#user_main").datagrid("loadData",datas);
            //获取分页组件
            var pager= $("#user_main").datagrid("getPager");
            pager.pagination({
                total:d.total,
                pageSize:pagesize,
                pageList:[5,10,20],
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

