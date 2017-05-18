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
    <script type="text/javascript">
        /*$(document).ready(function(){
            $('#exportExcel').click(function(){
                $('#form2').ajaxSubmit({
                    dataType: 'text',
                    error: errorMsg
                });
                function errorMsg(){
                    alert("导出excel出错！");
                }
            });
        });*/

        function setItemId(iid,inm){
            $("#itemId").val(iid);
            $("#itemNm1").val(inm);
            $("#form2").submit();
        }
    </script>
</head>
<body>
<div class="main sidebar-minified">
    <div class="form-horizontal">
    <form:form action="/tecapp/extract/itemList" method="post" commandName="item" role="form">
        <div class="form-group">
            <label for="itemNm" class="col-sm-1 control-label">项目名称:</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="itemNm" name="itemNm" value="${item.itemNm}" placeholder="输入项目名称:"/>
            </div>
            <div class="col-sm-2">
                <input type="submit" name="submit" class="btn btn-primary btn-sm" value="检索">
            </div>
        </div>
    </form:form>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2><i class="fa fa-table red"></i><span class="break"></span><strong>项目列表</strong></h2>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered table-striped table-condensed table-hover">
                        <thead>
                        <tr>
                            <th width="5%">序号</th>
                            <th width="35%">项目名称</th>
                            <th width="20%">招标编号</th>
                            <th width="20%">创建时间</th>
                            <th width="20%">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${itemList}" var="item" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${item.itemNm}</td>
                                <td>${item.bidId}</td>
                                <td><fmt:formatDate value="${item.operateTime}" pattern="yyyy-MM-dd" /> </td>
                                <td>
                                    <a href="/tecapp/extract/packList/${item.id}" type="button" class="btn btn-sm btn-success">专家抽取</a>
                                    <a href="#" type="button" id="exportExcel" onclick="setItemId('${item.id}','${item.itemNm}');" class="btn btn-sm btn-warning">导出抽取到的专家</a>
                                </td>
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
<div style="display: none;">
<form action="/tecapp/extract/exportExcel" method="post" id="form2">
    <input type="text" id="itemId" name="itemId">
    <input type="text" id="itemNm1" name="itemNm">
</form>
</div>
</body>
</html>