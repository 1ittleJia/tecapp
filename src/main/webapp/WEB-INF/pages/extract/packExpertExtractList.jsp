<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>呼和浩特供电局专家抽取管理</title>
    <%@ include file="/style/share/style.jsp" %>
    <script type="text/javascript">
        function extract(){
            var msg="";
            var vali=true;
            if($("#extractClass").val()==""){
                vali=false;
                msg+="抽取类别不能为空！\n";
            }
            if($("#evalueNum").val()==""){
                vali=false;
                msg+="抽取人数不能为空！\n";
            }

            var checkId = "";
            $('input[name="checkItem"]:checked').each(function() {
                var id = $(this).parents("tr").attr("id");
                checkId += id+",";
            });
            if(checkId!=""){
                checkId = checkId.substr(0,checkId.length-1);
                $("#packIds").val(checkId);
            }else{
                msg+="请选择要抽取专家的标段！\n";
            }
            if(vali==false)alert(msg);
            return vali;
        }

        function cancelExtract(id){
            bootbox.prompt({
                title: "请输入取消原因!",
                inputType: 'textarea',
                callback: function (result) {
                    if(result!=null){
                        if(result==""){
                            bootbox.alert("请输入取消原因!", function(){ cancelExtract(id); });
                        }else{
                            $("#extractExpertId").val(id);
                            $("#reason").val(result);
                            $("#subSeason").submit();
                        }
                    }
                }
            });
        }

        function goBackPackList(){
            var itemId = $("#itemId").val();
            window.location.href="/tecapp/extract/packList/"+itemId;
        }

    </script>
</head>
<body>
<div class="main sidebar-minified">
    <div class="form-horizontal">
    <form:form action="/tecapp/extract/expertMakeUp" method="post" commandName="extract" role="form" cssClass="form-horizontal">
    <div class="form-group">
        <input type="hidden" id="itemId" name="itemId" value="${itemId}"/>
        <input type="hidden" id="packSeq" name="packSeq" value="${packSeq}"/>
        <label for="extractClass" class="col-sm-1 control-label">抽取类别:</label>
        <div class="col-sm-4">
            <select class="form-control" id="extractClass" name="extractClass">
                <option>变电</option>
                <option>配电</option>
                <option>输电</option>
                <option>服务</option>
                <option>物资处</option>
            </select>
        </div>
        <label for="evalueNum" class="col-sm-1 control-label">抽取人数:</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="evalueNum" name="evalueNum" placeholder="请输入抽取人数"/>
        </div>
        <div class="col-sm-2">
            <input class="btn btn-primary" id="submit" type="submit" value="补抽" onclick="return extract()"/>
            <input class="btn btn-primary" id="botton" type="button" value="返回" onclick="return goBackPackList()"/>
        </div>
    </div>
    </form:form>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2><i class="fa fa-table red"></i><span class="break"></span><strong>专家抽取结果列表</strong></h2>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered table-striped table-condensed table-hover">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>标段名称</th>
                                <th>专家名称</th>
                                <th>联系电话</th>
                                <th>抽取类别</th>
                                <th>是否有效</th>
                                <th>无效原因</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty packExtractExpertList}">
                                <tr>
                                    <td colspan="8" style="text-align: center">无数据</td>
                                </tr>
                            </c:if>
                            <c:forEach items="${packExtractExpertList}" var="extractExpert" varStatus="status">
                                <tr id="${extractExpert.id}">
                                    <td>${status.count}</td>
                                    <td>${extractExpert.packNm}</td>
                                    <td>${extractExpert.expertNm}</td>
                                    <td>${extractExpert.phone}</td>
                                    <td>${extractExpert.extractClass}</td>
                                    <td>
                                        <c:if test="${extractExpert.delFlag=='0'}">
                                            有效
                                        </c:if>
                                        <c:if test="${extractExpert.delFlag=='1'}">
                                            无效
                                        </c:if>
                                    </td>
                                    <td>${extractExpert.reason}</td>
                                    <td><a href="#" type="button" class="btn btn-sm btn-success" onclick="return cancelExtract('${extractExpert.id}');">设为无效</a></td>
                                </tr>
                            </c:forEach>
                        <tbody>
                    </table>
                </div>
            </div>
        </div><!--/col-->
    </div><!--/row-->
</div>
<div style="display: none;">
    <from:form id="subSeason" action="/tecapp/extract/cancelExtract" method="post" commandName="extractBo">
        <input type="text" id="itemId1" name="itemId" value="${itemId}"/>
        <input type="text" id="packSeq1" name="packSeq" value="${packSeq}">
        <input type="text" id="extractExpertId" name="extractExpertId" >
        <input type="text" id="reason" name="reason" >
    </from:form>
</div>
</body>
</html>