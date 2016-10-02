<%--
  Created by IntelliJ IDEA.
  User: fzl
  Date: 16/5/11
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>nanuku</title>
    <link href="http://localhost:8080/favicon.ico" rel="SHORTCUT ICON">

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js_css/pb.css"/>


    <script src="<%=request.getContextPath() %>/jquery/jquery-1.7.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/js_css/pb.js"></script>


    <script type="text/javascript">

        var pageIndex = 0;
        window.onload = function () {
            //运行瀑布流主函数
            PBL('wrap', 'box');
            //模拟数据
            var data = [
                {'src': '1.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '2.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '3.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '4.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '5.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '6.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '7.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '8.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '9.jpg', 'title': '素材家园-sucaijiayuan.com'},
                {'src': '10.jpg', 'title': '素材家园-sucaijiayuan.com'}
            ];

            //设置滚动加载
            window.onscroll = function () {
                //校验数据请求
                if (getCheck()) {
                    $.get('/pics', {
                        pageNum: 10,
                        pageIndex: pageIndex
                    }, function (data) {
                        res = $.trim(data);
                        res = eval('(' + res + ')');
                        var pics = res.data;
                        var wrap = document.getElementById('wrap');
                        for (var i = 0; i < pics.length; i++) {
                            //创建box
                            var box = document.createElement('div');
                            box.className = 'box';
                            wrap.appendChild(box);
                            //创建info
                            var info = document.createElement('div');
                            info.className = 'info';
                            box.appendChild(info);
                            //创建pic
                            var pic = document.createElement('div');
                            pic.className = 'pic';
                            info.appendChild(pic);
                            //创建img
                            var img = document.createElement('img');
                            img.src = '/pic/' + pics[i].url;
                            img.style.height = 'auto';
                            pic.appendChild(img);
                            //创建title
                            var title = document.createElement('div');
                            title.className = 'title';
                            info.appendChild(title);
                            //创建a标记
                            var a = document.createElement('a');
                            a.innerHTML = pics[i].name;
                            title.appendChild(a);
                        }
                        PBL('wrap', 'box');
                        pageIndex = pageIndex + 1;
                    });
                }
            }


        }
    </script>


</head>
<body>
<div id="wrap">

    <div class="box">
        <div class="info">
            <div class="pic"><img src="images/1.jpg"></div>
            <div class="title"><a href="http://www.sucaijiayuan.com">素材家园-sucaijiayuan.com</a></div>
        </div>
    </div>

    <div class="box">
        <div class="info">
            <div class="pic"><img src="images/2.jpg"></div>
            <div class="title"><a href="http://www.sucaijiayuan.com">素材家园-sucaijiayuan.com</a></div>
        </div>
    </div>

    <div class="box">
        <div class="info">
            <div class="pic"><img src="images/3.jpg"></div>
            <div class="title"><a href="http://www.sucaijiayuan.com">素材家园-sucaijiayuan.com</a></div>
        </div>
    </div>

    <div class="box">
        <div class="info">
            <div class="pic"><img src="images/4.jpg"></div>
            <div class="title"><a href="http://www.sucaijiayuan.com">素材家园-sucaijiayuan.com</a></div>
        </div>
    </div>

    <div class="box">
        <div class="info">
            <div class="pic"><img src="images/5.jpg"></div>
            <div class="title"><a href="http://www.sucaijiayuan.com">素材家园-sucaijiayuan.com</a></div>
        </div>
    </div>

    <div class="box">
        <div class="info">
            <div class="pic"><img src="images/6.jpg"></div>
            <div class="title"><a href="http://www.sucaijiayuan.com">素材家园-sucaijiayuan.com</a></div>
        </div>
    </div>

</div>

</body>
</html>
