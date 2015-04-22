package vn.com.luanvan.service;

public interface ThiSinhThiService {
	void CreateTableExam(String taiKhoan, int msdt, int soLanThi);
	
	boolean KiemTraSoLanThi(String taiKhoan, int msdt, int soLanThi);
}
