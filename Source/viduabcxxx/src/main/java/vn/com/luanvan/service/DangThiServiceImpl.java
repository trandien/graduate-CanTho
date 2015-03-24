package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.DangThiDao;
import vn.com.luanvan.model.Dangthi;

public class DangThiServiceImpl implements DangThiService{

	@Autowired
	DangThiDao dangThiDao;
	
	@Override
	public List<Dangthi> DSDangThi() {
		return dangThiDao.DSDangThi();
	}

	@Override
	public Dangthi TimDangThiByMa(int maDangThi) {
		return dangThiDao.TimDangThiByMa(maDangThi);
	}

}
