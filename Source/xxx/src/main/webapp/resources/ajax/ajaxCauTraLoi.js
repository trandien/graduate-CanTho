function LuuCauTraLoi(msch) {
	$.ajax({
		data: "MaCauHoi="+msch.val() + "&NoiDungCTL="+$("#editorcautraloi").val(), 
		url: "AjaxLuuCauTraLoi",
		type: "POST",
		success: function(result) {
			alert("Them cau tra loi thanh cong");
		}, 
		error: function () {
			alert("Them cau hoi that bai");
		}
	});
}