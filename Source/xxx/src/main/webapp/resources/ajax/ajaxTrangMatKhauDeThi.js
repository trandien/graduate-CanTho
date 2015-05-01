
//Kiểm tra mật khẩu đề thi
function CheckPassTest(){
	var msdt = $("#msdt").val();
	var matKhauNhap = $("#inputMatKhauDeThi").val();
	$.ajax({ // Kiểm tra mật khẩu đề thi
		data: "MaDeThi="+msdt +"&MatKhauNhap="+matKhauNhap,
		url: "AjaxKiemTraMatKhauDeThi",
		type: "POST",
		success : function(result) {
			if(result.length != 0) {
				$("#thongbao_nhapmatkhaudethi").html("");
				
				$.ajax({ // Kiểm tra số lần cho phép thi
					data: "MaDeThi="+msdt,
					url: "AjaxKiemTraSoLanChoPhep",
					type: "POST",
					success : function(kq) {
						if(kq.length == 0) {
							window.location.href = "Test.html?msdt="+msdt;
							
							$.ajax({
								data: "MaDeThi="+msdt+"&SoLanThi="+kq,
								url: "AjaxTaoBangThiSinhThi",
								type: "POST",
								success : function(create) {
									
								},
								error : function(error) {
									
								}
							});
						} else {
							$("#thongbao_nhapmatkhaudethi").html("<span style='color: #a94442'>Số lần cho phép thi của bạn đã hết!</span>");
						}
					} ,
					error : function(kq) {
						}
					});
			} else {
				$("#thongbao_nhapmatkhaudethi").html("<span style='color: #a94442'>Mật khẩu sai. Vui lòng kiểm tra lại!</span>");
			}
		},
		error : function(result) {
			
		}
	});
}











