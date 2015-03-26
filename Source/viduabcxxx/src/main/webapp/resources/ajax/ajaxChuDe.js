$(document).on('keyup', '#tao-tenchude', function (e) {
	//Tạo thẻ mới
	if(e.keyCode == "13" || e.which == "13")
	{
		if($(this).val().length == 0){
			$(this).focus();i
			return;
		}
		var tk = $("#taiKhoanChuDe").val();
		$.ajax({
			
			data: "TaiKhoan=" + $("#taiKhoanChuDe").val() + "&TenChuDe=" + $(this).val(),
			type: "POST",
			url : "AjaxThemChuDe",
			success : function(result) {
				$(".create-list").remove();
				$(".list-wrapper").append(result);
				$("#horizoltal-scroll>.mCustomScrollBox>.mCSB_container").css("width","+=320");
				$("#tao-tenchude").focus();
				$(".list-content").mCustomScrollbar({
					theme : "dark-2",
					axis : "y"
				});
/*				
				$(".the").sortable({//Kich hoat keo tha 
					containment: "document",
					appendTo: "body",
					zIndex: '9999',
					connectWith: ".the",
					cursor: "-webkit-grabbing",
					scroll: true,
					helper: 'clone',
					
					update: function (event, ui) {
				        var data = $(this).sortable('serialize');
				        $.ajax({
				            data: data + "&TheHienTai="+$(ui.item).attr('id').replace("card_",""),
				            type: 'POST',
				            url: 'AjaxCapNhatThuTuThe'
				        });
				    }
				});
*/
			},
			error : function() {
				alert("Action chu de hoat dong nhung bi loi");
			}
		});
	}
});

function AjaxXoaChuDe(mscd) {
	$.ajax({
		data: "MaChuDe="+mscd,
		type: "POST",
		url: "AjaxXoaChuDe",
		success: function() {
			$("#chude_"+mscd).remove();
		},
		error : function(){
			alert("Xóa chủ đề gặp lỗi");
		}
	});
}

function AjaxSuaChuDe(mscd) {
	$.ajax({
		data: "MaChuDe="+mscd + "&TenChuDe="+$("#ten-ChinhSua").val(),
		type: "POST",
		url: "AjaxSuaChuDe",
		success: function(result) {
			$("#chude_"+mscd).children(".list-header").removeClass("editing");
			$("#chude_"+mscd).children(".list-header").children(".list-title").html("<strong>"+result+"</strong>");
		},
		error : function(){
			alert("Xóa chủ đề gặp lỗi");
		}
	});
}


