<%--
  Created by IntelliJ IDEA.
  User: fzl
  Date: 16/5/11
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>nanuku</title>
    <link href="http://localhost:8080/favicon.ico" rel="SHORTCUT ICON">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js_css/pbl.css"/>

    <script src="<%=request.getContextPath() %>/jquery/jquery-1.7.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/js_css/pbl.js"></script>

</head>
<body>

<div id="waterfall">
    <c:forEach var="pic" items="${picList}">
        <div class="cell">
            <a href="#"> <img src="/pic/<c:out value="${pic.url}" />"/></a>
            <p><a href="http://sc.chinaz.com/jiaoben/">站长素材</a></p></div>
    </c:forEach>
</div>
<script>

    var html = "";

    var opt = {
        getResource: function (index) {
            $.ajax({
                type: "get",
                url: "/pics",
                data: "pageNum=10&pageIndex="+index,
                async: false,
                success: function (data) {
                    var res = eval('(' + $.trim(data) + ')');
                    var pics = res.data;
                    html = "";
                    for (var i = 0; i < pics.length; i++) {
                        var src = "/pic/" + pics[i].url;
                        html += '<div class="cell"><a href="#"><img src="' + src + '" /></a><p>' + i + '</p></div>';
                    }
                }
            });
            return $(html);
        },
        auto_imgHeight: true,
        insert_type: 1
    }
    $('#waterfall').waterfall(opt);

</script>


</body>
</html>
