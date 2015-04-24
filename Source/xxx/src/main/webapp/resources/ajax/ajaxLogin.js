function ajaxDangKy(){
	$.ajax({
		data: "taiKhoan=" + $("#taiKhoan").val() + "&email=" + $("#email").val(),
		type: "POST",
		url : "AjaxDangKy",
		success : function(result) {
			if(result.length == 0)
			{
				$("#thongbao_taikhoan").html("<strong>Tài khoản đã có người sử dụng</strong>")					
			}
			else
			{
				
			}
		},
		error : function() {
			//alert("ERROR");
		}
	});
}

function ajaxKTTaiKhoan(){
	$.ajax({
		data: "taiKhoan=" + $("#taiKhoan").val(),
		type: "POST",
		url : "AjaxDangKy",
		success : function(result) {
			if(result.length == 0)
			{
				$("#thongbao_taikhoan").html("<strong>Tài khoản đã có người sử dụng</strong>")				
			}
			else
			{
				
			}
		},
		error : function() {
			//alert("ERROR");
		}
	});
}