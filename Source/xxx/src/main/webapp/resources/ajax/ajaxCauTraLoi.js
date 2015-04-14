

function LuuCauTraLoi() {
	$.ajax({
		data: "MaCauHoi="+$("#msch").val() + "&NoiDungCTL="+$("#editorcautraloi").val(), 
		url: "AjaxLuuCauTraLoi",
		type: "POST",
		success: function(result) {
			alert("Them cau tra loi thanh cong");
		}, 
		error: function () {
			alert("Them cau tra loi that bai");
		}
	});
}

function ThemCauTraLoi(msch) {
	/*
    $.ajax({
    	data:"MaDeThi="+$("#msdt").val(),
    	url: "AjaxLayMaxIdCauHoi",
    	type: "POST",
    	success: function(result) {
    		$("#idmsch").html("<input type='hidden' id='msch' name = 'msch' value='"+result+"'>");
    	},
    	error: function() {
    		alert("Loi khi them cau tra loi");
    	}
    });*/
}

function SuaCauTraLoi(msch, msctl) {
	$.ajax({
		data: "MaCauHoi="+msch + "&MaCauTraLoi="+msctl + "&NoiDungCTL="+$("#editorcautraloi-"+msch+"-"+msctl).val(), 
		url: "AjaxSuaCauTraLoi",
		type: "POST",
		success: function(result) {
			alert("Sua cau tra loi thanh cong");
		}, 
		error: function () {
			alert("Sua cau tra loi that bai");
		}
	});
}

function XoaCauTraLoi(msctl, msch) {
	$.ajax({
		data: "MaCauTraLoi="+msctl + "&MaCauHoi="+msch, 
		url: "AjaxXoaCauTraLoi",
		type: "POST",
		success: function(result) {
			ResetLabelCTL(msch, msctl);
		}, 
		error: function (result) {
			alert("xoa cau tra loi that bai");
		}
	});
}

function ResetLabelCTL(msch, msctl) {
	var count = 0;
	var tach = new Array();
	$.ajax({
		url: "AjaxLayListIdCTL",
		data: "MaCauHoi="+msch,
		type: "POST",
		success : function(list) {
			tach = list.split("-");
			$.ajax({
				url: "AjaxLaySoLuongCauTraLoi",
				data: "MaCauHoi="+msch, 
				type: "POST",
				success : function(soluong) {
					count = new Number(soluong);
					$("#tr-"+msch+"-"+msctl).remove();
			    	$("#tr-"+msch+"-"+msctl).remove();
		    		$("#iddapandung-"+msch+"-"+msctl).remove();
		    		$("#kitu-"+msch+"-"+msctl).remove();
		    		//Cập nhật ký tự 
					for(var k = 0; k<count; k++) {
						$("#capnhatkytu-"+msch+"-"+tach[k]).html("<span>"+String.fromCharCode(k+65)+".</span>");
						$("#kitu-"+msch+"-"+tach[k]).html(String.fromCharCode(k+65));
					}
					
				},
				error : function(soluong) {
					
				}
			});
		},
		error: function(list) {
			
		}
	});
}

function CapNhatCTL(msch, msctl) {
	var noidungctl = $("#editorcautraloi-"+msch+"-"+msctl).val();
	$.ajax({
		data: "MaCauHoi="+msch + "&NoiDungCTL="+noidungctl,
		url: "AjaxThemCauTraLoi",
		type: "POST",
		success : function(result) {
			$("#xong-cau-tra-loi-"+msch+"-"+msctl).attr('onclick', "SuaCauTraLoi("+msch+","+msctl+")");
		},
		error : function(result) {
			alert("loi khi cap nhat ctl");
		}
	});
}
	
	function ThemEditorCTL(msch) {
		var IntResult = 0;
		$.ajax({
			data: "MaCauHoi="+msch, 
			url: "AjaxLaySoLuongCauTraLoi",
			type: "POST",
			success: function(SoLuong) {
				$.ajax({
					data: "MaCauHoi="+msch, 
					url: "AjaxLayMaxIdCTL",
					type: "POST",
					success : function(maxId) {
						IntResult = new Number(SoLuong) + 1;
						var slctl = new Number(maxId) + 1;
			    		if(slctl > 1) {
					    	var kiemtra = slctl - 1; //trừ 1 để kiểm tra câu trước có rỗng không.
					    	var hienthi = $("#hienthicautraloi-"+msch+"-"+kiemtra);
					    	var rong = hienthi.html();
					    	if( hienthi.html().length == 0 || rong == "<span style=\"color: #a94442\">Lưu ý: Câu trả lời không được bỏ trống</span>" ) {
					    		alert("Nội dung câu trả lời trước chưa hoàn thành. Vui lòng kiểm tra lại.");
					    		return;
					    	}
			    		}
				    	var ketqua="";
				    	var kitu = String.fromCharCode(IntResult+64);
				         ketqua+="<tr id='tr-"+msch+"-"+slctl+"'>";
				        
				         ketqua+=	"<th>";
				         ketqua+=		"<div id='capnhatkytu-"+msch+"-"+slctl+"'><span>"+kitu+".</span></div>";
				         ketqua+=	"</th>";
				         ketqua+=	"<td>";
				         ketqua+=		"<div id='hienthicautraloi-"+msch+"-"+slctl+"' class='ctl"+msch+"'></div>";
				         ketqua+=		"<section id='editor' style='width: 95%; margin-top: 15px; margin-bottom: 15px;'>";
				         ketqua+=			"<textarea id='editorcautraloi-"+msch+"-"+slctl+"' style='margin-top: 30px; margin-bottom: 10px;'></textarea>";
				         ketqua+=		"</section>";
				         ketqua+=	"</td>";
				         ketqua+=	"<th>";
				         ketqua+=		"<section id='buttons'>" ;
				         ketqua+=			"<button style='margin-top: 7px; margin-bottom: 30px;'"; 
				         ketqua+=			"id='luu-cau-tra-loi-"+msch+"-"+slctl+"' onclick='LuuCauTraLoi()' hidden >Lưu </button>";
				         ketqua+=			"<button id='xong-cau-tra-loi-"+msch+"-"+slctl+"' onclick='CapNhatCTL("+msch+","+slctl+")' style='margin-top: 7px; margin-bottom: 30px;' class='btn btn-success acXongCTL'>Xong </button>";
				         ketqua+=			"<button class='pull-right acSuaCTL' id='sua-cau-tra-loi-"+msch+"-"+slctl+"' style='margin-top: 7px; margin-bottom: 30px;' hidden > Sửa</button>";
				         ketqua+=			"<button id='xoa-cau-tra-loi-"+msch+"-"+slctl+"' name='xoa-cau-tra-loi-"+msch+"-"+slctl+"' onclick='XoaCauTraLoi("+slctl+")' class='btn btn-danger acXoaCTL'>Xóa</button>";
				         ketqua+=		"</section>";
				         ketqua+=	"</th>";
				         ketqua+="</tr>";
				         document.getElementById("kq-themcautraloi-"+msch).innerHTML+= ketqua;
				         $("#editorcautraloi-"+msch+"-"+slctl).editable({inlineMode: false});
					},
					error : function(maxId) {
						
					}
				});
			}, 
			error: function (result) {
				alert("Loi HienThiEditorCTLKhiThem");
			}
		});
	}

