package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Dethi;

public interface DeThiService {
	void ThemDeThi(Dethi DeThi);

	void SuaDeThi(Dethi DeThi);

	void XoaDeThi(Dethi DeThi);

	List<Dethi> LayDeThiByTen(String tenDeThi);

	List<Dethi> LayDeThiByNienKhoa(String tenNienKhoa);

	List<Dethi> LayDeThiByChuDe(String tenChuDe);

	List<Dethi> LayDeThiByMonHoc(String tenMonHoc);

	List<Dethi> LayDeThiByHocKy(Integer mshk);
	
	Integer LayMaxDeThi();
	
	Dethi LayDeThiByMa(Integer maDeThi);
}
