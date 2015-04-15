<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<title>Thêm đề thi</title>
<script src="<c:url value = "/resources/ajax/ajaxDeThi.js"/>"></script>
<script src="<c:url value = "/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/css/bootstrap.css" />"/>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
 <script src="<c:url value="/resources/js/jquery.blockUI.js" />"></script>

<style type="text/css">
	.empty-input{
		border: 1px solid red;
	}
	
</style>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading"
			style="text-align: center; font-size: 20px;">
			<i class="glyphicon glyphicon-list-alt"></i> &nbsp <strong>Thông
				tin đề thi </strong>
				
		</div>
		<div class="panel-body">
			<table class="table table-hover">

				<tbody>
					<tr>
						<!--Tên đề-->
						<td>Tên đề</td>
						<td><input id="tenDe" class="form-control" type="text"
							name="tenDe" placeholder="Tên đề thi">
							<div id="thongbao_tende"></div>	
						</td>
						<td></td>
					</tr>

					<tr>
						<!--Loại đề-->
						<td>Niên khóa</td>
						<td><select name="nienKhoan" id="nienKhoan"
							class="form-control" required="required" style="width: 50%;">
								<c:forEach items="${listNienKhoa}" var="NienKhoa">
									<option value="${NienKhoa.msnk}">${NienKhoa.nkTen}</option>
								</c:forEach>
						</select></td>
						<td></td>
					</tr>

					<tr>
						<!--Loại đề-->
						<td>Học kỳ</td>
						<td><select name="hocKy" id="hocKy" class="form-control"
							required="required" style="width: 50%;">
								<option value="1">I</option>
								<option value="2">II</option>
								<option value="3">III</option>
						</select></td>
						<td></td>
					</tr>

					<tr>
						<!--Chủ đề-->
						<td>Chủ đề</td>
						<td><select name="chuDe" id="chuDe" class="form-control"
							required="required" style="width: 50%;">
								<c:forEach items="${listChude }" var="ChuDe">
									<c:choose>
										<c:when test="${ChuDe.mscd == mscd}">
											<option selected="selected" value="${ChuDe.mscd}">${ChuDe.cdTen}</option>
										</c:when>
										<c:otherwise>
											<option value="${ChuDe.mscd }">${ChuDe.cdTen}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
						<td></td>
					</tr>

					<tr>
						<!--Môn học-->
						<td>Môn học</td>
						<td><select name="monHoc" id="monHoc" class="form-control"
							required="required" style="width: 50%;">
								<c:forEach items="${listMonHoc}" var="MonHoc">
									<option value="${MonHoc.msmh}">${MonHoc.mhTen}</option>
								</c:forEach>
						</select></td>
						<td></td>
					</tr>

					<tr>
						<!--Hệ số-->
						<td>Hệ số</td>
						<td><select name="heSo" id="heSo" class="form-control"
							required="required" style="width: 50%;">
								<c:forEach items="${listDangThi}" var="DangThi">
									<option value="${DangThi.msdangthi}">${DangThi.dtTen}</option>
								</c:forEach>
						</select></td>
						<td></td>
					</tr>

					<tr>
						<!--Trạng thái-->
						<td>Trạng thái</td>
						<td>
							<div class="radio">
								<label> <input type="radio" name="trangThai"
									id="trangThai" checked="checked" value="0"> <span>Đóng&nbsp;&nbsp;&nbsp;</span>

								</label> <label> <input type="radio" name="trangThai" id="trangThai"
									value="1"> <span>Mở</span>
								</label>
							</div>
						</td>
						<td></td>
					</tr>

					<tr>
						<!--Thoi gian làm bài-->
						<td>Thời gian làm bài <br> (phút)
						</td>
						<td><input id="thoiGian" class="form-control" type="text"
							name="thoiGian" value="" style="width: 50%;">
							<div id="thongbao_thoigian"></div>
						</td>
						<td></td>
					</tr>

					<tr>
						<!--Ngày tạo đề-->
						<td>Ngày tạo đề</td>
						<td><input type="date" name="ngayTaoDe" id="ngayTaoDe"
							class="form-control" value="" required="required" title=""
							style="width: 50%;">
							<div id="thongbao_ngaytaode"></div> 
						</td>
						<td></td>
					</tr>

					<tr>
						<!--Dặn dò-->
						<td>Dặn dò</td>
						<td><textarea id="danDo" class="form-control" rows="5">
											</textarea></td>
						<td></td>
					</tr>

					<tr>
						<!--Số lần cho phép-->
						<td>Số lần cho phép thi</td>
						<td><input type="number" name="soLanChoPhep"
							id="soLanChoPhep" class="form-control" value=""
							required="required" title="" style="width: 50%;">
							<div id="thongbao_solanchophep"></div>
							</td>
						<td></td>
					</tr>

					<tr>
						<!--Mật khẩu đề thi-->
						<td>Mật khẩu đề thi</td>
						<td><input id="matKhauDeThi" class="form-control"
							type="password" name="matKhauDeThi"
							style="width: 50%; margin-bottom: 10px;">
							<div class="checkbox">
								<label> <input type="checkbox" value="" onclick="showPassword()" id="showPassword"> Hiện
									mật khẩu
								</label>
							</div></td>
						<td></td>
					</tr>
					<tr>
						<!--Mật khẩu đề thi-->
						<td></td>
						<td>
							<button id="luu-thong-tin" class="btn btn-primary" onClick="AjaxLuuDeThi()">Lưu thông tin đề thi </button>
							<button hidden id="sua-thong-tin" onClick="AjaxSuaThongTinDeThi()">Sửa thông tin đề thi </button>
						</td>

						<td></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#tenDe").keyup(function() {
			var tenDe = $(this).val();
			var result = $("#thongbao_tende");
			if (tenDe.length > 0) {
				$("#tenDe").removeClass("empty-input");
				$("#thongbao_tende").html('');
				} else {}
	});

		$("#thoiGian").keyup(function() {
			var thoiGian = $(this).val();
			var result = $("#thongbao_thoigian");
			if (thoiGian.length > 0) {
				$("#thoiGian").removeClass("empty-input");
				$("#thongbao_thoigian").html('');
				} else {}
		});
		
		$("#ngayTaoDe").click(function() {
			var ngaytaode = $(this).val();
			var result = $("#thongbao_ngaytaode");
			if (ngaytaode != null) {
				$("#ngayTaoDe").removeClass("empty-input");
				$("#thongbao_ngaytaode").html('');
				} else {}
		});
		
		$("#soLanChoPhep").keyup(function() {
			var solanchophep = $(this).val();
			var result = $("#thongbao_solanchophep");
			if (solanchophep.length > 0) {
				$("#soLanChoPhep").removeClass("empty-input");
				$("#thongbao_solanchophep").html('');
				} else {}
		});
	});
</script>
</html>