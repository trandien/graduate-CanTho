$(document).on("change","#project-deadline",function(){
	$(".datepicker").hide();
});

$(document).on('click', '.plan-delete', function (e) {
	var fpd = $("#form-plan-delete");
	if (fpd.css("display") != "none")
	{
		fpd.hide("fast");
		return;
	}

	var pos = $(this).offset();
	var x = pos.left;
	var y = pos.top + $(this).height() + 5;

	$("#form-plan-delete").css({
		"left": x + "px",
		"top": y + "px"
	})

	$("#form-plan-delete").show("fast");
	var mkh = $(this).children(".plan-delete-val").val();
	$("#form-makehoach").val(mkh);
});

$(document).on('click', '.plan', function () {
	localStorage.setItem("maKeHoach", $(this).parent().attr("id"));
	var href = $(this).children(".plan-header").children(".plan-title").attr("href");
	window.location.href = href;
});

$(document).on("submit","form",function(e){
	e.preventDefault();
});

$(document).on("click",".btn-create-project", function (e) {
	var pcp = $(".panel-create-project");
	if (pcp.css("display") != "none") return;
	var pos = $(this).offset();
	var x = pos.left;
	var y = pos.top;

	if (!$(this).hasClass("btn-create-project"))
		y = y + $(this).outerHeight();
	//alert("x = " + x + "y = " + y);
	$(".panel-create-project").css({
		"left": x + "px",
		"top": y + "px"
	})
	$(".panel-create-project").show("fast");
	$("#project-title").focus();
});

$(document).on("click",".toggle",function () {
	var index = $(this).index();
	$('.panel-container').eq(index).toggle().siblings('.panel-container').hide();
});

$(document).mousedown(function (e) {
	var container = $(".panel-create-project");
	var datepicker = $(".datepicker");
	if (!container.is(e.target) && container.has(e.target).length === 0 && !datepicker.is(e.target) && datepicker.has(e.target).length === 0) {
		container.hide("fast");
	}

	container = $("#form-plan-delete");
	if (!container.is(e.target) && container.has(e.target).length === 0)
		container.hide("fast");
});

$(document).ready(
		function () {
			$("#btn-notification").tooltip({
				title: "Thông báo",
				placement: "left",
				container: 'body'
			});

			$("#btn-project").tooltip({
				title: "Kế hoạch",
				placement: "left",
				container: 'body'
			});

			$("#project-deadline").datepicker({
				format: 'dd/mm/yyyy'
			});
		}
);