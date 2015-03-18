package vn.com.luanvan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.ChuDeService;
import vn.com.luanvan.service.UserService;

@Controller
public class ChuDeController {
	@Autowired
	ChuDeService chuDeService;

	private boolean isLogin(HttpSession session) {
		return session.getAttribute("isLogin") != null
				&& session.getAttribute("isLogin").equals(true);
	}

	@RequestMapping(value = "/AjaxThemChuDe", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String ThemChuDe(HttpServletRequest request,
			HttpSession session) {
		String result = "";
		if (isLogin(session)) {
			String tenChuDe = request.getParameter("TenChuDe");
			String taiKhoan = request.getParameter("TaiKhoan");
			int maChuDe = chuDeService.getMaChuDeMax() + 1;
			Chude chude = new Chude();
			chude.setNdTaikhoan(taiKhoan);
			System.out.println("AjaxThemChude tai khoan la " + taiKhoan);
			chude.setCdTen(tenChuDe);
			chude.setMscd(maChuDe);
			chuDeService.ThemChuDe(chude);
			System.out.println("bat dau tao chu de moi");
			/* Tạo Thông báo tạo danh sách */
			System.out.println("Tao danh sach thanh cong");
			
			result += "<div class='list' id='list_" + chude.getMscd() + "' style='border: 1px solid #cccccc;' >";
			result += "<div class='list-header editable'>";
			result += "<div class='list-id sr-only'>" + chude.getMscd()
					+ "</div>";
			result += "<div class='list-title'> <strong>" + chude.getCdTen() + "</strong></div>";
			result += "<div class='dropdown'>";
			result += "<div class='dropdown-toggle option flaticon-sm'  id='list"
					+ chude.getMscd() + "-menu' data-toggle='dropdown'>";
			result += "					<i class='flaticon-option'></i>";
			result += "</div>";
			result += "<ul class='dropdown-menu' role='menu' aria-labelledby='list"
					+ chude.getMscd() + "-menu'>";
			result += "					<li role='presentation' style='text-align:center;'>";
			result += "					<button class='btn btn-danger btn-block' onclick='ajaxXoaDanhSach("
					+ "\"" + chude.getMscd() + "\")'>Xóa Chủ đề</button>";
			result += "					</li>";
			result += "					</ul>";
			result += "					</div>";
			result += "					</div>";
			result += "					<hr>";

			result += " <div class='form-group'>";
			result += "			<input type='button' class='form-control btn-primary' name='Them chu de' value='Thêm đề thi'>";
			result += "			</div>";
			result += "</div>";
			
			
			result += " <div class='form-group create-list'>";
			result += "			<input type='hidden' name='taiKhoanChuDe' id='taiKhoanChuDe' value='${user.ndTaikhoan}'>";
			result += "			<input type='text' class='form-control' name='tenChuDe' id='tao-tenchude' placeholder='Điền tên và bấm enter để thêm chủ đề'>";
			result += "</div>";


		} else {

		}
		return result;
	}
}
