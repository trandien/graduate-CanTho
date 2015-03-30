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


		        $('#edit2').editable({inlineMode: false})
		        
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
		    $("#themcautraloi").hide();
		    $("#them-cau-tra-loi").click(function(){
		    	$("#editorcautraloi").editable({inlineMode: false});
		        $("#themcautraloi").show();
		        
		    });
    	});
