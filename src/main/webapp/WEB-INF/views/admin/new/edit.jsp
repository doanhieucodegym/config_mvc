<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <form:form class="form-horizontal" role="form" id="formAddOrUpdateNew" modelAttribute="model">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên bài viết</label>
                            <div class="col-sm-9">
                               <form:input path="title" class="col-xs-10 col-sm-5"></form:input>
<%--                                <input type="text" id="title" name="title" value="${model.title}"  />--%>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể loại bài
                                :</label>
                            <div class="col-sm-9">
<%--                                <select class="form-control" id="categoryCode" name="categoryCode">--%>
<%--                                    <option value="">Chọn thể loại</option>--%>
<%--                                    <c:forEach var="item" items="${category}">--%>
<%--                                        <option value="${item.code}">${item.name}</option>--%>
<%--                                    </c:forEach>--%>
<%--                                </select>--%>
                                <form:select path="categoryCode" id ="categoryCode">
                                    <form:option value="" label="--Chon the loại---"></form:option>
                                    <form:options items="${category}"></form:options>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Ảnh đại diện</label>
                            <div class="col-sm-9">
                                <input type="file" id="thumbnail" name="thumbnail" value="${model.thumbnail}" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="shortDescription" class="col-sm-3 control-label no-padding-right">Mô tả:</label>
                            <div class="col-sm-9">
                                <form:textarea path="shortDescription" class="col-xs-10 col-sm-5" rows="10" cols="10" id="shortDescription"></form:textarea>
                            </div>

                        </div>
                        <div class="form-group">
                            <label for="content" class="col-sm-3 control-label no-padding-right">Nội dung:</label>
                            <div class="col-sm-9">
                                <form:textarea path="content" cols="10" rows="10" class="col-xs-10 col-sm-5" id="content"></form:textarea>
                            </div>

                        </div>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <c:if test="${not empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                       Cập nhật bài viết
                                    </button>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                       Thêm bài viết
                                    </button>
                                </c:if>
                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Hủy
                                </button>
                            </div>
                        </div>

                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('#btnAddOrUpdateNew').click(function (e) {

        // var content =$('#content').val();
        // var shortDescription = $('#shortDescription').val();
        // var title = $('#title').val();
        // cách này dung thủ công ta sử dụng cách công nghiệp hơn dùng serializeArray()
        e.preventDefault();
        var formData = $('#formAddOrUpdateNew').serializeArray();
        console.log(formData);
    });
</script>
</body>
</html>
