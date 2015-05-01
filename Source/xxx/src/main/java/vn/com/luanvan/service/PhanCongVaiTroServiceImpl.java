package vn.com.luanvan.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.PhanCongVaiTroDao;
import vn.com.luanvan.model.Phancongvaitro;
import vn.com.luanvan.model.User;

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

	@Override
	public List<Phancongvaitro> LayDeThiHS(String taiKhoan) {
		return phanCongVaiTroDao.LayDeThiHS(taiKhoan);
	}

	@Override
	public List<Phancongvaitro> LayDeThiGiamThi(String taiKhoan) {
		return phanCongVaiTroDao.LayDeThiGiamThi(taiKhoan);
	}

	@Override
	public Integer SLPCVTGiamThi(int msdt) {
		return phanCongVaiTroDao.SLPCVTGiamThi(msdt);
	}

	@Override
	public Integer SLPCVTHS(int msdt) {
		return phanCongVaiTroDao.SLPCVTHS(msdt);
	}

	@Override
	public List<Phancongvaitro> layDSHSByNgayVaPhong(int mspt, String ngay,
			String gioBatDau, String gioKetThuc) throws ParseException {
		return phanCongVaiTroDao.layDSHSByNgayVaPhong(mspt, ngay, gioBatDau, gioKetThuc) ;
	}

	@Override
	public List<Phancongvaitro> ListHSByMSDT(int msdt) {
		return phanCongVaiTroDao.ListHSByMSDT(msdt);
	}

	@Override
	public List<Phancongvaitro> ListGTByMSDT(int msdt) {
		return phanCongVaiTroDao.ListGTByMSDT(msdt);
	}

	

}
