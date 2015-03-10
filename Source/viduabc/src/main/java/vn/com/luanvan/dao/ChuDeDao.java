package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.ChuDe;

public interface ChuDeDao {
	void ThemChuDe(ChuDe chude);

	void SuaChuDe(ChuDe chude);

	void XoaChuDe(ChuDe chude);

	ChuDe TimChuDeByMa(int maChuDe);

	List<ChuDe> TimChuDeByTen(String tenChuDe);

	Integer getMaChuDeMax();

	List<ChuDe> DSChuDe();
}
