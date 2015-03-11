function ajaxLuuThongTin()
{
	//alert($("#uploadPreview").attr("src"));
    $.ajax({
        data: "HinhAnh=" + $("#uploadPreview").attr("src") + "&HoTen=" + $("#profile-name-edit").val() + "&MatKhau=" + $("#new-pass").val(),
        type: "POST",
        url : "AjaxLuuThongTin",
        success : function(result) {
            $("#profile-name").text(result);
            $("#bubble-name").text(result);
        },
        error : function() {
            alert("ERROR");
        }
    });
}