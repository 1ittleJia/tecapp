<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>呼和浩特供电局专家抽取管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/style/css/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/style/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/style/css/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container form-horizontal">
        <table class="table table-bordered table-striped">
            <tr class="success">
                <th>ID</th>
                <th>专业名称</th>
                <th>创建时间</th>
            </tr>
            <c:if test="${empty majorList}">
                <tr>
                    <td colspan="3" style="text-align: center">无数据</td>
                </tr>
            </c:if>
            <c:forEach items="${majorList}" var="major">
                <tr>
                    <td>${major.id}</td>
                    <td>${major.majorNm}</td>
                    <td>${major.operateTime}</td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>