
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="css/icon.css">
    <link rel="stylesheet" type="text/css" href="css/easyui.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
</head>
<body>
    首页
<<a href="/dologin.do?users_account=aa&users_pwd=aa">点击</a>
    <div class="easyui-panel" title="搜索" style="width:100%;height:100px">
        <input class="easyui-searchbox" data-options="menu:'#choice',prompt:'输入搜索关键字',searcher:doSearch"/>
        <div id="choice">
            <div data-options="name:'account'">账号</div>
            <div data-options="name:'role'">角色</div>
        </div>
    </div>
</body>
</html>
