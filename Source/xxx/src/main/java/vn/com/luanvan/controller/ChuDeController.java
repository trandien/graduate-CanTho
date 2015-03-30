package vn.com.luanvan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.luanvan.model.Chude;
import vn.com.luanvan.model.User;
import vn.com.luanvan.service.ChuDeService;
import vn.com.luanvan.service.UserService;

@Controller
public class ChuDeController {
	@Autowired
	ChuDeService chuDeService;
	
	@Autowired
	UserService userService;

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
			System.out.println("Tao chu de thanh cong "+maChuDe);
			
			result += "<div class='list' id='chude_" + chude.getMscd() + "' style='border: 1px solid #cccccc;'  >";
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
			result += "					<button class='btn btn-danger btn-block' onclick='AjaxXoaChuDe("
					+ "\"" + chude.getMscd() + "\")'>Xóa Chủ đề</button>";
			result += "					</li>";
			result += "					</ul>";
			result += "					</div>";
			result += "					</div>";
			result += "					<hr>";

			result += " <div class='form-group'>";
			result += "<a href='De-Thi.html?mscd="+chude.getMscd()+"'>";
			result += "			<button class='form-control btn-primary' name='Them chu de'>Thêm đề thi</button>";
			result += "</a>";
			result += "</div>";
			
			result += "</div>";
			
			result += " <div class='form-group create-list'>";
			result += "			<input type='hidden' name='taiKhoanChuDe' id='taiKhoanChuDe' value='${user.ndTaikhoan}'>";
			result += "			<input type='text' class='form-control' name='tenChuDe' id='tao-tenchude' placeholder='Điền tên và bấm enter để thêm chủ đề'>";
			result += "</div>";
		} else {

		}
		return result;
	}
	
	@RequestMapping(value = "/AutocompleteLoadGiaoVien", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody List<String> LoadGiaoVien(@RequestParam ("term") String tenGV) {
		String ketQua = null;
		tenGV = tenGV.toLowerCase();
		System.out.println("AutocompleteLoadGiaoVien");
		System.out.println("Ten gv "+tenGV);
		List<String> listGV = userService.LayDanhSachGiaoVien();
		List<String> DSGV = new ArrayList<String>();
		for (int i =0; i<listGV.size(); i++) {
			ketQua = listGV.get(i).toLowerCase();
			if(ketQua.startsWith(tenGV)) {
				DSGV.add(listGV.get(i));
				try {
					System.out.println("Ket qua "+DSGV.get(i));
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return DSGV;
	}
	/*
	@RequestMapping(value = "/AutocompleteLoadHocSinh", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody List<User> LoadHocSinh() {
		List<User> listHS = userService.LayDanhSachHocSinh();
		return listHS;
	}
	*/
	
	@RequestMapping(value = "/AjaxXoaChuDe", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String XoaChuDe(HttpServletRequest request, HttpSession session) {
		String result="";
		if (isLogin(session)) {
			int mscd = Integer.parseInt(request.getParameter("MaChuDe"));
			System.out.println("ma so chu de: "+mscd);
			Chude ChuDe = chuDeService.LayChuDeByMa(mscd);
			chuDeService.XoaChuDe(ChuDe);
			result = "Xoa chu de thanh cong";
		}
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "/AjaxSuaChuDe", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String SuaChuDe(HttpServletRequest request, HttpSession session) {
		String tenChuDe = request.getParameter("TenChuDe");
		if (isLogin(session)) {
			int mscd = Integer.parseInt(request.getParameter("MaChuDe"));
			System.out.println("Ten chu de: "+tenChuDe);
			Chude ChuDe = chuDeService.LayChuDeByMa(mscd);
			ChuDe.setCdTen(tenChuDe);
			chuDeService.SuaChuDe(ChuDe);
		}
		System.out.println("Sua chu de thanh cong");
		return tenChuDe;
	}
}
