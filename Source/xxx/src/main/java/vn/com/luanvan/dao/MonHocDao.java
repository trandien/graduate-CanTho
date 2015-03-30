package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Monhoc;

public interface MonHocDao {
	void ThemMonHoc(Monhoc chude);

	void SuaMonHoc(Monhoc chude);

	void XoaMonHoc(Monhoc chude);
	
	Monhoc LayMonHocByMa(int maMonHoc);

	List<Monhoc> DSMonHoc();
}
