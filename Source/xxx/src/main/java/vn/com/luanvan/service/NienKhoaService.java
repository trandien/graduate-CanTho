package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.model.Nienkhoa;

public interface NienKhoaService {
	void ThemNienKhoa(Nienkhoa NienKhoa);

	void SuaNienKhoa(Nienkhoa NienKhoa);

	void XoaNienKhoa(Nienkhoa NienKhoa);

	Nienkhoa TimNienKhoaByMa(int maNienKhoa);

	List<Nienkhoa> TimNienKhoaByTen(String tenNienKhoa);

	Integer getMaNienKhoaMax();
	
	List<Nienkhoa> DSNienKhoa();
}
