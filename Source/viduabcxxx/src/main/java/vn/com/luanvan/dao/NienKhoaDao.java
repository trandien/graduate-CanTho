package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Nienkhoa;

public interface NienKhoaDao {
	void ThemNienKhoa(Nienkhoa NienKhoa);

	void SuaNienKhoa(Nienkhoa NienKhoa);

	void XoaNienKhoa(Nienkhoa NienKhoa);

	Nienkhoa TimNienKhoaByMa(int maNienKhoa);

	List<Nienkhoa> TimNienKhoaByTen(String tenNienKhoa);

	Integer getMaNienKhoaMax();
	
	List<Nienkhoa> DSNienKhoa();
}
