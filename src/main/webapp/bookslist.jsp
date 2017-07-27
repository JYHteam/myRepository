
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
          function addBook(book_id){
              $.getJSON("addCart.do","book_id:book_id",function (d) {
                  alert(d);
              })
          }
        })
    </script>
</head>
<body>
<table class="table table-striped">
    <caption>书籍详情</caption>
    <thead>
    <tr>
        <th>id</th>
        <th>书名</th>
        <th>价格</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allBooks}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.book_name}</td>
            <td>${item.book_price}</td>
            <td><a class="label label-primary" href="addCart.do?book_id=${item.id}">添加到购物车</a> </td>
        </tr>
    </c:forEach>


    </tbody>
</table>
</body>
</html>
