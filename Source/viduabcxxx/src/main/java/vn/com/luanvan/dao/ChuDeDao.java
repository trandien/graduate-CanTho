package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Chude;

public interface ChuDeDao {
	void ThemChuDe(Chude chude);

	void SuaChuDe(Chude chude);

	void XoaChuDe(Chude chude);

	Chude TimChuDeByMa(int maChuDe);

	List<Chude> TimChuDeByTen(String tenChuDe);

	Integer getMaChuDeMax();

	List<Chude> DSChuDeByTaiKhoan(String taiKhoan);
}
