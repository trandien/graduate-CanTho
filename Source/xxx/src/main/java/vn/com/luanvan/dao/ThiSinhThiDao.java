package vn.com.luanvan.dao;

import vn.com.luanvan.model.Thi;

public interface ThiSinhThiDao {
	void CreateTableExam(String taiKhoan, int msdt, int soLanThi);

	Integer KiemTraSoLanThi(String taiKhoan, int msdt);

	void ThemThiSinhThi(Thi thi);

	void SuaThiSinhThi(Thi thi);

	void XoaThiSinhThi(Thi thi);
	
	void LuuKQThiSinh(String tableName, int msch, int msctl);
	
	void SuaKQThiSinh(String tableName, int msch, int msctl);
	
	boolean KTCHDaDuocChon(String tableName, int msch);
	
	String LayBangDangThi(String taiKhoan, int msch); // Trả về tên bảng thêm vô sau cùng của người thi (khắc phục lỗi load lại trang)
}
