<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8" />
    <title>呼和浩特供电局专家抽取系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <%@ include file="/style/share/style.jsp" %>
    <script type="text/javascript">
        function changeFrameHeight(){
            var ifm= document.getElementById("rightFrame");
            ifm.height=document.documentElement.clientHeight-10;
        }
        window.onresize=function(){
            changeFrameHeight();
        }

        function toPage(url){
            $('iframe').attr('src',url);
        }
    </script>
</head>
<body style="overflow-y: hidden;">
<!-- start: Header -->
<%@ include file="/WEB-INF/pages/main/header.jsp"%>
<!-- end: Header -->

<div class="container-fluid content">
    <div class="row">
        <!-- start: Main Menu -->
        <%@ include file="/WEB-INF/pages/main/menu.jsp"%>
        <!-- end: Main Menu -->
        <!-- start: Content -->
        <iframe id="rightFrame" name="right" width="100%" frameborder=0 onload="changeFrameHeight()" allowtransparency="true" scrolling="no"
                style="overflow: hidden; overflow-x: hidden; overflow-y: hidden;" src="/tecapp/item/itemList">
        </iframe>
        <!-- end: Content -->
    </div>
</div>
</body>
</html>