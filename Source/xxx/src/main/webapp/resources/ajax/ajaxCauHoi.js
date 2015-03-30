function TaoCauHoi() {
	
			$("#themcauhoi").show();
		
}

function LuuCauHoi() {
	var maDangCauHoi= jQuery('input[name=dangcauhoi]:checked' ).val()
	var maDoKho = jQuery('input[name=dokho2]:checked' ).val()
	var noiDungCauHoi = $("#edit2").val();
	var diem = $("#diemChoCauHoi1").val();
	var dapAnDung = $("#dapAnDung").val();
	var msdt = $("#msdt").val();
	
	if(typeof msdt == "undefined") {
		alert("Ban phai them de thi truoc khi them cau hoi");
		return;
	}
	$.ajax({
		data : "MaDeThi=" + msdt + "&MaDangCauHoi="
				+ maDangCauHoi + "&MaDoKho=" + maDoKho + "&NoiDungCauHoi="
				+ noiDungCauHoi + "&Diem=" + diem + "&DapAnDung=" + dapAnDung,
		type : "POST",
		url : "AjaxLuuCauHoi",
		success : function(result) {
			
			$("#luu-cau-hoi").hide();
			$("#sua-cau-hoi").prop("class","btn btn-primary");
			$("#sua-cau-hoi").show();
			$("#xoa-cau-hoi").prop("class","btn btn-danger");
			$("#xoa-cau-hoi").show();
			  console.log("Destroying Froala Editor...");
			  $('#edit2').editable('destroy');
			  $("#edit2").hide();
			alert("Them cau hoi thanh cong");
		},
		error : function() {
			alert("Thêm câu hỏi bị lỗi");
		}
	});
}

function ThemCauTraLoi() {
	var sttCauTraLoi = $("#laysothutucautraloi").val();
	sttCauTraLoi++;
	$("#laysothutucautraloi").val(sttCauTraLoi)
	var kitu = String.fromCharCode(sttCauTraLoi);
	$("#sttcautraloi").html("<span style='margin-left: 15px;'>"+kitu+".</span>");
	
}






