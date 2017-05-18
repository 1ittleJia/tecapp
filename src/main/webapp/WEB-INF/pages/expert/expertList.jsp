<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>呼和浩特供电局专家抽取管理</title>
    <%@ include file="/style/share/style.jsp" %>
</head>
<body>
<div class="main sidebar-minified">
    <div class="form-horizontal">
    <form:form action="/tecapp/expert/expertList" method="post" commandName="expert" role="form">
    <div class="form-group">
        <label for="expertNm" class="col-sm-1 control-label">专家名称:</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="expertNm" name="expertNm" value="${expert.expertNm}" placeholder="输入专家名称:"/>
        </div>
        <label for="extractClass" class="col-sm-1 control-label">专家分类:</label>
        <div class="col-sm-3">
            <select class="form-control" id="extractClass" name="extractClass" valu ="${expert.extractClass}" >
                <option>变电</option>
                <option>配电</option>
                <option>输电</option>
                <option>服务</option>
                <option>物资处</option>
            </select>
        </div>
        <div class="col-sm-3">
            <input type="submit" name="submit" class="btn btn-primary btn-sm" value="检索">
            <a href="/tecapp/expert/expertList" type="button" class="btn btn-primary btn-sm">全部</a>
            <a href="/tecapp/expert/add" type="button" class="btn btn-primary btn-sm">添加</a>
            <a href="/tecapp/expert/importExcel" type="button" class="btn btn-primary btn-sm">导入</a>
        </div>
    </div>
    </form:form>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2><i class="fa fa-table red"></i><span class="break"></span><strong>专家列表</strong></h2>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered table-striped table-condensed table-hover">
                        <tr class="text-center success">
                            <th class="text-center" width="5%">序号</th>
                            <th class="text-center" width="10%">专家姓名</th>
                            <th class="text-center" width="15%">工作单位</th>
                            <th class="text-center" width="15%">工作部门</th>
                            <th class="text-center" width="15%">岗位/职务</th>
                            <th class="text-center" width="10%">联系电话</th>
                            <th class="text-center" width="10%">专家分类</th>
                            <th class="text-center" width="15%">操作</th>
                        </tr>

                        <c:forEach items="${expertList}" var="expert" varStatus="s">
                            <tr>
                                <td class="text-center">${s.count}</td>
                                <td class="text-center">${expert.expertNm}</td>
                                <td>${expert.workUnit}</td>
                                <td>${expert.department}</td>
                                <td>${expert.position}</td>
                                <td>${expert.phone}</td>
                                <td class="text-center">${expert.extractClass}</td>
                                <td>
                                    <a href="/tecapp/expert/editExpert/${expert.id}" type="button" class="btn btn-sm btn-warning">修改</a>
                                    <a href="/tecapp/expert/delete/${expert.id}" type="button" class="btn btn-sm btn-danger">删除</a>
                                    <a href="/tecapp/expert/view/${expert.id}" type="button" class="btn btn-sm btn-success">详情</a>
                                </td>
                            </tr>
                        </c:forEach>
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