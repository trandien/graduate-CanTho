<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Kết quả thi</title>
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/headPage.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/project.css" /> " />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/register.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.mCustomScrollbar.css" />"/>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/project.js" />"></script>
<script src="<c:url value="/resources/js/jquery.mCustomScrollbar.concat.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />" type="text/javascript"></script>
</head>
<body style="font-family: 'Calibri', sans-serif; font-size: 16px;">

	<%@ include file="/WEB-INF/views/head-page.jsp"%>
	<!-- /header-->
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-lg-3 col-sm-12 col-xs-12"></div>
			<div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
				<span style="text-align: center;"><h3>Kết quả thi</h3></span>
				<table class="table table-hover" style="margin-top: 25px;">
					<thead>
						<tr>
							<th>STT</th>
							<th>Ngày thi</th>
							<th>Số câu đúng / Tổng số câu</th>
							<th>Điểm</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>24/04/2013</td>
							<td>46/50</td>
							<td>9</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-3 col-lg-3 col-sm-12 col-xs-12"></div>
		</div>
	</div>

</body>
</html>