<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8" />
    <title>呼和浩特供电局专家抽取系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <link href="${pageContext.request.contextPath }/style/css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/style/css/style.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath }/style/jquery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/style/css/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function toPage(url){
            $('iframe').attr('src',url);
        }
    </script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-main">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">欢迎登陆呼和浩特供电局专家抽取系统</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse-main">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" onclick="toPage('/tecapp/item/itemList')">项目管理</a></li>
                <li><a href="#" onclick="toPage('/tecapp/expert/expertList')">专家管理</a></li>
                <li><a href="#" onclick="toPage('/tecapp/extract/itemList')">专家抽取</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- first section - Home -->
<div id="home" class="home">
    <div class="text-vcenter">
        <iframe frameborder="no" border="0" style="margin:40px 0 0 0px; width:100%;height:88%;border-style: none;border-width:0px;border-color:#CCC; "
                src="/tecapp/item/itemList" scrolling="auto">
        </iframe>
    </div>
</div>
</body>
</html>