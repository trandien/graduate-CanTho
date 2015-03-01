<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Forget password</title>

<link rel="stylesheet" type="text/css"
	href=" <c:url value = "/resources/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/custom/login.css"/>" />
<script src="<c:url value = "/resources/js/jquery-1.11.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrapValidator.min.js" />"></script>
<link href="<c:url value="/resources/css/bootstrapValidator.min.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/register.js" />"></script>
</head>

<body>
	<div class="container">
		<div class="login-header">
			<div class="login-title">
				<div>Anki</div>
				<em style="font-weight: 300; font-size: 20px;">Website tạo và
					thi trắc nghiệm</em>
			</div>
		</div>
		<form class="form-horizontal" role="form" id="form-dang-ky" style="max-width: 500px;">
			<p style="font-size: 20px; font-weight: 500;">Bạn đã quên mật
				khẩu ?</p>
			<p style="font-size: 14px;">Hãy điền email bạn đã đăng ký và
				chúng tôi sẽ gửi cho bạn email chứa mật khẩu mới</p>
			<div class="form-group"
					style="margin-left: 0px; margin-right: 0px; margin-bottom: 0px; padding-bottom: 15px;">
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-envelope"></span></span> <input type="email"
							name="email" id="email" class="form-control input-lg"
							required="required" placeholder="Email" data-bv-notempty="true"
							data-bv-notempty-message="Email phải khác rỗng"
							data-bv-emailaddress="true"
							data-bv-emailaddress-message="Email nhập chưa chính xác">
					</div>
				</div>
			<div class="form-group" style="margin-bottom: 20px;">
				<div class="col-md-12">
					<div class="checkbox" style="float: left;">
						<a style="font-size: 14px; cursor: pointer;" href="login.html">Quay
							về trang đăng nhập</a>
					</div>
					<button class="btn btn-lg btn-primary" type="submit"
						style="float: right;">Gửi email</button>
				</div>
			</div>
		</form>
	</div>
</body>

</html>
