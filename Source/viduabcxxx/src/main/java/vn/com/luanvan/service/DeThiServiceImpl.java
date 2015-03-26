package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.DeThiDao;
import vn.com.luanvan.form.DeThiChuDeForm;
import vn.com.luanvan.model.Dethi;

public class DeThiServiceImpl implements DeThiService{

	@Autowired
	DeThiDao deThiDao;
	
	@Override
	public void ThemDeThi(Dethi DeThi) {
		deThiDao.ThemDeThi(DeThi);
		
	}

	@Override
	public void SuaDeThi(Dethi DeThi) {
		deThiDao.SuaDeThi(DeThi);
		
	}

	@Override
	public void XoaDeThi(Dethi DeThi) {
		deThiDao.XoaDeThi(DeThi);
	}

	@Override
	public List<Dethi> LayDeThiByTen(String tenDeThi) {
		return deThiDao.LayDeThiByTen(tenDeThi);
	}

	@Override
	public List<Dethi> LayDeThiByNienKhoa(String tenNienKhoa) {
		return deThiDao.LayDeThiByNienKhoa(tenNienKhoa);
	}

	@Override
	public List<Dethi> LayDeThiByTenChuDe(String tenChuDe) {
		return deThiDao.LayDeThiByTenChuDe(tenChuDe);
	}

	@Override
	public List<Dethi> LayDeThiByMonHoc(String tenMonHoc) {
		return deThiDao.LayDeThiByMonHoc(tenMonHoc);
	}

	@Override
	public List<Dethi> LayDeThiByHocKy(Integer mshk) {
		return deThiDao.LayDeThiByHocKy(mshk);
	}

	@Override
	public Integer LayMaxDeThi() {
		return deThiDao.LayMaxDeThi();
	}

	@Override
	public Dethi LayDeThiByMa(Integer maDeThi) {
		return deThiDao.LayDeThiByMa(maDeThi);
	}

	@Override
	public List<Dethi> LayDeThiByMaChuDe(Integer maChuDe) {
		return deThiDao.LayDeThiByMaChuDe(maChuDe);
	}

	@Override
	public List<Dethi> LayDSDeThiByTaiKhoan(String taiKhoan) {
		return deThiDao.LayDSDeThiByTaiKhoan(taiKhoan);
	}

}
