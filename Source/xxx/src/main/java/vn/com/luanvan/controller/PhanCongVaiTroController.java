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

import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Phancongvaitro;
import vn.com.luanvan.model.Phongthi;
import vn.com.luanvan.model.User;
import vn.com.luanvan.model.Vaitro;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.PhanCongVaiTroService;
import vn.com.luanvan.service.PhongThiService;
import vn.com.luanvan.service.UserService;

@Controller
public class PhanCongVaiTroController {
	@Autowired
	UserService userService;

	@Autowired
	DeThiService deThiService;

	@Autowired
	PhongThiService phongThiService;

	@Autowired
	PhanCongVaiTroService phanCongVaiTroService;

	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}

	@RequestMapping(value = "/AjaxThemPhanCongVaiTro", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemPhanCongVaiTro(ModelAndView model,
			HttpSession session, HttpServletRequest request)
			throws ParseException {
		String result = "";
		if (isLogin(session)) {
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			int mscd = Integer.parseInt(request.getParameter("MaChuDe"));
			int mspt = Integer.parseInt(request.getParameter("PhongThi"));
			String taiKhoanGiamThi = request.getParameter("TaiKhoanGiamThi");
			String thoiGianThi = request.getParameter("NgayThi");
			String gioBatDau = request.getParameter("GioiBatDau");
			String gioKetThuc = request.getParameter("GioiKetThuc");
			Phancongvaitro PhanCongVaiTro = new Phancongvaitro();
			User giamThi = userService.findByUserName(taiKhoanGiamThi);
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			Vaitro VaiTro = new Vaitro();
			VaiTro.setMsvt(3);
			VaiTro.setVtTen("GiamThi");

			Phongthi PhongThi = phongThiService.LayPhongThiByMa(mspt);

			SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat(
					"yyyy-MM-dd");
			Date thoiGian = dinhDangThoiGian.parse(thoiGianThi);
			SimpleDateFormat time = new SimpleDateFormat("hh:mm");
			Date timeStart = time.parse(gioBatDau);
			Date timeEnd = time.parse(gioKetThuc);

			PhanCongVaiTro.setUser(giamThi);
			PhanCongVaiTro.setDethi(DeThi);
			PhanCongVaiTro.setVaitro(VaiTro);
			PhanCongVaiTro.setMspt(mspt);
			PhanCongVaiTro.setMscda(mscd);
			PhanCongVaiTro.setNgay(thoiGian);
			PhanCongVaiTro.setGiobatdau(timeStart);
			PhanCongVaiTro.setGioketthuc(timeEnd);

			phanCongVaiTroService.ThemPhanCongVaiTro(PhanCongVaiTro);
			int mspcvt = phanCongVaiTroService.getMaxIdByMaDeThi(msdt);
			result += " <tr id='pcvt-"+mspcvt+"'>";
			result += " <td id='sttPCVT'>1</td>";
			result += " <td>";
			result += "<div class='btn-group'>";
			result += "<div class='dropdown-toggle' data-toggle='dropdown' href='#'>";
			result += "<span class='glyphicon glyphicon-trash'></span></div>";
			result += "<div class='dropdown-menu'>";
			result += "<hr>";
			result += "<BUTTON class='btn btn-danger' style='width: 100%' onclick='AjaxXoaPhanCongVaiTro("+mspcvt+")'>";
			result += "Xóa</BUTTON>";
			result += "</div>";
			result += "</div>";
			result += " </td>";
			result += " <td title='" + giamThi.getNdTaikhoan() + "'>"
					+ giamThi.getNdHoten() + "</td>";
			result += " <td>" + PhongThi.getPtTen() + "</td>";
			result += " <td>" + thoiGianThi + "</td>";
			result += " <td>" + gioBatDau + "</td>";
			result += " <td>" + gioKetThuc + "</td>";
			result += " </tr>";
			
			
		}
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "/AjaxXoaPhanCongVaiTro", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String XoaPhanCongVaiTro(ModelAndView model,
			HttpSession session, HttpServletRequest request)
			throws ParseException {
		String result = "";
		if (isLogin(session)) {
			int mspcvt = Integer.parseInt(request.getParameter("MSPCVT"));
			Phancongvaitro PhanCongVaiTro = phanCongVaiTroService.LayPhanCongVaiTroByMa(mspcvt);
			phanCongVaiTroService.XoaPhanCongVaiTro(PhanCongVaiTro);
			result = "Xoa phan cong vai tro thanh cong";
		}
		System.out.println(result);
		return result;
	}

	@RequestMapping(value = "/AjaxKiemTraPhanCongVaiTro", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String KiemTraPhanCongVaiTro(ModelAndView model,
			HttpSession session, HttpServletRequest request)
			throws ParseException {
		String result = "";
		int test = 0;
		int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
		int mspt = Integer.parseInt(request.getParameter("PhongThi"));
		String taiKhoanGiamThi = request.getParameter("TaiKhoanGiamThi");
		String thoiGianThi = request.getParameter("NgayThi");
		String gioBatDau = request.getParameter("GioBatDau");
		String gioKetThuc = request.getParameter("GioKetThuc");

		List<Phancongvaitro> listPhanCongVaiTro = phanCongVaiTroService
				.ListPhanCongVaiTro(msdt);
		for (Phancongvaitro pcvt : listPhanCongVaiTro) {
			if (pcvt.getUser().getNdTaikhoan().equals(taiKhoanGiamThi)) {
				SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat(
						"yyyy-MM-dd");
				Date thoiGian = dinhDangThoiGian.parse(thoiGianThi);
				if (thoiGian.equals(pcvt.getNgay())) {
					SimpleDateFormat dinhDangtime = new SimpleDateFormat(
							"hh:mm");
					Date timeStart = dinhDangtime.parse(gioBatDau);
					Date timeEnd = dinhDangtime.parse(gioKetThuc);

					int timeStartInput = timeStart.getHours() * 60
							+ timeStart.getMinutes();
					int timeEndInput = timeEnd.getHours() * 60
							+ timeEnd.getMinutes();
					int timeStartDB = pcvt.getGiobatdau().getHours() * 60
							+ pcvt.getGiobatdau().getMinutes();
					int timeEndDB = pcvt.getGioketthuc().getHours() * 60
							+ pcvt.getGioketthuc().getMinutes();
					
					if ((timeStartDB > timeStartInput && timeStartDB <= timeEndInput)
							|| (timeEndDB > timeStartInput && timeEndDB <= timeEndInput)
							|| (timeStartInput > timeStartDB && timeEndInput <= timeStartDB)
							|| (timeStartInput > timeStartDB && timeEndInput <= timeStartDB)) {
						return "Thêm không thành công. Giám thị này bị trùng lịch";
					}
				}
			}
			if(pcvt.getMspt() == null){}
			else if (pcvt.getMspt() == mspt) {
				SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat(
						"yyyy-MM-dd");
				Date thoiGian = dinhDangThoiGian.parse(thoiGianThi);
				if (thoiGian.equals(pcvt.getNgay())) {
					SimpleDateFormat dinhDangtime = new SimpleDateFormat(
							"hh:mm");
					Date timeStart = dinhDangtime.parse(gioBatDau);
					Date timeEnd = dinhDangtime.parse(gioKetThuc);

					int timeStartInput = timeStart.getHours() * 60
							+ timeStart.getMinutes();
					int timeEndInput = timeEnd.getHours() * 60
							+ timeEnd.getMinutes();
					int timeStartDB = pcvt.getGiobatdau().getHours() * 60
							+ pcvt.getGiobatdau().getMinutes();
					int timeEndDB = pcvt.getGioketthuc().getHours() * 60
							+ pcvt.getGioketthuc().getMinutes();
					System.out.println("input : "+timeStartInput+" - "+timeEndInput);
					System.out.println("DB : "+timeStartDB+" - "+timeEndDB);
					if ((timeStartDB > timeStartInput && timeStartDB <= timeEndInput)
							|| (timeEndDB > timeStartInput && timeEndDB <= timeEndInput)
							|| (timeStartInput > timeStartDB && timeEndInput <= timeStartDB)
							|| (timeStartInput > timeStartDB && timeEndInput <= timeStartDB)) {
						return "Thêm không thành công. Phòng thi này bị trùng lịch";
					}
				}
			}
			
		}
		return result;
	}
}
