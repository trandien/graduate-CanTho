function AjaxLuuDeThiLop(){
	var test = 0;
	var msdt = $("#msdt").val();
	var msl = $("#tenlop").val();
	var mspt = $("#phongthiL").val();
	var ngay = $("#ngaythiL").val();
	var timeStart = $("#giobatdauLop").val();
	var timeEnd = $("#gioketthucLop").val();
	if (typeof msdt == "undefined") {
		alert("Bạn vui lòng thêm đề thi trước khi thêm giám thị!!");
		return;
	}
	
	if(ngay == "") {
		$("#ngaythiL").addClass('empty-input');
		$("#thongbao_ngaythi").html("<span style='color: #a94442'>Bạn vui lòng chọn ngày thi</span>");
		test++;
	}
	if(timeStart == "") {
		$("#giobatdauLop").addClass('empty-input');
		$("#thongbao_giobatdauLop").html("<span style='color: #a94442'>Bạn vui lòng chọn thời gian bắt đầu thi</span>");
		test++;
	}
	if(timeEnd == "") {
		$("#gioketthucLop").addClass('empty-input');
		$("#thongbao_gioketthucLop").html("<span style='color: #a94442'>Bạn vui lòng chọn thời gian kết thúc thi</span>");
		test++;
	}
	if(test>0) return;
	$.ajax({
		data: "MaDeThi="+msdt+"&MaLop="+msl+"&MaPhongThi="+mspt+"&NgayThi="+ngay+"&GioBatDau="+timeStart+"&GioKetThuc="+timeEnd,
		type: "POST",
		url: "AjaxLuuDeThiLop",
		success: function(result) {
			var stt = 0;
			$("#bang-lop-").attr('id',"bang-lop-"+msdt);
			stt = $("#bang-lop-"+msdt+" > tr").length;
			++stt;
			$("#bang-lop-"+msdt).append(result);
			$("#pcvt-" + msdt + "-"+msl+" > .indexL").html(stt);
		},
		error: function(result) {
			alert("Loi de thi lop");
		}
	});
}

$(document).on('click', '#ngaythiL', function (e) {
	var time = $("#ngaythiL").val();
	$("#ngaythiL").removeClass('empty-input');
	$("#thongbao_ngaythi").html("");
});

$(document).on('click', '#gioketthucLop', function (e) {
	var time = $("#gioketthucLop").val();
	$("#gioketthucLop").removeClass('empty-input');
	$("#thongbao_gioketthucLop").html("");
});

$(document).on('click', '#giobatdauLop', function (e) {
	var time = $("#giobatdauLop").val();
	$("#giobatdauLop").removeClass('empty-input');
	$("#thongbao_giobatdauLop").html("");
});

$(document).on('click', '.XoaDeThiLop', function(e){
	var id = $(this).attr('id');
	var msdt = id.split("-")[0];
	var msl = id.split("-")[1];
	$.ajax({
		data: "MaDeThi="+msdt+"&MaLop="+msl,
		url: "AjaxXoaDeThiLop",
		type: "POST",
		success : function(result) {
			var indexL = 1;
			$("#pcvt-"+msdt+"-"+msl).remove();
			$('.indexL').each(function () {
                $(this).html(indexL);
                indexL++;
            });
		},
		error : function(result) {
			alert("Xóa thất bại");
		}
	});
});







