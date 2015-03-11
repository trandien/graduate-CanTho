<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Anki</title>

<link rel="stylesheet" type="text/css"
	href=" <c:url value = "/resources/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/custom/login.css"/>" />
<script src="<c:url value = "/resources/js/jquery-1.11.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrapValidator.min.js" />"></script>
<link href="<c:url value="/resources/css/bootstrapValidator.min.css" />"
	rel="stylesheet">
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
		<form action="XacThuc" method="post" class="form-horizontal"
			role="form" id="form-dang-ky" style="max-width: 500px;">

			<!--Warning tai khoan va mat khau sai -------------------------------------------------------------- -->
			<c:if test="${not empty error }">
				<div class="alert alert-danger">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					${error }
				</div>
			</c:if>

			<div class="form-group"
				style="margin-left: 0px; margin-right: 0px; margin-bottom: 0px; padding-bottom: 15px;">
				<div class="input-group">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-user"></span></span> <input type="text"
						name="taiKhoan" id="taiKhoan" class="form-control input-lg"
						placeholder="Tài khoản" data-bv-notempty="true"
						data-bv-notempty-message="Tài khoản phải khác rỗng"
						data-bv-stringlength="true" data-bv-stringlength-min="6"
						data-bv-stringlength-max="20"
						data-bv-stringlength-message="Tài khoản phải ít nhất là 6 ký tự và nhiều nhất là 20 ký tự">
				</div>
				
			
			</div>
			<div class="form-group"
				style="margin-left: 0px; margin-right: 0px; margin-bottom: 0px; padding-bottom: 15px; ">
				<div class="input-group" style="padding-bottom: 10px;">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-lock"></span></span> <input type="text"
						name="matKhau" id="matKhau" class="form-control input-lg"
						placeholder="Mật Khẩu" data-bv-notempty="true"
						data-bv-notempty-message="Mật khẩu phải khác rỗng"
						data-bv-stringlength="true" data-bv-stringlength-min="6"
						data-bv-stringlength-max="20"
						data-bv-stringlength-message="Mật khẩu phải ít nhất là 6 ký tự và nhiều nhất là 20 ký tự">
				</div>
				
				
			</div>

			<div class="form-group" style="margin-bottom: 20px;">
				<div class="col-md-12">
					<div class="checkbox" style="float: left;">
						<label> <input type="checkbox">Ghi nhớ </label>
					</div>
					<button class="btn btn-lg btn-primary" type="submit"
						style="float: right;">Đăng nhập</button>
				</div>
			</div>
			<div class="form-group" style="margin-bottom: 0px;">
				<div class="col-md-12">
					<a href="forget-password.html">Bạn đã quên mật khẩu ?</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>
