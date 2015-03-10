<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Arcana</title>
</head><link
	<c:url value = "href='http://fonts.googleapis.com/css?family=Roboto:400,300,700,500'"/>
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/profile.css" />" />
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/profile.js" />"
	type="text/javascript"></script>
</head>

<body>
	<div id="wrapper">
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row" style="margin-left: -35px; margin-right: -35px;">

				</div>
				<form action="SuaThongTin" method="POST"  >
					<div class="row profile-container" style="padding-top: 40px;">

						<div class="profile-base" style="padding-bottom: 20px;">
							<div class="logoImg "
								style="width: 110px; height: 110px; border: 3px solid #2c3e50;">
								<div onclick="showDialog()"
									style="height: 100px; width: 100px; padding: 0px; margin: 2px; cursor: pointer; z-index: 9;">
									<c:if test="${empty user.avatar}">
										<img name="avatar" id="uploadPreview"
											src="<c:url value="/resources/img/user91.png" />"
											style="height: 100px; width: 100px;">
									</c:if>

									<c:if test="${not empty user.avatar}">
										<img name="avatar" id="uploadPreview" src="${user.avatar}"
											style="height: 100px; width: 100px;">
									</c:if>


									<div class="hoverImg"
										style="z-index: 10; color: #fff; background: rgba(34, 85, 85, 0); position: relative; top: -70px; margin-top: 35px; padding-top: 5px; padding-bottom: 10px;">
										<i class="glyphicon glyphicon-camera" style="color:;"></i> <span
											style="font-size: 10px; padding-left: 5px;">Ảnh đại
											diện</span>

									</div>
								</div>
								<input type="hidden" name="file" id="fileString" /> <input
									type="file" style="display: none;" id="uploadImageId" />
							</div>


							<div id="profile-basic"
								style="margin-left: 50px; margin-top: 15px;">
								<div id="profile-name">${user.hoTen }</div>

							</div>
						</div>

						<div class="form-horizontal active tab-pane"
							id="profile-form-info">
							<div class="form-group">
								<label for="profile-name-edit"
									class="col-sm-4 col-lg-4 control-label">Tài khoản</label>
								<div class="col-sm-8 col-lg-8">
									<input name="taiKhoan" class="form-control"
										id="profile-name-edit" type="text" placeholder="Tài khoản"
										value="${user.taiKhoan}" disabled />
								</div>
							</div>
						
							<div class="form-group">
								<label for="profile-email-edit"
									class="col-sm-4 col-lg-4 control-label">Email</label>
								<div class="col-sm-8 col-lg-8">
									<input name="taiKhoan" value="${user.email}"
										class="form-control" id="profile-email-edit" type="text"
										disabled>
								</div>
							</div>

							<hr />
							<div class="form-group">
								<label for="old-pass" class="col-sm-4 col-lg-4 control-label">Mật
									khẩu cũ</label>
								<div class="col-sm-8 col-lg-8">
									<input name="matKhauCu" class="form-control" id="old-pass"
										type="password" placeholder="Mật khẩu cũ">
								</div>
							</div>
							<div class="form-group">
								<label for="new-pass" class="col-sm-4 col-lg-4 control-label">Mật
									khẩu mới</label>
								<div class="col-sm-8 col-lg-8">
									<input name="matKhauMoi" class="form-control" id="new-pass"
										type="password" placeholder="Mật khẩu mới">
								</div>
							</div>
							<div class="form-group">
								<label for="repeat-new-pass"
									class="col-sm-4 col-lg-4 control-label">Nhập lại mật
									khẩu mới</label>
								<div class="col-sm-8 col-lg-8">
									<input name="nhacLaiMatKhauMoi" class="form-control"
										id="repeat-new-pass" type="password"
										placeholder="Nhập lại mật khẩu mới">
								</div>
							</div>
							<input type="submit" class="btn btn-primary" value="Lưu thông tin" />
							
						</div>

					</div>
				</form>
			</div>
		</div>
		<!-- /#page-content-wrapper -->
	</div>
</body>
<script>


	function Validate() {
		var image = document.getElementById("image").value;
		if (image != '') {
			var checkimg = image.toLowerCase();
			if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
				alert("Bạn vui lòng chọn ảnh có phần mở rộng là : .jpg,.png,.jpeg");
				document.getElementById("image").focus();
				return false;
			}
		}
		return true;
	}

	function showDialog() {
		$("#uploadImageId").click();
	}
	$(document).ready(function() {
		$(".logoImg").hover(function() {
			$(".hoverImg").css('background', 'rgba(34, 85, 85, 0.8)');
		}, function() {
			$(".hoverImg").css('background', 'rgba(34, 85, 85, 0.3)')
		});
	});
	$("#uploadImageId")
			.change(
					function(evt) {
						var oFReader = new FileReader();
						oFReader.readAsDataURL(document
								.getElementById("uploadImageId").files[0]);

						oFReader.onload = function(oFREvent) {
							document.getElementById("uploadPreview").src = oFREvent.target.result;
						};
					});
</script>

</html>