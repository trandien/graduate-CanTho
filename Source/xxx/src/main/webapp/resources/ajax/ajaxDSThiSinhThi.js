/*
$(document).ready(function () {
    var interval = 3000;   //number of mili seconds between each call
    var refresh = function() {
    	var dsthisinh = [];
        $.ajax({
            url: "AjaxLayDSDangThi",
            cache: false,
            type: "GET",
            data : "MaDeThi="+$("#msdt").val(),
            success: function(result) {
            	dsthisinh = result.split("-");
                setTimeout(function() {
                    refresh();
                }, interval);
            }
        });
    };
    refresh();
});
*/


$(document).on('click', '.onoffswitch-checkbox', function (e) {
	var id = $(this).attr('id');
	var taiKhoan = $(this).attr('name');
	var kt = jQuery("input[name="+taiKhoan+"]:checked").val();
	if(kt == 'on') {
		$.ajax({
			data: "MaDeThi="+$("#msdt").val()+"&TaiKhoan="+taiKhoan,
			type: "POST",
			url: "AjaxMoBaiThi",
			success : function (result) {
				
			},
			error : function(result) {
				
			}
		});
	} else {
		$.ajax({
			data: "MaDeThi="+$("#msdt").val()+"&TaiKhoan="+taiKhoan,
			type: "POST",
			url: "AjaxKhoaBaiThi",
			success : function (result) {
				
			},
			error : function(result) {
				
			}
		});
	}
});

$(document).ready(function () {
	var soCoMat = 0;
        $.ajax({
            url: "AjaxLayDSDangThi",
            cache: false,
            type: "GET",
            data : "MaDeThi="+$("#msdt").val(),
            success: function(result) {
            	dsthisinh = result.split(";");
            	for(var k=0; k<dsthisinh.length - 1; k++) {
            		soCoMat ++;
            		$("#comat-"+dsthisinh[k].split("-")[0]).attr('id', 'comat');
            		$("#diem-"+dsthisinh[k].split("-")[0]).html(dsthisinh[k].split("-")[1]);
            		$("#check-"+dsthisinh[k].split("-")[0]).prop('disabled', false);
            		if(dsthisinh[k].split("-")[2] == 'true') {
            			$("#check-"+dsthisinh[k].split("-")[0]).prop('checked', false);
            		}
            	}
            }, 
            error : function (result) {
            	
            }
        });
});

$(document).on('change', '#xemdiem-lop', function (e) {
	var tenLop = $(this).val();
	if(tenLop == "0") {
		
	} else {
		$.ajax({
			data: "MaDeThi="+$("#msdt").val() + "&MaLop="+tenLop,
			url: "AjaxXemDanhSachKQThi",
			type: "GET",
			success : function (result) {
				$("#table-diem").html(result);
				$.ajax({
		            url: "AjaxLayDSDangThi",
		            cache: false,
		            type: "GET",
		            data : "MaDeThi="+$("#msdt").val(),
		            success: function(result) {
		            	dsthisinh = result.split(";");
		            	for(var k=0; k<dsthisinh.length - 1; k++) {
		            		$("#DiemThi-"+dsthisinh[k].split("-")[0]).html(dsthisinh[k].split("-")[1]);
		            		$("#VangThi-"+dsthisinh[k].split("-")[0]).html("");
		            		if(dsthisinh[k].split("-")[2] == 'true') {
		            			$("#BiKhoa-"+dsthisinh[k].split("-")[0]).html("<span class='glyphicon glyphicon-remove' style='color: red;'></span>");
		            		}
		            		
		            	}
		            }, 
		            error : function (result) {
		            	
		            }
		        });
			} , 
			error : function (result) {
				$("#table-diem").html("<h3>HTTP Status 404 - Không thể kết nối đến máy chủ</h3>");
			}
		});
	}
});
