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
var socautraloi = 0;

function showCauHoi(maDangCauHoi, maDoKho, noiDungCauHoi, diem, dapAnDung, msdt, listCauTraLoi, msch) {
	var stt = sttCH;
	var result = "";
	result += " <div id='themcauhoi-"+msch+"' style='border: 1px solid #000077;  margin-bottom: 15px;'> ";
	result += "<input type='hidden' name='msch-"+msch+"' id='msch-"+msch+"' value='"+msch+"'>";
	result += " <div class='container-fluid'>";
	result += " <div class='row'>";
	result += " <div class='col-md-2 col-sm-2 col-lg-2 col-xs-2'> ";
	result += " <div id='tencauhoi-"+msch+"'><h3>Câu &nbsp;"+stt+"<h3></div>";
	result += " <div class='form-group'>";
	result += " <div class='radio'>";
	result += " <label> <input type='radio' onclick='AjaxSuaDoKho("+msch+")' name='dokho-"+msch+"' id='dokho-"+msch+"-3' value='3' > ";
	result += " <span id='idmucdode'>Dễ</span>";
	result += " </label><br> <label> <input onclick='AjaxSuaDoKho("+msch+")' type='radio' name='dokho-"+msch+"' id='dokho-"+msch+"-2' value='2'> ";
	result += " <span	id='idmucdotrungbinh'>Trung bình</span>";
	result += " </label><br> <label> <input onclick='AjaxSuaDoKho("+msch+")' type='radio' name='dokho-"+msch+"' id='dokho-"+msch+"-1' value='1'> ";
	result += " <span id='idmucdokho'>Khó</span>";
	result += " </label>";
	result += " </div>";
	result += " </div>";
	
	result += " <div id='icon-delete-cauhoi' class='card-delete' style='width: 30px; height: 30px;'>";
	result += " <span title='Xóa câu hỏi' data-toggle='modal' href='#modal-id' class='glyphicon glyphicon-trash' style='height: 30px; font-size: 30px; margin-top: 20px;'></span>";
	result += " </div>";
	
	result += " </div>";
	
	result += " <div class='col-md-10 col-sm-10 col-lg-10 col-xs-10'>";
	result += " <div class='form-group'>";
	result += " <div class='radio'>";
	result += " <label> ";
	result += " <input type='radio' onclick='AjaxSuaDangCauHoi("+msch+")' class='acDangCauHoi' name='dangcauhoi-"+msch+"' id='dangCauHoi-"+msch+"-1' value='1' checked='checked'>";
	result += " Chọn câu đúng nhất &nbsp; &nbsp;&nbsp;";
	result += " </label> <label> ";
	result += " <input type='radio' onclick='AjaxSuaDangCauHoi("+msch+")' class='acDangCauHoi' name='dangcauhoi-"+msch+"' id='dangCauHoi-"+msch+"-2' value='2'> Chọn nhiều câu đúng &nbsp; &nbsp;&nbsp; ";
	result += " </label> <label> ";
	result += " <input type='radio' onclick='AjaxSuaDangCauHoi("+msch+")' class='acDangCauHoi' name='dangcauhoi-"+msch+"' id='dangCauHoi-"+msch+"-3' value='3'> Điền vào chổ trống ";
	result += " </label>";
	result += " </div>";
	result += " </div>";
	result += " <div class='form-group'>";
	result += " <span>Điểm cho câu hỏi này là:</span><input value='"+diem+"' disabled type='text' class='form-control acDiem' name='diemChoCauHoi-"+msch+"' id='diemChoCauHoi-"+msch+"' style='width: 100px;'>";
	result += " <div id='thongbao_loinhapdiem-"+msch+"'></div>";
	result += " </div>";
	result += "<div id='hienthicuahoi-"+msch+"'>"+noiDungCauHoi+"</div>";
	result += " <section id='editor' style='width: 95%;'>";
	result += " <textarea id='editorcauhoi-"+msch+"' style='margin-top: 30px; margin-bottom: 10px; display: none;'>";
	result += " </textarea>";
	result += " </section>";
	result += " <section id='buttons'> ";
	result += " <button hidden id='xong-cau-hoi-"+msch+"' onclick='AjaxSuaCauHoi("+msch+")' style='margin-top: 7px; margin-bottom: 30px; ' >Xong </button> ";
	result += " <button id='sua-cau-hoi-"+msch+"'  class='btn btn-primary acSuaCH' style='margin-top: 7px; margin-bottom: 30px;' hidden > Sửa</button>";				
	result += " </section>";
	result += " </div>";
	result += " <br>";
	result += " <div id='themcautraloi-"+msch+"'>";
	result += " <div class='cautraloi' style='padding-top: 15px; text-align: center'>";							
	result += " <span style='text-align: center; font-family: Calibri, serif; font-size: 14pt;'>";
	result += " <strong >Câu trả lời</strong>";
	result += " </span>";
	result += " <br>";
	result += " <table class='table table-hover'>";
	result += " <thead>";
	result += "<span style='float: left; padding-left: 10px;font-family: Calibri, serif; font-size: 14pt;'>Đáp án đúng: </span>";
	result += " <div id='dapandung-"+msch+"'></div>";
	result += " <div id='kq-dapandung-"+msch+"'></div>";
	result += " </thead>";
	result += " <tbody style='text-align: left;' id='kq-themcautraloi-"+msch+"'>";
	result += " </tbody>";
	result += " </table>";
	result += " <hr> ";
	result += " </div>";
	result += " </div>";
	result += " <div id='idmsch-"+msch+"'></div>";			
	result += " <div class='form-group' id='idthemcautraloi-"+msch+"'>";
	result += " <button class='btn btn-success acThemCauTraLoi' id='them-cau-tra-loi-"+msch+"' onclick='ThemCauTraLoi()'>";
	result += " Thêm câu trả lời &nbsp;<span class='glyphicon glyphicon-plus'></span>";
	result += " </button>";
	result += " </div>";
	result += " </div>";
	result += " </div>";
	result += " </div>";
	result += " </div>";
	result += ModalXoaCauHoi(msch);
	
     
	return result;
}

function ModalXoaCauHoi(msch){
	var result = "";
	result += " <div class='modal fade' id='modal-id'>";
	result += " 		<div class='modal-dialog'>";
	result += " 			<div class='modal-content'>";
	result += " 				<div class='modal-header'>";
	result += " 	<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>&times;</button>";
	result += " 	<h4 class='modal-title'>Thông báo</h4>";
	result += " 				</div>";
	result += " 				<div class='modal-body'>";
	result += " Bạn muốn xóa câu hỏi.<br> <b>";
	result += " Lưu ý: </b>khi xóa không thể";
	result += " 					khôi phục lại được ";
	result += " 				</div>";
	result += " 				<div class='modal-footer'>";
	result += " 					<button type='button' class='btn btn-default' data-dismiss='modal'>Đóng</button>";
	result += " <button type='button' class='btn btn-primary' onclick='AjaxXoaCauHoi("+msch+")' data-dismiss='modal'>Đồng ý</button>";
	result += " 				</div>";
	result += " 			</div>";
	result += " 		</div>";
	result += " 	</div> ";
	
	return result;
}

function ThemCTL(listCauTraLoi, msch) {
	var ketqua="";
	socautraloi = listCauTraLoi.length;
	var k;
	var kitu ="";
	for(k=0; k<socautraloi; k++) {
		kitu = String.fromCharCode(k+1+64);
		ketqua+="<tr id='tr-"+msch+"-"+(k+1)+"'>";
	     ketqua+=	"<th>";
	     ketqua+=		"<div id='capnhatkytu-"+msch+"-"+(k+1)+"'><span>"+kitu+".</span></div>";
	     ketqua+=	"</th>";
	     ketqua+=	"<td>";
	     ketqua+=		"<div id='hienthicautraloi-"+msch+"-"+(k+1)+"' class='ctl"+msch+"'>"+listCauTraLoi[k]+"</div>";
	     ketqua+=		"<section id='editor' style='width: 95%; margin-top: 15px; margin-bottom: 15px;'>";
	     ketqua+=			"<textarea hidden id='editorcautraloi-"+msch+"-"+(k+1)+"' style='margin-top: 30px; margin-bottom: 10px;'></textarea>";
	     ketqua+=		"</section>";
	     ketqua+=	"</td>";
	     ketqua+=	"<th>";
	     ketqua+=		"<section id='buttons'>" ;
	     ketqua+=			"<button hidden id='xong-cau-tra-loi-"+msch+"-"+(k+1)+"' onclick='XongCauTraLoi("+(k+1)+")' style='margin-top: 7px; margin-bottom: 30px;'>Xong </button>";
	     ketqua+=			"<button class='btn btn-success acSuaCTL' id='sua-cau-tra-loi-"+msch+"-"+(k+1)+"' onclick='SuaCauTraLoi("+(k+1)+")' style='margin-top: 7px; margin-bottom: 30px;' > Sửa</button>";
	     ketqua+=			"<button id='xoa-cau-tra-loi-"+msch+"-"+(k+1)+"' name='xoa-cau-tra-loi-"+msch+"-"+(k+1)+"' onclick='XoaCauTraLoi("+(k+1)+")' class='btn btn-danger acXoaCTL'>Xóa</button>";
	     ketqua+=		"</section>";
	     ketqua+=	"</th>";
	     ketqua+="</tr>";
	}
     return ketqua;
}
// iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
function LayDapAnDung(listCauTraLoi, maDangCauHoi, msch) {
	
	var ketqua = new Array();
	if(maDangCauHoi == 1 || maDangCauHoi == 2) {
		var cut = listCauTraLoi.split("<p>");
		for(var k=1; k<cut.length; k++) {
			ketqua.push(cut[k].split('</p>')[0]);
		}
	} else if(maDangCauHoi == 3) { //??
		var cut = listCauTraLoi.split("<strike>");
		for(var k=1; k<cut.length; k++) {
			ketqua.push(cut[k].split('</strike>')[0]);
		}
	}
	
	for(var k=0; k<listCauTraLoi.length; k++) {
		$("#dapandung-" + msch).append(
				"<input onclick='AjaxSuaDapAnDung("+msch+")' name='dapandung-" + msch + "' class='dapandung-"
						+ msch + "' type='" + radio
						+ "' id='iddapandung-" + msch + "-" + sttCTL
						+ "'><span id='kitu-" + msch + "-" + sttCTL
						+ "'style='margin-left: 10px; margin-right: 40px;'>"
						+ kitu + "</span>");
	}
}

    	$(document).ready(function(){
    		
    	//******************************************************************************************	
    		
    		
    		//OK
    		 $(document).on('keyup', '.acDiem', function(){
    			 var stt = $(this).attr('id').split("-")[1];
    			 var DiemValue = $(this).val();
    			 var diemTam;
    			 
    			 diemTam = new Number(tongDiem) + new Number(DiemValue);
    			 if(diemTam > 10) {
    				$("#thongbao_loinhapdiem-"+stt).addClass("input-error-taikhoan");
                  	$("#diemChoCauHoi-"+stt).addClass("input-error-taikhoan1");
                    $("#thongbao_loinhapdiem-"+stt).html("<span>Tổng điểm của các câu hỏi đã lớn hơn 10 ("+diemTam+")</span>");
                    return;
    			 } else {
    				 $("#thongbao_loinhapdiem-"+stt).html("");
    			 }
    			 if(DiemValue.length == 0) {
                 	$("#thongbao_loinhapdiem-"+stt).addClass("input-error-taikhoan");
                 	$("#diemChoCauHoi-"+stt).addClass("input-error-taikhoan1");
                     $("#thongbao_loinhapdiem-"+stt).html('<span>Điểm không được bỏ trống</span>');
                 }
                 else
                 {
                     if(DiemValue == '0') {
                     	$("#thongbao_loinhapdiem-"+stt).addClass("input-error-taikhoan");
                     	$("#diemChoCauHoi-"+stt).addClass("input-error-taikhoan1");
                     	$("#thongbao_loinhapdiem-"+stt).html('Điểm phải khác 0');
                       return;
                     }
                     if(jQuery.isNumeric(DiemValue)) {
                     	$("#thongbao_loinhapdiem-"+stt).removeClass("input-error-taikhoan");
                     	$("#diemChoCauHoi-"+stt).removeClass("input-error-taikhoan1");
                         $("#thongbao_loinhapdiem-"+stt).html('');
                     }
                     else {
                     	$("#thongbao_loinhapdiem-"+stt).addClass("input-error-taikhoan");
                     	$("#diemChoCauHoi-"+stt).addClass("input-error-taikhoan1");
                         $("#thongbao_loinhapdiem-"+stt).html('<span>Điểm phải là số</span>');
                     }
                 }
    		 });
    		 
    		 
// OK
    		 $(document).on('click', '.acSuaCH', function (e) {
    			 var sttCauHoi = $(this).attr('id').split("-")[3];
    			 dienvaochotrong = "";
    			 var noidungcauhoitam = "";
    			 noidungcauhoitam = $("#hienthicuahoi-"+sttCauHoi).html();
    			 $("#hienthicuahoi-"+sttCauHoi).html('');
    			 $("#editorcauhoi-"+sttCauHoi).show();
    			 $("#editorcauhoi-"+sttCauHoi).html(noidungcauhoitam);
    			 
		         $('#editorcauhoi-'+sttCauHoi).editable({inlineMode: false});
		         if($('#editorcauhoi-'+sttCauHoi).val().length == 0) {
		//        	$("#xong-cau-hoi-"+sttCauHoi).attr("onclick", "LuuCauHoi("+maDeThi+")"); //???
		        	$("#xong-cau-hoi-"+sttCauHoi).prop("class", "btn btn-primary acXongCH");
		    		$("#xong-cau-hoi-"+sttCauHoi).show();
		    		$("#sua-cau-hoi-"+sttCauHoi).hide();
		         }
		        $("#diemChoCauHoi-"+sttCauHoi).prop("disabled", false);
    			$("#xong-cau-hoi-"+sttCauHoi).prop("class", "btn btn-primary acXongCH");
    			$("#xong-cau-hoi-"+sttCauHoi).show();
    			$("#sua-cau-hoi-"+sttCauHoi).hide();
    		});
		        
		        var varDangCauHoi; // trả về dạng câu hỏi đã chọn, dùng để xử lý ở những hàm sau.
		        $(document).on('change', '.acDangCauHoi', function(){
		        	var sttCauHoi = $(this).attr('id').split("-")[1];
		        	var dangCHValue = $(this).attr('id').split("-")[2];
		        	if(dangCHValue == 2) {
		        		varDangCauHoi = 2;
		        		$("#idthemcautraloi-"+sttCauHoi).show();
		        		$(".table-hover").show();
		        		$("#dapandung-"+sttCauHoi).show();
		        		var k;
		        		for (k=1; k<=bid; k++) {
		        			$("#iddapandung-"+sttCauHoi+"-"+k).prop('type', 'checkbox');
		        		}
		        	} else if(dangCHValue == 1) {
		        		varDangCauHoi = 1;
		        		$("#idthemcautraloi-"+sttCauHoi).show();
		        		$(".table-hover").show();
		        		$("#dapandung-"+sttCauHoi).show();
		        		var k;
		        		for (k=1; k<=bid; k++) {
		        			$("#iddapandung-"+sttCauHoi+"-"+k).prop('type', 'radio');
		        		}
		        	} else if(dangCHValue == 3) {
		        		dienvaochotrong = "";
		        		varDangCauHoi = 3;
		        		$("#idthemcautraloi-"+sttCauHoi).hide();
		        		$(".table-hover").hide();
		        		$(".dapandung-"+sttCauHoi).hide();
		        	}
		        });

//OK 
		        $(document).on('click', '.acXongCH', function (e) {
		        	var tam = 0;
		        	var sttCauHoi = $(this).attr('id').split("-")[3];
	    			var DiemValue = $("#diemChoCauHoi-"+sttCauHoi).val();
	    			var cut = "";
	    			var arrayKetQuaDienVaoChoTrong = new Array();
	    			var dapandienvaochotrong = "";
	    			var diemTam;
	    			if(varDangCauHoi == 3) {
	    				var cauHoiContent = $("#editorcauhoi-"+sttCauHoi).val();
	    				cut = cauHoiContent.split("<strike>");
	    				for(var k=1; k<cut.length; k++) {
	    					arrayKetQuaDienVaoChoTrong.push(cut[k].split('</strike>')[0]);
	    					dienvaochotrong +="<>"+arrayKetQuaDienVaoChoTrong[k-1];
	    				}
	    				for (var j=0; j<arrayKetQuaDienVaoChoTrong.length; j++) {
	    					dapandienvaochotrong+="("+(j+1)+")&nbsp;&nbsp;&nbsp;&nbsp;"+arrayKetQuaDienVaoChoTrong[j].trim()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	    				}
	    				$("#dapandung-"+sttCauHoi).html("<span id='dapandienvaochotrong-"+sttCauHoi+"'>"+dapandienvaochotrong+"</span>");
	    			}
	    			diemTam = new Number(tongDiem) + new Number(DiemValue);
	    			 if(diemTam > 10) {
	    				$("#thongbao_loinhapdiem-"+stt).addClass("input-error-taikhoan");
	                  	$("#diemChoCauHoi-"+stt).addClass("input-error-taikhoan1");
	                    $("#thongbao_loinhapdiem-"+stt).html("<span>Tổng điểm của các câu hỏi đã lớn hơn 10 ("+diemTam+")</span>");
	                    tam++;
	    			 } else {
	    			 }
	    			 
	    			if(DiemValue.length == 0) {
	                 	$("#thongbao_loinhapdiem-"+sttCauHoi).addClass("input-error-taikhoan");
	                 	$("#diemChoCauHoi-"+sttCauHoi).addClass("input-error-taikhoan1");
	                    $("#thongbao_loinhapdiem-"+sttCauHoi).html('<span>Điểm không được bỏ trống</span>');
	                    tam++;
	                 } else {}
	    			if($("#editorcauhoi-"+sttCauHoi).val().length == 1) {
			        	$("#hienthicuahoi-"+sttCauHoi).html("<span style='color: #a94442'>Lưu ý: câu hỏi không được bỏ trống</span>");
			        	tam++;
			        } else {
			        }
    			 
	    			if(tam>0) return;
	    			xongCauHoi = 1;
	    			$("#diemChoCauHoi-"+sttCauHoi).prop("disabled", true);
	    			$("#hienthicuahoi-"+sttCauHoi).html($('#editorcauhoi-'+sttCauHoi).val());
			        $('#editorcauhoi-'+sttCauHoi).editable('destroy');
			        $("#editorcauhoi-"+sttCauHoi).hide();
	    			$("#sua-cau-hoi-"+sttCauHoi).prop("class", "btn btn-primary acSuaCH");
	    			$("#sua-cau-hoi-"+sttCauHoi).show();
	    			$("#xong-cau-hoi-"+sttCauHoi).hide();
		        });
    		
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx		        
		        $(document).on('click', '.acHuyCH', function (e) {
		        	 var sttCauHoi = $(this).attr('id').split("-")[3];
		        	 $("#themcauhoi-"+sttCauHoi).hide();
		        	 --sttCH;
		        });
		   
// OK
		    
		    $(document).on('click', '.acThemCauTraLoi', function (e) {
		    	var sttCauHoi = $(this).attr('id').split("-")[4];// lấy số thứ tự câu hỏi
		    	
		    		bid++;
		    		capnhatkitu++;
		    		solanthem++;
		    	if(solanthem > 1) {
			    	var kiemtra = solanthem - 1; //trừ 1 để kiểm tra câu trước có rỗng không.
			    	var hienthi = $("#hienthicautraloi-"+sttCauHoi+"-"+kiemtra);
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
		         ketqua+=		"<div id='capnhatkytu-"+sttCauHoi+"-"+bid+"'><span>"+kitu+".</span></div>";
		         ketqua+=	"</th>";
		         ketqua+=	"<td>";
		         ketqua+=		"<div id='hienthicautraloi-"+sttCauHoi+"-"+bid+"' class='ctl"+sttCauHoi+"'></div>";
		         ketqua+=		"<section id='editor' style='width: 95%; margin-top: 15px; margin-bottom: 15px;'>";
		         ketqua+=			"<textarea id='editorcautraloi-"+sttCauHoi+"-"+bid+"' style='margin-top: 30px; margin-bottom: 10px;'></textarea>";
		         ketqua+=		"</section>";
		         ketqua+=	"</td>";
		         ketqua+=	"<th>";
		         ketqua+=		"<section id='buttons'>" ;
		         ketqua+=			"<button style='margin-top: 7px; margin-bottom: 30px;'"; 
		         ketqua+=			"id='luu-cau-tra-loi-"+sttCauHoi+"-"+bid+"' onclick='LuuCauTraLoi()' hidden >Lưu </button>";
		         ketqua+=			"<button id='xong-cau-tra-loi-"+sttCauHoi+"-"+bid+"' onclick='XongCauTraLoi("+bid+")' style='margin-top: 7px; margin-bottom: 30px;' class='btn btn-success acXongCTL'>Xong </button>";
		         ketqua+=			"<button class='pull-right acSuaCTL' id='sua-cau-tra-loi-"+sttCauHoi+"-"+bid+"' onclick='SuaCauTraLoi("+bid+")' style='margin-top: 7px; margin-bottom: 30px;' hidden > Sửa</button>";
		         ketqua+=			"<button id='xoa-cau-tra-loi-"+sttCauHoi+"-"+bid+"' name='xoa-cau-tra-loi-"+sttCauHoi+"-"+bid+"' onclick='XoaCauTraLoi("+bid+")' class='btn btn-danger acXoaCTL'>Xóa</button>";
		         ketqua+=		"</section>";
		         ketqua+=	"</th>";
		         ketqua+="</tr>";
		         document.getElementById("kq-themcautraloi-"+sttCauHoi).innerHTML+= ketqua;
		         $("#editorcautraloi-"+sttCauHoi+"-"+bid).editable({inlineMode: false});
		    });
//OK	    
		    $(document).on('click', '.acXongCTL', function (e) {
		    	
		    	var sttCauHoi = $(this).attr('id').split("-")[4];
		    	var sttCTL = $(this).attr('id').split("-")[5];
		    	var maDangCauHoi = jQuery("input[name=dangcauhoi-"+sttCauHoi+"]:checked").val();
		    	var typeMaDangCauHoi = "";
		    	if(maDangCauHoi == 1) {
		    		typeMaDangCauHoi = 'radio';
		    	} else if(maDangCauHoi == 2) {
		    		typeMaDangCauHoi = 'checkbox';
		    	} 
		    	
		    	var capnhatkitu = $("#idClickx").val();
	    		capnhatkitu = new Number(capnhatkitu);
	    		var kitu = String.fromCharCode(solanthem + 64);
	    		var editor = $("#editorcautraloi-"+sttCauHoi+"-"+sttCTL);
	    		var hienthi = $("#hienthicautraloi-"+sttCauHoi+"-"+sttCTL);
	  			 if(editor.val().length == 0) {
			        	hienthi.html("<span style='color: #a94442'>Lưu ý: Câu trả lời không được bỏ trống</span>");
			        	return;
			        } else {
			        	hienthi.html(editor.val());
			        }
	  			editor.editable('destroy');
	  			editor.hide();
	  			if(sua==0) {
	  				$("#dapandung-"+sttCauHoi).append("<input name='dapandung-"+sttCauHoi+"' class='dapandung-"+sttCauHoi+"' type='"+typeMaDangCauHoi+"' id='iddapandung-"+sttCauHoi+"-"+sttCTL+"'><span id='kitu-"+sttCauHoi+"-"+sttCTL+"'style='margin-left: 10px; margin-right: 40px;'>"+kitu+"</span>");
	  			} else {
	  				sua = 0;
	  			}
	  			$("#sua-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).prop("class", "btn btn-success acSuaCTL");
	  			$("#sua-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).show();
	  			$("#xong-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).hide();
		    });

//OK
		    $(document).on('click', '.acSuaCTL', function (e) {
		    	var sttCauHoi = $(this).attr('id').split("-")[4];
		    	var sttCTL = $(this).attr('id').split("-")[5];
		    	
		    	$("#editorcautraloi-"+sttCauHoi+"-"+sttCTL).show().html($("#hienthicautraloi-"+sttCauHoi+"-"+sttCTL).html());
	   			$("#hienthicautraloi-"+sttCauHoi+"-"+sttCTL).html('');
			     $("#editorcautraloi-"+sttCauHoi+"-"+sttCTL).editable({inlineMode: false});
			     if($("#editorcautraloi-"+sttCauHoi+"-"+sttCTL).val().length == 0) {
			    	$("#xong-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).attr("onclick", "XongCauTraLoi("+sttCTL+")");
			        $("#xong-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).prop("class", "btn btn-success");
			    	$("#xong-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).show();
			    	$("#sua-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).hide();
			     }
	   			$("#xong-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).prop("class", "btn btn-success acXongCTL");
	   			$("#xong-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).show();
	   			$("#sua-cau-tra-loi-"+sttCauHoi+"-"+sttCTL).hide();
	   			sua++;
		    });
		    
//OK
		    $(document).on('click', '.acXoaCTL', function (e) {
		    	var sttCauHoi = $(this).attr('id').split("-")[4];
		    	var sttCTL = $(this).attr('id').split("-")[5];
		    	
		    	$("#tr-"+sttCauHoi+"-"+sttCTL).remove();
		    	$("#tr-"+sttCauHoi+"-"+sttCTL).remove();
		    	
	    		$("#iddapandung-"+sttCauHoi+"-"+sttCTL).remove();
	    		$("#kitu-"+sttCauHoi+"-"+sttCTL).remove();
	    		var maxClick = solanthem;
	    		var j;
	    		for(j=1; j<socautraloi; j++)
	    		{
	    			$("#capnhatkytu-"+sttCauHoi+"-"+(j+1)).html('');
	    			$("#capnhatkytu-"+sttCauHoi+"-"+(j+1)).html("<span>"+String.fromCharCode(j+64)+".</span>");
	    			$("#kitu-"+sttCauHoi+"-"+(j+1)).html('');
	    			$("#kitu-"+sttCauHoi+"-"+(j+1)).html("<span>"+String.fromCharCode(j+64)+"</span>");
	    		}
	    		socautraloi--;
		    });
		    
    	}); // ket thuc document.ready(function());
    	
// AJAx==========================================================================================================
    	
    	// Hoàn thành câu hỏi và câu trả lời lưu vào csdl
    	function HoanThanh(i) {
    		var Cauhoi = new Array();
    		var listCauTraLoi = new Array();
    		var isCheck = [];
    		var tam;
    		var check_chondapandung = 0;
    		var vitri = new Array(); // Lấy vị trí của đáp án đúng
    		$(".ctl"+i).each(function() {
    			listCauTraLoi.push($(this).html());
    		});
    		socautraloi = listCauTraLoi.length;
    		
            $.each($("input[name='dapandungx-"+i+"']:checked"), function(){            
            	isCheck.push($(this).attr('id'));
            });
           
           $("#kq-dapandungx-"+i).hide();
           
           if(isCheck.length == 1) {
	        	tam = isCheck[0].split("-")[2];
	           	dapandung = $("#hienthicautraloix-"+i+"-"+tam).html();
	           	$("#kq-dapandungx-"+i).html(dapandung);
           } else if(isCheck.length > 1){
	            for(var k=0; k<isCheck.length; k++) {
	            	tam = isCheck[k].split("-")[2];
	            	dapandung = $("#hienthicautraloix-"+i+"-"+tam).html();
	            	$("#kq-dapandungx-"+i).append(dapandung);
	            }
           	} else {
           		// trường hợp điền vào chổ trống sẽ lấy đáp án trực tiếp từ câu hỏi.
           	//	$("#kq-dapandung-"+i).html(dienvaochotrong);
           	}
           
           
    		var maDangCauHoi = jQuery("input[name=dangcauhoix-"+i+"]:checked").val();
    		var maDoKho = jQuery("input[name=dokhox-"+i+"]:checked").val();
    		var noiDungCauHoi = $("#editorcauhoix-"+i).val().trim();
    		var diem = $("#diemChoCauHoix-"+i).val().trim();
    		var dapAnDung = $("#kq-dapandungx-"+i).html().trim();
    		//Lấy vị trí của đáp án đúng
    		
    		var arrayDapAnDung = new Array();
    		var cut = dapAnDung.split("<p>");
    		for(var t=1; t<cut.length; t++) {
    			arrayDapAnDung.push("<p>"+cut[t].split('</p>')[0]+"</p>");
    		}
    		for(var k=0; k<listCauTraLoi.length; k++) {
    			for(var t=0; t<arrayDapAnDung.length; t++) {
	         	   if(listCauTraLoi[k] == arrayDapAnDung[t]) {
	         		   vitri.push(k+1);
	         		   break;
	         	   }
    			}
    		}
    		
    		var msdt = $("#msdt").val();
    		Cauhoi = {
    			"maDangCauHoi" : maDangCauHoi,
    			"maDoKho" : maDoKho,
    			"noiDungCauHoi" : noiDungCauHoi,
    			"diem" : diem,
    			"dapAnDung" : dapAnDung,
    			"msdt" : msdt,
    			"noiDungCauTraLoi" : listCauTraLoi
    		};
    		/*
    		if (typeof msdt == "undefined") {
    			alert("Bạn vui lòng thêm đề thi trước khi thêm câu hỏi!!");
    			return;
    		}
    		*/
    		
    		if(xongCauHoi==0) {
    			alert("Bạn chưa hoàn thành câu hỏi. Vui lòng kiểm tra lại!");
    			return;
    		}
    		
    		if(dapAnDung.length == 0 && dienvaochotrong.length == 0) {
    			alert("Bạn vui lòng chọn đáp án đúng!");
    			return;
    		}
    		
    		
    		$.ajax({
    			data : JSON.stringify(Cauhoi),
    			type : "POST",
    			url : "AjaxLuuCauHoiVaCauTraLoi",
    			contentType : "application/json; charset=utf-8",
    			dataType : "json",
    			success : function(result) {
    				alert('Đã lưu câu hỏi');
 //   				$.growlUI('Đã lưu câu hỏi'); 
 /*Ajax 2*/   				$.ajax({
		    					data: ({}),
		    					type: "POST",
		    					url: "AjaxLayMaxIdCauHoi",
		    					success: function(msch) {
		    						
		    						hoanthanh = 1;
		    			        	 solanthem = 0;
		    			        	 bid = 0;
		    			        	 sua = 0; // Xét có bấm sửa chưa
		    			        	 clickx = 0;
		    			        	 capnhatkitu = 0;
		    			        	 xongCauHoi = 0;
		    			        	 tongDiem += new Number(diem);
		    			        	 $("#huy-cau-hoi-"+i).hide();
		    			        	 $("#hoan-thanh-"+i).hide();
		    			        	 $("#thoat").prop('class', 'btn btn-warning');
		    			        	 $("#thoat").show();

		    			        	 var themslcauhoi = "";
		    			        	 var socau = 0;
		    			        	 if(maDoKho==3) {
		    			        		 socau = new Number($("#socaude").val()) + 1;
		    			        		 $("#socaude").val(socau);
		    			        		 themslcauhoi="<span class='caude'>"+sttCH+"</span>";
		    			        	 } else if(maDoKho==2) {
		    			        		 socau = new Number($("#socautrungbinh").val()) + 1;
		    			        		 $("#socautrungbinh").val(socau);
		    			        		 themslcauhoi="<span class='cautrungbinh'>"+sttCH+"</span>";
		    			        	 } else {
		    			        		 socau = new Number($("#socaukho").val()) + 1;
		    			        		 $("#socaukho").val(socau);
		    			        		 themslcauhoi="<span class='caukho'>"+sttCH+"</span>";
		    			        	 }
		    			        	 
		    			        	 $("#themsoluongcauhoi").append(themslcauhoi);
		    			        	 $("#noidungcauhoi").append(showCauHoi(maDangCauHoi, maDoKho, noiDungCauHoi, diem, dapAnDung, msdt, listCauTraLoi, msch));
		    			        	 if(maDoKho == 1) {
		    			        		 $("#dokho-"+msch+"-1").prop('checked', true);
		    			        	 } else if(maDoKho == 2) {
		    			        		 $("#dokho-"+msch+"-2").prop('checked', true);
		    			        	 } else if(maDoKho == 3) {
		    			        		 $("#dokho-"+msch+"-3").prop('checked', true);
		    			        	 }
		    			        	 
		    			        	 if(maDangCauHoi == 1) { // Chọn câu đúng nhất
		    			        		 $("#dangCauHoi-"+msch+"-1").prop('checked', true);
		    			        		 $("#idthemcautraloi-"+msch).show();
		    			        			$(".table-hover").show();
		    			        			$("#dapandung-"+msch).show();
		    			        			var k;
		    			        			var kitu = "";
		    			        			for (k=1; k<=listCauTraLoi.length; k++) {
		    			        				$("#dapandung-"+msch).append("" +
		    			        						"<input onclick='AjaxSuaDapAnDung("+msch+")' name='dapandung-"+msch+"' class='dapandung-"+msch+"' type='radio' id='iddapandung-"+msch+"-"+k+"'>" +
		    			        						"<span id='kitu-"+msch+"-"+k+"'style='margin-left: 10px; margin-right: 40px;'>"+String.fromCharCode(k+64)+"</span>");
		    			        				$("#iddapandung-"+msch+"-"+k).prop('type', 'radio');
		    			        				
		    			        				for(var t=0; t<vitri.length; t++)
		    			        				if(k == vitri[t]) {
		    			        					$("#iddapandung-"+msch+"-"+k).prop('checked', true);
		    			        				}
		    			        			}
		    			        	 } else if(maDangCauHoi == 2) { //Chọn nhiều câu đúng
		    			        		 $("#dangCauHoi-"+msch+"-2").prop('checked', true);
		    			        		 $("#idthemcautraloi-"+msch).show();
		    			        			$(".table-hover").show();
		    			        			$("#dapandung-"+msch).show();
		    			        			var k;
		    			        			for (k=1; k<=listCauTraLoi.length; k++) {
		    			        				$("#dapandung-"+msch).append("" +
		    			        						"<input onclick='AjaxSuaDapAnDung("+msch+")' name='dapandung-"+msch+"' class='dapandung-"+msch+"' type='checkbox' id='iddapandung-"+msch+"-"+k+"'>" +
		    			        						"<span id='kitu-"+msch+"-"+k+"'style='margin-left: 10px; margin-right: 40px;'>"+String.fromCharCode(k+64)+"</span>");
		    			        				$("#iddapandung-"+msch+"-"+k).prop('type', 'checkbox');
		    			        				
		    			        				for(var t=0; t<vitri.length; t++)
		    				        				if(k == vitri[t]) {
		    				        					$("#iddapandung-"+msch+"-"+k).prop('checked', true);
		    				        				}
		    			        			}
		    			        	 } else if(maDangCauHoi == 3) { // Điền vào chổ trống
		    			        		 $("#dangCauHoi-"+msch+"-3").prop('checked', true);
		    			        		 $("#idthemcautraloi-"+msch).hide();
		    			        		$(".table-hover").hide();
		    			        		$(".dapandung-"+msch).hide();
		    			        	 }
		    			        	 document.getElementById("kq-themcautraloi-"+msch).innerHTML+= ThemCTL(listCauTraLoi, msch);
		    	   			
		    			        	 sttCH++;
		    						
		    					},
		    					error: function(){
		    						alert('Loi khi lax max id cau hoi xxx');
		    					}
		    				});
    				
    			},
    			error : function(result) {
 //   				$.growlUI('Đã lưu câu hỏi'); 
    				alert('Lỗi khi lưu câu hỏi');
    				
    				hoanthanh = 1;
		        	 solanthem = 0;
		        	 bid = 0;
		        	 sua = 0; // Xét có bấm sửa chưa
		        	 clickx = 0;
		        	 capnhatkitu = 0;
		        	 xongCauHoi = 0;
		        	 tongDiem += new Number(diem);
		        	 $("#huy-cau-hoi-"+i).hide();
		        	 $("#hoan-thanh-"+i).hide();
		        	 $("#thoat").prop('class', 'btn btn-warning');
		        	 $("#thoat").show();

		        	 var themslcauhoi = "";
		        	 var socau = 0;
		        	 if(maDoKho==3) {
		        		 socau = new Number($("#socaude").val()) + 1;
		        		 $("#socaude").val(socau);
		        		 themslcauhoi="<span class='caude'>"+sttCH+"</span>";
		        	 } else if(maDoKho==2) {
		        		 socau = new Number($("#socautrungbinh").val()) + 1;
		        		 $("#socautrungbinh").val(socau);
		        		 themslcauhoi="<span class='cautrungbinh'>"+sttCH+"</span>";
		        	 } else {
		        		 socau = new Number($("#socaukho").val()) + 1;
		        		 $("#socaukho").val(socau);
		        		 themslcauhoi="<span class='caukho'>"+sttCH+"</span>";
		        	 }
		        	 themslcauhoi += "<input type='hidden' name='msch-"+i+"' id='msch-"+i+"' value='"+result+"'>";
		        	 $("#themsoluongcauhoi").append(themslcauhoi);
		        	 $("#noidungcauhoi").append(showCauHoi(maDangCauHoi, maDoKho, noiDungCauHoi, diem, dapAnDung, msdt, listCauTraLoi));
		        	 if(maDoKho == 1) {
		        		 $("#dokho-"+i+"-1").prop('checked', true);
		        	 } else if(maDoKho == 2) {
		        		 $("#dokho-"+i+"-2").prop('checked', true);
		        	 } else if(maDoKho == 3) {
		        		 $("#dokho-"+i+"-3").prop('checked', true);
		        	 }
		        	 
		        	 if(maDangCauHoi == 1) { //Chọn câu đúng nhất
		        		 $("#dangCauHoi-"+i+"-1").prop('checked', true);
		        		 $("#idthemcautraloi-"+i).show();
		        			$(".table-hover").show();
		        			$("#dapandung-"+i).show();
		        			var k;
		        			var kitu = "";
		        			for (k=1; k<=listCauTraLoi.length; k++) {
		        				$("#dapandung-"+i).append("" +
		        						"<input onclick='AjaxSuaDapAnDung("+msch+")' name='dapandung-"+i+"' class='dapandung-"+i+"' type='radio' id='iddapandung-"+i+"-"+k+"'>" +
		        						"<span id='kitu-"+i+"-"+k+"'style='margin-left: 10px; margin-right: 40px;'>"+String.fromCharCode(k+64)+"</span>");
		        				$("#iddapandung-"+i+"-"+k).prop('type', 'radio');
		        				
		        				for(var t=0; t<vitri.length; t++)
		        				if(k == vitri[t]) {
		        					$("#iddapandung-"+i+"-"+k).prop('checked', true);
		        				}
		        			}
		        	 } else if(maDangCauHoi == 2) { // Chọn nhiều câu đúng
		        		 $("#dangCauHoi-"+i+"-2").prop('checked', true);
		        		 $("#idthemcautraloi-"+i).show();
		        			$(".table-hover").show();
		        			$("#dapandung-"+i).show();
		        			var k;
		        			for (k=1; k<=listCauTraLoi.length; k++) {
		        				$("#dapandung-"+i).append("" +
		        						"<input onclick='AjaxSuaDapAnDung("+msch+")' name='dapandung-"+i+"' class='dapandung-"+i+"' type='checkbox' id='iddapandung-"+i+"-"+k+"'>" +
		        						"<span id='kitu-"+i+"-"+k+"'style='margin-left: 10px; margin-right: 40px;'>"+String.fromCharCode(k+64)+"</span>");
		        				$("#iddapandung-"+i+"-"+k).prop('type', 'checkbox');
		        				
		        				for(var t=0; t<vitri.length; t++)
			        				if(k == vitri[t]) {
			        					$("#iddapandung-"+i+"-"+k).prop('checked', true);
			        				}
		        			}
		        	 } else if(maDangCauHoi == 3) { //Điền vào chổ trống
		        		 $("#dangCauHoi-"+i+"-3").prop('checked', true);
		        		 $("#idthemcautraloi-"+i).hide();
		        		$(".table-hover").hide();
		        		$(".dapandung-"+i).hide();
		        	 }
		        	 document.getElementById("kq-themcautraloi-"+i).innerHTML+= ThemCTL(listCauTraLoi);
    			
		        	 sttCH++;
    			}
    		});
    	}

