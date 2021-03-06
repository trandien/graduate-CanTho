<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/register.css" />" />
<link rel="stylesheet" href="<c:url value="/resources/autocomplete/flexselect.css" />" type="text/css" media="screen" />
<script src="<c:url value="/resources/autocomplete/liquidmetal.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/autocomplete/jquery.flexselect.js" />" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/auto/jquery.tokenize.css" />" />
<script type="text/javascript" src="<c:url value="/resources/auto/jquery.tokenize.js"/>" > </script>
<script type="text/javascript" src="<c:url value="/resources/ajax/ajaxPhanCongVaiTro.js"/>" > </script>
<script type="text/javascript" src="<c:url value="/resources/ajax/ajaxDeThiLop.js"/>" > </script>
 <script type="text/javascript">
			 jQuery(document).ready(function() {
			     $("select.lop").flexselect();
			   });
			 
          $(document).ready(function(){
            $('#tokenizexxx').tokenize();
            
          });

      </script>
      <style type="text/css">
        .tokenize-sample{
          width: 100%;
          height: 10px;
        }
        .glyphicon-trash:hover{
        	color: red;
        }
      </style>
      
      
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading"
			style="text-align: center; font-size: 20px;">
			<i class="glyphicon glyphicon-user"></i> &nbsp <strong>Danh
				sách tham gia thi </strong>
		</div>

		<div class="panel-body">
			<ul class="nav nav-tabs" role="tablist" id="myTab">
				<li role="presentation" class="active" ><a href="#dslop"
					aria-controls="home" role="tab" data-toggle="tab">Danh sách lớp</a></li>
				<li role="presentation" ><a href="#dshocsinh"
					aria-controls="profile" role="tab" data-toggle="tab">Danh sách
						học sinh</a></li>
			</ul>

			<hr>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="dslop">

					<table class="table table-hover tableL"
						style="width: 100%; border: 1px solid #ccc;">
						<thead>
							<tr>
								<th colspan="7" style="text-align: center;">Danh sách lớp
									tham gia thi</th>
							</tr>

							<tr>
								<th colspan="7">
									<div id="wrapper">
										<div id="page-content-wrapper">
											<div class="container-fluid">
												<div class="row">
													<div class="col-sm-12 col-lg-12 col-xs-12 col-md-12">
														<div class="form-group" style="margin-top: 15px; margin-bottom: 15px;">
													        <div class="col-sm-5 col-lg-5 col-xs-5 col-md-5">
													          <label for="tenlop">Lớp:</label>
															<select class="lop form-control" id='tenlop'>
																<c:forEach items='${listLop }' var='lop'>
																	<option value="${lop.msl }">${lop.msl }</option>
																</c:forEach>
															</select>
													       </div>
													       
													       <div class="col-sm-5 col-lg-5 col-xs-5 col-md-5">
													       	<label for="phongthi">Phòng thi:</label>
																<select name="phongThiLop" id="phongthiL" class="form-control"
																	required="required">
																	<c:forEach items='${listPhongThi }' var='pt'>
																		<option value="${pt.mspt }">${pt.ptTen }</option>
																	</c:forEach>
																</select>
													       </div>
													       </div>
													       <br>
												<div class="col-md-4 col-lg-4 col-sm-4 col-xs-4">
													
														<div class="form-group" style="margin-top: 30px;">
															<label for="inputThoiGian">Ngày thi:</label>
															<input type="date" name="ngaythi" id="ngaythiL"
																class="form-control" value="" title="Thời gian">
															<div id="thongbao_ngaythi"></div>
														</div>
													</div>
													<div class="col-md-4 col-lg-4 col-sm-4 col-xs-4">
														<div class="form-group" style="margin-top: 30px;">
														        <label for="gioibatdau">Giờ bắt đầu:</label>
														        <input type="time" name="" id="giobatdauLop" class="form-control" value="" required="required" title="" >
														        <div id="thongbao_giobatdauLop"></div>
													      </div>
													  </div>
													  <div class="col-md-4 col-lg-4 col-sm-4 col-xs-4">    
													      <div class="form-group" style="margin-top: 15px;">
														        <label for="gioketthuc" class="control-label" style="margin-top: 15px; ">Giờ kết thúc:</label>
														        <input type="time" name="" id="gioketthucLop" class="form-control" value="" required="required" title=""  >
													      		<div id="thongbao_gioketthucLop"></div>
													      </div>
													</div>
												
												</div>
												</div>
												<!-- .row -->
											</div>
										</div>
									</div> <input type="button" id="themDSLopThamGiaThi" value="Thêm"
									class="btn btn-primary"
									style="margin-top: -20px; margin-left: 50px;" onclick="AjaxLuuDeThiLop()">
								</th>


							</tr>
							<tr>
								<th>STT</th>
								<th>Xóa</th>
								<th>Lớp</th>
								<th>Phòng</th>
								<th>Ngày thi</th>
								<th>Giờ bắt đầu</th>
								<th>Giờ kết thúc</th>
							</tr>

						</thead>
						<c:choose>
							<c:when test="${sua == '1'}">
								<tbody id='bang-lop-'>
									<c:forEach items="${listDeThiLop }" var='dtlop' varStatus="status">
										<tr id='pcvt-${dtlop.dethi.msdt }-${dtlop.lop.msl}'>
											<td class='indexL'><c:out value="${status.count}" /></td>
											<td>
												<div class='btn-group'>
													<div class='dropdown-toggle' data-toggle='dropdown' href='#'>
														<span class='glyphicon glyphicon-trash'></span>
													</div>
													<div class='dropdown-menu'>
														<hr>
														<BUTTON id='${dtlop.dethi.msdt }-${dtlop.lop.msl}' class='btn btn-danger XoaDeThiLop' style='width: 100%' onclick='XoaDeThiLop()'>
														Xóa</BUTTON>
													</div>
												</div>
											</td>
											<td>${dtlop.lop.msl }</td>
											<td>${dtlop.phongthi.ptTen }</td>
											<td>${dtlop.ngay }</td>
											<td>${dtlop.giobatdau }</td>
											<td>${dtlop.gioketthuc }</td>
										</tr>
									</c:forEach>
								</tbody>
							</c:when>
							<c:otherwise>
								<tbody id='bang-lop-'>
								</tbody>
							</c:otherwise>
						</c:choose>
						
					</table>
				</div>

				<!-- tab thêm Danh sách thí sinh tham gia thi-->
				<div role="tabpanel" class="tab-pane" id="dshocsinh">
					<table class="table table-hover"
						style="width: 100%; border: 1px solid #ccc;">
						<thead>
							<tr>
								<th colspan="8" style="text-align: center;">Danh sách thí
									sinh tham gia thi</th>
							</tr>

							<tr>
								<th colspan="8">
									<div id="wrapper">
										<div id="page-content-wrapper">
											<div class="container-fluid">
												<div class="row">
													<div class="col-sm-12 col-lg-12 col-xs-12 col-md-12">
													
														<div class="form-group" style="margin-top: 15px; margin-bottom: 15px;">
													        <div class="col-sm-5 col-lg-5 col-xs-5 col-md-5">
													          <select name="" id="lopxxx" class="form-control" onchange="AjaxLoadHSTrongLop()">
													          	<option value="0">- - - - - - Chọn tên lớp - - - - - - </option>
													            <c:forEach items='${listLop }' var='lop'>
																	<option value="${lop.msl }">${lop.msl }</option>
																</c:forEach>
													          </select>
													       </div>
													       
													       <div class="col-sm-5 col-lg-5 col-xs-5 col-md-5">
																<select name="phongThiHS" id="phongThiHS" class="form-control"
																	required="required">
																	<option value="0">- - - - - - Chọn phòng thi - - - - - - </option>
																	<c:forEach items='${listPhongThi }' var='pt'>
																		<option value="${pt.mspt }">${pt.ptTen }</option>
																	</c:forEach>
																</select>
													       </div>
													       </div>
													       <br>
													       
 													<div class='form-group' style="width: 100%; position: relative; margin-top: 30px; margin-left:15px;">
														 <select id="tokenizexxx" multiple="multiple" class="tokenize-sample">

													      </select>
													</div>
													<div class="col-md-4 col-lg-4 col-sm-4 col-xs-4">
													
														<div class="form-group" style="margin-top: 95px;">
															<label for="inputThoiGian">Ngày thi:</label>
															<input type="date" name="thoiGian" id="inputThoiGianhs"
																class="form-control" value="" title="Thời gian">
															<div id="thongbao_inputThoiGianhs"></div>
														</div>
													</div>
													<div class="col-md-4 col-lg-4 col-sm-4 col-xs-4">
														<div class="form-group" style="margin-top: 95px;">
														        <label for="gioibatdau">Giờ bắt đầu:</label>
														        <input type="time" name="" id="giobatdauhs" class="form-control" value="" required="required" title="" >
														        <div id="thongbao_giobatdauhs"></div>
													      </div>
													  </div>
													  <div class="col-md-4 col-lg-4 col-sm-4 col-xs-4">    
													      <div class="form-group" style="margin-top: 80px;">
														        <label for="gioketthuc" class="control-label" style="margin-top: 15px; ">Giờ kết thúc:</label>
														        <input type="time" name="" id="gioketthuchs" class="form-control" value="" required="required" title=""  >
													      		<div id="thongbao_gioketthuchs"></div>
													      </div>
													</div>
													</div>
												</div>
												<!-- .row -->
											</div>
										</div>
									</div> <input type="button" id="themDSHSThamGiaThi" value="Thêm"
									class="btn btn-primary"
									style="margin-left: 50px; margin-top: -10px" onclick="AjaxThemHSVaoDeThi()">
								</th>
							</tr>
							<tr>
								<th>STT</th>
								<th>Xóa</th>
								<th>Họ tên</th>
								<th>Phòng</th>
								<th>Ngày thi</th>
								<th>Giờ bắt đầu</th>
								<th>Giờ kết thúc</th>
								<th>Lớp</th>

							</tr>

						</thead>
						<c:choose>
							<c:when test="${sua == '1'}">
								<tbody id='bang-hs-thi-'>
									<c:forEach items="${listHSThamGiaThi }" var='hsthi' varStatus="status">
										<tr id='pcvths-${hsthi.mspcvt }'>
											 <td class='indexHS'><c:out value="${status.count}" /></td>
											 <td>
												<div class='btn-group'>
												<div class='dropdown-toggle' data-toggle='dropdown' href='#'>
													<span class='glyphicon glyphicon-trash'></span>
												</div>
												<div class='dropdown-menu'>
												<hr>
												<BUTTON class='btn btn-danger' style='width: 100%' onclick='AjaxXoaPhanCongVaiTro(${hsthi.mspcvt })'>
												Xóa</BUTTON>
												</div>
												</div>
											 </td>
											 <td>${hsthi.user.ndHoten }</td>
											 <td>${hsthi.phongthi.ptTen }</td>
											
											 <td>${hsthi.ngay }</td>
											 <td>${hsthi.giobatdau }</td>
											 <td>${hsthi.gioketthuc }</td>
											  <td>${hsthi.user.lop.msl }</td>
										 </tr>
									</c:forEach>
								</tbody>
							</c:when>
							<c:otherwise>
								<tbody id='bang-hs-thi-'>
								</tbody>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>