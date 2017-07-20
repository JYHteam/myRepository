<%--
  Created by IntelliJ IDEA.
  User: huangguan
  Date: 2017/7/20 0020
  Time: 下午 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="user_main"></div>
<%--添加用户--%>
<div id="user_window" class="easyui_window" style="width: 400px;height: 400px" data-options="closed:true;modal:true">
<div style="height: 100%;width: 100%;display: flex;justify-content: center;align-items:center;background-color: greenyellow;">
    <form id="user_form" action="addUsers.do" method="post">
        <input type="hidden" name="id">
       账&nbsp;&nbsp;号&nbsp;：&nbsp; <input type="text" name="users_account"><br/>
        密&nbsp;&nbsp;码&nbsp;：&nbsp;<input type="text" name="users_pwd"><br/>
        <br/>
        <div>
           <a class="easyui-linkbutton" href="javascript:saveUsers()">保存</a>
       </div>
    </form>
</div>
</div>
<%--修改用户--%>
<div id="users_window" class="easyui_window" style="width: 400px;height: 400px" data-options="closed:true;modal:true">
    <div style="height: 100%;width: 100%;display: flex;justify-content: center;align-items:center;background-color: greenyellow;">
        <form id="users_form" action="updateUsers.do" method="post">
            <input type="hidden" name="id">
            账&nbsp;&nbsp;号&nbsp;：&nbsp; <input type="text" name="users_account"><br/>
            密&nbsp;&nbsp;码&nbsp;：&nbsp;<input type="text" name="users_pwd"><br/>
            <br/>
            <div>
                <a class="easyui-linkbutton" href="javascript:saveUser()">保存</a>
            </div>
        </form>
    </div>
</div>
    <script type="text/javascript">
        function init() {
            $("#user_main").datagrid({
                title:"用户管理",
               pagination:true,
                columns:[[
                    {field:"id",title:"序号",checkbox:true,width:80},
                    {field:"users_account",title:"账号",width:100},
                    {field:"users_pwd",title:"密码",width:100},
                    {field:"users_status",title:"登录状态",width:100}
                ]],
                toolbar:[
                    {text:"添加",icon_Cls:"icon_add",handler:function () {addUsers();}},
                    {text:"删除",icon_Cls:"icon_remove",handler:function () {removeUsers();}},
                    {text:"修改",icon_Cls:"icon_edit",handler:function () {updateUsers();}},
                    {text:"分配权限",icon_Cls:"icon_edit",handler:function(){fenp();}}
                ]

            });
            load1(1);
        }
        function load1(p) {
            $.getJSON("findAllUsers.do",{page:p},function (d) {
               //填充数据
                $("#user_main").datagrid("loadData",d);
                //获取分页组件
               var pager= $("#user_main").datagrid("getPager");
               pager.pagination({
                   total:4,
                   pageSize:2,
                   pageNumer:p,
                   pageList:[1,2,3],
                   onSelectPage:function(page,size){

                       load1(page);
                   }
               });
            });
        }
//        添加用户的操作
        function addUsers() {
            $("#user_form").form("clear");
            $("#user_form").form("load",{
                id:0
            });
            $("#user_window").window("open");
        }
        function saveUsers() {
            $("#user_form").form("submit",{
                success:function (xhr) {
                    if(xhr>0){
                        $.messager.alert("系统提示","成功添加用户");
                        //再添加完新用户后重新加载数据
                        load1(1);
                        //当添加完用户后，关闭该界面（窗口）
                        $("#user_windows").window("close");
                    }
                    if (xhr<0){
                        $.messager.alert("系统提示","添加用户失败");
                    }
                }
            });
        }
//        删除用户的操作，一次可以删除多条
        function removeUsers() {
            //获取选择删除的数据
           var data= $("#user_main").datagrid("getSelections");
           //把得到的数据id放入数组
           var ids=[];
           for(i=0;i<data.length;i++){
               ids[i]=data[i].id;
           }
           //把ids数组封装成json数据
            var romveUserId= JSON.stringify(ids);
            $.ajax({
                url:"removeUsers.do",
                method:"post",
                data:romveUserId,
                contentType:"application/json",
                success:function(d){
                    $.messager.alert("系统提示",d);
                    //删除完用户后，重新加载页面
                    load1(1);
                }
            });
        }
        //对用户进行修改操作
        function updateUsers() {
            var dataUsers=$("#user_main").datagrid("getSelected");
            $("#users_form").form("load",{
                id:dataUsers.id,
                user_account:dataUsers.user_account,
                user_pwd:dataUsers.user_pwd,

            });
            $("#users_window").window("open");
        }
        function saveUser() {
            $("#users_form").form("submit",{
                success:function (xhr) {
                    if(xhr>0){
                        $.messager.alert("系统提示","修改用户成功");
                        //再修改完用户数据后重新加载数据
                        load1(1);
                        //当添加完用户后，关闭该界面（窗口）
                        $("#users_windows").window("close");
                    }
                    if (xhr<0){
                        $.messager.alert("系统提示","用户修改失败");
                    }
                }
            });
        }
      init();
    </script>

