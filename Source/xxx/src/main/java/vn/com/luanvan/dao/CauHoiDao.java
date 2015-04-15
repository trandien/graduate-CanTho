package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Cauhoi;

public interface CauHoiDao {
	void ThemCauHoi(Cauhoi CauHoi);

	void SuaCauHoi(Cauhoi CauHoi);

	void XoaCauHoi(Cauhoi CauHoi);
	
	int LayMaxIdCauHoi(String taiKhoan);
	
	List<Cauhoi> listCauHoi (Integer maDeThi);
	
	List<Integer> ListIdCauHoi(Integer maDeThi);
	
	List<Integer> ListDoKho(Integer maDeThi);
	
	Cauhoi LayCauHoiByMa(Integer maCauHoi);
}
