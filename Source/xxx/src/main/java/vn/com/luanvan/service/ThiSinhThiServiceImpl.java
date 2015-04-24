package vn.com.luanvan.service;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.ThiSinhThiDao;
import vn.com.luanvan.model.Thi;

public class ThiSinhThiServiceImpl implements ThiSinhThiService{
	@Autowired
	ThiSinhThiDao thiSinhThiDao;
	
	@Override
	public void CreateTableExam(String taiKhoan, int msdt, int soLanThi) {
		thiSinhThiDao.CreateTableExam(taiKhoan, msdt, soLanThi);
	}

	@Override
	public Integer KiemTraSoLanThi(String taiKhoan, int msdt) {
		return thiSinhThiDao.KiemTraSoLanThi(taiKhoan, msdt);
	}

	@Override
	public void ThemThiSinhThi(Thi thi) {
		thiSinhThiDao.ThemThiSinhThi(thi);
	}

	@Override
	public void SuaThiSinhThi(Thi thi) {
		thiSinhThiDao.SuaThiSinhThi(thi);		
	}

	@Override
	public void XoaThiSinhThi(Thi thi) {
		thiSinhThiDao.XoaThiSinhThi(thi);		
	}

	@Override
	public void LuuKQThiSinh(String tableName, int msch, int msctl) {
		thiSinhThiDao.LuuKQThiSinh(tableName, msch, msctl);		
	}

	@Override
	public void SuaKQThiSinh(String tableName, int msch, int msctl) {
		thiSinhThiDao.SuaKQThiSinh(tableName, msch, msctl);		
	}

	@Override
	public boolean KTCHDaDuocChon(String tableName, int msch) {
		return thiSinhThiDao.KTCHDaDuocChon(tableName, msch);
	}

	@Override
	public String LayBangDangThi(String taiKhoan, int msch) {
		return thiSinhThiDao.LayBangDangThi(taiKhoan, msch);
	}

}
