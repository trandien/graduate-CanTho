package vn.com.luanvan.service;

import java.util.List;

import vn.com.luanvan.form.BangThiSinhThiForm;
import vn.com.luanvan.form.HocSinhDeThiForm;
import vn.com.luanvan.model.Thi;

public interface ThiSinhThiService {
	void CreateTableExam(String taiKhoan, int msdt, int soLanThi);
	
	Integer KiemTraSoLanThi(String taiKhoan, int msdt) ;
	
	void ThemThiSinhThi(Thi thi);

	void SuaThiSinhThi(Thi thi);

	void XoaThiSinhThi(Thi thi);
	
	void LuuKQThiSinh(String tableName, int msch, String msctl, String dapAnDung, float Diem);
	
	void SuaKQThiSinh(String tableName, int msch, String msctl, float Diem);
	
	boolean KTCHDaDuocChon(String tableName, int msch);
	
	String LayBangDangThi(String taiKhoan, int msch);
	
	List<Thi> listBangHocSinhDeThiForm (String taiKhoan, int msdt);
	
	Thi LayBangThi(String taiKhoan, int msdt, int soLanThi);
	
	String BangHocSinhDeThiForm (String taiKhoan, int msdt, int soLanThi);
	
	BangThiSinhThiForm LayBangTSDTForm(String taiKhoan, int msdt, int soLanThi);
	
	List<Thi> layDSDangThi(int msdt);
	
}
