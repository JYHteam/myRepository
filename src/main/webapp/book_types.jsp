<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="booktypes_tree"></div>
<div id="booktypes_windows" class="easyui-window"
     style="width:400px;height:500px;" data-options="closed:true,modal:true,title:'添加书籍类型'">
    <div style="width: 100%;height:100%;display:flex;justify-content:center;align-items:center;background-color: greenyellow;">
        <form id="booktypes_form" action="addBookType.do" method="post">
            <input type="hidden" name="id"/>
            &nbsp;&nbsp; &nbsp;书&nbsp;籍&nbsp;类&nbsp;型:<input id="bookType" type="text" name="books_type" class="easyui-validatebox" data-options="required:true,validType:'books_type'"/><br/>
            <br/>
            <div>
                <a  class="easyui-linkbutton" href="javascript:saveBookType()">保存</a>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    function init() {
        $("#booktypes_tree").datagrid({
            title:"书籍类型管理",
            pagination:true,
            columns:[[
                {
                    field:"id",
                    title:"序号",
                    checkbox:true,
                    width:80
                },
                {
                    field:"books_type",
                    title:"类别",
                    width:100
                }
            ]],
            toolbar:[
                {
                    text:"添加",
                    iconCls:"icon-add",
                    handler:function () { addBookTypes();}
                },
                {
                    text:"删除",
                    iconCls:"icon-remove",
                    handler:function () {}
                },
                {
                    text:"修改",
                    iconCls:"icon-edit",
                    handler:function () {}
                }
            ]
        });
        load1(1,5);
    }
    function load1(page,pagesize){
        $.getJSON("findAllBookTypes.do",{
            page:page,
            pagesize:pagesize
        },function (d) {
            //解析json字符串
            //var json= JSON.stringify(d.allBookType);
            var datas=d.allBookType;
            //填充数据
            $("#booktypes_tree").datagrid("loadData",datas);
            //获取分页组件
            var pager= $("#booktypes_tree").datagrid("getPager");
            pager.pagination({
                total:d.total,
                pageSize:pagesize,
                pageList:[5,10],
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
    function addBookTypes(){
        $("#booktypes_form").form("clear");
        $("#booktypes_windows").window("open");
    }
    function saveBookType() {
        $("#booktypes_form").form("submit",{
            success:function (xhr) {
                if(xhr==1){
                    $.messager.alert("系统提示","成功添加书籍类型成功");
                    //再添加完新用户后重新加载数据
                    load1(1,5);
                    //当添加完用户后，关闭该界面（窗口）
                    $("#books_windows").window("close");
                }
                if (xhr==-1){
                    $.messager.alert("系统提示","添加失败");
                }
            }
        });
    }
    $(init);
</script>
