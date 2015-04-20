package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.LopDao;
import vn.com.luanvan.model.Lop;

public class LopServiceImpl implements LopService{
	@Autowired
	LopDao lopDao;
	
	@Override
	public void ThemLop(Lop lop) {
		lopDao.ThemLop(lop);
		
	}

	@Override
	public void SuaLop(Lop lop) {
		lopDao.SuaLop(lop);		
	}

	@Override
	public void XoaLop(Lop lop) {
		lopDao.XoaLop(lop);		
	}

	@Override
	public List<Lop> listLop() {
		return lopDao.listLop();
	}

	@Override
	public List<Lop> listLopByKhoi(Integer msk) {
		return lopDao.listLopByKhoi(msk);
	}

	@Override
	public void ThemLopVaoDeThi(Integer msdt, String msl) {
		lopDao.ThemLopVaoDeThi(msdt, msl);		
	}

}
