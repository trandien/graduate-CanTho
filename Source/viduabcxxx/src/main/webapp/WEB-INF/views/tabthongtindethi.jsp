<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
<title>Thêm đề thi</title>
<body>
	<div class="panel panel-default">
		<div class="panel-heading"
			style="text-align: center; font-size: 20px;">
			<i class="glyphicon glyphicon-list-alt"></i> &nbsp <strong>Thông
				tin đề thi </strong>
		</div>
		<div class="panel-body">
			<table class="table table-hover">

				<tbody>
					<tr>
						<!--Tên đề-->
						<td>Tên đề</td>
						<td><input id="tenDe" class="form-control" type="text"
							name="tenDe" placeholder="Tên đề thi"></td>
						<td></td>
					</tr>

					<tr>
						<!--Loại đề-->
						<td>Niên khóa</td>
						<td><select name="nienKhoan" id="inputNienKhoan"
							class="form-control" required="required" style="width: 50%;">
								<option value="2005-2006">2005-2006</option>
								<option value="2006-2007">2006-2007</option>
								<option value="2007-2008">2007-2008</option>
								<option value="2008-2009">2008-2009</option>
								<option value="2009-2010">2009-2010</option>
						</select></td>
						<td></td>
					</tr>

					<tr>
						<!--Loại đề-->
						<td>Học kỳ</td>
						<td><select name="hocKy" id="inputHocKy" class="form-control"
							required="required" style="width: 50%;">
								<option value="1">I</option>
								<option value="2">II</option>
								<option value="3">III</option>
						</select></td>
						<td></td>
					</tr>

					<tr>
						<!--Chủ đề-->
						<td>Chủ đề</td>
						<td><select name="chuDe" id="chuDe" class="form-control"
							required="required" style="width: 50%;">
								<option value="1">Hóa hữu cơ</option>
								<option value="2">Hóa vô cơ</option>
								<option value="3">Hóa lượng tử</option>
						</select></td>
						<td></td>
					</tr>
					
					<tr>
						<!--Môn học-->
						<td>Môn học</td>
						<td><select name="monHoc" id="monHoc" class="form-control"
							required="required" style="width: 50%;">
								<option value="1">Toán</option>
								<option value="2">Lý</option>
								<option value="3">Hóa</option>
						</select></td>
						<td></td>
					</tr>
					
					<tr>
						<!--Hệ số-->
						<td>Hệ số</td>
						<td><select name="heSo" id="heSo" class="form-control"
							required="required" style="width: 50%;">
								<option value="1">Kiểm tra hệ số 1</option>
								<option value="2">Kiểm tra hệ số 2</option>
								<option value="3">Kiểm tra hệ số 3</option>
								<option value="0">Kiểm tra thử</option>
						</select></td>
						<td></td>
					</tr>

					<tr>
						<!--Trạng thái-->
						<td>Trạng thái</td>
						<td>
							<div class="radio">
								<label> <input type="radio" name="trangThai" id="input"
									value="" checked="checked"> <span>Đóng&nbsp;&nbsp;&nbsp;</span>

								</label> <label> <input type="radio" name="trangThai" id="input"
									value=""> <span>Mở</span>
								</label>
							</div>
						</td>
						<td></td>
					</tr>

					<tr>
						<!--Thoi gian làm bài-->
						<td>Thời gian làm bài <br> (phút)
						</td>
						<td><input id="thoiGian" class="form-control" type="text"
							name="tenDe" value="30" style="width: 50%;"></td>
						<td></td>
					</tr>

					<tr>
						<!--Ngày tạo đề-->
						<td>Ngày tạo đề</td>
						<td><input type="date" name="" id="input"
							class="form-control" value="" required="required" title=""
							style="width: 50%;"></td>
						<td></td>
					</tr>

					<tr>
						<!--Dặn dò-->
						<td>Dặn dò</td>
						<td><textarea id="danDo" class="form-control" rows="5">Không được mang tài liệu. Không được trao đổi trong lúc thi. Trừ điểm đối với những ai vi phạm
											</textarea></td>
						<td></td>
					</tr>

					<tr>
						<!--Số lần cho phép-->
						<td>Số lần cho phép thi</td>
						<td><input type="number" name="soLanChoPhep"
							id="soLanChoPhep" class="form-control" value=""
							required="required" title="" style="width: 50%;"></td>
						<td></td>
					</tr>

					<tr>
						<!--Mật khẩu đề thi-->
						<td>Mật khẩu đề thi</td>
						<td><input id="matKhau" class="form-control" type="password"
							name="matKhau" style="width: 50%; margin-bottom: 10px;">
							<div class="checkbox">
								<label> <input type="checkbox" value=""> Hiện
									mật khẩu
								</label>
							</div></td>
						<td></td>
					</tr>
					<tr>
						<!--Mật khẩu đề thi-->
						<td></td>
						<td><input type="button" class="btn btn-primary"
							value="Lưu thông tin đề thi"></td>

						<td></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>