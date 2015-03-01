package vn.com.luanvan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.luanvan.dao.UserDao;
import vn.com.luanvan.dao.UserDaoImpl;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.UserService;
import vn.com.luanvan.service.UserServiceImpl;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	//@Autowired
	//UserDao userDao;
	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}
	
	@RequestMapping(value = "/Dang-Xuat")
	public ModelAndView ChuyenTrangDangXuat(ModelAndView model,
			HttpSession session) {
		session.invalidate();
		model.setViewName("redirect:/Dang-Nhap.html");
		return model;
	}
	
	@RequestMapping(value = "/Dang-Nhap.html")
	public String LoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/AjaxDangKy", method = RequestMethod.POST)
	public @ResponseBody String DangKy(ModelAndView model, HttpServletRequest request) {
		String result = "";
		String email = request.getParameter("email");
		String taiKhoan = request.getParameter("taiKhoan");
		System.out.println("(DangKy-LoginController) Tai khoan dang ky: "+taiKhoan);
		System.out.println("(DangKy-LoginController) Email dang ky: "+email);
		String useEmail = "";
		String useTaiKhoan = "";
		if(userService.findByUserName(taiKhoan) != null) {
			System.out.println("(DangKy-LoginController): "+useTaiKhoan);
			useTaiKhoan = "Tài khoản đã có người sử dụng";
			
			result += useTaiKhoan;
		} else{}
		if(userService.ExistEmail(useEmail)){
			System.out.println("(DangKy-LoginController): "+useEmail);
			useEmail = "Email đã được sử dụng";
			result += useEmail;
		} else{}
		return result;
	}
	
	@RequestMapping(value = "/XacThuc", method = RequestMethod.POST)
	public ModelAndView Validate(ModelAndView model, HttpServletRequest request) {
		String taiKhoan = request.getParameter("taiKhoan");
		String matKhau = request.getParameter("matKhau");
		System.out.println(taiKhoan);
		System.out.println(matKhau);
		User user = userService.findByUserName(taiKhoan);
		String error=null;
		if(user!=null && user.getMatKhau().equals(matKhau)) {
			System.out.println("Tai khoan va mat khau dung");
		} else {
			error = "Tài khoản hoặc mật khẩu không đúng";
			System.out.println("dang nhap that bai");
			model.addObject("error", error);
			model.setViewName("login");
			System.out.println(error);
			return model;
		}
		model.addObject("taiKhoan", taiKhoan);
		model.setViewName("main");
		return model;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Register(ModelAndView model) {
		model.setViewName("register");
		return model;
	}
	/*
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String Login(ModelAndView model) {
		return "login";
	}
	*/
	@RequestMapping(value = "/forget-password.html")
	public String ForgetPassword(ModelAndView model) {
		return "forget-password";
	}
}
