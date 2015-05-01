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
<script src="<c:url value = "/resources/ajax/ajaxDSThiSinhThi.js"/>"></script>
<script src="<c:url value = "/resources/js/bootstrap.min.js" />"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/bootstrap.css" />" />
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.blockUI.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/register.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/tabthongtindethi.css" />" />


</head>
<div class="container">
	<div class="row">
		<div class="col-md-3 col-lg-3 col-xs-12 col-sm-12"></div>
		<div class="col-md-3 col-lg-3 col-xs-12 col-sm-12">
			<select name="xemdiem-lop" id="xemdiem-lop" class="form-control" style="margin-top: 20px;">
			<option value="0">- - - - - Chọn lớp cần xem - - - - -</option>
				<c:forEach items="${listDeThiLop }" var="dtl">
					<option value="${dtl.lop.msl }">${dtl.lop.msl }</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-md-6 col-lg-6 col-xs-12 col-sm-12"></div>
	</div>
</div>

<hr>
<div id='table-diem'></div>

</body>
</html>