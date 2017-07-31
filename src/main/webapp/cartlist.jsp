<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            function deleteBook(book_id){
              $.get("deleteCart.do","book_id:book_id",function (d) {
                    alert(d);
                })
             alert("删除");
            }

        })
    </script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">LOGO</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-primary">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <%--<li><a href="#">Link</a></li>--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">会员中心<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#" data-toggle="modal" data-target="#login">登录</a></li>
                        <li><a href="#">注册</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">会员中心</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="col-md-3">

</div>
<div class="col-md-9">
    <table class="table table-striped">
        <caption>购物车详情</caption>
        <thead>
        <tr>
            <th>id</th>
            <th>书名</th>
            <th>数量</th>
            <th>总价</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cart.showCart()}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.book_name}</td>
                <td>${item.cart_count}</td>
                <td>${(item.book_price*item.cart_count)}</td>
                <td>
                    <button type="button" class="btn btn-danger" onclick="deleteBook('${item.id}')">删除</button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <hr/>
    <!--下单-->
    <div >
        应付：￥${cart.total()}  <a type="button" class="btn btn-primary" href="gaddress.jsp">下单</a>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                   登录界面
                </h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="Email">会员账号：</label>
                        <input type="email" class="form-control" id="Email" placeholder="请输入您的会员账号">
                    </div>
                    <div class="form-group">
                        <label for="Password">会员密码：</label>
                        <input type="password" class="form-control" id="Password" placeholder="请输入密码">
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> 记住我
                        </label>
                    </div>
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <%--<button type="button" class="btn btn-primary">
                    登录
                </button>--%>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>

