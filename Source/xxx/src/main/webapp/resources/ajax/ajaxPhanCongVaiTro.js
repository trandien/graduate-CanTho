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
	var time = $("#giobatdau").val();
	$("#giobatdau").removeClass('empty-input');
	$("#thongbao_gioibatdau").html("");
});

function AjaxXoaPhanCongVaiTro(mspcvt) {
	$.ajax({
		data : "MSPCVT="+mspcvt,
		url: "AjaxXoaPhanCongVaiTro",
		type: "POST",
		success : function(result) {
			var indexHS = 1;
			var indexGT = 1;
			$("#pcvths-"+mspcvt).remove();
			$("#pcvt-"+mspcvt).remove();
			
			 $('.indexHS').each(function () {
                 $(this).html(indexHS);
                 indexHS++;
             });
			 
			 $('.indexGiamThi').each(function () {
                 $(this).html(indexGT);
                 indexGT++;
             });
		} ,
		error : function(result) {
			
		}
	});
}

function AjaxThemLopThamGiaThi() {
	var msdt = $("#msdt").val();
	var msl = $("#tenlop").val();
	if (typeof msdt == "undefined") {
		alert("Bạn vui lòng thêm đề thi trước khi lớp tham gia thi!!");
		return;
	}
	$.ajax({
		data: "MaLop="+msl+"&MaDeThi="+msdt,
		url: "AjaxThemLopVaoDeThi",
		type: "POST",
		success : function(result) {
			$("#bang-lop-").attr('id',"bang-lop-"+msdt);
			$("#bang-lop-"+msdt).append(result);
		},
		error : function(result) {
			
		}
	});
}

function AjaxLoadHSTrongLop(){
	var msl = $("#lopxxx").val();
	$.ajax({
		data: "MaLop="+msl,
		url: "AjaxLoadHSTrongLop",
		type: "POST",
		success : function(result) {
			var list = result.split(";");
			for(var k=0; k<list.length-1; k++) {
				$("#tokenizexxx").append($("<option></option>").val(list[k].split("-")[0]).html(list[k].split("-")[1]));
			}
		} ,
		error : function(result) {
			
		}
	});
}

function AjaxThemHSVaoDeThi() {
	var test = 0;
	var listHS = $("#tokenizexxx").val();
	var msdt = $("#msdt").val();
	var mscd = $("#mscd").val();
	var msl = $("#lopxxx").val();
	var mspt = $("#phongThiHS").val();
	var time = $("#inputThoiGianhs").val();
	var timeStart = $("#giobatdauhs").val();
	var timeEnd = $("#gioketthuchs").val();

	if (typeof msdt == "undefined") {
		alert("Bạn vui lòng thêm đề thi trước khi thêm học sinh tham gia thi!!");
		return;
	}
	if (typeof mscd == "undefined") {
		alert("Bạn vui lòng thêm chủ đề trước khi thêm học sinh tham gia thi!!");
		return;
	}
	
	if(time == "") {
		$("#inputThoiGianhs").addClass('empty-input');
		$("#thongbao_inputThoiGianhs").html("<span style='color: #a94442'>Bạn vui lòng chọn ngày thi</span>");
		test++;
	}
	if(timeStart == "") {
		$("#giobatdauhs").addClass('empty-input');
		$("#thongbao_giobatdauhs").html("<span style='color: #a94442'>Bạn vui lòng chọn thời gian bắt đầu thi</span>");
		test++;
	}
	if(timeEnd == "") {
		$("#gioketthuchs").addClass('empty-input');
		$("#thongbao_gioketthuchs").html("<span style='color: #a94442'>Bạn vui lòng chọn thời gian kết thúc thi</span>");
		test++;
	}
	if(test>0) return;
	var xxx = new Object();
	xxx.taiKhoan = listHS;
	xxx.mscd = mscd;
	xxx.msdt = msdt;
	xxx.msl = msl;
	xxx.ngay = time;
	xxx.giobatdau = timeStart;
	xxx.gioketthuc = timeEnd;
	xxx. mspt = mspt;
	
	$.ajax({
		data : JSON.stringify(xxx),
		type : "POST",
		url : "AjaxThemHSVaoDeThi",
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			$("#bang-hs-thi-").attr('id',"bang-hs-thi-"+msdt);
			$("#bang-hs-thi-"+msdt).append(result);

    	},
		error : function(result, e) {
			alert("that bai "+e);
		}
	}); // the end AjaxLuuCauHoiVaCauTraLoi
}

$(document).on('click', '#inputThoiGianhs', function (e) {
	var time = $("#inputThoiGianhs").val();
	$("#inputThoiGianhs").removeClass('empty-input');
	$("#thongbao_inputThoiGianhs").html("");
});

$(document).on('click', '#gioketthuchs', function (e) {
	var time = $("#gioketthuchs").val();
	$("#gioketthuchs").removeClass('empty-input');
	$("#thongbao_gioketthuchs").html("");
});

$(document).on('click', '#giobatdauhs', function (e) {
	var time = $("#giobatdauhs").val();
	$("#giobatdauhs").removeClass('empty-input');
	$("#thongbao_gioibatdauhs").html("");
});

