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

<style type="text/css">
#timkiem {
	background-color: #6699ff;
	padding-top: 20px;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:active {
	text-decoration: none;
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

	<%@ include file="/WEB-INF/views/head-page.jsp"%>

	<div class="container-fluid" style="padding-top: 15px;">
		<div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
			<div class="panel panel-default">
				<div class="panel-heading" style="text-align: center;">
					<strong>Quản lý chung</strong>
				</div>
				<div class="panel-body">
					<div class="tabs-left">
						<ul class="nav nav-stacked tab-left">
							<li class="classLi active text-left" id="tabDSDeThi"><a
								href="#dethi" data-toggle="tab"> Đề thi của bạn</a></li>

							<li class="classLi text-left" id="tabGacThi"><a
								href="#gacthi" data-toggle="tab">Lịch gác thi</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10" id="kq_tim_dethi">

			<div class="tab-content">
				<div class="tab-pane fade active in" id="dethi">
						<div class="panel-body">
							<div class="tab-content">

								<h4 align="center" style="font-family: arial; color: #3b5998;">Danh
									sách đề thi</h4>
								<hr>
								<div id="wrapper">
									<!-- Page Content -->
									<div id="page-content-wrapper">
										<div class="container-fluid">
											<div id="horizoltal-scroll">
												<div class="list-wrapper" id="content-1">
													<c:forEach items="${listChudes}" var="chude">
														<div class="list" style="border: 1px solid #cccccc;"
															id="chude_${chude.mscd }">
															<div class="list-header editable">
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
																		<input class="get-mscd" value="${chude.mscd }"
																			type="hidden">
																		<li role="presentation" style="text-align: center;">
																			<button class="btn btn-danger btn-block"
																				onclick="AjaxXoaChuDe(${chude.mscd})">Xóa
																				Chủ đề</button>
																		</li>
																	</ul>
																</div>
															</div>
															<hr>
															<div class="form-group">
																<a href="De-Thi.html?mscd=${chude.mscd}"><input
																	type="button" class="form-control btn-primary"
																	name="Them chu de" value="Thêm đề thi"></a>
															</div>
															<ul class="list-content">
																<c:forEach items="${listDethis}" var="dethi">
																	<c:if test="${dethi.chude.mscd == chude.mscd}">


																		<li class="list-item" data-toggle="modal"
																			data-target="#myModal" id="dethi_${dethi.msdt }">
																			<a href="Thong-tin-de-thi.html?msdt=${dethi.msdt }"
																			style="margin-top: 10px">
																				<div class="list-item-id sr-only">1</div>
																				<div class="list-item-title">${dethi.dtTende }</div>
																		</a>
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
																					<input class="list-item-id" value="${dethi.msdt }"
																						type="hidden"> <span
																						class="glyphicon glyphicon-trash"
																						aria-hidden="true"></span>
																				</div>
																			</div>
																		</li>


																	</c:if>
																</c:forEach>
															</ul>
														</div>
													</c:forEach>
													<div class="form-group create-list">
														<input type="hidden" name="taiKhoanChuDe"
															id="taiKhoanChuDe" value="${user.ndTaikhoan}"> <input
															type="text" class="form-control" name="tenChuDe"
															id="tao-tenchude"
															placeholder="Điền tên và bấm enter để thêm chủ đề">
													</div>

												</div>
											</div>
										</div>
										<!-- /#page-content-wrapper -->
									</div>
								</div>
							</div>
						</div>
				</div>
				<!-- end tab-pane fade active in -->

				<div class="tab-pane" id="gacthi">
					<div class="panel panel-default">
						<div class="panel-heading"
							style="text-align: center; font-size: 20px;">
							<strong>Lịch gác thi </strong>
						</div>
						<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Phòng</th>
									<th>Ngày gác</th>
									<th>Giờ bắt đầu</th>
									<th>Giờ kết thúc</th>
									<th>Môn thi</th>
									<th>Giáo viên ra đề</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Phòng 1</td>
									<td>20/02/2015</td>
									<td>15:30</td>
									<td>16:30</td>
									<td>Vật Lý</td>
									<td>Trần Hữu Tính</td>
								</tr>
							</tbody>
						</table>
						</div>
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