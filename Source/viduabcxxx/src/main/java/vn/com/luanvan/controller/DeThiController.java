package vn.com.luanvan.controller;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			String chuDe = request.getParameter("ChuDe");
			String monHoc = request.getParameter("MonHoc");
			String dangThi = request.getParameter("HeSo");
			String trangThai = request.getParameter("TrangThai");
			String thoiGianLamBai = request.getParameter("ThoiGian");
			String ngayTaoDe = request.getParameter("NgayTaoDe");
			String danDo = request.getParameter("DanDo");
			String soLanChoPhepThi = request.getParameter("SoLanChoPhep");
			String matKhauDeThi = request.getParameter("MatKhauDeThi");
			int msdt = deThiService.LayMaxDeThi() + 1;

			System.out.println("Ten De: " + tenDe);
			System.out.println("Nien Khoa: " + nienKhoa);
			System.out.println("Hoc Ky: " + hocKy);
			System.out.println("Chu De: " + chuDe);
			System.out.println("Mon Hoc: " + monHoc);
			System.out.println("Dang Thi: " + dangThi);
			System.out.println("Trang thai: " + trangThai);
			System.out.println("Thoi gian lam bai: " + thoiGianLamBai);
			System.out.println("Ngay tao de: " + ngayTaoDe);
			System.out.println("Dan do: " + danDo);
			System.out.println("So lan cho phep thi: " + soLanChoPhepThi);
			System.out.println("mat khau de thi: " + matKhauDeThi);
			
			SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("yyyy-MM-dd");
		//	String ngayCapNhat = dinhDangThoiGian.format(thoiGian.getTime());
			Date thoiGianTaoDe = dinhDangThoiGian.parse(ngayTaoDe);
		//	Date ngayCapNhat = new Date();
			
			DeThi.setMsdt(msdt);
			DeThi.setDtTende(tenDe);
			DeThi.setDtMatkhau(matKhauDeThi);
			DeThi.setDtNgaycapnhat(null);
			DeThi.setDtDando(danDo);
			DeThi.setDtNgaytaode(thoiGianTaoDe);
			DeThi.setDtSolanchophep(Integer.parseInt(soLanChoPhepThi));
			DeThi.setDtThoigianlambai(Integer.parseInt(thoiGianLamBai));
			DeThi.setDtTrangthai(Boolean.parseBoolean(trangThai));
			DeThi.setDtNguoiRaDe(taiKhoan);

			Nienkhoa NienKhoa = new Nienkhoa();
			Hocky HocKy = new Hocky(Integer.parseInt(hocKy));
			Chude ChuDe = new Chude();
			Monhoc MonHoc = new Monhoc();
			Dangthi DangThi = new Dangthi();
			Vaitro vaiTro = new Vaitro();
			vaiTro.setMsvt(5);
			vaiTro.setVtTen("GVRaDe");
			
			Phancongvaitro phanCongVaiTro = new Phancongvaitro();
			PhancongvaitroId phanCongVaiTroId = new PhancongvaitroId();
			phanCongVaiTroId.setMsdt(msdt);
			phanCongVaiTroId.setMsvt(5);
			phanCongVaiTroId.setNdTaikhoan(taiKhoan);
			
			phanCongVaiTro.setDethi(DeThi);
			phanCongVaiTro.setMscda(Integer.parseInt(chuDe));
			phanCongVaiTro.setUser(user);
			phanCongVaiTro.setVaitro(vaiTro);
			phanCongVaiTro.setId(phanCongVaiTroId);
			Set<Phancongvaitro> phancongvaitros = new HashSet<Phancongvaitro>(0);
			phancongvaitros.add(phanCongVaiTro);

		//	HocKy.setMshk(Integer.parseInt(hocKy));
			ChuDe = chuDeService.LayChuDeByMa(Integer.parseInt(chuDe));
			MonHoc = monHocService.LayMonHocByMa(Integer.parseInt(monHoc));
			NienKhoa = nienKhoaService.TimNienKhoaByMa(Integer.parseInt(nienKhoa));
			DangThi = dangThiService.TimDangThiByMa(Integer.parseInt(dangThi));
			
			DeThi.setChude(ChuDe);
			DeThi.setMonhoc(MonHoc);
			DeThi.setNienkhoa(NienKhoa);
			DeThi.setDangthi(DangThi);
			DeThi.setHocky(HocKy);
			
			DeThi.setPhancongvaitros(phancongvaitros);
			
			deThiService.ThemDeThi(DeThi);
			result +="<input type='hidden' value='"+msdt+"' id='msdt' name='msdt'>";
			result += "<div id='myElem'>";
			result += "<div class='modal-body' style='width: 50%;'>";
			result += "<div class='alert alert-success text-center'>";
			result +="<button type='button' class='close' data-dismiss='alert'";
			result +="aria-hidden='true'>&times;</button>";
			result += "Thêm đề thi thành công";
			result +="</div>";
			result +="</div>";
			result +="</div>";
			
			
			System.out.println("Them thanh cong");
			
			return result;
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
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			deThiService.XoaDeThi(DeThi);
			result = "Xoa thanh cong";
		}
		System.out.println(result);
		return result;
	}
}
