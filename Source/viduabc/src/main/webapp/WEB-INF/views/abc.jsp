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
	href="<c:url value="/resources/custom/headPage.css" />" />
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
<style type="text/css">
#timkiem {
	background-color: #6699ff;
	padding-top: 20px;
}

/* fast nav */
</style>

<script type="text/javascript">
	$(document).ready(function() {
	    $('#profile--panel-show').click(function() {
	         $('.bubble').slideToggle("fast");
	     });
	    });		    
</script>

</head>
<body style="font-family: 'Source Sans Pro', sans-serif;">

	<div id="form-card-delete" style="display: none">
		<div class="form-header">Xóa đề thi</div>
		<hr />
		<div class="form-body">
			Bạn có chắc chắn muốn xóa đề thi này ? <br /> <b>Chú ý:</b> Đề thi
			đã xóa không thể khôi phục
		</div>
		<button onclick="ajaxXoaThe()" class="btn btn-danger btn-block"
			id="btn-card-delete">Đồng ý</button>
	</div>

	<form id="edit">
		<div class="form-group">
			<input class="form-id sr-only" type="text" value="" />
			<textarea type="text" class="field form-control"
				style="height: 66px;"></textarea>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-success btn-save">Lưu</button>
			<button type="button" class="close cancel">
				<span aria-hidden="true">&times;</span><span class="sr-only">Đóng</span>
			</button>
		</div>
	</form>

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

	<header class="navbar navbar-menu header--menu" role="navigation">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-lg-6 col-xs-6">  
                    <a class="logo-anki" href="home.html"></a>     
                </div>	
                    <div class="col-md-6 col-lg-6 col-xs-6">
                    	<img src="<c:url value="${user.avatar }" />" style="width: 50px; height: 50px; float: right; margin-top: 10px; cursor: pointer;" id="profile--panel-show">
                    </div>	
            </div>
            <!-- .row -->
        </div>
        <!-- /.container-fluid -->
    </header>

	<!-- /. PROFILE -->
	
	<div class="bubble" style="display: none;">
		<div class="panel-body">
			<div class="avatar" >
				<img src="${user.avatar }" class="img-responsive" style="width: 108px; height: 108px;">
			</div>
			<div style="display: inline-block; color: white; padding-left: 20px;">
				<div id="bubble-name" style="font-size: 24px;">${user.hoTen }</div>
				<div>${user.taiKhoan }</div>

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
	
	<!-- /. PROFILE -->

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
								<div class="col-xs-12">
									<div class="list-wrapper" id="content-1">
										<div class="list">
											<div class="list-header editable">
												<div class="list-id sr-only">1</div>
												<!-- LIST ID -->
												<div class="list-title">Nhóm I</div>
												<div class="dropdown">
													<div class="dropdown-toggle option" id="ddMenu1"
														data-toggle="dropdown">
														<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
													</div>
													<ul class="dropdown-menu" role="menu"
														aria-labelledby="ddMenu1">
														<li role="presentation" class="dropdown-header"></li>
														<li role="presentation" class="divider"></li>

														<li role="presentation" class="divider"></li>
														<li role="presentation" style="text-align: center;">
															<button class="btn btn-danger btn-block">Xóa
																nhóm</button>
														</li>
													</ul>
												</div>
											</div>
											<ul class="list-content">
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>

											</ul>
											
										</div>

										<div class="list">
											<div class="list-header editable">
												<div class="list-id sr-only">1</div>
												<!-- LIST ID -->
												<div class="list-title">Nhóm II</div>
												<div class="dropdown">
													<div class="dropdown-toggle option" id="ddMenu1"
														data-toggle="dropdown">
														<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
													</div>
													<ul class="dropdown-menu" role="menu"
														aria-labelledby="ddMenu1">
														<li role="presentation" class="dropdown-header">Xóa
															nhóm</li>
														<li role="presentation" class="divider"></li>

														<li role="presentation" class="divider"></li>
														<li role="presentation" style="text-align: center;">
															<button class="btn btn-danger btn-block">Xóa
																nhóm</button>
														</li>
													</ul>
												</div>
											</div>
											<ul class="list-content">
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>
												<li class="list-item" data-toggle="modal"
													data-target="#myModal">
													<div class="list-item-id sr-only">1</div>
													<div class="list-item-title">AAAAAA</div>
													<div class="list-item-info">
														<div class="badge-deadline new">
															<div class="deadline-text">16/10/2014</div>
														</div>
														<div class="badge-done">
															<i class="flaticon-list"></i>
															<div class="done-text">2/5</div>
														</div>
														&nbsp;
														<div class="card-delete">
															<input class="list-item-id" value="35" type="hidden">
															<span class="glyphicon glyphicon-trash"
																aria-hidden="true"></span>
														</div>
													</div>
												</li>

											</ul>
											
										</div>
										<form:form role="form" action="ThemChuDe" method="POST" >
											<div class="form-group create-list">
												<input type="text" class="form-control" name="tenChuDe"
													placeholder="Điền tên và bấm enter để thêm chủ đề">
											</div>
										</form:form>
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