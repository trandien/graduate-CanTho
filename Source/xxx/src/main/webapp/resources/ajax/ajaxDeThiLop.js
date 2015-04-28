function AjaxLuuDeThiLop(){
	var msdt = $("#msdt").val();
	$.ajax({
		data: "MaCauHoi="+msch,
		type: "POST",
		url: "AjaxXoaCauHoi",
		success: function(result) {
			$("#themcauhoi-"+msch).remove();
			AjaxCapNhatSoLuongCH(msdt);
		},
		error: function(result) {
			alert("Loi khi xoa cau hoi");
		}
	});
}