package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.ChuDe;

public interface ChuDeService {
	void ThemChuDe(ChuDe chude);

	void SuaChuDe(ChuDe chude);

	void XoaChuDe(ChuDe chude);

	ChuDe TimChuDeByMa(int maChuDe);

	List<ChuDe> TimChuDeByTen(String tenChuDe);

	Integer getMaChuDeMax();
}
