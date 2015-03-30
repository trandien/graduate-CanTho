package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Monhoc;

public interface MonHocService {
	void ThemMonHoc(Monhoc monhoc);

	void SuaMonHoc(Monhoc monhoc);

	void XoaMonHoc(Monhoc monhoc);
	
	Monhoc LayMonHocByMa(int maMonHoc);

	List<Monhoc> DSMonHoc();
}
