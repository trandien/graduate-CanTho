package vn.com.luanvan.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import vn.com.luanvan.model.DethiLop;
import vn.com.luanvan.model.Hocky;
import vn.com.luanvan.model.Lop;
import vn.com.luanvan.model.Monhoc;
import vn.com.luanvan.model.Nienkhoa;
import vn.com.luanvan.model.Phancongvaitro;
import vn.com.luanvan.model.Phongthi;
import vn.com.luanvan.model.User;
import vn.com.luanvan.model.Vaitro;
import vn.com.luanvan.service.ChuDeService;
import vn.com.luanvan.service.DangThiService;
import vn.com.luanvan.service.DeThiLopService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.LopService;
import vn.com.luanvan.service.MonHocService;
import vn.com.luanvan.service.NienKhoaService;
import vn.com.luanvan.service.PhanCongVaiTroService;
import vn.com.luanvan.service.PhongThiService;
import vn.com.luanvan.service.UserService;

@Controller
public class DeThiController {

	@Autowired
	UserService userService;
	
	@Autowired
	PhongThiService phongThiService;
	
	@Autowired
	DeThiLopService deThiLopService;
	
	@Autowired
	LopService lopService;
	
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
	
	@Autowired
	PhanCongVaiTroService phanCongVaiTroService;
	
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
			List<User> listGV = userService.LayDanhSachGiaoVien();
			List<Phongthi> listPhongThi = phongThiService.danhSachPhongThi();
			List<Lop> listLop = lopService.listLop();
			redirectAttributes.addFlashAttribute("sua", "0");
			
			model.addObject("listLop", listLop);
			model.addObject("listPhongThi", listPhongThi);
			model.addObject("listGV", listGV);
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
			Date thoiGianTaoDe = dinhDangThoiGian.parse(ngayTaoDe);
			
			DeThi.setDtTende(tenDe);
			DeThi.setDtMatkhau(matKhauDeThi);
			DeThi.setDtNgaycapnhat(null);
			DeThi.setDtDando(danDo);
			DeThi.setDtNgaytaode(thoiGianTaoDe);
			DeThi.setDtSolanchophep(Integer.parseInt(soLanChoPhepThi));
			DeThi.setDtThoigianlambai(Integer.parseInt(thoiGianLamBai));
			DeThi.setDtTrangthai(Integer.parseInt(trangThai));
			DeThi.setUser(user);
			

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
			deThiService.ThemDeThi(DeThi);
				
			Vaitro vaiTro = new Vaitro();
			vaiTro.setMsvt(5);
			vaiTro.setVtTen("GVRaDe");
			
			int msdt = deThiService.LayMaxDeThiByTaiKhoan(taiKhoan);
			System.out.println("msdt: " + msdt);
			System.out.println("Them thanh cong");
			
			Phancongvaitro PhanCongVaiTro = new Phancongvaitro();
			PhanCongVaiTro.setVaitro(vaiTro);
			PhanCongVaiTro.setUser(user);
			PhanCongVaiTro.setDethi(DeThi);
			PhanCongVaiTro.setMscda(Integer.parseInt(mscd));
			
			phanCongVaiTroService.ThemPhanCongVaiTro(PhanCongVaiTro);
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
			DeThi.setUser(user);
			
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
	
	@RequestMapping(value = "/Thong-tin-de-thi.html")
	public ModelAndView ChuyenTrangSuaDeThi(ModelAndView model,
			HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes){
		if (isLogin(session)) {
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			int msdt = Integer.parseInt(request.getParameter("msdt"));
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			List<Monhoc> listMonHoc = monHocService.DSMonHoc();
			List<Dangthi> listDangThi = dangThiService.DSDangThi();
			List<Nienkhoa> listNienKhoa = nienKhoaService.DSNienKhoa();
			List<Chude> listChude = chuDeService.DSChuDeByTaiKhoan(taiKhoan);
			List<DethiLop> listDeThiLop = deThiLopService.listLopByMSDT(msdt);
			List<Phongthi> listPhongThi = phongThiService.danhSachPhongThi();
			List<Lop> listLop = lopService.listLop();
			List<User> listGV = userService.LayDanhSachGiaoVien();
			List<Phancongvaitro> listGTGacThi = phanCongVaiTroService.ListGTByMSDT(msdt);
			List<Phancongvaitro> listHSThamGiaThi = phanCongVaiTroService.ListHSByMSDT(msdt);
			model.addObject("sua", 1);
			model.addObject("listGTGacThi", listGTGacThi);
			model.addObject("listHSThamGiaThi", listHSThamGiaThi);
			model.addObject("listGV", listGV);
			model.addObject("listPhongThi", listPhongThi);
			model.addObject("listLop", listLop);
			model.addObject("listDeThiLop", listDeThiLop);
			model.addObject("listChude", listChude);
			model.addObject("listMonHoc", listMonHoc);
			model.addObject("listDangThi", listDangThi);
			model.addObject("listNienKhoa", listNienKhoa);
			model.addObject("DeThi", DeThi);
			model.setViewName("SuaDeThi");
		} else {
			model.setViewName("redirect:/Dang-Nhap.html");
		}
		return model;
	}
	
	@RequestMapping(value = "/AjaxXemDanhSachKQThi", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String XemDanhSachKQThi(ModelAndView model,
			HttpSession session, HttpServletRequest request){
		String result = "";
		if (isLogin(session)) {
			String msl = request.getParameter("MaLop");
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			List<User> dsThiSinh = new ArrayList<User>();
			int stt = 1;
			dsThiSinh = userService.LayDanhSachHSTrongLop(msl);
			result += " <h4 align='center' style='color: #3b5998; font-weight: bold;'>Kết quả thi lớp "+msl+"</h4>";
			result += " <div class='table-responsive'>";
			result += " 	<table class='table table-hover'>";
			result += " 		<thead>";
			result += " 			<tr>";
			result += " 				<th>STT</th>";
			result += " 				<th>Họ tên</th>";
			result += " 				<th>Điểm</th>";
			result += " 				<th>Vắng thi</th>";
			result += " 				<th>Bị khóa</th>";
			result += " 			</tr>";
			result += " 		</thead>";
			result += " 		<tbody>";
			for(User u : dsThiSinh) {
				result += " 			<tr>";
				result += " 				<td>"+stt+"</td>";
				result += " 				<td>"+u.getNdHoten()+"</td>";
				result += " 				<td><div id='DiemThi-"+u.getNdTaikhoan()+"'>0.0</div></td>";
				result += " 				<td><div id='VangThi-"+u.getNdTaikhoan()+"'><span class='glyphicon glyphicon-remove' style='color: #f0ad4e;'></span></div></td>";
				result += " 				<td><div id='BiKhoa-"+u.getNdTaikhoan()+"'></div></td>";
				result += " 			</tr>";
				stt++;
			}
			result += " 		</tbody>";
			result += " 	</table>";
			result += " </div>";
			result += "<button class='btn btn-primary pull-right' style='margin-right: 100px;'>Xuất kết quả</button>";
		}
		System.out.println(result);
		return result;
	}
	
}
