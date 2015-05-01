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
