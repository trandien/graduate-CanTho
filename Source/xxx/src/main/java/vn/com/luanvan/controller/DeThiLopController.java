package vn.com.luanvan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.luanvan.model.Cauhoi;

@Controller
public class DeThiLopController {

	@RequestMapping(value = "/AjaxLuuDeThiLop", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LuuDeThiLop(HttpServletRequest request,
			HttpSession session) {
		String result = "";
		Cauhoi CauHoi = new Cauhoi();
		int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
		
		return result;
	}
}
