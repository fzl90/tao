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

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js_css/main.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js_css/pbl.css"/>

    <script src="<%=request.getContextPath() %>/jquery/jquery-1.7.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/js_css/pbl.js"></script>
    <script>

        $(function () {
            //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
            $(function () {
                $(window).scroll(function () {
                    if ($(window).scrollTop() > 100) {
                        $("#back-to-top").fadeIn(1500);
                    } else {
                        $("#back-to-top").fadeOut(1500);
                    }
                });

                //当点击跳转链接后，回到页面顶部位置

                $("#back-to-top").click(function () {
                    $('body,html').animate({scrollTop: 0}, 1000);
                    return false;
                });
            });
        });

    </script>
</head>
<body>


<div id="header" style="left: 0px;">
    <div class="wrapper wrapper-996">
        <div class="menu-bar">
            <div class="left-part">
                <a id="nanuku" href="/"></a>
                <a href="/discovery/" class="header-item active">发现</a>
                <a href="/all/" class="header-item ">最新</a>
                <a href="https://muse.huaban.com/" class="header-item meisi">美思<i class="muse entrance"></i></a>
            </div>
            <div class="right-part">
                <a style="display: none" href="#" onclick="return false;" class="go-mobile btn rbtn"><span class="text"> 访问移动版</span></a>
            </div>
        </div>
    </div>
</div>


<div id="waterfall">
    <c:forEach var="pic" items="${picList}">
        <div class="cell">
            <a href="#"> <img src="/pic/<c:out value="${pic.url}" />"/></a>
            <p><a href="http://sc.chinaz.com/jiaoben/">素材</a></p>
        </div>
    </c:forEach>
</div>

<p id="back-to-top"><a href="#top"><span></span>返回顶部</a></p>


</body>

<script>
    var opt = {
        getResource: function (index) {
            var html = "";
            $.ajax({
                type: "get",
                url: "/pics",
                data: "pageNum=20&pageIndex=" + index,
                async: false,
                success: function (data) {
                    var res = eval('(' + $.trim(data) + ')');
                    var pics = res.data;
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
</html>
