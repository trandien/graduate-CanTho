<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Thêm đề thi</title>
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery.min.js" />" ></script>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/headPage.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/project.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/ThemDeThi.css" />" />    
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
<body>


	<%@ include file="/WEB-INF/views/head-page.jsp"%>
	<!-- /header-->

	<div id="form-card-delete" style="display: none">
		<div class="form-header">Xóa lớp</div>
		<hr />
		<div class="form-body">
			Bạn có chắc chắn muốn xóa lớp này ? <br />
		</div>
		<button onclick="ajaxXoaThe()" class="btn btn-danger btn-block"
			id="btn-card-delete">Đồng ý</button>
	</div>


	<div class="container" style="margin-top: 15px;">
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-default">
					<div class="panel-heading" style="text-align: center;">Quản
						lý</div>
					<div class="panel-body">
						<div class="tabs-left">
							<ul class="nav nav-stacked tab-left">
								<li class="classLi active text-left" id="thongTinDeThi"><a
									href="#tabThongTinDeThi" data-toggle="tab"><i
										class="glyphicon glyphicon-list-alt">&nbsp</i> Thông tin đề
										thi</a></li>
								<li class="classLi text-left" id="DSThamGiaThi"><a
									href="#tabDSThamGiaThi" data-toggle="tab"><i
										class="glyphicon glyphicon-user">&nbsp</i> Danh sách tham gia
										thi</a></li>
								<li class="classLi text-left" id="DSGiamThi"><a
									href="#tabDSGiamThi" data-toggle="tab"><i
										class="glyphicon glyphicon-user">&nbsp</i> Danh sách giám thị</a></li>
								<li class="classLi text-left" id="noiDungCauHoi"><a
									href="#tabNoiDunCauHoi" data-toggle="tab"><i
										class="glyphicon glyphicon-book">&nbsp</i>Nội dung câu hỏi</a></li>

							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="tab-content">

					<div class="tab-pane fade active in" id="tabThongTinDeThi">
						<%@ include file="/WEB-INF/views/tabthongtindethi.jsp"%>
					</div>
					<!-- end tab-pane fade active in -->

					<div class="tab-pane" id="tabDSThamGiaThi">
						<%@ include file="/WEB-INF/views/tabdanhsachthamgiathi.jsp"%>
					</div>
					<!--Kết thúc tab thêm thí sinh tham gia thi-->

					<!--Bắt đầu tab ds giám thị-->
					<div class="tab-pane" id="tabDSGiamThi">
						<%@ include file="/WEB-INF/views/tabgiamthi.jsp"%>
					</div>
					<!--Kết thúc giám thị-->


				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<!-- end tab pane-->
	</div>
	</div>
	<!-- end col-9-->
	</div>
	</div>
</body>
</html>