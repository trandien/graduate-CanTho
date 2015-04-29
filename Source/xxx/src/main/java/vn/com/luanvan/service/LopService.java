package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Lop;

public interface LopService {
	void ThemLop(Lop lop);

	void SuaLop(Lop lop);

	void XoaLop(Lop lop);

	List<Lop> listLop();

	List<Lop> listLopByKhoi(Integer msk);
	
	void ThemLopVaoDeThi(Integer msdt, String msl);
	
	Lop LayLopByMa (String msl);
}
