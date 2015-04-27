
$(document).ready(function(){
	var url = $(location).attr('href');
	var existURL = url.match(/Test.html/i);
	var delay = 59 ;
   
   
	if(existURL == null) {
		
	} else {
		var soLanThi = $("#soLanThi").val();
		var taiKhoan = $("#taiKhoan").val();
		var msdt = $("#msdt").val();
		var phut = new Number($("#finish-time").val());
		var seconds = "seconds_"+taiKhoan+"_"+msdt+"_"+soLanThi;
		var minutes = "minutes_"+taiKhoan+"_"+msdt+"_"+soLanThi;
		if(localStorage.getItem(seconds)){
		    if(localStorage.getItem(seconds) <= 0){
		        var value = 0;
		    }else{
		        var value = localStorage.getItem(seconds);
		      }
		}else{
		      var value = 59;
		    }

		if(localStorage.getItem(minutes)){
		    if(localStorage.getItem(minutes) <= 0){
		        var p = 0;
		    }else{
		        var p = localStorage.getItem(minutes);
		      }
		}else{
		      var p = parseInt(phut) - 1;
		    }
		    
		    document.getElementById('time-limit').innerHTML = "Thời gian còn lại: "+p+" : "+value;
		    var counter = function (){
		      if(value <= 0 && p>0){
		        localStorage.setItem(seconds, 59);
		        value = 59;
		        p =  parseInt(p)-1;
		        localStorage.setItem(minutes, p);
		      }else{
		        value = parseInt(value)-1;
		        localStorage.setItem(seconds, value);
		      }
		      document.getElementById('time-limit').innerHTML = "Thời gian còn lại: "+p+" : "+value;
		      
		      if(value <= 0 && p<=0){
		         document.getElementById('time-limit').innerHTML = "Hết thời gian !";
		         NopBai();
		      }
		    };
		    var interval = setInterval(function (){counter();}, 1000);
		  
	}
	
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

function NopBai() {
	var msdt = $("#msdt").val();
	window.location.href = "Ket-Qua-Thi.html?msdt="+msdt;
}




