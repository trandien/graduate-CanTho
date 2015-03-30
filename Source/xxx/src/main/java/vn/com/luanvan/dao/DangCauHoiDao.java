package vn.com.luanvan.dao;

import vn.com.luanvan.model.Dangcauhoi;

public interface DangCauHoiDao {
	void ThemDangCauHoi(Dangcauhoi DangCauHoi);

	void SuaDangCauHoi(Dangcauhoi DangCauHoi);

	void XoaDangCauHoi(Dangcauhoi DangCauHoi);

	Integer getMaDangCauHoiMax();
	
	Dangcauhoi LayDangCauHoiByMa(Integer maDangCauHoi);
}
