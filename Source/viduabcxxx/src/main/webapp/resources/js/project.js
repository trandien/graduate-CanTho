//-------------------------------------------------
//Các chức năng thẻ
//-------------------------------------------------

//Khởi tạo công việc cho thẻ từ CSDL
function khoiTaoThe(maThe){
	ajaxKhoiTaoCongViec(maThe);
	ajaxCapNhatTienTrinh(maThe);
    ajaxLayThoiGianHoanThanhThe(maThe);
    ajaxLayMoTaThe(maThe);
    ajaxLayNhanThe(maThe);
    ajaxKhoiTaoBinhLuan(maThe);
}

//Sửa tên thẻ
$(document).on('click', '#card-title', function (e) {
	$(".editable").removeClass("editing");
	var editable = $(this).parent();
	editable.append($("#edit"));
	var field = editable.find("#edit > .form-group > .field");
    $("#edit .form-group .btn-save").attr("onclick","ajaxSuaThe("+ $("#card-id").val() +")");
	editable.addClass("editing");
	field.focus();
	field.val($(this).text());
	field.select();
});


//Mở thẻ
$(document).on('click', '.list-item', function (e) {
	if( $(e.target).is($(".card-delete")) || $(e.target).is($(".card-delete").children()) )
		return;
	
	$('#cardModal').modal('show');
	var title = $(this).children(".list-item-title").text();
	var maThe = $(this).children(".list-item-id").val();
	$("#card-title").html(title);
	$("#card-id").val(maThe);
	$("#modal-card-id").val(maThe);
	khoiTaoThe(maThe);
});

//Mở box xóa thẻ
$(document).on('click', '.card-delete', function (e) {
    var fcd = $("#form-card-delete");
    if (fcd.css("display") != "none") return;
    var pos = $(this).offset();
    var x = pos.left;
    var y = pos.top + $(this).outerHeight() + 5;

    fcd.css({
        "left": x + "px",
        "top": y + "px"
    })

    fcd.show("fast");
    var id = $(this).children(".list-item-id").val();
    $("#btn-card-delete").attr("onclick","ajaxXoaThe(\"" + id +"\")");
});

//Xóa thẻ
$(document).on('mousedown', function (e) {
    container = $("#form-card-delete");
    if (!container.is(e.target) && container.has(e.target).length === 0)
        container.hide("fast");
});

//-------------------------------------------------
//Các chức năng thẻ - Kết thúc
//-------------------------------------------------

//===============================================================================================//
//===============================================================================================//
//===============================================================================================//

//-------------------------------------------------
//Các chức năng danh sách
//-------------------------------------------------

//Sửa tên danh sách
$(document).on('click', '.list-title', function (e) {
	$(".editable").removeClass("editing");
	var editable = $(this).parent();
	editable.append($("#edit"));
	var field = editable.find("#edit > .form-group > .field");
	var maDanhSach = editable.find(".list-id").text();
	editable.addClass("editing");
	
	$("#edit .form-group .btn-save").attr("onclick","ajaxSuaDanhSach('"+maDanhSach+"')");
	$(".form-id").val(maDanhSach);
	
	field.focus();
	field.val($(this).text());
	field.select();
});

//-------------------------------------------------
//Các chức năng danh sách - Kết thúc
//-------------------------------------------------

//===============================================================================================//
//===============================================================================================//
//===============================================================================================//

//Sửa tên công việc
$(document).on('click', '.checklist-item-title', function (e) {
	$(".editable").removeClass("editing");
	var editable = $(this).parent();
	editable.append($("#edit"));
	var field = editable.find("#edit > .form-group > .field");
	editable.addClass("editing");
	
	var maCongViec = $(".editing .maCongViec").val(); 
	$("#edit .form-group .btn-save").attr("onclick","ajaxSuaCongViec('"+maCongViec+"')");
	
	field.focus();
	field.val($(this).text());
	field.select();
});

$(document).mousedown(function (e) {
	var container = $(".editable");
	if (!container.is(e.target) && container.has(e.target).length === 0)
		container.removeClass("editing");
});

$(document).on('focus', '.comment-field', function (e) {
    $(".btn-group-comment").removeClass("notShow");
});

$(document).on('blur', '.comment-field', function (e) {
    if($(this).val().length == 0) $(".btn-group-comment").addClass("notShow");
});

$(document).on('focus', '#description', function (e) {
    $(".btn-act").removeClass("notShow");
    $(".btn-act .btn-primary").attr("onclick","ajaxSuaMoTaThe("+ $("#card-id").val() +")");
});

$(document).on('blur', '#description', function (e) {
    if($(this).val().length == 0) $(".btn-act").addClass("notShow");
});

//Chinh sua binh luan
$(document).on("click",".btn-edit-comment",function(){
	$(".editable").removeClass("editing");
	var binhluan = $(this).parent().parent();
	var editable = binhluan;
	editable.append($("#edit"));
	var field = editable.find("#edit > .form-group > .field");
	editable.addClass("editing");
	
	var maBinhLuan = binhluan.attr("id").replace("binhluan","");
	$("#edit .form-group .btn-save").attr("onclick","ajaxSuaBinhLuan('"+maBinhLuan+"')");
	
	field.focus();
	field.val(binhluan.children(".comment-content").text());
	field.select();
});

$(document).on("submit","form",function(e){
	e.preventDefault();
});

$(document).ready(
		function () {
			$(".project-title").click(
					function () {
						$(".editable").removeClass("editing");
						var editable = $(this).parent();
						editable.append($("#edit"));
						var field = editable.find("#edit > .form-group > .field");
						var maKeHoach = localStorage.maKeHoach;
						$("#edit .form-group .btn-save").attr("onclick","ajaxSuaKeHoach('"+maKeHoach+"')");
						editable.addClass("editing");
						field.focus();
						field.val($(this).text());
						field.select();
					}
			);


			$(".cancel").click(
					function (e) {
						var editable = $(this).parent().parent().parent();
						editable.removeClass("editing");
					}
			);

			$(".toggle").click(
					function () {
						var index = $(this).index();
						$('.panel-container').eq(index).toggle().siblings('.panel-container').hide();
					}
			);

			$("#btn-notification").tooltip({
				title: "Hoạt động",
				placement: "left",
				container: 'body'
			});

			$("#btn-project").tooltip({
				title: "Kế hoạch",
				placement: "left",
				container: 'body'
			});

			$("#btn-group").tooltip({
				title: "Nhóm",
				placement: "left",
				container: 'body'
			});

			$("#deadline").datepicker({
				format: 'dd/mm/yyyy'
			});
		}
);