function LuuCauTraLoi() {
	$.ajax({
		data: "MaCauHoi="+$("#msch").val() + "&NoiDungCTL="+$("#editorcautraloi").val(), 
		url: "AjaxLuuCauTraLoi",
		type: "POST",
		success: function(result) {
			alert("Them cau tra loi thanh cong");
		}, 
		error: function () {
			alert("Them cau tra loi that bai");
		}
	});
}

function ThemCauTraLoi() {
	
    $.ajax({
    	data:"MaDeThi="+$("#msdt").val(),
    	url: "AjaxLayMaxIdCauHoi",
    	type: "POST",
    	success: function(result) {
    		$("#idmsch").html("<input type='hidden' id='msch' name = 'msch' value='"+result+"'>");
    	},
    	error: function() {
    		
    	}
    });
}