
$(document).ready(function(){
	var url = $(location).attr('href');
	var existURL = url.match(/Test.html/i);
	var delay = 59 ;
    /*
    countdown() ;
	if(existURL == null) {
		
	} else {
		var phut = new Number($("#finish-time").val());
		var giay = new Number(phut)*60000;
		function countdown() {
			
		    setTimeout(countdown, 1000) ;
		    $("#time-limit").html("Thời gian còn lại: 00 : "+phut+" : "  + delay  + " s");
		    delay --;
		    if (delay < 0 ) {
			    delay = 59 ;
			    phut--;
		    }
	    }
		setTimeout(function() {  window.location.href = "Ket-Qua-Thi.html";}, time );
	}
	*/
	$(document).on('click', '.isTag', function(e) {
		var sttCauHoi = $(this).attr('id').split("-")[2];
		var abc = $(this).attr('id');
		
		if($("#"+abc).css('color') == 'rgb(51, 51, 51)') {
			$("#"+abc).css('color', 'red');
		}else {
			$("#"+abc).css('color', '#333333');
		}
		if($("#question-number-"+sttCauHoi).css('border') == '1px solid rgb(204, 204, 204)') {
			$("#question-number-"+sttCauHoi).css('border', '1px solid red');
		}else {
			$("#question-number-"+sttCauHoi).css('border', '1px solid #ccc');
		}
		
	});
});


function LayURL() {
	var url = $(location).attr('href');
	var existURL = url.match(/Test.html/i);
	alert(existURL);
	if(existURL == null) {
		alert("null");
	} else {
		alert(url);
	}
}

function NopBai() {
	window.location.href = "Ket-Qua-Thi.html";
}