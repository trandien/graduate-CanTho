package vn.com.luanvan.dao;

import vn.com.luanvan.model.Dokho;

public interface DoKhoDao {
	void ThemDoKho(Dokho DoKho);

	void SuaNienKhoa(Dokho DoKho);

	void XoaDoKho(Dokho DoKho);

	Integer getMaDoKhoMax();
	
	Dokho LayDoKhoByMa(Integer maDoKho);
}
