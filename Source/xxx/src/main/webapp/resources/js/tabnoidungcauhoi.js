var solanthem = 0;
var bid = 0;
var sua = 0;
var socauhoi = 0;
function themsoluongcauhoi() {
    	var rates = document.getElementsByName('dokho2');
		var rate_value;
		var socaukho = document.getElementById('socaukho').value;
		var socautrungbinh = document.getElementById('socautrungbinh').value;
		var socaude = document.getElementById('socaude').value;
		
		for(var i = 0; i < rates.length; i++){
	    	if(rates[i].checked){
		        rate_value = rates[i].value;
		    }
		}
		
		if(rate_value == '3'){
			socaude ++;
			document.getElementById("themsoluongcauhoi").innerHTML= "<span class='caude'>10</span>";
			document.getElementById("socaude").value= socaude;
		} else if(rate_value == '2'){
			socautrungbinh ++;
			document.getElementById("themsoluongcauhoi").innerHTML= "<span class='cautrungbinh'>10</span>";
			document.getElementById("socautrungbinh").value= socautrungbinh;
		} else if(rate_value == '1') {
			socaukho ++;
			document.getElementById("themsoluongcauhoi").innerHTML = "<span class='caukho'>10</span>";
			document.getElementById("socaukho").value= socaukho;
		}

    }
   
function TaoCauHoi() {
	++socauhoi;
	var result = "";
	result += " <div id='themcauhoi-"+socauhoi+"' style='border: 1px solid #000077;  margin-bottom: 15px;'> ";
	result += " <div class='container-fluid'>";
	result += " <div class='row'>";
	result += " <div class='col-md-2 col-sm-2 col-lg-2 col-xs-2'> ";
	result += " <div id='tencauhoi-"+socauhoi+"'></div>";
	result += " <div class='form-group'>";
	result += " <div class='radio'>";
	result += " <label> <input type='radio' name='dokho-"+socauhoi+"' id='doKho-"+socauhoi+"' value='3' checked='checked'> ";
	result += " <span id='idmucdode'>Dễ</span>";
	result += " </label><br> <label> <input type='radio' name='dokho-"+socauhoi+"' id='doKho-"+socauhoi+"' value='2'> ";
	result += " <span	id='idmucdotrungbinh'>Trung bình</span>";
	result += " </label><br> <label> <input type='radio' name='dokho-"+socauhoi+"' id='doKho-"+socauhoi+"' value='1'> ";

	result += " <span id='idmucdokho'>Khó</span>";
	result += " </label>";

	result += " </div>";
	result += " </div>";
	result += " </div>";
	result += " <div class='col-md-10 col-sm-10 col-lg-10 col-xs-10'>";
	result += " <div class='form-group'>";
	result += " <div class='radio'>";
	result += " <label> ";
	result += " <input type='radio' name='dangcauhoi-"+socauhoi+"' id='dangCauHoi-"+socauhoi+"' value='1' checked='checked'>";
	result += " Chọn câu đúng nhất &nbsp; &nbsp;&nbsp;";
	result += " </label> <label> ";
	result += " <input type='radio' name='dangcauhoi-"+socauhoi+"' id='dangCauHoi-"+socauhoi+"' value='2'> Chọn nhiều câu đúng &nbsp; &nbsp;&nbsp; ";
	result += " </label> <label> ";
	result += " <input type='radio' name='dangcauhoi-"+socauhoi+"' id='dangCauHoi-"+socauhoi+"' value='3'> Điền vào chổ trống ";
	result += " </label>";
	result += " </div>";
	result += " </div>";
	result += " <div class='form-group'>";
	result += " <span>Điểm cho câu hỏi này là:</span><input type='text' class='form-control acDiem' name='diemChoCauHoi-"+socauhoi+"' id='diemChoCauHoi-"+socauhoi+"' style='width: 100px;'>";
	result += " <div id='thongbao_loinhapdiem-"+socauhoi+"'></div>";
	result += " </div>";
	result += "<div id='hienthicuahoi-"+socauhoi+"'></div>";
	result += " <section id='editor' style='width: 95%;'>";
	result += " <textarea id='editorcauhoi-"+socauhoi+"' style='margin-top: 30px; margin-bottom: 10px; display: none;'>";
	result += " </textarea>";
	result += " </section>";
	result += " <section id='buttons'> ";
		
	result += " <button id='xong-cau-hoi-"+socauhoi+"' class='btn btn-primary acXongCH' style='margin-top: 7px; margin-bottom: 30px; ' >Xong </button> ";
	result += " <button id='sua-cau-hoi-"+socauhoi+"' style='margin-top: 7px; margin-bottom: 30px;' hidden > Sửa</button>";				
	result += " </section>";
	result += " </div>";
	result += " <br>";

	result += " <div id='themcautraloi-"+socauhoi+"'>";
	result += " <div class='cautraloi' style='padding-top: 15px; text-align: center'>";							
	result += " <span style='text-align: center; font-family: Calibri, serif; font-size: 14pt;'>";
	result += " <strong >Câu trả lời</strong>";
	result += " </span>";
	result += " <br>";
	result += " <table class='table table-hover'>";
	result += " <thead>";
	result += " 	<!-- Cau tra loi -->					<span style='float: left; padding-left: 10px;font-family: Calibri, serif; font-size: 14pt;'>Đáp án đúng: </span>";
	result += " <div id='dapandung-"+socauhoi+"'></div>";
	result += " <div id='kq-dapandung-"+socauhoi+"'></div>";
	result += " </thead>";
	result += " <tbody style='text-align: left;' id='kq-themcautraloi-"+socauhoi+"'>";
	result += " </tbody>";
	result += " </table>";
	result += " <hr> ";
	result += " </div>";
	result += " </div>";
	result += " <div id='idmsch-"+socauhoi+"'></div>	";			
	result += " <div class='form-group' id='idthemcautraloi-"+socauhoi+"'>";
	result += " <button class='btn btn-success acThemCauTraLoi' id='them-cau-tra-loi-"+socauhoi+"' onclick='ThemCauTraLoi("+socauhoi+")'>";
	result += " Thêm câu trả lời &nbsp;<span class='glyphicon glyphicon-plus'></span>";
	result += " </button>";
	result += " </div>";
	result += " <div id='form-group' class='pull-right' style='margin-bottom: 15px;'>";
	result += " <button class='btn btn-primary' onclick='HoanThanh("+socauhoi+")'>Hoàn thành &nbsp;<span class='glyphicon glyphicon-ok'></span></button>";
	result += " <button class='btn btn-danger' id='huy-cau-hoi-"+socauhoi+"' data-toggle='modal' href='#modal-id'>Hủy &nbsp;<span class='glyphicon glyphicon-remove'></span></button>";
	result += " </div>";
	result += " </div>";
	result += " </div>";
	result += " </div>";
	document.getElementById('noidungcauhoi').innerHTML += result;
	$("#editorcauhoi-"+socauhoi).editable({inlineMode: false})
}


    	$(document).ready(function(){
//OK
    		
    		 $(document).on('keyup', '.acDiem', function(){
    			 var stt = $(this).attr('id').split("-")[1];
    			 var DiemValue = $(this).val();
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
    		 
// kết thúc kiểm tra kí tự nhập điểm  
    		$('#luu-cau-tra-loi').on('click', function (e) {
	        	
	        	if($("#editorcautraloi").val().length == 0) {
	        		$("#hienthicautraloi").html("<span style='color: #a94442'>Lưu ý: Câu trả lời không được bỏ trống</span>");
	        	} else {
	        		$("#hienthicautraloi").html($("#editorcautraloi").val());
	        	}
	        	$("#luu-cau-tra-loi").hide();
	        	$("#sua-cau-tra-loi").prop("class","btn btn-success");
	        	$("#sua-cau-tra-loi").show();
	        	$("#xoa-cau-tra-loi").prop("class","btn btn-danger");
	        	$("#xoa-cau-tra-loi").show();
	          console.log("Destroying Froala Editor...");
	          $('#editorcautraloi').editable('destroy');
	          $("#editorcautraloi").hide();
	        });
    		
    		$("#sua-cau-tra-loi").click(function(){
		   			 console.log("Initializing Froala Editor...");
		   			 $("#hienthicautraloi").html('');
		   			 $("#editorcautraloi").show();
				     $('#editorcautraloi').editable({inlineMode: false});
				     if($('#editorcautraloi').val().length == 0) {
				    	$("#xong-cau-tra-loi").attr("onclick", "LuuCauTraLoi()");
				        $("#xong-cau-tra-loi").prop("class", "btn btn-success");
				    	$("#xong-cau-tra-loi").show();
				    	$("#sua-cau-tra-loi").hide();
				     }
		   			$("#xong-cau-tra-loi").prop("class", "btn btn-success");
		   			$("#xong-cau-tra-loi").show();
		   			$("#sua-cau-tra-loi").hide();
    			});
    		
		        $('#editorcauhoi-').editable({inlineMode: false})

// OK
    		 $(document).on('click', '.acSuaCH', function (e) {
    			 console.log("Initializing Froala Editor...");
    			 var sttCauHoi = $(this).attr('id').split("-")[3];
    			 $("#hienthicuahoi-"+sttCauHoi).html('');
    			 $("#editorcauhoi-"+sttCauHoi).show();
		         $('#editorcauhoi-'+sttCauHoi).editable({inlineMode: false});
		         if($('#editorcauhoi-'+sttCauHoi).val().length == 0) {
		//        	$("#xong-cau-hoi-"+sttCauHoi).attr("onclick", "LuuCauHoi("+maDeThi+")"); //???
		        	$("#xong-cau-hoi-"+sttCauHoi).prop("class", "btn btn-primary acXongCH");
		    		$("#xong-cau-hoi-"+sttCauHoi).show();
		    		$("#sua-cau-hoi-"+sttCauHoi).hide();
		         }
    			$("#xong-cau-hoi-"+sttCauHoi).prop("class", "btn btn-primary acXongCH");
    			$("#xong-cau-hoi-"+sttCauHoi).show();
    			$("#sua-cau-hoi-"+sttCauHoi).hide();
    		});

//OK XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
		        $(document).on('click', '.acXongCH', function (e) {
    			 console.log("Destroying Froala Editor...");
    			 var sttCauHoi = $(this).attr('id').split("-")[3];
    			 
    			 if($("#editorcauhoi-"+sttCauHoi).val().length == 1) {
		        	$("#hienthicuahoi-"+sttCauHoi).html("<span style='color: #a94442'>Lưu ý: câu hỏi không được bỏ trống</span>");
		        	return;
		        } else {
		        }
		        $('#editorcauhoi-'+sttCauHoi).editable('destroy');
		        $("#editorcauhoi-"+sttCauHoi).hide();
    			$("#sua-cau-hoi-"+sttCauHoi).prop("class", "btn btn-primary acSuaCH");
    			$("#sua-cau-hoi-"+sttCauHoi).show();
    			$("#xong-cau-hoi-"+sttCauHoi).hide();
    		});
    		
		    $("#huy-cau-hoi").click(function(){
		    	$("#themcauhoi").hide();
		    });
		   
		    var clickx = 0;
		    var capnhatkitu = 0;
		    
// OK
		    
		    $(document).on('click', '.acThemCauTraLoi', function (e) {
		    	var sttCauHoi = $(this).attr('id').split("-")[4];// lấy số thứ tự câu hỏi
		    	var sttCTL = $(this).attr('id').split("-")[5]; 
		    		
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
		         ketqua+=		"<div id='hienthicautraloi-"+sttCauHoi+"-"+bid+"' class='ctl'></div>";
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
	  				$("#dapandung-"+sttCauHoi).append("<input name='dapandung' class='dapandung' type='radio' id='iddapandung-"+sttCauHoi+"-"+sttCTL+"'><span id='kitu-"+sttCauHoi+"-"+sttCTL+"'style='margin-left: 10px; margin-right: 40px;'>"+kitu+"</span>");
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
		    	$("#tr-"+sttCauHoi+"-"+sttCTL).hide();
	    		$("#iddapandung-"+sttCauHoi+"-"+sttCTL).hide();
	    		$("#kitu-"+sttCauHoi+"-"+sttCTL).hide();
	    		var maxClick = solanthem;
	    		var j;
	    		for(j=1; j<solanthem; j++)
	    		{
	    			$("#capnhatkytu-"+sttCauHoi+"-"+(j+1)).html('');
	    			$("#capnhatkytu-"+sttCauHoi+"-"+(j+1)).html("<span>"+String.fromCharCode(j+64)+".</span>");
	    			$("#kitu-"+sttCauHoi+"-"+(j+1)).html('');
	    			$("#kitu-"+sttCauHoi+"-"+(j+1)).html("<span>"+String.fromCharCode(j+64)+"</span>");
	    		}
	    		solanthem--;
		    	
		    });
		    
// OK		    
		    $(document).on('click', '.dapandung', function (e) {
		    	var sttCauHoi = $(this).attr('id').split("-")[1];
		    	var sttCTL = $(this).attr('id').split("-")[2];
		    	$("#kq-dapandung").hide();
		         var dapandung = $("#hienthicautraloi-"+sttCauHoi+"-"+sttCTL).html();
		         $("#kq-dapandung").html(dapandung);
		  });
		    
		    
		    
    	}); // ket thuc document.ready(function());
    	
