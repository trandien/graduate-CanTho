	$(document).on('change', '.radio-answer', function (e) {
		var msch = $(this).attr('id').split("-")[0];
		var msctl = $(this).attr('id').split("-")[1];
		$.ajax({
			data: "MaCauHoi="+msch,
			url : "AjaxKiemTraCHCoDuocChon",
			type: "POST",
			success : function(kq){
				if(kq=="false") {
					$.ajax({
						data: "MaCauHoi="+msch+"&MaCauTraLoi="+msctl,
						url: "AjaxLuuKQThi",
						type: "POST",
						success : function(result) {
							
						},
						error : function(result) {
							
						}
					});
				} else {
					$.ajax({
						data: "MaCauHoi="+msch+"&MaCauTraLoi="+msctl,
						url: "AjaxSuaKQThi",
						type: "POST",
						success : function(result) {
						},
						error : function(result) {
							
						}
					});
				}
			} ,
			error : function(kq, e) {
				alert("Loi AjaxKiemTraCHCoDuocChon "+kq + "- "+e);
			}
		});
			
	});
	
	function xxx() {
		
	}