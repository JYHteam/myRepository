<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/20 0020
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
</head>
<body>
<%--<!-- 角色搜索弹框 -->
<div class="easyui-panel" title="搜索" style="width:100%;height:100px">
    <input class="easyui-searchbox" data-options="menu:'#choice',prompt:'输入搜索关键字',searcher:doSearch"/>
    <div id="choice">
        <div data-options="name:'account'">账号</div>
        <div data-options="name:'role'">角色</div>
    </div>
</div>--%>
<!-- 角色弹框 -->
<div id="roles_window" class="easyui-window"
     style="width:300px;height:400px;" data-options="closed:true,modal:true">
    <ul id="roles_tree" class="easyui-tree"
        data-options="url:'findAllRoles.do',checkbox:true">
    </ul>
    <div>
        <a class="easyui-linkbutton" href="javascript:dofenp()">分配</a>
    </div>
</div>
<script type="text/javascript">
    function init() {
        $("#roles").datagrid({

            columns: [[
                {
                    filed: "id",
                    title: "id",
                    checkbox: ture
                },
                {
                    filed: "account",
                    title: "账号",
                    width: 100
                },
                {
                    field: "pwd",
                    title: "密码",
                    width: 100
                },
                {
                    field:"roles",
                    title:"角色",
                    width:100

                }

            ]],
            toolbar: [

                {
                    text: "删除",
                    iconCls: "icon-remove",
                    handler: function () {
                        remove();
                    }
                },
                {
                    text: "分配角色",
                    iconCls: "icon-search",
                    handler: function () {
                        fenp();
                    }
                }
            ]
        });
        load2(1);
    }
    //加载数据
    function load2(p) {
        //获取服务端的json数据
        $.getJSON("findAllRoles.do", function(d) {
            //填充数据
            $("#roles").datagrid("loadData", d);

        });
    }
    /*//删除
    function remove() {
        var data = $("#roles").datagrid("getSelections");
        var ids = [];
        for (var i = 0; i < data.length; i++) {
            ids[i] = data[i].id;
        }
        var x = JSON.stringify(ids);
        //发送json数据
        $.ajax({
            url: "removeuser.do",
            method: "post",
            data: x,
            contentType: "application/json",
            success: function (d) {
                load2(1);
            }
        });
    }
    //分配角色
    function fenp() {
        var user = $("#roles").datagrid("getSelected");
        //判断是否选择好账号
        if (user) {
            $("roles_window").window("open");
        } else {
            $.message.alert("系统提示", "请选择需要分配角色的账号");
        }
    }
    function dofenp() {
        //获取选择的用户
        var user = $("#roles").datagrid("getSelected");
        //获取用户选择的角色
        var data = $("#roles_tree").tree("getChecked");
        var as = [user.id];
        for (i = 0; i < data.length; i++) {
            as[i + 1] = data[i].id;
        }
        //将数组转化为json字符串
        var json = JSON.stringify(as);
        $.ajax({
            url: "fenp.do",
            method: "post",
            data: json,
            contentType: "application/json",
            //服务端返回的数据
            success: function (d) {
                //刷新页面重新加载用户的角色
                window.location.reload();
                alert(d);
            }
        });
    }*/
</script>
</body>
</html>