package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Dethi;

public interface DeThiService {
	void ThemDeThi(Dethi DeThi);

	void SuaDeThi(Dethi DeThi);

	void XoaDeThi(Dethi DeThi);

	List<Dethi> TimDeThiByTen(String tenDeThi);

	List<Dethi> TimDeThiByNienKhoa(String tenNienKhoa);

	List<Dethi> TimDeThiByChuDe(String tenChuDe);

	List<Dethi> TimDeThiByMonHoc(String tenMonHoc);

	List<Dethi> TimDeThiByHocKy(Integer mshk);
}
