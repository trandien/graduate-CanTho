package vn.com.luanvan.service;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.ThiSinhThiDao;

public class ThiSinhThiServiceImpl implements ThiSinhThiService{
	@Autowired
	ThiSinhThiDao thiSinhThiDao;
	
	@Override
	public void CreateTableExam(String taiKhoan, int msdt, int soLanThi) {
		thiSinhThiDao.CreateTableExam(taiKhoan, msdt, soLanThi);
	}

	@Override
	public boolean KiemTraSoLanThi(String taiKhoan, int msdt, int soLanThi) {
		return thiSinhThiDao.KiemTraSoLanThi(taiKhoan, msdt, soLanThi);
	}

}
