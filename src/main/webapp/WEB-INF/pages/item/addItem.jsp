<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        $(document).ready(function() {
            $('#validatorForm').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    itemNm: {
                        validators: {
                            notEmpty: {
                                message: '项目名称不能为空！'
                            }
                        }
                    },
                    bidId: {
                        validators: {
                            notEmpty: {
                                message: '招标编号不能为空！'
                            }
                        }
                    }
                }
            });
        });

        function comeBack(){
            window.location="/tecapp/item/itemList";
        }
    </script>
</head>
<body>
<div class="main ">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2><i class="fa fa-indent red"></i><strong>项目信息</strong></h2>
                </div>
                <form:form action="/tecapp/item/addP" id="validatorForm" method="post" commandName="item" role="form" cssClass="form-horizontal">
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="itemNm">项目名称:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="itemNm" name="itemNm" value="${item.itemNm}" placeholder="输入项目名称:"/>
                        </div>
                        <label class="col-sm-2 control-label" for="bidId">招标编号:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bidId" name="bidId" value="${item.bidId}" placeholder="输入招标编号:"/>
                        </div>
                    </div>
                </div>
                <div class="panel-footer" style="text-align: right">
                    <button type="submit" id="submit" class="btn btn-sm btn-success"><i class="fa fa-dot-circle-o"></i> 保存</button>
                    <button type="button" id="button" class="btn btn-sm btn-danger" onclick="comeBack();"><i class="fa fa-ban"></i> 取消</button>
                </div>
                </form:form>
            </div>
        </div><!--.col-->
    </div><!--.row-->
</div>
</body>
</html>
