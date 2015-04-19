package vn.com.luanvan.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.luanvan.form.DeThiCauHoiForm;
import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.Cautraloi;
import vn.com.luanvan.model.Dangcauhoi;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Dokho;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.CauHoiService;
import vn.com.luanvan.service.CauTraLoiService;
import vn.com.luanvan.service.DangCauHoiService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.DoKhoService;

@Controller
public class CauHoiController {
	
	@Autowired
	CauHoiService cauHoiService;
	
	@Autowired
	CauTraLoiService cauTraLoiService;
	
	@Autowired
	DangCauHoiService dangCauHoiService;
	
	@Autowired
	DoKhoService doKhoService;
	
	@Autowired
	DeThiService deThiService;
	
	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}

	@RequestMapping(value = "/AjaxLuuCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			Cauhoi CauHoi = new Cauhoi();
			int maDeThi = Integer.parseInt(request.getParameter("MaDeThi"));
			int maDangCauHoi = Integer.parseInt(request.getParameter("MaDangCauHoi"));
			
			int maDoKho = Integer.parseInt(request.getParameter("MaDoKho"));
			String noiDungCauHoi = request.getParameter("NoiDungCauHoi");
			float diem = Float.parseFloat(request.getParameter("Diem"));
			String dapAnDung = request.getParameter("DapAnDung").trim();
			Dangcauhoi DangCauHoi = dangCauHoiService.LayDangCauHoiByMa(maDangCauHoi);
			Dokho DoKho = doKhoService.LayDoKhoByMa(maDoKho);
			Dethi DeThi = deThiService.LayDeThiByMa(maDeThi);
			
			CauHoi.setDangcauhoi(DangCauHoi);
			CauHoi.setDethi(DeThi);
			CauHoi.setDokho(DoKho);
			CauHoi.setChNoidungcauhoi(noiDungCauHoi);
			CauHoi.setChDiem(diem);
			CauHoi.setChDapandung(dapAnDung);
			System.out.println("Ma de thi "+maDeThi);
			cauHoiService.ThemCauHoi(CauHoi);
			System.out.println("Them cau hoi thanh cong");
			
		} else {
			System.out.println("Bạn chua dang nhap");
		}
		return result;
	}

	@RequestMapping(value = "/AjaxLuuCauHoiVaCauTraLoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LuuCauHoiVaCauTraLoi(@RequestBody DeThiCauHoiForm tang, HttpServletRequest request, HttpSession session) {
		String result = "";
		System.out.println("Ham AjaxLuuCauHoiVaCauTraLoi duoc goi");
		System.out.println("noidung tra loi"+tang.getNoiDungCauTraLoi().size());
		System.out.println("Diem "+tang.getDiem());
		System.out.println("msdt "+tang.getMsdt());
		int msdt = Integer.parseInt(tang.getMsdt());
		int maDangCauHoi = Integer.parseInt(tang.getMaDangCauHoi());
		int maDoKho = Integer.parseInt(tang.getMaDoKho());
		float diem = Float.parseFloat(tang.getDiem().trim());
		String noiDungCauHoi = tang.getNoiDungCauHoi().trim();
		String dapAnDung = tang.getDapAnDung().trim();
		List<String> noiDungCauTraLoi = tang.getNoiDungCauTraLoi();
		Dokho DoKho = doKhoService.LayDoKhoByMa(maDoKho);
		Dethi DeThi = deThiService.LayDeThiByMa(msdt);
		Dangcauhoi DangCauHoi = dangCauHoiService.LayDangCauHoiByMa(maDangCauHoi);
		Cauhoi CauHoi = new Cauhoi();
		CauHoi.setDangcauhoi(DangCauHoi);
		CauHoi.setDethi(DeThi);
		CauHoi.setDokho(DoKho);
		CauHoi.setChNoidungcauhoi(noiDungCauHoi);
		CauHoi.setChDiem(diem);
		CauHoi.setChDapandung(dapAnDung);
		cauHoiService.ThemCauHoi(CauHoi);
		Cautraloi CauTraLoi = new Cautraloi();
		for(String ndctl : noiDungCauTraLoi) {
			CauTraLoi.setCtlNoidung(ndctl);
			CauTraLoi.setCauhoi(CauHoi);
			cauTraLoiService.ThemCauTraLoi(CauTraLoi);
		}
		
		System.out.println("-------------");
		System.out.println("Them cau hoi va thanh cong");
		
		User user = (User)session.getAttribute("user");
		String taiKhoan = user.getNdTaikhoan();
		int maxIdCauHoi = cauHoiService.LayMaxIdCauHoi(taiKhoan);
		
		return String.valueOf(maxIdCauHoi);
	}

	
	@RequestMapping(value = "/AjaxLayMaxIdCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LayMaxIdCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		User user = (User)session.getAttribute("user");
		String taiKhoan = user.getNdTaikhoan();
		int maxIdCauHoi = cauHoiService.LayMaxIdCauHoi(taiKhoan);
		System.out.println("MaxIdCauHoi "+maxIdCauHoi);
		String maxIdCauHoiString = String.valueOf(maxIdCauHoi);
		return maxIdCauHoiString;
	}
	
	@RequestMapping(value = "/AjaxSuaCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			String noiDungCauHoi = request.getParameter("NoiDungCauHoi");
			float diem = Float.parseFloat(request.getParameter("Diem"));
			String dapAnDung = request.getParameter("DapAnDung");
			
			CauHoi.setChDapandung(dapAnDung);
			CauHoi.setChDiem(diem);
			CauHoi.setChNoidungcauhoi(noiDungCauHoi);
			
			cauHoiService.SuaCauHoi(CauHoi);
			System.out.println("Sua cau hoi thanh cong");
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxHienThiCauHoiThem", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String HienThiCauHoiThem(HttpServletRequest request, HttpSession session) {
		String result = "";
		Cauhoi CauHoi = new Cauhoi();
		User user = (User)session.getAttribute("user");
		String taiKhoan = user.getNdTaikhoan();
		int maCauHoi = cauHoiService.LayMaxIdCauHoi(taiKhoan);
		CauHoi = cauHoiService.LayCauHoiByMa(maCauHoi);
		
		return result;
	}
	
	@RequestMapping(value = "/AjaxXoaCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String XoaCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		try {
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			cauHoiService.XoaCauHoi(CauHoi);
			result = "Xoa cau hoi thanh cong";
		} catch(Exception e) {
			result = "Xoa cau hoi that bai";
		}
		System.out.println("Thong bao sua cau hoi: "+result);
		return result;
	}
	
	@RequestMapping(value = "/AjaxSuaDoKho", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaDoKho(HttpServletRequest request, HttpSession session) {
		String result = "";
		try{
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			int mdk = Integer.parseInt(request.getParameter("MaDoKho"));
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			Dokho DoKho = doKhoService.LayDoKhoByMa(mdk);
			CauHoi.setDokho(DoKho);
			cauHoiService.SuaCauHoi(CauHoi);
			
		} catch(Exception e) {
			System.out.println("Loi khi click do kho");
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxSuaDangCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaDangCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		try{
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			int mdch = Integer.parseInt(request.getParameter("MaDangCauHoi"));
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			System.out.println("IN IN IN "+mdch);
			Dangcauhoi DangCauHoi = dangCauHoiService.LayDangCauHoiByMa(mdch);
			CauHoi.setDangcauhoi(DangCauHoi);
			cauHoiService.SuaCauHoi(CauHoi);
			
		} catch(Exception e) {
			System.out.println("Loi khi click dang cau hoi");
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxSuaDapAnDung", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaDapAnDung(HttpServletRequest request, HttpSession session) {
		String result = "";
		try{
			int msch = Integer.parseInt(request.getParameter("MaCauHoi"));
			Cauhoi CauHoi = cauHoiService.LayCauHoiByMa(msch);
			String dapandung = request.getParameter("DapAnDung");
			CauHoi.setChDapandung(dapandung);
			cauHoiService.SuaCauHoi(CauHoi);
			
		} catch(Exception e) {
			System.out.println("Loi khi click dap an dung");
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxLaySLCauHoi", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LaySLCauHoi(HttpServletRequest request, HttpSession session) {
		String result = "";
		try{
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			int kq = cauHoiService.listCauHoi(msdt).size();
			result = String.valueOf(kq);
		} catch(Exception e) {
			System.out.println("Loi khi lay sl cau hoi");
		}
		return result;
	}
	
	@RequestMapping(value = "/AjaxLayListIdCH", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LayListIdCH(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			List<Integer> listIdCH = cauHoiService.ListIdCauHoi(msdt);
			for(int i=0; i<listIdCH.size(); i++) {
				result += String.valueOf(listIdCH.get(i)) +"-";
			}
		}
		
		System.out.println("List Id cau hoi: "+result);
		return result;
	}
	
	@RequestMapping(value = "/AjaxLayListDoKho", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String LayListDoKho(HttpServletRequest request, HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
			List<Integer> listIdCH = cauHoiService.ListDoKho(msdt);
			for(int i=0; i<listIdCH.size(); i++) {
				result += String.valueOf(listIdCH.get(i)) +"-";
			}
		}
		
		System.out.println("List do kho: "+result);
		return result;
	}
	
	@RequestMapping(value = "/Test.html", method = RequestMethod.GET)
	public ModelAndView ChuyenTrangThi(ModelAndView model, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
		
		String view = "";
		System.out.println("Test duoc goi");
		if (isLogin(session)) {
			int msdt = Integer.parseInt(request.getParameter("msdt"));
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			List<Cauhoi> listCauHoi = cauHoiService.listCauHoi(msdt);
			int sizeListCauHoi = listCauHoi.size();
			int dangCauHoi = 0;
			List<Cautraloi> listCTL = null;
			String result = "";
			 result += "<div class='form-group' style='text-align: center;'>";
		      result += "    <h1>"+DeThi.getDtTende()+"</h1>";
		      result += "    <input hidden id='finish-time' value='"+DeThi.getDtThoigianlambai()+"'/>";
		      result += "   <span>Thời gian: "+DeThi.getDtThoigianlambai()+" phút</span><br>";
		      result += "    <span>Môn: "+DeThi.getMonhoc().getMhTen()+"</span><br>";
		      result += "    <span>Lưu ý: "+DeThi.getDtDando()+"</span>";
		      result += "  </div>";
		      result += "  <hr>";
		      result += "  <div class='container'>";
		      result += "    <div class='row'>";
		      result += "       <div class='question-table'>";
		      result += "         <div id='title-question'>Câu hỏi</div>";
		      result += "         <hr>";
		      result += "        <div class='question-number'>";
		      result += "          <div class='group-question'>";
		      for(int i=1; i<=sizeListCauHoi; i++) {
		    	  result += "            <span class='question-numberx' id='question-number-"+i+"'>"+i+"</span>";
		    	  if(i%5==0) {
		    		  result += "          </div>";
				      result += "         <div class='group-question'>";
		    	  }
		    	  if(i==sizeListCauHoi) {
		    		  result += "          </div>";
		    		  result += "      </div>";
		    	  }
		      }
		      result += "      <hr>";
		      result += "      <span id='time-limit'>Thời gian còn lại: 00:15:42s</span>";
		      result += "      <hr>";
		      result += "      <button class='btn btn-primary question-btn' onclick='test()'>Nộp bài và kết thúc</button>";
		      result += "    </div>";
		      result += "    <div class='col-md-3 col-lg-3 col-xs-3'>";
		      result += "  </div>";

		      result += "  <div class='col-md-9 col-lg-9 col-xs-9'>";
		      result += "    <span id='title-content-question'>Nội dung câu hỏi</span>";
		      result += "    <hr>";
		      result += "    <div class='question'>";
		      result += "      <div class='group-question'>";
		      for(int j=1; j<=sizeListCauHoi; j++) {
		    	  dangCauHoi = 0;
		    	  listCTL = null;
		    	  result += "       <div class='content-question' >";
			      result += "         Câu "+j+": "+listCauHoi.get(j-1).getChNoidungcauhoi();
			      result += "        </div>";
			      dangCauHoi = listCauHoi.get(j-1).getDangcauhoi().getMsdch();
			      listCTL = cauTraLoiService.LayDSCauTraLoi(listCauHoi.get(j-1).getMsch());
			      String labelAnswer = "";
			  	System.out.println(listCauHoi.get(j-1).getChNoidungcauhoi());
			      if (dangCauHoi== 1) { //  Dạng câu hỏi là radio
				      for(int k=0; k<listCTL.size(); k++) {
				    	  labelAnswer = "";
				    	  char lableAnswer = (char)(k+65);
				    	  result += "        <div class='content-answer'>";
					      result += "          <div class='radio'>";
					      result += "            <label>";
					      result += "              <input type='radio' name='"+listCauHoi.get(j-1).getMsch()+"' id='"+listCTL.get(k).getMsctl()+"' value=''>";
					      result += " <div class='form-group' style='display: inline' ><p>"+lableAnswer+".&nbsp;&nbsp;</p>"+listCTL.get(k).getCtlNoidung()+"</div>";
					      result += "            </label>";
					      result += "          </div> ";     
					      result += "        </div>";
					      
					  	System.out.println(listCTL.get(k).getCtlNoidung());
				    	  }
			    	  
			      } else if (dangCauHoi== 2) { // Dạng câu hỏi là checkbox
				      for(int k=0; k<listCTL.size(); k++) {
				    	  labelAnswer = "";
				    	  char lableAnswer = (char)(k+65);
				    	  result += "        <div class='content-answer'>";
					      result += "          <div class='checkbox'>";
					      result += "            <label>";
					      result += "              <input type='checkbox' name='"+listCauHoi.get(j-1).getMsch()+"' id='"+listCTL.get(k).getMsctl()+"' value=''>";
					      result += " <div class='form-group' style='display: inline' ><p>"+lableAnswer+".&nbsp;&nbsp;</p>"+listCTL.get(k).getCtlNoidung()+"</div>";
					      result += "            </label>";
					      result += "          </div> ";     
					      result += "        </div>";
					      System.out.println(listCTL.get(k).getCtlNoidung());
				    	  }
				      }
			      else{
			    	  // Dạng câu hỏi điền vào chổ trống
			      }
			      result += "        <div class='tag' >";
			      result += "          <span class='glyphicon glyphicon-check isTag' title='Đánh dấu' id='tag-"+listCauHoi.get(j-1).getMsch()+"-"+j+"'></span>";
			      result += "        </div>";
			      result += "<hr>";
		      }
		     
		      result += "    </div>";
		      result += "  </div>";
		      result += " </div>";
		      result += " </div>";
		      result += "</div>";
		      model.addObject("load", result);
		      model.setViewName("DeThi");
		}
		else {
			model.setViewName("redirect:/Dang-Nhap.html");
		}
		return model;
	}
	
	@RequestMapping(value = "/Ket-Qua-Thi.html", method = RequestMethod.GET)
	public ModelAndView KetQuaThi(ModelAndView model, HttpServletRequest request, HttpSession session) {
	//	model.setViewName("redirect:/Lay-Code-Quen-Mat-Khau.html");
		return model;
	}
}











