
function AjaxSuaCauHoi(msch){
	var tam;
	var isCheck = [];
	var diem = $("#diemChoCauHoi-"+msch).val();
	var noidungcauhoi = $("#editorcauhoi-"+msch).val();
	var dapandung;
	
	$.each($("input[name='dapandung-"+msch+"']:checked"), function(){            
    	isCheck.push($(this).attr('id'));
    });
	$("#kq-dapandung-"+msch).hide();
	
	 if(isCheck.length == 1) {
     	tam = isCheck[0].split("-")[2];
        	dapandung = $("#hienthicautraloi-"+msch+"-"+tam).html();
        	$("#kq-dapandung-"+msch).html(dapandung);
    } else if(isCheck.length > 1){
         for(var k=0; k<isCheck.length; k++) {
         	tam = isCheck[k].split("-")[2];
         	dapandung = $("#hienthicautraloi-"+msch+"-"+tam).html();
         	$("#kq-dapandung-"+msch).append(dapandung);
         }
    	} else {
    		// trường hợp điền vào chổ trống sẽ lấy đáp án trực tiếp từ câu hỏi.
    	//	$("#kq-dapandung-"+i).html(dienvaochotrong);
    	}
	 
	$.ajax({
		data: "MaCauHoi="+msch+"&DapAnDung="+dapandung+"&Diem="+diem+"&NoiDungCauHoi="+noidungcauhoi,
		type: "POST",
		url: "AjaxSuaCauHoi",
		success: function(result) {
			alert("Sua cau hoi thanh cong");
		},
		error: function(result) {
			alert("Loi khi Sua cau hoi");
		}
	});
}

function AjaxXoaCauHoi(msch){
	$.ajax({
		data: "MaCauHoi="+msch,
		type: "POST",
		url: "AjaxXoaCauHoi",
		success: function(result) {
			alert("Xoa cau hoi thanh cong");
			$("#themcauhoi-"+msch).remove();
		},
		error: function(result) {
			alert("Loi khi xoa cau hoi");
		}
	});
}

function LuuCauHoi() {
	var maDangCauHoi = jQuery('input[name=dangcauhoi]:checked').val()
	var maDoKho = jQuery('input[name=dokho2]:checked').val()
	var noiDungCauHoi = $("#edit2").val();
	var diem = $("#diemChoCauHoi1").val();
	var dapAnDung = $("#dapAnDung").val();
	var msdt = $("#msdt").val();

	if (typeof msdt == "undefined") {
		alert("Ban phai them de thi truoc khi them cau hoi");
		return;
	}
	$.ajax({
		data : "MaDeThi=" + msdt + "&MaDangCauHoi=" + maDangCauHoi
				+ "&MaDoKho=" + maDoKho + "&NoiDungCauHoi=" + noiDungCauHoi
				+ "&Diem=" + diem + "&DapAnDung=" + dapAnDung,
		type : "POST",
		url : "AjaxLuuCauHoi",
		success : function(result) {

			$("#luu-cau-hoi").hide();
			$("#sua-cau-hoi").prop("class", "btn btn-primary");
			$("#sua-cau-hoi").show();
			$("#xoa-cau-hoi").prop("class", "btn btn-danger");
			$("#xoa-cau-hoi").show();
			console.log("Destroying Froala Editor...");
			$('#edit2').editable('destroy');
			$("#edit2").hide();
			alert("Them cau hoi thanh cong");
		},
		error : function() {
			alert("Thêm câu hỏi bị lỗi");
		}
	});
}

function AjaxSuaDoKho(msch){
	var maDoKho = jQuery("input[name=dokho-"+msch+"]:checked").val(); 
		$.ajax({
		data: "MaCauHoi="+msch+"&MaDoKho="+maDoKho,
		url: "AjaxSuaDoKho",
		type: "POST",
		success: function(result) {
			
		},
		error: function (result){
			
		}
	});
}

function AjaxSuaDangCauHoi(msch){
	var maDangCauHoi = jQuery("input[name=dangcauhoi-"+i+"]:checked").val();
		$.ajax({
		data: "MaCauHoi="+msch+"&MaDangCauHoi="+maDangCauHoi,
		url: "AjaxSuaDangCauHoi",
		type: "POST",
		success: function(result) {
			
		},
		error: function (result){
			
		}
	});
}

function AjaxSuaDapAnDung(msch){
	var tam;
	var isCheck = [];
	var noidungcauhoi = $("#editorcauhoi-"+msch).val();
	var dapandung;
	
	$.each($("input[name='dapandung-"+msch+"']:checked"), function(){            
    	isCheck.push($(this).attr('id'));
    });
	$("#kq-dapandung-"+msch).hide();
	
	 if(isCheck.length == 1) {
     	tam = isCheck[0].split("-")[2];
        	dapandung = $("#hienthicautraloi-"+msch+"-"+tam).html();
        	$("#kq-dapandung-"+msch).html(dapandung);
    } else if(isCheck.length > 1){
         for(var k=0; k<isCheck.length; k++) {
         	tam = isCheck[k].split("-")[2];
         	dapandung = $("#hienthicautraloi-"+msch+"-"+tam).html();
         	$("#kq-dapandung-"+msch).append(dapandung);
         }
    	} else {
    		// trường hợp điền vào chổ trống sẽ lấy đáp án trực tiếp từ câu hỏi.
    	//	$("#kq-dapandung-"+i).html(dienvaochotrong);
    	}
	 alert(dapandung);
		$.ajax({
		data: "MaCauHoi="+msch+"&DapAnDung="+dapandung,
		url: "AjaxSuaDapAnDung",
		type: "POST",
		success: function(result) {
			
		},
		error: function (result){
			
		}
	});
}

