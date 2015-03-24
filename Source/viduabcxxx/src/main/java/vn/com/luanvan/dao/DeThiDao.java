package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Dethi;

public interface DeThiDao {
	void ThemDeThi(Dethi DeThi);

	void SuaDeThi(Dethi DeThi);

	void XoaDeThi(Dethi DeThi);
	
	Dethi LayDeThiByMa(Integer maDeThi);

	List<Dethi> LayDeThiByTen(String tenDeThi);

	List<Dethi> LayDeThiByNienKhoa(String tenNienKhoa);

	List<Dethi> LayDeThiByChuDe(String tenChuDe);

	List<Dethi> LayDeThiByMonHoc(String tenMonHoc);

	List<Dethi> LayDeThiByHocKy(Integer mshk);
	
	Integer LayMaxDeThi();
}
