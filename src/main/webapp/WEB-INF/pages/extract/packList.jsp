<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        $(function(){
            function initTableCheckbox() {
                var $thr = $('table thead tr');
                var $checkAllTh = $('<th><input type="checkbox" id="checkAll" name="checkAll"/></th>');
                /*将全选/反选复选框添加到表头最前，即增加一列*/
                $thr.prepend($checkAllTh);
                /*“全选/反选”复选框*/
                var $checkAll = $thr.find('input');
                $checkAll.click(function(event){
                    /*将所有行的选中状态设成全选框的选中状态*/
                    $tbr.find('input').prop('checked',$(this).prop('checked'));
                    /*并调整所有选中行的CSS样式*/
                    if ($(this).prop('checked')) {
                        $tbr.find('input').parent().parent().addClass('warning');
                    } else{
                        $tbr.find('input').parent().parent().removeClass('warning');
                    }
                    /*阻止向上冒泡，以防再次触发点击操作*/
                    event.stopPropagation();
                });
                /*点击全选框所在单元格时也触发全选框的点击操作*/
                $checkAllTh.click(function(){
                    $(this).find('input').click();
                });
                var $tbr = $('table tbody tr');
                var $checkItemTd = $('<td><input type="checkbox" name="checkItem"/></td>');
                /*每一行都在最前面插入一个选中复选框的单元格*/
                $tbr.prepend($checkItemTd);
                /*点击每一行的选中复选框时*/
                $tbr.find('input').click(function(event){
                    /*调整选中行的CSS样式*/
                    $(this).parent().parent().toggleClass('warning');
                    /*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/
                    $checkAll.prop('checked',$tbr.find('input:checked').length == $tbr.length ? true : false);
                    /*阻止向上冒泡，以防再次触发点击操作*/
                    event.stopPropagation();
                });
                /*点击每一行时也触发该行的选中操作*/
                $tbr.click(function(){
                    $(this).find('input').click();
                });
            }
            initTableCheckbox();
        });

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
            if(checkId==""||checkId==","||checkId==null){
                msg+="请选择要抽取专家的标段！\n";
                vali==false
            }else{
                checkId = checkId.substr(0,checkId.length-1);
                $("#packIds").val(checkId);
            }
            if(vali==false)alert(msg);
            return vali;
        }
    </script>
</head>
<body>
<div class="main sidebar-minified">
    <div class="form-horizontal">
    <form:form action="/tecapp/extract/expertExtract" method="post" commandName="extract" role="form" cssClass="form-horizontal">
    <div class="form-group">
        <input type="hidden" id="itemId" name="itemId" value="${itemId}"/>
        <input type="hidden" id="packIds" name="packIds" />
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
            <input class="btn btn-primary" id="submit" type="submit" value="专家抽取" onclick="return extract()"/>
        </div>
    </div>
    </form:form>
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
                                <th>实际抽取人数</th>
                                <th>有效人数</th>
                                <th>出席地址</th>
                                <th>抽取状态</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty packList}">
                                <tr id="">
                                    <td colspan="11" style="text-align: center">无数据</td>
                                </tr>
                            </c:if>
                            <c:forEach items="${packList}" var="pack" varStatus="status">
                                <tr id="${pack.id}">
                                    <td>${status.count}</td>
                                    <td>${pack.packNm}</td>
                                    <td>${pack.bidMode}</td>
                                    <td>${pack.phone}</td>
                                    <td>${pack.evalueTime}</td>
                                    <td>${pack.evalueNum}</td>
                                    <td>${pack.evalueNumReal}</td>
                                    <td>${pack.evalueNumEffect}</td>
                                    <td>${pack.evalueAddr}</td>
                                    <td>
                                        <c:if test="${pack.extractStatue=='0'}">
                                            未抽取
                                        </c:if>
                                        <c:if test="${pack.extractStatue=='1'}">
                                            已抽取
                                        </c:if>
                                    </td>
                                    <td><a href="/tecapp/extract/packExpertExtractList/${pack.id}.${pack.itemId}" type="button" class="btn btn-sm btn-success">抽取详情</a></td>
                                </tr>
                            </c:forEach>
                        <tbody>
                    </table>
                </div>
            </div>
        </div><!--/col-->
    </div><!--/row-->
</div>
</body>
</html>