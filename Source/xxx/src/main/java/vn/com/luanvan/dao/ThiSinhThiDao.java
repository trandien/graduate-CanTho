package vn.com.luanvan.dao;

public interface ThiSinhThiDao {
	void CreateTableExam(String taiKhoan, int msdt, int soLanThi);
	boolean KiemTraSoLanThi(String taiKhoan, int msdt, int soLanThi);
}
