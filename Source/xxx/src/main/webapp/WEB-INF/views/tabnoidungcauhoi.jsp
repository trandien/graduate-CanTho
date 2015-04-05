<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/froala_editor.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/froala_style.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/tabdethi.css" />"
	rel="stylesheet" type="text/css">
	
<script src="<c:url value="/resources/js/froala_editor.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/tables.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/lists.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/colors.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/font_family.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/font_size.min.js" />"></script>
<script
	src="<c:url value="/resources/js/plugins/block_styles.min.js" />"></script>
<script
	src="<c:url value="/resources/js/plugins/media_manager.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/video.min.js" />"></script>
<script
	src="<c:url value="/resources/js/plugins/char_counter.min.js" />"></script>
<script src="<c:url value="/resources/js/tabnoidungcauhoi.js" />"></script>
<script src="<c:url value="/resources/ajax/ajaxCauHoi.js" />"></script>
<script src="<c:url value="/resources/ajax/ajaxCauTraLoi.js" />"></script>
<style type="text/css">
.input-error-taikhoan {
	color: #a94442;
	border-color: #a94442;
}

th {
	width: 50px;
}
.input-error-taikhoan1 {
	border: 1px solid #a94442;
}
</style>
</head>
<body>
<input name="mscd" id="mscd" value="${mscd }" hidden>
	<div class="panel panel-default">
		<div class="panel-heading"
			style="text-align: center; font-size: 20px;">
			<i class="glyphicon glyphicon-book">&nbsp</i> <strong> Nội
				dung câu hỏi </strong>
		</div>
		<div class="panel-body">
			<div
				style="height: 100%; min-height: 100%; width: 100%; margin-left: 10px;">
				<div style="height: 100%; min-height: 100%; width: 100%;">
					<div class="container-fluid">
						<div class="soluongcauhoi">
							<br> <span>Số lượng câu hỏi</span>
							<hr>
							<span class="caukho">1</span> <span class="cautrungbinh">2</span>
							<span class="caude">3</span> <span class="caukho">4</span> <span
								class="caukho">5</span> <span class="caukho">6</span> <span
								class="cautrungbinh">7</span> <span class="cautrungbinh">8</span>
							<span class="caude">9</span>
							<div id="themsoluongcauhoi"></div>
							<hr>
							<span>Số câu dễ: &nbsp;</span><input id="socaude" value='2'
								disabled="true"
								style="border: 0px; width: 50px; background-color: white;"><br>
							<span>Số câu trung bình:&nbsp;</span><input id="socautrungbinh"
								value='3' disabled="true"
								style="border: 0px; width: 50px; background-color: white;"><br>
							<span>Số câu khó:&nbsp;</span><input id="socaukho" value='4'
								disabled="true"
								style="border: 0px; width: 50px; background-color: white;"><br>
								
						</div>

						<div class="form-group" style="text-align: center;">
							<button type="button" class="btn btn-primary" id='them-cau-hoi' onClick="TaoCauHoi()">
								Thêm câu hỏi &nbsp;<span class="glyphicon glyphicon-plus"></span>
							</button>
						</div>

						<div class="noidungcauhoi" id='noidungcauhoi'>
							<br> <span id="idnoidungcauhoi">Nội dung câu hỏi</span>
							<hr>
							
<!--Them cau hoi-->
							
<!-- Ket thuc Them cau hoi-->
					</div>
				</div>
			</div>
</div>
		</div>
	</div>



	<div class="modal fade" id="modal-id">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Thông báo</h4>
				</div>
				<div class="modal-body">
					Bạn muốn hủy thêm câu hỏi.<br> Lưu ý: khi xóa không thể
					khôi phục lại được
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
					<button type="button" class="btn btn-primary">Đồng ý</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</body>
</html>