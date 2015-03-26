package vn.com.luanvan.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
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

import vn.com.luanvan.dao.UserDao;
import vn.com.luanvan.dao.UserDaoImpl;
import vn.com.luanvan.form.DeThiChuDeForm;
import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.ChuDeService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.UserService;
import vn.com.luanvan.service.UserServiceImpl;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@Autowired
	ChuDeService chuDeService;
	
	@Autowired
	DeThiService deThiService;

	String useEmail;
	String useTaiKhoan;

	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}

	@RequestMapping(value = "/DangXuat")
	public ModelAndView DangXuat(ModelAndView model, HttpSession session) {
		session.invalidate();
		model.setViewName("redirect:/Dang-Nhap.html");
		return model;
	}

	@RequestMapping(value = "/")
	public ModelAndView Register(ModelAndView model) {
		model.setViewName("register");
		return model;
	}

	// ????
	@RequestMapping(value = "/Quen-Mat-Khau.html")
	public String ForgetPassword(ModelAndView model) {
		return "email-get-code";
	}

	@RequestMapping(value = "/Dang-Nhap.html")
	public String LoginPage() {
		return "login";
	}

	//Ham nay chua xong
	@RequestMapping(value = "/Thong-Tin-Ca-Nhan.html")
	public ModelAndView ThongTinCaNhan(ModelAndView model, HttpSession session) {
		if (isLogin(session)) {
			System.out.println("Trang thong tin ca nhan");
			User user = (User) session.getAttribute("user");
			model.addObject("user", user);
			model.setViewName("modify-profile");
		} else {
			model.setViewName("redirect:/Dang-Nhap.html");
		}
		return model;
	}
	
	// Hàm này chua xong
	@RequestMapping(value = "/SuaThongTin", method = RequestMethod.POST)
	public String SuaThongTin(ModelAndView model, HttpServletRequest request, HttpSession session) {
		String result = "";
		System.out.println("ham SuaThongTin duoc goi");
		User user = (User) session.getAttribute("user");
		String file = request.getParameter("file");
		user.setNdAvatar(file);
		userService.update(user);
		System.out.println(file);
		return "login";
	}

	@RequestMapping(value = "/Trang-chu.html", method = RequestMethod.GET)
	public ModelAndView HomePage(ModelAndView model, HttpSession session) {
		if (isLogin(session)) {
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			List<Chude> listChudes = chuDeService.DSChuDeByTaiKhoan(taiKhoan);
			List<Dethi> listDethis = deThiService.LayDSDeThiByTaiKhoan(taiKhoan);
			model.addObject("listDethis", listDethis);
			model.addObject("listChudes", listChudes);
			model.setViewName("main");
		} else {
			model.setViewName("redirect:/Dang-Nhap.html");
		}
		return model;
	}

	@RequestMapping(value = "/Lay-Code-Quen-Mat-Khau.html")
	public String LayCodeQuenMatKhau() {
		return "code-modifypass";
	}

	@RequestMapping(value = "/GuiCode", method = RequestMethod.POST)
	public ModelAndView GuiCode(ModelAndView model, HttpServletRequest request) {
		String loiCode = "";
		String codeRandom = userService.RanCode();
		String email = request.getParameter("email");
		System.out.println("Email code ran: " + email);
		System.out.println("Code random: " + codeRandom);
		try {
			User user = userService.getUserByEmail(email);
			if (user == null) {
				System.out.println("Email khong ton tai");

			} else {
				System.out.println("Email ton tai");
			}
			user.setCoderandom(codeRandom);
			String subject = "Quên mật khẩu";
			String text = "Mã đổi mật khẩu của bạn là: " + codeRandom;
			userService.sendMail(user.getNdEmail(), subject, text);
			userService.update(user);
			request.getSession().setAttribute("userEmail", user);
			model.setViewName("redirect:/Lay-Code-Quen-Mat-Khau.html");
			System.out.println("Gui ma code doi mat khau thanh cong");
		} catch (Exception e) {
			loiCode = "Đã xảy ra lỗi trong quá trình gửi email, vui lòng kiểm tra lại!";
			model.addObject("email", email);
			model.addObject("loiCode", loiCode);
			model.setViewName("redirect:/Quen-Mat-Khau.html");
		}
		return model;
	}

	@RequestMapping(value = "/KiemTraCode", method = RequestMethod.GET)
	public String LayCodeQuenMatKhau(RedirectAttributes redirectAttributes,
			HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("userEmail");
		String email = user.getNdEmail();
		System.out.println("Lay-code-quen " + email);
		String codeRandom = request.getParameter("codeRandom");
		String kiemTraCode = null;
		String model = "";
		if (codeRandom.equals(user.getCoderandom())) {
			model = "redirect:/Doi-Mat-Khau.html";
		} else {
			kiemTraCode = "Code đổi mật khẩu không đúng, vui lòng kiểm tra lại!";
			redirectAttributes.addFlashAttribute("kiemTraCode", kiemTraCode);
			redirectAttributes.addFlashAttribute("email", email);
			model = "redirect:/Lay-Code-Quen-Mat-Khau.html";
		}
		return model;
	}

	@RequestMapping(value = "/Doi-Mat-Khau.html")
	public String TrangDoiMatKhau() {
		return "change-password";
	}

	@RequestMapping(value = "/DoiMatKhau")
	public String DoiMatKhau(RedirectAttributes redirectattributes,
			HttpServletRequest request, HttpSession session) {
		String matKhau = request.getParameter("matKhau");
		String nhacLaiMatKhau = request.getParameter("nhacLaiMatKhau");
		String thanhCong = "";
		String thatBai = "";
		String loiCode = "";
		String model = "";
		User user = (User) session.getAttribute("userEmail");
		if (user.getCoderandom() == null || user.getCoderandom().equals("")) {
			loiCode = "Bạn chưa lấy mã code đổi mật khẩu, vui lòng kiểm tra lại!";
			redirectattributes.addFlashAttribute("loiCode", loiCode);
			return "redirect:/Doi-Mat-Khau.html";
		}
		if (matKhau.equals(nhacLaiMatKhau)) {

			user.setNdMatkhau(matKhau);
			user.setCoderandom(null);
			userService.update(user);
			thanhCong = "Đổi mật khẩu thành công";
			redirectattributes.addFlashAttribute("thanhCong", thanhCong);
			model = "redirect:/Doi-Mat-Khau.html";
		} else {
			thatBai = "Mật khẩu cũ và mới chưa khớp";
			redirectattributes.addFlashAttribute("thatBai", thatBai);
			model = "redirect:/Doi-Mat-Khau.html";
		}
		return model;
	}

	/*
	 * @RequestMapping(value = "/KiemTraCode", method = RequestMethod.GET)
	 * public ModelAndView KiemTraCode(ModelAndView model, HttpServletRequest
	 * request) { String ketQuaKiemTra = request.getParameter("email");
	 * System.out.println("KiemTraCode: "+ketQuaKiemTra); String codeRandom =
	 * request.getParameter("codeRandom"); return model; }
	 */
	@RequestMapping(value = "/AjaxCheckExistEmail", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String Check_Exist_Email(HttpServletRequest request) {
		String email = request.getParameter("Email");
		String result = "";
		if (userService.ExistEmail(email) == true) {
			result = "Email đã được sử dụng.";
			System.out.println(result);
		}
		System.out.println("Ham check_exist-email duoc thuc hien");
		return result;
	}

	@RequestMapping(value = "/AjaxCheckExistTaiKhoan", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String Check_Exist_TaiKhoan(HttpServletRequest request) {
		String taiKhoan = request.getParameter("TaiKhoan");
		String result = "";
		if (userService.findByUserName(taiKhoan) != null) {
			result = "tai khoan đã được sử dụng.";
			System.out.println(result);
		}
		return result;
	}

	@RequestMapping(value = "/AjaxDangKy", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ModelAndView dangKy(HttpServletRequest http, User user,
			ModelAndView model) {
		System.out.println("Thuc hien ham dangky");
		SecureRandom random = new SecureRandom();
		String matKhau = new BigInteger(80, random).toString(32);
		String taiKhoan = http.getParameter("TaiKhoan");
		String email = http.getParameter("Email");
		System.out.println("Tai khoan dang ky " + taiKhoan);
		System.out.println("Email dang ky " + email);
		String result = "";
		if (userService.ExistEmail(email) == false
				&& userService.findByUserName(taiKhoan) == null) {
			user.setNdTaikhoan(taiKhoan);
			user.setNdMatkhau(matKhau);
			user.setNdEmail(email);
			userService.add(user);
			userService.sendMail(email, "Tài khoản thi trắc nghiệm anki Anki",
					"Bạn đã được đăng ký thành công tài khoản Anki\n\n"
							+ "Tài khoản: " + taiKhoan + "\n" + "Mật khẩu: "
							+ matKhau);
			System.out.println("Ham send mail da duoc goi");
			result = "Đăng ký thành công. Bạn vui lòng kiểm tra email để lấy mật khẩu";
			model.addObject("result", result);
			model.setViewName("redirect:/");
		} else {
			model.setViewName("redirect:/");
		}
		return model;
	}

	@RequestMapping(value = "/XacThuc", method = RequestMethod.POST)
	public String Validate(HttpServletRequest request, HttpSession session,
			RedirectAttributes redirectAttributes) {
		String taiKhoan = request.getParameter("taiKhoan");
		String matKhau = request.getParameter("matKhau");
		System.out.println(taiKhoan);
		System.out.println(matKhau);
		User user = userService.findByUserName(taiKhoan);
		String error = null;
		if (user != null && user.getNdMatkhau().equals(matKhau)) {
			System.out.println("Tai khoan va mat khau dung");
			/*
			session.setAttribute("taiKhoan", taiKhoan);
			session.setAttribute("hoTen", user.getNdHoten());
			*/
			session.setAttribute("isLogin", true);
			request.getSession().setAttribute("user", user);
		} else {
			error = "Tài khoản hoặc mật khẩu không đúng";
			System.out.println("dang nhap that bai");
			redirectAttributes.addFlashAttribute("error", error);
			return "redirect:/Dang-Nhap.html";
		}
		return "redirect:/Trang-chu.html";
	}

}
