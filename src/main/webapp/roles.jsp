<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 角色搜索弹框 -->
<div class="easyui-panel" title="搜索" style="width:100%;height:100px">
    <input class="easyui-searchbox" data-options="menu:'#choice',prompt:'输入搜索关键字',searcher:doSearch"/>
    <div id="choice">
        <div data-options="name:'roles_name'">角色</div>
    </div>
</div>

<div id="roles"></div>

<!--添加角色弹框-->
<div id="addRoles_windows" class="easyui-window"
     style="width:400px;height:500px;" data-options="closed:true,modal:true,title:'添加角色'">
    <div style="width: 100%;height:100%;display:flex;justify-content:center;align-items:center;background-color: greenyellow;">
        <form id="roles_form" action="addRoles.do" method="post">
            <input type="hidden" name="id"/>
            <input type="text" name="roles_name" placeholder="角色"><br/><br/>
            <input type="text" name="roles_status" placeholder="角色状态"><br/><br/>
            <div>
                <a class="easyui-linkbutton" href="javascript:saveRoles()">保存</a>
            </div>
        </form>
    </div>
</div>
<!--修改角色-->
<div id="Roles_windows" class="easyui-window"
     style="width:400px;height:500px;" data-options="closed:true,modal:true,title:'修改角色'">
    <div style="width: 100%;height:100%;display:flex;justify-content:center;align-items:center;background-color: greenyellow;">
        <form id="updateroles_form" action="updaterole.do" method="post">
            <input type="hidden" name="id"/>
            <input type="text" name="roles_name" placeholder="角色"><br/><br/>
            <input type="text" name="roles_status" placeholder="角色状态"><br/><br/>
            <div>
                <a class="easyui-linkbutton" href="javascript:saveUpdate()">确认修改</a>
            </div>
        </form>
    </div>
</div>

<script type="text/javascript">
    function init() {
        $("#roles").datagrid({
            title: "角色管理",
            pagination: true,
            columns: [[
                {
                    field: "id",
                    title: "序号",
                    checkbox: true
                },
                {
                    field: "roles_name",
                    title: "角色",
                    width: 100
                },
                {
                    field: "roles_status",
                    title: "状态",
                    width: 100
                }
                /*{
                 field: "users_account",
                 title: "用户",
                 width: 100,
                 formatter: function (value, row, index) {
                 return row.users.users_account;
                 }*/


            ]],
            toolbar: [
                {
                    text: "添加角色",
                    iconCls: "icon-add",
                    handler: function () {
                        addRoles();
                    }
                },
                {
                    text: "删除角色",
                    iconCls: "icon-remove",
                    handler: function () {
                        deleteRoles();
                    }
                },

                {
                    text: "修改角色",
                    iconCls: "icon-edit",
                    handler: function () {
                        update();
                    }
                }
            ]
        });
        load2(1, 5);
    }
    $(init);
    //加载数据
    function load2(p, size) {
        //获取服务端的json数据
        $.getJSON("findAllRoles.do", {
            page: p,
            pagesize: size
        }, function (d) {
            var jsons = JSON.stringify(d.allroles)
            var datas = d.allroles;
            //填充数据
            $("#roles").datagrid("loadData", datas);
            var pager = $("#roles").datagrid("getPager");
            pager.pagination({
                total: d.total,
                pageSize:size,
                pageList: [5,10,15],
                pageNumber: p,
                //页码改变时重新加载数据
                onSelectPage: function (page, size) {
                    load2(page, size);
                },
                beforePageText: '第',
                afterPageText: '页,共{pages}页',
                displayMsg: '共{total}条数据'
            });
        });
    }
    //搜索
    function doSearch(key, type) {
        $.getJSON("search.do", {type: type, key: key}, function (d) {
            if (d != null) {
                $("#roles").datagrid("loadData", d);
            } else {
                //最好指定一个错误的页面，即发生异常时跳转的页面
                $.messager.alert("系统提示", "服务器崩溃了")
            }

        });
    }
    //增加角色
    function addRoles() {
        $("#roles_form").form("clear");
        $("#roles_form").form("load", {
            id: 0
        });
        $("#addRoles_windows").window("open");
    }
    function saveRoles() {
        $("#roles_name").validatebox({
            required: true,
            validType: 'text'
        }),
        $("#roles_form").form("submit", {

            success: function (xhr) {
                if (xhr = 1) {
                    $.messager.alert("系统提示", "成功添加角色");
                    //再添加完新用户后重新加载数据
                    load2(1,5);
                    //当添加完用户后，关闭该界面（窗口）
                    $("#addRoles_windows").window("close");
                }
                if (xhr == 0) {
                    $.messager.alert("系统提示", "角色已存在，请重新添加");
                }
                if (xhr == -1) {
                    $.messager.alert("系统提示", "格式不正确，添加角色失败");
                }
            }
        });
    }

    //删除角色
    function deleteRoles() {
        var data = $("#roles").datagrid("getSelections");
      /*  if(data=[]){
            $.messager.alert("系统提示","请选择需要删除的角色");
        }*/
        var ids = [];
        for (var i = 0; i < data.length; i++) {
            ids[i] = data[i].id;
        }
        var x = JSON.stringify(ids);
        //发送json数据
        $.ajax({
            url: "deleteRoles.do",
            method: "post",
            data: x,
            contentType: "application/json",
            success: function (d) {
                $.messager.alert("系统提示",d);
                load2(1,5);
            }
        });
    }
    //修改角色
    function update() {
        var update = $("#roles").datagrid("getSelected");

        if(update){
            $("#Roles_windows").window("open");
        }else{
            $.messager.alert("系统提示","请选择需要修改的角色");
        }

       // alert(update);
        $("#updateroles_form").form("load", {
            id: update.id,
            roles_name: update.roles_name,
            roles_status: update.roles_status,

        });


    }
    function saveUpdate() {
        $("#updateroles_form").form("submit", {
            success: function (xhr) {
                //alert(xhr);
                if (xhr == 1) {
                    $.messager.alert("系统提示", "修改用户成功");
                    //再修改完用户数据后重新加载数据
                    load2(1, 5);
                    //当添加完用户后，关闭该界面（窗口）
                    $("#Roles_windows").window("close");
                }
                if (xhr == -1) {
                    $.messager.alert("系统提示", "用户修改失败");
                }
            }
        });
    }


</script>

