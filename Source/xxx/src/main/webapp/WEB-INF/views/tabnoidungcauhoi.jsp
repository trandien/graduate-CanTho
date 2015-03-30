<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/froala_editor.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/froala_style.min.css" />"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/tabdethi.css" />"
	rel="stylesheet" type="text/css">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
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
<script src="<c:url value="/resources/ajax/ajaxCauHoi.js" />"></script>
<style type="text/css">
.input-error-taikhoan {
	color: #a94442;
	border-color: #a94442;
}

.input-error-taikhoan1 {
	border: 1px solid #a94442;
}
</style>
</head>
<body>
<input name="mscd" id="mscd" value="${mscd }" hidden>
	<div class="panel panel-default">
		<div class="panel-heading"
			style="text-align: center; font-size: 20px;">
			<i class="glyphicon glyphicon-book">&nbsp</i> <strong> Nội
				dung câu hỏi </strong>
		</div>
		<div class="panel-body">
			<div
				style="height: 100%; min-height: 100%; width: 100%; margin-left: 10px;">
				<div style="height: 100%; min-height: 100%; width: 100%;">
					<div class="container-fluid">
						<div class="soluongcauhoi">
							<br> <span>Số lượng câu hỏi</span>
							<hr>
							<span class="caukho">1</span> <span class="cautrungbinh">2</span>
							<span class="caude">3</span> <span class="caukho">4</span> <span
								class="caukho">5</span> <span class="caukho">6</span> <span
								class="cautrungbinh">7</span> <span class="cautrungbinh">8</span>
							<span class="caude">9</span>
							<div id="themsoluongcauhoi"></div>
							<hr>
							<span>Số câu dễ: &nbsp;</span><input id="socaude" value='2'
								disabled="true"
								style="border: 0px; width: 50px; background-color: white;"><br>
							<span>Số câu trung bình:&nbsp;</span><input id="socautrungbinh"
								value='3' disabled="true"
								style="border: 0px; width: 50px; background-color: white;"><br>
							<span>Số câu khó:&nbsp;</span><input id="socaukho" value='4'
								disabled="true"
								style="border: 0px; width: 50px; background-color: white;"><br>
								
						</div>

						<div class="form-group" style="text-align: center;">
							<button type="button" class="btn btn-primary"  onClick="TaoCauHoi()">
								Thêm câu hỏi &nbsp;<span class="glyphicon glyphicon-plus"></span>
							</button>
						</div>

						<div class="noidungcauhoi">
							<br> <span id="idnoidungcauhoi">Nội dung câu hỏi</span>
							<hr>
<!--Them cau hoi-->
							<div id="themcauhoi"
								style="border: 1px solid #000077; margin-bottom: 15px;">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-2 col-sm-2 col-lg-2 col-xs-2">
<!-- Ajax-->							
										<div id="tencauhoi"></div>
											<div class="form-group">
												<div class="radio">
													<label> <input type="radio" name="dokho2"
														id="doKho" value="3" checked="checked"> <span
														id="idmucdode">Dễ</span>
													</label><br> <label> <input type="radio" name="dokho2"
														id="doKho" value="2"> <span
														id="idmucdotrungbinh">Trung bình</span>
													</label><br> <label> <input type="radio" name="dokho2"
														id="doKho" value="1"> <span
														id="idmucdokho">Khó</span>
													</label>

												</div>
											</div>

										</div>

										<div class="col-md-10 col-sm-10 col-lg-10 col-xs-10">
											<div class="form-group">
												<div class="radio">
													<label> <input type="radio" name="dangcauhoi"
														id="dangCauHoi" value="1" checked="checked">
														Chọn câu đúng nhất &nbsp; &nbsp;&nbsp;
													</label> <label> <input type="radio" name="dangcauhoi"
														id="dangCauHoi" value="2"> Chọn nhiều câu
														đúng &nbsp; &nbsp;&nbsp;
													</label> <label> <input type="radio" name="dangcauhoi"
														id="dangCauHoi" value="3"> Điền vào chổ trống
													</label>
												</div>
											</div>
											<div class="form-group">
												<span>Điểm cho câu hỏi này là:</span><input type="text"
													class="form-control" name="diemChoCauHoi1"
													id="diemChoCauHoi1" style="width: 100px;">
												<div id="thongbao_loinhapdiem"></div>
											</div>
<!-- editor  --><div id="hienthicuahoi"></div>
											<section id="editor" style="width: 95%;">
											<textarea id='edit2'
												style="margin-top: 30px; margin-bottom: 10px; display: none;"></textarea>
											</section>
											
											<section id="buttons"> 
											<button class="btn btn-primary" style="margin-top: 7px; margin-bottom: 30px;" 
												id="luu-cau-hoi" onclick="LuuCauHoi()" >Lưu </button>
<!-- Vừa bỏ onclick="LuuCauHoi()" -->
<!-- Sử dụng action thêm câu hỏi -->		
											<button id="xong-cau-hoi" style="margin-top: 7px; margin-bottom: 30px;" hidden>Xong </button>
											<button id="sua-cau-hoi" style="margin-top: 7px; margin-bottom: 30px;" hidden > Sửa</button>
<!--											
<button id="xoa-cau-hoi" style="margin-top: 7px; margin-bottom: 30px;" data-toggle="modal" href='#modal-id' hidden>Xóa</button>
  -->											
											</section>
											
										</div>
										<br>
<!-- Id Thêm câu trả lời -->
										<div id="themcautraloi">
											<div class="cautraloi" style="padding-top: 15px; text-align: center">

									<table class="table table-hover">
										<thead>
	<!-- Cau tra loi -->					<span style="text-align: center; font-family: Calibri, serif; font-size: 14pt;">
												<strong >Câu trả lời</strong>
											</span>
										</thead>
										<tbody style="text-align: left;">
											<tr>
												<td>
													<div id="sttcautraloi"></div>
													<input id="laysothutucautraloi" type="hidden" value="64">
												</td>
												<td><section id="editor" style="width: 95%;">
											<div id='editorcautraloi'
												style="margin-top: 30px; margin-bottom: 10px;"></div>
											</section></td>
												<td>
													<section id="buttons"> 
														<input type="button" value="Xong" class="btn btn-success" id="sua-cau-tra-loi" onclick="LuuCauTraLoi()"> 
														<input type="button" value="Sửa" id="sua-cau-tra-loi-xong" hidden> 
													</section>
												</td>
												<td>
													<input type="button" value="Hủy" class="btn btn-danger" id="xoa-cau-tra-loi">
												</td>
											</tr>
											<div id="kq-themcautraloi"></div>
										</tbody>
									</table>
								<hr>

							</div>
										</div>
										<div class="form-group" id="idthemcautraloi">
											<button class="btn btn-success" id="them-cau-tra-loi" onclick="ThemCauTraLoi()">
<!-- btn them ctl -->					Thêm câu trả lời &nbsp;<span class="glyphicon glyphicon-plus"></span>
											</button>
										</div>
										<div id="form-group" class="pull-right" style="margin-bottom: 15px;">
											<button class="btn btn-primary">Hoàn thành &nbsp;<span class="glyphicon glyphicon-ok"></span></button>
											<button class="btn btn-danger" id="huy-cau-hoi" data-toggle="modal" href='#modal-id'>Hủy &nbsp;<span class="glyphicon glyphicon-remove"></span></button>
										</div>
									</div>
								</div>
							</div>
<!-- Ket thuc Them cau hoi-->
					</div>
				</div>
			</div>
</div>
		</div>
	</div>
	</div>
	</div>
	</div>


	<div class="modal fade" id="modal-id">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Thông báo</h4>
				</div>
				<div class="modal-body">
					Bạn muốn hủy thêm câu hỏi.<br> Lưu ý: khi xóa không thể
					khôi phục lại được
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
					<button type="button" class="btn btn-primary">Đồng ý</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</body>
</html>