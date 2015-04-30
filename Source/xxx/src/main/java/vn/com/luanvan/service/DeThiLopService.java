package vn.com.luanvan.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import vn.com.luanvan.model.DethiLop;

public interface DeThiLopService {
	void ThemDeThiLop(DethiLop dtl);

	void SuaDeThiLop(DethiLop dtl);

	void XoaDeThiLop(DethiLop dtl);

	List<DethiLop> LayDSDeThiLop(Date ngay, int mspt);
	
	DethiLop LayDeThiLopById(int msdt, String msl);
	
	DethiLop LayDTLByPhongVaThoiGian(int mspt, String ngay, String gioBatDau, String gioKetThuc)  throws ParseException;
}
