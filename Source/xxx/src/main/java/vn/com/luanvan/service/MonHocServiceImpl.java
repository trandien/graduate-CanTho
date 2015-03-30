package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.MonHocDao;
import vn.com.luanvan.model.Monhoc;

public class MonHocServiceImpl implements MonHocService{
	@Autowired
	MonHocDao monHocDao;

	@Override
	public void ThemMonHoc(Monhoc monhoc) {
		monHocDao.ThemMonHoc(monhoc);
		
	}

	@Override
	public void SuaMonHoc(Monhoc monhoc) {
		monHocDao.SuaMonHoc(monhoc);		
	}

	@Override
	public void XoaMonHoc(Monhoc monhoc) {
		monHocDao.XoaMonHoc(monhoc);		
	}

	@Override
	public List<Monhoc> DSMonHoc() {
		return monHocDao.DSMonHoc();
	}

	@Override
	public Monhoc LayMonHocByMa(int maMonHoc) {
		return monHocDao.LayMonHocByMa(maMonHoc);
	}
}
