package vn.com.luanvan.service;

import vn.com.luanvan.model.Dangcauhoi;

public interface DangCauHoiService {
	void ThemDangCauHoi(Dangcauhoi DangCauHoi);

	void SuaDangCauHoi(Dangcauhoi DangCauHoi);

	void XoaDangCauHoi(Dangcauhoi DangCauHoi);

	Integer getMaDangCauHoiMax();
	
	Dangcauhoi LayDangCauHoiByMa(Integer maDangCauHoi);
}
