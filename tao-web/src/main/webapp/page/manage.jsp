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
    <title>nanuku管理页面</title>
    <link rel="shortcut icon" href="/favicon.ico"/>
    <link rel="bookmark" href="/favicon.ico"/>
</head>
<body>

    <form action="/manage/upload" method="post" enctype="multipart/form-data">


        请选择要上传的文件

        <input type="file" name="pic" >
        <input type="submit" value="提交">
    </form>
    <div style="text-align:center;"><img width="1200"  src="WechatIMG1.jpeg"></div>

</body>
</html>
