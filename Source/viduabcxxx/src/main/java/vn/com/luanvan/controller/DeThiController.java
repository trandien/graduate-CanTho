package vn.com.luanvan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.luanvan.service.DeThiService;

@Controller
public class DeThiController {

	@Autowired
	DeThiService deThiService;
	
	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}

	@RequestMapping(value = "/De-Thi.html")
	public String TrangDeThi(ModelAndView model, HttpSession session) {
		if(isLogin(session)){
			return "ThemDeThi";
		} else {
			return "redirect:/Dang-Nhap.html";
		}
	}
	
	@RequestMapping(value = "/AjaxTaoDeThi")
	public String TaoDeThi(ModelAndView model, HttpSession session, HttpServletRequest request) {
		if(isLogin(session)){
			return "ThemDeThi";
		} else {
			return "redirect:/Dang-Nhap.html";
		}
	}
}
