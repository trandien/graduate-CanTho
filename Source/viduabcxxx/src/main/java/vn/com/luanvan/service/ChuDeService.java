package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Chude;

public interface ChuDeService {
	void ThemChuDe(Chude chude);

	void SuaChuDe(Chude chude);

	void XoaChuDe(Chude chude);

	Chude LayChuDeByMa(int maChuDe);

	List<Chude> LayChuDeByTen(String tenChuDe);

	Integer getMaChuDeMax();
	
	List<Chude> DSChuDeByTaiKhoan(String taiKhoan);
}
