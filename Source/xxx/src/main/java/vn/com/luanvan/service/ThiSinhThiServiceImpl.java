package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.ThiSinhThiDao;
import vn.com.luanvan.form.BangThiSinhThiForm;
import vn.com.luanvan.form.HocSinhDeThiForm;
import vn.com.luanvan.model.Thi;

public class ThiSinhThiServiceImpl implements ThiSinhThiService {
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
	public void LuuKQThiSinh(String tableName, int msch, String msctl,
			String dapAnDung, float Diem) {
		thiSinhThiDao.LuuKQThiSinh(tableName, msch, msctl, dapAnDung, Diem);
	}

	@Override
	public void SuaKQThiSinh(String tableName, int msch, String msctl, float Diem) {
		thiSinhThiDao.SuaKQThiSinh(tableName, msch, msctl, Diem);
	}

	@Override
	public boolean KTCHDaDuocChon(String tableName, int msch) {
		return thiSinhThiDao.KTCHDaDuocChon(tableName, msch);
	}

	@Override
	public String LayBangDangThi(String taiKhoan, int msch) {
		return thiSinhThiDao.LayBangDangThi(taiKhoan, msch);
	}

	@Override
	public List<Thi> listBangHocSinhDeThiForm(String taiKhoan,
			int msdt) {
		return thiSinhThiDao.listBangHocSinhDeThiForm(taiKhoan, msdt);
	}

	@Override
	public String BangHocSinhDeThiForm(String taiKhoan, int msdt,
			int soLanThi) {
		return thiSinhThiDao.BangHocSinhDeThiForm(taiKhoan, msdt, soLanThi);
	}

	@Override
	public BangThiSinhThiForm LayBangTSDTForm(String taiKhoan, int msdt,
			int soLanThi) {
		return thiSinhThiDao.LayBangTSDTForm(taiKhoan, msdt, soLanThi);
	}

	@Override
	public Thi LayBangThi(String taiKhoan, int msdt, int soLanThi) {
		return thiSinhThiDao.LayBangThi(taiKhoan, msdt, soLanThi);
	}

}
