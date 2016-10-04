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

        function editPic() {
            $("#editForm").ajaxSubmit({
                type: 'post',
                url: '/manage/edit',
                data: '',
                success: function (data) {
                    var res = eval('(' + $.trim(data) + ')');
                    if(res.code == 200){
                        showAlert("成功啦", "success");
                    }else{
                        showAlert(res.msg, "warning");
                    }
                }, error: function (data) {
                    showAlert("失败啦", "success");
                }
            });
        }

        function gotoMindex() {
            window.location.href = "<%=request.getContextPath() %>/manage";
        }

        function categorySelectChange() {
            var category = $("#categorySelect").val();
            $.get('/manage/subCategories', {
                category: category
            }, function (data) {
                var res = eval('(' + $.trim(data) + ')');
                var subCategories = res.data;
                var h = "";
                if (subCategories != null && subCategories.length > 0) {
                    for (var i = 0; i < subCategories.length; i++) {
                        h += "<option value='" + subCategories[i].id + "'>" + subCategories[i].name + "</option>";
                    }
                }
                $("#subCategorySelect").html(h);
            });
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

            <form role="form" action="/manage/edit" method="post" id="editForm">
                <input hidden="hidden" name="id" value="<c:out value="${pic.id}"/>">
                <div class="form-group">
                    <label for="nameInput">名称</label>
                    <input type="text" name="name" class="form-control" id="nameInput"
                           value="<c:out value="${pic.name}"/>"/>
                </div>
                <div class="form-group">
                    <label for="remarkInput">备注</label>
                    <input type="text" name="remark" class="form-control" id="remarkInput"
                           value="<c:out value="${pic.remark}"/>"/>
                </div>

                <div class="form-group">
                    <label for="categorySelect">类别</label>
                    <select class="form-control" name="category" id="categorySelect" onchange="categorySelectChange()">
                        <c:forEach var="category" items="${categories}">
                            <option value="<c:out value="${category.id}"/>" <c:if test="${pic.category == category.id}"> selected="selected"</c:if> ><c:out value="${category.name}"/></option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="subCategorySelect">子类别</label>
                    <select class="form-control" name="subCategory" id="subCategorySelect">
                        <c:forEach var="subCategory" items="${subCategories}">
                            <option value="<c:out value="${subCategory.id}"/>" <c:if test="${pic.subCategory == subCategory.id}"> selected="selected"</c:if> ><c:out
                                    value="${subCategory.name}"/></option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="diyTimeInput">创作时间</label>
                    <input type="text" name="diyTimeStr" class="form-control" id="diyTimeInput"
                           value="<c:out value="${pic.diyTimeStr}"/>"/>
                </div>

            </form>

            <div class="form-group" style="text-align: center">
                <button type="button" class="btn btn-success active btn-default" onclick="editPic()">提交</button>
            </div>

            <div style="text-align:center;"><img id="newImage" width="1150" class="img-thumbnail"
                                                 src="/pic/<c:out value="${pic.url}"/>"></div>
            <br>
        </div>
    </div>
</div>

</body>

</html>