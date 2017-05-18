<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>呼和浩特供电局专家抽取</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/style/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/style/assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/style/assets/css/form-elements.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath }/style/assets/css/style.css">
    </head>
<body>
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>欢迎登陆呼和浩特供电局专家抽取系统</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/tecapp/login" method="post" commandName="login" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="loginNm" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">Sign in!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Javascript -->
<script src="../tecapp/style/assets/js/jquery-1.11.1.min.js"></script>
<script src="../tecapp/style/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../tecapp/style/assets/js/jquery.backstretch.min.js"></script>
<script src="../tecapp/style/assets/js/scripts.js"></script>
<!--[if lt IE 10]>
<script src="../tecapp/style/assets/js/placeholder.js"></script>
<![endif]-->
</body>
</html>