$(document).ready(function () {
	var khoa = 0;
	var khongKhoa = 0;
    var interval = 4000;  
    var refresh = function() {
    	var dsthisinh = [];
        $.ajax({
            url: "AjaxKiemTraKhoaThiSinh",
            cache: false,
            type: "GET",
            data : "MaDeThi="+$("#msdt").val(),
            success: function(result) {
                setTimeout(function() {
                    refresh();
                }, interval);
                if(result == 'true') {
                	if(khoa == 0) {
                		alert("Bài thi của bạn đã bị giám thị khóa");
                		khoa = 1;
                	}
                	$(".radio-answer").each(function() {
                        $(this).prop('disabled', true);
                    });
                	$(".checkbox-answer").each(function() {
                        $(this).prop('disabled', true);
                    });
                	$(".dienvaochotrong").each(function() {
                        $(this).prop('disabled', true);
                    });
                } else {
                	if(khongKhoa != 0) {
                		alert("Bài thi của bạn đã được giám thị mở khóa");
                		khongKhoa = 0;
                	}
                	$(".radio-answer").each(function() {
                        $(this).prop('disabled', false);
                    });
                	$(".checkbox-answer").each(function() {
                        $(this).prop('disabled', false);
                    });
                	$(".dienvaochotrong").each(function() {
                        $(this).prop('disabled', false);
                    });
                }
            }
        });
    };
    refresh();
});	


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
	
	$(document).on('change', '.checkbox-answer', function (e) {
		var msch = $(this).attr('id').split("-")[0];
		var msctl = $(this).attr('id').split("-")[1];
		var name = $(this).attr('name');
		var ketQuaChon = "";
	
		var selected = [];
		$("#checkbox-"+msch+" input:checked").each(function() {
		    selected.push($(this).attr('id').split("-")[1]);
		});
		for(k=0; k<selected.length; k++) {
			ketQuaChon+=selected[k]+"-";
		}
		$.ajax({
			data: "MaCauHoi="+msch,
			url : "AjaxKiemTraCHCoDuocChon",
			type: "POST",
			success : function(kq){
				if(kq=="false") {
					$.ajax({
						
						data: "MaCauHoi="+msch+"&MaCauTraLoi="+ketQuaChon,
						url: "AjaxLuuKQThi",
						type: "POST",
						success : function(result) {
						},
						error : function(result) {
							
						}
					});
				} else {
					$.ajax({
						data: "MaCauHoi="+msch+"&MaCauTraLoi="+ketQuaChon,
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
	
	$(document).on('keyup', '.dienvaochotrong', function (e) {
		var msch = $(this).attr('id').split("-")[0];
		var name = $(this).attr('name');
		var noiDungDien = document.getElementsByName(name);
		var arrayNoiDungDien = new Array();
		var ketQuaChon = "";
		for(key=0; key < noiDungDien.length; key++)  {
			ketQuaChon+= noiDungDien[key].value.trim() + "-";
			
		}
		$.ajax({
			data: "MaCauHoi="+msch,
			url : "AjaxKiemTraCHCoDuocChon",
			type: "POST",
			success : function(kq){
				if(kq=="false") {
					$.ajax({
						
						data: "MaCauHoi="+msch+"&MaCauTraLoi="+ketQuaChon,
						url: "AjaxLuuKQThi",
						type: "POST",
						success : function(result) {
						},
						error : function(result) {
							
						}
					});
				} else {
					$.ajax({
						data: "MaCauHoi="+msch+"&MaCauTraLoi="+ketQuaChon,
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
	
	
	
	
	
	
	
