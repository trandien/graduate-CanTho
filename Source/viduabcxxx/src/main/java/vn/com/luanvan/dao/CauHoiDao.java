package vn.com.luanvan.dao;

import vn.com.luanvan.model.Cauhoi;

public interface CauHoiDao {
	void ThemCauHoi(Cauhoi CauHoi);

	void SuaCauHoi(Cauhoi CauHoi);

	void XoaCauHoi(Cauhoi CauHoi);
	
	Integer LayMaxIdCauHoi(Integer maDeThi);
}
