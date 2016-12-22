<%--
  Created by IntelliJ IDEA.
  User: fzl
  Date: 16/5/11
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>nanuku</title>
    <link href="http://localhost:8080/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js_css/main.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js_css/pbl.css"/>
    <script src="<%=request.getContextPath() %>/jquery/jquery-1.7.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/js_css/pbl.js"></script>
    <script src="<%=request.getContextPath() %>/js_css/main.js"></script>


    <script>

        $(function () {

            $("#waterfall").width(Math.round($(window).width() * 5 / 6));

            //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
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


        function showDetail(picId) {
            $("#pin_view_layer").show();
        }

        function hideDetail() {
            $("#pin_view_layer").hide();
        }

        function showNav() {
            $(".header-main-menu").show();
        }
        function hideNav() {
            $(".header-main-menu").hide();
        }


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
                <div class="menu-nav" onmouseover="showNav()" onmouseleave="hideNav()">
                    <div class="header-main-menu" style="display: none;">
                        <div class="top-module"><a href="/apps/" rel="nofollow" class="text app-link">移动应用</a><a
                                href="/about/goodies/" rel="nofollow" class="text app-link">采集工具</a><a href="/iwantyou/"
                                                                                                       rel="nofollow"
                                                                                                       class="text pin-link">招聘</a>
                        </div>
                        <div id="category_more" class="middle-module clearfix">
                            <div class="col-1 col"><a href="/favorite/web_app_icon/" rel="nofollow"
                                                      data-id="web_app_icon" class="category-link">UI/UX</a><a
                                    href="/favorite/design/" rel="nofollow" data-id="design"
                                    class="category-link">平面</a><a href="/favorite/illustration/" rel="nofollow"
                                                                   data-id="illustration"
                                                                   class="category-link">插画/漫画</a><a
                                    href="/favorite/home/" rel="nofollow" data-id="home" class="category-link">家居/家装</a><a
                                    href="/favorite/apparel/" rel="nofollow" data-id="apparel" class="category-link">女装/搭配</a>
                            </div>
                            <div class="col-2 col"><a href="/favorite/men/" rel="nofollow" data-id="men"
                                                      class="category-link">男士/风尚</a><a href="/favorite/wedding_events/"
                                                                                        rel="nofollow"
                                                                                        data-id="wedding_events"
                                                                                        class="category-link">婚礼</a><a
                                    href="/favorite/industrial_design/" rel="nofollow" data-id="industrial_design"
                                    class="category-link">工业设计</a><a href="/favorite/photography/" rel="nofollow"
                                                                     data-id="photography"
                                                                     class="category-link">摄影</a><a href="/categories/"
                                                                                                    rel="nofollow"
                                                                                                    data-id="more"
                                                                                                    class="all-categories-link category-link">兴趣/生活
                                »</a></div>
                        </div>
                        <div class="bottom-module clearfix">
                            <div icon="pin-icon" onclick="app.switchHeaderTo('side');return false;"
                                 class="to-side"></div>
                            <div class="links"><a href="/activities/" rel="nofollow">活动</a><span>·</span><a
                                    href="/weekly/" rel="nofollow">周刊</a><span>·</span><a href="/about/" rel="nofollow">关于</a><span>·</span><a
                                    href="/pins/53553/" rel="nofollow">反馈</a><span>·</span><a
                                    href="http://blog.huaban.com/" rel="nofollow" style="margin-right: 0;">博客</a></div>
                            <div class="up-arrow"></div>
                        </div>
                    </div>
                </div>
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
            <div class="pin">
                <a href="#" onclick="showDetail('${pic.id}')"> <img src="/pic/<c:out value="${pic.url}" />"/></a>
                <p class="span-pic-name">${pic.name}</p>
                <p class="span-pic-time"><fmt:formatDate value="${pic.diyTime}" pattern="yyyy-MM-dd"/></p>
            </div>

        </div>
    </c:forEach>
</div>

<div id="pin_view_layer" style="display: none">
    <div class="close-layer" onclick="hideDetail()"><i></i></div>
    <div class="pin-view">
        <div class="pin-view-wrapper">
            <div class="main-part">
                <div class="image-piece piece">
                    <div class="main-image">
                        <div id="baidu_image_holder" class="image-holder"><img
                                src="//img.hb.aicdn.com/8ab6d525f793885f546c84a4311488e5d2b652b699801-7b540V_fw658"
                                width="760"
                                alt="来自相册" data-baiduimageplus-ignore="1"></div>
                    </div>
                    <%--<div class="extra-box"></div>--%>
                </div>
            </div>
            <%--<div style="display: none"--%>
            <%--data-img="//img.hb.aicdn.com/8ab6d525f793885f546c84a4311488e5d2b652b699801-7b540V"--%>
            <%--class="zoom-layer">--%>
            <%--<div class="holder"></div>--%>
            <%--<div class="close-zoom"></div>--%>
            <%--</div>--%>
        </div>
    </div>
</div>


<p id="back-to-top"><a href="#top"><span></span>返回顶部</a></p>


</body>

<script>
    $(function () {
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
                            html += '<div class="cell">';
                            html += '<div  class="pin">';
                            html += '<a href="#"><img src="' + src + '" /></a>';
                            html += '<p class="span-pic-name">' + pics[i].name + '</p>';
                            html += '<p class="span-pic-time">' + new Date(pics[i].diyTime).d_format('yyyy-MM-dd') + '</p>';
                            html += '</div>';
                            html += '</div>';
                        }
                    }
                });
                return $(html);
            },
            column_width: 240,//列宽
            column_space: 20,//列间距
            auto_imgHeight: true,
            insert_type: 1
        }
        $('#waterfall').waterfall(opt);
    });
</script>
</html>
