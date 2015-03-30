package vn.com.luanvan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.luanvan.model.Cauhoi;
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

	@RequestMapping(value = "/AjaxLuuCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXx");
		if (isLogin(session)) {
			Cauhoi CauHoi = new Cauhoi();
			int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
			int maDangCauHoi = Integer.parseInt(request.getParameter("MaDangCauHoi"));
			
			int maDoKho = Integer.parseInt(request.getParameter("MaDoKho"));
			String noiDungCauHoi = request.getParameter("NoiDungCauHoi");
			float diem = Float.parseFloat(request.getParameter("Diem"));
			String dapAnDung = request.getParameter("DapAnDung").trim();
			Dangcauhoi DangCauHoi = dangCauHoiService.LayDangCauHoiByMa(maDangCauHoi);
			System.out.println("Ma dang cau hoi: "+maDangCauHoi);
			System.out.println("Ten dang cau hoi: "+DangCauHoi.getDchTen());
			Dokho DoKho = doKhoService.LayDoKhoByMa(maDoKho);
			
			Dethi DeThi = deThiService.LayDeThiByMa(maDeThi);
			
			CauHoi.setDangcauhoi(DangCauHoi);
			CauHoi.setDethi(DeThi);
			CauHoi.setDokho(DoKho);
			CauHoi.setChNoidungcauhoi(noiDungCauHoi);
			CauHoi.setChDiem(diem);
			CauHoi.setChDapandung(dapAnDung);
			System.out.println("Ma de thi "+maDeThi);
			cauHoiService.ThemCauHoi(CauHoi);
			System.out.println("Them cau hoi thanh cong");
			
		} else {
			System.out.println("Bạn chua dang nhap");
		}
		return result;
	}

	@RequestMapping(value = "/AjaxLayMaxIdCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LayMaxIdCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
		System.out.println(maDeThi);
		int maxIdCauHoi = cauHoiService.LayMaxIdCauHoi(maDeThi) + 1;
		System.out.println(maxIdCauHoi);
		String maxIdCauHoiString = String.valueOf(maxIdCauHoi);
		return maxIdCauHoiString;
	}
	
	@RequestMapping(value = "/AjaxSuaCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cauhoi CauHoi = new Cauhoi();
			int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
			int maChuDe = Integer.parseInt(request.getParameter("MaChuDe"));
			int maCauHoi = cauHoiService.LayMaxIdCauHoi(maDeThi);
			int maDangCauHoi = Integer.parseInt(request.getParameter("MaDangCauHoi"));
			System.out.println("Ma dang cau hoi: "+maDangCauHoi);
			int maDoKho = Integer.parseInt(request.getParameter("MaDoKho"));
			String noiDungCauHoi = request.getParameter("NoiDungCauHoi");
			float diem = Float.parseFloat(request.getParameter("Diem"));
			String dapAnDung = request.getParameter("DapAnDung").trim();
			Dangcauhoi DangCauHoi = dangCauHoiService.LayDangCauHoiByMa(maDangCauHoi);
			Dokho DoKho = doKhoService.LayDoKhoByMa(maDoKho);
			
			Dethi DeThi = deThiService.LayDeThiByMa(maDeThi);
			CauHoi.setMsch(maCauHoi);
			CauHoi.setDangcauhoi(DangCauHoi);
			CauHoi.setDethi(DeThi);
			CauHoi.setDokho(DoKho);
			CauHoi.setChNoidungcauhoi(noiDungCauHoi);
			CauHoi.setChDiem(diem);
			CauHoi.setChDapandung(dapAnDung);
			
			cauHoiService.SuaCauHoi(CauHoi);
			System.out.println("Sua cau hoi thanh cong");
		}
		return result;
	}
}











