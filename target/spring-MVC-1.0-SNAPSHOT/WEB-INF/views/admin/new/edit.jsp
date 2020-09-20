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
                    <form class="form-horizontal" role="form" id="formAddOrUpdateNew">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên bài viết</label>
                            <div class="col-sm-9">
                                <input type="text" id="title" name="title" class="col-xs-10 col-sm-5" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="categoryCode" class="col-sm-3 control-label no-padding-right">Thể loại bài
                                :</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="categoryCode" name="categoryCode">
                                    <option value="VH">Văn Hóa</option>
                                    <option value="TH">Toán học</option>
                                    <option value="XH">Xã hội</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Ảnh đại diện</label>
                            <div class="col-sm-9">
                                <input type="file" id="thumbnail" name="thumbnail" class="col-xs-10 col-sm-5"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="shortDescription" class="col-sm-3 control-label no-padding-right">Mô tả:</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" rows="5" cols="10" id="shortDescription" name="shortDescription"></textarea>
                            </div>

                        </div>
                        <div class="form-group">
                            <label for="content" class="col-sm-3 control-label no-padding-right">Nội dung:</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" rows="10" cols="20" id="content" name="content"></textarea>
                            </div>

                        </div>
                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
                                    <i class="ace-icon fa fa-check bigger-110"></i>
                                    Thêm bài viết
                                </button>

                                &nbsp; &nbsp; &nbsp;
                                <button class="btn" type="reset">
                                    <i class="ace-icon fa fa-undo bigger-110"></i>
                                    Hủy
                                </button>
                            </div>
                        </div>

                    </form>
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
