package vn.com.luanvan.service;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.CauHoiDao;
import vn.com.luanvan.model.Cauhoi;

public class CauHoiServiceImpl implements CauHoiService {
	@Autowired
	CauHoiDao cauHoiDao;

	@Override
	public void ThemCauHoi(Cauhoi CauHoi) {
		cauHoiDao.ThemCauHoi(CauHoi);
	}

	@Override
	public void SuaCauHoi(Cauhoi CauHoi) {
		cauHoiDao.SuaCauHoi(CauHoi);
	}

	@Override
	public void XoaCauHoi(Cauhoi CauHoi) {
		cauHoiDao.XoaCauHoi(CauHoi);
	}

	@Override
	public Integer LayMaxIdCauHoi(Integer maDeThi) {
		return cauHoiDao.LayMaxIdCauHoi(maDeThi);
	}

}
