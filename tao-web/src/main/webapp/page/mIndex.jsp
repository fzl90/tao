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

    <script  src="<%=request.getContextPath() %>/js/jquery/jquery-1.7.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery/jquery.form.js"></script>
    <script  src="<%=request.getContextPath() %>/js/jquery/jquery-datePicker.js"></script>
    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        function test(id) {
            alert(id);

        }

    </script>
</head>


<body>


<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <div class="alert alert-success alert-dismissable" hidden="hidden">
                <strong>Warning!</strong> Best check yo self, you're not looking too good.
            </div>

            <button type="button" class="btn btn-success btn-sm active btn-block">添加</button>
            <br>

            <c:forEach var="subList" items="${picList}" >
                <div class="row">
                    <c:forEach var="pic" items="${subList}" >
                        <div class="col-md-4">
                            <div class="thumbnail">
                                <img alt="300x200" src="/pic/<c:out value="${pic.url}" default=""/>" />
                                <div class="caption">
                                    <h3>
                                        <c:out value="${pic.name}" default=""/>
                                    </h3>
                                    <p>
                                        <c:out value="${pic.remark}" default=""/>
                                    </p>
                                    <p>
                                        <a class="btn btn-primary" href="#" onclick="test()">删除</a> <a class="btn" href="#">Action</a>
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