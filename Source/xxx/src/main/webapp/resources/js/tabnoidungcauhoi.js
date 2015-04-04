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
    
    	$(document).ready(function(){
// Kiểm tra kí tự nhập điểm
    		$('#diemChoCauHoi1').keyup(function(){
                var txtVal = $('#diemChoCauHoi1').val();

                if(txtVal.length == 0) {
                	$("#thongbao_loinhapdiem").addClass("input-error-taikhoan");
                	$("#diemChoCauHoi1").addClass("input-error-taikhoan1");
                    $("#thongbao_loinhapdiem").html('<span>Điểm không được bỏ trống</span>');
                }
                else
                {
                    if(txtVal == '0') {
                    	$("#thongbao_loinhapdiem").addClass("input-error-taikhoan");
                    	$("#diemChoCauHoi1").addClass("input-error-taikhoan1");
                    	$("#thongbao_loinhapdiem").html('Điểm phải khác 0');
                      return;
                    }
                    if(jQuery.isNumeric(txtVal)) {
                    	$("#thongbao_loinhapdiem").removeClass("input-error-taikhoan");
                    	$("#diemChoCauHoi1").removeClass("input-error-taikhoan1");
                        $("#thongbao_loinhapdiem").html('');
                    }
                    else {
                    	$("#thongbao_loinhapdiem").addClass("input-error-taikhoan");
                    	$("#diemChoCauHoi1").addClass("input-error-taikhoan1");
                        $("#thongbao_loinhapdiem").html('<span>Điểm phải là số</span>');
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
    /*
    		$("#xong-cau-tra-loi").click(function(){
	   			 console.log("Destroying Froala Editor...");
	   			 if($("#editorcautraloi").val().length == 0) {
			        	$("#hienthicautraloi").html("<span style='color: #a94442'>Lưu ý: Câu trả lời không được bỏ trống</span>");
			        } else {
			        	$("#hienthicautraloi").html($("#editorcautraloi").val());
			        }
			        $('#editorcautraloi').editable('destroy');
			        $("#editorcautraloi").hide();
	   			$("#sua-cau-tra-loi").prop("class", "btn btn-success");
	   			$("#sua-cau-tra-loi").show();
	   			$("#xong-cau-tra-loi").hide();
    		});
    		
    			$("#sua-cau-tra-loi").click(function(){
    				$("#editcautraloi").editable({inlineMode: false});
    				$("#sua-cau-tra-loi-xong").prop("class", "btn btn-success");
    				$("#sua-cau-tra-loi-xong").show();
    				$("#sua-cau-tra-loi").hide();
    			});

    			$("#sua-cau-tra-loi-xong").click(function(){
    				$("#editcautraloi").editable('destroy');
    				$("#sua-cau-tra-loi").prop("class", "btn btn-success");
    				$("#sua-cau-tra-loi").show();
    				$("#sua-cau-tra-loi-xong").hide();
    			});
*/
		        $('#edit2').editable({inlineMode: false})
		   /*     
		        $('#luu-cau-hoi').on('click', function (e) {
		        	if($('#diemChoCauHoi1').val().length == 0) {
	                	$("#thongbao_loinhapdiem").addClass("input-error-taikhoan");
	                	$("#diemChoCauHoi1").addClass("input-error-taikhoan1");
	                    $("#thongbao_loinhapdiem").html('<span>Điểm không được bỏ trống</span>');
	                }
		        	if($("#edit2").val().length == 0) {
		        		$("#hienthicuahoi").html("<span style='color: #a94442'>Lưu ý: câu hỏi không được bỏ trống</span>");
		        	} else {
		        		$("#hienthicuahoi").html($("#edit2").val());
		        	}
		        	$("#luu-cau-hoi").hide();
		        	$("#sua-cau-hoi").prop("class","btn btn-primary");
		        	$("#sua-cau-hoi").show();
		        	$("#xoa-cau-hoi").prop("class","btn btn-danger");
		        	$("#xoa-cau-hoi").show();
		          console.log("Destroying Froala Editor...");
		          $('#edit2').editable('destroy');
		          $("#edit2").hide();
		        });
*/
    		$("#sua-cau-hoi").click(function(){
    			 console.log("Initializing Froala Editor...");
    			 $("#hienthicuahoi").html('');
    			 $("#edit2").show();
		         $('#edit2').editable({inlineMode: false});
		         if($('#edit2').val().length == 0) {
		        	$("#xong-cau-hoi").attr("onclick", "LuuCauHoi("+maDeThi+")");
		        	$("#xong-cau-hoi").prop("class", "btn btn-primary");
		    		$("#xong-cau-hoi").show();
		    		$("#sua-cau-hoi").hide();
		         }
    			$("#xong-cau-hoi").prop("class", "btn btn-primary");
    			$("#xong-cau-hoi").show();
    			$("#sua-cau-hoi").hide();
    		});

    		$("#xong-cau-hoi").click(function(){
    			 console.log("Destroying Froala Editor...");
    			 if($("#edit2").val().length == 0) {
		        	$("#hienthicuahoi").html("<span style='color: #a94442'>Lưu ý: câu hỏi không được bỏ trống</span>");
		        } else {
		        	$("#hienthicuahoi").html($("#edit2").val());
		        }
		        $('#edit2').editable('destroy');
		        $("#edit2").hide();
    			$("#sua-cau-hoi").prop("class", "btn btn-primary");
    			$("#sua-cau-hoi").show();
    			$("#xong-cau-hoi").hide();
    		});

    		$("#themcauhoi").hide();
    		$("#them-cau-hoi").click(function(){
		        $("#themcauhoi").show();
		    });

		    $("#huy-cau-hoi").click(function(){
		    	$("#themcauhoi").hide();
		    });
		   
		    var clickx = 0;
		    var capnhatkitu = 0;
		    
// Them cau tra loi
		    
		    $("#them-cau-tra-loi").click(function(){
		    	bid++;
		    		capnhatkitu++;
		    		solanthem++;
		    	if(solanthem > 1) {
			    	var kiemtra = solanthem - 1; //trừ 1 để kiểm tra câu trước có rỗng không.
			    	var hienthi = $("#hienthicautraloi-"+kiemtra);
			    	var rong = hienthi.html();
			    	if( hienthi.html().length == 0 || rong == "<span style=\"color: #a94442\">Lưu ý: Câu trả lời không được bỏ trống</span>" ) {
			    		alert("Nội dung câu trả lời trước chưa hoàn thành. Vui lòng kiểm tra lại.");
			    		solanthem--;
			    		return;
			    	}
			    	
		    	}
		    	var ketqua="";
		    	var kitu = String.fromCharCode(solanthem+64);
		         ketqua+="<tr id='tr-"+bid+"'>";
		        
		         ketqua+=	"<th>";
		         ketqua+=		"<div id='capnhatkytu"+bid+"'><span>"+kitu+".</span></div>";
		         ketqua+=	"</th>";
		         ketqua+=	"<td>";
		         ketqua+=		"<div id='hienthicautraloi-"+bid+"' class='ctl'></div>";
		         ketqua+=		"<section id='editor' style='width: 95%; margin-top: 15px; margin-bottom: 15px;'>";
		         ketqua+=			"<textarea id='editorcautraloi-"+bid+"' style='margin-top: 30px; margin-bottom: 10px;'></textarea>";
		         ketqua+=		"</section>";
		         ketqua+=	"</td>";
		         ketqua+=	"<th>";
		         ketqua+=		"<section id='buttons'>" ;
		         ketqua+=			"<button style='margin-top: 7px; margin-bottom: 30px;'"; 
		         ketqua+=			"id='luu-cau-tra-loi-"+bid+"' onclick='LuuCauTraLoi()' hidden >Lưu </button>";
		         ketqua+=			"<button id='xong-cau-tra-loi-"+bid+"' onclick='XongCauTraLoi("+bid+")' style='margin-top: 7px; margin-bottom: 30px;' class='btn btn-success'>Xong </button>";
		         ketqua+=			"<button class='pull-right' id='sua-cau-tra-loi-"+bid+"' onclick='SuaCauTraLoi("+bid+")' style='margin-top: 7px; margin-bottom: 30px;' hidden > Sửa</button>";
		         ketqua+=			"<button id='xoa-cau-tra-loi-"+bid+"' name='xoa-cau-tra-loi-"+bid+"' onclick='XoaCauTraLoi("+bid+")' class='btn btn-danger'>Xóa</button>";
		         ketqua+=		"</section>";
		         ketqua+=	"</th>";
		         ketqua+="</tr>";
		         document.getElementById("kq-themcautraloi").innerHTML+= ketqua;
		         $("#editorcautraloi-"+bid).editable({inlineMode: false});
		    });
		    
		    $(document).on('click', '.dapandung', function (e) {
		    	$("#kq-dapandung").hide();
		         var iddapandung = $(this).attr('id').split("-")[1]; // lấy id click
		         var dapandung = $("#hienthicautraloi-"+iddapandung).html();
		         $("#kq-dapandung").html(dapandung);
		  });
    	});
    	


    	function XongCauTraLoi(i) {
    		var capnhatkitu = $("#idClickx").val();
    		capnhatkitu = new Number(capnhatkitu);
    		var kitu = String.fromCharCode(solanthem + 64);
    		var editor = $("#editorcautraloi-"+i);
    		var hienthi = $("#hienthicautraloi-"+i);
  			 if(editor.val().length == 0) {
		        	hienthi.html("<span style='color: #a94442'>Lưu ý: Câu trả lời không được bỏ trống</span>");
		        	return;
		        } else {
		        	hienthi.html(editor.val());
		        }
  			editor.editable('destroy');
  			editor.hide();
  			if(sua==0) {
  				$("#dapandung").append("<input name='dapandung' class='dapandung' type='radio' id='iddapandung-"+i+"'><span id='kitu-"+i+"'style='margin-left: 10px; margin-right: 40px;'>"+kitu+"</span>");
  			} else {
  				sua = 0;
  			}
  			$("#sua-cau-tra-loi-"+i).prop("class", "btn btn-success");
  			$("#sua-cau-tra-loi-"+i).show();
  			$("#xong-cau-tra-loi-"+i).hide();
    	}
    	
    	function XoaCauTraLoi(i) {
    		$("#tr-"+i).hide();
    		$("#iddapandung-"+i).hide();
    		$("#kitu-"+i).hide();
    		var maxClick = solanthem;
    		var j;
    		for(j=1; j<solanthem; j++)
    		{
    			$("#capnhatkytu"+(j+1)).html('');
    			$("#capnhatkytu"+(j+1)).html("<span>"+String.fromCharCode(j+64)+".</span>");
    			$("#kitu-"+(j+1)).html('');
    			$("#kitu-"+(j+1)).html("<span>"+String.fromCharCode(j+64)+"</span>");
    		}
    		solanthem--;
    		
    	}
    	
    	
    	function SuaCauTraLoi(i) {
    		 console.log("Initializing Froala Editor...");
   			// $("#hienthicautraloi-"+i).html('');
    		
   			 $("#editorcautraloi-"+i).show().html($("#hienthicautraloi-"+i).html());
   			$("#hienthicautraloi-"+i).html('');
		     $("#editorcautraloi-"+i).editable({inlineMode: false});
		     if($("#editorcautraloi-"+i).val().length == 0) {
		    	$("#xong-cau-tra-loi-"+i).attr("onclick", "XongCauTraLoi("+i+")");
		        $("#xong-cau-tra-loi-"+i).prop("class", "btn btn-success");
		    	$("#xong-cau-tra-loi-"+i).show();
		    	$("#sua-cau-tra-loi-"+i).hide();
		     }
   			$("#xong-cau-tra-loi-"+i).prop("class", "btn btn-success");
   			$("#xong-cau-tra-loi-"+i).show();
   			$("#sua-cau-tra-loi-"+i).hide();
   			sua++;
    	}
    	
    	
    	
    	
    	