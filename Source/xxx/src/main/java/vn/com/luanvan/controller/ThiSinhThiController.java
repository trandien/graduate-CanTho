package vn.com.luanvan.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.luanvan.form.BangThiSinhThiForm;
import vn.com.luanvan.form.KetQuaThiForm;
import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.Cautraloi;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Phancongvaitro;
import vn.com.luanvan.model.Thi;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.CauHoiService;
import vn.com.luanvan.service.CauTraLoiService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.PhanCongVaiTroService;
import vn.com.luanvan.service.ThiSinhThiService;

@Controller
public class ThiSinhThiController {

	@Autowired
	DeThiService deThiService;

	@Autowired
	PhanCongVaiTroService phanCongVaiTroService;

	@Autowired
	CauHoiService cauHoiService;
	
	@Autowired
	ThiSinhThiService thiSinhThiService;

	@Autowired
	CauTraLoiService cauTraLoiService;
	
	private String tableThiSinh = "";
	
	private int daVaoTrang = 0;
	
	private List<Cauhoi>listCauHois;
	
	public List<Cauhoi> getListCauHois() {
		return listCauHois;
	}

	public void setListCauHois(List<Cauhoi> listCauHois) {
		this.listCauHois = listCauHois;
	}

	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}
	
	private boolean isPermission(int msdt, String taiKhoan) {
		boolean quyenTruyCap = false;
		List<Phancongvaitro> listpcvt = phanCongVaiTroService
				.ListPhanCongVaiTro(msdt);
		for (Phancongvaitro pcvt : listpcvt) {
			if (pcvt.getUser().getNdTaikhoan().equals(taiKhoan)) {
				quyenTruyCap = true;
				break;
			}
		}
		return quyenTruyCap;
	}

	@RequestMapping(value = "/Nhap-Mat-Khau-De-Thi.html", method = RequestMethod.GET)
	public ModelAndView TrangMatKhauDeThi(ModelAndView model,
			HttpServletRequest request, HttpSession session) {
		int msdt = Integer.parseInt(request.getParameter("msdt"));
		Dethi DeThi = deThiService.LayDeThiByMa(msdt);
		try{
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
		if (isPermission(msdt, taiKhoan)) {
			model.addObject("DeThi", DeThi);
			model.setViewName("TrangMatKhauDeThi");
		} else {
			model.setViewName("403");
		}
		} catch(Exception e) {
			model.setViewName("redirect:/Dang-Nhap.html");
		}
		
		return model;
	}

	@RequestMapping(value = "/AjaxKiemTraMatKhauDeThi", method = RequestMethod.POST)
	public @ResponseBody String KiemTraMatKhauDeThi(ModelAndView model,
			HttpServletRequest request, HttpSession session) {
		String matKhauDeThi = request.getParameter("MatKhauNhap");
		String result = "";
		int msdt = 0;
		Dethi DeThi = new Dethi();
		msdt = Integer.parseInt(request.getParameter("MaDeThi"));
		DeThi = deThiService.LayDeThiByMa(msdt);
		
		if (DeThi.getDtMatkhau().equals(matKhauDeThi)) {
			result = "Mat khau dung";
			System.out.println(result);
			
		} else {
			System.out.println("Mat khau sai");
		}

		return result;
	}
	
	@RequestMapping(value = "/AjaxKiemTraSoLanChoPhep", method = RequestMethod.POST)
	public @ResponseBody String KiemTraSoLanChoPhep(ModelAndView model,
			HttpServletRequest request, HttpSession session) {
		System.out.println("Kiem tra so lan cho phep duoc goi");
		String result = "";
		int msdt = 0;
		Dethi DeThi = new Dethi();
		int soLanThiChoPhep = 0;
		int soLanThi = 0;
		String taiKhoan = "";
		
		msdt = Integer.parseInt(request.getParameter("MaDeThi"));
		DeThi = deThiService.LayDeThiByMa(msdt);
		User user = new User();
		user = (User) session.getAttribute("user");
		taiKhoan = user.getNdTaikhoan();
		soLanThiChoPhep = DeThi.getDtSolanchophep();
		
		soLanThi = thiSinhThiService.KiemTraSoLanThi(taiKhoan, msdt);
		
		if(soLanThi >= soLanThiChoPhep) {
			result = "Ban da thi vuot qua so lan cho phep";
			System.out.println("Ban da thi vuot qua so lan cho phep");
		} else {
			++soLanThi;
			Thi thi = new Thi();
			thi.setDethi(DeThi);
			thi.setUser(user);
			thi.setSolanthi(soLanThi);
			thiSinhThiService.ThemThiSinhThi(thi);
			System.out.println("Them vao bang thi thanh cong");
		}
		return result;
	}

	@RequestMapping(value = "/AjaxTaoBangThiSinhThi", method = RequestMethod.POST)
	public @ResponseBody String TaoBangThiSinhThi(ModelAndView model,
			HttpServletRequest request, HttpSession session) {
		System.out.println("Tao bang thi sinh duoc goi");
		String result = "";
		tableThiSinh = "";
		int msdt = 0;
		int soLanThi = 0;
		String taiKhoan = "";
		Dethi DeThi = new Dethi();
		User user = new User();
		try {
			user = (User) session.getAttribute("user");
			taiKhoan = user.getNdTaikhoan();
			msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			soLanThi = thiSinhThiService.KiemTraSoLanThi(taiKhoan, msdt);
			thiSinhThiService.CreateTableExam(taiKhoan, msdt, soLanThi);
			result = taiKhoan+"_"+msdt+"_"+soLanThi;
			tableThiSinh = result;
			System.out.println(result);
		} catch(Exception e) {
			System.out.println("Tao bang that bai "+e.getMessage()+" : "+soLanThi);
		}
		return result;
	}

	@RequestMapping(value = "/Test.html", method = RequestMethod.GET)
	public ModelAndView ChuyenTrangThi(ModelAndView model,
			HttpServletRequest request, HttpSession session,
			RedirectAttributes redirectAttributes) throws InterruptedException {

		System.out.println("Test duoc goi");
		boolean quyenTruyCap = false;
		if (isLogin(session)) {
			int msdt = Integer.parseInt(request.getParameter("msdt"));
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			int soLanThi = 0;
			soLanThi = thiSinhThiService.KiemTraSoLanThi(taiKhoan, msdt);
			String tableName = "";
			tableName = taiKhoan+"_"+msdt+"_"+soLanThi;
			
			String dapAnDung = "";
			Cauhoi CauHoi = new Cauhoi();
			if (isPermission(msdt, taiKhoan)) {
				List<Cauhoi> listCauHoi = new ArrayList();
				if(getListCauHois() != null) {
					listCauHoi = getListCauHois();
				} else {
					listCauHoi = cauHoiService.listCauHoi(msdt);
					setListCauHois(listCauHoi);
				}
				
				int sizeListCauHoi = listCauHoi.size();
				int dangCauHoi = 0;
				List<Cautraloi> listCTL = null;
				String result = "";
				result += "<div class='form-group' style='text-align: center;'>";
				result += "    <h1>" + DeThi.getDtTende() + "</h1>";
				result += "    <input hidden id='finish-time' value='"
						+ DeThi.getDtThoigianlambai() + "'/>";
				result += "   <span>Thời gian: " + DeThi.getDtThoigianlambai()
						+ " phút</span><br>";
				result += "    <span>Môn: " + DeThi.getMonhoc().getMhTen()
						+ "</span><br>";
				result += "    <span>Lưu ý: " + DeThi.getDtDando() + "</span>";
				result += "  </div>";
				result += "  <hr>";
				result += "  <div class='container'>";
				result += "    <div class='row'>";
				result += "       <div class='question-table'>";
				result += "         <div id='title-question'>Câu hỏi</div>";
				result += "         <hr>";
				result += "        <div class='question-number'>";
				result += "          <div class='group-question'>";
				for (int i = 1; i <= sizeListCauHoi; i++) {
					result += "            <span class='question-numberx' id='question-number-"
							+ i + "'>" + i + "</span>";
					if (i % 5 == 0) { // Hiển thị 5 câu hỏi trên cùng 1 hàng
						result += "          </div>";
						result += "         <div class='group-question'>";
					}
					if (i == sizeListCauHoi) {
						result += "          </div>";
						result += "      </div>";
					}
				}
				result += "      <hr>";
				result += "      <span id='time-limit'></span>";
				result += "      <hr>";
				result += "      <button class='btn btn-primary question-btn' onclick='NopBai()'>Nộp bài và kết thúc</button>";
				result += "    </div>";
				result += "    <div class='col-md-3 col-lg-3 col-xs-3'>";
				result += "  </div>";

				result += "  <div class='col-md-9 col-lg-9 col-xs-9'>";
				result += "    <span id='title-content-question'>Nội dung câu hỏi</span>";
				result += "    <hr>";
				result += "    <div class='question'>";
				result += "      <div class='group-question'>";
				int macauhoi = 0;
				for (int j = 1; j <= sizeListCauHoi; j++) {
					dangCauHoi = 0;
					listCTL = null;
					result += "       <div class='content-question' >";
					result += "         Câu " + j + ": "
							+ listCauHoi.get(j - 1).getChNoidungcauhoi();
					result += "        </div>";
					dangCauHoi = listCauHoi.get(j - 1).getDangcauhoi()
							.getMsdch();
					listCTL = cauTraLoiService.LayDSCauTraLoi(listCauHoi.get(
							j - 1).getMsch());
					String labelAnswer = "";
					if (dangCauHoi == 1) { // Dạng câu hỏi là radio
						for (int k = 0; k < listCTL.size(); k++) {
							labelAnswer = "";
							char lableAnswer = (char) (k + 65);
							result += "        <div class='content-answer'>";
							result += "          <div class='radio'>";
							result += "            <label>";
							result += "              <input class='radio-answer' type='radio' name='"
									+ listCauHoi.get(j - 1).getMsch()+ "-"+soLanThi+"'"
											+ " id='"+listCauHoi.get(j - 1).getMsch()+"-" + listCTL.get(k).getMsctl()
									+ "-"+soLanThi+"' value='"+listCTL.get(k).getCtlNoidung()+"'>";
							result += " <div class='form-group' style='display: inline' ><p>"
									+ lableAnswer
									+ ".&nbsp;&nbsp;</p>"
									+ listCTL.get(k).getCtlNoidung() + "</div>";
							result += "            </label>";
							result += "          </div> ";
							result += "        </div>";
									
						}
						
					} else if (dangCauHoi == 2) { // Dạng câu hỏi là checkbox
						for (int k = 0; k < listCTL.size(); k++) {
							labelAnswer = "";
							char lableAnswer = (char) (k + 65);
							result += "        <div class='content-answer'>";
							result += "          <div class='checkbox' id='checkbox-"+listCauHoi.get(j - 1).getMsch()+"'>";
							result += "            <label>";
							result += "              <input class='checkbox-answer' type='checkbox' name='"
									+ listCauHoi.get(j - 1).getMsch()+"-" + listCTL.get(k).getMsctl()+ "-"+soLanThi+"'"
											+ " id='"+listCauHoi.get(j - 1).getMsch()+"-" + listCTL.get(k).getMsctl()
									+ "-"+soLanThi+"' value='"+listCTL.get(k).getCtlNoidung()+"'>";
							result += " <div class='form-group' style='display: inline' ><p>"
									+ lableAnswer
									+ ".&nbsp;&nbsp;</p>"
									+ listCTL.get(k).getCtlNoidung() + "</div>";
							result += "            </label>";
							result += "          </div> ";
							result += "        </div>";
						}
						result += "<div id='DaChon-"+listCauHoi.get(j - 1).getMsch()+"'> </div>";
					} else {
						// Dạng câu hỏi điền vào chổ trống
					}
					result += "        <div class='tag' >";
					result += "          <span class='glyphicon glyphicon-check isTag' title='Đánh dấu' id='tag-"
							+ listCauHoi.get(j - 1).getMsch()
							+ "-"
							+ j
							+ "'></span>";
					result += "        </div>";
					result += "<hr>";
				}
				result += "    </div>";
				result += "  </div>";
				result += " </div>";
				result += " </div>";
				result += "</div>";
				
				model.addObject("load", result);
				model.addObject("msdt", msdt);
				model.addObject("taiKhoan", taiKhoan);
				model.addObject("soLanThi", soLanThi);
				model.setViewName("DeThi");
			} else {
				model.setViewName("403");
			}
		} else {
			model.setViewName("redirect:/Dang-Nhap.html");
		}
		daVaoTrang = 1;
		return model;
	}

	@RequestMapping(value = "/Ket-Qua-Thi.html", method = RequestMethod.GET)
	public ModelAndView KetQuaThi(ModelAndView model,
			HttpServletRequest request, HttpSession session) throws ParseException {
		try {
			int msdt = 0;
			msdt = Integer.parseInt(request.getParameter("msdt"));
			
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			int laySoLanThi = thiSinhThiService.KiemTraSoLanThi(taiKhoan, msdt); // Hàm trả về kết quả là số lần thi mà hiện tại đang thi
			int tongSoCauHoi = deThiService.LaySLCauHoiTrongDeThi(msdt);
			Thi thi = new Thi();
			String kqthi = "";
			kqthi = thiSinhThiService.BangHocSinhDeThiForm(taiKhoan, msdt, laySoLanThi);
			thi = thiSinhThiService.LayBangThi(taiKhoan, msdt, laySoLanThi);
			Date timeFinish = new Date();
			thi.setTDiem(Float.parseFloat(kqthi.split("-")[0]));
			thi.setTSocaudung(Integer.parseInt(kqthi.split("-")[1]));
			thi.setTNgaylam(timeFinish);
			thi.setTTongsocau(tongSoCauHoi);
			thiSinhThiService.SuaThiSinhThi(thi);
			List<Thi> listBHST = thiSinhThiService.listBangHocSinhDeThiForm(taiKhoan, msdt);
			model.addObject("listBHST", listBHST);
			model.setViewName("KetQuaThi");
		} catch(Exception e) {
			model.setViewName("404");
		}
		return model;
	}
	
	@RequestMapping(value = "/AjaxLuuKQThi", method = RequestMethod.POST)
	public @ResponseBody String LuuKQThi(HttpServletRequest request, HttpSession session) {
		String result = "";
		try {
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			String cautraloi = request.getParameter("MaCauTraLoi");
			float Diem = 0;
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			String dapAnDung = "";
			Cauhoi CauHoi = new Cauhoi();
			CauHoi = cauHoiService.LayCauHoiByMa(msch);
			dapAnDung = CauHoi.getChDapandung();
			if(dapAnDung.equals(cautraloi)) {
				Diem = CauHoi.getChDiem();
			}
			if(tableThiSinh.equals("") || tableThiSinh == null) {
				tableThiSinh = thiSinhThiService.LayBangDangThi(taiKhoan, msch);
			}
			thiSinhThiService.LuuKQThiSinh(tableThiSinh, msch, cautraloi, dapAnDung, Diem);
			result = "Luu Kq thi thanh cong";
		} catch (Exception e) {
			System.out.println("Luu ket qua thi that bai");
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxSuaKQThi", method = RequestMethod.POST)
	public @ResponseBody String SuaKQThi(HttpServletRequest request, HttpSession session) {
		String result = "";
		try {
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			String cautraloi = request.getParameter("MaCauTraLoi");
			float Diem = 0;
			String dapAnDung = "";
			Cauhoi CauHoi = new Cauhoi();
			CauHoi = cauHoiService.LayCauHoiByMa(msch);
			dapAnDung = CauHoi.getChDapandung();
			if(dapAnDung.equals(cautraloi)) {
				Diem = CauHoi.getChDiem();
			}
			
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			if(tableThiSinh.equals("") || tableThiSinh == null) {
				tableThiSinh = thiSinhThiService.LayBangDangThi(taiKhoan, msch);
			}
			thiSinhThiService.SuaKQThiSinh(tableThiSinh, msch, cautraloi, Diem);
			result = "Sua Kq thi thanh cong";
		} catch (Exception e) {
			System.out.println("Luu ket qua thi that bai");
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxKiemTraCHCoDuocChon", method = RequestMethod.POST)
	public @ResponseBody String KiemTraCHCoDuocChon(HttpServletRequest request, HttpSession session) {
		String result = "";
		try {
			boolean kq = false;
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			if(tableThiSinh.equals("") || tableThiSinh == null) {
				tableThiSinh = thiSinhThiService.LayBangDangThi(taiKhoan, msch);
			}
			kq = thiSinhThiService.KTCHDaDuocChon(tableThiSinh, msch);
			if(kq) {
				result = "true";
			} else {
				result = "false";
			}
			System.out.println("Ket qua chon la "+result);
		} catch (Exception e) {
			result = "true";
		}
		return result;
	}
}








