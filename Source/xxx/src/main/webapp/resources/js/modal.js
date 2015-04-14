var solanthem = 0;
var bid = 0; // Câu trả lời
var sua = 0; // Xét có bấm sửa chưa
var xongCauHoi = 0;// xét có bấm xong câu hỏi chưa;
var socauhoi = 0;
var hoanthanh = 0; // Xét có bấm hoàn thành chưa
var sttCH = 1;
var clickx = 0;
var capnhatkitu = 0;
var dienvaochotrong="";
var tongDiem = 0; //Tính tổng điểm của đề thi


function TaoCauHoi() {
	++socauhoi;
	if(sttCH == 1 || hoanthanh == 1) {
		var result = "";
		result += "<div class='modal fade panelhoanthanh' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'> ";
		result += "<div class='modal-dialog' style='width: 90%;'> ";
		result += "<div class='modal-content'>";
		result += "<div class='modal-header'>";
		result += "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>";
		result += "<div class='modal-title' id='myModalLabel'>";
		result += "<div class='container'>";
		result += "<div class='col-md-2 col-sm-2 col-lg-2'>";
		result += "<h4>Câu &nbsp;"+sttCH+"</h4>";
		result += "</div>";
		result += "<div class='col-md-2 col-sm-2 col-lg-2'>";
		result += "<div class='form-group'>";
		result += "<div class='radio'>";
		result += "<label> ";
		result += "<input type='radio' name='dokhox-"+socauhoi+"' id='doKho-"+socauhoi+"' value='3' checked='checked'> ";
		result += "<span id='idmucdode'>Dễ</span>";
		result += "</label><br> <label> ";
		result += "<input type='radio' name='dokhox-"+socauhoi+"' id='doKho-"+socauhoi+"' value='2'> ";
		result += "<span id='idmucdotrungbinh'>Trung bình</span>";
		result += "</label><br> <label> ";
		result += "<input type='radio' name='dokhox-"+socauhoi+"' id='doKho-"+socauhoi+"' value='1'> ";
		result += "<span id='idmucdokho'>Khó</span>";
		result += "</label>";
		result += "</div>";
		result += "</div>";
		result += "</div>";
		result += "<div class='col-md-2 col-sm-2 col-lg-2'>";
		result += "<div class='form-group'>";
		result += "<span>Điểm cho câu hỏi này là:</span>";
		result += "<input type='text' class='form-control acDiemModal' name='diemChoCauHoix-"+socauhoi+"' id='diemChoCauHoix-"+socauhoi+"' style='width: 100px;' placeholder='Điểm'>";
		result += " <div id='thongbao_loinhapdiemx-"+socauhoi+"'></div>";
		result += "</div>";
		
		result += "</div>";
		result += "<div class='col-md-6 col-sm-6 col-lg-6'>";
		result += "<div class='form-group'>";
		result += "<div class='radio'>";
		result += "<label> ";
		result += "<input type='radio' class='acDangCauHoiModal' name='dangcauhoix-"+socauhoi+"' id='dangCauHoix-"+socauhoi+"-1' value='1' checked='checked'> Chọn câu đúng nhất &nbsp; &nbsp;&nbsp; ";
		result += "</label>";
		result += "<label> ";
		result += "<input type='radio' class='acDangCauHoiModal' name='dangcauhoix-"+socauhoi+"' id='dangCauHoix-"+socauhoi+"-2' value='2'> Chọn nhiều câu đúng &nbsp; &nbsp;&nbsp; ";
		result += "</label> <label> ";
		result += "<input type='radio' class='acDangCauHoiModal' name='dangcauhoix-"+socauhoi+"' id='dangCauHoix-"+socauhoi+"-3' value='3'> Điền vào chổ trống ";
		result += "</label>";
		result += "</div>";
		result += "</div>";
		result += "</div>";
		result += "</div>";
		result += "</div>";
		result += "</div>";
		result += "<div class='modal-body'>";
		result += "<div id='hienthicuahoix-"+socauhoi+"'></div>";
		
	    result += " <section id='editor' style='width: 90%;'>";
	    result += " <textarea id='editorcauhoix-"+socauhoi+"' style='margin-top: 30px; margin-bottom: 10px; display: none;'>";
	    result += " </textarea>";
	    result += " </section>";
	    
	    result += " <section id='buttons'> ";
	    result += " <button id='xong-cau-hoix-"+socauhoi+"' class='btn btn-primary acXongCHModal' style='margin-top: 7px; margin-bottom: 30px; ' >Xong </button> ";
	    result += " <button id='sua-cau-hoix-"+socauhoi+"' style='margin-top: 7px; margin-bottom: 30px;' hidden > Sửa</button>";       
	    result += " </section>";
	    result += " <br>";
	    
	    result += " <div id='themcautraloix-"+socauhoi+"'>";
	    result += " <div class='cautraloi' style='padding-top: 15px; text-align: center'>";             
	    result += " <span style='text-align: center; font-family: Calibri, serif; font-size: 14pt;'>";
	    result += " <strong >Câu trả lời</strong>";
	    result += " </span>";
	    result += " <br>";
	    result += " <table class='table table-hover'>";
	    result += " <thead>";
	    result += "   <!-- Cau tra loi -->          <span style='float: left; padding-left: 10px;font-family: Calibri, serif; font-size: 14pt;'>Đáp án đúng: </span>";
	    result += " <div id='dapandungx-"+socauhoi+"'></div>";
	    result += " <div id='kq-dapandungx-"+socauhoi+"'></div>";
	    result += " </thead>";
	    result += " <tbody style='text-align: left;' id='kq-themcautraloix-"+socauhoi+"'>";
	    result += " </tbody>";
	    result += " </table>";
	    result += " <hr> ";
	    result += " </div>";
	    result += " </div>";
	    
	    result += " <div id='idmschx-"+socauhoi+"'></div>  ";      
	    result += " <div class='form-group' id='idthemcautraloix-"+socauhoi+"'>";
	    result += " <button class='btn btn-primary acThemCauTraLoiModal' id='them-cau-tra-loix-"+socauhoi+"' onclick='ThemCauTraLoi()'>";
	    result += " Thêm câu trả lời &nbsp;<span class='glyphicon glyphicon-plus'></span>";
	    result += " </button>";
	    result += " </div>";
	    result += "</div>";
		result += "<div class='modal-footer'>";
		result += "<button type='button' class='btn btn-primary acHoanThanh' id='hoan-thanh-"+socauhoi+"' onclick='HoanThanh("+socauhoi+")'>Hoàn thành&nbsp;<span class='glyphicon glyphicon-ok'></span></button>";
		result += "<button type='button' class='btn btn-danger acHuyCH' id='huy-cau-hoi-"+socauhoi+"' data-dismiss='modal'>Hủy &nbsp;<span class='glyphicon glyphicon-remove'></span></button>";
		result += "<button hidden type='button' class='acThoat' id='thoat' data-dismiss='modal'>Thoát &nbsp;<span class='glyphicon glyphicon-log-out'></span></button>";
		result += "</div>";
		result += "</div>";
		result += "</div>";
		result += "</div>";
		document.getElementById('xxx').innerHTML = result;
		$("#editorcauhoix-"+socauhoi).editable({inlineMode: false});
		hoanthanh = 0;
	} else {
		alert("Bạn chưa hoàn thành câu hỏi trước. Vui lòng kiểm tra lại!");
		return;
	}
}




    	$(document).ready(function(){
    		
    	//******************************************************************************************	
    		
    		
    		//OK
    		 $(document).on('keyup', '.acDiemModal', function(){
    			 var stt = $(this).attr('id').split("-")[1];
    			 var DiemValue = $(this).val();
    			 var diemTam;
    			 
    			 diemTam = new Number(tongDiem) + new Number(DiemValue);
    			 if(diemTam > 10) {
    				$("#thongbao_loinhapdiemx-"+stt).addClass("input-error-taikhoan");
                  	$("#diemChoCauHoix-"+stt).addClass("input-error-taikhoan1");
                    $("#thongbao_loinhapdiemx-"+stt).html("<span>Tổng điểm của các câu hỏi đã lớn hơn 10 ("+diemTam+")</span>");
                    return;
    			 } else {
    				 $("#thongbao_loinhapdiemx-"+stt).html("");
    			 }
    			 if(DiemValue.length == 0) {
                 	$("#thongbao_loinhapdiemx-"+stt).addClass("input-error-taikhoan");
                 	$("#diemChoCauHoix-"+stt).addClass("input-error-taikhoan1");
                     $("#thongbao_loinhapdiemx-"+stt).html('<span>Điểm không được bỏ trống</span>');
                 }
                 else
                 {
                     if(DiemValue == '0') {
                     	$("#thongbao_loinhapdiemx-"+stt).addClass("input-error-taikhoan");
                     	$("#diemChoCauHoix-"+stt).addClass("input-error-taikhoan1");
                     	$("#thongbao_loinhapdiemx-"+stt).html('Điểm phải khác 0');
                       return;
                     }
                     if(jQuery.isNumeric(DiemValue)) {
                     	$("#thongbao_loinhapdiemx-"+stt).removeClass("input-error-taikhoan");
                     	$("#diemChoCauHoix-"+stt).removeClass("input-error-taikhoan1");
                         $("#thongbao_loinhapdiemx-"+stt).html('');
                     }
                     else {
                     	$("#thongbao_loinhapdiemx-"+stt).addClass("input-error-taikhoan");
                     	$("#diemChoCauHoix-"+stt).addClass("input-error-taikhoan1");
                         $("#thongbao_loinhapdiemx-"+stt).html('<span>Điểm phải là số</span>');
                     }
                 }
    		 });
// OK
    		 $(document).on('click', '.acSuaCHModal', function (e) {
    			 dienvaochotrong = "";
    			 console.log("Initializing Froala Editor...");
    			 var sttCauHoi = $(this).attr('id').split("-")[3];
    			 $("#hienthicuahoix-"+sttCauHoi).html('');
    			 $("#editorcauhoix-"+sttCauHoi).show();
		         $('#editorcauhoix-'+sttCauHoi).editable({inlineMode: false});
		         if($('#editorcauhoix-'+sttCauHoi).val().length == 0) {
		//        	$("#xong-cau-hoi-"+sttCauHoi).attr("onclick", "LuuCauHoi("+maDeThi+")"); //???
		        	$("#xong-cau-hoix-"+sttCauHoi).prop("class", "btn btn-primary acXongCHModal");
		    		$("#xong-cau-hoix-"+sttCauHoi).show();
		    		$("#sua-cau-hoix-"+sttCauHoi).hide();
		         }
		        $("#diemChoCauHoix-"+sttCauHoi).prop("disabled", false);
    			$("#xong-cau-hoix-"+sttCauHoi).prop("class", "btn btn-primary acXongCHModal");
    			$("#xong-cau-hoix-"+sttCauHoi).show();
    			$("#sua-cau-hoix-"+sttCauHoi).hide();
    		});
		        
		        var varDangCauHoi; // trả về dạng câu hỏi đã chọn, dùng để xử lý ở những hàm sau.
		        $(document).on('change', '.acDangCauHoiModal', function(){
		        	var sttCauHoi = $(this).attr('id').split("-")[1];
		        	var dangCHValue = $(this).attr('id').split("-")[2];
		        	if(dangCHValue == 2) {
		        		varDangCauHoi = 2;
		        		$("#idthemcautraloix-"+sttCauHoi).show();
		        		$(".table-hover").show();
		        		$("#dapandungx-"+sttCauHoi).show();
		        		var k;
		        		for (k=1; k<=bid; k++) {
		        			$("#iddapandungx-"+sttCauHoi+"-"+k).prop('type', 'checkbox');
		        		}
		        	} else if(dangCHValue == 1) {
		        		varDangCauHoi = 1;
		        		$("#idthemcautraloix-"+sttCauHoi).show();
		        		$(".table-hover").show();
		        		$("#dapandungx-"+sttCauHoi).show();
		        		var k;
		        		for (k=1; k<=bid; k++) {
		        			$("#iddapandungx-"+sttCauHoi+"-"+k).prop('type', 'radio');
		        		}
		        	} else if(dangCHValue == 3) {
		        		dienvaochotrong = "";
		        		varDangCauHoi = 3;
		        		$("#idthemcautraloix-"+sttCauHoi).hide();
		        		$(".table-hover").hide();
		        		$(".dapandungx-"+sttCauHoi).hide();
		        	}
		        });
		        

//OK 
		        $(document).on('click', '.acXongCHModal', function (e) {
		        	var tam = 0;
		        	var sttCauHoi = $(this).attr('id').split("-")[3];
	    			var DiemValue = $("#diemChoCauHoix-"+sttCauHoi).val();
	    			var cut = "";
	    			var arrayKetQuaDienVaoChoTrong = new Array();
	    			var dapandienvaochotrong = "";
	    			var diemTam;
	    			 
	    			 
	    			if(varDangCauHoi == 3) {
	    				var cauHoiContent = $("#editorcauhoix-"+sttCauHoi).val();
	    				cut = cauHoiContent.split("<strike>");
	    				for(var k=1; k<cut.length; k++) {
	    					arrayKetQuaDienVaoChoTrong.push(cut[k].split('</strike>')[0]);
	    					dienvaochotrong +="<>"+arrayKetQuaDienVaoChoTrong[k-1];
	    				}
	    				for (var j=0; j<arrayKetQuaDienVaoChoTrong.length; j++) {
	    					dapandienvaochotrong+="("+(j+1)+")&nbsp;&nbsp;&nbsp;&nbsp;"+arrayKetQuaDienVaoChoTrong[j].trim()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    				}
	    				$("#dapandungx-"+sttCauHoi).html("<span id='dapandienvaochotrongx-"+sttCauHoi+"'>"+dapandienvaochotrong+"</span>");
	    			}
	    			diemTam = new Number(tongDiem) + new Number(DiemValue);
	    			 if(diemTam > 10) {
	    				$("#thongbao_loinhapdiemx-"+stt).addClass("input-error-taikhoan");
	                  	$("#diemChoCauHoix-"+stt).addClass("input-error-taikhoan1");
	                    $("#thongbao_loinhapdiemx-"+stt).html("<span>Tổng điểm của các câu hỏi đã lớn hơn 10 ("+diemTam+")</span>");
	                    tam++;
	    			 } else {
	    			 }
	    			 
	    			if(DiemValue.length == 0) {
	                 	$("#thongbao_loinhapdiemx-"+sttCauHoi).addClass("input-error-taikhoan");
	                 	$("#diemChoCauHoix-"+sttCauHoi).addClass("input-error-taikhoan1");
	                    $("#thongbao_loinhapdiemx-"+sttCauHoi).html('<span>Điểm không được bỏ trống</span>');
	                    tam++;
	                 } else {}
	    			if($("#editorcauhoix-"+sttCauHoi).val().length == 1) {
			        	$("#hienthicuahoix-"+sttCauHoi).html("<span style='color: #a94442'>Lưu ý: câu hỏi không được bỏ trống</span>");
			        	tam++;
			        } else {
			        }
    			 
	    			if(tam>0) return;
	    			xongCauHoi = 1;
	    			$("#diemChoCauHoix-"+sttCauHoi).prop("disabled", true);
	    			$("#hienthicuahoix-"+sttCauHoi).html($('#editorcauhoix-'+sttCauHoi).val());
			        $('#editorcauhoix-'+sttCauHoi).editable('destroy');
			        $("#editorcauhoix-"+sttCauHoi).hide();
	    			$("#sua-cau-hoix-"+sttCauHoi).prop("class", "btn btn-primary acSuaCHModal");
	    			$("#sua-cau-hoix-"+sttCauHoi).show();
	    			$("#xong-cau-hoix-"+sttCauHoi).hide();
		        });
    		
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx		        
		        $(document).on('click', '.acHuyCHModal', function (e) {
		        /*	 var sttCauHoi = $(this).attr('id').split("-")[3];
		        	 $("#themcauhoi-"+sttCauHoi).hide();
		        	 --sttCH;*/
		        });
		   
// OK
		    
		    $(document).on('click', '.acThemCauTraLoiModal', function (e) {
		    	var sttCauHoi = $(this).attr('id').split("-")[4];// lấy số thứ tự câu hỏi
		    	
		    		bid++;
		    		capnhatkitu++;
		    		solanthem++;
		    	if(solanthem > 1) {
			    	var kiemtra = solanthem - 1; //trừ 1 để kiểm tra câu trước có rỗng không.
			    	var hienthi = $("#hienthicautraloix-"+sttCauHoi+"-"+kiemtra);
			    	var rong = hienthi.html();
			    	if( hienthi.html().length == 0 || rong == "<span style=\"color: #a94442\">Lưu ý: Câu trả lời không được bỏ trống</span>" ) {
			    		alert("Nội dung câu trả lời trước chưa hoàn thành. Vui lòng kiểm tra lại.");
			    		solanthem--;
			    		return;
			    	}
			    	
		    	}
		    	var ketqua="";
		    	var kitu = String.fromCharCode(solanthem+64);
		         ketqua+="<tr id='tr-"+sttCauHoi+"-"+bid+"'>";
		        
		         ketqua+=	"<th>";
		         ketqua+=		"<div id='capnhatkytux-"+sttCauHoi+"-"+bid+"'><span>"+kitu+".</span></div>";
		         ketqua+=	"</th>";
		         ketqua+=	"<td>";
		         ketqua+=		"<div id='hienthicautraloix-"+sttCauHoi+"-"+bid+"' class='ctl"+sttCauHoi+"'></div>";
		         ketqua+=		"<section id='editor' style='width: 95%; margin-top: 15px; margin-bottom: 15px;'>";
		         ketqua+=			"<textarea id='editorcautraloix-"+sttCauHoi+"-"+bid+"' style='margin-top: 30px; margin-bottom: 10px;'></textarea>";
		         ketqua+=		"</section>";
		         ketqua+=	"</td>";
		         ketqua+=	"<th>";
		         ketqua+=		"<section id='buttons'>" ;
		         ketqua+=			"<button style='margin-top: 7px; margin-bottom: 30px;'"; 
		         ketqua+=			"id='luu-cau-tra-loix-"+sttCauHoi+"-"+bid+"' onclick='LuuCauTraLoi()' hidden >Lưu </button>";
		         ketqua+=			"<button id='xong-cau-tra-loix-"+sttCauHoi+"-"+bid+"' onclick='XongCauTraLoi("+bid+")' style='margin-top: 7px; margin-bottom: 30px;' class='btn btn-success acXongCTLModal'>Xong </button>";
		         ketqua+=			"<button class='pull-right acSuaCTLModal' id='sua-cau-tra-loix-"+sttCauHoi+"-"+bid+"' style='margin-top: 7px; margin-bottom: 30px;' hidden > Sửa</button>";
		         ketqua+=			"<button id='xoa-cau-tra-loix-"+sttCauHoi+"-"+bid+"' name='xoa-cau-tra-loix-"+sttCauHoi+"-"+bid+"' onclick='XoaCauTraLoi("+bid+")' class='btn btn-danger acXoaCTLModal'>Xóa</button>";
		         ketqua+=		"</section>";
		         ketqua+=	"</th>";
		         ketqua+="</tr>";
		         document.getElementById("kq-themcautraloix-"+sttCauHoi).innerHTML+= ketqua;
		         $("#editorcautraloix-"+sttCauHoi+"-"+bid).editable({inlineMode: false});
		    });
//OK	    
		    $(document).on('click', '.acXongCTLModal', function (e) {
		    	
		    	var sttCauHoi = $(this).attr('id').split("-")[4];
		    	var sttCTL = $(this).attr('id').split("-")[5];
		    	var maDangCauHoi = jQuery("input[name=dangcauhoix-"+sttCauHoi+"]:checked").val();
		    	var typeMaDangCauHoi = "";
		    	if(maDangCauHoi == 1) {
		    		typeMaDangCauHoi = 'radio';
		    	} else if(maDangCauHoi == 2) {
		    		typeMaDangCauHoi = 'checkbox';
		    	} 
		    	
		    	var capnhatkitu = $("#idClickx").val();
	    		capnhatkitu = new Number(capnhatkitu);
	    		var kitu = String.fromCharCode(solanthem + 64);
	    		var editor = $("#editorcautraloix-"+sttCauHoi+"-"+sttCTL);
	    		var hienthi = $("#hienthicautraloix-"+sttCauHoi+"-"+sttCTL);
	  			 if(editor.val().length == 0) {
			        	hienthi.html("<span style='color: #a94442'>Lưu ý: Câu trả lời không được bỏ trống</span>");
			        	return;
			        } else {
			        	hienthi.html(editor.val());
			        }
	  			editor.editable('destroy');
	  			editor.hide();
	  			if(sua==0) {
	  				$("#dapandungx-"+sttCauHoi).append("<input name='dapandungx-"+sttCauHoi+"' class='dapandungx-"+sttCauHoi+"' type='"+typeMaDangCauHoi+"' id='iddapandungx-"+sttCauHoi+"-"+sttCTL+"'><span id='kitux-"+sttCauHoi+"-"+sttCTL+"'style='margin-left: 10px; margin-right: 40px;'>"+kitu+"</span>");
	  			} else {
	  				sua = 0;
	  			}
	  			$("#sua-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).prop("class", "btn btn-success acSuaCTLModal");
	  			$("#sua-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).show();
	  			$("#xong-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).hide();
		    });
		    
		    

//OK
		    $(document).on('click', '.acSuaCTLModal', function (e) {
		    	var sttCauHoi = $(this).attr('id').split("-")[4];
		    	var sttCTL = $(this).attr('id').split("-")[5];
		    	
		    	$("#editorcautraloix-"+sttCauHoi+"-"+sttCTL).show().html($("#hienthicautraloix-"+sttCauHoi+"-"+sttCTL).html());
	   			$("#hienthicautraloix-"+sttCauHoi+"-"+sttCTL).html('');
			     $("#editorcautraloix-"+sttCauHoi+"-"+sttCTL).editable({inlineMode: false});
			     if($("#editorcautraloix-"+sttCauHoi+"-"+sttCTL).val().length == 0) {
			    	$("#xong-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).attr("onclick", "XongCauTraLoi("+sttCTL+")");
			        $("#xong-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).prop("class", "btn btn-success");
			    	$("#xong-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).show();
			    	$("#sua-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).hide();
			     }
	   			$("#xong-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).prop("class", "btn btn-success acXongCTLModal");
	   			$("#xong-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).show();
	   			$("#sua-cau-tra-loix-"+sttCauHoi+"-"+sttCTL).hide();
	   			sua++;
		    });
		    
//OK
		    $(document).on('click', '.acXoaCTLModal', function (e) {
		    	var sttCauHoi = $(this).attr('id').split("-")[4];
		    	var sttCTL = $(this).attr('id').split("-")[5];
		    	$("#tr-"+sttCauHoi+"-"+sttCTL).remove();
	    		$("#iddapandungx-"+sttCauHoi+"-"+sttCTL).remove();
	    		$("#kitux-"+sttCauHoi+"-"+sttCTL).remove();
	    		var maxClick = solanthem;
	    		var j;
	    		for(j=1; j<solanthem; j++)
	    		{
	    			$("#capnhatkytux-"+sttCauHoi+"-"+(j+1)).html('');
	    			$("#capnhatkytux-"+sttCauHoi+"-"+(j+1)).html("<span>"+String.fromCharCode(j+64)+".</span>");
	    			$("#kitux-"+sttCauHoi+"-"+(j+1)).html('');
	    			$("#kitux-"+sttCauHoi+"-"+(j+1)).html("<span>"+String.fromCharCode(j+64)+"</span>");
	    		}
	    		solanthem--;
		    	
		    });
		    
    	}); // ket thuc document.ready(function());
    	
    	

