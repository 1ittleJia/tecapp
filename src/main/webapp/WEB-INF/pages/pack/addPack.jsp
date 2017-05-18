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
    <script type="text/javascript" src="${pageContext.request.contextPath }/style/jedate/jedate.js"></script>
    <script type="text/javascript">
        function valiDate(){
            var msg="";
            var vali=true;
            if($("#packNm").val()==""){
                vali=false;
                msg+="标段名称不能为空！\n";
            }
            if($("#phone").val()==""){
                vali=false;
                msg+="联系电话不能为空！\n";
            }
            if($.trim($("#dateinfo").val())=="00"){
                vali=false;
                msg+="评标时间不能为空！\n";
            }
            if($.trim($("#evalueNum").val())=="00"){
                vali=false;
                msg+="评标人数不能为空！\n";
            }
            if($.trim($("#evalueAddr").val())==""){
                vali=false;
                msg+="评标地址不能为空！\n";
            }
            if(vali==false)alert(msg);
            return vali;
        }

        function comeBack(){
            var itemId = $("#itemId").val();
            window.location="/tecapp/pack/packList/"+itemId;
        }
    </script>
</head>
<body>
<div class="main ">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2><i class="fa fa-indent red"></i><strong>标段信息</strong></h2>
                </div>
                <form:form action="/tecapp/pack/addPack" method="post" commandName="pack" role="form" cssClass="form-horizontal group-border">
                <div class="panel-body">
                    <input type="hidden" id="itemId" name="itemId" value="${pack.itemId}">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="packNm">标段名称</label>
                        <div class="col-sm-4">
                            <input class="form-control" id="packNm" name="packNm" type="text" value="${pack.packNm}" placeholder="请输入姓名"/>
                        </div>
                        <label class="col-sm-2 control-label" for="bidMode">招标方式</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="bidMode" name="bidMode" value="${pack.bidMode}" >
                                <option>公开招标</option>
                                <option>入围招标</option>
                                <option>单一来源</option>
                                <option>竞争性谈判</option>
                            </select>
                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="phone">联系电话</label>
                        <div class="col-sm-4">
                            <input class="form-control" id="phone" name="phone" type="text" value="${pack.phone}" placeholder="请输入联系电话"/>
                        </div>
                        <label class="col-sm-2 control-label" for="dateinfo">评标开始时间</label>
                        <div class="col-sm-4">
                            <input class="form-control datainp" id="dateinfo" name="evalueTime" placeholder="请输入日期" >
                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="evalueNum">评标人数</label>
                        <div class="col-sm-4">
                            <input class="form-control" id="evalueNum" name="evalueNum" type="text" value="${pack.evalueNum}" placeholder="请输入评标人数"/>
                        </div>
                        <label class="col-sm-2 control-label" for="evalueAddr">出席地点</label>
                        <div class="col-sm-4">
                            <input class="form-control" id="evalueAddr" name="evalueAddr" type="text" value="${pack.evalueAddr}" placeholder="请输入出席地点"/>
                        </div>
                    </div>
                </div>
                <div class="panel-footer" style="text-align: right">
                    <button type="submit" id="submit" class="btn btn-sm btn-success" onclick="return valiDate()"><i class="fa fa-dot-circle-o"></i> 保存</button>
                    <button type="reset" id="button" class="btn btn-sm btn-danger" onclick="comeBack();"><i class="fa fa-ban"></i> 取消</button>
                </div>
                </form:form>
            </div>
        </div><!--.col-->
    </div><!--.row-->
</div>
<script type="text/javascript">
    //jeDate.skin('gray');
    jeDate({
        dateCell:"#dateinfo",
        format:"YYYY-MM-DD hh:mm:ss",
        isinitVal:true,
        isTime:true, //isClear:false,
        minDate:"2014-09-19 00:00:00",
        okfun:function(val){alert(val)}
    })
</script>
</body>
</html>
