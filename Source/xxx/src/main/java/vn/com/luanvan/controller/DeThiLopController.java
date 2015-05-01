package vn.com.luanvan.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.DethiLop;
import vn.com.luanvan.model.DethiLopId;
import vn.com.luanvan.model.Lop;
import vn.com.luanvan.model.Phongthi;
import vn.com.luanvan.model.Thi;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.DeThiLopService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.LopService;
import vn.com.luanvan.service.PhanCongVaiTroService;
import vn.com.luanvan.service.PhongThiService;
import vn.com.luanvan.service.ThiSinhThiService;

@Controller
public class DeThiLopController {
	
	@Autowired
	ThiSinhThiService thiSinhThiService;
	
	@Autowired
	DeThiService deThiService;
	
	@Autowired
	LopService lopService;
	
	@Autowired
	PhongThiService phongThiService;
	
	@Autowired
	DeThiLopService deThiLopService;
	
	@Autowired
	PhanCongVaiTroService phanCongVaiTroService;

	@RequestMapping(value = "/AjaxLuuDeThiLop", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LuuDeThiLop(HttpServletRequest request,
			HttpSession session) throws ParseException {
		String result = "";
		int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
		String msl = request.getParameter("MaLop");
		int mspt = Integer.parseInt(request.getParameter("MaPhongThi"));
		String ngayThi = request.getParameter("NgayThi");
		String gioBatDau = request.getParameter("GioBatDau");;
		String gioKetThuc = request.getParameter("GioKetThuc");
		SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date thoiGian = dinhDangThoiGian.parse(ngayThi);
		SimpleDateFormat time = new SimpleDateFormat("hh:mm");
		Date timeStart = time.parse(gioBatDau);
		Date timeEnd = time.parse(gioKetThuc);
		Dethi DeThi = new Dethi();
		Lop lop = new Lop();
		Phongthi PhongThi = new Phongthi();
		DethiLopId DeThiLopId = new DethiLopId();
		DeThi = deThiService.LayDeThiByMa(maDeThi);
		lop = lopService.LayLopByMa(msl);
		PhongThi = phongThiService.LayPhongThiByMa(mspt);
		DeThiLopId.setMsdt(maDeThi);
		DeThiLopId.setMsl(msl);
		DethiLop DeThiLop = new DethiLop();
		DeThiLop.setDethi(DeThi);
		DeThiLop.setGiobatdau(timeStart);
		DeThiLop.setGioketthuc(timeEnd);
		DeThiLop.setId(DeThiLopId);
		DeThiLop.setMspt(mspt);
		DeThiLop.setLop(lop);
		DeThiLop.setNgay(thoiGian);
		String stringTimeStart = time.format(timeStart);
		String stringTimeEnd = time.format(timeEnd);
		String stringTime = dinhDangThoiGian.format(thoiGian);
		deThiLopService.ThemDeThiLop(DeThiLop);
		
		result += " <tr id='pcvt-" + maDeThi + "-"+msl+"'>";
		result += " <td class='indexL'></td>";
		result += " <td>";
		result += "<div class='btn-group'>";
		result += "<div class='dropdown-toggle' data-toggle='dropdown' href='#'>";
		result += "<span class='glyphicon glyphicon-trash'></span></div>";
		result += "<div class='dropdown-menu'>";
		result += "<hr>";
		result += "<BUTTON id='" + maDeThi + "-"+msl+"' class='btn btn-danger XoaDeThiLop' style='width: 100%' onclick='XoaDeThiLop()'>";
		result += "Xóa</BUTTON>";
		result += "</div>";
		result += "</div>";
		result += " </td>";
		result += " <td>"
				+ lop.getMsl() + "</td>";
		result += " <td>" + PhongThi.getPtTen() + "</td>";
		result += " <td>" + stringTime + "</td>";
		result += " <td>" + stringTimeStart + "</td>";
		result += " <td>" + stringTimeEnd + "</td>";
		result += " </tr>";
		System.out.println("Them de thi lop thanh cong");
		return result;
	}
	
	
	@RequestMapping(value = "/AjaxXoaDeThiLop", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String XoaDeThiLop(HttpServletRequest request,
			HttpSession session){
		String result="";
		try {
			System.out.println("Ajax Xoa De Thi Lop called");
			int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
			String msl = request.getParameter("MaLop");
			DethiLop DeThiLop = new DethiLop();
			DeThiLop = deThiLopService.LayDeThiLopById(maDeThi, msl);
			deThiLopService.XoaDeThiLop(DeThiLop);
			System.out.println("XoaDeThiLop thanh cong");
		} catch(Exception e) {
			System.out.println("XoaDeThiLop that bai "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxMoBaiThi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String MoBaiThi(HttpServletRequest request,
			HttpSession session){
		String result = "";
		try {
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			String taiKhoan = request.getParameter("TaiKhoan");
			Thi thi = new Thi();
			thi = thiSinhThiService.LayBangThi(taiKhoan, msdt, 1);
			thi.setTKhoabailam(false);
			thiSinhThiService.SuaThiSinhThi(thi);
		} catch(Exception e) {
			System.out.println("Ajax mo bai thi Exception "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxKhoaBaiThi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String KhoaBaiThi(HttpServletRequest request,
			HttpSession session){
		String result = "";
		try {
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			String taiKhoan = request.getParameter("TaiKhoan");
			Thi thi = new Thi();
			thi = thiSinhThiService.LayBangThi(taiKhoan, msdt, 1);
			thi.setTKhoabailam(true);
			thiSinhThiService.SuaThiSinhThi(thi);
		} catch(Exception e) {
			System.out.println("Ajax khoa bai thi Exception "+e.getMessage());
		}
		return result;
	}
}









