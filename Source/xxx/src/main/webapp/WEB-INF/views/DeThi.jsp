<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Anki</title>
<link
	<c:url value = "href='http://fonts.googleapis.com/css?family=Roboto:400,300,700,500'"/>
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/custom/DeThi.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/jquery.mCustomScrollbar.css" />" />
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/ajax/DeThi.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/ajax/ajaxThiSinhThi.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.DataSaver.js"/>"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#profile--panel-show').click(function() {
			$('.bubble').slideToggle("fast");
		});
		
		$('.radio-answer').each(function() {
            var key = $(this).attr('name');
            var val = localStorage[key];
            if ( $(this).attr('name') == key && $(this).attr('value') == val ) {
              $(this).attr('checked', 'checked');
            }
          });

          $('.checkbox-answer').each(function() {
            var key = $(this).attr('name');
            var val = localStorage[key];
            if ( $(this).attr('name') == key && $(this).attr('value') == val ) {
              $(this).attr('checked', 'checked');
            }
          });

          $('.dienvaochotrong').each(function() {
            var key = $(this).attr('id');
            var val = localStorage[key];
            
              $(this).val(val);
            
          });
		
		
	});
	//Save data for fields with class "save"
	$(document).on('click', '.radio-answer', function (e) {
                if ( $(this).attr('type')=='radio' ) {
                  localStorage[$(this).attr('name')] = $(this).val();
                } else {
                  localStorage[$(this).attr('id')] = $(this).val();
                }
              });

           $(document).on('change', '.checkbox-answer', function (e) {
                if ( $(this).attr('type')=='checkbox' ) {
                  var kt = jQuery("input[name="+$(this).attr('name')+"]:checked").val();
                  if(kt == undefined) { 
                    localStorage.removeItem($(this).attr('name'));
                    
                  } else {
                    localStorage[$(this).attr('name')] = $(this).val();
                  }
                  
                } else {
                  var kt = jQuery("input[name="+$(this).attr('name')+"]:checked").val();
                  if(kt != undefined) {
                    localStorage[$(this).attr('id')] = $(this).val();
                  } else {
                    localStorage.removeItem($(this).attr('id'));
                  }
                }
              });

           $(document).on('keyup', '.dienvaochotrong', function (e) {
                var value = $(this).val();
                
                if(value.length > 0) {
                  localStorage[$(this).attr('id')] = value;
                  
                } else {
                  localStorage.removeItem($(this).attr('id'));
                }
              });
	
</script>
<style>
p {
	display: inline;
}
</style>
</head>
<body style="font-family: 'Calibri', sans-serif; font-size: 16px;">
	<%@ include file="/WEB-INF/views/head-page.jsp"%>
		${load }
		<input type="hidden" id="msdt" value="${msdt }">
		<input type="hidden" id="taiKhoan" value="${taiKhoan }">
		<input type="hidden" id="soLanThi" value="${soLanThi }">
		
</body>
</html>
