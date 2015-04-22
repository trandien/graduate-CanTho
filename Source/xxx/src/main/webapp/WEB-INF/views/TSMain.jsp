<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TSMain</title>
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>


<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/headPage.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/project.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/background.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/register.css" />" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/jquery.mCustomScrollbar.css" />" />
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/project.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery.mCustomScrollbar.concat.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"
	type="text/javascript"></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/head-page.jsp"%>


	<div class="container-fluid" style="margin-top: 15px;">
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-default">
					<div class="panel-heading" style="text-align: center;">
						<strong>Môn học</strong>
					</div>
					<div class="panel-body">
						<div class="tabs-left">
							<ul class="nav nav-stacked tab-left">
								<c:forEach items="${listMonHoc }" var="mh">
									<c:choose>
										<c:when test="${mh.mhTen=='Toán'}">
											<li class="classLi active text-left" id="tab${mh.msmh}"><a
												href="#${mh.msmh}" data-toggle="tab"> ${mh.mhTen }</a></li>
										</c:when>
										<c:otherwise>
											<li class="classLi text-left" id="tab${mh.msmh}"><a
												href="#${mh.msmh}" data-toggle="tab"> ${mh.mhTen }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="tab-content">
					<c:forEach items="${listMonHoc }" var="mh">
						<c:choose>
							<c:when test="${mh.mhTen=='Toán'}">
								<div class="tab-pane fade active in" id="${mh.msmh}">
									<div class="panel panel-default">
										<div class="panel-heading"
											style="text-align: center; font-size: 20px;">
											<strong>${mh.mhTen } </strong>
										</div>
										<div class="panel-body">
											<div class="tab-content">
												<c:forEach items="${listDeThiThamGiaThi}" var="dt">
													<c:if test="${dt.monhoc.msmh == mh.msmh}">
														<c:if test="${dt.dtTrangthai == '1' }">
															<a href="Nhap-Mat-Khau-De-Thi.html?msdt=${dt.msdt }">${dt.dtTende }</a>
															<hr>
														</c:if>
													</c:if>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
								<!-- end tab-pane fade active in -->
							</c:when>
							<c:otherwise>

								<div class="tab-pane" id="${mh.msmh}">
									<div class="panel panel-default">
										<div class="panel-heading"
											style="text-align: center; font-size: 20px;">
											<strong>${mh.mhTen } </strong>
										</div>
										<div class="panel-body">
											<div class="tab-content">
												<c:forEach items="${listDeThiThamGiaThi}" var="dt">
													<c:if test="${dt.monhoc.msmh == mh.msmh}">
														<c:if test="${dt.dtTrangthai == '1' }">
															<a href="Nhap-Mat-Khau-De-Thi.html?msdt=${dt.msdt }">${dt.dtTende }</a>
															<hr>
														</c:if>
													</c:if>
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

</body>
</html>