var dienvaochotrong="";
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
	 	var tam = 0;
		var DiemValue = $("#diemChoCauHoi-"+msch).val();
		var cut = "";
		var arrayKetQuaDienVaoChoTrong = new Array();
		var dapandienvaochotrong = "";
		var diemTam;
		var varDangCauHoi = jQuery("input[name=dangcauhoi-"+msch+"]:checked").val();
		
		if(varDangCauHoi == 3) {
			var cauHoiContent = $("#editorcauhoi-"+msch).val();
			cut = cauHoiContent.split("<strike>");
			for(var k=1; k<cut.length; k++) {
				arrayKetQuaDienVaoChoTrong.push(cut[k].split('</strike>')[0]);
				dienvaochotrong +="<>"+arrayKetQuaDienVaoChoTrong[k-1];
			}
			for (var j=0; j<arrayKetQuaDienVaoChoTrong.length; j++) {
				dapandienvaochotrong+="("+(j+1)+")&nbsp;&nbsp;&nbsp;&nbsp;"+arrayKetQuaDienVaoChoTrong[j].trim()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			$("#dapandung-"+msch).html("<span id='dapandienvaochotrong-"+msch+"'>"+dapandienvaochotrong+"</span>");
		}
		 diemTam = new Number(tongDiem) + new Number(DiemValue);
		 if(diemTam > 10) {
			$("#thongbao_loinhapdiem-"+msch).addClass("input-error-taikhoan");
	       	$("#diemChoCauHoi-"+msch).addClass("input-error-taikhoan1");
	        $("#thongbao_loinhapdiem-"+msch).html("<span>Tổng điểm của các câu hỏi đã lớn hơn 10 ("+diemTam+")</span>");
	        tam++;
		 } else {
		 }
		 
		if(DiemValue.length == 0) {
	      	$("#thongbao_loinhapdiem-"+msch).addClass("input-error-taikhoan");
	      	$("#diemChoCauHoi-"+msch).addClass("input-error-taikhoan1");
	        $("#thongbao_loinhapdiem-"+msch).html('<span>Điểm không được bỏ trống</span>');
	        tam++;
		} else {}
		if($("#editorcauhoi-"+msch).val().length == 0) {
	     	$("#hienthicuahoi-"+msch).html("<span style='color: #a94442'>Lưu ý: Câu hỏi không được bỏ trống</span>");
	     	tam++;
	     } else {
	     }
	 
		if(tam>0) return;
		
	$.ajax({
		data: "MaCauHoi="+msch+"&DapAnDung="+dapandung+"&Diem="+diem+"&NoiDungCauHoi="+noidungcauhoi,
		type: "POST",
		url: "AjaxSuaCauHoi",
		success: function(result) {
		
			$("#diemChoCauHoi-"+msch).prop("disabled", true);
			$("#hienthicuahoi-"+msch).html($('#editorcauhoi-'+msch).val());
	        $('#editorcauhoi-'+msch).editable('destroy');
	        $("#editorcauhoi-"+msch).hide();
			$("#sua-cau-hoi-"+msch).prop("class", "btn btn-primary acSuaCH");
			$("#sua-cau-hoi-"+msch).show();
			$("#xong-cau-hoi-"+msch).hide();
		},
		error: function(result) {
			alert("Loi khi Sua cau hoi");
		}
	});
}

function AjaxXoaCauHoi(msch){
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

function LuuCauHoi() {
	var maDangCauHoi = jQuery('input[name=dangcauhoi]:checked').val();
	var maDoKho = jQuery('input[name=dokho2]:checked').val();
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
			var msdt = $("#msdt").val();
			AjaxCapNhatSoLuongCH(msdt);
		},
		error: function (result){
			alert("cap nhat msch that bai");
		}
	});
}

function AjaxSuaDangCauHoi(msch){
	var maDangCauHoi = jQuery("input[name=dangcauhoi-"+msch+"]:checked").val();
		$.ajax({
		data: "MaCauHoi="+msch+"&MaDangCauHoi="+maDangCauHoi,
		url: "AjaxSuaDangCauHoi",
		type: "POST",
		success: function(result) {
			$.ajax({
				url: "AjaxLaySoLuongCauTraLoi",
				data: "MaCauHoi="+msch, 
				type: "POST",
				success : function(soluong) {
					var bid = new Number(soluong);
					
					$.ajax({
				   		 data: "MaCauHoi="+msch,
				   		 url: "AjaxLayListIdCTL",
				   		 type: "POST",
				   		 success : function(list) {
				   			 listIdCTL = list.split("-");
				   			if(maDangCauHoi == 2) {
				        		$("#idthemcautraloi-"+msch).show();
				        		$(".table-hover").show();
				        		$("#dapandung-"+msch).show();
				        		var k;
				        		for(var k=0; k<listIdCTL.length; k++) {
				        			$("#iddapandung-"+msch+"-"+listIdCTL[k]).prop('type', 'checkbox');
				        		}
				        	} else if(maDangCauHoi == 1) {
				        		$("#idthemcautraloi-"+msch).show();
				        		$(".table-hover").show();
				        		$("#dapandung-"+msch).show();
				        		var k;
				        		for(var k=0; k<listIdCTL.length; k++) {
				        			$("#iddapandung-"+msch+"-"+listIdCTL[k]).prop('type', 'radio');
				        		}
				        	} else if(maDangCauHoi == 3) {
				        		dienvaochotrong = "";
				        		varDangCauHoi = 3;
				        		$("#idthemcautraloi-"+msch).hide();
				        		$(".table-hover").remove();
				        		$("#dapandung-"+msch).html('');
				        	}
				   		 },
				   		 error : function(list){
				   			 // AjaxLayListIdCTL
				   		 }
					}); // The end AjaxLayListIdCTL
					
				},
				error: function(soluong){
					//AjaxLaySoLuongCauTraLoi
					}
				}); // The end AjaxLaySoLuongCauTraLoi
			
		},
		error: function (result){
			//AjaxSuaDangCauHoi
		}
	}); // The end AjaxSuaDangCauHoi
}

function AjaxSuaDapAnDung(msch){
	var tam;
	var isCheck = [];
	var noidungcauhoi = $("#editorcauhoi-"+msch).val();
	var dapandung;
	var listCauTraLoi = new Array();
	$(".ctl"+msch).each(function() {
		listCauTraLoi.push($(this).html());
	});
	
	$.each($("input[name='dapandung-"+msch+"']:checked"), function(){            
    	isCheck.push($(this).attr('id'));
    });
	$("#kq-dapandung-"+msch).hide();
	$("#kq-dapandung-"+msch).html("");
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
   		$("#kq-dapandung-"+msch).html("");
   	}
		$.ajax({
		data: "MaCauHoi="+msch+"&DapAnDung="+$("#kq-dapandung-"+msch).html(),
		url: "AjaxSuaDapAnDung",
		type: "POST",
		success: function(result) {
			
		},
		error: function (result){
			
		}
	});
}

function AjaxCapNhatSoLuongCH(msdt){
	$.ajax({
		data: "MaDeThi="+msdt,
		url: "AjaxLaySLCauHoi",
		type: "POST",
		success : function(result) {
			var soLuongCauHoi = new Number(result);
			$.ajax({
				url: "AjaxLayListDoKho",
				data: "MaDeThi="+msdt,
				type: "POST",
				success : function(list) {
					var listDoKho = list.split("-");
					$("#themsoluongcauhoi").html('');
				
					var typeDoKho = "";
					var socaude = 0;
					var socaukho = 0;
					var socautrungbinh = 0;
					for(var k=1; k<=soLuongCauHoi; k++) {
						if(listDoKho[k-1]=="3") {
							typeDoKho = "caude";
							++socaude;
						} else if(listDoKho[k-1]=="2") {
							typeDoKho = "cautrungbinh";
							++socautrungbinh;
						} else if(listDoKho[k-1]=="1") {
							typeDoKho = "caukho";
							++socaukho;
						}
						$("#themsoluongcauhoi").append("<span class='"+typeDoKho+"'>"+k+"</span>");
						$("#socaude").val(socaude);
						$("#socaukho").val(socaukho);
						$("#socautrungbinh").val(socautrungbinh);
					}
				},
				error : function(list) {
					
				}
			});
			
			$.ajax({
					url: "AjaxLayListIdCH",
					data: "MaDeThi="+msdt,
					type: "POST",
					success : function(list) {
						var listIdCH = list.split("-");
						for(var k=1; k<=soLuongCauHoi; k++){
							$("#tencauhoi-"+listIdCH[k-1]).html("<h3>Câu &nbsp;"+k+"</h3><h3></h3>");
						}
					},
					error: function() {
						
					}
				});
			
		},
		error: function(result) {
			alert("Loi khi cap nhat so luong")
		}
	});
}

