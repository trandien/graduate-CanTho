package vn.com.luanvan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.luanvan.model.ChuDe;
import vn.com.luanvan.service.ChuDeService;

@Controller
public class ChuDeController {

	@Autowired
	private ChuDeService chuDeService;
	
	@RequestMapping(value = "/ThemChuDe", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ModelAndView ThemChuDe(HttpServletRequest request, ModelAndView model) {
		System.out.println("Action them chu de duoc goi");
		ChuDe chude = new ChuDe();
		String tenChuDe = request.getParameter("tenChuDe");
		int mscd = chuDeService.getMaChuDeMax() + 1;
		System.out.println("ma so chu de la :"+mscd);
		System.out.println("ten chu de la :"+tenChuDe);
		chude.setCdTen(tenChuDe);
		chude.setMscd(mscd);
		chuDeService.ThemChuDe(chude);
		System.out.println("Them Thanh cong");
		String result = "";
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/TimKiem", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public ModelAndView TimKiemChuDe(HttpServletRequest request, ModelAndView model) {
		System.out.println("Action tim kiem duoc goi");
		model.setViewName("login");
		return model;
	}
}
