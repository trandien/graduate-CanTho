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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.luanvan.form.HocSinhDeThiForm;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Phancongvaitro;
import vn.com.luanvan.model.Phongthi;
import vn.com.luanvan.model.User;
import vn.com.luanvan.model.Vaitro;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.LopService;
import vn.com.luanvan.service.PhanCongVaiTroService;
import vn.com.luanvan.service.PhongThiService;
import vn.com.luanvan.service.UserService;

@Controller
public class PhanCongVaiTroController {

	@Autowired
	UserService userService;

	@Autowired
	LopService lopService;

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
			String stringTime = dinhDangThoiGian.format(thoiGian);
			SimpleDateFormat time = new SimpleDateFormat("hh:mm");
			Date timeStart = time.parse(gioBatDau);
			Date timeEnd = time.parse(gioKetThuc);
			String stringTimeStart = time.format(timeStart);
			String stringTimeEnd = time.format(timeEnd);

			PhanCongVaiTro.setUser(giamThi);
			PhanCongVaiTro.setDethi(DeThi);
			PhanCongVaiTro.setVaitro(VaiTro);
			PhanCongVaiTro.setPhongthi(PhongThi);
			PhanCongVaiTro.setMscda(mscd);
			PhanCongVaiTro.setNgay(thoiGian);
			PhanCongVaiTro.setGiobatdau(timeStart);
			PhanCongVaiTro.setGioketthuc(timeEnd);

			phanCongVaiTroService.ThemPhanCongVaiTro(PhanCongVaiTro);

			int sttPCVT = phanCongVaiTroService.SLPCVTGiamThi(msdt);

			int mspcvt = phanCongVaiTroService.getMaxIdByMaDeThi(msdt);
			result += " <tr id='pcvt-" + mspcvt + "'>";
			result += " <td class='indexGiamThi'>" + sttPCVT + "</td>";
			result += " <td>";
			result += "<div class='btn-group'>";
			result += "<div class='dropdown-toggle' data-toggle='dropdown' href='#'>";
			result += "<span class='glyphicon glyphicon-trash'></span></div>";
			result += "<div class='dropdown-menu'>";
			result += "<hr>";
			result += "<BUTTON class='btn btn-danger' style='width: 100%' onclick='AjaxXoaPhanCongVaiTro("
					+ mspcvt + ")'>";
			result += "Xóa</BUTTON>";
			result += "</div>";
			result += "</div>";
			result += " </td>";
			result += " <td title='" + giamThi.getNdTaikhoan() + "'>"
					+ giamThi.getNdHoten() + "</td>";
			result += " <td>" + PhongThi.getPtTen() + "</td>";
			result += " <td>" + stringTime + "</td>";
			result += " <td>" + stringTimeStart + "</td>";
			result += " <td>" + stringTimeEnd + "</td>";
			result += " </tr>";

		}
		return result;
	}

	@RequestMapping(value = "/AjaxXoaPhanCongVaiTro", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String XoaPhanCongVaiTro(ModelAndView model,
			HttpSession session, HttpServletRequest request)
			throws ParseException {
		String result = "";
		if (isLogin(session)) {
			int mspcvt = Integer.parseInt(request.getParameter("MSPCVT"));
			Phancongvaitro PhanCongVaiTro = phanCongVaiTroService
					.LayPhanCongVaiTroByMa(mspcvt);
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
			int msptx = 0;
			try {
				msptx = 0;
				msptx = pcvt.getPhongthi().getMspt();
			} catch(Exception e) {
				msptx = 0;			}
			 if (msptx == mspt) {
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
					System.out.println("input : " + timeStartInput + " - "
							+ timeEndInput);
					System.out.println("DB : " + timeStartDB + " - "
							+ timeEndDB);
					if ((timeStartDB > timeStartInput && timeStartDB <= timeEndInput)
							|| (timeEndDB > timeStartInput && timeEndDB <= timeEndInput)
							|| (timeStartInput > timeStartDB && timeEndInput <= timeStartDB)
							|| (timeStartInput > timeStartDB && timeEndInput <= timeStartDB)) {
						return "Thêm không thành công. Phòng thi này bị trùng lịch";
					}
				}
			} else {
				
			}

		}
		return result;
	}

	@RequestMapping(value = "/AjaxThemLopVaoDeThi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemLopVaoDeThi(ModelAndView model,
			HttpSession session, HttpServletRequest request)
			throws ParseException {
		String result = "";
		int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
		String msl = request.getParameter("MaLop");
		try {
			lopService.ThemLopVaoDeThi(msdt, msl);
			result += "<tr id='them-lop-" + msdt + "'>";
			result += "<th scope='row'>1</th>";
			result += "<td>" + msl + "</td>";
			result += "<td>";
			result += "<div class='card-delete'>";
			result += "<input class='list-item-id' value='35' type='hidden'>";
			result += "<span class='glyphicon glyphicon-trash' aria-hidden='true'></span>";
			result += "</div>";
			result += "</td>";
			result += "</tr>";
		} catch (Exception e) {
		}
		System.out.println(result);
		return result;
	}

	@RequestMapping(value = "/AjaxLoadHSTrongLop", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LoadHSTrongLop(ModelAndView model,
			HttpSession session, HttpServletRequest request)
			throws ParseException {
		String result = "";
		List<User> listHS = new ArrayList<User>();
		String msl = request.getParameter("MaLop");
		listHS = userService.LayDanhSachHSTrongLop(msl);
		for (User u : listHS) {
			result += u.getNdTaikhoan() + "-" + u.getNdHoten() + ";";
		}
		return result;
	}

	@RequestMapping(value = "/AjaxThemHSVaoDeThi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemHSVaoDeThi(HttpSession session,
			@RequestBody HocSinhDeThiForm abc) throws ParseException {
		String result = "";
		Phancongvaitro PhanCongVaiTro;
		int msdt = Integer.parseInt(abc.getMsdt());
		int mscd = Integer.parseInt(abc.getMscd());
		int mspt = Integer.parseInt(abc.getMspt());
		SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("yyyy-MM-dd");
		Date time = dinhDangThoiGian.parse(abc.getNgay());
		String stringTime = dinhDangThoiGian.format(time);
		SimpleDateFormat dinhDangtime = new SimpleDateFormat("HH:mm");
		Date timeStart = dinhDangtime.parse(abc.getGiobatdau());
		Date timeEnd = dinhDangtime.parse(abc.getGioketthuc());
		String stringTimeStart = dinhDangtime.format(timeStart);
		String stringTimeEnd = dinhDangtime.format(timeEnd);
		Vaitro VaiTro = new Vaitro();
		VaiTro.setMsvt(4);
		VaiTro.setVtTen("HocSinh");

		Phongthi PhongThi = phongThiService.LayPhongThiByMa(mspt);

		Dethi DeThi = deThiService.LayDeThiByMa(msdt);
		User user = new User();
		int sttPCVT = 0;
		int mspcvt = 0;
		for (String hs : abc.getTaiKhoan()) {
			user = userService.findByUserName(hs);
			PhanCongVaiTro = new Phancongvaitro();
			PhanCongVaiTro.setDethi(DeThi);
			PhanCongVaiTro.setVaitro(VaiTro);
			PhanCongVaiTro.setUser(user);
			PhanCongVaiTro.setMscda(mscd);
			PhanCongVaiTro.setGiobatdau(timeStart);
			PhanCongVaiTro.setGioketthuc(timeEnd);
			PhanCongVaiTro.setNgay(time);
			PhanCongVaiTro.setPhongthi(PhongThi);
			phanCongVaiTroService.ThemPhanCongVaiTro(PhanCongVaiTro);
			sttPCVT = phanCongVaiTroService.SLPCVTHS(msdt);
			mspcvt = phanCongVaiTroService.getMaxIdByMaDeThi(msdt);
			result += " <tr id='pcvths-" + mspcvt + "'>";
			result += " <td class='indexHS'>" + sttPCVT + "</td>";
			result += " <td>";
			result += "<div class='btn-group'>";
			result += "<div class='dropdown-toggle' data-toggle='dropdown' href='#'>";
			result += "<span class='glyphicon glyphicon-trash'></span></div>";
			result += "<div class='dropdown-menu'>";
			result += "<hr>";
			result += "<BUTTON class='btn btn-danger' style='width: 100%' onclick='AjaxXoaPhanCongVaiTro("
					+ mspcvt + ")'>";
			result += "Xóa</BUTTON>";
			result += "</div>";
			result += "</div>";
			result += " </td>";
			result += " <td title='" + hs + "'>" + user.getNdHoten() + "</td>";
			result += " <td>" + PhongThi.getPtTen() + "</td>";
			result += " <td>" + stringTime + "</td>";
			result += " <td>" + stringTimeStart + "</td>";
			result += " <td>" + stringTimeEnd + "</td>";
			result += " <td>" + user.getLop().getMsl() + "</td>";
			result += " </tr>";
		}

		return result;
	}


	@RequestMapping(value = "/AjaxSLPCVTGiamThi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SLPCVTGiamThi(ModelAndView model,
			HttpSession session, HttpServletRequest request) {
		String result = "";
		try {
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			int SLGiamThi = phanCongVaiTroService.SLPCVTGiamThi(msdt);
			result = String.valueOf(SLGiamThi);
		} catch(Exception e) {
			System.out.println("Ngoai le xay ra khi lay SLPCVTGiamThi");
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxSLPCVTHS", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SLPCVTHS(ModelAndView model,
			HttpSession session, HttpServletRequest request) {
		String result = "";
		try {
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			int SLGiamThi = phanCongVaiTroService.SLPCVTHS(msdt);
			result = String.valueOf(SLGiamThi);
		} catch(Exception e) {
			System.out.println("Ngoai le xay ra khi lay SLPCVTGiamThi");
		}
		return result;
	}
}
