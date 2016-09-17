<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/jquery/jquery.datetimepicker.css" rel="stylesheet">

    <script src="<%=request.getContextPath() %>/jquery/jquery-1.7.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/jquery/jquery.form.js"></script>
    <script src="<%=request.getContextPath() %>/jquery/jquery.datetimepicker.js"></script>
    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">

        $(function () {
            $('#diyTimeInput').datetimepicker();
        });

        function showAlert(msg, type) {
            if (type == 'success') {
                $("#successAlertStrong").html(msg);
                $('#successAlert').show();
            }
            if (type == "warning") {
                $("#warningAlertStrong").html(msg);
                $('#warningAlert').show();
            }
            setTimeout(function () {
                $(".alert").hide();
            }, 1000);
        }

        function uploadFile() {
            $("#fileForm").ajaxSubmit({
                type: 'post',
                url: '/manage/upload',
                data: '',
                success: function (data) {
                    res = $.trim(data);
                    res = eval('(' + res + ')');
                    $('#newImage').attr("src", "/pic/" + res.data);
                    $('#newImage').show();
                    $('#urlInput').attr("value", res.data);
                }, error: function () {
                    alert("图片上传失败");
                }
            });
        }

        function add() {
            var url = $('#urlInput').attr("value");
            if (url == null || url == '') {
                showAlert("请先上传图片吧", "warning");
                return;
            }
            $("#addForm").ajaxSubmit({
                type: 'post',
                url: '/manage/add',
                data: '',
                success: function (data) {
                    showAlert("成功啦", "success");
                }, error: function (data) {
                    showAlert("失败啦", "success");
                }
            });
        }

        function gotoMindex() {
            window.location.href = "<%=request.getContextPath() %>/manage";
        }

    </script>
</head>


<body>
<br>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">

            <div id="successAlert" class="alert alert-success alert-dismissable" hidden="hidden"
                 style="text-align: center">
                <strong id="successAlertStrong" style="text-align: center">success!</strong>
            </div>

            <div id="warningAlert" class="alert alert-warning alert-dismissable" hidden="hidden"
                 style="text-align: center">
                <strong id="warningAlertStrong"></strong>
            </div>

            <button type="button" class="btn btn-success btn-sm active btn-block" onclick="gotoMindex()">返回首页</button>
            <br>

            <form role="form" action="/manage/add" method="post" id="addForm">
                <input id="urlInput" name="url" hidden="hidden">
                <div class="form-group">
                    <label for="nameInput">名称</label>
                    <input type="text" name="name" class="form-control" id="nameInput"/>
                </div>
                <div class="form-group">
                    <label for="remarkInput">备注</label>
                    <input type="text" name="remark" class="form-control" id="remarkInput"/>
                </div>

                <div class="form-group">
                    <label for="categorySelect">类别</label>
                    <select class="form-control" name="category" id="categorySelect">
                        <c:forEach var="category" items="${categories}">
                            <option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="subCategorySelect">子类别</label>
                    <select class="form-control" name="subCategory" id="subCategorySelect">
                        <c:forEach var="subCategory" items="${subCategories}">
                            <option value="<c:out value="${subCategory.id}"/>"><c:out
                                    value="${subCategory.name}"/></option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="diyTimeInput">创作时间</label>
                    <input type="text" name="diyTimeStr" class="form-control" id="diyTimeInput"/>
                </div>

            </form>

            <form id="fileForm" action="/manage/upload" method="post" enctype="multipart/form-data">
                <input type="file" id="picFileInput" name="pic"/>
                <br>
                <button type="button" class="btn btn-success active btn-sm" onclick="uploadFile()">上传</button>
            </form>

            <div class="form-group" style="text-align: center">
                <button type="button" class="btn btn-success active btn-default" onclick="add()">提交</button>
            </div>

            <div style="text-align:center;"><img id="newImage" width="1150" class="img-thumbnail" style="display: none">
            </div>
            <br>
        </div>
    </div>
</div>

</body>

</html>