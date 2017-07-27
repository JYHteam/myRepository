
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
<div id="resource_window" title="资源分配" class="easyui-window"
     style="width:500px;height:700px;" data-options="closed:true,modal:true">
    <div id="resource_tree" class="easyui-treegrid" data-options="url:'findAllResources.do',
				method: 'get',
				rownumbers: true,
				showFooter: true,
				idField: 'id',
				singleSelect:false,
                treeField: 'name',
                columns: [[
                    {field: 'id',title:'id',checkbox:true,width:100},
                    {field: 'name', title: '资源目录', width: 160},
                    {field: 'path', title: '资源路径', width: 120}
                ]]
				<%--treeField: 'region'--%>">


    </div>
    <div style="display: flex; justify-content:center">
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
                        fenResource();
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
                pageSize:size,
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


    //分配资源
   function fenResource() {
        var role= $("#mytable").datagrid("getSelected");
        //判断是否选择好账号,并显示原来的资源
        if (role) {
            $.get("findResourceByRole.do",{roleId:role.id},function (d) {
                alert("角色资源"+d);

                var datas= JSON.parse(d);
                $("#resource_window").window("open");
                for(var i=0;i<datas.length;i++){
                    var node= $("#resource_tree").treegrid("find",datas[i].id);
                    var node1 = JSON.stringify(node);
                    $("#resource_tree").treegrid("check",node.id);
                }

            })
            $("#resource_window").window({
                onClose:function(){
                    $("#resource_tree").treegrid("reload");
                }
            })

        }else {
            $.messager.alert("系统提示", "请选择需要分配资源的账号");
        }
    }

    function dofenp() {
        //获取选择的角色
        var role = $("#mytable").datagrid("getSelected");
        //获取用户选择的角色
        var data = $("#resource_tree").treegrid("getChecked");
        var node1 = JSON.stringify(data);
        alert(node1);
        var as = [role.id];
        for (var i = 0; i < data.length; i++) {
            as[i + 1] = data[i].id;
        }
        //将数组转化为json字符串
        var arrjson = JSON.stringify(as);
        alert(arrjson)
        $.ajax({
            url: "fenpResource.do",
            method: "post",
            data: arrjson,
            contentType: "application/json",
            //服务端返回的数据
            success: function (d) {
                alert(d);
                if(d==1){
                    $.messager.alert("提示","恭喜您分配资源权限成功");
                    load2(1,5);
                   // $("#resource_tree").treegrid("reload");
                    $("#resource_window").window("close");
                }else{
                    $.messager.alert("提示","对不起本次操作失败");
                }
            }
        });
    }
</script>

