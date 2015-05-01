function AjaxLuuDeThi() {
	var TenDe = $("#tenDe").val();
	var NienKhoa = $("#nienKhoan").val();
	var ChuDe = $("#chuDe").val();
	var MonHoc = $("#monHoc").val();
	var HeSo = $("#heSo").val();
	var kt = jQuery("input[name='trangThai']:checked").val();
	if(kt == 'on') {
		var TrangThai = "0";
	} else {
		var TrangThai = "1";
	}
	var ThoiGianLamBai = $("#thoiGian").val();
	var NgayTaoDe = $("#ngayTaoDe").val();
	var DanDo = $("#danDo").val();
	var SoLanChoPhep = $("#soLanChoPhep").val();
	var MatKhauDeThi = $("#matKhauDeThi").val();
	if(TenDe=="" || ThoiGianLamBai=="" || NgayTaoDe=="" || SoLanChoPhep == "" || !jQuery.isNumeric(ThoiGianLamBai)) {
		if(TenDe=="") {
			$("#tenDe").addClass("empty-input");
			$("#thongbao_tende").html("<span style='color: #a94442'>Tên đề không được bỏ trống</span>");
		} 
		if(ThoiGianLamBai=="") {
			$("#thoiGian").addClass("empty-input");
			$("#thongbao_thoigian").html("<span style='color: #a94442'>Thời gian làm bài không được bỏ trống</span>");
		} else if(!jQuery.isNumeric(ThoiGianLamBai)) {
			$("#thoiGian").addClass("empty-input");
			$("#thongbao_thoigian").html("<span style='color: #a94442'>Thời gian làm bài phải là số nguyên dương</span>");
		}
		if(NgayTaoDe=="") {
			$("#ngayTaoDe").addClass("empty-input");
			$("#thongbao_ngaytaode").html("<span style='color: #a94442'>Ngày tạo đề không được bỏ trống</span>");
		}
		if(SoLanChoPhep=="") {
			$("#soLanChoPhep").addClass("empty-input");
			$("#thongbao_solanchophep").html("<span style='color: #a94442'>Số lần cho phép thi không được bỏ trống</span>");
		}
		return;
	}
	
	var ketqua = "";
	$.ajax({
		data : "TenDe=" + $("#tenDe").val()
				+ "&NienKhoa=" + $("#nienKhoan").val()
				+ "&HocKy=" + $("#hocKy").val()
				+ "&ChuDe=" + $("#chuDe").val()
				+ "&MonHoc=" + $("#monHoc").val()
				+ "&HeSo=" + $("#heSo").val()
				+ "&TrangThai=" + TrangThai
				+ "&ThoiGian=" + $("#thoiGian").val()
				+ "&NgayTaoDe=" + $("#ngayTaoDe").val()
				+ "&DanDo=" + $("#danDo").val()
				+ "&SoLanChoPhep=" + $("#soLanChoPhep").val()
				+ "&MatKhauDeThi=" + $("#matKhauDeThi").val(),
		type : "POST",
		url : "AjaxLuuDeThi",
		success : function(result) {
			
			ketqua += "<input type='hidden' id='msdt' name='msdt' value='"+result+"'>";
			$("#ketquathemdethi").html(ketqua);
			$.growlUI('Thêm đề thi thành công'); 
			$("#luu-thong-tin").remove();
			$("#sua-thong-tin").prop("class", "btn btn-success");
		},
		error : function() {
			alert("Thêm thất bại");
		}

	});
}

function AjaxSuaThongTinDeThi() {
	var msdt = $("#msdt").val();
	var TenDe = $("#tenDe").val();
	var NienKhoa = $("#nienKhoan").val();
	var ChuDe = $("#chuDe").val();
	var MonHoc = $("#monHoc").val();
	var HeSo = $("#heSo").val();
	
	var kt = jQuery("input[name='trangThai']:checked").val();
	if(kt == 'on') {
		var TrangThai = "0";
	} else {
		var TrangThai = "1";
	}
	var ThoiGianLamBai = $("#thoiGian").val();
	var NgayTaoDe = $("#ngayTaoDe").val();
	var DanDo = $("#danDo").val();
	var SoLanChoPhep = $("#soLanChoPhep").val();
	var MatKhauDeThi = $("#matKhauDeThi").val();
	if(TenDe=="" || ThoiGianLamBai=="" || NgayTaoDe=="" || SoLanChoPhep == "") {
		if(TenDe=="") {
			$("#tenDe").addClass("empty-input");
			$("#thongbao_tende").html("<span style='color: #a94442'>Tên đề không được bỏ trống</span>");
		} 
		if(ThoiGianLamBai=="") {
			$("#thoiGian").addClass("empty-input");
			$("#thongbao_thoigian").html("<span style='color: #a94442'>Thời gian làm bài không được bỏ trống</span>");
		}
		if(NgayTaoDe=="") {
			$("#ngayTaoDe").addClass("empty-input");
			$("#thongbao_ngaytaode").html("<span style='color: #a94442'>Ngày tạo đề không được bỏ trống</span>");
		}
		if(SoLanChoPhep=="") {
			$("#soLanChoPhep").addClass("empty-input");
			$("#thongbao_solanchophep").html("<span style='color: #a94442'>Số lần cho phép thi không được bỏ trống</span>");
		}
		return;
	}
	var ketqua = "";
	$.ajax({
		data : "TenDe=" + $("#tenDe").val()
				+ "&NienKhoa=" + $("#nienKhoan").val()
				+ "&HocKy=" + $("#hocKy").val()
				+ "&ChuDe=" + $("#chuDe").val()
				+ "&MonHoc=" + $("#monHoc").val()
				+ "&HeSo=" + $("#heSo").val()
				+ "&TrangThai=" + TrangThai
				+ "&ThoiGian=" + $("#thoiGian").val()
				+ "&NgayTaoDe=" + $("#ngayTaoDe").val()
				+ "&DanDo=" + $("#danDo").val()
				+ "&SoLanChoPhep=" + $("#soLanChoPhep").val()
				+ "&MatKhauDeThi=" + $("#matKhauDeThi").val()
				+ "&MaDeThi="+$("#msdt").val(),
		type : "POST",
		url : "AjaxSuaThongTinDeThi",
		success : function(result) {
			var ketqua = "<input type='hidden' id='msdt' name='msdt' value='"+result+"'>";
			$("#ketquathemdethi").html(ketqua);
			$.growlUI('Sửa đề thi thành công'); 
			$("#luu-thong-tin").remove();
			$("#sua-thong-tin").prop("class", "btn btn-success");
		},
		error : function() {
			alert("Sửa đề thi thất bại");
		}

	});
}

function AjaxXoaDeThi(maDe) {
	$.ajax({
		data: "MaDeThi="+maDe,
		type: "POST",
		url: "AjaxXoaDeThi",
		success: function(result) {
			$("#dethi_"+maDe).remove();
			$("#form-card-delete").hide();
		},
		error: function(){
			alert("Xoa de thi that bai");
		}
	});
}

function showPassword(){
	var isCheck = $("#showPassword").is(':checked');
	if(isCheck) {
		$("#matKhauDeThi").prop('type', 'text');
	} else {
		$("#matKhauDeThi").prop('type', 'password');
	}
}

function ThiThu(){
	var msdt = $("#msdt").val();
	if (typeof msdt == "undefined") {
		alert("Đề thi chưa được thêm. Vui lòng kiểm tra lại!");
		return;
	}
	 window.location.href = "Test.html?msdt="+msdt;
//	setTimeout(function() {  window.location.href = "Dang-Nhap.html";}, 5000 );
	
	
}





