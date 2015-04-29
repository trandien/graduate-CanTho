package vn.com.luanvan.dao;

import java.util.Date;
import java.util.List;

import vn.com.luanvan.model.DethiLop;

public interface DeThiLopDao {
	void ThemDeThiLop(DethiLop dtl);

	void SuaDeThiLop(DethiLop dtl);

	void XoaDeThiLop(DethiLop dtl);
	
	List<DethiLop> LayDSDeThiLop(Date ngay, int mspt);
	
	DethiLop LayDeThiLopById(int msdt, String msl);
}
