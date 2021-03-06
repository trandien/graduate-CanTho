package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Dethi;

public interface DeThiDao {
	void ThemDeThi(Dethi DeThi);

	void SuaDeThi(Dethi DeThi);

	void XoaDeThi(Dethi DeThi);
	
	List<Dethi> LayDSDeThiByTaiKhoan(String taiKhoan);

	List<Dethi> LayDeThiByTen(String tenDeThi);

	List<Dethi> LayDeThiByNienKhoa(String tenNienKhoa);

	List<Dethi> LayDeThiByTenChuDe(String tenChuDe);
	
	List<Dethi> LayDeThiByMaChuDe(Integer maChuDe);

	List<Dethi> LayDeThiByMonHoc(String tenMonHoc);

	List<Dethi> LayDeThiByHocKy(Integer mshk);
	
	Integer LayMaxDeThiByTaiKhoan(String taiKhoan);
	
	Integer LaySLCauHoiTrongDeThi(Integer msdt);
	
	Dethi LayDeThiByMa(Integer maDeThi);
	
}
