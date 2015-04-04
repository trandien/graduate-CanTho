package vn.com.luanvan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.Cautraloi;
import vn.com.luanvan.service.CauHoiService;
import vn.com.luanvan.service.CauTraLoiService;

@Controller
public class CauTraLoiController {
	@Autowired
	CauTraLoiService cauTraLoiService;
	
	@Autowired
	CauHoiService cauHoiService;
	
	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}
	
	@RequestMapping(value = "/AjaxLuuCauTraLoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemCauTraLoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cautraloi CauTraLoi = new Cautraloi();
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			int msctl = cauTraLoiService.LayMaxCauTraLoi(msch)+1;
			String ctl_noidung = request.getParameter("NoiDungCTL");
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			CauTraLoi.setMsctl(msctl);
			CauTraLoi.setCauhoi(CauHoi);
			CauTraLoi.setCtlNoidung(ctl_noidung);
			
			cauTraLoiService.ThemCauTraLoi(CauTraLoi);
			result = "Them cau tra loi thanh cong";
		}
		if(result.equals("")) {
			System.out.println("Them cau tra loi that bai");
		} else {
			System.out.println(result);
		}
		return result;
	}
}
