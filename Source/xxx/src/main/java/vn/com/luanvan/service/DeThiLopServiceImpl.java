package vn.com.luanvan.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.com.luanvan.dao.DeThiLopDao;
import vn.com.luanvan.model.DethiLop;

public class DeThiLopServiceImpl implements DeThiLopService{
	@Autowired
	DeThiLopDao deThiLopdao;
	
	@Override
	public void ThemDeThiLop(DethiLop dtl) {
		deThiLopdao.ThemDeThiLop(dtl);		
	}

	@Override
	public void SuaDeThiLop(DethiLop dtl) {
		deThiLopdao.SuaDeThiLop(dtl);		
	}

	@Override
	public void XoaDeThiLop(DethiLop dtl) {
		deThiLopdao.XoaDeThiLop(dtl);		
	}

	@Override
	public List<DethiLop> LayDSDeThiLop(Date ngay, int mspt) {
		return deThiLopdao.LayDSDeThiLop(ngay, mspt);
	}

	@Override
	public DethiLop LayDeThiLopById(int msdt, String msl) {
		return deThiLopdao.LayDeThiLopById(msdt, msl);
	}

}
