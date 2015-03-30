package vn.com.luanvan.service;

import vn.com.luanvan.model.Dokho;

public interface DoKhoService {
	void ThemDoKho(Dokho DoKho);

	void SuaNienKhoa(Dokho DoKho);

	void XoaDoKho(Dokho DoKho);

	Integer getMaDoKhoMax();
	
	Dokho LayDoKhoByMa(Integer maDoKho);
}
