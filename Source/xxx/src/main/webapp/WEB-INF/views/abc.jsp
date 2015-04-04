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
	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
 <script src="<c:url value="/resources/js/jquery.blockUI.js" />"></script>

<style type="text/css">
      .growlUI h1, .growlUI h2 {
          color: white; padding: 3px 5px 5px 75px; text-align: left; font-size: 20px;
    }
</style>

</head>
<body>
	<button onclick="trangtran()" class='btn btn-deafault'>OK</button>
  
</body>

</html>