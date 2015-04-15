package vn.com.luanvan.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.Dangthi;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Hocky;
import vn.com.luanvan.model.Monhoc;
import vn.com.luanvan.model.Nienkhoa;
import vn.com.luanvan.model.Phancongvaitro;
import vn.com.luanvan.model.PhancongvaitroId;
import vn.com.luanvan.model.User;
import vn.com.luanvan.model.Vaitro;
import vn.com.luanvan.service.ChuDeService;
import vn.com.luanvan.service.DangThiService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.MonHocService;
import vn.com.luanvan.service.NienKhoaService;

@Controller
public class DeThiController {

	@Autowired
	DeThiService deThiService;

	@Autowired
	ChuDeService chuDeService;
	
	@Autowired
	MonHocService monHocService;

	@Autowired
	DangThiService dangThiService;

	@Autowired
	NienKhoaService nienKhoaService;
	
	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}

	@RequestMapping(value = "/De-Thi.html")
	public ModelAndView TrangDeThi(ModelAndView model, HttpSession session,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (isLogin(session)) {
			User user = (User) session.getAttribute("user");
			String mscd = request.getParameter("mscd");
			System.out.println("Ma so chu de: "+mscd);
			String taiKhoan = user.getNdTaikhoan();
			List<Monhoc> listMonHoc = monHocService.DSMonHoc();
			List<Dangthi> listDangThi = dangThiService.DSDangThi();
			List<Chude> listChude = chuDeService.DSChuDeByTaiKhoan(taiKhoan);
			List<Nienkhoa> listNienKhoa = nienKhoaService.DSNienKhoa();
			model.addObject("listMonHoc", listMonHoc);
			model.addObject("listDangThi", listDangThi);
			model.addObject("listChude", listChude);
			model.addObject("listNienKhoa", listNienKhoa);
			model.addObject("mscd", mscd);
			model.setViewName("ThemDeThi");
			return model;
		} else {
			model.setViewName("redirect:/Dang-Nhap.html");
			return model;
		}
	}

	@RequestMapping(value = "/AjaxLuuDeThi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String TaoDeThi(ModelAndView model,
			HttpSession session, HttpServletRequest request)
			throws ParseException {
		String result="";
		if (isLogin(session)) {
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			
			System.out.println("Ham de thi duoc goi");
			Dethi DeThi = new Dethi();
			String tenDe = request.getParameter("TenDe");
			String nienKhoa = request.getParameter("NienKhoa");
			String hocKy = request.getParameter("HocKy");
			String mscd = request.getParameter("ChuDe");
			String monHoc = request.getParameter("MonHoc");
			String dangThi = request.getParameter("HeSo");
			String trangThai = request.getParameter("TrangThai");
			String thoiGianLamBai = request.getParameter("ThoiGian");
			String ngayTaoDe = request.getParameter("NgayTaoDe");
			String danDo = request.getParameter("DanDo");
			String soLanChoPhepThi = request.getParameter("SoLanChoPhep");
			String matKhauDeThi = request.getParameter("MatKhauDeThi");
			SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("yyyy-MM-dd");
		//	String ngayCapNhat = dinhDangThoiGian.format(thoiGian.getTime());
			Date thoiGianTaoDe = dinhDangThoiGian.parse(ngayTaoDe);
		//	Date ngayCapNhat = new Date();
			DeThi.setDtTende(tenDe);
			DeThi.setDtMatkhau(matKhauDeThi);
			DeThi.setDtNgaycapnhat(null);
			DeThi.setDtDando(danDo);
			DeThi.setDtNgaytaode(thoiGianTaoDe);
			DeThi.setDtSolanchophep(Integer.parseInt(soLanChoPhepThi));
			DeThi.setDtThoigianlambai(Integer.parseInt(thoiGianLamBai));
			DeThi.setDtTrangthai(Integer.parseInt(trangThai));
			DeThi.setDtNguoirade(taiKhoan);
			

			Nienkhoa NienKhoa = new Nienkhoa();
			Hocky HocKy = new Hocky(Integer.parseInt(hocKy));
			Chude ChuDe = new Chude();
			Monhoc MonHoc = new Monhoc();
			Dangthi DangThi = new Dangthi();
			Vaitro vaiTro = new Vaitro();
			vaiTro.setMsvt(5);
			vaiTro.setVtTen("GVRaDe");
			
			
			ChuDe = chuDeService.LayChuDeByMa(Integer.parseInt(mscd));
			MonHoc = monHocService.LayMonHocByMa(Integer.parseInt(monHoc));
			NienKhoa = nienKhoaService.TimNienKhoaByMa(Integer.parseInt(nienKhoa));
			DangThi = dangThiService.TimDangThiByMa(Integer.parseInt(dangThi));
			
			DeThi.setChude(ChuDe);
			DeThi.setMonhoc(MonHoc);
			DeThi.setNienkhoa(NienKhoa);
			DeThi.setDangthi(DangThi);
			DeThi.setHocky(HocKy);
			
			deThiService.ThemDeThi(DeThi);
			int msdt = deThiService.LayMaxDeThiByTaiKhoan(taiKhoan);
			System.out.println("msdt: " + msdt);
			System.out.println("Them thanh cong");
			
			return String.valueOf(msdt);
		} else {
			return result;
		}
	}
	
	@RequestMapping(value = "/AjaxSuaThongTinDeThi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaDeThi(ModelAndView model,
			HttpSession session, HttpServletRequest request)
			throws ParseException {
		String result="";
		if (isLogin(session)) {
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			System.out.println("Ham de thi duoc goi");
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			String tenDe = request.getParameter("TenDe");
			String nienKhoa = request.getParameter("NienKhoa");
			String hocKy = request.getParameter("HocKy");
			String mscd = request.getParameter("ChuDe");
			String monHoc = request.getParameter("MonHoc");
			String dangThi = request.getParameter("HeSo");
			String trangThai = request.getParameter("TrangThai");
			String thoiGianLamBai = request.getParameter("ThoiGian");
			String ngayTaoDe = request.getParameter("NgayTaoDe");
			String danDo = request.getParameter("DanDo");
			String soLanChoPhepThi = request.getParameter("SoLanChoPhep");
			String matKhauDeThi = request.getParameter("MatKhauDeThi");
			SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("yyyy-MM-dd");
		//	String ngayCapNhat = dinhDangThoiGian.format(thoiGian.getTime());
			Date thoiGianTaoDe = dinhDangThoiGian.parse(ngayTaoDe);
		//	Date ngayCapNhat = new Date();
			DeThi.setDtTende(tenDe);
			DeThi.setDtMatkhau(matKhauDeThi);
			DeThi.setDtNgaycapnhat(null);
			DeThi.setDtDando(danDo);
			DeThi.setDtNgaytaode(thoiGianTaoDe);
			DeThi.setDtSolanchophep(Integer.parseInt(soLanChoPhepThi));
			DeThi.setDtThoigianlambai(Integer.parseInt(thoiGianLamBai));
			DeThi.setDtTrangthai(Integer.parseInt(trangThai));
			DeThi.setDtNguoirade(taiKhoan);
			
			Nienkhoa NienKhoa = new Nienkhoa();
			Hocky HocKy = new Hocky(Integer.parseInt(hocKy));
			Chude ChuDe = new Chude();
			Monhoc MonHoc = new Monhoc();
			Dangthi DangThi = new Dangthi();
			
			ChuDe = chuDeService.LayChuDeByMa(Integer.parseInt(mscd));
			MonHoc = monHocService.LayMonHocByMa(Integer.parseInt(monHoc));
			NienKhoa = nienKhoaService.TimNienKhoaByMa(Integer.parseInt(nienKhoa));
			DangThi = dangThiService.TimDangThiByMa(Integer.parseInt(dangThi));
			
			DeThi.setChude(ChuDe);
			DeThi.setMonhoc(MonHoc);
			DeThi.setNienkhoa(NienKhoa);
			DeThi.setDangthi(DangThi);
			DeThi.setHocky(HocKy);
			
			deThiService.SuaDeThi(DeThi);
			System.out.println("Them thanh cong");
			
			return String.valueOf(msdt);
		} else {
			return result;
		}
	}
	
	@RequestMapping(value = "/AjaxXoaDeThi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String XoaDeThi(ModelAndView model,
			HttpSession session, HttpServletRequest request){
		String result = "";
		if (isLogin(session)) {
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			System.out.println("-------------------");
			System.out.println("Controller Xoa de thi: ");
			System.out.println("Ma so de thi: "+msdt);
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			deThiService.XoaDeThi(DeThi);
			result = "Xoa thanh cong";
		}
		System.out.println(result);
		return result;
	}
}
