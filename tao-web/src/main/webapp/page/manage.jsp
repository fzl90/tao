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

    <script  src="js/jquery/jquery-1.7.2.min.js"></script>
    <script src="js/jquery/jquery.form.js"></script>
    <script  src="js/jquery/jquery-datePicker.js"></script>

    <script type="text/javascript">

        function uploadFile(){
            $("#fileForm").ajaxSubmit({
                type:'post',
                url:'/manage/upload',
                data:'',
                success:function (data) {
                    res = $.trim(data);
                    res = eval('(' + res + ')');
                    $('#newImage').attr("src", "/pic/"+res.data);
                    $('#urlInput').attr("value", res.data);
                }, error:function () {
                    alert("图片上传失败")
                }
            });
        }


    </script>
</head>
<body>

    <form id="fileForm" action="/manage/upload" method="post" enctype="multipart/form-data" >

        请选择要上传的文件

        <input type="file" name="pic" >
    </form>
    <input type="button" onclick="uploadFile()" value="上传"/>

    <form id="addForm" action="/manage/add" method="post" >

        <input id="urlInput" name="url" hidden="hidden">
        名称:<input id="nameInput" name="name" ><br>
        备注:<input id="remarkInput" name="remark" ><br>
        <input type="submit" value="提交">
    </form>
    <div style="text-align:center;"><img id="newImage" width="1200"></div>

</body>
</html>
