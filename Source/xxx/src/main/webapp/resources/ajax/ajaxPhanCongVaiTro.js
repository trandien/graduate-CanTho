function ThemPhanCongVaiTro() {
	var test = 0;
	var testTime = 0;
	var msdt = $("#msdt").val();
	var mscd = $("#mscd").val();
	var mspt = $("#inputPhongThi").val();
	var time = $("#inputThoiGian").val();
	var timeStart = $("#giobatdau").val();
	var timeEnd = $("#gioketthuc").val();

	if (typeof msdt == "undefined") {
		alert("Bạn vui lòng thêm đề thi trước khi thêm giám thị!!");
		return;
	}
	if (typeof mscd == "undefined") {
		alert("Bạn vui lòng thêm chủ đề trước khi thêm giám thị!!");
		return;
	}
	
	if(time == "") {
		$("#inputThoiGian").addClass('empty-input');
		$("#thongbao_inputThoiGian").html("<span style='color: #a94442'>Bạn vui lòng chọn ngày thi</span>");
		test++;
	}
	if(timeStart == "") {
		$("#giobatdau").addClass('empty-input');
		$("#thongbao_giobatdau").html("<span style='color: #a94442'>Bạn vui lòng chọn thời gian bắt đầu thi</span>");
		test++;
	}
	if(timeEnd == "") {
		$("#gioketthuc").addClass('empty-input');
		$("#thongbao_gioketthuc").html("<span style='color: #a94442'>Bạn vui lòng chọn thời gian kết thúc thi</span>");
		test++;
	}
	if(test>0) return;
	$.ajax({
		
		data : 	"MaDeThi=" + $("#msdt").val()
				+ "&PhongThi=" + mspt
				+ "&TaiKhoanGiamThi=" + $("#tengv").val()
				+ "&NgayThi=" + time
				+ "&GioBatDau=" + timeStart
				+ "&GioKetThuc=" + timeEnd,
		url : "AjaxKiemTraPhanCongVaiTro",
		type : "POST",
		success : function(result) {
			$("#kiemtraphancongvaitro").html("<span style='color: #a94442'>"+result+"</span>");
			if(result.length == 0) {
				$.ajax({
					data : "MaDeThi=" + msdt
							+ "&MaChuDe=" + mscd
							+ "&PhongThi=" + mspt
							+ "&TaiKhoanGiamThi=" + $("#tengv").val()
							+ "&NgayThi=" + time
							+ "&GioiBatDau=" + timeStart
							+ "&GioiKetThuc=" + timeEnd,
					url : "AjaxThemPhanCongVaiTro",
					type : "POST",
					success : function(result) {
						
						$("#bang-giam-thi-").attr('id',"bang-giam-thi-"+msdt);
						$("#bang-giam-thi-"+msdt).append(result);
						
					},
					error : function() {
						alert("Phan cong vai tro that bai");
					}
				});
			}
		},
		error: function(result) {
			
			}
		});
	
}

$(document).on('click', '#inputThoiGian', function (e) {
	var time = $("#inputThoiGian").val();
	$("#inputThoiGian").removeClass('empty-input');
	$("#thongbao_inputThoiGian").html("");
});

$(document).on('click', '#gioketthuc', function (e) {
	var time = $("#gioketthuc").val();
	$("#gioketthuc").removeClass('empty-input');
	$("#thongbao_gioketthuc").html("");
});

$(document).on('click', '#giobatdau', function (e) {
	var time = $("#gioibatdau").val();
	$("#giobatdau").removeClass('empty-input');
	$("#thongbao_gioibatdau").html("");
});

function AjaxXoaPhanCongVaiTro(mspcvt) {
	$.ajax({
		data : "MSPCVT="+mspcvt,
		url: "AjaxXoaPhanCongVaiTro",
		type: "POST",
		success : function(result) {
			$("#pcvt-"+mspcvt).remove();
		} ,
		error : function(result) {
			
		}
	});
}






