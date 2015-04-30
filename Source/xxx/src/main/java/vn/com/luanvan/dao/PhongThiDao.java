package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.DethiLop;
import vn.com.luanvan.model.Phongthi;

public interface PhongThiDao {
	void ThemPhongThi(Phongthi PhongThi);

	void SuaPhongThi(Phongthi PhongThi);

	void XoaPhongThi(Phongthi PhongThi);

	List<Phongthi> danhSachPhongThi();
	
	Phongthi LayPhongThiByMa(int mspt);
	

}
