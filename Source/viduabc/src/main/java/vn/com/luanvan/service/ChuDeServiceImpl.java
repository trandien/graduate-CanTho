package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.ChuDeDao;
import vn.com.luanvan.model.ChuDe;

public class ChuDeServiceImpl implements ChuDeService{
	@Autowired
	ChuDeDao chuDeDao;

	@Override
	public void ThemChuDe(ChuDe chude) {
		chuDeDao.ThemChuDe(chude);
	}
	
	@Override
	public void SuaChuDe(ChuDe chude) {
		chuDeDao.SuaChuDe(chude);
	}
	
	@Override
	public void XoaChuDe(ChuDe chude) {
		chuDeDao.XoaChuDe(chude);
	}

	@Override
	public ChuDe TimChuDeByMa(int maChuDe) {
		return chuDeDao.TimChuDeByMa(maChuDe);
	}

	@Override
	public List<ChuDe> TimChuDeByTen(String tenChuDe) {
		return chuDeDao.TimChuDeByTen(tenChuDe);
	}

	@Override
	public Integer getMaChuDeMax() {
		return chuDeDao.getMaChuDeMax();
	}
}
