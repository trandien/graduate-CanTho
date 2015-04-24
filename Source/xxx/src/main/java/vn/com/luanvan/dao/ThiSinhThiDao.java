package vn.com.luanvan.dao;

public interface ThiSinhThiDao {
	void CreateTableExam(String taiKhoan, int msdt, int soLanThi);
	Integer KiemTraSoLanThi(String taiKhoan, int msdt) ;
}
