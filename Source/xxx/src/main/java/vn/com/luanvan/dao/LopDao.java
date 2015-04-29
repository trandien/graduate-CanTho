package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Khoi;
import vn.com.luanvan.model.Lop;

public interface LopDao {
	void ThemLop(Lop lop);

	void SuaLop(Lop lop);

	void XoaLop(Lop lop);

	List<Lop> listLop();

	List<Lop> listLopByKhoi(Integer msk);
	
	void ThemLopVaoDeThi(Integer msdt, String msl);
	
	Lop LayLopByMa (String msl);
}
