function TaoCauHoi() {
	$.ajax({
		data : "MaChuDe=" + $("#mscd").val(),
		type : "POST",
		url : "AjaxLayMaxIdCauHoi",
		success : function(result) {
			$("#tencauhoi").html(
					"<strong style='font-size: 20px;' id='doimautheodokho'>Câu &nbsp;"
							+ result + "</strong>");
			$("#themcauhoi").show();
		},
		error : function() {
			alert("Tao Cau Hoi that bai");
		}
	});
}

function LuuCauHoi() {
	var maDeThi = $("#msdt").val();
	var maChuDe = $("#mscd").val();
	var maDangCauHoi= jQuery('input[name=dangcauhoi]:checked' ).val()
	var maDoKho = jQuery('input[name=dokho2]:checked' ).val()
	var noiDungCauHoi = $("#edit2").val();
	var diem = $("#diem1").val();
	
	var dapAnDung = $("#dapAnDung").val();
	$.ajax({
		data : "MaDeThi=" + maDeThi + "&MaChuDe=" + maChuDe + "&MaDangCauHoi="
				+ maDangCauHoi + "&MaDoKho=" + maDoKho + "&NoiDungCauHoi="
				+ noiDungCauHoi + "&Diem=" + diem + "&DapAnDung=" + dapAnDung,
		type : "POST",
		url : "AjaxLuuCauHoi",
		success : function(result) {
			alert("Luu thanh cong");
		},
		error : function() {
			alert("Thêm câu hỏi bị lỗi");
		}
	});
}

function SuaCauHoi() {
	
}