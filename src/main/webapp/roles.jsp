
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="mytable"></div>
<!-- 角色搜索弹框 -->
<%--<div class="easyui-panel" title="搜索" style="width:100%;height:100px">
    <input class="easyui-searchbox" data-options="menu:'#choice',prompt:'输入搜索关键字',searcher:doSearch"/>
    <div id="choice">
        <div data-options="name:'account'">账号</div>
        <div data-options="name:'role'">角色</div>
    </div>
</div>--%>
<!-- 角色弹框 -->
<div id="roles_window" class="easyui-window"
     style="width:300px;height:400px;" data-options="closed:true,modal:true">
    <%--<ul id="roles_tree" class="easyui-tree"
        data-options="url:'findAllRoles.do',checkbox:true">
    </ul>--%>
    <div>
        <a class="easyui-linkbutton" href="javascript:dofenp()">分配</a>
    </div>
</div>
<script type="text/javascript">
    function init() {
        $("#mytable").datagrid({
            title : "角色管理",
            pagination:true,
            columns: [[
                {
                    field: "id",
                    title: "Id",
                    checkbox: true
                },
                {
                    field: "roles_name",
                    title: "角色",
                    width: 100
                    /*formatter:function (value,row,index) {
                        return row.users.account;
                    }*/
                }


            ]],
            toolbar: [

                {
                    text: "删除",
                    iconCls: "icon-remove",
                    handler: function () {
                        //remove();
                    }
                },
                {
                    text: "分配资源权限",
                    iconCls: "icon-search",
                    handler: function () {
                       // fenp();
                    }
                }
            ]
        });
        load2(1,5);
    }

    //加载数据
   function load2(p,size) {
        //获取服务端的json数据
        $.getJSON("findAllRoles.do", {
            page:p,
            pagesize:size
        },function(d) {
           var jsons= JSON.stringify(d.allroles)
           // alert(jsons)
            var datas=d.allroles;
            //填充数据
            $("#mytable").datagrid("loadData", datas);
            var pager=$("#mytable").datagrid("getPager");
            pager.pagination({
                total:d.total,
                pageSize:5,
                pageList:[5,10],
                pageNumber:p,
                onSelectPage:function (page,size) {
                    load2(page,size);
                },
                beforePageText : '第',
                afterPageText : '页,共{pages}页',
                displayMsg : '共{total}条数据'
            });

        });
    }
    $(init);
   /* //删除
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
    }*/
    //分配角色
   /* function fenp() {
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

