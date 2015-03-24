<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Đăng nhập Arcane</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/login.css" />" />
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"
	type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$("#myElem").delay(5000).fadeOut(0);
	});
</script>
</head>

<body>
	<c:if test="${not empty thanhCong}">
		<div id="myElem">
			<div class="alert alert-success text-center"
				style="width: 50%; margin: auto;">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				${thanhCong}
			</div>
		</div>
	</c:if>

	<c:if test="${not empty thatBai}">
		<div>
			<div class="alert alert-warning text-center"
				style="width: 50%; margin: auto;">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				${thatBai}
			</div>
		</div>
	</c:if>

	<c:if test="${not empty loiCode}">
		<div>
			<div class="alert alert-warning text-center"
				style="width: 50%; margin: auto;">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				${loiCode}
			</div>
		</div>
	</c:if>

	<div class="container">
		<div class="login-header">
			<div class="login-title">
				<div>Anki</div>
				<em style="font-weight: 300; font-size: 20px;">Website tạo và
					thi trắc nghiệm</em>
			</div>
		</div>
		<form action="DoiMatKhau" method="post" class="form-horizontal"
			role="form" id="changepassword">
			<p style="font-size: 20px; font-weight: 500; margin-bottom: 20px;">Bạn
				vui lòng nhập mật khẩu mới</p>

			<div class="form-group" style="margin-bottom: 10px;">
				<div class="col-md-12">
					<input type="password" name="matKhau" id="matKhau"
						class="form-control" placeholder="Mật khẩu mới">
					<div id="thongbao_matkhau"
						style="color: #a94442; font-size: 85%; padding-top: 5px;"></div>
				</div>
			</div>
			<div class="form-group" style="margin-bottom: 10px;">
				<div class="col-md-12">

					<input type="password" name="nhacLaiMatKhau" id="nhacLaiMatKhau"
						class="form-control" placeholder="Nhắc lại mật khẩu mới">

					<div id="thongbao_nhaclaimatkhau"
						style="color: #a94442; font-size: 85%; padding-top: 5px;"></div>
				</div>
			</div>

			<div class="form-group" style="margin-bottom: 20px;">
				<div class="col-md-12">
					<div class="checkbox" style="float: left;">
						<a style="font-size: 14px; cursor: pointer;" href="Dang-Nhap.html">Quay
							về trang đăng nhập</a>
					</div>
					<button class="btn btn-lg btn-primary" type="submit"
						disabled="true" id="doimatkhau" style="float: right;">Đổi
						mật khẩu</button>
				</div>
			</div>
		</form>

	</div>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		$("#matKhau").keyup(function() {
			var matKhau = $(this).val();
			var result = $("#thongbao_matkhau");
			if (matKhau.length < 6) {
				result.html('<span style="color: red">Mật khẩu phải từ 6 ký tự trở lên</span>');
				$("#doimatkhau").prop("disabled", true);
			} else {
					result.html('');
				}
	});

		$("#nhacLaiMatKhau").keyup(function() {
				var matKhau = $('#matKhau').val();
				var nhacLaiMatKhau = $(this).val();
				var result = $("#thongbao_nhaclaimatkhau");
				if (matKhau != nhacLaiMatKhau) {
						result.html('Mật khẩu không khớp');
						$("#doimatkhau").prop("disabled", true);
					} else if (matKhau == nhacLaiMatKhau && matKhau.length >= 6) {
							result.html('');
							$("#doimatkhau").prop("disabled", false);
						}
		});
	});
</script>

</html>
