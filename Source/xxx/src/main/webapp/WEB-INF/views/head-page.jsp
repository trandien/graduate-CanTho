<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/headPage.css" />" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
	    $('#profile--panel-show').click(function() {
	         $('.bubble').slideToggle("fast");
	     });
	    });		    
</script>
</head>
<body>

	<header class="navbar navbar-menu header--menu" role="navigation">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 col-lg-6 col-xs-6">
				<a class="logo-anki" href="home.html"></a>
			</div>
			<div class="col-md-6 col-lg-6 col-xs-6">
				<img src="<c:url value="${user.ndAvatar }" />"
					style="width: 50px; height: 50px; float: right; margin-top: 10px; cursor: pointer;"
					id="profile--panel-show">
			</div>
		</div>
		<!-- .row -->
	</div>
	<!-- /.container-fluid --> </header>

	<!-- /. PROFILE -->

	<div class="bubble" style="display: none;">
		<div class="panel-body">
			<div class="avatar">
				<img src="${user.ndAvatar }" class="img-responsive"
					style="width: 108px; height: 108px;">
			</div>
			<div style="display: inline-block; color: white; padding-left: 20px;">
				<div id="bubble-name" style="font-size: 24px;">${user.ndHoten }</div>
				<div>${user.ndTaikhoan }</div>

				<hr>
				<div style="padding-left: 10px;">
					<a href="Thong-Tin-Ca-Nhan.html">Xem thông tin cá nhân</a>
				</div>
			</div>
		</div>
		<div class="panel-footer text-right">
			<a class="btn btn-primary" href="DangXuat">Đăng xuất</a>
		</div>
	</div>

</body>
</html>