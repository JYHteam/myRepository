
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="panel panel-success">
    <!-- Default panel contents -->
    <div class="panel-heading">填写购物信息</div>
    <div class="panel-body">
        <h4>收货地址</h4>
        <hr/>
        <form class="form-horizontal">
            <div class="form-group">
                <label for="province" class="col-sm-2 control-label">省</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="province" name="province" placeholder="省份">
                </div>
            </div>
            <div class="form-group">
                <label for="city" class="col-sm-2 control-label">市</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="city" name="city" placeholder="城市">
                </div>
            </div>
            <div class="form-group">
                <label for="area" class="col-sm-2 control-label">地区</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="area" name="area" placeholder="地区">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">确定订单</button>
                </div>
            </div>
        </form>
    </div>

    <!-- Table -->
    <table class="table">
        ...
    </table>
</div>
</body>
</html>
