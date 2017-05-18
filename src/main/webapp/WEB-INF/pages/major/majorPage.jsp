<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>呼和浩特供电局专家抽取管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/style/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/style/css/style.css" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/style/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/style/css/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
       $(function(){
            $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
            $('.tree li.parent_li > span').on('click', function (e) {
                var children = $(this).parent('li.parent_li').find(' > ul > li');
                if (children.is(":visible")) {
                    children.hide('fast');
                    $(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
                } else {
                    children.show('fast');
                    $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
                }
                e.stopPropagation();
            });
        });

        function toPage(url){
            $('iframe').attr('src',url);
        }
    </script>
</head>
<body>
<div class="container form-horizontal">
    <h3>专家专业管理</h3><hr/>
    <div class="form-group" style="height: 80%">
        <div class="col-sm-4">
            <div class="tree well">
                <ul>
                    <li>
                        <c:forEach items="${majorList}" var="major" varStatus="status">
                            <c:if test="${empty major.pid}">
                                <c:if test="${status.count!=1}">
                                    </ul>
                                </c:if>
                                <span><i class="icon-folder-open"></i> ${major.majorNm}</span> <a href="#" onclick="toPage('/tecapp/major/majorListById/2')">${major.majorNm}</a>
                                <ul>
                            </c:if>
                            <c:if test="${!empty major.pid}">
                                <c:if test="${majorList[status.index-1].leaf==1}">
                                    </li>
                                </c:if>
                                <c:if test="${major.leaf==0}">
                                    <li>
                                    <span><i class="icon-minus-sign"></i> ${major.majorNm}</span> <a href="">${major.majorNm}</a>
                                    <c:if test="${fn:contains(majorList[status.index-1].pids, major.id)}">

                                    </c:if>
                                </c:if>
                                <c:if test="${major.leaf==1}">
                                    <ul>
                                        <li>
                                            <span><i class="icon-leaf"></i> ${major.majorNm}</span> <a href="">${major.majorNm}</a>
                                        </li>
                                    </ul>
                                    </li>
                                </c:if>
                                <c:if test="${status.last}">
                                    <c:if test="${fn:contains(majorList[status.index+1].pids, major.id)}">
                                        <ul>
                                    </c:if>
                                    <c:if test="${fn:contains(majorList[status.index+1].pids, major.id)}">
                                        </ul>
                                    </c:if>
                                </c:if>
                            </c:if>
                            <c:if test="${status.last}">
                                </ul>
                            </c:if>
                        </c:forEach>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm-8" style="height: 700px">
            <iframe frameborder="no" border="0" style="margin:0px 0 0 0px; width:100%;height:100%;border-style: none;border-width:0px;border-color:#CCC; "
                    src="/tecapp/major/majorList" scrolling="auto">
            </iframe>
        </div>
    </div>
</div>
</body>
</html>