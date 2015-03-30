package vn.com.luanvan.service;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.DangCauHoiDao;
import vn.com.luanvan.model.Dangcauhoi;

public class DangCauHoiServiceImpl implements DangCauHoiService{

	@Autowired
	DangCauHoiDao dangCauHoiDao;
	
	@Override
	public void ThemDangCauHoi(Dangcauhoi DangCauHoi) {
		dangCauHoiDao.ThemDangCauHoi(DangCauHoi);
	}

	@Override
	public void SuaDangCauHoi(Dangcauhoi DangCauHoi) {
		dangCauHoiDao.SuaDangCauHoi(DangCauHoi);
		
	}

	@Override
	public void XoaDangCauHoi(Dangcauhoi DangCauHoi) {
		dangCauHoiDao.XoaDangCauHoi(DangCauHoi);
		
	}

	@Override
	public Integer getMaDangCauHoiMax() {
		return dangCauHoiDao.getMaDangCauHoiMax();
	}

	@Override
	public Dangcauhoi LayDangCauHoiByMa(Integer maDangCauHoi) {
		return dangCauHoiDao.LayDangCauHoiByMa(maDangCauHoi);
	}

}
