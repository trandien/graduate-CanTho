package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Dethi;

public interface DeThiDao {
	void ThemDeThi(Dethi DeThi);

	void SuaDeThi(Dethi DeThi);

	void XoaDeThi(Dethi DeThi);

	List<Dethi> TimDeThiByTen(String tenDeThi);

	List<Dethi> TimDeThiByNienKhoa(String tenNienKhoa);

	List<Dethi> TimDeThiByChuDe(String tenChuDe);

	List<Dethi> TimDeThiByMonHoc(String tenMonHoc);

	List<Dethi> TimDeThiByHocKy(Integer mshk);
}
