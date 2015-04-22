<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>TSMain</title>
		<link href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese" rel="stylesheet" type="text/css" />
		
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<script src="<c:url value="/resources/js/jquery.js" />"></script>
		<script src="<c:url value="/resources/js/jquery.min.js" />"></script>

		 
	    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
	    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/headPage.css" />" />
	    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/project.css" />" />
	    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/background.css" />" />

	    	
	     <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.mCustomScrollbar.css" />" />
	    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
	    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
	    <script src="<c:url value="/resources/js/project.js" />" ></script>
	    <script src="<c:url value="/resources/js/jquery.mCustomScrollbar.concat.min.js" />" ></script>
    	<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/ajax/ajaxTrangMatKhauDeThi.js" />" type="text/javascript"></script>
    	<style type="text/css">
			.bubble {
			  position: absolute;
			  width: 380px;
			  height: auto;
			  padding: 0px;
			  background: #2c3e50;
			  -webkit-border-radius: 3px;
			  -moz-border-radius: 3px;
			  border-radius: 3px;
			  border: #7F7F7F solid 1px;
			  right: 80px;
			  top: 10px;
			  z-index: 2000;
			}
			.bubble:after {
			  content: '';
			  position: absolute;
			  border-style: solid;
			  border-width: 11px 0 11px 12px;
			  border-color: transparent #2c3e50;
			  display: block;
			  width: 0;
			  z-index: 1;
			  right: -12px;
			  top: 20px;
			}
			.bubble .avatar {
			  background: #fff;
			  display: block;
			  float: left;
			  height: 128px;
			  width: 128px;
			  padding: 10px;
			}
			.bubble .panel-body {
			  border-bottom: none;
			}
			.bubble .panel-footer {
			  border-top: none;
			  background: #1a242f;
			}
		</style>

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
                    	<img src="<c:url value="/resources/img/user92.png" />" style="width: 50px; height: 50px; float: right; margin-top: 10px; cursor: pointer;" id="profile--panel-show">
                    </div>	
            </div>
            <!-- .row -->
        </div>
        <!-- /.container-fluid -->
    </header>

    <div class="bubble" style="display: none;">
		<div class="panel-body">
			<div class="avatar">
				<img src="<c:url value="/resources/img/user91.png" />" class="img-responsive">
			</div>
			<div style="display: inline-block; color: white; padding-left: 20px;">
				<div id="bubble-name" style="font-size: 24px;">Trần Thanh Điền</div>
				<div>tranthanhdien@gmail.com</div>

				<hr>
				<div style="padding-left: 10px;">
					<a href="Thong-Tin-Ca-Nhan-Page.htm">Xem thông tin cá nhân</a>
				</div>
			</div>
		</div>
		<div class="panel-footer text-right">
			<a class="btn btn-primary" href="Dang-Nhap-Page.htm">Đăng xuất</a>
		</div>
	</div>
	<input type="hidden" id='msdt' value='${DeThi.msdt }'>
	<div class="form-group" style="text-align: center;">
			<h3>${DeThi.dtTende }</h3>
			<span>Thời gian: ${DeThi.dtThoigianlambai}</span><br>
			<span>Môn: ${DeThi.monhoc.mhTen }</span><br>
			<span><strong>Lưu ý: ${DeThi.dtDando }</strong></span>
		</div>
		<hr>
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-lg-3 col-xs-12">
					
				</div>
				<div class="col-md-6 col-lg-6 col-xs-12">
					<div class="form-group">
						<label for="input" class="col-sm-3 control-label">Mật khẩu đề thi:</label>
						<div class="col-sm-9">
							<input type="password" name="" id="inputMatKhauDeThi" class="form-control" required="required" title="">
						</div>
						
					</div>
					
					<div class="form-group" style="text-align: center; margin-top: 70px;">
						<button class="btn btn-primary" id="KiemTraMatKhauInputDeThi" onclick="CheckPassTest()">Bắt đầu kiểm tra</button>
					</div>
				</div>
				<div class="col-md-3 col-lg-3 col-xs-12">
					<div id="thongbao_nhapmatkhaudethi"></div>
				</div>
			</div>
		</div>
		

	</body>
</html>