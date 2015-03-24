package vn.com.luanvan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.CauhoiId;
import vn.com.luanvan.model.CautraloiId;
import vn.com.luanvan.model.Dangcauhoi;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Dokho;
import vn.com.luanvan.service.CauHoiService;
import vn.com.luanvan.service.DangCauHoiService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.DoKhoService;

@Controller
public class CauHoiController {
	
	@Autowired
	CauHoiService cauHoiService;
	
	@Autowired
	DangCauHoiService dangCauHoiService;
	
	@Autowired
	DoKhoService doKhoService;
	
	@Autowired
	DeThiService deThiService;
	
	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}

	@RequestMapping(value = "/AjaxThemCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cauhoi CauHoi = new Cauhoi();
			int maDeThi = Integer.parseInt(request.getParameter("maDeThi"));
			int maChuDe = Integer.parseInt(request.getParameter("maChuDe"));
			int maCauHoi = cauHoiService.LayMaxIdCauHoi(maChuDe) + 1;
			int maDangCauHoi = Integer.parseInt(request.getParameter("MaDangCauHoi"));
			int maDoKho = Integer.parseInt(request.getParameter("MaDoKho"));
			String noiDungCauHoi = request.getParameter("noiDungCauHoi");
			float diem = Float.parseFloat(request.getParameter("Diem"));
			String dapAnDung = request.getParameter("DapAnDung").trim();
			
			System.out.println("------------------------------------");
			System.out.println("Ma chu de: "+maChuDe);
			System.out.println("Ma cau hoi: "+maCauHoi);
			System.out.println("Ma dang cau hoi: "+maDangCauHoi);
			System.out.println("noi dung cau hoi: "+noiDungCauHoi);
			System.out.println("Ma do kho: "+maDoKho);
			System.out.println("Diem: "+diem);
			System.out.println("Dap an: "+dapAnDung);
			
			Dangcauhoi DangCauHoi = dangCauHoiService.LayDangCauHoiByMa(maDangCauHoi);
			Dokho DoKho = doKhoService.LayDoKhoByMa(maDoKho);
			
			Dethi DeThi = deThiService.LayDeThiByMa(maDeThi);
			CauhoiId CauHoiId = new CauhoiId();
			CauHoiId.setMsch(maCauHoi);
			CauHoiId.setMsdt(DeThi.getMsdt());
			
			CauHoi.setId(CauHoiId);
			CauHoi.setDangcauhoi(DangCauHoi);
			CauHoi.setDethi(DeThi);
			CauHoi.setDokho(DoKho);
			CauHoi.setChNoidungcauhoi(noiDungCauHoi);
			CauHoi.setChDiem(diem);
			CauHoi.setChDapandung(dapAnDung);
			
			cauHoiService.ThemCauHoi(CauHoi);
			System.out.println("Them cau hoi thanh cong");
			
		} else {

		}
		return result;
	}

	@RequestMapping(value = "/AjaxLayMaxIdCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LayMaxIdCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		String maChuDe = request.getParameter("MaChuDe");
		System.out.println(maChuDe);
		int IntMaChuDe = Integer.parseInt(maChuDe);
		int maxIdCauHoi = cauHoiService.LayMaxIdCauHoi(IntMaChuDe) + 1;
		System.out.println(maxIdCauHoi);
		String maxIdCauHoiString = String.valueOf(maxIdCauHoi);
		result +="<div id='themcauhoi' style='border: 1px solid #000077; margin-bottom: 15px;'>";
		result += "<div class=cauhoi'>";
		result += "<div class='container-fluid'>";
		result +=	"<div class='row'>";
		result +=		"<div class='col-md-2 col-sm-2 col-lg-2 col-xs-2'>";
		result +=			"<strong style='font-size: 20px;' id='doimautheodokho'>Câu &nbsp;"+maxIdCauHoiString+"</strong>";
		result +=			"<div class='form-group'>";
		result +=				"<div class='radio'>";
		result +=					"<label> <input type='radio' name='dokho'";
		result +=						"id='inputmucdode' value='3' checked='checked'> <span";
		result +=						"id='idmucdode'>Dễ</span>";
		result +=					"</label><br> <label> <input type='radio' name='dokho'";
		result +=						"id='inputmucdotrungbinh' value='1'> <span";
		result +=						"id='idmucdotrungbinh'>Trung bình</span>";
		result +=					"</label><br> <label> <input type='radio' name='dokho'";
		result +=						"id='inputmucdokho' value='2'> <span";
		result +=						"id='idmucdokho'>Khó</span>";
		result +=					"</label>";
		result +=				"</div>";
		result +=			"</div>";
		result +=		"</div>";
		result +=		"<div class='col-md-10 col-sm-10 col-lg-10 col-xs-10'>";
		result +=			"<div class='form-group'>";
		result +=				"<div class='radio'>";
		result +=					"<label> <input type='radio' name='dangcauhoi1'";
		result +=						"id='choncaudungnhat1' value='1' checked='checked'>";
		result +=						"Chọn câu đúng nhất &nbsp; &nbsp;&nbsp;";
		result +=					"</label> <label> <input type='radio' name='dangcauhoi1'";
		result += "id='chonnhieucaudung1' value='2'> Chọn nhiều câu";
		result +=		"đúng &nbsp; &nbsp;&nbsp;";
		result +=	"</label> <label> <input type='radio' name='dangcauhoi1'";
		result +=		"id='dienvaochotrong1' value='3'> Điền vào chổ trống";
		result +=	"</label>";
		result += "</div>";
		result +="</div>";
		result +="<div class='form-group'>";
		result +="<span>Điểm cho câu hỏi này là:</span><input type='text'";
		result +=	"class='form-control' name='diemChoCauHoi1'";
		result +=	"id='diemChoCauHoi1' style='width: 100px;'>";
		result +="<div id='thongbao_loinhapdiem'></div>";
		result +="</div>";
		result +="<hr>";
		result +="<section id='editor' style='width: 95%;'>";
		result +="<div id='edit1'";
		result +="style='margin-top: 30px; margin-bottom: 10px;'>";
		result +="<p>Java do ai sáng lập</p>";
		result +="</div>";
		result +="</section>";
		result +="<section id='buttons'>";
		result +="<div>";
		result +="<input type='button' id='destroy' value='Xong' hidden>";
		result +="<input type='button' id='init' class='btn btn-primary'";
		result +="value='Sửa'> <a class='btn btn-danger'";
		result +="data-toggle='modal' href='#modal-id'>Xóa</a>";
		result +="</div>";
		result +="</section>";
		result +="</div></div></div><hr>";
		result +="<div class='cautraloi' style='padding-top: 15px;'>";

		result +="<table class='table table-hover'>";
		result +="<thead>";
		result +="<strong>Câu trả lời</strong>";
		result +="</thead>";
		result +="<tbody style='text-align: left;'>";
		result +="<tr>";
		result +="<td>A.</td>";
		result +="<td><section id='editor' style='width: 95%;'>";
		result +="<div id='editcautraloi'";
		result +="	style='margin-top: 30px; margin-bottom: 10px;'>";
		result +="	<p>Donec facilisis diam in odio iaculis blandit.</p>";
		result +="</div>";
		result +="</section></td>";
		result +="<td><section id='buttons'> <input";
		result +="	type='button' value='Sửa' class='btn btn-success'";
		result +="	id='sua-cau-tra-loi'> <input type='button'";
		result +="	value='Xong' id='sua-cau-tra-loi-xong' hidden> </section></td>";
		result +="<td><input type='button' value='Xóa'";
		result +="class='btn btn-danger' id='xoa-cau-tra-loi'></td>";
		result +="</tr>";

		result +="</tbody>";
		result +="</table>";
		result +="<hr>";
		result +="<div class='form-group'>";
		result +="<button class='btn btn-success' id='them-cau-hoi'>";
		result +="Thêm câu trả lời &nbsp;<span class='glyphicon glyphicon-plus'></span>";
		result +="</button>";
		result +="</div>";

		result +="</div>";
		result +="</div>";
		result +="</div>";
		return maxIdCauHoiString;
	}
}











