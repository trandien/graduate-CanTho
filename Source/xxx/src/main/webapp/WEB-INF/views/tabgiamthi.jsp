<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
   
<link rel="stylesheet" href="<c:url value="/resources/autocomplete/flexselect.css" />" type="text/css" media="screen" />
<script src="<c:url value="/resources/autocomplete/liquidmetal.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/autocomplete/jquery.flexselect.js" />" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/register.css" />" />
<script src="<c:url value="/resources/ajax/ajaxChuDe.js" />"></script>
<script src="<c:url value="/resources/ajax/ajaxPhanCongVaiTro.js" />"></script>
<script type="text/javascript">
	 jQuery(document).ready(function() {
	     $("select.flexselect").flexselect();
	   });
 </script>
 <style>
 	.empty-input{
		border: 1px solid red;
	}
 </style>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading"
			style="text-align: center; font-size: 20px;">
			<i class="glyphicon glyphicon-user">&nbsp</i> <strong> Danh
				sách giám thị </strong>
		</div>
		
		<div class="panel-body">
			<div id="wrapper">
				<div id="page-content-wrapper">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
								<div class="form-group">
									<!--  
									<input id='tenGV' type="text" class="form-control" id="tenGV" path="tenGV"
										placeholder="Nhập tên giám thị cần thêm" onclick="AjaxLoadDSGV()"/>
									-->
									 <label for="tengv">Tên:</label>
									<select class="flexselect form-control" id='tengv'>
										<c:forEach items='${listGV }' var='gv'>
											<option value="${gv.ndTaikhoan }">${gv.ndHoten }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="inputPhongThi">Phòng:</label>
									<select name="phongThi" id="inputPhongThi" class="form-control"
										required="required">
										<c:forEach items='${listPhongThi }' var='pt'>
											<option value="${pt.mspt }">${pt.ptTen }</option>
										</c:forEach>
									</select>
								</div>
								<label for="inputThoiGian">Ngày gác thi:</label>
								<div class="form-group">
									<input type="date" name="thoiGian" id="inputThoiGian"
										class="form-control" value="" title="Thời gian">
									<div id="thongbao_inputThoiGian"></div>
									<div id='kiemtraphancongvaitro'></div>
								</div>
								
								
							</div>
							
							<div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
								<div class="form-group">
								        <label for="gioibatdau">Giờ bắt đầu:</label>
								        <input type="time" name="" id="giobatdau" class="form-control" value="" required="required" title="" >
								        <div id="thongbao_giobatdau"></div>
							      </div>
							      
							      <div class="form-group" >
								        <label for="gioketthuc" class="control-label" style="margin-top: 15px; ">Giờ kết thúc:</label>
								        <input type="time" name="" id="gioketthuc" class="form-control" value="" required="required" title=""  >
							      		<div id="thongbao_gioketthuc"></div>
							      </div>
							</div>
						</div>
						<!-- .row -->
					</div>
				</div>
			</div>
			
			<input type="button" id="themDSLopThamGiaThi" value="Thêm"
				class="btn btn-primary"
				style="margin-top: -20px; margin-left: 50px;" onclick="ThemPhanCongVaiTro()">

			<table id='tableGiamThi' class="table table-hover"
				style="width: 100%; border: 1px solid #ccc; margin-top: 20px;">
				<thead>
					
					<tr>
						<th>STT</th>
						<th>Xóa</th>
						<th>Họ tên</th>
						<th>Phòng</th>
						<th>Ngày gác thi</th>
						<th>Giờ bắt đầu</th>
						<th>Giờ kết thúc</th>
					</tr>

				</thead>
				<tbody id='bang-giam-thi-'>

				</tbody>
			</table>
		</div>
	</div>
</body>

</html>