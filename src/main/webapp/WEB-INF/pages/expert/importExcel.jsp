<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script type="text/javascript">
        //JS校验form表单信息
        function checkData(){
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if("" == fileDir){
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if(".xls" != suffix && ".xlsx" != suffix ){
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }

        function comeBack(){
            window.location="/tecapp/expert/expertList";
        }
    </script>
</head>
<body>
<div class="container">
    <h1>批量导入专家信息</h1>
    <hr/>
    <form name="excelImportForm" action="/tecapp/expert/uploadExcel" method="post" enctype="multipart/form-data" id="excelImportForm">
        <input  type="hidden" name="ids" id="ids">
        <div class="modal-body">
            <div class="row gap">
                <label class="col-sm-7 control-label"><input class="btn btn-default" id="upfile" type="file" name="upfile"  accept="xls"/></label>
                <div class="col-sm-3">
                    <input class="btn btn-primary" id="excel_button" type="submit" value="导入Excel" onclick="return checkData()"/>
                </div>
            </div>

        </div>

        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal" onClick="comeBack();">取消</button>
        </div>
    </form>
</div>
</body>
</html>
