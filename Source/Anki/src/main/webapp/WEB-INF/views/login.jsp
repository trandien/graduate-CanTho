<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Đăng nhập Anki</title>

<link rel="stylesheet" type="text/css"
	href=" <c:url value = "/resources/css/bootstrap.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/custom/login.css"/>" />
<script src="<c:url value = "/resources/js/jquery-1.11.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value = "/resources/js/bootstrap.min.js"/>"
	type="text/javascript"></script>

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
		<form class="form-horizontal" role="form">
			<div class="form-group" style="margin-bottom: 10px;">
				<div class="col-md-12">
					<input class="form-control input-lg" placeholder="Email" autofocus />
				</div>
			</div>
			<div class="form-group" style="margin-bottom: 22px;">
				<div class="col-md-12">
					<input type="password" class="form-control input-lg"
						placeholder="Mật khẩu" />
				</div>
			</div>
			<div class="form-group" style="margin-bottom: 20px;">
				<div class="col-md-12">
					<div class="checkbox" style="float: left;">
						<label> <input type="checkbox">Ghi nhớ
						</label>
					</div>
					<button class="btn btn-lg btn-primary" type="submit"
						style="float: right;">Đăng nhập</button>
				</div>
			</div>
			<div class="form-group" style="margin-bottom: 0px;">
				<div class="col-md-12">
					<a href="forget-password.jsp">Bạn đã quên mật khẩu ?</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>
