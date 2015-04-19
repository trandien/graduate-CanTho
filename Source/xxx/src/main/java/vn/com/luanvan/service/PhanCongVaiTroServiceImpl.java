package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.PhanCongVaiTroDao;
import vn.com.luanvan.model.Phancongvaitro;

public class PhanCongVaiTroServiceImpl implements PhanCongVaiTroService{
	@Autowired
	PhanCongVaiTroDao phanCongVaiTroDao;
	
	@Override
	public void ThemPhanCongVaiTro(Phancongvaitro phancongvaitro) {
		phanCongVaiTroDao.ThemPhanCongVaiTro(phancongvaitro);
	}

	@Override
	public void SuaPhanCongVaiTro(Phancongvaitro phancongvaitro) {
		phanCongVaiTroDao.SuaPhanCongVaiTro(phancongvaitro);
	}

	@Override
	public void XoaPhanCongVaiTro(Phancongvaitro phancongvaitro) {
		phanCongVaiTroDao.XoaPhanCongVaiTro(phancongvaitro);
	}

	@Override
	public List<Phancongvaitro> ListPhanCongVaiTro(Integer msdt) {
		return phanCongVaiTroDao.ListPhanCongVaiTro(msdt);
	}

	@Override
	public Boolean KiemTraTonTaiPhanCongVaiTro(Integer msdt, String taiKhoan,
			Integer msvt, Integer mscd) {
		return phanCongVaiTroDao.KiemTraTonTaiPhanCongVaiTro(msdt, taiKhoan, msvt, mscd);
	}

	@Override
	public Integer getMaxIdByMaDeThi(Integer msdt) {
		return phanCongVaiTroDao.getMaxIdByMaDeThi(msdt);
	}

	@Override
	public Phancongvaitro LayPhanCongVaiTroByMa(Integer mspcvt) {
		return phanCongVaiTroDao.LayPhanCongVaiTroByMa(mspcvt);
	}

}
