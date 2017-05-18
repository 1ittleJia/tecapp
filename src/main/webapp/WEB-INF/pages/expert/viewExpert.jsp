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
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/style/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/style/css/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function valiDate(){
            var msg="";
            var vali=true;

            if($("#vo_month").val()==""){
                vali=false;
                msg+="日期不能为空！\n";
            }
            if($("#vo_accountNum").val()==""){
                vali=false;
                msg+="户号不能为空！\n";
            }
            if($.trim($("#vo_defaultElectricityWay").val())=="00"){
                vali=false;
                msg+="违约用电方式不能为空！\n";
            }
            if($.trim($("#vo_defaultElectricityDesc").val())==""){
                vali=false;
                msg+="违约用电描述不能为空！\n";
            }
            if(vali==false)alert(msg);
            return vali;
        }

        function comeBack(){
            window.location="/tecapp/expert/expertList";
        }
    </script>
</head>
<body>
<div class="container form-horizontal">
    <fieldset>
        <legend>专家信息</legend>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="expertNm">姓名</label>
            <div class="col-sm-4">
                <input class="form-control" id="expertNm" name="expertNm" type="text" value="${expert.expertNm}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="sex" >性别</label>
            <div class="col-sm-4">
                <select class="form-control" id="sex" name="sex" value="${expert.sex}" disabled>
                    <option>男</option>
                    <option>女</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nativePlace">籍贯</label>
            <div class="col-sm-4">
                <input class="form-control" id="nativePlace" name="nativePlace" type="text" value="${expert.nativePlace}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="identCard">身份证号</label>
            <div class="col-sm-4">
                <input class="form-control" id="identCard" name="identCard" type="text" value="${expert.identCard}" readonly/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="politicalStatus">政治面貌</label>
            <div class="col-sm-4">
                <input class="form-control" id="politicalStatus" name="politicalStatus" type="text" value="${expert.politicalStatus}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="birthdate">出生日期</label>
            <div class="col-sm-4">
                <input class="form-control" id="birthdate" name="birthdate" type="date" value="${expert.birthdate}" readonly/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="schooltag">毕业学校</label>
            <div class="col-sm-4">
                <input class="form-control" id="schooltag" name="schooltag" type="text" value="${expert.schooltag}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="graduationDate">毕业日期</label>
            <div class="col-sm-4">
                <input class="form-control" id="graduationDate" name="graduationDate" type="date" value="${expert.graduationDate}" readonly/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="education">学历</label>
            <div class="col-sm-4">
                <input class="form-control" id="education" name="education" type="text" value="${expert.education}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="locationProvince">工作地</label>
            <div class="col-sm-4">
                <div class="input-group">
                    <div class="col-sm-6">
                        <input class="form-control" id="locationProvince" name="locationProvince" type="text" value="${expert.locationProvince}" readonly/>
                    </div>
                    <div class="col-sm-6">
                        <input class="form-control" id="locationCity" name="locationCity" type="text" value="${expert.locationCity}" readonly/>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="workUnit">工作单位</label>
            <div class="col-sm-4">
                <input class="form-control" id="workUnit" name="workUnit" type="text" value="${expert.workUnit}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="unitType">单位类型</label>
            <div class="col-sm-4">
                <select class="form-control" id="unitType" name="unitType" value="${expert.unitType}" disabled>
                    <option>1.国有企业</option>
                    <option>2.国有控股企业</option>
                    <option>3.外资企业</option>
                    <option>4.合资企业</option>
                    <option>5.私营企业</option>
                    <option>6.事业单位</option>
                    <option>7.国家行政机关</option>
                    <option>8.政府</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="department">工作部门</label>
            <div class="col-sm-4">
                <input class="form-control" id="department" name="department" type="text" value="${expert.department}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="position">职务/职位</label>
            <div class="col-sm-4">
                <input class="form-control" id="position" name="position" type="text" value="${expert.position}" readonly/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="workTime">参加工作时间</label>
            <div class="col-sm-4">
                <input class="form-control" id="workTime" name="workTime" type="text" value="${expert.workTime}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="majorPerformance">重大业绩</label>
            <div class="col-sm-4">
                <input class="form-control" id="majorPerformance" name="majorPerformance" type="text" value="${expert.majorPerformance}" readonly/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="phone">联系电话</label>
            <div class="col-sm-4">
                <input class="form-control" id="phone" name="phone" type="text" value="${expert.phone}" readonly/>
            </div>
            <label class="col-sm-2 control-label" for="alternativePhone">备用联系电话</label>
            <div class="col-sm-4">
                <input class="form-control" id="alternativePhone" name="alternativePhone" type="text" value="${expert.alternativePhone}" readonly/>
            </div>
        </div>
        <div class="panel-footer">
            <div align="right">
                <input class="btn btn-primary" id="button" type="button" value="取消" onclick="comeBack();"/>
            </div>
        </div>
    </fieldset>
</div>
</body>
</html>
