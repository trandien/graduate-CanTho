function AjaxLuuDeThi() {
	var TenDe = $("#tenDe").val();
	var NienKhoa = $("#nienKhoan").val();
	var ChuDe = $("#chuDe").val();
	var MonHoc = $("#monHoc").val();
	var HeSo = $("#heSo").val();
	var TrangThai = $("#trangThai").val();
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
	$.ajax({
		data : "TenDe=" + $("#tenDe").val()
				+ "&NienKhoa=" + $("#nienKhoan").val()
				+ "&HocKy=" + $("#hocKy").val()
				+ "&ChuDe=" + $("#chuDe").val()
				+ "&MonHoc=" + $("#monHoc").val()
				+ "&HeSo=" + $("#heSo").val()
				+ "&TrangThai=" + $("#trangThai").val()
				+ "&ThoiGian=" + $("#thoiGian").val()
				+ "&NgayTaoDe=" + $("#ngayTaoDe").val()
				+ "&DanDo=" + $("#danDo").val()
				+ "&SoLanChoPhep=" + $("#soLanChoPhep").val()
				+ "&MatKhauDeThi=" + $("#matKhauDeThi").val(),
		type : "POST",
		url : "AjaxLuuDeThi",
		success : function(result) {
			
			$("#ketquathemdethi").html(result);
		},
		error : function() {
			alert("Thêm thất bại");
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