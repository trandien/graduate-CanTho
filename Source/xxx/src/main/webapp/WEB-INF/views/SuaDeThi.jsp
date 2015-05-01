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
	href=" <c:url value="/resources/http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
	 <script src="<c:url value = "/resources/ajax/ajaxDeThi.js"/>"></script>

<script src="<c:url value="/resources/js/jquery.min.js" />" ></script>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/headPage.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/project.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/ThemDeThi.css" />" />    
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.mCustomScrollbar.css" />" />

<script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/project.js" />"></script>
<script src="<c:url value="/resources/js/jquery.mCustomScrollbar.concat.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />" type="text/javascript"></script>

<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/froala_editor.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/froala_style.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/tabdethi.css" />"
	rel="stylesheet" type="text/css">

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/froala_editor.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/tables.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/lists.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/colors.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/font_family.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/font_size.min.js" />"></script>
<script
	src="<c:url value="/resources/js/plugins/block_styles.min.js" />"></script>
<script
	src="<c:url value="/resources/js/plugins/media_manager.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/video.min.js" />"></script>
<script
	src="<c:url value="/resources/js/plugins/char_counter.min.js" />"></script>
<script src="<c:url value="/resources/js/tabnoidungcauhoi.js" />"></script>
<script src="<c:url value="/resources/js/modal.js" />" ></script>
<script src="<c:url value="/resources/ajax/ajaxCauHoi.js" />"></script>
<script src="<c:url value="/resources/ajax/ajaxCauTraLoi.js" />"></script>
	   
		<script type="text/javascript">
		     $(document).ready(function() {
	            $('#profile--panel-show').click(function() {
	                    $('.bubble').slideToggle("fast");
	            });
	       });
	    </script>
	    
	    <style type="text/css">
	    	.growlUI h1, .growlUI h2 {
			          color: white; padding: 0px 5px 0px 75px; text-align: left; font-size: 20px;
			     }
			     
			     .input-error-taikhoan {
					color: #a94442;
					border-color: #a94442;
				}
				
				th {
					width: 50px;
				}
				.input-error-taikhoan1 {
					border: 1px solid #a94442;
				}
	    </style>
</head>
<body>


	<%@ include file="/WEB-INF/views/head-page.jsp"%>
	<!-- /header-->
<div id="ketquathemdethi">
	
</div>
<input type="hidden" id="msdt" value="${DeThi.msdt }">
<input type="hidden" id="mscd" value="${DeThi.chude.mscd }">

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
								<li class="classLi text-left" id="diem"><a
									href="#tabdiem" data-toggle="tab"><i
										class="glyphicon glyphicon-file">&nbsp</i>Điểm</a></li>

							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="tab-content">

					<div class="tab-pane fade active in" id="tabThongTinDeThi">
						<%@ include file="/WEB-INF/views/tabSuaThongTinDeThi.jsp"%>
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
					
					<!--Bắt đầu tab đề thi-->
					<div class="tab-pane" id="tabNoiDunCauHoi">
						<%@ include file="/WEB-INF/views/tabnoidungcauhoi.jsp"%>
					</div>
					<!--Kết thúc tab đề thi-->
					
					<div class="tab-pane" id="tabdiem">
						<%@ include file="/WEB-INF/views/tabDiem.jsp"%>
					</div>
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