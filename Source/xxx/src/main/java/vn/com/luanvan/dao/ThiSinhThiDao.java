package vn.com.luanvan.dao;

import java.util.List;

import vn.com.luanvan.model.Thi;
import vn.com.luanvan.form.BangThiSinhThiForm;

public interface ThiSinhThiDao {
	void CreateTableExam(String taiKhoan, int msdt, int soLanThi);

	Integer KiemTraSoLanThi(String taiKhoan, int msdt);

	void ThemThiSinhThi(Thi thi);

	void SuaThiSinhThi(Thi thi);

	void XoaThiSinhThi(Thi thi);
	
	void LuuKQThiSinh(String tableName, int msch, int msctl, String dapAnDung, float Diem);
	
	void SuaKQThiSinh(String tableName, int msch, int msctl, float Diem);
	
	boolean KTCHDaDuocChon(String tableName, int msch);
	
	String LayBangDangThi(String taiKhoan, int msch); // Trả về tên bảng thêm vô sau cùng của người thi (khắc phục lỗi load lại trang)
	
	void InsertDapAnDungVaoBangThiSinh(String tableName, int msch, String dapAnDung);
	
	List<Thi> listBangHocSinhDeThiForm (String taiKhoan, int msdt);
	
	Thi LayBangThi(String taiKhoan, int msdt, int soLanThi);
	
	String BangHocSinhDeThiForm (String taiKhoan, int msdt, int soLanThi);
	
	BangThiSinhThiForm LayBangTSDTForm(String taiKhoan, int msdt, int soLanThi);
	
}
