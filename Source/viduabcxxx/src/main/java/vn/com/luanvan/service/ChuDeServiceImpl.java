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
	public Chude LayChuDeByMa(int maChuDe) {
		return chuDeDao.LayChuDeByMa(maChuDe);
	}

	@Override
	public List<Chude> LayChuDeByTen(String tenChuDe) {
		return chuDeDao.LayChuDeByTen(tenChuDe);
	}

	@Override
	public Integer getMaChuDeMax() {
		return chuDeDao.getMaChuDeMax();
	}

	@Override
	public List<Chude> DSChuDeByTaiKhoan(String taiKhoan) {
		return chuDeDao.DSChuDeByTaiKhoan(taiKhoan);
	}
}
