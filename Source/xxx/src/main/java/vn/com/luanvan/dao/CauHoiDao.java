package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Cauhoi;

public interface CauHoiDao {
	void ThemCauHoi(Cauhoi CauHoi);

	void SuaCauHoi(Cauhoi CauHoi);

	void XoaCauHoi(Cauhoi CauHoi);
	
	int LayMaxIdCauHoi(String taiKhoan);
	
	Integer CountIdCauHoi(Integer maDeThi);
	
	List<Cauhoi> listCauHoi (Integer maDeThi);
	
	Cauhoi LayCauHoiByMa(Integer maCauHoi);
}
