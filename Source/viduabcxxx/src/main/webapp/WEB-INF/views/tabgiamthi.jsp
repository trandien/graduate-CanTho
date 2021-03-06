<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
<title>Insert title here</title>
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
									<input type="text" class="form-control" id="tenGV" path="tenGV"
										placeholder="Nhập tên giám thị cần thêm " />
								</div>
								<div class="form-group">
									<select name="phongThi" id="inputPhongThi" class="form-control"
										required="required">
										<option value="1">Phòng 1</option>
										<option value="2">Phòng 2</option>
										<option value="3">Phòng 3</option>
										<option value="4">Phòng 4</option>
										<option value="5">Phòng 5</option>
									</select>
								</div>
								<div class="form-group">
									<input type="date" name="thoiGian" id="input"
										class="form-control" value="" title="Thời gian">
								</div>

							</div>
						</div>
						<!-- .row -->
					</div>
				</div>
			</div>

			<input type="button" id="themDSLopThamGiaThi" value="Thêm"
				class="btn btn-primary"
				style="margin-top: -30px; margin-left: 50px;">

			<table class="table table-hover"
				style="width: 100%; border: 1px solid #ccc;">
				<thead>
					</tr>
					<tr>
						<th>STT</th>
						<th>Xóa</th>
						<th>Tài khoản</th>
						<th>Họ tên</th>
						<th>Phòng</th>
						<th>Thời Gian</th>
					</tr>

				</thead>
				<tbody>

					<tr>
						<th scope="row">1</th>
						<td>
							<div class="card-delete">
								<input class="list-item-id" value="35" type="hidden"> <span
									class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</div>
						</td>
						<td>huynhxuanhiep</td>
						<td>Huỳnh Xuân Hiệp</td>
						<td>Phòng 3</td>
						<td>20/02/2012</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>
							<div class="card-delete">
								<input class="list-item-id" value="35" type="hidden"> <span
									class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</div>
						</td>
						<td>huynhxuanhiep</td>
						<td>Huỳnh Xuân Hiệp</td>
						<td>Phòng 3</td>
						<td>20/02/2012</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>
							<div class="card-delete">
								<input class="list-item-id" value="35" type="hidden"> <span
									class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</div>
						</td>
						<td>huynhxuanhiep</td>
						<td>Huỳnh Xuân Hiệp</td>
						<td>Phòng 3</td>
						<td>20/02/2012</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
function split(val) {
    return val.split(/,\s*/);
}
function extractLast(term) {//xxxxxxxxxxxxxxxxxxxxxx
    return split(term).pop();//xxxxxxxxxxxxxxxxxxxxxx
}
 
$(document).ready(function() {
     
    $( "#tenGV").autocomplete({
        source: function (request, response) {
            $.getJSON("${pageContext. request. contextPath}/AutocompleteLoadGiaoVien.html", {
                term: extractLast(request.term)//xxxxxxxxxxxxxxxxxxxxxx
            }, response);
        },
        search: function () {
            var term = extractLast(this.value);//xxxxxxxxxxxxxxxxxxxxxx
            if (term.length < 1) {//xxxxxxxxxxxxxxxxxxxxxx
                return false;
            }
        },
        focus: function () {
            return false;
        },
        select: function (event, ui) {
            var terms = split(this.value);
            terms.pop();
            terms.push(ui.item.value);
            terms.push("");
            this.value = terms.join(", ");
            return false;
        }
    });
     
});
</script>
</body>

</html>