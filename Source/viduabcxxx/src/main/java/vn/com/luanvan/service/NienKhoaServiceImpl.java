package vn.com.luanvan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.NienKhoaDao;
import vn.com.luanvan.model.Nienkhoa;

public class NienKhoaServiceImpl implements NienKhoaService{

	@Autowired
	NienKhoaDao nienKhoaDao;
	
	@Override
	public void ThemNienKhoa(Nienkhoa NienKhoa) {
		nienKhoaDao.ThemNienKhoa(NienKhoa);
		
	}

	@Override
	public void SuaNienKhoa(Nienkhoa NienKhoa) {
		nienKhoaDao.SuaNienKhoa(NienKhoa);
		
	}

	@Override
	public void XoaNienKhoa(Nienkhoa NienKhoa) {
		nienKhoaDao.XoaNienKhoa(NienKhoa);
		
	}

	@Override
	public Nienkhoa TimNienKhoaByMa(int maNienKhoa) {
		return nienKhoaDao.TimNienKhoaByMa(maNienKhoa);
	}

	@Override
	public List<Nienkhoa> TimNienKhoaByTen(String tenNienKhoa) {
		return nienKhoaDao.TimNienKhoaByTen(tenNienKhoa);
	}

	@Override
	public Integer getMaNienKhoaMax() {
		return nienKhoaDao.getMaNienKhoaMax();
	}

	@Override
	public List<Nienkhoa> DSNienKhoa() {
		return nienKhoaDao.DSNienKhoa();
	}

}
