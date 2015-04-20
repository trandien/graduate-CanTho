<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/autocomplete/flexselect.css" />" type="text/css" media="screen" />
<script src="<c:url value="/resources/autocomplete/liquidmetal.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/autocomplete/jquery.flexselect.js" />" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/auto/jquery.tokenize.css" />" />
<script type="text/javascript" src="<c:url value="/resources/auto/jquery.tokenize.js"/>" > </script>
    

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

					<table class="table table-hover"
						style="width: 100%; border: 1px solid #ccc;">
						<thead>
							<tr>
								<th colspan="3" style="text-align: center;">Danh sách lớp
									tham gia thi</th>
							</tr>

							<tr>
								<th colspan="3">
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
															 <label for="tenlop">Lớp:</label>
															<select class="lop form-control" id='tenlop'>
																<c:forEach items='${listLop }' var='lop'>
																	<option value="${lop.msl }">${lop.msl }</option>
																</c:forEach>
															</select>
														</div>
												</div>
												</div>
												<!-- .row -->
											</div>
										</div>
									</div> <input type="button" id="themDSLopThamGiaThi" value="Thêm"
									class="btn btn-primary"
									style="margin-top: -20px; margin-left: 50px;" onclick="AjaxThemLopThamGiaThi()">
								</th>


							</tr>
							<tr>
								<th>STT</th>
								<th>Tên lớp</th>
								<th>Xóa</th>
							</tr>

						</thead>
						<tbody id='bang-lop-'>
						
						</tbody>
					</table>
				</div>

				<!-- tab thêm Danh sách thí sinh tham gia thi-->
				<div role="tabpanel" class="tab-pane" id="dshocsinh">
					<table class="table table-hover"
						style="width: 100%; border: 1px solid #ccc;">
						<thead>
							<tr>
								<th colspan="5" style="text-align: center;">Danh sách thí
									sinh tham gia thi</th>
							</tr>

							<tr>
								<th colspan="5">
									<div id="wrapper">
										<div id="page-content-wrapper">
											<div class="container-fluid">
												<div class="row">
													<div class="col-md-12">
													
														<div class="form-group" style="margin-top: 15px; margin-bottom: 15px;">
													        <div class="col-sm-5">
													          <select name="" id="lopxxx" class="form-control" onchange="AjaxLoadHSTrongLop()">
													          	<option value="0">- - - - - - Chọn tên lớp - - - - - - </option>
													            <c:forEach items='${listLop }' var='lop'>
																	<option value="${lop.msl }">${lop.msl }</option>
																</c:forEach>
													          </select>
													       </div>
													       </div>
													       <br>
													       
 													<div class='form-group' style="width: 100%; position: relative; margin-top: 30px; margin-left:15px;">
														 <select id="tokenizexxx" multiple="multiple" class="tokenize-sample">

													      </select>
													</div>
													</div>
												</div>
												<!-- .row -->
											</div>
										</div>
									</div> <input type="button" id="themDSHSThamGiaThi" value="Thêm"
									class="btn btn-primary"
									style="margin-top: 70px; margin-left: 50px;" onclick="AjaxThemHSVaoDeThi()">
								</th>
							</tr>
							<tr>
								<th>STT</th>
								<th>Xóa</th>
								<th>Tài khoản</th>
								<th>Họ Tên</th>
								<th>Lớp</th>

							</tr>

						</thead>
						<tbody>

							<tr>
								<th scope="row">1</th>
								<td>
									<div class="card-delete">
										<input class="list-item-id" value="35" type="hidden">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</div>
								</td>
								<td>tranthanhdien</td>
								<td>Trần Thanh Điền</td>
								<td>12A2</td>

							</tr>
							<tr>
								<th scope="row">2</th>
								<td>
									<div class="card-delete">
										<input class="list-item-id" value="35" type="hidden">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</div>
								</td>
								<td>huynhnhatminh</td>
								<td>huỳnh Nhật Minh</td>
								<td>12A2</td>

							</tr>
							<tr>
								<th scope="row">3</th>
								<td>
									<div class="card-delete">
										<input class="list-item-id" value="35" type="hidden">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</div>
								</td>
								<td>hohuunhan</td>
								<td>Hồ Hữu Nhân</td>
								<td>12A3</td>

							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>