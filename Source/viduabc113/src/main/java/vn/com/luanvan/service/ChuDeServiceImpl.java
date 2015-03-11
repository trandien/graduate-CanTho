package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.ChuDeDao;
import vn.com.luanvan.model.Chude;

public class ChuDeServiceImpl implements ChuDeService{
	@Autowired
	ChuDeDao chuDeDao;

	@Override
	public void ThemChuDe(Chude chude) {
		chuDeDao.ThemChuDe(chude);
	}
	
	@Override
	public void SuaChuDe(Chude chude) {
		chuDeDao.SuaChuDe(chude);
	}
	
	@Override
	public void XoaChuDe(Chude chude) {
		chuDeDao.XoaChuDe(chude);
	}

	@Override
	public Chude TimChuDeByMa(int maChuDe) {
		return chuDeDao.TimChuDeByMa(maChuDe);
	}

	@Override
	public List<Chude> TimChuDeByTen(String tenChuDe) {
		return chuDeDao.TimChuDeByTen(tenChuDe);
	}

	@Override
	public Integer getMaChuDeMax() {
		return chuDeDao.getMaChuDeMax();
	}
}
