
//Kiểm tra mật khẩu đề thi

function CheckPassTest(){
	var msdt = $("#msdt").val();
	var matKhauNhap = $("#inputMatKhauDeThi").val();
	$.ajax({
		data: "MaDeThi="+msdt +"&MatKhauNhap="+matKhauNhap,
		url: "AjaxKiemTraMatKhauDeThi",
		type: "POST",
		success : function(result) {
			if(result.length != 0) {
				$("#thongbao_nhapmatkhaudethi").html("");
				window.location.href = "Test.html?msdt="+msdt;
			} else {
				$("#thongbao_nhapmatkhaudethi").html("<span style='color: #a94442'>Mật khẩu sai. Bạn vui lòng kiểm tra lại!</span>");
			}
		},
		error : function(result) {
			
		}
	});
}