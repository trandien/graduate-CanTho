<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Danh sách thí sinh tham gia thi</title>
		<link href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese" rel="stylesheet" type="text/css" />
		
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<script src="<c:url value="/resources/js/jquery.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>

		 
	    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
	    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/headPage.css" />" />
	    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/project.css" />" />
	    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/DSThiSinhThi.css" />" />
		
	    	
	      <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.mCustomScrollbar.css" />" />
	    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
	    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
	    <script src="<c:url value="/resources/js/project.js" />"></script>
	    <script src="<c:url value="/resources/js/jquery.mCustomScrollbar.concat.min.js" />"></script>
    	<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />" type="text/javascript"></script>

		<style type="text/css">
			
		</style>

		<script type="text/javascript">
		     $(document).ready(function() {
	            $('#profile--panel-show').click(function() {
	                    $('.bubble').slideToggle("fast");
	            });
	       });
		    
	    </script>
	</head>
	<body style="font-family: 'Calibri', sans-serif; font-size: 18px;">
	<header class="navbar navbar-menu header--menu" role="navigation">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-lg-6 col-xs-6">  
                    <a class="logo-anki" href="home.html"></a>     
                </div>	
                    <div class="col-md-6 col-lg-6 col-xs-6">
                    	<img src="img/user92.png" style="width: 50px; height: 50px; float: right; margin-top: 10px; cursor: pointer;" id="profile--panel-show">
                    </div>	
            </div>
            <!-- .row -->
        </div>
        <!-- /.container-fluid -->
    </header>

    <div class="bubble" style="display: none;">
		<div class="panel-body">
			<div class="avatar">
				<img src="img/user91.png" class="img-responsive">
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
	<!-- /header-->
	<h3 align="center" style="color: #3b5998;"><strong>Danh sách thí sinh tham gia thi</strong></h3>
		<div class="container">
			<table class="table table-bordered table-hover" style="margin-top: 20px; align: center; ">
				<thead>
					<tr>
						<th>STT</th>
						<th>Họ tên</th>
						<th>Có mặt</th>
						<th>Lớp</th>
						<th>Điểm</th>
						<th>Khóa bài thi</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${hocSinhThi }" var="thisinh">
					<tr>
						<td>1</td>
						<td>${thisinh.ndHoten }</td>
						<td width="100px;"> <div id='comat'></div></td>
						<td>${thisinh.lop.msl }</td>
						<td>0</td>
						<td width="200px;">
							<div class="onoffswitch">
							    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="${thisinh.ndTaikhoan }" checked>
							    <label class="onoffswitch-label" for="${thisinh.ndTaikhoan }">
							        <span class="onoffswitch-inner"></span>
							        <span class="onoffswitch-switch"></span>
							    </label>
							</div>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>