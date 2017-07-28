<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="books_tree"></div>

<!--添加书籍-->
<div id="books_windows" class="easyui-window" style="width:600px;height:800px;" title="书籍添加" data-options="closed:true,modal:true">
    <div>
        <form id="books_form">
            <input type="hidden" name="id"/>
            书籍名字：<input id="book_name" name="book_name" type="text"/><br>
            书籍类型：<input name="book_typeid" class="easyui-combobox"
                        data-options="url:'pfindAllBookTypes.do',valueField:'id', textField:'books_type',panelHeight:'auto' "/><br/>
            书籍图片：<input id="book_image" name="book_image" type="file" onchange="showpic(this)"/>
            <%--显示将要上传的图片--%>
            <span id="pics" style="width:20px;height:20px"></span><br>
            书籍价格：<input id="book_price" name="book_price" type="text"/><br>
            书籍数量：<input id="book_count" name="book_count" type="text"/><br>
        </form>
    </div>
    <br/>
    <!--书籍描述-->
    <div>
        <textarea cols="3" rows="3" class="ckeditor" name="book_introduce" style="width: 100%;height:400px"></textarea>
    </div>
    <div>
        <a class="easyui-linkbutton" href="javascript:saveBook()">保存</a>
    </div>

</div>



<!--修改书籍-->
<div id="ubook_windows" class="easyui-window" style="width:600px;height:800px;" title="书籍修改" data-options="closed:true,modal:true">
    <div>
        <form id="updatebook_form">
            <input type="hidden" name="id"/>
            书籍名字：<input id="book_name" name="book_name" type="text"/><br>
            书籍类型：<input name="book_typeid" class="easyui-combobox"
                        data-options="url:'pfindAllBookTypes.do',valueField:'id', textField:'books_type',panelHeight:'auto' "/><br/>
            书籍图片：<input id="book_image" name="book_image" type="file" onchange="showpic(this)"/>
            <%--显示将要上传的图片--%>
            <span id="pics" style="width:20px;height:20px"></span><br>
            书籍价格：<input id="book_price" name="book_price" type="text"/><br>
            书籍数量：<input id="book_count" name="book_count" type="text"/><br>
        </form>
    </div>
    <br/>
    <!--书籍描述-->
    <div>
        <textarea cols="3" rows="3" class="ckeditor" name="book_introduce" style="width: 100%;height:400px"></textarea>
    </div>
    <div>
        <a class="easyui-linkbutton" href="javascript:upBook()">确认修改</a>
    </div>

</div>
<script type="text/javascript">
    function init() {
        $("#books_tree").datagrid({
            title: "书籍管理",
            pagination: true,
            columns: [[
                {
                    field: "id",
                    title: "序号",
                    checkbox: true,
                    width: 80
                },
                {
                    field: "book_name",
                    title: "书名",
                    width: 80
                },
                {
                    field: "book_price",
                    title: "价格",
                    width: 80
                },
                {
                    field: "book_count",
                    title: "库存",
                    width: 80
                },
                {
                    field: "books_type",
                    title: "类别",
                    width: 100,
                    formatter: function (value, row, index) {
                        if (row.bookTypes) {
                            return row.bookTypes.books_type;
                        } else {
                            return value;
                        }
                    }
                }
            ]],
            toolbar: [
                {
                    text: "添加",
                    iconCls: "icon-add",
                    handler: function () {
                        addBook();
                    }
                },
                {
                    text: "删除",
                    iconCls: "icon-remove",
                    handler: function () {
                        deletebook();
                    }
                },
                {
                    text: "修改",
                    iconCls: "icon-edit",
                    handler: function () {
                        updatebook();
                    }
                }
            ]
        });
        load1(1, 5);
        //初始化在线编译文本框
        CKEDITOR.replace("book_introduce");
    }
    $(init);
    function load1(page, pagesize) {
        $.getJSON("bfindAllBooks.do", {
            page: page,
            pagesize: pagesize
        }, function (d) {
            //解析json字符串
            //var json= JSON.stringify(d.allBookType);
            var datas = d.books;
            //填充数据
            $("#books_tree").datagrid("loadData", datas);
            //获取分页组件
            var pager = $("#books_tree").datagrid("getPager");
            pager.pagination({
                total: d.total,
                pageSize: pagesize,
                pageList: [5, 10],
                pageNumber: page,
                onSelectPage: function (page, pagesize) {

                    load1(page, pagesize);
                },
                beforePageText: '第',
                afterPageText: '页  共{pages}页',
                displayMsg: '共 {total} 条记录',

            });
        });
    }
    //添加书籍
    function addBook() {
        //$("#books_form").form("clear");
        $("#books_windows").window("open");
    }
    //显示图片
    function showpic(p) {
        var f1 = p.files[0];
        //伪造URL地址
        var xurl = URL.createObjectURL(f1);
        var imagey = "<img src='" + xurl + "'/>";
        $("#pics").html(imagey);
    }
    function saveBook() {
        var formData = new FormData(document.getElementById("books_form"));
        var data = CKEDITOR.instances.book_introduce.getData();
        alert(formData)
        formData.append("book_introduce", data);
        $.ajax({
            url: 'addBooks.do',
            method: 'post',
            data: formData,
            contentType: false,
            processData: false,
            success: function (d) {
                load1(1, 5);
                //$("#books_tree").datagrid("reload");
                $("#books_windows").window("close");
                $.messager.alert("系统提示", "添加成功");

            }

        });
    }
    //删除书籍
    function deletebook() {
        var dbook = $("#books_tree").datagrid("getSelections");
        alert(dbook);
        var ids = [];
        for (var i = 0; i < dbook.length; i++) {
            ids[i] = dbook[i].id;
        }
        var x = JSON.stringify(ids);
        //发送json数据
        $.ajax({
            url: "deleteBooks.do",
            method: "post",
            data: x,
            contentType: "application/json",
            success: function (d) {
                if (d == 1) {
                    $.messager.alert("系统提示", "删除成功");
                    //再修改完用户数据后重新加载数据
                    load1(1, 5);

                }
                if (d == -1) {
                    $.messager.alert("系统提示", "请选择需要删除的书籍");
                }

            }
        });
    }


    //修改
    function updatebook() {
        var ubook = $("#books_tree").datagrid("getSelected");
       // alert(ubook);
        if (ubook) {
            $("#ubook_windows").window("open");
        } else {
            $.messager.alert("系统提示", "请选择需要修改的书籍");
        }
        $("#updatebook_form").form("load", {
            id: ubook.id,
            book_name: ubook.book_name,
            book_price:ubook.book_price,
            book_count:ubook.book_count,
            book_typeid:ubook.book_typeid,
            book_image:ubook.book_image,
            book_introduce:ubook.book_introduce,
        });
    }
    function upBook() {
        var formData = new FormData(document.getElementById("updatebook_form"));
        var datas = CKEDITOR.instances.book_introduce.getData();
        alert(formData);
        alert(datas);
        formData.append("book_introduce", datas);
        $.ajax({
            url: 'updateBook.do',
            method: 'post',
            data: formData,
            contentType: false,
            processData: false,
            success: function (d) {
                if (d == 1) {
                    $.messager.alert("系统提示", "修改成功");
                    //再修改完用户数据后重新加载数据
                    load1(1, 5);
                }
                if (d == -1) {
                    $.messager.alert("系统提示", "修改失败");
                }

            }

        });
    }

</script>

