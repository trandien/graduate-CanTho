package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.CauTraLoiDao;
import vn.com.luanvan.model.Cautraloi;

public class CauTraLoiServiceImpl implements CauTraLoiService{
	@Autowired
	CauTraLoiDao cauTraLoiDao;

	@Override
	public void ThemCauTraLoi(Cautraloi CauTraLoi) {
		cauTraLoiDao.ThemCauTraLoi(CauTraLoi);		
	}

	@Override
	public void SuaCauTraLoi(Cautraloi CauTraLoi) {
		cauTraLoiDao.SuaCauTraLoi(CauTraLoi);		
	}

	@Override
	public void XoaCauTraLoi(Cautraloi CauTraLoi) {
		cauTraLoiDao.XoaCauTraLoi(CauTraLoi);		
	}

	@Override
	public List<Cautraloi> LayDSCauTraLoi(Integer maCauHoi) {
		return cauTraLoiDao.LayDSCauTraLoi(maCauHoi);
	}

	@Override
	public Cautraloi LayCauTraLoiByMa(Integer maCauTraLoi) {
		return cauTraLoiDao.LayCauTraLoiByMa(maCauTraLoi);
	}

	@Override
	public Integer LayMaxCauTraLoi(Integer maCauHoi) {
		return cauTraLoiDao.LayMaxCauTraLoi(maCauHoi);
	}

	
}
