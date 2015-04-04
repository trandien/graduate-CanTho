package vn.com.luanvan.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.luanvan.form.DeThiCauHoiForm;
import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.Cautraloi;
import vn.com.luanvan.model.Dangcauhoi;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Dokho;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.CauHoiService;
import vn.com.luanvan.service.CauTraLoiService;
import vn.com.luanvan.service.DangCauHoiService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.DoKhoService;

@Controller
public class CauHoiController {
	
	@Autowired
	CauHoiService cauHoiService;
	
	@Autowired
	CauTraLoiService cauTraLoiService;
	
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
		if (isLogin(session)) {
			Cauhoi CauHoi = new Cauhoi();
			int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
			int maDangCauHoi = Integer.parseInt(request.getParameter("MaDangCauHoi"));
			
			int maDoKho = Integer.parseInt(request.getParameter("MaDoKho"));
			String noiDungCauHoi = request.getParameter("NoiDungCauHoi");
			float diem = Float.parseFloat(request.getParameter("Diem"));
			String dapAnDung = request.getParameter("DapAnDung").trim();
			Dangcauhoi DangCauHoi = dangCauHoiService.LayDangCauHoiByMa(maDangCauHoi);
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

	@RequestMapping(value = "/AjaxLuuCauHoiVaCauTraLoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LuuCauHoiVaCauTraLoi(@RequestBody DeThiCauHoiForm tang, HttpServletRequest request) {
		String result = "";
		System.out.println("Ham AjaxLuuCauHoiVaCauTraLoi duoc goi");
		System.out.println("noidung tra loi"+tang.getNoiDungCauTraLoi().size());
		System.out.println("Diem "+tang.getDiem());
		System.out.println("msdt "+tang.getMsdt());
		int msdt = Integer.parseInt(tang.getMsdt());
		int maDangCauHoi = Integer.parseInt(tang.getMaDangCauHoi());
		int maDoKho = Integer.parseInt(tang.getMaDoKho());
		float diem = Float.parseFloat(tang.getDiem().trim());
		String noiDungCauHoi = tang.getNoiDungCauHoi().trim();
		String dapAnDung = tang.getDapAnDung().trim();
		List<String> noiDungCauTraLoi = tang.getNoiDungCauTraLoi();
		Dokho DoKho = doKhoService.LayDoKhoByMa(maDoKho);
		Dethi DeThi = deThiService.LayDeThiByMa(msdt);
		Dangcauhoi DangCauHoi = dangCauHoiService.LayDangCauHoiByMa(maDangCauHoi);
		Cauhoi CauHoi = new Cauhoi();
		CauHoi.setDangcauhoi(DangCauHoi);
		CauHoi.setDethi(DeThi);
		CauHoi.setDokho(DoKho);
		CauHoi.setChNoidungcauhoi(noiDungCauHoi);
		CauHoi.setChDiem(diem);
		CauHoi.setChDapandung(dapAnDung);
		
		
		System.out.println("Diem "+tang.getDiem());
		System.out.println("msdt "+tang.getMsdt());
		System.out.println("Noi dung cau hoi "+tang.getNoiDungCauHoi());
		System.out.println("Do kho "+tang.getMaDoKho());
		System.out.println("Ma dang cau hoi "+tang.getMaDangCauHoi());
		System.out.println("noidung tra loi: "+tang.getNoiDungCauTraLoi().size());
		
		
		for(String ctl : tang.getNoiDungCauTraLoi()) {
			System.out.println(ctl);
		}
		cauHoiService.ThemCauHoi(CauHoi);
		Cautraloi CauTraLoi = new Cautraloi();
		for(String ndctl : noiDungCauTraLoi) {
			CauTraLoi.setCtlNoidung(ndctl);
			CauTraLoi.setCauhoi(CauHoi);
			System.out.println("Cau tra loi "+CauTraLoi.getCtlNoidung());
			cauTraLoiService.ThemCauTraLoi(CauTraLoi);
		}
		
		System.out.println("-------------");
		System.out.println("Them cau hoi va thanh cong");
		return result;
	}

	
	@RequestMapping(value = "/AjaxLayMaxIdCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LayMaxIdCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		User user = (User)session.getAttribute("user");
		String taiKhoan = user.getNdTaikhoan();
		int maxIdCauHoi = cauHoiService.LayMaxIdCauHoi(taiKhoan);
		System.out.println("MaxIdCauHoi "+maxIdCauHoi);
		String maxIdCauHoiString = String.valueOf(maxIdCauHoi);
		return maxIdCauHoiString;
	}
	
	@RequestMapping(value = "/AjaxSuaCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cauhoi CauHoi = new Cauhoi();
			User user = (User)session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
			int maChuDe = Integer.parseInt(request.getParameter("MaChuDe"));
			int maCauHoi = cauHoiService.LayMaxIdCauHoi(taiKhoan);
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











