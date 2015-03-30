package vn.com.luanvan.service;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.DoKhoDao;
import vn.com.luanvan.model.Dokho;

public class DoKhoServiceImpl implements DoKhoService{
	@Autowired
	DoKhoDao doKhodao;

	@Override
	public void ThemDoKho(Dokho DoKho) {
		doKhodao.ThemDoKho(DoKho);
		
	}

	@Override
	public void SuaNienKhoa(Dokho DoKho) {
		doKhodao.SuaNienKhoa(DoKho);
		
	}

	@Override
	public void XoaDoKho(Dokho DoKho) {
		doKhodao.XoaDoKho(DoKho);
		
	}

	@Override
	public Integer getMaDoKhoMax() {
		return doKhodao.getMaDoKhoMax();
	}

	@Override
	public Dokho LayDoKhoByMa(Integer maDoKho) {
		return doKhodao.LayDoKhoByMa(maDoKho);
	};
}
