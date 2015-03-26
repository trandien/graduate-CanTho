package vn.com.luanvan.service;

import vn.com.luanvan.model.Cauhoi;

public interface CauHoiService {
	void ThemCauHoi(Cauhoi CauHoi);

	void SuaCauHoi(Cauhoi CauHoi);

	void XoaCauHoi(Cauhoi CauHoi);
	
	Integer LayMaxIdCauHoi(Integer maDeThi);
}
