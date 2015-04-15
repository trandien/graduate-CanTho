package vn.com.luanvan.service;

import java.util.List;

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
	public int LayMaxIdCauHoi(String taiKhoan) {
		return cauHoiDao.LayMaxIdCauHoi(taiKhoan);
	}

	@Override
	public List<Cauhoi> listCauHoi(Integer maDeThi) {
		return cauHoiDao.listCauHoi(maDeThi);
	}

	@Override
	public Cauhoi LayCauHoiByMa(Integer maCauHoi) {
		return cauHoiDao.LayCauHoiByMa(maCauHoi);
	}

	@Override
	public List<Integer> ListIdCauHoi(Integer maDeThi) {
		return cauHoiDao.ListIdCauHoi(maDeThi);
	}

	@Override
	public List<Integer> ListDoKho(Integer maDeThi) {
		return cauHoiDao.ListDoKho(maDeThi);
	}

	

}
