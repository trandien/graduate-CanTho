package vn.com.luanvan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.luanvan.model.Cauhoi;
import vn.com.luanvan.model.Cautraloi;
import vn.com.luanvan.model.Dethi;
import vn.com.luanvan.model.Phancongvaitro;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.CauHoiService;
import vn.com.luanvan.service.CauTraLoiService;
import vn.com.luanvan.service.DeThiService;
import vn.com.luanvan.service.PhanCongVaiTroService;

@Controller
public class ThiSinhThiController {

	@Autowired
	DeThiService deThiService;

	@Autowired
	PhanCongVaiTroService phanCongVaiTroService;

	@Autowired
	CauHoiService cauHoiService;

	@Autowired
	CauTraLoiService cauTraLoiService;

	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}
	
	private boolean isPermission(int msdt, String taiKhoan) {
		boolean quyenTruyCap = false;
		List<Phancongvaitro> listpcvt = phanCongVaiTroService
				.ListPhanCongVaiTro(msdt);
		for (Phancongvaitro pcvt : listpcvt) {
			if (pcvt.getUser().getNdTaikhoan().equals(taiKhoan)) {
				quyenTruyCap = true;
				break;
			}
		}
		return quyenTruyCap;
	}

	@RequestMapping(value = "/Nhap-Mat-Khau-De-Thi.html", method = RequestMethod.GET)
	public ModelAndView TrangMatKhauDeThi(ModelAndView model,
			HttpServletRequest request, HttpSession session) {
		int msdt = Integer.parseInt(request.getParameter("msdt"));
		Dethi DeThi = deThiService.LayDeThiByMa(msdt);
		User user = (User) session.getAttribute("user");
		String taiKhoan = user.getNdTaikhoan();
		if (isPermission(msdt, taiKhoan)) {
			model.addObject("DeThi", DeThi);
			model.setViewName("TrangMatKhauDeThi");
		} else {
			model.setViewName("403");
		}
		
		return model;
	}

	@RequestMapping(value = "/AjaxKiemTraMatKhauDeThi", method = RequestMethod.POST)
	public @ResponseBody String KiemTraMatKhauDeThi(ModelAndView model,
			HttpServletRequest request) {
		String matKhauDeThi = request.getParameter("MatKhauNhap");
		String result = "";
		int msdt = Integer.parseInt(request.getParameter("MaDeThi"));
		Dethi DeThi = deThiService.LayDeThiByMa(msdt);
		if (DeThi.getDtMatkhau().equals(matKhauDeThi)) {
			result = "Mat khau dung";
			System.out.println(result);
		} else {
			System.out.println("Mat khau sai");
		}

		return result;
	}


	@RequestMapping(value = "/Test.html", method = RequestMethod.GET)
	public ModelAndView ChuyenTrangThi(ModelAndView model,
			HttpServletRequest request, HttpSession session,
			RedirectAttributes redirectAttributes) {

		System.out.println("Test duoc goi");
		boolean quyenTruyCap = false;
		if (isLogin(session)) {

			int msdt = Integer.parseInt(request.getParameter("msdt"));
			Dethi DeThi = deThiService.LayDeThiByMa(msdt);
			User user = (User) session.getAttribute("user");
			String taiKhoan = user.getNdTaikhoan();
			if (isPermission(msdt, taiKhoan)) {
				List<Cauhoi> listCauHoi = cauHoiService.listCauHoi(msdt);
				int sizeListCauHoi = listCauHoi.size();
				int dangCauHoi = 0;
				List<Cautraloi> listCTL = null;
				String result = "";
				result += "<div class='form-group' style='text-align: center;'>";
				result += "    <h1>" + DeThi.getDtTende() + "</h1>";
				result += "    <input hidden id='finish-time' value='"
						+ DeThi.getDtThoigianlambai() + "'/>";
				result += "   <span>Thời gian: " + DeThi.getDtThoigianlambai()
						+ " phút</span><br>";
				result += "    <span>Môn: " + DeThi.getMonhoc().getMhTen()
						+ "</span><br>";
				result += "    <span>Lưu ý: " + DeThi.getDtDando() + "</span>";
				result += "  </div>";
				result += "  <hr>";
				result += "  <div class='container'>";
				result += "    <div class='row'>";
				result += "       <div class='question-table'>";
				result += "         <div id='title-question'>Câu hỏi</div>";
				result += "         <hr>";
				result += "        <div class='question-number'>";
				result += "          <div class='group-question'>";
				for (int i = 1; i <= sizeListCauHoi; i++) {
					result += "            <span class='question-numberx' id='question-number-"
							+ i + "'>" + i + "</span>";
					if (i % 5 == 0) {
						result += "          </div>";
						result += "         <div class='group-question'>";
					}
					if (i == sizeListCauHoi) {
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
				for (int j = 1; j <= sizeListCauHoi; j++) {
					dangCauHoi = 0;
					listCTL = null;
					result += "       <div class='content-question' >";
					result += "         Câu " + j + ": "
							+ listCauHoi.get(j - 1).getChNoidungcauhoi();
					result += "        </div>";
					dangCauHoi = listCauHoi.get(j - 1).getDangcauhoi()
							.getMsdch();
					listCTL = cauTraLoiService.LayDSCauTraLoi(listCauHoi.get(
							j - 1).getMsch());
					String labelAnswer = "";
					System.out.println(listCauHoi.get(j - 1)
							.getChNoidungcauhoi());
					if (dangCauHoi == 1) { // Dạng câu hỏi là radio
						for (int k = 0; k < listCTL.size(); k++) {
							labelAnswer = "";
							char lableAnswer = (char) (k + 65);
							result += "        <div class='content-answer'>";
							result += "          <div class='radio'>";
							result += "            <label>";
							result += "              <input type='radio' name='"
									+ listCauHoi.get(j - 1).getMsch()
									+ "' id='"
									+ listCTL.get(k).getMsctl()
									+ "' value=''>";
							result += " <div class='form-group' style='display: inline' ><p>"
									+ lableAnswer
									+ ".&nbsp;&nbsp;</p>"
									+ listCTL.get(k).getCtlNoidung() + "</div>";
							result += "            </label>";
							result += "          </div> ";
							result += "        </div>";

							System.out.println(listCTL.get(k).getCtlNoidung());
						}

					} else if (dangCauHoi == 2) { // Dạng câu hỏi là checkbox
						for (int k = 0; k < listCTL.size(); k++) {
							labelAnswer = "";
							char lableAnswer = (char) (k + 65);
							result += "        <div class='content-answer'>";
							result += "          <div class='checkbox'>";
							result += "            <label>";
							result += "              <input type='checkbox' name='"
									+ listCauHoi.get(j - 1).getMsch()
									+ "' id='"
									+ listCTL.get(k).getMsctl()
									+ "' value=''>";
							result += " <div class='form-group' style='display: inline' ><p>"
									+ lableAnswer
									+ ".&nbsp;&nbsp;</p>"
									+ listCTL.get(k).getCtlNoidung() + "</div>";
							result += "            </label>";
							result += "          </div> ";
							result += "        </div>";
							System.out.println(listCTL.get(k).getCtlNoidung());
						}
					} else {
						// Dạng câu hỏi điền vào chổ trống
					}
					result += "        <div class='tag' >";
					result += "          <span class='glyphicon glyphicon-check isTag' title='Đánh dấu' id='tag-"
							+ listCauHoi.get(j - 1).getMsch()
							+ "-"
							+ j
							+ "'></span>";
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
			} else {
				model.setViewName("403");
			}
		} else {
			model.setViewName("redirect:/Dang-Nhap.html");
		}
		return model;
	}

	@RequestMapping(value = "/Ket-Qua-Thi.html", method = RequestMethod.GET)
	public ModelAndView KetQuaThi(ModelAndView model,
			HttpServletRequest request, HttpSession session) {
		// model.setViewName("redirect:/Lay-Code-Quen-Mat-Khau.html");
		return model;
	}
}
