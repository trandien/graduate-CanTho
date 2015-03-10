<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Arcana</title>
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/headPage.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/register.css" />" />

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>

<script src="<c:url value="/resources/js/bootstrapValidator.min.js" />"></script>
<link href="<c:url value="/resources/css/bootstrapValidator.min.css" />" rel="stylesheet">

<script src="<c:url value="/resources/js/register.js" />"></script>

<style>
	.input-error-taikhoan{
		color: #a94442;
		border-color: #a94442;
		background-color: #f2dede;
	}
</style>

</head>


<body>

	<!-- start head page-->
	<!-- Collect the nav links, forms, and other content for toggling -->

	<!-- end head page-->

	<header class="navbar navbar-menu navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="row">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="logo-anki" href="home.html"></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			
			<!-- /.navbar-collapse -->
		</div>
		<!-- .row -->
	</div>
	<!-- /.container-fluid --> </header>


	<div class="container" style="padding-top: 160px;">
		<div class="intro">
			<form action="XacThuc" method="POST" class="form-horizontal col-lg-5 col-sm-5 col-md-5" role="form"
				style="padding-top: 90px; padding-bottom: 0px;" id="form-dang-ky">
				<h4>Nếu bạn muốn tạo hoặc tham gia thi trắc nghiệm</h4>
				<h4>Đây sẽ là một sự lựa chọn thích hợp</h4>
				<div class="form-group"
					style="margin-left: 0px; margin-right: 0px; margin-bottom: 0px;">
					<div class="input-group">
						<span class="input-group-addon" id="icon-taikhoan" ><span
							class="glyphicon glyphicon-user"></span></span> <input type="text"
							name="taiKhoan" id="taiKhoanDangKy" class="form-control input-lg"
							placeholder="Tài khoản" data-bv-notempty="true"
							data-bv-notempty-message="Tài khoản phải khác rỗng"
							data-bv-stringlength="true" data-bv-stringlength-min="6"
							data-bv-stringlength-max="20"
							data-bv-stringlength-message="Tài khoản phải ít nhất là 6 ký tự và nhiều nhất là 20 ký tự">
				
					</div>
					<div style="color: #a94442; font-size: 85%; padding-top: 5px;">
						<div id="thongbao_taikhoan" style="padding-bottom: 15px;"></div>
					</div>
					
				</div>
				<div class="form-group"
					style="margin-left: 0px; margin-right: 0px; margin-bottom: 0px;">
					<div class="input-group">
						<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                          <input type="password" name="matKhau" id="matKhau" class="form-control input-lg"  placeholder="Mật khẩu" 
                            data-bv-notempty="true"
                            data-bv-notempty-message="Tài khoản phải khác rỗng"
                            data-bv-stringlength="true"
                            data-bv-stringlength-min="6"
                            data-bv-stringlength-max="20"
                            data-bv-stringlength-message="Tài khoản phải ít nhất là 6 ký tự và nhiều nhất là 20 ký tự">
					</div>
					<div style="color: #a94442;font-size: 85%;padding-top: 5px;">
 						<div id="thongbao_email"></div>
					</div>
					
				</div>
				<div style="margin-top: 10px;">
                    <a href="Quen-Mat-Khau.html">Bạn đã quên mật khẩu?</a>
                </div>
				<div class="form-group" style="margin-left: 0px; margin-right: 0px;">
					<input id="btn-tao-tai-khoan" type="submit" class="btn btn-default pull-right btn-green"
						 value="Đăng nhập"/>
				</div>


			</form>
			<div class="carousel-container pull-right col-lg-7 col-md-7 col-sm-7">
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
							<img src="<c:url value="/resources/img/Giao-dien-kehoach.png" /> ">
						</div>
						<div class="item">
							<img src="<c:url value="/resources/img/Giao-dien-lamviec.png" /> ">
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
				<div class="col-lg-4 col-sm-4 col-md-4 col-xs-12">
					<div class="thumbnail">
						<img data-src="holder.js/300x300"
							src="<c:url value="/resources/img/nhanhchong.png" />" width="128"
							height="128">
						<div class="caption">
							<h3>Củng cố kiến thức</h3>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-4 col-md-4 col-xs-12">
					<div class="thumbnail">
						<img data-src="holder.js/300x300"
							src="<c:url value="/resources/img/clock.png" />" width="128" height="128">
						<div class="caption">
							<h3>Tiết kiệm thời gian</h3>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-4 col-md-4 col-xs-12">
					<div class="thumbnail">
						<img data-src="holder.js/300x300"
							src="<c:url value="/resources/img/vitinh.png"/>" width="128" height="128">
						<div class="caption">
							<h3>Chấm điểm tự động</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
<script type="text/javascript">
	
	
	$(document).ready(function(){
		$('#taiKhoanDangKy').keyup(function(){
	        var Username = $(this).val(); 
	        var UsernameAvailResult = $('#thongbao_taikhoan'); 
	            $.ajax({
	            type : 'POST',
	            data : "TaiKhoan=" + $("#taiKhoanDangKy").val(),
	            url  : 'AjaxCheckExistTaiKhoan',
	            success: function(responseText){
	                 if(responseText.length > 0){
	                    UsernameAvailResult.html('Tài khoản đã có người sử dụng');
	                    $("#btn-tao-tai-khoan").prop("disabled", true);
	                    $("#taiKhoanDangKy").css("color", "a94442")
	                }
	                else{
	                	 UsernameAvailResult.html('');
	                }
	            }
	            });
	      
	    });
		
		
		$("#emailDangKy").keyup(function(){
			var email = $(this).val();
			var EmailAvailResult = $('#thongbao_email'); 
			$.ajax({
				type: 'POST',
				data: "Email=" + $("#emailDangKy").val(),
				url: "AjaxCheckExistEmail",
				success: function (result) {
					if(result.length > 0) {
						EmailAvailResult.html('Email đã có người dùng');
						$("#btn-tao-tai-khoan").prop("disabled", true);
					} else {
						EmailAvailResult.html('');
					}
				}
			});
			
		});
	
		$("#btn-tao-tai-khoan").click(function(){
			
		});
		
	});
/*	
	function ajaxDangKy(){
		var email = $("#emailDangKy").val();
		var taiKhoan = $("#taiKhoanDangKy").val();
		
	    $.ajax({
	        data: "Email=" + email + "&TaiKhoan=" + taiKhoan,
	        type: "POST",
	        url : "AjaxDangKy",
	        success : function(result) {
	        	if(result.length > 0) {
	        		window.location.href = "/Anki/Dang-Nhap.html";	
	        	} else {
	        		window.location.href = "/Anki/Dang-Nhap.html";
	        	}
	        },
	        error : function() {
	        	window.location.href = "/Anki/Dang-Nhap.html";
	        }
	    });
	}
*/

function ajaxDangKy(){
	$.ajax({
		data: "TaiKhoan=" + $("#taiKhoanDangKy").val() + "&Email=" + $("#email").val(),
		type: "POST",
		url : "AjaxGuiMatKhau",
		success : function(result) {
			if(result.length > 0)
			{
				window.location.href = "/Anki/Dang-Nhap.html";				
			}
			else
			{
				$("#thongbao_taikhoan").html("Da duoc su dung");
				
				$("#taiKhoanDangKy").focus();
			}
		},
		error : function() {
			alert("ERROR");
		}
	});
}


</script>
</html>