package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.DeThiDao;
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
	public List<Dethi> TimDeThiByTen(String tenDeThi) {
		return deThiDao.TimDeThiByTen(tenDeThi);
	}

	@Override
	public List<Dethi> TimDeThiByNienKhoa(String tenNienKhoa) {
		return deThiDao.TimDeThiByNienKhoa(tenNienKhoa);
	}

	@Override
	public List<Dethi> TimDeThiByChuDe(String tenChuDe) {
		return deThiDao.TimDeThiByChuDe(tenChuDe);
	}

	@Override
	public List<Dethi> TimDeThiByMonHoc(String tenMonHoc) {
		return deThiDao.TimDeThiByMonHoc(tenMonHoc);
	}

	@Override
	public List<Dethi> TimDeThiByHocKy(Integer mshk) {
		return deThiDao.TimDeThiByHocKy(mshk);
	}

}
