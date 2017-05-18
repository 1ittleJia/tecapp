<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>呼和浩特供电局专家抽取管理</title>
    <%@ include file="/style/share/style.jsp" %>
    <script type="text/javascript">
        function comeBack(){
            window.location="/tecapp/item/itemList";
        }
    </script>
</head>
<body>
<div class="main sidebar-minified">
    <div class="form-horizontal">
        <div class="form-group">
        <label class="col-sm-10 control-label">标段列表</label>
        <div class="col-sm-2">
            <a href="/tecapp/pack/add/${itemId}" type="button" class="btn btn-primary btn-sm">添加标段</a>
            <a href="#" type="button" onclick="comeBack()" class="btn btn-primary btn-sm">返回</a>
        </div>
    </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2><i class="fa fa-table red"></i><span class="break"></span><strong>标段列表</strong></h2>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered table-striped table-condensed table-hover">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>标段名称</th>
                                <th>招标方式</th>
                                <th>联系电话</th>
                                <th>评标开始时间</th>
                                <th>评标人数</th>
                                <th>出席地址</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty packList}">
                            <tr>
                                <td colspan="8" style="text-align: center">无数据</td>
                            </tr>
                            </c:if>
                            <c:forEach items="${packList}" var="pack" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${pack.packNm}</td>
                                    <td>${pack.bidMode}</td>
                                    <td>${pack.phone}</td>
                                    <td>${pack.evalueTime}</td>
                                    <td>${pack.evalueNum}</td>
                                    <td>${pack.evalueAddr}</td>
                                    <td><a href="/tecapp/pack/delete/${pack.id}.${pack.itemId}" type="button" class="btn btn-sm btn-danger">删除</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <ul class="pagination">
                        <li><a href="table.html#">Prev</a></li>
                        <li class="active">
                            <a href="table.html#">1</a>
                        </li>
                        <li><a href="table.html#">2</a></li>
                        <li><a href="table.html#">3</a></li>
                        <li><a href="table.html#">4</a></li>
                        <li><a href="table.html#">5</a></li>
                        <li><a href="table.html#">Next</a></li>
                    </ul>
                </div>
            </div>
        </div><!--/col-->
    </div><!--/row-->
</div>
</body>
</html>