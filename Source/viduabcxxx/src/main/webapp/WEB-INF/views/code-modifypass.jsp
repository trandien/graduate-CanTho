<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Đăng nhập Arcane</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/custom/login.css" />" />
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>

    </head>

    <body>
        <div class="container">
            <div class="login-header">
                <div class="login-title">
                    <div>Anki</div>
                    <em style="font-weight: 300; font-size: 20px;">Website tạo và thi trắc nghiệm</em>
                </div>
            </div>
            <form action="KiemTraCode" class="form-horizontal" role="form" id="form-dang-ky">
                <p style="font-size: 20px; font-weight: 500;">Bạn đã quên mật khẩu ?</p>
                <p style="font-size: 14px;">Bạn vui lòng điền mã đổi mật khẩu mà chúng tôi đã gửi cho bạn</p>
                <div class="form-group" style="margin-bottom: 10px;">
                    <div class="col-md-12">
                        <input name="codeRandom" class="form-control" placeholder="Mã đổi mật khẩu">
                        <c:if test="${not empty kiemTraCode}">
	                        <div style="color: #a94442; font-size: 85%; padding-top: 5px;">
	                        	<span>${kiemTraCode }</span>
	                        </div>
                        </c:if>
                        
                    </div>
                </div>
                <div class="form-group" style="margin-bottom: 20px;">
                    <div class="col-md-12">
                        <div class="checkbox" style="float: left;">
                            <a style="font-size: 14px; cursor: pointer;" href="login.html">Quay về trang đăng nhập</a>
                        </div>
                        <button class="btn btn-lg btn-primary" type="submit" style="float: right;">Xong</button>
                    </div>
                </div>
            </form>
        </div>
    </body>

</html>
