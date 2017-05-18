<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="sidebar ">
    <div class="sidebar-collapse">
        <div class="sidebar-header t-center" style="background:#048975">
            <span><img class="text-logo" src="${pageContext.request.contextPath }/style/proton_assets/img/logo1.png"><i class="fa fa-space-shuttle fa-3x blue"></i></span>
        </div>
        <div class="sidebar-menu">
            <ul class="nav nav-sidebar">
                <li><a href="index.html"><i class="fa fa-laptop"></i><span class="text">主页</span></a></li>
                <li><a href="#" onclick="toPage('/tecapp/item/itemList')"><i class="fa fa-picture-o"></i><span class="text">项目管理</span></a></li>
                <li><a href="#" onclick="toPage('/tecapp/extract/itemList')"><i class="fa fa-list-alt"></i><span class="text">专家抽取</span></a></li>
                <li><a href="#" onclick="toPage('/tecapp/expert/expertList')"><i class="fa fa-table"></i><span class="text">专家管理</span></a></li>
            </ul>
        </div>
    </div>
    <div class="sidebar-footer">

        <div class="sidebar-brand">
            专家抽取系统
        </div>
        <ul class="sidebar-terms" style="text-align: center">
            <!--
            <li><a href="index.html#">Terms</a></li>
            <li><a href="index.html#">Privacy</a></li>
            -->
            <li><a href="index.html#">Help</a></li>
            <li><a href="index.html#">About</a></li>

        </ul>
        <div class="copyright text-center">
            <small><i class="fa fa-coffee">ieds</i></small>
        </div>
    </div>

</div>
</body>
</html>
