<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/23 0023
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台登录界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />

    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content="" />
    <meta name="twitter:image" content="" />
    <meta name="twitter:url" content="" />
    <meta name="twitter:card" content="" />

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/icon.css">
    <link rel="stylesheet" type="text/css" href="css/easyui.css">
    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>

    <![endif]-->


</head>
<body class="style-2">

<div class="container">
    <div class="row">
        <div class="col-md-12 text-center">
            <div style=" width: 100%; height:30px;  display:flex; justify-content:center;align-content:center;" >

                <h2 style="color:#33CCCC">冠冠易贸后台登录界面</h2>

            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-md-4">
            <!-- Start Sign In Form -->
            <form  class="fh5co-form animate-box" data-animate-effect="fadeInLeft">
                <h2>Sign In</h2>
                <div class="form-group">
                    <label  class="sr-only">Username</label>
                    <input type="text" class="form-control" name="users_account" id="account" placeholder="Username" autocomplete="off">
                </div>
                <div class="form-group">
                    <label  class="sr-only">Password</label>
                    <input type="password" class="form-control" name="users_pwd" id="pwd" placeholder="Password" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="remember"><input type="checkbox" id="remember"> 记着我</label>
                </div>
                <!--<div class="form-group">
                    <p>Not registered? <a href="sign-up2.html">Sign Up</a> | <a href="forgot2.html">忘记密码?</a></p>
                </div>-->
                <div class="form-group">
                    <input  id="login" value="登录" class="btn btn-primary">
                    <!--<a href="main.jsp">进入后台</a>-->

                </div>
            </form>
            <!-- END Sign In Form -->

        </div>
    </div>
    <div class="row" style="padding-top: 60px; clear: both;">
        <div class="col-md-12 text-center"><p><small>&copy; 版权所有</small></p></div>
    </div>
</div>

<!-- jQuery -->
<script src="js/jquery.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Placeholder -->
<script src="js/jquery.placeholder.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="js/main.js"></script>
<script src="js/easyui.js"></script>
<script>
    $(document).ready(function(){
        $("#login").click(function () {
            var users_account = $("#account").val();
            var users_pwd=$("#pwd").val();
            alert(users_account);
            $.ajax({
                type:'post',
                url:"backLogin.do",
                data:{
                    users_account:users_account,
                    users_pwd:users_pwd
                },
                success:function (d) {
                    var d1= JSON.stringify(d)
                    alert(d1);
                    if(d==1){
                        $.messager.alert("提示","恭喜您登录成功");
                        window.location.href="main.jsp"
                    }else if(d==0){
                        $.messager.alert("提示","对不起该账号没有分配角色，请联系管理员先分配角色后在登录");
                    }
                    else {
                        $.messager.alert("提示","对不起用户名或者密码不对，请从登录")
                    }
                },
                error:function (d) {
                    alert(d);
                }

            })
        })

    })
</script>

</body>
</html>
