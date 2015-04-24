package vn.com.luanvan.controller;

import java.util.List;

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
	public @ResponseBody String LuuCauTraLoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cautraloi CauTraLoi = new Cautraloi();
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			String ctl_noidung = request.getParameter("NoiDungCTL");
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			CauTraLoi.setCauhoi(CauHoi);
			CauTraLoi.setCtlNoidung(ctl_noidung);
			
			cauTraLoiService.ThemCauTraLoi(CauTraLoi);
		}
		if(result.equals("")) {
			System.out.println("Them cau tra loi that bai");
		} else {
			System.out.println(result);
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxLayListIdCTL", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LayListIdCTL(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			List<Integer> listIdCTL = cauTraLoiService.ListIdCauTraLoi(msch);
			for(int i=0; i<listIdCTL.size(); i++) {
				result += String.valueOf(listIdCTL.get(i)) +"-";
			}
		}
		
		System.out.println("List Id cau tra loi: "+result);
		return result;
	}
	
	@RequestMapping(value = "/AjaxLayMaxIdCTL", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LayMaxIdCTL(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			Integer maxIdCTL = cauTraLoiService.LayMaxCauTraLoi(msch);
			result = String.valueOf(maxIdCTL);
		}
		System.out.println("Max Id cau tra loi: "+result);
		return result;
	}
	
	@RequestMapping(value = "/AjaxLaySoLuongCauTraLoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LaySoLuongCauTraLoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			List<Integer> listIdCTL = cauTraLoiService.ListIdCauTraLoi(msch);
			result = String.valueOf(listIdCTL.size());
		}
		
		System.out.println("So luong cau tra loi: "+result);
		return result;
	}
	
	@RequestMapping(value = "/AjaxSuaCauTraLoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaCauTraLoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cautraloi CauTraLoi = new Cautraloi();
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			int msctl = Integer.parseInt(request.getParameter("MaCauTraLoi"));
			String ctl_noidung = request.getParameter("NoiDungCTL");
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			CauTraLoi.setMsctl(msctl);
			CauTraLoi.setCauhoi(CauHoi);
			CauTraLoi.setCtlNoidung(ctl_noidung);
			cauTraLoiService.SuaCauTraLoi(CauTraLoi);
			result = "Sua cau tra loi thanh cong";
		}
		if(result.equals("")) {
			System.out.println("Sua cau tra loi that bai");
		} else {
			System.out.println(result);
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxXoaCauTraLoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String XoaCauTraLoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cautraloi CauTraLoi = new Cautraloi();
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			int msctl = Integer.parseInt(request.getParameter("MaCauTraLoi"));
			CauTraLoi = cauTraLoiService.LayCauTraLoiByMa(msctl);
			cauTraLoiService.XoaCauTraLoi(CauTraLoi);
			cauTraLoiService.ResetMaxIdCTL(msch);
			
			result = "Xoa cau tra loi thanh cong";
		}
		if(result.equals("")) {
			System.out.println("Xoa cau tra loi that bai");
		} else {
			System.out.println(result);
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxThemCauTraLoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemCauTraLoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cautraloi CauTraLoi = new Cautraloi();
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			String ctl_noidung = request.getParameter("NoiDungCTL");
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			
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
