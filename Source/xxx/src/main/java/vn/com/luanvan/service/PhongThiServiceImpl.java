package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.PhongThiDao;
import vn.com.luanvan.model.DethiLop;
import vn.com.luanvan.model.Phongthi;

public class PhongThiServiceImpl implements PhongThiService{
	@Autowired
	PhongThiDao phongThiDao;
	
	@Override
	public void ThemPhongThi(Phongthi PhongThi) {
		phongThiDao.ThemPhongThi(PhongThi);
	}

	@Override
	public void SuaPhongThi(Phongthi PhongThi) {
		phongThiDao.SuaPhongThi(PhongThi);
	}

	@Override
	public void XoaPhongThi(Phongthi PhongThi) {
		phongThiDao.XoaPhongThi(PhongThi);
	}

	@Override
	public List<Phongthi> danhSachPhongThi() {
		return phongThiDao.danhSachPhongThi();
	}

	@Override
	public Phongthi LayPhongThiByMa(int mspt) {
		return phongThiDao.LayPhongThiByMa(mspt);
	}

}
