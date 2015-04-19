package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Phongthi;

public interface PhongThiService {
	void ThemPhongThi(Phongthi PhongThi);

	void SuaPhongThi(Phongthi PhongThi);

	void XoaPhongThi(Phongthi PhongThi);

	List<Phongthi> danhSachPhongThi();
	
	public Phongthi LayPhongThiByMa(int mspt);
}
