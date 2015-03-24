function TaoCauHoi() {
	$.ajax({
		data : "MaChuDe="+$("#mscd").val(),
		type : "POST",
		url : "AjaxLayMaxIdCauHoi",
		success : function(result) {
			$("#tencauhoi").html("<strong style='font-size: 20px;' id='doimautheodokho'>Câu &nbsp;"+result +"</strong>");
			$("#themcauhoi").show();
		},
		error : function() {
			alert("Tao Cau Hoi that bai");
		}

	});
}