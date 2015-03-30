package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Cauhoi;

public interface CauHoiService {
	void ThemCauHoi(Cauhoi CauHoi);

	void SuaCauHoi(Cauhoi CauHoi);

	void XoaCauHoi(Cauhoi CauHoi);
	
	int LayMaxIdCauHoi(int maDeThi);
	
	Integer CountIdCauHoi(Integer maDeThi);
	
	List<Cauhoi> listCauHoi (Integer maDeThi);
	
	Cauhoi LayCauHoiByMa(Integer maCauHoi);
}
