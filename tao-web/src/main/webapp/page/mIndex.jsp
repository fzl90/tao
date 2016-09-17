<%--
  Created by IntelliJ IDEA.
  User: fzl
  Date: 16/5/11
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>nanuku管理页面</title>
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link rel="bookmark" href="/favicon.ico"/>

    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script  src="<%=request.getContextPath() %>/jquery/jquery-1.7.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/jquery/jquery.form.js"></script>
    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">

        function gotoAdd() {
            window.location.href="manage/goto/add";
        }

        function removePic(id) {
            $.post('/manage/remove', {
                id : id
            }, function(data) {
                window.location.href="<%=request.getContextPath() %>/manage";
            });
        }

        function gotoEdit(id) {
            window.location.href="manage/goto/edit?id="+id;
        }

    </script>
</head>


<body>

<br>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <button type="button" class="btn btn-success btn-sm active btn-block" onclick="gotoAdd()">添加</button>
            <br>

            <c:forEach var="subList" items="${picList}" >
                <div class="row">
                    <c:forEach var="pic" items="${subList}" >
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img alt="300x200" src="/pic/<c:out value="${pic.url}" default=""/>" />
                                <div class="caption">
                                    <h4>
                                        <c:out value="${pic.name}" default=""/>
                                    </h4>
                                    <p>
                                        <c:out value="${pic.remark}" default=""/>
                                    </p>
                                    <p>
                                        <button type="button" class="btn btn-link btn-xs" onclick="gotoEdit(<c:out value="${pic.id}"/>)">修改</button>
                                        <button type="button" class="btn btn-link btn-xs" onclick="removePic(<c:out value="${pic.id}"/>)">删除</button>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

</body>
</html>