<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Main</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Arcana</title>
<link
	<c:url value = "href='http://fonts.googleapis.com/css?family=Roboto:400,300,700,500'"/>
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/main.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/project.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/register.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/jquery.mCustomScrollbar.css" />" />
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/project.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery.mCustomScrollbar.concat.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"
	type="text/javascript"></script>

<script src="<c:url value = "/resources/ajax/ajaxChuDe.js"/>"></script>
<script src="<c:url value = "/resources/ajax/ajaxDeThi.js"/>"></script>

<script type="text/javascript">
	$(function() {
		$("#myElem").delay(5000).fadeOut(0);
	});
</script>

<style type="text/css">
#timkiem {
	background-color: #6699ff;
	padding-top: 20px;
}
</style>



</head>
<body style="font-family: 'Source Sans Pro', sans-serif;">
	<input type="hidden" name="taiKhoan" value="${user.ndTaikhoan}">
	
	<div id="form-card-delete" style="display: none">
		<div class="form-header">Xóa đề thi</div>
		<hr />
		<div class="form-body">
			Bạn có chắc chắn muốn xóa đề thi này ? <br /> <b>Chú ý:</b> Đề thi
			đã xóa không thể khôi phục
		</div>
		<button onclick="AjaxXoaDeThi()" class="btn btn-danger btn-block"
			id="btn-card-delete">Đồng ý</button>
	</div>
	
	<div id="edit">
		<div class="form-group">
			<input class="form-id sr-only" type="text" value="" />
			<textarea type="text" class="field form-control" id="ten-ChinhSua"
				style="height: 66px;"></textarea>
		</div>
		<div class="form-group">
			<button class="btn btn-success btn-save">Lưu</button>
			<button type="button" class="close cancel">
				<span aria-hidden="true">&times;</span><span class="sr-only">Đóng</span>
			</button>
		</div>
	</div>

	<!-- LAY THE ID
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="z-index:4000;">
        <div class="modal-dialog" style="width: 700px;">
            <div class="modal-content">
                <div class="modal-header editable">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <div class="modal-title card-title" id="myModalLabel">Tên thẻ</div>
                    <input class="sr-only modal-id" type="text" value="" />
                    
                </div>
            </div>
        </div>
    </div>
-->

	<!-- /. PROFILE -->
	
	<%@ include file="/WEB-INF/views/head-page.jsp"%>

	<div class="container-fluid" style="padding-top: 15px;">
		<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<i class="glyphicon glyphicon-search pull-right"></i>
						<h4>Tìm kiếm</h4>
					</div>
				</div>
				<div class="panel-body">
					<form class="form form-vertical">
						<div class="form-group">
							<div class="controls">
								<input type="text" class="form-control" placeholder="Mã đề">
							</div>
						</div>
						<div class="form-group">

							<div class="controls">
								<input type="text" class="form-control" placeholder="Tên đề thi">
							</div>
						</div>
						<div class="form-group">

							<div class="controls">
								<input type="text" class="form-control" placeholder="Tên môn">
							</div>
						</div>
						<div class="form-group">

							<div class="controls">
								<input type="text" class="form-control" placeholder="Khối">
							</div>
						</div>
						<div class="form-group">

							<div class="controls">
								<input type="text" class="form-control"
									placeholder="Tên người ra đề">
							</div>
						</div>

						<div class="form-group">
							<div class="controls">
								<button type="submit" class="btn btn-primary"
									style="margin-left: 40%;">Tìm kiếm</button>
							</div>
						</div>
					</form>
				</div>
				<!--/panel content-->
			</div>
			<!--/panel-->
		</div>
		<!--   	
    <div class="container-fluid" style="padding-top: 50px">
		<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			<form action="" method="POST" role="form" id='form-search'>
				<legend align="center" id="timkiem">Tìm kiếm</legend>
			
				<div class="form-group">
					<label>Khối</label>
					<select class="form-control" id='khoi' name='khoi' required="required" onchange='search()'>
						<option value='all'>--Tất cả--</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
				</div>
				<div class="form-group">
					<label>Hệ số bài kiểm</label>
					<select id="input" class="form-control" id='heso' name='heso' onchange='search()'>
						<option value='all'>--Tất cả--</option>
						<option value='1'>1</option>
						<option value='2'>2</option>
						<option value='3'>3</option>
					</select>
				</div>
			</form>	
			</div>
<!--			ajax load de thi
			<script type="text/javascript">
			$(function(){
				search();
			});
			function search(){
				$('#kq_tim_dethi').html('<h1>Đang tải</h1>');
				$.ajax({
					type: 'get',
					url: 'timkiem/searchAjax',
					data: $('#form-search').serialize(),
					success: function(data) {
						$('#kq_tim_dethi').html(data);
					},
					error: function () {
						alert("Lỗi kết nối cơ sở dữ liệu.\nHãy thử lại!")
					}
				});
			};
			</script>
-->
		<!--End col 4 -->

		<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9" id="kq_tim_dethi">
			<div class="container">
				<h3 align="center" style="font-family: arial; color: #3b5998;">Danh
					sách đề thi</h3>
				<hr>
				<div id="wrapper">
					<!-- Page Content -->
					<div id="page-content-wrapper">
						<div class="container-fluid">
							<div id="horizoltal-scroll">
								<div class="list-wrapper" id="content-1">
									<c:forEach items="${listChudes}" var="chude">
										<div class="list" style="border: 1px solid #cccccc;" id="chude_${chude.mscd }">
											<div class="list-header editable" >
												<div class="list-id sr-only">${chude.mscd }</div>
												<!-- LIST ID -->
												<div class="list-title">
													<strong>${chude.cdTen }</strong>
												</div>
												<div class="dropdown">
													<div class="dropdown-toggle option" id="ddMenu1"
														data-toggle="dropdown">
														<span class="glyphicon glyphicon-tasks"></span>
													</div>
													<ul class="dropdown-menu" role="menu"
														aria-labelledby="ddMenu1">
														<input class="get-mscd" value="${chude.mscd }" type="hidden">
														<li role="presentation" style="text-align: center;">
															<button class="btn btn-danger btn-block" onclick="AjaxXoaChuDe(${chude.mscd})">Xóa Chủ
																đề</button>
														</li>
													</ul>
												</div>
											</div>
											<hr>
											<div class="form-group">
												<a href="De-Thi.html?mscd=${chude.mscd}"><input type="button" class="form-control btn-primary"
													name="Them chu de" value="Thêm đề thi"></a>
											</div>
											
											<c:forEach items="${listDethis}" var="dethi">
											<c:if test="${dethi.chude.mscd == chude.mscd}">
											<ul class="list-content">
												<li class="list-item" data-toggle="modal"
													data-target="#myModal" id="dethi_${dethi.msdt }">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">${dethi.dtTende }</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">${dethi.dtNgaytaode }</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>

														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="${dethi.msdt }" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
															
															
														</div>
													</div>
												</li>
											</ul>
											</c:if>
											</c:forEach>
										</div>
									</c:forEach>
									<div class="form-group create-list">
										<input type="hidden" name="taiKhoanChuDe" id="taiKhoanChuDe"
											value="${user.ndTaikhoan}"> <input type="text"
											class="form-control" name="tenChuDe" id="tao-tenchude"
											placeholder="Điền tên và bấm enter để thêm chủ đề">
									</div>

								</div>
							</div>
						</div>
						<!-- /#page-content-wrapper -->
					</div>
				</div>

			</div>
			<!--End col 9-->

		</div>
		<!--End container fluid -->
	</div>
</body>
</html>
<script>
    (function ($) {
        $(window).load(function () {
            $(".list-content").mCustomScrollbar({
                theme: "dark-2",
                axis: "y"
            });
            $("#horizoltal-scroll").mCustomScrollbar({
                theme: "dark-3",
                axis: "x",
                scrollInertia: 500
            });
        });
    })(jQuery);
</script>