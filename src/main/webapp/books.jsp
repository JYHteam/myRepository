<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="books_tree"></div>
<div id="books_windows" class="easyui-window" style="width:600px;height:800px;" title="书籍添加"
     data-options="closed:true,modal:true">
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
                    }
                },
                {
                    text: "修改",
                    iconCls: "icon-edit",
                    handler: function () {
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
                $("#books_windows").window("close");
                $.messager.alert("系统提示", "添加成功");
                $("#books_tree").datagrid("reload");
            }

        })
    }

</script>

