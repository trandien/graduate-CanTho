<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Anki</title>
<link
	<c:url value = "href='http://fonts.googleapis.com/css?family=Roboto:400,300,700,500'"/>
	rel="stylesheet" type="text/css">

	<link rel="stylesheet" type="text/css"
		href=" <c:url value = "/resources/css/bootstrap.css"/>" />
	<link rel="stylesheet" type="text/css"
		href="<c:url value = "/resources/custom/register.css"/>" />
	<script src="<c:url value = "/resources/js/jquery-1.11.1.min.js" />"
		type="text/javascript"></script>
	<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"
		type="text/javascript"></script>
</head>

<body>

	<header class="navbar navbar-default navbar-fixed-top"
		role="navigation">
	<div class="container">
		<div class="row">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><h3>Anki</h3></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse pull-right" id="navbar-collapse">
				<a class="btn btn-default btn-login" href="login.jsp">Đăng nhập</a>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- .row -->
	</div>
	<!-- /.container-fluid --> </header>

	<div class="container" style="padding-top: 160px;">
		<div class="intro">
			<form class="form-horizontal col-lg-5 col-sm-5 col-xs-12" role="form"
				style="padding-top: 90px; padding-bottom: 0px;">
				<h4>Nếu bạn muốn tạo hoặc tham gia thi trắc nghiệm</h4>
				<h4>Đây sẽ là sự lựa chọn thích hợp</h4>
				<div class="form-group"
					style="margin-left: 0px; margin-right: 0px; margin-bottom: 0px;">
					<label for="hoTen">Họ tên</label>
					<div class="form-group" id="inp_hoten"
						style="margin-left: 0px; margin-right: 0px; margin-bottom: 5px;">
						<input type="text" id="hoTen" class="form-control"> <span
							id="icon_hoten"
							class="sr-only glyphicon glyphicon-ok form-control-feedback"></span>
					</div>
					<div id="thongbao_hoten"></div>
				</div>
				<div class="form-group"
					style="margin-left: 0px; margin-right: 0px; margin-bottom: 0px;">
					<label for="taiKhoan">Email</label>
					<div class="form-group" id="inp_taikhoan"
						style="margin-left: 0px; margin-right: 0px; margin-bottom: 5px;">
						<input type="text" id="taiKhoan" class="form-control"> <span
							id="icon_taikhoan"
							class="sr-only glyphicon glyphicon-ok form-control-feedback"></span>
					</div>
					<div id="thongbao_taikhoan"></div>
				</div>

				<div class="form-group" style="margin-left: 0px; margin-right: 0px;">
					<button class="btn btn-default pull-right btn-green"
						onclick="ajaxDangKy()">Tạo tài khoản Anki</button>
				</div>


			</form>
			<div
				class="carousel-container pull-right col-lg-7 col-sm-7 col-xs-12">
				<div id="carousel-example-generic" class="carousel slide row"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="<c:url value = "/resources/img/Giao-dien-kehoach.png"/>" >
						</div>
						<div class="item">
							<img src="<c:url value = "/resources/img/Giao-dien-lamviec.png"/>" >
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>
		<hr />
		<div class="benefit">
			<div class="row">
				<div class="col-sm-4 col-md-4">
					<div class="thumbnail">
						<img data-src="holder.js/300x300" src="<c:url value = "/resources/img/nhanhchong.png"/>"
							width="128" height="128">
							<div class="caption">
								<h3>Củng cố kiến thức</h3>
							</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="thumbnail">
						<img data-src="holder.js/300x300" src="<c:url value = "/resources/img/clock.png" />"width="128"
							height="128">
							<div class="caption">
								<h3>Tiết kiệm thời gian</h3>
							</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-4">
					<div class="thumbnail">
						<img data-src="holder.js/300x300" src="<c:url value = "/resources/img/vitinh.png"/>" width="128"
							height="128">
							<div class="caption">
								<h3>Chấm điểm tự động</h3>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	
	function ajaxDangKy(){
	if($("#taiKhoan").val().length == 0){
		$("#thongbao_taikhoan").text("");
		$("#thongbao_taikhoan").text("Xin vui lÃ²ng Äiá»n email.");
		$("#icon_taikhoan").removeClass("glyphicon-ok");
		$("#icon_taikhoan").removeClass("sr-only");
		$("#icon_taikhoan").addClass("glyphicon-warning-sign");
		$("#inp_taikhoan").addClass("has-error has-feedback");
		$("#taiKhoan").focus();
		return;
	}
	
	if($("#hoTen").val().length == 0){
		$("#thongbao_hoten").text("");
		$("#thongbao_hoten").text("Xin vui lÃ²ng Äiá»n há» tÃªn.");
		$("#icon_hoten").removeClass("glyphicon-ok");
		$("#icon_hoten").removeClass("sr-only");
		$("#icon_hoten").addClass("glyphicon-warning-sign");
		$("#inp_hoten").addClass("has-error has-feedback");
		$("#hoTen").focus();
		return;
	}
	
	$.ajax({
		data: "HoTen=" + $("#hoTen").val() + "&TaiKhoan=" + $("#taiKhoan").val(),
		type: "POST",
		url : "AjaxGuiMatKhau",
		success : function(result) {
			if(result.length == 0)
			{
				window.location.href = "/controller/Dang-Nhap-Page.htm";				
			}
			else
			{
				$("#thongbao").text("");
				$("#thongbao").text(result);
				$("#icon_taikhoan").removeClass("glyphicon-ok");
				$("#icon_taikhoan").removeClass("sr-only");
				$("#icon_taikhoan").addClass("glyphicon-warning-sign");
				$("#inp_taikhoan").addClass("has-error has-feedback");
				$("#taiKhoan").focus();
			}
		},
		error : function() {
			//alert("ERROR");
		}
	});
}
</script>
</html>